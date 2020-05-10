package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;

public abstract interface IShareSingleSignOnState<T extends BaseAccount, U extends RefreshToken>
{
  public abstract U getSingleSignOnState(T paramT);
  
  public abstract void setSingleSignOnState(T paramT, U paramU);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.IShareSingleSignOnState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */