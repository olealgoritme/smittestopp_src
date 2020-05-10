package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.MessageCallback;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;

public class AmqpsConvertFromProtonReturnValue
{
  public IotHubTransportMessage message;
  public MessageCallback messageCallback;
  public Object messageContext;
  
  public AmqpsConvertFromProtonReturnValue(IotHubTransportMessage paramIotHubTransportMessage, MessageCallback paramMessageCallback, Object paramObject)
  {
    message = paramIotHubTransportMessage;
    messageCallback = paramMessageCallback;
    messageContext = paramObject;
  }
  
  public IotHubTransportMessage getMessage()
  {
    return message;
  }
  
  public MessageCallback getMessageCallback()
  {
    return messageCallback;
  }
  
  public Object getMessageContext()
  {
    return messageContext;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsConvertFromProtonReturnValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */