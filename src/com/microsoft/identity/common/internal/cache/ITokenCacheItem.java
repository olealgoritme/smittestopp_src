package com.microsoft.identity.common.internal.cache;

public abstract interface ITokenCacheItem
{
  public abstract String getAuthority();
  
  public abstract String getClientId();
  
  public abstract String getRefreshToken();
  
  public abstract String getResource();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.ITokenCacheItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */