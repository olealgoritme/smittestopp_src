package com.microsoft.identity.common.internal.eststelemetry;

import android.text.TextUtils;
import com.microsoft.identity.common.internal.cache.ISharedPreferencesFileManager;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferencesLastRequestTelemetryCache
  implements IRequestTelemetryCache
{
  public static final String TAG = "SharedPreferencesLastRequestTelemetryCache";
  public final ISharedPreferencesFileManager mSharedPreferencesFileManager;
  
  public SharedPreferencesLastRequestTelemetryCache(ISharedPreferencesFileManager paramISharedPreferencesFileManager)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileManager = paramISharedPreferencesFileManager;
  }
  
  private void saveTelemetryDataToCache(Map<String, String> paramMap)
  {
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(paramMap)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          mSharedPreferencesFileManager.putString(paramMap, (String)localObject);
        }
      }
      return;
    }
    finally {}
  }
  
  public void clearAll()
  {
    try
    {
      Logger.info(TAG, "Clearing all SharedPreferences entries...");
      mSharedPreferencesFileManager.clear();
      Logger.info(TAG, "SharedPreferences cleared.");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public RequestTelemetry getRequestTelemetryFromCache()
  {
    try
    {
      Object localObject1 = mSharedPreferencesFileManager.getAll();
      if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
      {
        Object localObject3 = (String)((Map)localObject1).get("schema_version");
        RequestTelemetry localRequestTelemetry = new com/microsoft/identity/common/internal/eststelemetry/RequestTelemetry;
        int i = 0;
        localRequestTelemetry.<init>((String)localObject3, false);
        String[] arrayOfString = Schema.getCommonFields(false);
        localObject3 = Schema.getPlatformFields(false);
        int j = arrayOfString.length;
        for (int k = 0; k < j; k++)
        {
          String str = arrayOfString[k];
          localRequestTelemetry.putTelemetry(str, (String)((Map)localObject1).get(str));
        }
        j = localObject3.length;
        for (k = i; k < j; k++)
        {
          arrayOfString = localObject3[k];
          localRequestTelemetry.putTelemetry(arrayOfString, (String)((Map)localObject1).get(arrayOfString));
        }
        return localRequestTelemetry;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(":getRequestTelemetryFromCache");
      Logger.verbose(((StringBuilder)localObject1).toString(), "Last Request telemetry not found in cache. ");
      return null;
    }
    finally {}
  }
  
  public ISharedPreferencesFileManager getSharedPreferencesFileManager()
  {
    return mSharedPreferencesFileManager;
  }
  
  public void saveRequestTelemetryToCache(RequestTelemetry paramRequestTelemetry)
  {
    try
    {
      Logger.verbose(TAG, "Saving Request Telemetry to cache...");
      mSharedPreferencesFileManager.putString("schema_version", "1");
      saveTelemetryDataToCache(paramRequestTelemetry.getCommonTelemetry());
      saveTelemetryDataToCache(paramRequestTelemetry.getPlatformTelemetry());
      return;
    }
    finally
    {
      paramRequestTelemetry = finally;
      throw paramRequestTelemetry;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.eststelemetry.SharedPreferencesLastRequestTelemetryCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */