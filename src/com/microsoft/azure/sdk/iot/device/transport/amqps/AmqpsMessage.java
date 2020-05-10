package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.MessageType;
import k.a.b.a.b.k.r;
import k.a.b.a.b.k.s;
import k.a.b.a.d.e;

public class AmqpsMessage
  extends k.a.b.a.f.d.a
{
  public e _delivery;
  public MessageType amqpsMessageType;
  public DeviceClientConfig deviceClientConfig;
  
  public void acknowledge(AmqpsMessage.ACK_TYPE paramACK_TYPE)
  {
    int i = paramACK_TYPE.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          _delivery.a(new r());
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid ack type given. Type ");
          localStringBuilder.append(paramACK_TYPE);
          localStringBuilder.append(" does not exist.");
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      else {
        _delivery.a(s.a);
      }
    }
    else {
      _delivery.a(k.a.b.a.b.k.a.a);
    }
    _delivery.R();
  }
  
  public MessageType getAmqpsMessageType()
  {
    return amqpsMessageType;
  }
  
  public DeviceClientConfig getDeviceClientConfig()
  {
    return deviceClientConfig;
  }
  
  public void setAmqpsMessageType(MessageType paramMessageType)
  {
    amqpsMessageType = paramMessageType;
  }
  
  public void setDelivery(e parame)
  {
    _delivery = parame;
  }
  
  public void setDeviceClientConfig(DeviceClientConfig paramDeviceClientConfig)
  {
    deviceClientConfig = paramDeviceClientConfig;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */