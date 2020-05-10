package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.ResponseMessage;
import java.util.Map;

public abstract interface IotHubTransportManager
{
  public abstract void close();
  
  public abstract void open();
  
  public abstract void open(String[] paramArrayOfString);
  
  public abstract Message receive();
  
  public abstract ResponseMessage send(IotHubTransportMessage paramIotHubTransportMessage, Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.IotHubTransportManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */