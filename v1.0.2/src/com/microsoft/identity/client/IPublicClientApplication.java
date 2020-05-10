package com.microsoft.identity.client;

import android.app.Activity;

public abstract interface IPublicClientApplication
{
  public abstract void acquireToken(Activity paramActivity, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback);
  
  public abstract void acquireToken(AcquireTokenParameters paramAcquireTokenParameters);
  
  public abstract IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters paramAcquireTokenSilentParameters);
  
  public abstract void acquireTokenSilentAsync(AcquireTokenSilentParameters paramAcquireTokenSilentParameters);
  
  public abstract PublicClientApplicationConfiguration getConfiguration();
  
  public abstract boolean isSharedDevice();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */