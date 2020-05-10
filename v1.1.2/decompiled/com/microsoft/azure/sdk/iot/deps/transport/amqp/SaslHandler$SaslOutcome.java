package com.microsoft.azure.sdk.iot.deps.transport.amqp;

public enum SaslHandler$SaslOutcome
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
  
  public SaslHandler$SaslOutcome() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.SaslHandler.SaslOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */