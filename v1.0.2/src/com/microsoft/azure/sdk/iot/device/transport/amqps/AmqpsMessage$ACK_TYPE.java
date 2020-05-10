package com.microsoft.azure.sdk.iot.device.transport.amqps;

public enum AmqpsMessage$ACK_TYPE
{
  static
  {
    ABANDON = new ACK_TYPE("ABANDON", 1);
    ACK_TYPE localACK_TYPE = new ACK_TYPE("REJECT", 2);
    REJECT = localACK_TYPE;
    $VALUES = new ACK_TYPE[] { COMPLETE, ABANDON, localACK_TYPE };
  }
  
  public AmqpsMessage$ACK_TYPE() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsMessage.ACK_TYPE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */