package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.transport.RetryPolicy;
import java.util.ArrayList;
import k.f.b;
import k.f.c;

public class TransportClient
{
  public static long RECEIVE_PERIOD_MILLIS_AMQPS = 10L;
  public static long SEND_PERIOD_MILLIS;
  public static final b log = c.a(TransportClient.class);
  public ArrayList<DeviceClient> deviceClientList;
  public DeviceIO deviceIO;
  public IotHubClientProtocol iotHubClientProtocol;
  public TransportClient.TransportClientState transportClientState;
  
  static
  {
    SEND_PERIOD_MILLIS = 10L;
  }
  
  public TransportClient(IotHubClientProtocol paramIotHubClientProtocol)
  {
    int i = paramIotHubClientProtocol.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label72;
        }
        if (i != 3)
        {
          if (i == 4) {
            break label72;
          }
          throw new IllegalStateException("Invalid client protocol specified.");
        }
      }
      iotHubClientProtocol = paramIotHubClientProtocol;
      deviceIO = null;
      deviceClientList = new ArrayList();
      transportClientState = TransportClient.TransportClientState.CLOSED;
      return;
    }
    label72:
    throw new IllegalArgumentException("Multiplexing is only supported for AMQPS and AMQPS_WS");
  }
  
  public void closeNow()
  {
    for (int i = 0; i < deviceClientList.size(); i++) {
      ((DeviceClient)deviceClientList.get(i)).closeFileUpload();
    }
    DeviceIO localDeviceIO = deviceIO;
    if (localDeviceIO != null)
    {
      localDeviceIO.multiplexClose();
      deviceIO = null;
    }
    log.c("Transport client closed successfully");
  }
  
  public IotHubClientProtocol getIotHubClientProtocol()
  {
    return iotHubClientProtocol;
  }
  
  public TransportClient.TransportClientState getTransportClientState()
  {
    return transportClientState;
  }
  
  public void open()
  {
    DeviceIO localDeviceIO = deviceIO;
    if ((localDeviceIO != null) && (localDeviceIO.isOpen())) {
      throw new IllegalStateException("The transport client connection is already open.");
    }
    if (deviceClientList.size() > 0)
    {
      deviceIO = new DeviceIO(((DeviceClient)deviceClientList.get(0)).getConfig(), SEND_PERIOD_MILLIS, RECEIVE_PERIOD_MILLIS_AMQPS);
      ((DeviceClient)deviceClientList.get(0)).setDeviceIO(deviceIO);
      for (int i = 1; i < deviceClientList.size(); i++)
      {
        ((DeviceClient)deviceClientList.get(i)).setDeviceIO(deviceIO);
        deviceIO.addClient(((DeviceClient)deviceClientList.get(i)).getConfig());
      }
      deviceIO.open();
    }
    transportClientState = TransportClient.TransportClientState.OPENED;
    log.c("Transport client opened successfully");
  }
  
  public void registerDeviceClient(DeviceClient paramDeviceClient)
  {
    if (paramDeviceClient != null)
    {
      DeviceIO localDeviceIO = deviceIO;
      if ((localDeviceIO != null) && (localDeviceIO.isOpen())) {
        throw new IllegalStateException("deviceClient cannot be registered if the connection is open.");
      }
      deviceClientList.add(paramDeviceClient);
      log.b("DeviceClient instance successfully added to the transport client");
      return;
    }
    throw new IllegalArgumentException("deviceClient parameter cannot be null.");
  }
  
  public void setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    if (deviceClientList.size() != 0)
    {
      for (int i = 0; i < deviceClientList.size(); i++) {
        ((DeviceClient)deviceClientList.get(i)).getConfig().setRetryPolicy(paramRetryPolicy);
      }
      log.b("Retry policy updated successfully in the transport client");
      return;
    }
    throw new UnsupportedOperationException("TransportClient.setRetryPolicy only works when there is at least one registered device client.");
  }
  
  public void setSendInterval(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (transportClientState == TransportClient.TransportClientState.OPENED)
      {
        DeviceIO localDeviceIO = deviceIO;
        if (localDeviceIO != null)
        {
          localDeviceIO.setSendPeriodInMilliseconds(paramLong);
          log.b("Send interval updated successfully in the transport client");
          return;
        }
      }
      throw new IllegalStateException("TransportClient.setSendInterval only works when the transport client is opened");
    }
    throw new IllegalArgumentException("send interval can not be zero or negative");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.TransportClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */