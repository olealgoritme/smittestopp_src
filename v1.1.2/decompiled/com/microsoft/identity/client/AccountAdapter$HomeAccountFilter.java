package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountAdapter$HomeAccountFilter
  implements AccountAdapter.CacheRecordFilter
{
  public List<ICacheRecord> filter(List<ICacheRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ICacheRecord)localIterator.next();
      if (paramList.getAccount().getHomeAccountId().contains(paramList.getAccount().getLocalAccountId())) {
        localArrayList.add(paramList);
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AccountAdapter.HomeAccountFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */