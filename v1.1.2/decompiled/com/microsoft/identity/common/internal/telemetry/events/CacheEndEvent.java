package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.cache.CacheRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.telemetry.Properties;
import com.microsoft.identity.common.internal.util.StringUtil;

public class CacheEndEvent
  extends BaseEvent
{
  public CacheEndEvent()
  {
    names("cache_end_event");
    types("Microsoft.MSAL.cache_event");
  }
  
  public CacheEndEvent putAtStatus(String paramString)
  {
    put("Microsoft.MSAL.at_status", paramString);
    return this;
  }
  
  public CacheEndEvent putCacheRecordStatus(CacheRecord paramCacheRecord)
  {
    if (paramCacheRecord == null) {
      return this;
    }
    Object localObject = paramCacheRecord.getAccessToken();
    String str = "false";
    if (localObject == null) {
      localObject = "false";
    } else {
      localObject = "true";
    }
    put("Microsoft.MSAL.at_status", (String)localObject);
    if (paramCacheRecord.getRefreshToken() != null)
    {
      put("Microsoft.MSAL.mrrt_status", "true");
      put("Microsoft.MSAL.rt_status", "true");
      if (StringUtil.isEmpty(paramCacheRecord.getRefreshToken().getFamilyId())) {
        localObject = "false";
      } else {
        localObject = "true";
      }
      put("Microsoft.MSAL.frt_status", (String)localObject);
    }
    else
    {
      put("Microsoft.MSAL.rt_status", "false");
    }
    if (paramCacheRecord.getIdToken() == null) {
      localObject = "false";
    } else {
      localObject = "true";
    }
    put("Microsoft.MSAL.id_token_status", (String)localObject);
    if (paramCacheRecord.getV1IdToken() == null) {
      localObject = "false";
    } else {
      localObject = "true";
    }
    put("Microsoft.MSAL.v1_id_token_status", (String)localObject);
    if (paramCacheRecord.getAccount() == null) {
      paramCacheRecord = str;
    } else {
      paramCacheRecord = "true";
    }
    put("Microsoft.MSAL.account_status", paramCacheRecord);
    EstsTelemetry.getInstance().emit(getProperties());
    return this;
  }
  
  public CacheEndEvent putFrtStatus(String paramString)
  {
    put("Microsoft.MSAL.frt_status", paramString);
    return this;
  }
  
  public CacheEndEvent putRtStatus(String paramString)
  {
    put("Microsoft.MSAL.rt_status", paramString);
    return this;
  }
  
  public CacheEndEvent putSpeInfo(String paramString)
  {
    put("Microsoft.MSAL.spe_info", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.events.CacheEndEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */