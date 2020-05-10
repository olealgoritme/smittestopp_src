package com.microsoft.identity.client;

import android.app.Activity;

public abstract interface ISingleAccountPublicClientApplication
  extends IPublicClientApplication
{
  public abstract IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, String paramString);
  
  public abstract void acquireTokenSilentAsync(String[] paramArrayOfString, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback);
  
  public abstract ICurrentAccountResult getCurrentAccount();
  
  public abstract void getCurrentAccountAsync(ISingleAccountPublicClientApplication.CurrentAccountCallback paramCurrentAccountCallback);
  
  public abstract void signIn(Activity paramActivity, String paramString, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract void signOut(ISingleAccountPublicClientApplication.SignOutCallback paramSignOutCallback);
  
  public abstract boolean signOut();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.ISingleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */