package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public final class DeviceMethod$deviceMethodRequestMessageCallback
  implements IotHubEventCallback
{
  public DeviceMethod$deviceMethodRequestMessageCallback(DeviceMethod paramDeviceMethod) {}
  
  public void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject)
  {
    if (DeviceMethod.access$400(this$0) != null) {
      DeviceMethod.access$400(this$0).execute(paramIotHubStatusCode, DeviceMethod.access$300(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethod.deviceMethodRequestMessageCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */