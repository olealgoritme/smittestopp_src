package com.microsoft.azure.sdk.iot.device.exceptions;

public enum TransportException$IotHubService
{
  static
  {
    TELEMETRY = new IotHubService("TELEMETRY", 1);
    METHODS = new IotHubService("METHODS", 2);
    FILE_UPLOAD = new IotHubService("FILE_UPLOAD", 3);
    IotHubService localIotHubService = new IotHubService("NOT_APPLICABLE", 4);
    NOT_APPLICABLE = localIotHubService;
    $VALUES = new IotHubService[] { TWIN, TELEMETRY, METHODS, FILE_UPLOAD, localIotHubService };
  }
  
  public TransportException$IotHubService() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.exceptions.TransportException.IotHubService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */