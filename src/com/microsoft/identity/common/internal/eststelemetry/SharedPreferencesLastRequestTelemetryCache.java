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
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          mSharedPreferencesFileManager.putString(str, (String)localObject);
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
      Map localMap = mSharedPreferencesFileManager.getAll();
      if ((localMap != null) && (!localMap.isEmpty()))
      {
        Object localObject1 = (String)localMap.get("schema_version");
        localObject2 = new com/microsoft/identity/common/internal/eststelemetry/RequestTelemetry;
        int i = 0;
        ((RequestTelemetry)localObject2).<init>((String)localObject1, false);
        String[] arrayOfString = Schema.getCommonFields(false);
        localObject1 = Schema.getPlatformFields(false);
        int j = arrayOfString.length;
        String str;
        for (int k = 0; k < j; k++)
        {
          str = arrayOfString[k];
          ((RequestTelemetry)localObject2).putTelemetry(str, (String)localMap.get(str));
        }
        j = localObject1.length;
        for (k = i; k < j; k++)
        {
          str = localObject1[k];
          ((RequestTelemetry)localObject2).putTelemetry(str, (String)localMap.get(str));
        }
        return (RequestTelemetry)localObject2;
      }
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":getRequestTelemetryFromCache");
      Logger.verbose(((StringBuilder)localObject2).toString(), "Last Request telemetry not found in cache. ");
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
 * Qualified Name:     base.com.microsoft.identity.common.internal.eststelemetry.SharedPreferencesLastRequestTelemetryCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */