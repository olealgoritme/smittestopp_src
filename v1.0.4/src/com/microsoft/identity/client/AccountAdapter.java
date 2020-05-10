package com.microsoft.identity.client;

import android.util.Pair;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountAdapter
{
  public static final String TAG = "AccountAdapter";
  public static final AccountAdapter.CacheRecordFilter guestAccountsWithNoHomeTenantAccountFilter = new AccountAdapter.1();
  
  public static List<IAccount> adapt(List<ICacheRecord> paramList)
  {
    List localList1 = filterCacheRecords(paramList, new AccountAdapter.HomeAccountFilter(null));
    List localList2 = filterCacheRecords(paramList, new AccountAdapter.GuestAccountFilter(null));
    paramList = filterCacheRecords(paramList, guestAccountsWithNoHomeTenantAccountFilter);
    localList2.removeAll(paramList);
    localList1 = createRootAccounts(localList1);
    appendChildren(localList1, localList2);
    localList1.addAll(createIAccountsForGuestsNotSignedIntoHomeTenant(paramList));
    return localList1;
  }
  
  public static void appendChildren(List<IAccount> paramList, List<ICacheRecord> paramList1)
  {
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      IAccount localIAccount = (IAccount)localIterator1.next();
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = paramList1.iterator();
      while (localIterator2.hasNext())
      {
        ICacheRecord localICacheRecord = (ICacheRecord)localIterator2.next();
        if (localICacheRecord.getAccount().getHomeAccountId().contains(localIAccount.getId()))
        {
          paramList = new TenantProfile(null, getIdToken(localICacheRecord));
          localHashMap.put(localICacheRecord.getAccount().getRealm(), paramList);
        }
      }
      ((MultiTenantAccount)localIAccount).setTenantProfiles(localHashMap);
    }
  }
  
  public static List<IAccount> createIAccountsForGuestsNotSignedIntoHomeTenant(List<ICacheRecord> paramList)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (ICacheRecord)paramList.next();
      localObject3 = ((ICacheRecord)localObject2).getAccount().getHomeAccountId();
      if (((HashMap)localObject1).get(localObject3) == null) {
        ((HashMap)localObject1).put(localObject3, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(localObject3)).add(localObject2);
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = new MultiTenantAccount(null, null);
      ((Account)localObject2).setId((String)getTenantInfogetKeyfirst);
      ((Account)localObject2).setTenantId((String)getTenantInfogetKeysecond);
      ((Account)localObject2).setEnvironment(((ICacheRecord)((List)((Map.Entry)localObject4).getValue()).get(0)).getAccount().getEnvironment());
      localObject3 = new HashMap();
      Iterator localIterator = ((List)((Map.Entry)localObject4).getValue()).iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (ICacheRecord)localIterator.next();
        ((HashMap)localObject3).put(((ICacheRecord)localObject4).getAccount().getRealm(), new TenantProfile(null, getIdToken((ICacheRecord)localObject4)));
      }
      ((MultiTenantAccount)localObject2).setTenantProfiles((Map)localObject3);
      paramList.add(localObject2);
    }
    return paramList;
  }
  
  public static List<IAccount> createRootAccounts(List<ICacheRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ICacheRecord localICacheRecord = (ICacheRecord)localIterator.next();
      paramList = new MultiTenantAccount(localICacheRecord.getAccount().getClientInfo(), getIdToken(localICacheRecord));
      paramList.setTenantId((String)getTenantInfogetAccountgetHomeAccountIdsecond);
      paramList.setEnvironment(localICacheRecord.getAccount().getEnvironment());
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  public static List<ICacheRecord> filterCacheRecords(List<ICacheRecord> paramList, AccountAdapter.CacheRecordFilter paramCacheRecordFilter)
  {
    return paramCacheRecordFilter.filter(paramList);
  }
  
  public static AccountRecord getAccountInternal(String paramString1, OAuth2TokenCache paramOAuth2TokenCache, String paramString2, String paramString3)
  {
    boolean bool = StringUtil.isEmpty(paramString2);
    Object localObject = null;
    if (!bool)
    {
      paramString1 = paramOAuth2TokenCache.getAccount(null, paramString1, paramString2, paramString3);
    }
    else
    {
      Logger.warn(TAG, "homeAccountIdentifier was null or empty -- invalid criteria");
      paramString1 = (String)localObject;
    }
    return paramString1;
  }
  
  public static IDToken getIdToken(ICacheRecord paramICacheRecord)
  {
    if (paramICacheRecord.getIdToken() != null)
    {
      paramICacheRecord = paramICacheRecord.getIdToken().getSecret();
    }
    else
    {
      if (paramICacheRecord.getV1IdToken() == null) {
        break label63;
      }
      paramICacheRecord = paramICacheRecord.getV1IdToken().getSecret();
    }
    try
    {
      paramICacheRecord = new IDToken(paramICacheRecord);
      return paramICacheRecord;
    }
    catch (ServiceException paramICacheRecord)
    {
      throw new IllegalStateException("Failed to restore IdToken");
    }
    label63:
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AccountAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */