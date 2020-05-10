package com.microsoft.identity.client;

import java.io.Serializable;

public abstract interface IAccount
  extends Serializable, IClaimable
{
  public abstract String getAuthority();
  
  public abstract String getId();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */