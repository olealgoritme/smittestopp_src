package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionState;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStateCallback;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeReason;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.DeviceClientException;
import com.microsoft.azure.sdk.iot.device.exceptions.DeviceOperationTimeoutException;
import com.microsoft.azure.sdk.iot.device.exceptions.IotHubServiceException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.exceptions.UnauthorizedException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsIotHubConnection;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionThrottledException;
import com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpUnauthorizedAccessException;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsIotHubConnection;
import com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttIotHubConnection;
import com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttUnauthorizedException;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l.f.b;
import l.f.c;

public class IotHubTransport
  implements IotHubListener
{
  public static final int MAX_MESSAGES_TO_SEND_PER_THREAD = 10;
  public static final int POOL_SIZE = 1;
  public static final b log = c.a(IotHubTransport.class);
  public final Queue<IotHubTransportPacket> callbackPacketsQueue = new ConcurrentLinkedQueue();
  public volatile IotHubConnectionStatus connectionStatus;
  public IotHubConnectionStatusChangeCallback connectionStatusChangeCallback;
  public Object connectionStatusChangeCallbackContext;
  public int currentReconnectionAttempt;
  public DeviceClientConfig defaultConfig;
  public Queue<DeviceClientConfig> deviceClientConfigs;
  public final Object inProgressMessagesLock = new Object();
  public final Map<String, IotHubTransportPacket> inProgressPackets = new ConcurrentHashMap();
  public IotHubTransportConnection iotHubTransportConnection;
  public final Queue<IotHubTransportMessage> receivedMessagesQueue = new ConcurrentLinkedQueue();
  public long reconnectionAttemptStartTimeMillis;
  public final Object reconnectionLock = new Object();
  public ScheduledExecutorService scheduledExecutorService;
  public IotHubConnectionStateCallback stateCallback;
  public Object stateCallbackContext;
  public ScheduledExecutorService taskScheduler;
  public final Queue<IotHubTransportPacket> waitingPacketsQueue = new ConcurrentLinkedQueue();
  
  public IotHubTransport(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      defaultConfig = paramDeviceClientConfig;
      connectionStatus = IotHubConnectionStatus.DISCONNECTED;
      currentReconnectionAttempt = 0;
      return;
    }
    throw new IllegalArgumentException("Config cannot be null");
  }
  
  private void acknowledgeReceivedMessage(IotHubTransportMessage paramIotHubTransportMessage)
  {
    MessageCallback localMessageCallback = paramIotHubTransportMessage.getMessageCallback();
    Object localObject = paramIotHubTransportMessage.getMessageCallbackContext();
    if (localMessageCallback != null)
    {
      log.e("Executing callback for received message ({})", paramIotHubTransportMessage);
      localObject = localMessageCallback.execute(paramIotHubTransportMessage, localObject);
      try
      {
        log.e("Sending acknowledgement for received cloud to device message ({})", paramIotHubTransportMessage);
        iotHubTransportConnection.sendMessageResult(paramIotHubTransportMessage, (IotHubMessageResult)localObject);
      }
      catch (TransportException localTransportException)
      {
        log.d("Sending acknowledgement for received cloud to device message failed, adding it back to the queue ({})", paramIotHubTransportMessage, localTransportException);
        receivedMessagesQueue.add(paramIotHubTransportMessage);
        throw localTransportException;
      }
    }
  }
  
  private void addReceivedMessagesOverHttpToReceivedQueue()
  {
    IotHubTransportMessage localIotHubTransportMessage = ((HttpsIotHubConnection)iotHubTransportConnection).receiveMessage();
    if (localIotHubTransportMessage != null)
    {
      log.b("Message was received from IotHub ({})", localIotHubTransportMessage);
      receivedMessagesQueue.add(localIotHubTransportMessage);
    }
  }
  
  private void addToCallbackQueue(IotHubTransportPacket paramIotHubTransportPacket)
  {
    if (paramIotHubTransportPacket.getCallback() != null) {
      callbackPacketsQueue.add(paramIotHubTransportPacket);
    }
  }
  
  private void cancelPendingPackets()
  {
    for (??? = (IotHubTransportPacket)waitingPacketsQueue.poll(); ??? != null; ??? = (IotHubTransportPacket)waitingPacketsQueue.poll())
    {
      ((IotHubTransportPacket)???).setStatus(IotHubStatusCode.MESSAGE_CANCELLED_ONCLOSE);
      addToCallbackQueue((IotHubTransportPacket)???);
    }
    synchronized (inProgressMessagesLock)
    {
      Iterator localIterator = inProgressPackets.entrySet().iterator();
      while (localIterator.hasNext())
      {
        IotHubTransportPacket localIotHubTransportPacket = (IotHubTransportPacket)((Map.Entry)localIterator.next()).getValue();
        localIotHubTransportPacket.setStatus(IotHubStatusCode.MESSAGE_CANCELLED_ONCLOSE);
        addToCallbackQueue(localIotHubTransportPacket);
      }
      inProgressPackets.clear();
      return;
    }
  }
  
  private void checkForExpiredMessages()
  {
    ??? = (IotHubTransportPacket)waitingPacketsQueue.poll();
    Object localObject2 = new LinkedBlockingQueue();
    while (??? != null)
    {
      if (((IotHubTransportPacket)???).getMessage().isExpired())
      {
        ((IotHubTransportPacket)???).setStatus(IotHubStatusCode.MESSAGE_EXPIRED);
        addToCallbackQueue((IotHubTransportPacket)???);
      }
      else
      {
        ((AbstractQueue)localObject2).add(???);
      }
      ??? = (IotHubTransportPacket)waitingPacketsQueue.poll();
    }
    waitingPacketsQueue.addAll((Collection)localObject2);
    synchronized (inProgressMessagesLock)
    {
      localObject2 = new java/util/ArrayList;
      ((ArrayList)localObject2).<init>();
      Object localObject4 = inProgressPackets.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if (((IotHubTransportPacket)inProgressPackets.get(str)).getMessage().isExpired()) {
          ((ArrayList)localObject2).add(str);
        }
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject4 = (IotHubTransportPacket)inProgressPackets.remove(localObject4);
        ((IotHubTransportPacket)localObject4).setStatus(IotHubStatusCode.MESSAGE_EXPIRED);
        addToCallbackQueue((IotHubTransportPacket)localObject4);
      }
      return;
    }
  }
  
  private void checkForUnauthorizedException(TransportException paramTransportException)
  {
    if ((!isSasTokenExpired()) && (((paramTransportException instanceof MqttUnauthorizedException)) || ((paramTransportException instanceof UnauthorizedException)) || ((paramTransportException instanceof AmqpUnauthorizedAccessException)))) {
      paramTransportException.setRetryable(true);
    }
  }
  
  private IotHubConnectionStatusChangeReason exceptionToStatusChangeReason(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof TransportException))
    {
      if (((TransportException)paramThrowable).isRetryable())
      {
        log.d("Mapping throwable to NO_NETWORK because it was a retryable exception", paramThrowable);
        return IotHubConnectionStatusChangeReason.NO_NETWORK;
      }
      if (isSasTokenExpired())
      {
        log.d("Mapping throwable to EXPIRED_SAS_TOKEN because it was a non-retryable exception and the saved sas token has expired", paramThrowable);
        return IotHubConnectionStatusChangeReason.EXPIRED_SAS_TOKEN;
      }
      if (((paramThrowable instanceof UnauthorizedException)) || ((paramThrowable instanceof MqttUnauthorizedException)) || ((paramThrowable instanceof AmqpUnauthorizedAccessException)))
      {
        log.d("Mapping throwable to BAD_CREDENTIAL because it was a non-retryable exception authorization exception but the saved sas token has not expired yet", paramThrowable);
        return IotHubConnectionStatusChangeReason.BAD_CREDENTIAL;
      }
    }
    log.d("Mapping exception throwable to COMMUNICATION_ERROR because the sdk was unable to classify the thrown exception to anything other category", paramThrowable);
    return IotHubConnectionStatusChangeReason.COMMUNICATION_ERROR;
  }
  
  private void handleDisconnection(TransportException paramTransportException)
  {
    log.a("Handling a disconnection event", paramTransportException);
    synchronized (inProgressMessagesLock)
    {
      log.d("Due to disconnection event, clearing active queues, and re-queueing them to waiting queues to be re-processed later upon reconnection");
      waitingPacketsQueue.addAll(inProgressPackets.values());
      inProgressPackets.clear();
      updateStatus(IotHubConnectionStatus.DISCONNECTED_RETRYING, exceptionToStatusChangeReason(paramTransportException), paramTransportException);
      checkForUnauthorizedException(paramTransportException);
      log.e("Starting reconnection logic");
      reconnect(paramTransportException);
      return;
    }
  }
  
  private void handleMessageException(IotHubTransportPacket paramIotHubTransportPacket, TransportException paramTransportException)
  {
    log.d("Handling an exception from sending message: Attempt number {}", Integer.valueOf(paramIotHubTransportPacket.getCurrentRetryAttempt()), paramTransportException);
    paramIotHubTransportPacket.incrementRetryAttempt();
    Object localObject;
    if (!hasOperationTimedOut(paramIotHubTransportPacket.getStartTimeMillis()))
    {
      if (paramTransportException.isRetryable())
      {
        localObject = defaultConfig.getRetryPolicy().getRetryDecision(paramIotHubTransportPacket.getCurrentRetryAttempt(), paramTransportException);
        if (((RetryDecision)localObject).shouldRetry())
        {
          taskScheduler.schedule(new MessageRetryRunnable(waitingPacketsQueue, paramIotHubTransportPacket), ((RetryDecision)localObject).getDuration(), TimeUnit.MILLISECONDS);
          return;
        }
        log.d("Retry policy dictated that the message should be abandoned, so it has been abandoned ({})", paramIotHubTransportPacket.getMessage(), paramTransportException);
      }
      else
      {
        log.d("Encountering an non-retryable exception while sending a message, so it has been abandoned ({})", paramIotHubTransportPacket.getMessage(), paramTransportException);
      }
    }
    else {
      log.d("The device operation timeout has been exceeded for the message, so it has been abandoned ({})", paramIotHubTransportPacket.getMessage(), paramTransportException);
    }
    if ((paramTransportException instanceof IotHubServiceException)) {
      localObject = ((IotHubServiceException)paramTransportException).getStatusCode();
    } else {
      localObject = IotHubStatusCode.ERROR;
    }
    if ((paramTransportException instanceof AmqpConnectionThrottledException)) {
      localObject = IotHubStatusCode.THROTTLED;
    }
    paramIotHubTransportPacket.setStatus((IotHubStatusCode)localObject);
    addToCallbackQueue(paramIotHubTransportPacket);
  }
  
  private boolean hasOperationTimedOut(long paramLong)
  {
    boolean bool = false;
    if (paramLong == 0L) {
      return false;
    }
    if (System.currentTimeMillis() - paramLong > defaultConfig.getOperationTimeout()) {
      bool = true;
    }
    return bool;
  }
  
  private void invokeConnectionStateCallback(IotHubConnectionStatus paramIotHubConnectionStatus, IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason)
  {
    IotHubConnectionStateCallback localIotHubConnectionStateCallback = stateCallback;
    if (localIotHubConnectionStateCallback != null) {
      if (paramIotHubConnectionStatus == IotHubConnectionStatus.CONNECTED) {
        localIotHubConnectionStateCallback.execute(IotHubConnectionState.CONNECTION_SUCCESS, stateCallbackContext);
      } else if (paramIotHubConnectionStatusChangeReason == IotHubConnectionStatusChangeReason.EXPIRED_SAS_TOKEN) {
        localIotHubConnectionStateCallback.execute(IotHubConnectionState.SAS_TOKEN_EXPIRED, stateCallbackContext);
      } else if (paramIotHubConnectionStatus == IotHubConnectionStatus.DISCONNECTED) {
        localIotHubConnectionStateCallback.execute(IotHubConnectionState.CONNECTION_DROP, stateCallbackContext);
      }
    }
  }
  
  private void invokeConnectionStatusChangeCallback(IotHubConnectionStatus paramIotHubConnectionStatus, IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason, Throwable paramThrowable)
  {
    IotHubConnectionStatusChangeCallback localIotHubConnectionStatusChangeCallback = connectionStatusChangeCallback;
    if (localIotHubConnectionStatusChangeCallback != null) {
      localIotHubConnectionStatusChangeCallback.execute(paramIotHubConnectionStatus, paramIotHubConnectionStatusChangeReason, paramThrowable, connectionStatusChangeCallbackContext);
    }
  }
  
  private boolean isMessageValid(IotHubTransportPacket paramIotHubTransportPacket)
  {
    Message localMessage = paramIotHubTransportPacket.getMessage();
    if (localMessage.isExpired())
    {
      log.c("Message with has expired, adding to callbacks queue with MESSAGE_EXPIRED ({})", localMessage);
      paramIotHubTransportPacket.setStatus(IotHubStatusCode.MESSAGE_EXPIRED);
      addToCallbackQueue(paramIotHubTransportPacket);
      return false;
    }
    if (isSasTokenExpired())
    {
      log.b("Creating a callback for the message with expired sas token with UNAUTHORIZED status");
      paramIotHubTransportPacket.setStatus(IotHubStatusCode.UNAUTHORIZED);
      addToCallbackQueue(paramIotHubTransportPacket);
      updateStatus(IotHubConnectionStatus.DISCONNECTED, IotHubConnectionStatusChangeReason.EXPIRED_SAS_TOKEN, new SecurityException("Your sas token has expired"));
      return false;
    }
    return true;
  }
  
  private boolean isSasTokenExpired()
  {
    boolean bool;
    if ((defaultConfig.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN) && (defaultConfig.getSasTokenAuthentication().isRenewalNecessary())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void openConnection()
  {
    scheduledExecutorService = Executors.newScheduledThreadPool(1);
    if (iotHubTransportConnection == null)
    {
      int i = defaultConfig.getProtocol().ordinal();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              break label82;
            }
            if (i != 4) {
              throw new TransportException("Protocol not supported");
            }
          }
          iotHubTransportConnection = new MqttIotHubConnection(defaultConfig);
          break label115;
        }
        label82:
        iotHubTransportConnection = new AmqpsIotHubConnection(defaultConfig);
      }
      else
      {
        iotHubTransportConnection = new HttpsIotHubConnection(defaultConfig);
      }
    }
    label115:
    iotHubTransportConnection.setListener(this);
    iotHubTransportConnection.open(deviceClientConfigs, scheduledExecutorService);
    updateStatus(IotHubConnectionStatus.CONNECTED, IotHubConnectionStatusChangeReason.CONNECTION_OK, null);
  }
  
  private void reconnect(TransportException paramTransportException)
  {
    if (reconnectionAttemptStartTimeMillis == 0L) {
      reconnectionAttemptStartTimeMillis = System.currentTimeMillis();
    }
    boolean bool = hasOperationTimedOut(reconnectionAttemptStartTimeMillis);
    Object localObject = null;
    TransportException localTransportException = paramTransportException;
    paramTransportException = (TransportException)localObject;
    for (;;)
    {
      localObject = paramTransportException;
      if (connectionStatus != IotHubConnectionStatus.DISCONNECTED_RETRYING) {
        break;
      }
      localObject = paramTransportException;
      if (bool) {
        break;
      }
      localObject = paramTransportException;
      if (localTransportException == null) {
        break;
      }
      localObject = paramTransportException;
      if (!localTransportException.isRetryable()) {
        break;
      }
      log.d("Attempting reconnect attempt {}", Integer.valueOf(currentReconnectionAttempt));
      currentReconnectionAttempt += 1;
      paramTransportException = defaultConfig.getRetryPolicy().getRetryDecision(currentReconnectionAttempt, localTransportException);
      if (!paramTransportException.shouldRetry())
      {
        localObject = paramTransportException;
        break;
      }
      log.d("Sleeping between reconnect attempts");
      sleepUninterruptibly(paramTransportException.getDuration(), TimeUnit.MILLISECONDS);
      bool = hasOperationTimedOut(reconnectionAttemptStartTimeMillis);
      localTransportException = singleReconnectAttempt();
    }
    if (localObject != null) {}
    try
    {
      if (!((RetryDecision)localObject).shouldRetry())
      {
        log.e("Reconnection was abandoned due to the retry policy");
        close(IotHubConnectionStatusChangeReason.RETRY_EXPIRED, localTransportException);
      }
      else if (hasOperationTimedOut(reconnectionAttemptStartTimeMillis))
      {
        log.e("Reconnection was abandoned due to the operation timeout");
        localObject = IotHubConnectionStatusChangeReason.RETRY_EXPIRED;
        paramTransportException = new com/microsoft/azure/sdk/iot/device/exceptions/DeviceOperationTimeoutException;
        paramTransportException.<init>("Device operation for reconnection timed out");
        close((IotHubConnectionStatusChangeReason)localObject, paramTransportException);
      }
      else if ((localTransportException != null) && (!localTransportException.isRetryable()))
      {
        log.e("Reconnection was abandoned due to encountering a non-retryable exception", localTransportException);
        close(exceptionToStatusChangeReason(localTransportException), localTransportException);
      }
    }
    catch (DeviceClientException paramTransportException)
    {
      log.e("Encountered an exception while closing the client object, client instance should no longer be used as the state is unknown", paramTransportException);
      updateStatus(IotHubConnectionStatus.DISCONNECTED, IotHubConnectionStatusChangeReason.COMMUNICATION_ERROR, localTransportException);
    }
  }
  
  private void sendPacket(IotHubTransportPacket paramIotHubTransportPacket)
  {
    Message localMessage = paramIotHubTransportPacket.getMessage();
    int i;
    if (((localMessage instanceof IotHubTransportMessage)) && (!((IotHubTransportMessage)localMessage).isMessageAckNeeded(defaultConfig.getProtocol()))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {}
    try
    {
      synchronized (inProgressMessagesLock)
      {
        log.d("Adding transport message to the inProgressPackets to wait for acknowledgement ({})", localMessage);
        inProgressPackets.put(localMessage.getMessageId(), paramIotHubTransportPacket);
      }
      log.b("Sending message ({})", localMessage);
      IotHubStatusCode localIotHubStatusCode = iotHubTransportConnection.sendMessage(localMessage);
      log.b("Sent message ({}) to protocol level, returned status code was {}", localMessage, localIotHubStatusCode);
      if ((localIotHubStatusCode != IotHubStatusCode.OK_EMPTY) && (localIotHubStatusCode != IotHubStatusCode.OK))
      {
        handleMessageException((IotHubTransportPacket)inProgressPackets.remove(localMessage.getMessageId()), IotHubStatusCode.getConnectionStatusException(localIotHubStatusCode, ""));
      }
      else if (i == 0)
      {
        paramIotHubTransportPacket.setStatus(localIotHubStatusCode);
        addToCallbackQueue(paramIotHubTransportPacket);
      }
    }
    catch (TransportException localTransportException)
    {
      log.d("Encountered exception while sending message with correlation id {}", localMessage.getCorrelationId(), localTransportException);
      if (i != 0) {
        synchronized (inProgressMessagesLock)
        {
          paramIotHubTransportPacket = (IotHubTransportPacket)inProgressPackets.remove(localMessage.getMessageId());
        }
      }
      handleMessageException(paramIotHubTransportPacket, localTransportException);
    }
  }
  
  private TransportException singleReconnectAttempt()
  {
    try
    {
      log.d("Attempting to close and re-open the iot hub transport connection...");
      iotHubTransportConnection.close();
      openConnection();
      log.d("Successfully closed and re-opened the iot hub transport connection");
      return null;
    }
    catch (TransportException localTransportException)
    {
      checkForUnauthorizedException(localTransportException);
      log.b("Failed to close and re-open the iot hub transport connection, checking if another retry attempt should be made", localTransportException);
      return localTransportException;
    }
  }
  
  /* Error */
  public static void sleepUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iload_3
    //   6: istore 5
    //   8: aload_2
    //   9: lload_0
    //   10: invokevirtual 641	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   13: lstore 6
    //   15: iload_3
    //   16: istore 5
    //   18: invokestatic 644	java/lang/System:nanoTime	()J
    //   21: lstore 8
    //   23: lload 6
    //   25: lstore_0
    //   26: iload 4
    //   28: istore 5
    //   30: getstatic 647	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: lload_0
    //   34: invokevirtual 651	java/util/concurrent/TimeUnit:sleep	(J)V
    //   37: iload 4
    //   39: ifeq +9 -> 48
    //   42: invokestatic 657	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   45: invokevirtual 660	java/lang/Thread:interrupt	()V
    //   48: return
    //   49: astore_2
    //   50: iconst_1
    //   51: istore 5
    //   53: iconst_1
    //   54: istore 4
    //   56: invokestatic 644	java/lang/System:nanoTime	()J
    //   59: lstore_0
    //   60: lload 8
    //   62: lload 6
    //   64: ladd
    //   65: lload_0
    //   66: lsub
    //   67: lstore_0
    //   68: goto -42 -> 26
    //   71: astore_2
    //   72: iload 5
    //   74: ifeq +9 -> 83
    //   77: invokestatic 657	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   80: invokevirtual 660	java/lang/Thread:interrupt	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramLong	long
    //   0	85	2	paramTimeUnit	TimeUnit
    //   1	15	3	i	int
    //   3	52	4	j	int
    //   6	67	5	k	int
    //   13	50	6	l1	long
    //   21	40	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   30	37	49	java/lang/InterruptedException
    //   8	15	71	finally
    //   18	23	71	finally
    //   30	37	71	finally
    //   56	60	71	finally
  }
  
  private void updateStatus(IotHubConnectionStatus paramIotHubConnectionStatus, IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason, Throwable paramThrowable)
  {
    if (connectionStatus != paramIotHubConnectionStatus)
    {
      if (paramThrowable == null) {
        log.c("Updating transport status to new status {} with reason {}", paramIotHubConnectionStatus, paramIotHubConnectionStatusChangeReason);
      } else {
        log.b("Updating transport status to new status {} with reason {}", new Object[] { paramIotHubConnectionStatus, paramIotHubConnectionStatusChangeReason, paramThrowable });
      }
      connectionStatus = paramIotHubConnectionStatus;
      log.e("Invoking connection status callbacks with new status details");
      invokeConnectionStateCallback(paramIotHubConnectionStatus, paramIotHubConnectionStatusChangeReason);
      invokeConnectionStatusChangeCallback(paramIotHubConnectionStatus, paramIotHubConnectionStatusChangeReason, paramThrowable);
      if (paramIotHubConnectionStatus == IotHubConnectionStatus.CONNECTED)
      {
        currentReconnectionAttempt = 0;
        reconnectionAttemptStartTimeMillis = 0L;
      }
    }
  }
  
  public void addMessage(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if (connectionStatus != IotHubConnectionStatus.DISCONNECTED)
    {
      paramIotHubEventCallback = new IotHubTransportPacket(paramMessage, paramIotHubEventCallback, paramObject, null, System.currentTimeMillis());
      waitingPacketsQueue.add(paramIotHubEventCallback);
      log.b("Message was queued to be sent later ({})", paramMessage);
      return;
    }
    throw new IllegalStateException("Cannot add a message when the transport is closed.");
  }
  
  public void close(IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason, Throwable paramThrowable)
  {
    if (paramIotHubConnectionStatusChangeReason != null)
    {
      cancelPendingPackets();
      invokeCallbacks();
      Object localObject = taskScheduler;
      if (localObject != null) {
        ((ScheduledExecutorService)localObject).shutdown();
      }
      localObject = scheduledExecutorService;
      if (localObject != null)
      {
        ((ScheduledExecutorService)localObject).shutdownNow();
        scheduledExecutorService = null;
      }
      localObject = iotHubTransportConnection;
      if (localObject != null) {
        ((IotHubTransportConnection)localObject).close();
      }
      updateStatus(IotHubConnectionStatus.DISCONNECTED, paramIotHubConnectionStatusChangeReason, paramThrowable);
      log.b("Client connection closed successfully");
      return;
    }
    throw new IllegalArgumentException("reason cannot be null");
  }
  
  public void handleMessage()
  {
    if (connectionStatus == IotHubConnectionStatus.CONNECTED)
    {
      if ((iotHubTransportConnection instanceof HttpsIotHubConnection))
      {
        log.d("Sending http request to check for any cloud to device messages...");
        addReceivedMessagesOverHttpToReceivedQueue();
      }
      IotHubTransportMessage localIotHubTransportMessage = (IotHubTransportMessage)receivedMessagesQueue.poll();
      if (localIotHubTransportMessage != null) {
        acknowledgeReceivedMessage(localIotHubTransportMessage);
      }
    }
  }
  
  public void invokeCallbacks()
  {
    for (IotHubTransportPacket localIotHubTransportPacket = (IotHubTransportPacket)callbackPacketsQueue.poll(); localIotHubTransportPacket != null; localIotHubTransportPacket = (IotHubTransportPacket)callbackPacketsQueue.poll())
    {
      IotHubStatusCode localIotHubStatusCode = localIotHubTransportPacket.getStatus();
      IotHubEventCallback localIotHubEventCallback = localIotHubTransportPacket.getCallback();
      Object localObject = localIotHubTransportPacket.getContext();
      log.c("Invoking the callback function for sent message, IoT Hub responded to message ({}) with status {}", localIotHubTransportPacket.getMessage(), localIotHubStatusCode);
      localIotHubEventCallback.execute(localIotHubStatusCode, localObject);
    }
  }
  
  public boolean isEmpty()
  {
    synchronized (inProgressMessagesLock)
    {
      boolean bool;
      if ((waitingPacketsQueue.isEmpty()) && (inProgressPackets.size() == 0) && (callbackPacketsQueue.isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void onConnectionEstablished(String paramString)
  {
    if (paramString.equals(iotHubTransportConnection.getConnectionId()))
    {
      log.b("The connection to the IoT Hub has been established");
      updateStatus(IotHubConnectionStatus.CONNECTED, IotHubConnectionStatusChangeReason.CONNECTION_OK, null);
    }
  }
  
  public void onConnectionLost(Throwable paramThrowable, String paramString)
  {
    synchronized (reconnectionLock)
    {
      if (!paramString.equals(iotHubTransportConnection.getConnectionId()))
      {
        log.d("OnConnectionLost was fired, but for an outdated connection. Ignoring...");
        return;
      }
      if (connectionStatus != IotHubConnectionStatus.CONNECTED)
      {
        log.d("OnConnectionLost was fired, but connection is already disocnnected. Ignoring...");
        return;
      }
      if ((paramThrowable instanceof TransportException))
      {
        handleDisconnection((TransportException)paramThrowable);
      }
      else
      {
        paramString = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
        paramString.<init>(paramThrowable);
        handleDisconnection(paramString);
      }
      return;
    }
  }
  
  public void onMessageReceived(IotHubTransportMessage paramIotHubTransportMessage, Throwable paramThrowable)
  {
    if ((paramIotHubTransportMessage != null) && (paramThrowable != null))
    {
      log.e("Exception encountered while receiving a message from service {}", paramIotHubTransportMessage, paramThrowable);
    }
    else if (paramIotHubTransportMessage != null)
    {
      log.b("Message was received from IotHub ({})", paramIotHubTransportMessage);
      receivedMessagesQueue.add(paramIotHubTransportMessage);
    }
    else
    {
      log.e("Exception encountered while receiving messages from service", paramThrowable);
    }
  }
  
  public void onMessageSent(Message paramMessage, Throwable paramThrowable)
  {
    if (paramMessage == null)
    {
      log.c("onMessageSent called with null message");
      return;
    }
    log.e("IotHub message was acknowledged. Checking if there is record of sending this message ({})", paramMessage);
    synchronized (inProgressMessagesLock)
    {
      IotHubTransportPacket localIotHubTransportPacket = (IotHubTransportPacket)inProgressPackets.remove(paramMessage.getMessageId());
      if (localIotHubTransportPacket != null)
      {
        if (paramThrowable == null)
        {
          log.d("Message was sent by this client, adding it to callbacks queue with OK_EMPTY ({})", paramMessage);
          localIotHubTransportPacket.setStatus(IotHubStatusCode.OK_EMPTY);
          addToCallbackQueue(localIotHubTransportPacket);
        }
        else if ((paramThrowable instanceof TransportException))
        {
          handleMessageException(localIotHubTransportPacket, (TransportException)paramThrowable);
        }
        else
        {
          handleMessageException(localIotHubTransportPacket, new TransportException(paramThrowable));
        }
      }
      else {
        log.c("A message was acknowledged by IoT Hub, but this client has no record of sending it ({})", paramMessage);
      }
      return;
    }
  }
  
  public void open(Collection<DeviceClientConfig> paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      if (connectionStatus == IotHubConnectionStatus.CONNECTED) {
        return;
      }
      if (connectionStatus != IotHubConnectionStatus.DISCONNECTED_RETRYING)
      {
        if (!isSasTokenExpired())
        {
          paramCollection = new LinkedBlockingQueue(paramCollection);
          deviceClientConfigs = paramCollection;
          defaultConfig = ((DeviceClientConfig)paramCollection.peek());
          taskScheduler = Executors.newScheduledThreadPool(1);
          openConnection();
          log.b("Client connection opened successfully");
          return;
        }
        throw new SecurityException("Your sas token has expired");
      }
      throw new TransportException("Open cannot be called while transport is reconnecting");
    }
    throw new IllegalArgumentException("deviceClientConfigs cannot be null or empty");
  }
  
  public void registerConnectionStateCallback(IotHubConnectionStateCallback paramIotHubConnectionStateCallback, Object paramObject)
  {
    if (paramIotHubConnectionStateCallback != null)
    {
      stateCallback = paramIotHubConnectionStateCallback;
      stateCallbackContext = paramObject;
      return;
    }
    throw new IllegalArgumentException("Callback cannot be null");
  }
  
  public void registerConnectionStatusChangeCallback(IotHubConnectionStatusChangeCallback paramIotHubConnectionStatusChangeCallback, Object paramObject)
  {
    if ((paramObject != null) && (paramIotHubConnectionStatusChangeCallback == null)) {
      throw new IllegalArgumentException("Callback cannot be null if callback context is null");
    }
    connectionStatusChangeCallback = paramIotHubConnectionStatusChangeCallback;
    connectionStatusChangeCallbackContext = paramObject;
  }
  
  public void sendMessages()
  {
    checkForExpiredMessages();
    if ((connectionStatus != IotHubConnectionStatus.DISCONNECTED) && (connectionStatus != IotHubConnectionStatus.DISCONNECTED_RETRYING)) {
      for (int i = 10; (connectionStatus == IotHubConnectionStatus.CONNECTED) && (i > 0); i--)
      {
        IotHubTransportPacket localIotHubTransportPacket = (IotHubTransportPacket)waitingPacketsQueue.poll();
        if (localIotHubTransportPacket != null)
        {
          Message localMessage = localIotHubTransportPacket.getMessage();
          log.d("Dequeued a message from waiting queue to be sent ({})", localMessage);
          if ((localMessage != null) && (isMessageValid(localIotHubTransportPacket))) {
            sendPacket(localIotHubTransportPacket);
          }
        }
      }
    }
  }
  
  public class MessageRetryRunnable
    implements Runnable
  {
    public final IotHubTransportPacket transportPacket;
    public final Queue<IotHubTransportPacket> waitingPacketsQueue;
    
    public MessageRetryRunnable(IotHubTransportPacket paramIotHubTransportPacket)
    {
      waitingPacketsQueue = paramIotHubTransportPacket;
      IotHubTransportPacket localIotHubTransportPacket;
      transportPacket = localIotHubTransportPacket;
    }
    
    public void run()
    {
      waitingPacketsQueue.add(transportPacket);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.IotHubTransport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */