package com.microsoft.azure.sdk.iot.device.exceptions;

public class TransportException
  extends DeviceClientException
{
  public IotHubService iotHubService = IotHubService.NOT_APPLICABLE;
  public boolean isRetryable = false;
  
  public TransportException() {}
  
  public TransportException(String paramString)
  {
    super(paramString);
  }
  
  public TransportException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public TransportException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubService getIotHubService()
  {
    return iotHubService;
  }
  
  public boolean isRetryable()
  {
    return isRetryable;
  }
  
  public void setIotHubService(IotHubService paramIotHubService)
  {
    iotHubService = paramIotHubService;
  }
  
  public void setRetryable(boolean paramBoolean)
  {
    isRetryable = paramBoolean;
  }
  
  public static enum IotHubService
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
    
    public IotHubService() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.exceptions.TransportException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */