package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.MessageType;
import l.a.b.a.b.k.r;
import l.a.b.a.b.k.s;
import l.a.b.a.d.e;

public class AmqpsMessage
  extends l.a.b.a.f.d.a
{
  public e _delivery;
  public MessageType amqpsMessageType;
  public DeviceClientConfig deviceClientConfig;
  
  public void acknowledge(ACK_TYPE paramACK_TYPE)
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
      _delivery.a(l.a.b.a.b.k.a.a);
    }
    _delivery.x();
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
  
  public static enum ACK_TYPE
  {
    static
    {
      ABANDON = new ACK_TYPE("ABANDON", 1);
      ACK_TYPE localACK_TYPE = new ACK_TYPE("REJECT", 2);
      REJECT = localACK_TYPE;
      $VALUES = new ACK_TYPE[] { COMPLETE, ABANDON, localACK_TYPE };
    }
    
    public ACK_TYPE() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */