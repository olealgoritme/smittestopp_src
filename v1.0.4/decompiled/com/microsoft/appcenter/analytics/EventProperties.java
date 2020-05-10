package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventProperties
{
  public static final String VALUE_NULL_ERROR_MESSAGE = "Property value cannot be null";
  public final Map<String, TypedProperty> mProperties = new ConcurrentHashMap();
  
  private boolean isValidKey(String paramString)
  {
    if (paramString == null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Property key must not be null");
      return false;
    }
    if (mProperties.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Property \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\" is already set and will be overridden.");
      AppCenterLog.warn("AppCenterAnalytics", localStringBuilder.toString());
    }
    return true;
  }
  
  private boolean isValidValue(Object paramObject)
  {
    if (paramObject == null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Property value cannot be null");
      return false;
    }
    return true;
  }
  
  public Map<String, TypedProperty> getProperties()
  {
    return mProperties;
  }
  
  public EventProperties set(String paramString, double paramDouble)
  {
    if (isValidKey(paramString)) {
      if ((!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble)))
      {
        DoubleTypedProperty localDoubleTypedProperty = new DoubleTypedProperty();
        localDoubleTypedProperty.setName(paramString);
        localDoubleTypedProperty.setValue(paramDouble);
        mProperties.put(paramString, localDoubleTypedProperty);
      }
      else
      {
        AppCenterLog.error("AppCenterAnalytics", "Double property value cannot be NaN or infinite.");
      }
    }
    return this;
  }
  
  public EventProperties set(String paramString, long paramLong)
  {
    if (isValidKey(paramString))
    {
      LongTypedProperty localLongTypedProperty = new LongTypedProperty();
      localLongTypedProperty.setName(paramString);
      localLongTypedProperty.setValue(paramLong);
      mProperties.put(paramString, localLongTypedProperty);
    }
    return this;
  }
  
  public EventProperties set(String paramString1, String paramString2)
  {
    if ((isValidKey(paramString1)) && (isValidValue(paramString2)))
    {
      StringTypedProperty localStringTypedProperty = new StringTypedProperty();
      localStringTypedProperty.setName(paramString1);
      localStringTypedProperty.setValue(paramString2);
      mProperties.put(paramString1, localStringTypedProperty);
    }
    return this;
  }
  
  public EventProperties set(String paramString, Date paramDate)
  {
    if ((isValidKey(paramString)) && (isValidValue(paramDate)))
    {
      DateTimeTypedProperty localDateTimeTypedProperty = new DateTimeTypedProperty();
      localDateTimeTypedProperty.setName(paramString);
      localDateTimeTypedProperty.setValue(paramDate);
      mProperties.put(paramString, localDateTimeTypedProperty);
    }
    return this;
  }
  
  public EventProperties set(String paramString, boolean paramBoolean)
  {
    if (isValidKey(paramString))
    {
      BooleanTypedProperty localBooleanTypedProperty = new BooleanTypedProperty();
      localBooleanTypedProperty.setName(paramString);
      localBooleanTypedProperty.setValue(paramBoolean);
      mProperties.put(paramString, localBooleanTypedProperty);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.EventProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */