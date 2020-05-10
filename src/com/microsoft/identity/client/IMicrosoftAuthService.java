package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;

public abstract interface IMicrosoftAuthService
  extends IInterface
{
  public abstract Bundle acquireTokenSilently(Bundle paramBundle);
  
  public abstract Bundle getAccounts(Bundle paramBundle);
  
  public abstract Bundle getCurrentAccount(Bundle paramBundle);
  
  public abstract Bundle getDeviceMode();
  
  public abstract Intent getIntentForInteractiveRequest();
  
  public abstract Bundle hello(Bundle paramBundle);
  
  public abstract Bundle removeAccount(Bundle paramBundle);
  
  public abstract Bundle removeAccountFromSharedDevice(Bundle paramBundle);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMicrosoftAuthService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */