package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.exception.MsalException;

public abstract interface ISingleAccountPublicClientApplication
  extends IPublicClientApplication
{
  public abstract IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, String paramString);
  
  public abstract void acquireTokenSilentAsync(String[] paramArrayOfString, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback);
  
  public abstract ICurrentAccountResult getCurrentAccount();
  
  public abstract void getCurrentAccountAsync(CurrentAccountCallback paramCurrentAccountCallback);
  
  public abstract void signIn(Activity paramActivity, String paramString, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract void signOut(SignOutCallback paramSignOutCallback);
  
  public abstract boolean signOut();
  
  public static abstract interface CurrentAccountCallback
  {
    public abstract void onAccountChanged(IAccount paramIAccount1, IAccount paramIAccount2);
    
    public abstract void onAccountLoaded(IAccount paramIAccount);
    
    public abstract void onError(MsalException paramMsalException);
  }
  
  public static abstract interface SignOutCallback
  {
    public abstract void onError(MsalException paramMsalException);
    
    public abstract void onSignOut();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.ISingleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */