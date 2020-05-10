package com.microsoft.azure.sdk.iot.device.DeviceTwin;

public class DeviceMethodData
{
  public String responseMessage;
  public int status;
  
  public DeviceMethodData(int paramInt, String paramString)
  {
    status = paramInt;
    responseMessage = paramString;
  }
  
  public String getResponseMessage()
  {
    return responseMessage;
  }
  
  public int getStatus()
  {
    return status;
  }
  
  public void setResponseMessage(String paramString)
  {
    responseMessage = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    status = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */