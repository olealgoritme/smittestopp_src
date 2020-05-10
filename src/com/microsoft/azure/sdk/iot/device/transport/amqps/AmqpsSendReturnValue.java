package com.microsoft.azure.sdk.iot.device.transport.amqps;

public class AmqpsSendReturnValue
{
  public int deliveryHash;
  public boolean deliverySuccessful;
  public byte[] deliveryTag;
  public byte[] failedDeliveryTag;
  
  public AmqpsSendReturnValue(boolean paramBoolean, int paramInt)
  {
    byte[] arrayOfByte = "-1".getBytes();
    failedDeliveryTag = arrayOfByte;
    deliverySuccessful = paramBoolean;
    deliveryHash = paramInt;
    deliveryTag = arrayOfByte;
  }
  
  public AmqpsSendReturnValue(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    failedDeliveryTag = "-1".getBytes();
    deliverySuccessful = paramBoolean;
    deliveryHash = paramInt;
    deliveryTag = paramArrayOfByte;
  }
  
  public int getDeliveryHash()
  {
    return deliveryHash;
  }
  
  public byte[] getDeliveryTag()
  {
    return deliveryTag;
  }
  
  public boolean isDeliverySuccessful()
  {
    return deliverySuccessful;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsSendReturnValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */