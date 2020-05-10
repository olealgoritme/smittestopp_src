package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.exceptions.DeviceClientException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubReceiveTask;
import com.microsoft.azure.sdk.iot.device.transport.IotHubSendTask;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransport;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l.f.b;
import l.f.c;

public final class DeviceIO
{
  public static final b log = c.a(DeviceIO.class);
  public DeviceClientConfig config;
  public List<DeviceClientConfig> deviceClientConfigs;
  public IotHubClientProtocol protocol = null;
  public long receivePeriodInMilliseconds;
  public IotHubReceiveTask receiveTask = null;
  public long sendPeriodInMilliseconds;
  public IotHubSendTask sendTask = null;
  public IotHubClientState state;
  public ScheduledExecutorService taskScheduler;
  public IotHubTransport transport;
  
  public DeviceIO(DeviceClientConfig paramDeviceClientConfig, long paramLong1, long paramLong2)
  {
    Object localObject = new LinkedList();
    deviceClientConfigs = ((List)localObject);
    if (paramDeviceClientConfig != null)
    {
      ((List)localObject).add(paramDeviceClientConfig);
      config = paramDeviceClientConfig;
      localObject = paramDeviceClientConfig.getProtocol();
      protocol = ((IotHubClientProtocol)localObject);
      sendPeriodInMilliseconds = paramLong1;
      receivePeriodInMilliseconds = paramLong2;
      state = IotHubClientState.CLOSED;
      if ((localObject == IotHubClientProtocol.AMQPS_WS) || (localObject == IotHubClientProtocol.MQTT_WS)) {
        config.setUseWebsocket(true);
      }
      transport = new IotHubTransport(paramDeviceClientConfig);
      sendPeriodInMilliseconds = paramLong1;
      receivePeriodInMilliseconds = paramLong2;
      state = IotHubClientState.CLOSED;
      return;
    }
    throw new IllegalArgumentException("Config cannot be null.");
  }
  
  private void commonOpenSetup()
  {
    sendTask = new IotHubSendTask(transport);
    receiveTask = new IotHubReceiveTask(transport);
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(2);
    taskScheduler = localScheduledExecutorService;
    localScheduledExecutorService.scheduleAtFixedRate(sendTask, 0L, sendPeriodInMilliseconds, TimeUnit.MILLISECONDS);
    taskScheduler.scheduleAtFixedRate(receiveTask, 0L, receivePeriodInMilliseconds, TimeUnit.MILLISECONDS);
    state = IotHubClientState.OPEN;
  }
  
  public void addClient(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      deviceClientConfigs.add(paramDeviceClientConfig);
      return;
    }
    throw new IllegalArgumentException("Config cannot be null");
  }
  
  public void close()
  {
    ScheduledExecutorService localScheduledExecutorService = taskScheduler;
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.shutdown();
    }
    try
    {
      transport.close(IotHubConnectionStatusChangeReason.CLIENT_CLOSE, null);
      state = IotHubClientState.CLOSED;
      return;
    }
    catch (DeviceClientException localDeviceClientException)
    {
      state = IotHubClientState.CLOSED;
      throw new IOException(localDeviceClientException);
    }
  }
  
  public IotHubClientProtocol getProtocol()
  {
    return protocol;
  }
  
  public long getReceivePeriodInMilliseconds()
  {
    return receivePeriodInMilliseconds;
  }
  
  public long getSendPeriodInMilliseconds()
  {
    return sendPeriodInMilliseconds;
  }
  
  public boolean isEmpty()
  {
    return transport.isEmpty();
  }
  
  public boolean isOpen()
  {
    boolean bool;
    if (state == IotHubClientState.OPEN) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void multiplexClose()
  {
    close();
  }
  
  public void open()
  {
    if (state == IotHubClientState.OPEN) {
      return;
    }
    try
    {
      transport.open(deviceClientConfigs);
      commonOpenSetup();
      return;
    }
    catch (DeviceClientException localDeviceClientException)
    {
      throw new IOException("Could not open the connection", localDeviceClientException);
    }
  }
  
  public void registerConnectionStateCallback(IotHubConnectionStateCallback paramIotHubConnectionStateCallback, Object paramObject)
  {
    transport.registerConnectionStateCallback(paramIotHubConnectionStateCallback, paramObject);
  }
  
  public void registerConnectionStatusChangeCallback(IotHubConnectionStatusChangeCallback paramIotHubConnectionStatusChangeCallback, Object paramObject)
  {
    transport.registerConnectionStatusChangeCallback(paramIotHubConnectionStatusChangeCallback, paramObject);
  }
  
  public void sendEventAsync(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject, String paramString)
  {
    try
    {
      if (state != IotHubClientState.CLOSED)
      {
        if (paramMessage != null)
        {
          if (paramString != null) {
            paramMessage.setConnectionDeviceId(paramString);
          }
          transport.addMessage(paramMessage, paramIotHubEventCallback, paramObject);
          return;
        }
        paramMessage = new java/lang/IllegalArgumentException;
        paramMessage.<init>("Cannot send message 'null'.");
        throw paramMessage;
      }
      paramMessage = new java/lang/IllegalStateException;
      paramMessage.<init>("Cannot send event from an IoT Hub client that is closed.");
      throw paramMessage;
    }
    finally {}
  }
  
  public void setReceivePeriodInMilliseconds(long paramLong)
  {
    if (paramLong > 0L)
    {
      receivePeriodInMilliseconds = paramLong;
      ScheduledExecutorService localScheduledExecutorService = taskScheduler;
      if (localScheduledExecutorService != null)
      {
        IotHubReceiveTask localIotHubReceiveTask = receiveTask;
        if (localIotHubReceiveTask != null) {
          localScheduledExecutorService.scheduleAtFixedRate(localIotHubReceiveTask, 0L, paramLong, TimeUnit.MILLISECONDS);
        } else {
          throw new IOException("transport receive task not set");
        }
      }
      return;
    }
    throw new IllegalArgumentException("receive interval can not be zero or negative");
  }
  
  public void setSendPeriodInMilliseconds(long paramLong)
  {
    if (paramLong > 0L)
    {
      sendPeriodInMilliseconds = paramLong;
      ScheduledExecutorService localScheduledExecutorService = taskScheduler;
      if (localScheduledExecutorService != null)
      {
        IotHubSendTask localIotHubSendTask = sendTask;
        if (localIotHubSendTask != null) {
          localScheduledExecutorService.scheduleAtFixedRate(localIotHubSendTask, 0L, paramLong, TimeUnit.MILLISECONDS);
        } else {
          throw new IOException("transport send task not set");
        }
      }
      return;
    }
    throw new IllegalArgumentException("send interval can not be zero or negative");
  }
  
  public static enum IotHubClientState
  {
    static
    {
      IotHubClientState localIotHubClientState = new IotHubClientState("CLOSED", 1);
      CLOSED = localIotHubClientState;
      $VALUES = new IotHubClientState[] { OPEN, localIotHubClientState };
    }
    
    public IotHubClientState() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceIO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */