package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import java.util.List;

public abstract interface AccountAdapter$CacheRecordFilter
{
  public abstract List<ICacheRecord> filter(List<ICacheRecord> paramList);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AccountAdapter.CacheRecordFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */