package com.microsoft.azure.sdk.iot.device;

public enum DeviceClientConfig$AuthType
{
  static
  {
    AuthType localAuthType = new AuthType("SAS_TOKEN", 1);
    SAS_TOKEN = localAuthType;
    $VALUES = new AuthType[] { X509_CERTIFICATE, localAuthType };
  }
  
  public DeviceClientConfig$AuthType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */