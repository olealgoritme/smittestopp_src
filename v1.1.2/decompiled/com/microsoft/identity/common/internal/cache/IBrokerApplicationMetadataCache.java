package com.microsoft.identity.common.internal.cache;

import java.util.List;
import java.util.Set;

public abstract interface IBrokerApplicationMetadataCache
  extends ISimpleCache<BrokerApplicationMetadata>
{
  public abstract Set<String> getAllClientIds();
  
  public abstract List<BrokerApplicationMetadata> getAllFociApplicationMetadata();
  
  public abstract Set<String> getAllFociClientIds();
  
  public abstract Set<String> getAllNonFociClientIds();
  
  public abstract BrokerApplicationMetadata getMetadata(String paramString1, String paramString2, int paramInt);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.IBrokerApplicationMetadataCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */