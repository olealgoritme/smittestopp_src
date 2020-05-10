package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import java.util.List;

public abstract interface IMultipleAccountPublicClientApplication
  extends IPublicClientApplication
{
  public abstract void acquireToken(Activity paramActivity, String[] paramArrayOfString, String paramString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, IAccount paramIAccount, String paramString);
  
  public abstract void acquireTokenSilentAsync(String[] paramArrayOfString, IAccount paramIAccount, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback);
  
  public abstract IAccount getAccount(String paramString);
  
  public abstract void getAccount(String paramString, GetAccountCallback paramGetAccountCallback);
  
  public abstract List<IAccount> getAccounts();
  
  public abstract void getAccounts(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback);
  
  public abstract void removeAccount(IAccount paramIAccount, RemoveAccountCallback paramRemoveAccountCallback);
  
  public abstract boolean removeAccount(IAccount paramIAccount);
  
  public static abstract interface GetAccountCallback
    extends TaskCompletedCallbackWithError<IAccount, MsalException>
  {
    public abstract void onError(MsalException paramMsalException);
    
    public abstract void onTaskCompleted(IAccount paramIAccount);
  }
  
  public static abstract interface RemoveAccountCallback
  {
    public abstract void onError(MsalException paramMsalException);
    
    public abstract void onRemoved();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IMultipleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */