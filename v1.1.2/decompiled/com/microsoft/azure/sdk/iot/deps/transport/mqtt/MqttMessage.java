package com.microsoft.azure.sdk.iot.deps.transport.mqtt;

import l.c.a.a.a.l;

public class MqttMessage
{
  public byte[] payload;
  public MqttQos qos = MqttQos.DELIVER_UNKNOWN;
  public String topic;
  
  public MqttMessage(String paramString)
  {
    topic = paramString;
  }
  
  public MqttMessage(String paramString, l paraml)
  {
    if (paraml != null)
    {
      topic = paramString;
      payload = b;
      int i = c;
      if (i == 0) {
        qos = MqttQos.DELIVER_AT_MOST_ONCE;
      } else if (i == 2) {
        qos = MqttQos.DELIVER_EXACTLY_ONCE;
      } else if (i == 3) {
        qos = MqttQos.DELIVER_AT_LEAST_ONCE;
      } else {
        qos = MqttQos.DELIVER_FAILURE;
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public MqttMessage(String paramString, byte[] paramArrayOfByte)
  {
    topic = paramString;
    payload = paramArrayOfByte;
  }
  
  public static int retrieveQosValue(MqttQos paramMqttQos)
  {
    int i;
    if (paramMqttQos == MqttQos.DELIVER_AT_MOST_ONCE) {
      i = 0;
    } else if (paramMqttQos == MqttQos.DELIVER_AT_LEAST_ONCE) {
      i = 1;
    } else if (paramMqttQos == MqttQos.DELIVER_EXACTLY_ONCE) {
      i = 2;
    } else {
      i = 128;
    }
    return i;
  }
  
  public l getMqttMessage()
  {
    l locall = new l();
    Object localObject = payload;
    if (localObject != null) {
      locall.a((byte[])localObject);
    }
    localObject = qos;
    if (localObject != MqttQos.DELIVER_UNKNOWN) {
      locall.a(retrieveQosValue((MqttQos)localObject));
    }
    return locall;
  }
  
  public byte[] getPayload()
  {
    return payload;
  }
  
  public MqttQos getQos()
  {
    return qos;
  }
  
  public String getTopic()
  {
    return topic;
  }
  
  public void setPayload(byte[] paramArrayOfByte)
  {
    payload = paramArrayOfByte;
  }
  
  public void setQos(MqttQos paramMqttQos)
  {
    qos = paramMqttQos;
  }
  
  public void setTopic(String paramString)
  {
    topic = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.mqtt.MqttMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */