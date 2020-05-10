package com.microsoft.azure.sdk.iot.deps.transport.amqp;

public abstract interface AmqpListener
{
  public abstract void connectionEstablished();
  
  public abstract void connectionLost();
  
  public abstract void messageReceived(AmqpMessage paramAmqpMessage);
  
  public abstract void messageSent();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */