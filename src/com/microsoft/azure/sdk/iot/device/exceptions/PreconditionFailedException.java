package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class PreconditionFailedException
  extends IotHubServiceException
{
  public PreconditionFailedException() {}
  
  public PreconditionFailedException(String paramString)
  {
    super(paramString);
  }
  
  public PreconditionFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public PreconditionFailedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.PRECONDITION_FAILED;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.PreconditionFailedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */