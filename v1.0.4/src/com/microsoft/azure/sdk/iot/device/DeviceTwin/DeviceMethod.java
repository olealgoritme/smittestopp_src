package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceIO;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.ObjectLock;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import k.f.b;
import k.f.c;

public final class DeviceMethod
{
  public static final b log = c.a(DeviceMethod.class);
  public final ObjectLock DEVICE_METHOD_LOCK = new ObjectLock();
  public DeviceClientConfig config;
  public DeviceIO deviceIO;
  public DeviceMethodCallback deviceMethodCallback;
  public Object deviceMethodCallbackContext;
  public IotHubEventCallback deviceMethodStatusCallback;
  public Object deviceMethodStatusCallbackContext;
  public boolean isSubscribed = false;
  
  public DeviceMethod(DeviceIO paramDeviceIO, DeviceClientConfig paramDeviceClientConfig, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if ((paramDeviceIO != null) && (paramDeviceClientConfig != null))
    {
      if (paramIotHubEventCallback != null)
      {
        deviceIO = paramDeviceIO;
        config = paramDeviceClientConfig;
        deviceMethodStatusCallback = paramIotHubEventCallback;
        deviceMethodStatusCallbackContext = paramObject;
        paramDeviceClientConfig.setDeviceMethodsMessageCallback(new DeviceMethod.deviceMethodResponseCallback(this, null), null);
        return;
      }
      throw new IllegalArgumentException("Status call back cannot be null");
    }
    throw new IllegalArgumentException("Client or config cannot be null");
  }
  
  public void subscribeToDeviceMethod(DeviceMethodCallback paramDeviceMethodCallback, Object paramObject)
  {
    if (paramDeviceMethodCallback != null)
    {
      deviceMethodCallback = paramDeviceMethodCallback;
      deviceMethodCallbackContext = paramObject;
      if (!isSubscribed)
      {
        paramDeviceMethodCallback = MessageType.DEVICE_METHODS;
        paramDeviceMethodCallback = new IotHubTransportMessage(new byte[0], paramDeviceMethodCallback);
        paramDeviceMethodCallback.setDeviceOperationType(DeviceOperations.DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST);
        paramDeviceMethodCallback.setConnectionDeviceId(config.getDeviceId());
        deviceIO.sendEventAsync(paramDeviceMethodCallback, new DeviceMethod.deviceMethodRequestMessageCallback(this, null), null, config.getDeviceId());
      }
      return;
    }
    throw new IllegalArgumentException("Callback cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */