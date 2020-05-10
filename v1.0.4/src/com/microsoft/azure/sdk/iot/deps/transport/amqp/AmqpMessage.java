package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import java.nio.ByteBuffer;
import java.util.Map;
import k.a.b.a.b.k.d;
import k.a.b.a.b.k.e;

public class AmqpMessage
{
  public k.a.b.a.f.d.a messageImpl;
  
  public AmqpMessage()
  {
    messageImpl = new k.a.b.a.f.d.a();
  }
  
  public AmqpMessage(k.a.b.a.f.d.a parama)
  {
    messageImpl = parama;
  }
  
  public void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      messageImpl.decode(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new IllegalArgumentException("The data cannot be null.");
  }
  
  public int encode(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null) {
      return messageImpl.encode(paramArrayOfByte, paramInt, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("The data cannot be null.");
  }
  
  public byte[] getAmqpBody()
  {
    k.a.b.a.b.a locala = messageImpl.getBody()).a;
    byte[] arrayOfByte = new byte[c];
    locala.a().get(arrayOfByte);
    return arrayOfByte;
  }
  
  public Map<String, Object> getApplicationProperty()
  {
    d locald = messageImpl.getApplicationProperties();
    if (locald == null) {
      return null;
    }
    return a;
  }
  
  public void setApplicationProperty(Map<String, Object> paramMap)
  {
    paramMap = new d(paramMap);
    messageImpl.setApplicationProperties(paramMap);
  }
  
  public void setBody(e parame)
  {
    messageImpl.setBody(parame);
  }
  
  public void setBody(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new e(new k.a.b.a.b.a(paramArrayOfByte));
    messageImpl.setBody(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */