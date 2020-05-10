package com.microsoft.identity.common.internal.result;

import android.os.Bundle;
import com.microsoft.identity.common.exception.BaseException;

public abstract interface IBrokerResultAdapter
{
  public abstract ILocalAuthenticationResult authenticationResultFromBundle(Bundle paramBundle);
  
  public abstract Bundle bundleFromAuthenticationResult(ILocalAuthenticationResult paramILocalAuthenticationResult);
  
  public abstract Bundle bundleFromBaseException(BaseException paramBaseException);
  
  public abstract BaseException getBaseExceptionFromBundle(Bundle paramBundle);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.result.IBrokerResultAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */