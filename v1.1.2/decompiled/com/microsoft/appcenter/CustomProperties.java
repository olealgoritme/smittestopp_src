package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomProperties
{
  public static final Pattern KEY_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]*$");
  public static final int MAX_PROPERTIES_COUNT = 60;
  public static final int MAX_PROPERTY_KEY_LENGTH = 128;
  public static final int MAX_PROPERTY_VALUE_LENGTH = 128;
  public static final String VALUE_NULL_ERROR_MESSAGE = "Custom property value cannot be null, did you mean to call clear?";
  public final Map<String, Object> mProperties = new HashMap();
  
  private void addProperty(String paramString, Object paramObject)
  {
    if ((!mProperties.containsKey(paramString)) && (mProperties.size() >= 60)) {
      AppCenterLog.error("AppCenter", "Custom properties cannot contain more than 60 items");
    } else {
      mProperties.put(paramString, paramObject);
    }
  }
  
  private boolean isValidKey(String paramString)
  {
    if ((paramString != null) && (KEY_PATTERN.matcher(paramString).matches()))
    {
      if (paramString.length() > 128)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Custom property \"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\" length cannot be longer than ");
        localStringBuilder.append(128);
        localStringBuilder.append(" characters.");
        AppCenterLog.error("AppCenter", localStringBuilder.toString());
        return false;
      }
      if (mProperties.containsKey(paramString))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Custom property \"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\" is already set or cleared and will be overridden.");
        AppCenterLog.warn("AppCenter", localStringBuilder.toString());
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Custom property \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\" must match \"");
    localStringBuilder.append(KEY_PATTERN);
    localStringBuilder.append("\"");
    AppCenterLog.error("AppCenter", localStringBuilder.toString());
    return false;
  }
  
  private boolean isValidNumberValue(String paramString, Number paramNumber)
  {
    if (paramNumber == null)
    {
      AppCenterLog.error("AppCenter", "Custom property value cannot be null, did you mean to call clear?");
      return false;
    }
    double d = paramNumber.doubleValue();
    if ((!Double.isInfinite(d)) && (!Double.isNaN(d))) {
      return true;
    }
    paramNumber = new StringBuilder();
    paramNumber.append("Custom property \"");
    paramNumber.append(paramString);
    paramNumber.append("\" value cannot be NaN or infinite.");
    AppCenterLog.error("AppCenter", paramNumber.toString());
    return false;
  }
  
  private boolean isValidStringValue(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      AppCenterLog.error("AppCenter", "Custom property value cannot be null, did you mean to call clear?");
      return false;
    }
    if (paramString2.length() > 128)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Custom property \"");
      paramString2.append(paramString1);
      paramString2.append("\" value length cannot be longer than ");
      paramString2.append(128);
      paramString2.append(" characters.");
      AppCenterLog.error("AppCenter", paramString2.toString());
      return false;
    }
    return true;
  }
  
  public CustomProperties clear(String paramString)
  {
    try
    {
      if (isValidKey(paramString)) {
        addProperty(paramString, null);
      }
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Map<String, Object> getProperties()
  {
    try
    {
      HashMap localHashMap = new HashMap(mProperties);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public CustomProperties set(String paramString, Number paramNumber)
  {
    try
    {
      if ((isValidKey(paramString)) && (isValidNumberValue(paramString, paramNumber))) {
        addProperty(paramString, paramNumber);
      }
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public CustomProperties set(String paramString1, String paramString2)
  {
    try
    {
      if ((isValidKey(paramString1)) && (isValidStringValue(paramString1, paramString2))) {
        addProperty(paramString1, paramString2);
      }
      return this;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public CustomProperties set(String paramString, Date paramDate)
  {
    try
    {
      if (isValidKey(paramString)) {
        if (paramDate != null) {
          addProperty(paramString, paramDate);
        } else {
          AppCenterLog.error("AppCenter", "Custom property value cannot be null, did you mean to call clear?");
        }
      }
      return this;
    }
    finally {}
  }
  
  public CustomProperties set(String paramString, boolean paramBoolean)
  {
    try
    {
      if (isValidKey(paramString)) {
        addProperty(paramString, Boolean.valueOf(paramBoolean));
      }
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.CustomProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */