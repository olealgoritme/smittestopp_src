package com.microsoft.azure.sdk.iot.device;

public enum IotHubConnectionStatusChangeReason
{
  static
  {
    BAD_CREDENTIAL = new IotHubConnectionStatusChangeReason("BAD_CREDENTIAL", 1);
    RETRY_EXPIRED = new IotHubConnectionStatusChangeReason("RETRY_EXPIRED", 2);
    NO_NETWORK = new IotHubConnectionStatusChangeReason("NO_NETWORK", 3);
    COMMUNICATION_ERROR = new IotHubConnectionStatusChangeReason("COMMUNICATION_ERROR", 4);
    CONNECTION_OK = new IotHubConnectionStatusChangeReason("CONNECTION_OK", 5);
    IotHubConnectionStatusChangeReason localIotHubConnectionStatusChangeReason = new IotHubConnectionStatusChangeReason("CLIENT_CLOSE", 6);
    CLIENT_CLOSE = localIotHubConnectionStatusChangeReason;
    $VALUES = new IotHubConnectionStatusChangeReason[] { EXPIRED_SAS_TOKEN, BAD_CREDENTIAL, RETRY_EXPIRED, NO_NETWORK, COMMUNICATION_ERROR, CONNECTION_OK, localIotHubConnectionStatusChangeReason };
  }
  
  public IotHubConnectionStatusChangeReason() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */