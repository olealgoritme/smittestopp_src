package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class ServerBusyException
  extends IotHubServiceException
{
  public ServerBusyException()
  {
    isRetryable = true;
  }
  
  public ServerBusyException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public ServerBusyException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public ServerBusyException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.SERVER_BUSY;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.ServerBusyException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */