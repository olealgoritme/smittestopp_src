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
  public static final CacheRecordFilter guestAccountsWithNoHomeTenantAccountFilter = new CacheRecordFilter()
  {
    private boolean hasNoCorrespondingHomeAccount(ICacheRecord paramAnonymousICacheRecord, final List<ICacheRecord> paramAnonymousList)
    {
      paramAnonymousICacheRecord = paramAnonymousICacheRecord.getAccount().getHomeAccountId();
       ^  {};
    }
    
    public List<ICacheRecord> filter(List<ICacheRecord> paramAnonymousList)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = AccountAdapter.access$100(paramAnonymousList, new AccountAdapter.HomeAccountFilter(null));
      paramAnonymousList = AccountAdapter.access$100(paramAnonymousList, new AccountAdapter.GuestAccountFilter(null)).iterator();
      while (paramAnonymousList.hasNext())
      {
        ICacheRecord localICacheRecord = (ICacheRecord)paramAnonymousList.next();
        if (hasNoCorrespondingHomeAccount(localICacheRecord, localList)) {
          localArrayList.add(localICacheRecord);
        }
      }
      return localArrayList;
    }
  };
  
  public static List<IAccount> adapt(List<ICacheRecord> paramList)
  {
    List localList1 = filterCacheRecords(paramList, new HomeAccountFilter(null));
    List localList2 = filterCacheRecords(paramList, new GuestAccountFilter(null));
    paramList = filterCacheRecords(paramList, guestAccountsWithNoHomeTenantAccountFilter);
    localList2.removeAll(paramList);
    localList1 = createRootAccounts(localList1);
    appendChildren(localList1, localList2);
    localList1.addAll(createIAccountsForGuestsNotSignedIntoHomeTenant(paramList));
    return localList1;
  }
  
  public static void appendChildren(List<IAccount> paramList, List<ICacheRecord> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IAccount localIAccount = (IAccount)paramList.next();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        ICacheRecord localICacheRecord = (ICacheRecord)localIterator.next();
        if (localICacheRecord.getAccount().getHomeAccountId().contains(localIAccount.getId()))
        {
          TenantProfile localTenantProfile = new TenantProfile(null, getIdToken(localICacheRecord));
          localHashMap.put(localICacheRecord.getAccount().getRealm(), localTenantProfile);
        }
      }
      ((MultiTenantAccount)localIAccount).setTenantProfiles(localHashMap);
    }
  }
  
  public static List<IAccount> createIAccountsForGuestsNotSignedIntoHomeTenant(List<ICacheRecord> paramList)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      paramList = (ICacheRecord)((Iterator)localObject2).next();
      localObject3 = paramList.getAccount().getHomeAccountId();
      if (((HashMap)localObject1).get(localObject3) == null) {
        ((HashMap)localObject1).put(localObject3, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(localObject3)).add(paramList);
    }
    paramList = new ArrayList();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = new MultiTenantAccount(null, null);
      ((Account)localObject3).setId((String)getTenantInfogetKeyfirst);
      ((Account)localObject3).setTenantId((String)getTenantInfogetKeysecond);
      ((Account)localObject3).setEnvironment(((ICacheRecord)((List)((Map.Entry)localObject4).getValue()).get(0)).getAccount().getEnvironment());
      localObject2 = new HashMap();
      localObject4 = ((List)((Map.Entry)localObject4).getValue()).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ICacheRecord localICacheRecord = (ICacheRecord)((Iterator)localObject4).next();
        ((HashMap)localObject2).put(localICacheRecord.getAccount().getRealm(), new TenantProfile(null, getIdToken(localICacheRecord)));
      }
      ((MultiTenantAccount)localObject3).setTenantProfiles((Map)localObject2);
      paramList.add(localObject3);
    }
    return paramList;
  }
  
  public static List<IAccount> createRootAccounts(List<ICacheRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ICacheRecord localICacheRecord = (ICacheRecord)paramList.next();
      MultiTenantAccount localMultiTenantAccount = new MultiTenantAccount(localICacheRecord.getAccount().getClientInfo(), getIdToken(localICacheRecord));
      localMultiTenantAccount.setTenantId((String)getTenantInfogetAccountgetHomeAccountIdsecond);
      localMultiTenantAccount.setEnvironment(localICacheRecord.getAccount().getEnvironment());
      localArrayList.add(localMultiTenantAccount);
    }
    return localArrayList;
  }
  
  public static List<ICacheRecord> filterCacheRecords(List<ICacheRecord> paramList, CacheRecordFilter paramCacheRecordFilter)
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
  
  public static abstract interface CacheRecordFilter
  {
    public abstract List<ICacheRecord> filter(List<ICacheRecord> paramList);
  }
  
  public static class GuestAccountFilter
    implements AccountAdapter.CacheRecordFilter
  {
    public List<ICacheRecord> filter(List<ICacheRecord> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ICacheRecord localICacheRecord = (ICacheRecord)paramList.next();
        if (!localICacheRecord.getAccount().getHomeAccountId().contains(localICacheRecord.getAccount().getLocalAccountId())) {
          localArrayList.add(localICacheRecord);
        }
      }
      return localArrayList;
    }
  }
  
  public static class HomeAccountFilter
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AccountAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */