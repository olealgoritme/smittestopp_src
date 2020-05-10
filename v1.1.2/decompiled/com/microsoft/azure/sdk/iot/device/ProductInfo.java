package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;

public class ProductInfo
{
  public String extra = "";
  
  public String getUserAgentString()
  {
    Object localObject = extra;
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TransportUtils.USER_AGENT_STRING);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(extra);
      return ((StringBuilder)localObject).toString();
    }
    return TransportUtils.USER_AGENT_STRING;
  }
  
  public void setExtra(String paramString)
  {
    extra = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.ProductInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */