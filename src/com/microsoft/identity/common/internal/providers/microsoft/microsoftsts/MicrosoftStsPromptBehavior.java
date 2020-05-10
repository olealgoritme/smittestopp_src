package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

public enum MicrosoftStsPromptBehavior
{
  static
  {
    FORCE_LOGIN = new MicrosoftStsPromptBehavior("FORCE_LOGIN", 1);
    MicrosoftStsPromptBehavior localMicrosoftStsPromptBehavior = new MicrosoftStsPromptBehavior("CONSENT", 2);
    CONSENT = localMicrosoftStsPromptBehavior;
    $VALUES = new MicrosoftStsPromptBehavior[] { SELECT_ACCOUNT, FORCE_LOGIN, localMicrosoftStsPromptBehavior };
  }
  
  public MicrosoftStsPromptBehavior() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsPromptBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */