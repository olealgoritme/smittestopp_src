package com.microsoft.identity.client;

import java.util.Map;

public abstract interface IMultiTenantAccount
  extends IAccount
{
  public abstract Map<String, ITenantProfile> getTenantProfiles();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IMultiTenantAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */