package com.microsoft.azure.sdk.iot.deps.transport.amqp;

public abstract interface SaslHandler
{
  public abstract String chooseSaslMechanism(String[] paramArrayOfString);
  
  public abstract byte[] getInitPayload(String paramString);
  
  public abstract String getPlainPassword();
  
  public abstract String getPlainUsername();
  
  public abstract byte[] handleChallenge(byte[] paramArrayOfByte);
  
  public abstract void handleOutcome(SaslOutcome paramSaslOutcome);
  
  public abstract void setSasToken(String paramString);
  
  public static enum SaslOutcome
  {
    static
    {
      AUTH = new SaslOutcome("AUTH", 1);
      SYS = new SaslOutcome("SYS", 2);
      SYS_PERM = new SaslOutcome("SYS_PERM", 3);
      SaslOutcome localSaslOutcome = new SaslOutcome("SYS_TEMP", 4);
      SYS_TEMP = localSaslOutcome;
      $VALUES = new SaslOutcome[] { OK, AUTH, SYS, SYS_PERM, localSaslOutcome };
    }
    
    public SaslOutcome() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.SaslHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */