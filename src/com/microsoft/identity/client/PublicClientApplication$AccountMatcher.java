package com.microsoft.identity.client;

public class PublicClientApplication$AccountMatcher
{
  public final AccountMatcher[] mDelegateMatchers;
  
  public PublicClientApplication$AccountMatcher(PublicClientApplication paramPublicClientApplication)
  {
    mDelegateMatchers = new AccountMatcher[0];
  }
  
  public PublicClientApplication$AccountMatcher(PublicClientApplication paramPublicClientApplication, AccountMatcher... paramVarArgs)
  {
    mDelegateMatchers = paramVarArgs;
  }
  
  public boolean matches(String paramString, IAccount paramIAccount)
  {
    AccountMatcher[] arrayOfAccountMatcher = mDelegateMatchers;
    int i = arrayOfAccountMatcher.length;
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      bool = arrayOfAccountMatcher[j].matches(paramString, paramIAccount);
      if (bool) {
        break;
      }
      j++;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplication.AccountMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */