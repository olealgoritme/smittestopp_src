package com.microsoft.identity.client;

public class PublicClientApplication$10
  extends PublicClientApplication.AccountMatcher
{
  public PublicClientApplication$10(PublicClientApplication paramPublicClientApplication)
  {
    super(paramPublicClientApplication);
  }
  
  public boolean matches(String paramString, IAccount paramIAccount)
  {
    return paramString.contains(paramIAccount.getId());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */