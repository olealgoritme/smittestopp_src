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
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ICacheRecord localICacheRecord = (ICacheRecord)paramList.next();
      if (localICacheRecord.getAccount().getHomeAccountId().contains(localICacheRecord.getAccount().getLocalAccountId())) {
        localArrayList.add(localICacheRecord);
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AccountAdapter.HomeAccountFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */