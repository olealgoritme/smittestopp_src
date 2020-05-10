package com.microsoft.identity.common.internal.eststelemetry;

import android.content.Context;
import android.text.TextUtils;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EstsTelemetry
{
  public static final String LAST_REQUEST_TELEMETRY_SHARED_PREFERENCES = "com.microsoft.identity.client.last_request_telemetry";
  public static final String TAG = "EstsTelemetry";
  public static volatile EstsTelemetry sEstsTelemetryInstance;
  public IRequestTelemetryCache mLastRequestTelemetryCache;
  public Map<String, RequestTelemetry> mTelemetryMap = new ConcurrentHashMap();
  
  private IRequestTelemetryCache createLastRequestTelemetryCache(Context paramContext)
  {
    if (paramContext == null)
    {
      a.b(new StringBuilder(), TAG, ":createLastRequestTelemetryCache", "Context is NULL. Unable to create last request telemetry cache.");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":createLastRequestTelemetryCache");
    Logger.verbose(localStringBuilder.toString(), "Creating Last Request Telemetry Cache");
    return new SharedPreferencesLastRequestTelemetryCache(new SharedPreferencesFileManager(paramContext, "com.microsoft.identity.client.last_request_telemetry"));
  }
  
  private boolean eligibleToCache(RequestTelemetry paramRequestTelemetry)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramRequestTelemetry.getSchemaVersion())) && (!TextUtils.isEmpty((CharSequence)paramRequestTelemetry.getCommonTelemetry().get("Microsoft.MSAL.api_id")))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void emit(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getCurrentTelemetryInstance(paramString1);
    if (paramString1 != null) {
      paramString1.putTelemetry(paramString2, paramString3);
    }
  }
  
  private RequestTelemetry getCurrentTelemetryInstance(String paramString)
  {
    if ((mTelemetryMap != null) && (paramString != null) && (!paramString.equals("UNSET")))
    {
      RequestTelemetry localRequestTelemetry = (RequestTelemetry)mTelemetryMap.get(paramString);
      if (localRequestTelemetry != null) {
        return localRequestTelemetry;
      }
      localRequestTelemetry = new RequestTelemetry(true);
      mTelemetryMap.put(paramString, localRequestTelemetry);
      return localRequestTelemetry;
    }
    return null;
  }
  
  public static EstsTelemetry getInstance()
  {
    try
    {
      if (sEstsTelemetryInstance == null)
      {
        localEstsTelemetry = new com/microsoft/identity/common/internal/eststelemetry/EstsTelemetry;
        localEstsTelemetry.<init>();
        sEstsTelemetryInstance = localEstsTelemetry;
      }
      EstsTelemetry localEstsTelemetry = sEstsTelemetryInstance;
      return localEstsTelemetry;
    }
    finally {}
  }
  
  private RequestTelemetry loadLastRequestTelemetryFromCache()
  {
    IRequestTelemetryCache localIRequestTelemetryCache = mLastRequestTelemetryCache;
    if (localIRequestTelemetryCache == null)
    {
      a.b(new StringBuilder(), TAG, ":loadLastRequestTelemetry", "Last Request Telemetry Cache has not been initialized. Cannot load Last Request Telemetry data from cache.");
      return null;
    }
    return localIRequestTelemetryCache.getRequestTelemetryFromCache();
  }
  
  private RequestTelemetry setupLastFromCurrent(RequestTelemetry paramRequestTelemetry)
  {
    if (paramRequestTelemetry == null) {
      return new RequestTelemetry("1", false);
    }
    RequestTelemetry localRequestTelemetry = new RequestTelemetry(paramRequestTelemetry.getSchemaVersion(), false);
    Iterator localIterator = paramRequestTelemetry.getCommonTelemetry().entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localRequestTelemetry.putTelemetry((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramRequestTelemetry = paramRequestTelemetry.getPlatformTelemetry().entrySet().iterator();
    while (paramRequestTelemetry.hasNext())
    {
      localEntry = (Map.Entry)paramRequestTelemetry.next();
      localRequestTelemetry.putTelemetry((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localRequestTelemetry;
  }
  
  public void emit(String paramString1, String paramString2)
  {
    emit((String)DiagnosticContext.getRequestContext().get("correlation_id"), paramString1, paramString2);
  }
  
  public void emit(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      emit((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public void emitApiId(String paramString)
  {
    emit("Microsoft.MSAL.api_id", paramString);
  }
  
  public void emitForceRefresh(boolean paramBoolean)
  {
    emit("Microsoft.MSAL.force_refresh", Schema.getSchemaCompliantStringFromBoolean(paramBoolean));
  }
  
  public void flush()
  {
    flush((String)DiagnosticContext.getRequestContext().get("correlation_id"));
  }
  
  public void flush(String paramString)
  {
    flush(paramString, null);
  }
  
  public void flush(String paramString, BaseException paramBaseException)
  {
    if (paramBaseException == null) {
      paramBaseException = null;
    } else {
      paramBaseException = paramBaseException.getErrorCode();
    }
    flush(paramString, paramBaseException);
  }
  
  public void flush(String paramString, AcquireTokenResult paramAcquireTokenResult)
  {
    flush(paramString, TelemetryUtils.errorFromAcquireTokenResult(paramAcquireTokenResult));
  }
  
  public void flush(String paramString1, String paramString2)
  {
    Object localObject = mTelemetryMap;
    if ((localObject != null) && (paramString1 != null))
    {
      RequestTelemetry localRequestTelemetry = (RequestTelemetry)((Map)localObject).get(paramString1);
      if (localRequestTelemetry == null) {
        return;
      }
      localObject = setupLastFromCurrent(localRequestTelemetry);
      ((RequestTelemetry)localObject).putTelemetry("Microsoft.MSAL.correlation_id", paramString1);
      ((RequestTelemetry)localObject).putTelemetry("Microsoft.MSAL.api_error_code", paramString2);
      localRequestTelemetry.clearTelemetry();
      mTelemetryMap.remove(paramString1);
      if (mLastRequestTelemetryCache == null)
      {
        a.c(new StringBuilder(), TAG, ":flush", "Last Request Telemetry Cache object was null. Unable to save request telemetry to cache.");
      }
      else if (eligibleToCache((RequestTelemetry)localObject))
      {
        mLastRequestTelemetryCache.clearAll();
        mLastRequestTelemetryCache.saveRequestTelemetryToCache((RequestTelemetry)localObject);
      }
    }
  }
  
  public String getCurrentTelemetryHeaderString()
  {
    Object localObject = (String)DiagnosticContext.getRequestContext().get("correlation_id");
    Map localMap = mTelemetryMap;
    if ((localMap != null) && (localObject != null))
    {
      localObject = (RequestTelemetry)localMap.get(localObject);
      if (localObject == null) {
        return null;
      }
      return ((RequestTelemetry)localObject).getCompleteTelemetryHeaderString();
    }
    return null;
  }
  
  public String getLastTelemetryHeaderString()
  {
    RequestTelemetry localRequestTelemetry = loadLastRequestTelemetryFromCache();
    if (localRequestTelemetry == null) {
      return null;
    }
    return localRequestTelemetry.getCompleteTelemetryHeaderString();
  }
  
  public Map<String, String> getTelemetryHeaders()
  {
    HashMap localHashMap = new HashMap();
    String str1 = getCurrentTelemetryHeaderString();
    String str2 = getLastTelemetryHeaderString();
    if (str1 != null) {
      localHashMap.put("x-client-current-telemetry", str1);
    } else {
      a.b(new StringBuilder(), TAG, ":getTelemetryHeaders", "Current Request Telemetry Header is null");
    }
    if (str2 != null) {
      localHashMap.put("x-client-last-telemetry", str2);
    } else {
      a.b(new StringBuilder(), TAG, ":getTelemetryHeaders", "Last Request Telemetry Header is null");
    }
    return localHashMap;
  }
  
  public void setupLastRequestTelemetryCache(Context paramContext)
  {
    paramContext = createLastRequestTelemetryCache(paramContext);
    mLastRequestTelemetryCache = paramContext;
    if (paramContext != null) {
      Logger.verbose(TAG, "Ests Telemetry cache has been initialized properly.");
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */