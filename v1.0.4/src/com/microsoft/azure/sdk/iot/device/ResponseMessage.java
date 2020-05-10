package com.microsoft.azure.sdk.iot.device;

public final class ResponseMessage
  extends Message
{
  public IotHubStatusCode status;
  
  public ResponseMessage(byte[] paramArrayOfByte, IotHubStatusCode paramIotHubStatusCode)
  {
    super(paramArrayOfByte);
    if (paramIotHubStatusCode != null)
    {
      status = paramIotHubStatusCode;
      return;
    }
    throw new IllegalArgumentException("Null status");
  }
  
  public IotHubStatusCode getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.ResponseMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */