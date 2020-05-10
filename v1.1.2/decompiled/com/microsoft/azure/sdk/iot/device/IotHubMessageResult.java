package com.microsoft.azure.sdk.iot.device;

public enum IotHubMessageResult
{
  static
  {
    ABANDON = new IotHubMessageResult("ABANDON", 1);
    IotHubMessageResult localIotHubMessageResult = new IotHubMessageResult("REJECT", 2);
    REJECT = localIotHubMessageResult;
    $VALUES = new IotHubMessageResult[] { COMPLETE, ABANDON, localIotHubMessageResult };
  }
  
  public IotHubMessageResult() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubMessageResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */