package com.microsoft.azure.sdk.iot.device.exceptions;

public class IotHubSizeExceededException
  extends IotHubException
{
  public IotHubSizeExceededException()
  {
    this(null);
  }
  
  public IotHubSizeExceededException(String paramString)
  {
    super(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.IotHubSizeExceededException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */