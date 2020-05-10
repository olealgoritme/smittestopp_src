package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;

public enum Prompt
{
  static
  {
    LOGIN = new Prompt("LOGIN", 1);
    CONSENT = new Prompt("CONSENT", 2);
    Prompt localPrompt = new Prompt("WHEN_REQUIRED", 3);
    WHEN_REQUIRED = localPrompt;
    $VALUES = new Prompt[] { SELECT_ACCOUNT, LOGIN, CONSENT, localPrompt };
  }
  
  public Prompt() {}
  
  public OpenIdConnectPromptParameter toOpenIdConnectPromptParameter()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Prompt.class.getSimpleName());
    ((StringBuilder)localObject).append(":toOpenIdConnectPromptParameter");
    localObject = ((StringBuilder)localObject).toString();
    int i = ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return OpenIdConnectPromptParameter.SELECT_ACCOUNT;
          }
          Logger.info((String)localObject, "WHEN_REQUIRED Does not have corresponding value in in the OIDC prompt enumeration.  It's meant to convey do not sent the prompt parameter.");
          throw new UnsupportedOperationException("WHEN_REQUIRED Does not have corresponding value in in the OIDC prompt enumeration.  It's meant to convey do not sent the prompt parameter.");
        }
        return OpenIdConnectPromptParameter.CONSENT;
      }
      return OpenIdConnectPromptParameter.LOGIN;
    }
    return OpenIdConnectPromptParameter.SELECT_ACCOUNT;
  }
  
  public String toString()
  {
    int i = ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            return "WHEN_REQUIRED".toLowerCase();
          }
          throw new IllegalArgumentException();
        }
        return "CONSENT".toLowerCase();
      }
      return "LOGIN".toLowerCase();
    }
    return "SELECT_ACCOUNT".toLowerCase();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.Prompt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */