package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public final class DeviceTwin$deviceTwinRequestMessageCallback
  implements IotHubEventCallback
{
  public DeviceTwin$deviceTwinRequestMessageCallback(DeviceTwin paramDeviceTwin) {}
  
  public void execute(IotHubStatusCode paramIotHubStatusCode, Object arg2)
  {
    synchronized (DeviceTwin.access$000(this$0))
    {
      if ((paramIotHubStatusCode != IotHubStatusCode.OK) && (paramIotHubStatusCode != IotHubStatusCode.OK_EMPTY)) {
        DeviceTwin.access$200(this$0).execute(paramIotHubStatusCode, DeviceTwin.access$100(this$0));
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceTwin.deviceTwinRequestMessageCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */