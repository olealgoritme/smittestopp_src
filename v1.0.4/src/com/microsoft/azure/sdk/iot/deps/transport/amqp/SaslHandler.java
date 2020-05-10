package com.microsoft.azure.sdk.iot.deps.transport.amqp;

public abstract interface SaslHandler
{
  public abstract String chooseSaslMechanism(String[] paramArrayOfString);
  
  public abstract byte[] getInitPayload(String paramString);
  
  public abstract String getPlainPassword();
  
  public abstract String getPlainUsername();
  
  public abstract byte[] handleChallenge(byte[] paramArrayOfByte);
  
  public abstract void handleOutcome(SaslHandler.SaslOutcome paramSaslOutcome);
  
  public abstract void setSasToken(String paramString);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.SaslHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */