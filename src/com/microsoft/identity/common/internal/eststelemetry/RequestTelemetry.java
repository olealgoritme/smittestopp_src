package com.microsoft.identity.common.internal.eststelemetry;

import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RequestTelemetry
{
  public static final String TAG = "RequestTelemetry";
  public ConcurrentMap<String, String> mCommonTelemetry;
  public boolean mIsCurrentRequest;
  public ConcurrentMap<String, String> mPlatformTelemetry;
  public String mSchemaVersion;
  
  public RequestTelemetry(String paramString, boolean paramBoolean)
  {
    mIsCurrentRequest = paramBoolean;
    mSchemaVersion = paramString;
    mCommonTelemetry = new ConcurrentHashMap();
    mPlatformTelemetry = new ConcurrentHashMap();
  }
  
  public RequestTelemetry(boolean paramBoolean)
  {
    this("1", paramBoolean);
  }
  
  private String getCommonTelemetryHeaderString()
  {
    return getTelemetryHeaderStringFromFields(Schema.getCommonFields(mIsCurrentRequest), mCommonTelemetry);
  }
  
  private String getPlatformTelemetryHeaderString()
  {
    return getTelemetryHeaderStringFromFields(Schema.getPlatformFields(mIsCurrentRequest), mPlatformTelemetry);
  }
  
  private String getTelemetryHeaderStringFromFields(String[] paramArrayOfString, Map<String, String> paramMap)
  {
    if ((paramArrayOfString != null) && (paramMap != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        localStringBuilder.append(Schema.getSchemaCompliantString((String)paramMap.get(paramArrayOfString[i])));
        if (i != paramArrayOfString.length - 1) {
          localStringBuilder.append(',');
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void putInCommonTelemetry(String paramString1, String paramString2)
  {
    mCommonTelemetry.putIfAbsent(paramString1, paramString2);
  }
  
  private void putInPlatformTelemetry(String paramString1, String paramString2)
  {
    mPlatformTelemetry.putIfAbsent(paramString1, paramString2);
  }
  
  public void clearTelemetry()
  {
    mCommonTelemetry.clear();
    mPlatformTelemetry.clear();
  }
  
  public Map<String, String> getCommonTelemetry()
  {
    return mCommonTelemetry;
  }
  
  public String getCompleteTelemetryHeaderString()
  {
    if (StringUtil.isEmpty(mSchemaVersion))
    {
      a.b(new StringBuilder(), TAG, ":getCompleteTelemetryHeaderString", "SCHEMA_VERSION is null or empty. Telemetry Header String cannot be formed.");
      return null;
    }
    String str1 = Schema.getSchemaCompliantString(mSchemaVersion);
    String str2 = getCommonTelemetryHeaderString();
    String str3 = getPlatformTelemetryHeaderString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(str2);
    localStringBuilder.append("|");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> getPlatformTelemetry()
  {
    return mPlatformTelemetry;
  }
  
  public String getSchemaVersion()
  {
    return mSchemaVersion;
  }
  
  public void putTelemetry(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramString2 = Schema.getSchemaCompliantString(paramString2);
    if (Schema.isCommonField(paramString1, mIsCurrentRequest)) {
      putInCommonTelemetry(paramString1, paramString2);
    } else if (Schema.isPlatformField(paramString1, mIsCurrentRequest)) {
      putInPlatformTelemetry(paramString1, paramString2);
    } else {
      a.b(new StringBuilder(), TAG, ":putTelemetry", "Supplied key not added to Server telemetry map as it is not part of either common or platform schema.");
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.eststelemetry.RequestTelemetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */