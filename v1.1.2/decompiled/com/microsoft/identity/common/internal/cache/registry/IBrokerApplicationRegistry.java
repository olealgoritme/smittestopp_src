package com.microsoft.identity.common.internal.cache.registry;

import com.microsoft.identity.common.internal.cache.ISimpleCache;

public abstract interface IBrokerApplicationRegistry
  extends ISimpleCache<BrokerApplicationRegistryData>
{
  public abstract BrokerApplicationRegistryData getMetadata(String paramString1, String paramString2, int paramInt);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.registry.IBrokerApplicationRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */