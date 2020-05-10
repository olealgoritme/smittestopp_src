package com.microsoft.identity.client;

import android.app.Activity;
import java.util.List;

public abstract interface IMultipleAccountPublicClientApplication
  extends IPublicClientApplication
{
  public abstract void acquireToken(Activity paramActivity, String[] paramArrayOfString, String paramString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, IAccount paramIAccount, String paramString);
  
  public abstract void acquireTokenSilentAsync(String[] paramArrayOfString, IAccount paramIAccount, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback);
  
  public abstract IAccount getAccount(String paramString);
  
  public abstract void getAccount(String paramString, IMultipleAccountPublicClientApplication.GetAccountCallback paramGetAccountCallback);
  
  public abstract List<IAccount> getAccounts();
  
  public abstract void getAccounts(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback);
  
  public abstract void removeAccount(IAccount paramIAccount, IMultipleAccountPublicClientApplication.RemoveAccountCallback paramRemoveAccountCallback);
  
  public abstract boolean removeAccount(IAccount paramIAccount);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMultipleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */