package com.microsoft.appcenter.analytics;

import android.content.Context;
import android.provider.Settings.Secure;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.AppExtension;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.DeviceExtension;
import com.microsoft.appcenter.ingestion.models.one.Extensions;
import com.microsoft.appcenter.ingestion.models.one.UserExtension;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PropertyConfigurator
  extends AbstractChannelListener
{
  public static final String ANDROID_DEVICE_ID_PREFIX = "a:";
  public String mAppLocale;
  public String mAppName;
  public String mAppVersion;
  public boolean mDeviceIdEnabled;
  public final EventProperties mEventProperties = new EventProperties();
  public final AnalyticsTransmissionTarget mTransmissionTarget;
  public String mUserId;
  
  public PropertyConfigurator(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget)
  {
    mTransmissionTarget = paramAnalyticsTransmissionTarget;
  }
  
  private String getAppLocale()
  {
    return mAppLocale;
  }
  
  private String getAppName()
  {
    return mAppName;
  }
  
  private String getAppVersion()
  {
    return mAppVersion;
  }
  
  private String getUserId()
  {
    return mUserId;
  }
  
  private boolean shouldOverridePartAProperties(Log paramLog)
  {
    if ((paramLog instanceof CommonSchemaLog))
    {
      paramLog = paramLog.getTag();
      AnalyticsTransmissionTarget localAnalyticsTransmissionTarget = mTransmissionTarget;
      if ((paramLog == localAnalyticsTransmissionTarget) && (localAnalyticsTransmissionTarget.isEnabled())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public void collectDeviceId()
  {
    Analytics.getInstance().postCommandEvenIfDisabled(new PropertyConfigurator.5(this));
  }
  
  public void mergeEventProperties(EventProperties paramEventProperties)
  {
    try
    {
      Iterator localIterator = mEventProperties.getProperties().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if (!paramEventProperties.getProperties().containsKey(str)) {
          paramEventProperties.getProperties().put(str, localEntry.getValue());
        }
      }
      return;
    }
    finally {}
  }
  
  public void onPreparingLog(Log paramLog, String paramString)
  {
    if (shouldOverridePartAProperties(paramLog))
    {
      paramLog = (CommonSchemaLog)paramLog;
      Object localObject1 = paramLog.getExt().getApp();
      Object localObject2 = paramLog.getExt().getUser();
      paramString = paramLog.getExt().getDevice();
      paramLog = mAppName;
      String str;
      if (paramLog != null)
      {
        ((AppExtension)localObject1).setName(paramLog);
      }
      else
      {
        paramLog = mTransmissionTarget;
        do
        {
          paramLog = mParentTarget;
          if (paramLog == null) {
            break;
          }
          str = paramLog.getPropertyConfigurator().getAppName();
        } while (str == null);
        ((AppExtension)localObject1).setName(str);
      }
      paramLog = mAppVersion;
      if (paramLog != null)
      {
        ((AppExtension)localObject1).setVer(paramLog);
      }
      else
      {
        paramLog = mTransmissionTarget;
        do
        {
          paramLog = mParentTarget;
          if (paramLog == null) {
            break;
          }
          str = paramLog.getPropertyConfigurator().getAppVersion();
        } while (str == null);
        ((AppExtension)localObject1).setVer(str);
      }
      paramLog = mAppLocale;
      if (paramLog != null)
      {
        ((AppExtension)localObject1).setLocale(paramLog);
      }
      else
      {
        paramLog = mTransmissionTarget;
        do
        {
          paramLog = mParentTarget;
          if (paramLog == null) {
            break;
          }
          str = paramLog.getPropertyConfigurator().getAppLocale();
        } while (str == null);
        ((AppExtension)localObject1).setLocale(str);
      }
      paramLog = mUserId;
      if (paramLog != null)
      {
        ((UserExtension)localObject2).setLocalId(paramLog);
      }
      else
      {
        paramLog = mTransmissionTarget;
        do
        {
          paramLog = mParentTarget;
          if (paramLog == null) {
            break;
          }
          localObject1 = paramLog.getPropertyConfigurator().getUserId();
        } while (localObject1 == null);
        ((UserExtension)localObject2).setLocalId((String)localObject1);
      }
      if (mDeviceIdEnabled)
      {
        paramLog = Settings.Secure.getString(mTransmissionTarget.mContext.getContentResolver(), "android_id");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("a:");
        ((StringBuilder)localObject2).append(paramLog);
        paramString.setLocalId(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void removeEventProperty(String paramString)
  {
    try
    {
      mEventProperties.getProperties().remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAppLocale(String paramString)
  {
    Analytics.getInstance().postCommandEvenIfDisabled(new PropertyConfigurator.3(this, paramString));
  }
  
  public void setAppName(String paramString)
  {
    Analytics.getInstance().postCommandEvenIfDisabled(new PropertyConfigurator.1(this, paramString));
  }
  
  public void setAppVersion(String paramString)
  {
    Analytics.getInstance().postCommandEvenIfDisabled(new PropertyConfigurator.2(this, paramString));
  }
  
  public void setEventProperty(String paramString, double paramDouble)
  {
    try
    {
      mEventProperties.set(paramString, paramDouble);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setEventProperty(String paramString, long paramLong)
  {
    try
    {
      mEventProperties.set(paramString, paramLong);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setEventProperty(String paramString1, String paramString2)
  {
    try
    {
      mEventProperties.set(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void setEventProperty(String paramString, Date paramDate)
  {
    try
    {
      mEventProperties.set(paramString, paramDate);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setEventProperty(String paramString, boolean paramBoolean)
  {
    try
    {
      mEventProperties.set(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setUserId(String paramString)
  {
    if (UserIdContext.checkUserIdValidForOneCollector(paramString)) {
      Analytics.getInstance().postCommandEvenIfDisabled(new PropertyConfigurator.4(this, paramString));
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.PropertyConfigurator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */