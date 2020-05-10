package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.MessageType;
import l.a.b.a.f.d.a;

public class AmqpsConvertToProtonReturnValue
{
  public a messageImpl;
  public MessageType messageType;
  
  public AmqpsConvertToProtonReturnValue(a parama, MessageType paramMessageType)
  {
    messageImpl = parama;
    messageType = paramMessageType;
  }
  
  public a getMessageImpl()
  {
    return messageImpl;
  }
  
  public MessageType getMessageType()
  {
    return messageType;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsConvertToProtonReturnValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */