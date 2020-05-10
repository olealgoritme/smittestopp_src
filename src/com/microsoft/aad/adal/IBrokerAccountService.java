package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

public abstract interface IBrokerAccountService
  extends IInterface
{
  public abstract Bundle acquireTokenSilently(Map paramMap);
  
  public abstract Bundle getBrokerUsers();
  
  public abstract Bundle getInactiveBrokerKey(Bundle paramBundle);
  
  public abstract Intent getIntentForInteractiveRequest();
  
  public abstract void removeAccounts();
}

/* Location:
 * Qualified Name:     base.com.microsoft.aad.adal.IBrokerAccountService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */