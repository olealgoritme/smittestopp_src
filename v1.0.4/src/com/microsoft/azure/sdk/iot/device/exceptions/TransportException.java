package com.microsoft.azure.sdk.iot.device.exceptions;

public class TransportException
  extends DeviceClientException
{
  public TransportException.IotHubService iotHubService = TransportException.IotHubService.NOT_APPLICABLE;
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
  
  public TransportException.IotHubService getIotHubService()
  {
    return iotHubService;
  }
  
  public boolean isRetryable()
  {
    return isRetryable;
  }
  
  public void setIotHubService(TransportException.IotHubService paramIotHubService)
  {
    iotHubService = paramIotHubService;
  }
  
  public void setRetryable(boolean paramBoolean)
  {
    isRetryable = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.TransportException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */