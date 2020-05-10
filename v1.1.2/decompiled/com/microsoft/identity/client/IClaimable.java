package com.microsoft.identity.client;

import java.util.Map;

public abstract interface IClaimable
{
  public abstract Map<String, ?> getClaims();
  
  public abstract String getIdToken();
  
  public abstract String getTenantId();
  
  public abstract String getUsername();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IClaimable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */