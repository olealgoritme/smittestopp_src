package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.proton.transport.proxy.ProxyAuthenticationType;
import com.microsoft.azure.proton.transport.proxy.ProxyConfiguration;
import com.microsoft.azure.proton.transport.proxy.impl.ProxyHandlerImpl;
import com.microsoft.azure.proton.transport.proxy.impl.ProxyImpl;
import com.microsoft.azure.proton.transport.ws.impl.WebSocketImpl;
import com.microsoft.azure.sdk.iot.deps.transport.amqp.ErrorLoggingBaseHandler;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.ProxySettings;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportConnection;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.ReconnectionNotifier;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import k.a.b.a.b.k.r;
import k.a.b.a.b.k.s;
import k.a.b.a.b.n.j;
import k.a.b.a.d.e;
import k.a.b.a.d.g0.d0;
import k.a.b.a.d.g0.g;
import k.a.b.a.d.h;
import k.a.b.a.d.l;
import k.a.b.a.d.t;
import k.a.b.a.d.x;

public final class AmqpsIotHubConnection
  extends ErrorLoggingBaseHandler
  implements IotHubTransportConnection
{
  public static final int AMQP_PORT = 5671;
  public static final int AMQP_WEB_SOCKET_PORT = 443;
  public static final String APPLICATION_PROPERTY_STATUS_CODE = "status-code";
  public static final String APPLICATION_PROPERTY_STATUS_DESCRIPTION = "status-description";
  public static final int CBS_LINK_COUNT = 2;
  public static final int MAX_MESSAGES_TO_SEND_PER_CALLBACK = 1000;
  public static final int MAX_WAIT_TO_CLOSE_CONNECTION = 60000;
  public static final int MAX_WAIT_TO_OPEN_CBS_LINKS = 20000;
  public static final int MAX_WAIT_TO_OPEN_WORKER_LINKS = 60000;
  public static final int MAX_WAIT_TO_TERMINATE_EXECUTOR = 30;
  public static final int REACTOR_COUNT = 1;
  public static final int SEND_MESSAGES_PERIOD_MILLIS = 50;
  public static final int WEBSOCKET_PORT = 443;
  public static final String WEBSOCKET_QUERY = "iothub-no-client-cert=true";
  public static final String WEB_SOCKET_PATH = "/$iothub/websocket";
  public static final String WEB_SOCKET_SUB_PROTOCOL = "AMQPWSB10";
  public static final k.f.b log = k.f.c.a(AmqpsIotHubConnection.class);
  public AmqpsSessionManager amqpsSessionManager;
  public CountDownLatch authenticationLinkOpenLatch;
  public CountDownLatch cbsLinkAuthorizedLatch;
  public CountDownLatch closeReactorLatch;
  public k.a.b.a.d.c connection;
  public String connectionId;
  public DeviceClientConfig deviceClientConfig;
  public ExecutorService executorService;
  public String hostName;
  public final Map<Integer, Message> inProgressMessages = new ConcurrentHashMap();
  public boolean isAuthenticated;
  public IotHubListener listener;
  public Queue<Message> messagesToSend = new ConcurrentLinkedQueue();
  public k.a.b.a.g.d reactor;
  public boolean reconnectionScheduled = false;
  public AmqpSasTokenRenewalHandler sasTokenRenewalHandler;
  public TransportException savedException;
  public final Map<Message, AmqpsMessage> sendAckMessages = new ConcurrentHashMap();
  public IotHubConnectionStatus state;
  public final Boolean useWebSockets;
  public CountDownLatch workerLinksOpenLatch;
  
  public AmqpsIotHubConnection(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      if ((paramDeviceClientConfig.getIotHubHostname() != null) && (paramDeviceClientConfig.getIotHubHostname().length() != 0))
      {
        if ((paramDeviceClientConfig.getDeviceId() != null) && (paramDeviceClientConfig.getDeviceId().length() != 0))
        {
          if ((paramDeviceClientConfig.getIotHubName() != null) && (paramDeviceClientConfig.getIotHubName().length() != 0))
          {
            deviceClientConfig = paramDeviceClientConfig;
            paramDeviceClientConfig = Boolean.valueOf(paramDeviceClientConfig.isUseWebsocket());
            useWebSockets = paramDeviceClientConfig;
            boolean bool = paramDeviceClientConfig.booleanValue();
            int i = 443;
            if (bool) {
              hostName = String.format("%s:%d", new Object[] { chooseHostname(), Integer.valueOf(443) });
            } else {
              hostName = String.format("%s:%d", new Object[] { chooseHostname(), Integer.valueOf(5671) });
            }
            add(new k.a.b.a.g.c());
            add(new k.a.b.a.g.b());
            state = IotHubConnectionStatus.DISCONNECTED;
            amqpsSessionManager = new AmqpsSessionManager(deviceClientConfig);
            paramDeviceClientConfig = log;
            if (!useWebSockets.booleanValue()) {
              i = 5671;
            }
            paramDeviceClientConfig.d("AmqpsIotHubConnection object is created successfully and will use port {}", Integer.valueOf(i));
            return;
          }
          throw new IllegalArgumentException("hubName cannot be null or empty.");
        }
        throw new IllegalArgumentException("deviceID cannot be null or empty.");
      }
      throw new IllegalArgumentException("hostName cannot be null or empty.");
    }
    throw new IllegalArgumentException("The DeviceClientConfig cannot be null.");
  }
  
  private void addProxyLayer(k.a.b.a.d.c0 paramc0, String paramString)
  {
    Object localObject = deviceClientConfig.getProxySettings();
    if ((((ProxySettings)localObject).getUsername() != null) && (((ProxySettings)localObject).getPassword() != null))
    {
      log.e("Adding proxy username and password to amqp proxy configuration");
      localObject = new ProxyImpl(new ProxyConfiguration(ProxyAuthenticationType.BASIC, ((ProxySettings)localObject).getProxy(), ((ProxySettings)localObject).getUsername(), new String(((ProxySettings)localObject).getPassword())));
    }
    else
    {
      log.e("No proxy username and password will be used amqp proxy configuration");
      localObject = new ProxyImpl();
    }
    ((ProxyImpl)localObject).configure(paramString, null, new ProxyHandlerImpl(), paramc0);
    ((k.a.b.a.d.g0.c0)paramc0).a((d0)localObject);
  }
  
  private void addWebsocketLayer(k.a.b.a.d.c0 paramc0)
  {
    WebSocketImpl localWebSocketImpl = new WebSocketImpl();
    localWebSocketImpl.configure(hostName, "/$iothub/websocket", "iothub-no-client-cert=true", 443, "AMQPWSB10", null, null);
    ((k.a.b.a.d.g0.c0)paramc0).a(localWebSocketImpl);
  }
  
  private String chooseHostname()
  {
    String str = deviceClientConfig.getGatewayHostname();
    if ((str != null) && (!str.isEmpty()))
    {
      log.b("Gateway hostname was present in config, connecting to gateway rather than directly to hub");
      return str;
    }
    log.b("No gateway hostname was present in config, connecting directly to hub");
    return deviceClientConfig.getIotHubHostname();
  }
  
  private void closeAsync()
  {
    log.e("CloseAsync called on amqp connection");
    Object localObject = amqpsSessionManager;
    if (localObject != null) {
      ((AmqpsSessionManager)localObject).closeNow();
    }
    localObject = connection;
    if (localObject != null) {
      ((k.a.b.a.d.f)localObject).close();
    }
    localObject = reactor;
    if (localObject != null) {
      ((k.a.b.a.g.d)localObject).stop();
    }
    log.e("Proton reactor has been stopped");
  }
  
  private void closeConnectionWithException(String paramString, boolean paramBoolean)
  {
    TransportException localTransportException = new TransportException(paramString);
    localTransportException.setRetryable(paramBoolean);
    log.e(paramString, localTransportException);
    close();
    throw localTransportException;
  }
  
  private k.a.b.a.g.d createReactor()
  {
    try
    {
      Object localObject1 = deviceClientConfig.getAuthenticationType();
      Object localObject2 = DeviceClientConfig.AuthType.X509_CERTIFICATE;
      int i = 0;
      if (localObject1 == localObject2)
      {
        localObject2 = new k/a/b/a/g/f;
        ((k.a.b.a.g.f)localObject2).<init>();
        a = false;
        return e.c.a.a.b.l.c.a((k.a.b.a.g.f)localObject2, new l[] { this });
      }
      localObject2 = new k/a/b/a/g/i/d;
      k.a.b.a.g.i.c localc = new k/a/b/a/g/i/c;
      localc.<init>();
      localObject1 = new k/a/b/a/g/f;
      ((k.a.b.a.g.f)localObject1).<init>();
      ((k.a.b.a.g.i.d)localObject2).<init>(localc, (k.a.b.a.g.f)localObject1);
      while (i < 1)
      {
        localObject1 = new l[] { this }[i];
        ((k.a.b.a.g.d)localObject2).F().add((l)localObject1);
        i++;
      }
      return (k.a.b.a.g.d)localObject2;
    }
    catch (IOException localIOException)
    {
      throw new TransportException("Could not create Proton reactor", localIOException);
    }
  }
  
  private void executorServicesCleanup()
  {
    if (executorService != null)
    {
      log.e("Shutdown of executor service has started");
      executorService.shutdown();
      try
      {
        if (!executorService.awaitTermination(30L, TimeUnit.SECONDS))
        {
          executorService.shutdownNow();
          if (!executorService.awaitTermination(30L, TimeUnit.SECONDS)) {
            log.e("Pool did not terminate");
          }
        }
        executorService = null;
        log.e("Shutdown of executor service completed");
      }
      catch (InterruptedException localInterruptedException)
      {
        log.b("Interrupted while cleaning up executor services", localInterruptedException);
        executorService.shutdownNow();
        executorService = null;
        throw new TransportException("Waited too long for the connection to close.", localInterruptedException);
      }
    }
  }
  
  private j getErrorConditionFromEndpoint(k.a.b.a.d.f paramf)
  {
    if ((paramf.L() != null) && (La != null)) {
      paramf = paramf.L();
    } else {
      paramf = paramf.H();
    }
    return paramf;
  }
  
  private TransportException getTransportExceptionFromEvent(h paramh)
  {
    paramh = (g)paramh;
    TransportException localTransportException = getTransportExceptionFromProtonEndpoints(new k.a.b.a.d.f[] { paramh.o(), paramh.i(), paramh.U(), paramh.l(), paramh.T(), paramh.G() });
    paramh = localTransportException;
    if (localTransportException == null)
    {
      paramh = new TransportException("Unknown transport exception occurred");
      paramh.setRetryable(true);
    }
    return paramh;
  }
  
  private TransportException getTransportExceptionFromProtonEndpoints(k.a.b.a.d.f... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramVarArgs[j];
      if (localObject != null)
      {
        localObject = getErrorConditionFromEndpoint((k.a.b.a.d.f)localObject);
        if (localObject != null)
        {
          k.a.b.a.b.f localf = a;
          if (localf != null) {
            return AmqpsExceptionTranslator.convertToAmqpException(x, b);
          }
        }
      }
    }
    return null;
  }
  
  private void handleCbsMessage(AmqpsMessage paramAmqpsMessage)
  {
    log.e("Received message with correlation id {} was a cbs message, handling...", paramAmqpsMessage.getCorrelationId());
    if ((paramAmqpsMessage.getApplicationProperties() != null) && (getApplicationPropertiesa != null))
    {
      Map localMap = getApplicationPropertiesa;
      if (localMap.containsKey("status-code"))
      {
        String str = localMap.get("status-code").toString();
        try
        {
          IotHubStatusCode localIotHubStatusCode = IotHubStatusCode.getIotHubStatusCode(Integer.valueOf(str).intValue());
          if ((localIotHubStatusCode != IotHubStatusCode.OK) && (localIotHubStatusCode != IotHubStatusCode.OK_EMPTY))
          {
            paramAmqpsMessage = "";
            if (localMap.containsKey("status-description")) {
              paramAmqpsMessage = (String)localMap.get("status-description");
            }
            paramAmqpsMessage = IotHubStatusCode.getConnectionStatusException(localIotHubStatusCode, paramAmqpsMessage);
            savedException = paramAmqpsMessage;
            log.e("CBS authentication was rejected by service", paramAmqpsMessage);
            releaseLatch(cbsLinkAuthorizedLatch);
          }
          else
          {
            cbsLinkAuthorizedLatch.countDown();
            if (state != IotHubConnectionStatus.CONNECTED) {
              log.e("CBS link received 200, one connection has been authorized");
            } else {
              log.e("CBS link received 200, one connection has been re-authorized");
            }
            if (cbsLinkAuthorizedLatch.getCount() <= 0L)
            {
              if (state != IotHubConnectionStatus.CONNECTED) {
                log.b("All CBS links have received a 200, opening worker links");
              }
              isAuthenticated = true;
              amqpsSessionManager.openWorkerLinks();
            }
          }
        }
        catch (NumberFormatException paramAmqpsMessage)
        {
          savedException = new TransportException("Encountered message from service with invalid status code value");
          log.a("status code received from service on cbs link could not be parsed to integer {}", str);
        }
      }
      log.d("CBS message had no status code application property, so it was ignored");
    }
    else
    {
      log.d("CBS message had no application properties, so it was ignored");
    }
  }
  
  private void handleCloudToDeviceMessage(AmqpsMessage paramAmqpsMessage)
  {
    log.e("Handling a received message with amqp message correlation id {}", paramAmqpsMessage.getCorrelationId());
    AmqpsConvertFromProtonReturnValue localAmqpsConvertFromProtonReturnValue = convertFromProton(paramAmqpsMessage, paramAmqpsMessage.getDeviceClientConfig());
    if (localAmqpsConvertFromProtonReturnValue == null)
    {
      if (paramAmqpsMessage.getAmqpsMessageType() == MessageType.CBS_AUTHENTICATION)
      {
        handleCbsMessage(paramAmqpsMessage);
        return;
      }
      log.c("No handler found for received message with amqp correlation id {}, ignoring it", paramAmqpsMessage.getCorrelationId());
      return;
    }
    if (localAmqpsConvertFromProtonReturnValue.getMessageCallback() != null)
    {
      IotHubTransportMessage localIotHubTransportMessage = localAmqpsConvertFromProtonReturnValue.getMessage();
      localIotHubTransportMessage.setMessageCallback(localAmqpsConvertFromProtonReturnValue.getMessageCallback());
      localIotHubTransportMessage.setMessageCallbackContext(localAmqpsConvertFromProtonReturnValue.getMessageContext());
      log.d("Adding received message to the amqp message map to be acknowledged later ({})", localIotHubTransportMessage);
      sendAckMessages.put(localIotHubTransportMessage, paramAmqpsMessage);
      listener.onMessageReceived(localIotHubTransportMessage, null);
      return;
    }
    log.d("Callback is not defined therefore response to IoT Hub cannot be generated. All received messages will be removed from receive message queue");
    throw new TransportException("callback is not defined");
  }
  
  private void initializeStateLatches(int paramInt)
  {
    closeReactorLatch = new CountDownLatch(1);
    if ((deviceClientConfig.getAuthenticationProvider() instanceof IotHubSasTokenAuthenticationProvider))
    {
      log.d("Initializing authentication link latch count to {}", Integer.valueOf(2));
      authenticationLinkOpenLatch = new CountDownLatch(2);
    }
    else
    {
      log.e("Initializing authentication link latch count to 0");
      authenticationLinkOpenLatch = new CountDownLatch(0);
    }
    int i = amqpsSessionManager.getExpectedWorkerLinkCount();
    workerLinksOpenLatch = new CountDownLatch(i);
    log.d("Initializing worker link latch count to {}", Integer.valueOf(i));
    cbsLinkAuthorizedLatch = new CountDownLatch(paramInt);
    log.d("Initializing authentication links authorized latch count to {}", Integer.valueOf(paramInt));
  }
  
  private void openAsync()
  {
    log.e("OpenAsnyc called for AMQP connection");
    if (reactor == null) {
      reactor = createReactor();
    }
    if (executorService == null) {
      executorService = Executors.newFixedThreadPool(1);
    }
    AmqpsIotHubConnection.ReactorRunner localReactorRunner = new AmqpsIotHubConnection.ReactorRunner(this, new IotHubReactor(reactor), listener, connectionId);
    executorService.submit(localReactorRunner);
  }
  
  private int processMessage(Message paramMessage)
  {
    try
    {
      AmqpsConvertToProtonReturnValue localAmqpsConvertToProtonReturnValue = convertToProton(paramMessage);
      if (localAmqpsConvertToProtonReturnValue == null)
      {
        log.c("No handler found for message conversion! Abandoning message ({})", paramMessage);
        return -1;
      }
      try
      {
        log.e("Sending message over amqp ({})", paramMessage);
        int i = sendMessage(localAmqpsConvertToProtonReturnValue, paramMessage.getConnectionDeviceId()).intValue();
        if (i != -1)
        {
          log.d("Amqp message was sent, waiting for ack ({})", paramMessage);
          inProgressMessages.put(Integer.valueOf(i), paramMessage);
          log.e("Adding amqp delivery tag {} to in progress messages ({})", Integer.valueOf(i), paramMessage);
        }
        else
        {
          log.d("Amqp message failed to send, adding it back to messages to send queue ({})", paramMessage);
          messagesToSend.add(paramMessage);
        }
        return i;
      }
      catch (TransportException localTransportException1)
      {
        if (localTransportException1.isRetryable())
        {
          log.b("Encountered exception while sending amqp message, retrying ({})", paramMessage, localTransportException1);
          messagesToSend.add(paramMessage);
        }
        else
        {
          log.d("Encountered non-retryable exception while sending amqp message, abandoning message ({})", paramMessage, localTransportException1);
        }
        return -1;
      }
      return -1;
    }
    catch (TransportException localTransportException2)
    {
      if (localTransportException2.isRetryable())
      {
        log.b("Encountered exception while converting message to proton message, retrying ({})", paramMessage, localTransportException2);
        messagesToSend.add(paramMessage);
      }
      else
      {
        log.d("Encountered non-retryable exception while converting message to proton message, not retryable so discarding message ({})", paramMessage, localTransportException2);
      }
    }
  }
  
  private void processOutgoingMessages()
  {
    Message localMessage = (Message)messagesToSend.poll();
    int i = 0;
    int j = 0;
    while ((localMessage != null) && (i < 1000) && (j >= 0))
    {
      int k = i;
      if (!subscriptionChangeHandler(localMessage))
      {
        k = i + 1;
        j = processMessage(localMessage);
      }
      localMessage = (Message)messagesToSend.poll();
      i = k;
    }
    if (localMessage != null) {
      messagesToSend.add(localMessage);
    }
  }
  
  private void releaseLatch(CountDownLatch paramCountDownLatch)
  {
    for (int i = 0; i < paramCountDownLatch.getCount(); i++) {
      paramCountDownLatch.countDown();
    }
  }
  
  private void scheduleReconnection(Throwable paramThrowable)
  {
    log.b("Amqp connection was closed, creating a thread to notify transport layer", paramThrowable);
    if (!reconnectionScheduled)
    {
      reconnectionScheduled = true;
      ReconnectionNotifier.notifyDisconnectAsync(paramThrowable, listener, connectionId);
    }
  }
  
  private Integer sendMessage(AmqpsConvertToProtonReturnValue paramAmqpsConvertToProtonReturnValue, String paramString)
  {
    if ((state != IotHubConnectionStatus.DISCONNECTED) && (paramAmqpsConvertToProtonReturnValue != null))
    {
      k.a.b.a.f.d.a locala = paramAmqpsConvertToProtonReturnValue.getMessageImpl();
      paramAmqpsConvertToProtonReturnValue = paramAmqpsConvertToProtonReturnValue.getMessageType();
      paramAmqpsConvertToProtonReturnValue = amqpsSessionManager.sendMessage(locala, paramAmqpsConvertToProtonReturnValue, paramString);
    }
    else
    {
      log.e("Amqp connection is disconnected, rejecting attempt to send message with delivery tag -1");
      paramAmqpsConvertToProtonReturnValue = Integer.valueOf(-1);
    }
    return paramAmqpsConvertToProtonReturnValue;
  }
  
  private boolean subscriptionChangeHandler(Message paramMessage)
  {
    Object localObject = paramMessage.getMessageType();
    boolean bool = true;
    if (localObject != null)
    {
      int i = paramMessage.getMessageType().ordinal();
      if (i != 3)
      {
        if (i == 4)
        {
          localObject = (IotHubTransportMessage)paramMessage;
          if ((((IotHubTransportMessage)localObject).getDeviceOperationType() != DeviceOperations.DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST) && (((IotHubTransportMessage)localObject).getDeviceOperationType() == DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST))
          {
            amqpsSessionManager.subscribeDeviceToMessageType(MessageType.DEVICE_TWIN, paramMessage.getConnectionDeviceId());
            listener.onMessageSent(paramMessage, null);
            return bool;
          }
        }
      }
      else if (((IotHubTransportMessage)paramMessage).getDeviceOperationType() == DeviceOperations.DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST)
      {
        amqpsSessionManager.subscribeDeviceToMessageType(MessageType.DEVICE_METHODS, paramMessage.getConnectionDeviceId());
        listener.onMessageSent(paramMessage, null);
        return bool;
      }
    }
    bool = false;
    return bool;
  }
  
  public void addDeviceOperationSession(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      amqpsSessionManager.addDeviceOperationSession(paramDeviceClientConfig);
      log.e("Added device to session list");
    }
  }
  
  public void authenticate()
  {
    log.e("Authenticate called on amqp connection");
    amqpsSessionManager.authenticate();
  }
  
  public void close()
  {
    log.b("Closing amqp connection...");
    closeAsync();
    try
    {
      closeReactorLatch.await(60000L, TimeUnit.MILLISECONDS);
      executorServicesCleanup();
      log.e("Amqp connection closed successfully");
      state = IotHubConnectionStatus.DISCONNECTED;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      log.b("Interrupted while closing proton reactor", localInterruptedException);
      throw new TransportException("Waited too long for the connection to close.", localInterruptedException);
    }
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    return amqpsSessionManager.convertFromProton(paramAmqpsMessage, paramDeviceClientConfig);
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    return amqpsSessionManager.convertToProton(paramMessage);
  }
  
  public String getConnectionId()
  {
    return connectionId;
  }
  
  public void onConnectionBound(h paramh)
  {
    paramh = (g)paramh;
    k.a.b.a.d.c0 localc0 = paramh.U().l();
    if (localc0 != null)
    {
      if (useWebSockets.booleanValue()) {
        addWebsocketLayer(localc0);
      }
      try
      {
        amqpsSessionManager.onConnectionBound(localc0);
      }
      catch (TransportException localTransportException)
      {
        savedException = localTransportException;
        log.e("Encountered an exception while reacting to onConnectionBound event within amqp session", localTransportException);
      }
      if (deviceClientConfig.getProxySettings() != null)
      {
        log.b("Proxy settings set, adding amqp layer for proxy");
        addProxyLayer(localc0, paramh.U().f());
      }
    }
  }
  
  public void onConnectionInit(h paramh)
  {
    paramh = ((g)paramh).U();
    connection = paramh;
    paramh.c(hostName);
    connection.open();
    try
    {
      amqpsSessionManager.onConnectionInit(connection);
    }
    catch (TransportException paramh)
    {
      savedException = paramh;
      log.e("Encountered an exception while reacting to onConnectionInit within amqp session", paramh);
    }
  }
  
  public void onConnectionUnbound(h paramh)
  {
    log.e("onConnectionUnbound event fired by proton, setting AMQP connection state to DISCONNECTED");
    state = IotHubConnectionStatus.DISCONNECTED;
  }
  
  public void onDelivery(h paramh)
  {
    paramh = (g)paramh;
    k.a.b.a.d.n localn = paramh.G();
    if ((localn instanceof x)) {
      for (paramh = paramh.h(); (paramh != null) && (!paramh.K()) && (paramh.e() != null); paramh = localn.head())
      {
        Object localObject1 = paramh.e();
        int i = Integer.valueOf(new String(paramh.getTag())).intValue();
        if (!localn.A().b().equalsIgnoreCase("$cbs"))
        {
          log.d("Amqp delivery received that acknowledged a sent message with delivery tag {}", Integer.valueOf(i));
          log.d("Checking if amqp in progress messages contains delivery tag {}", Integer.valueOf(i));
          if (inProgressMessages.containsKey(Integer.valueOf(i)))
          {
            log.d("Amqp in progress messages does contain delivery tag {}", Integer.valueOf(i));
            Object localObject2 = (Message)inProgressMessages.remove(Integer.valueOf(i));
            if ((localObject1 instanceof k.a.b.a.b.k.a))
            {
              log.d("AMQP connection received Accepted acknowledgement for iot hub message ({})", localObject2);
              listener.onMessageSent((Message)localObject2, null);
            }
            else if ((localObject1 instanceof r))
            {
              log.d("AMQP connection received Rejected acknowledgement for iot hub message  ({})", localObject2);
              localObject2 = a;
              if (localObject2 != null)
              {
                localObject1 = a;
                if (localObject1 != null)
                {
                  localObject1 = x;
                  localObject2 = b;
                  if (localObject2 == null) {
                    localObject2 = "";
                  }
                  localObject2 = AmqpsExceptionTranslator.convertToAmqpException((String)localObject1, (String)localObject2);
                  break label303;
                }
              }
              localObject2 = new TransportException("IotHub rejected the message");
              label303:
              listener.onMessageSent((Message)inProgressMessages.remove(Integer.valueOf(i)), (Throwable)localObject2);
            }
            else if (((localObject1 instanceof k.a.b.a.b.k.n)) || ((localObject1 instanceof s)) || ((localObject1 instanceof k.a.b.a.b.k.q)))
            {
              log.d("AMQP connection received Modified, Released or Received acknowledgement for iot hub message  ({})", localObject2);
              localObject2 = new TransportException("IotHub responded to message with Modified, Received or Released; message needs to be re-delivered");
              ((TransportException)localObject2).setRetryable(true);
              listener.onMessageSent((Message)inProgressMessages.remove(Integer.valueOf(i)), (Throwable)localObject2);
            }
          }
          else
          {
            log.c("Unable to correlate acknowledgement with delivery tag {} to a sent message, ignoring it", Integer.valueOf(i));
            listener.onMessageReceived(null, new TransportException("Received response from service about a message that this client did not send"));
          }
        }
        else
        {
          log.e("Amqp delivery received that acknowledged a sent authentication message");
        }
        paramh.a();
      }
    }
    if ((localn instanceof t))
    {
      try
      {
        log.e("Amqp delivery received on a receiver link, checking receiver links for delivered message");
        paramh = amqpsSessionManager.getMessageFromReceiverLink(localn.getName());
      }
      catch (TransportException paramh)
      {
        log.e("Failed to receive message from receiver link", paramh);
        listener.onMessageReceived(null, paramh);
        paramh = null;
      }
      if (paramh != null) {
        try
        {
          handleCloudToDeviceMessage(paramh);
        }
        catch (TransportException paramh)
        {
          listener.onMessageReceived(null, paramh);
        }
      } else {
        log.d("onDelivery called on receiver link, but no message was found on any receiver link");
      }
    }
  }
  
  public void onLinkInit(h paramh)
  {
    paramh = ((g)paramh).G();
    amqpsSessionManager.onLinkInit(paramh);
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    super.onLinkRemoteClose(paramh);
    AmqpsSessionManager localAmqpsSessionManager = amqpsSessionManager;
    paramh = (g)paramh;
    localAmqpsSessionManager.onLinkRemoteClose(paramh.G());
    log.e("onLinkRemoteClose fired by proton, setting AMQP connection state as DISCONNECTED");
    state = IotHubConnectionStatus.DISCONNECTED;
    paramh = getTransportExceptionFromEvent(paramh);
    savedException = paramh;
    scheduleReconnection(paramh);
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    AmqpsSessionManager localAmqpsSessionManager = amqpsSessionManager;
    paramh = (g)paramh;
    localAmqpsSessionManager.onLinkRemoteOpen(paramh.G());
    if ((amqpsSessionManager.isAuthenticationOpened()) && (!isAuthenticated)) {
      try
      {
        authenticate();
      }
      catch (TransportException localTransportException)
      {
        savedException = localTransportException;
      }
    }
    if ((!paramh.G().getName().startsWith("cbs-receiver-")) && (!paramh.G().getName().startsWith("cbs-sender-")))
    {
      log.e("workerLinksOpenLatch counted down");
      workerLinksOpenLatch.countDown();
    }
    else
    {
      log.e("authenticationLinkOpenLatch counted down");
      authenticationLinkOpenLatch.countDown();
    }
  }
  
  public void onReactorFinal(h paramh)
  {
    releaseLatch(authenticationLinkOpenLatch);
    releaseLatch(workerLinksOpenLatch);
    releaseLatch(closeReactorLatch);
    reactor = null;
  }
  
  public void onReactorInit(h paramh)
  {
    paramh = ((g)paramh).b();
    if (useWebSockets.booleanValue())
    {
      ProxySettings localProxySettings = deviceClientConfig.getProxySettings();
      if (localProxySettings != null) {
        paramh.a(localProxySettings.getHostname(), localProxySettings.getPort(), this);
      } else {
        paramh.a(chooseHostname(), 443, this);
      }
    }
    else
    {
      paramh.a(chooseHostname(), 5671, this);
    }
    paramh.a(50, this);
    if ((deviceClientConfig.getAuthenticationProvider() instanceof IotHubSasTokenAuthenticationProvider)) {
      paramh.a(deviceClientConfig.getSasTokenAuthentication().getMillisecondsBeforeProactiveRenewal(), sasTokenRenewalHandler);
    }
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    amqpsSessionManager.onSessionRemoteOpen(((g)paramh).T());
  }
  
  public void onTimerTask(h paramh)
  {
    processOutgoingMessages();
    ((g)paramh).b().a(50, this);
  }
  
  public void onTransportError(h paramh)
  {
    super.onTransportError(paramh);
    state = IotHubConnectionStatus.DISCONNECTED;
    paramh = getTransportExceptionFromEvent(paramh);
    savedException = paramh;
    scheduleReconnection(paramh);
  }
  
  public void open(Queue<DeviceClientConfig> paramQueue, ScheduledExecutorService paramScheduledExecutorService)
  {
    log.b("Opening AMQP connection");
    int i = 0;
    reconnectionScheduled = false;
    connectionId = UUID.randomUUID().toString();
    isAuthenticated = false;
    savedException = null;
    sasTokenRenewalHandler = new AmqpSasTokenRenewalHandler(amqpsSessionManager, deviceClientConfig);
    if (state == IotHubConnectionStatus.DISCONNECTED)
    {
      if (paramQueue.size() > 1)
      {
        paramQueue.remove();
        while (!paramQueue.isEmpty()) {
          addDeviceOperationSession((DeviceClientConfig)paramQueue.remove());
        }
      }
      initializeStateLatches(paramQueue.size());
      try
      {
        openAsync();
        log.e("Waiting for authentication links to open...");
        int j;
        if (!authenticationLinkOpenLatch.await(20000L, TimeUnit.MILLISECONDS)) {
          j = 1;
        } else {
          j = 0;
        }
        if (savedException == null)
        {
          if (j != 0) {
            closeConnectionWithException("Timed out waiting for authentication links to open", true);
          }
          log.e("Waiting for worker links to open...");
          j = i;
          if (!workerLinksOpenLatch.await(60000L, TimeUnit.MILLISECONDS)) {
            j = 1;
          }
          if (savedException == null)
          {
            if (j != 0) {
              closeConnectionWithException("Timed out waiting for worker links to open", true);
            }
          }
          else {
            throw savedException;
          }
        }
        else
        {
          throw savedException;
        }
      }
      catch (InterruptedException paramQueue)
      {
        executorServicesCleanup();
        log.e("Interrupted while waiting for links to open for AMQP connection", paramQueue);
        throw new TransportException("Interrupted while waiting for links to open for AMQP connection", paramQueue);
      }
    }
    listener.onConnectionEstablished(connectionId);
    state = IotHubConnectionStatus.CONNECTED;
    log.b("AMQP connection opened successfully");
  }
  
  public IotHubStatusCode sendMessage(Message paramMessage)
  {
    log.d("Adding message to amqp message queue to be sent later ({})", paramMessage);
    messagesToSend.add(paramMessage);
    return IotHubStatusCode.OK;
  }
  
  public boolean sendMessageResult(Message paramMessage, IotHubMessageResult paramIotHubMessageResult)
  {
    if (state != IotHubConnectionStatus.CONNECTED)
    {
      log.d("Unable to send message acknowledgement because amqp connection is not open");
      return false;
    }
    log.e("Sending amqp acknowledgement for iothub message ({}) with result {}", paramMessage, paramIotHubMessageResult);
    if (sendAckMessages.containsKey(paramMessage))
    {
      AmqpsMessage localAmqpsMessage = (AmqpsMessage)sendAckMessages.get(paramMessage);
      int i = paramIotHubMessageResult.ordinal();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            log.c("Invalid IoT Hub message result {}", paramIotHubMessageResult.name());
            return false;
          }
          localAmqpsMessage.acknowledge(AmqpsMessage.ACK_TYPE.REJECT);
        }
        else
        {
          localAmqpsMessage.acknowledge(AmqpsMessage.ACK_TYPE.ABANDON);
        }
      }
      else {
        localAmqpsMessage.acknowledge(AmqpsMessage.ACK_TYPE.COMPLETE);
      }
      log.d("Removing message from amqp map of messages to acknowledge ({})", paramMessage);
      sendAckMessages.remove(paramMessage);
      return true;
    }
    log.a("Amqp connection cannot send ack for this iot hub message because it has no mapping from it to any amqp message ({})", paramMessage);
    return false;
  }
  
  public void setListener(IotHubListener paramIotHubListener)
  {
    if (paramIotHubListener != null)
    {
      listener = paramIotHubListener;
      return;
    }
    throw new IllegalArgumentException("listener cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsIotHubConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */