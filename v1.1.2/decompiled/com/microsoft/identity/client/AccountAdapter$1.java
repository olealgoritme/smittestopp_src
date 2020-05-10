package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AccountAdapter$1
  implements AccountAdapter.CacheRecordFilter
{
  private boolean hasNoCorrespondingHomeAccount(ICacheRecord paramICacheRecord, final List<ICacheRecord> paramList)
  {
    paramICacheRecord = paramICacheRecord.getAccount().getHomeAccountId();
     ^  {};
  }
  
  public List<ICacheRecord> filter(List<ICacheRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = AccountAdapter.access$100(paramList, new AccountAdapter.HomeAccountFilter(null));
    paramList = AccountAdapter.access$100(paramList, new AccountAdapter.GuestAccountFilter(null)).iterator();
    while (paramList.hasNext())
    {
      ICacheRecord localICacheRecord = (ICacheRecord)paramList.next();
      if (hasNoCorrespondingHomeAccount(localICacheRecord, localList)) {
        localArrayList.add(localICacheRecord);
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AccountAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */