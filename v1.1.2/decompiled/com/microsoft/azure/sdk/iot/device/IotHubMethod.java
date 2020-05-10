package com.microsoft.azure.sdk.iot.device;

public enum IotHubMethod
{
  static
  {
    IotHubMethod localIotHubMethod = new IotHubMethod("POST", 1);
    POST = localIotHubMethod;
    $VALUES = new IotHubMethod[] { GET, localIotHubMethod };
  }
  
  public IotHubMethod() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */