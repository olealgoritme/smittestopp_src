package com.microsoft.identity.common.internal.providers.oauth2;

public enum OpenIdConnectPromptParameter
{
  static
  {
    LOGIN = new OpenIdConnectPromptParameter("LOGIN", 2);
    OpenIdConnectPromptParameter localOpenIdConnectPromptParameter = new OpenIdConnectPromptParameter("CONSENT", 3);
    CONSENT = localOpenIdConnectPromptParameter;
    $VALUES = new OpenIdConnectPromptParameter[] { NONE, SELECT_ACCOUNT, LOGIN, localOpenIdConnectPromptParameter };
  }
  
  public OpenIdConnectPromptParameter() {}
  
  public static OpenIdConnectPromptParameter _fromPromptBehavior(String paramString)
  {
    if ((paramString != null) && (paramString.equals("FORCE_PROMPT"))) {
      paramString = LOGIN;
    } else {
      paramString = NONE;
    }
    return paramString;
  }
  
  public String toString()
  {
    if (this == NONE) {
      return null;
    }
    return name().toLowerCase();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */