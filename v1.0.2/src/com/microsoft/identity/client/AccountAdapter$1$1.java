package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountAdapter$1$1
  extends ArrayList<String>
{
  public AccountAdapter$1$1(AccountAdapter.1 param1, List paramList)
  {
    param1 = val$homeRecords.iterator();
    while (param1.hasNext()) {
      add(((ICacheRecord)param1.next()).getAccount().getHomeAccountId());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AccountAdapter.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */