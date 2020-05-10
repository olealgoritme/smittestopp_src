package com.microsoft.identity.client;

import android.app.Activity;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import java.util.List;

public abstract interface IPublicClientApplication
{
  public abstract void acquireToken(Activity paramActivity, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract void acquireToken(AcquireTokenParameters paramAcquireTokenParameters);
  
  public abstract IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters paramAcquireTokenSilentParameters);
  
  public abstract void acquireTokenSilentAsync(AcquireTokenSilentParameters paramAcquireTokenSilentParameters);
  
  public abstract PublicClientApplicationConfiguration getConfiguration();
  
  public abstract boolean isSharedDevice();
  
  public static abstract interface ApplicationCreatedListener
  {
    public abstract void onCreated(IPublicClientApplication paramIPublicClientApplication);
    
    public abstract void onError(MsalException paramMsalException);
  }
  
  public static abstract interface IMultipleAccountApplicationCreatedListener
  {
    public abstract void onCreated(IMultipleAccountPublicClientApplication paramIMultipleAccountPublicClientApplication);
    
    public abstract void onError(MsalException paramMsalException);
  }
  
  public static abstract interface ISingleAccountApplicationCreatedListener
  {
    public abstract void onCreated(ISingleAccountPublicClientApplication paramISingleAccountPublicClientApplication);
    
    public abstract void onError(MsalException paramMsalException);
  }
  
  public static abstract interface LoadAccountsCallback
    extends TaskCompletedCallbackWithError<List<IAccount>, MsalException>
  {
    public abstract void onError(MsalException paramMsalException);
    
    public abstract void onTaskCompleted(List<IAccount> paramList);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */