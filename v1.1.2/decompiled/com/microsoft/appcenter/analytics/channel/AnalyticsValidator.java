package com.microsoft.appcenter.analytics.channel;

import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AnalyticsValidator
  extends AbstractChannelListener
{
  public static final int MAX_NAME_LENGTH = 256;
  public static final int MAX_PROPERTY_COUNT = 20;
  public static final int MAX_PROPERTY_ITEM_LENGTH = 125;
  
  public static TypedProperty copyProperty(TypedProperty paramTypedProperty, String paramString)
  {
    Object localObject = paramTypedProperty.getType();
    if ("boolean".equals(localObject))
    {
      localObject = new BooleanTypedProperty();
      ((BooleanTypedProperty)localObject).setValue(((BooleanTypedProperty)paramTypedProperty).getValue());
      paramTypedProperty = (TypedProperty)localObject;
    }
    else if ("dateTime".equals(localObject))
    {
      localObject = new DateTimeTypedProperty();
      ((DateTimeTypedProperty)localObject).setValue(((DateTimeTypedProperty)paramTypedProperty).getValue());
      paramTypedProperty = (TypedProperty)localObject;
    }
    else if ("double".equals(localObject))
    {
      localObject = new DoubleTypedProperty();
      ((DoubleTypedProperty)localObject).setValue(((DoubleTypedProperty)paramTypedProperty).getValue());
      paramTypedProperty = (TypedProperty)localObject;
    }
    else if ("long".equals(localObject))
    {
      localObject = new LongTypedProperty();
      ((LongTypedProperty)localObject).setValue(((LongTypedProperty)paramTypedProperty).getValue());
      paramTypedProperty = (TypedProperty)localObject;
    }
    else
    {
      localObject = new StringTypedProperty();
      ((StringTypedProperty)localObject).setValue(((StringTypedProperty)paramTypedProperty).getValue());
      paramTypedProperty = (TypedProperty)localObject;
    }
    paramTypedProperty.setName(paramString);
    return paramTypedProperty;
  }
  
  private boolean validateLog(EventLog paramEventLog)
  {
    String str = validateName(paramEventLog.getName(), paramEventLog.getType());
    if (str == null) {
      return false;
    }
    validateProperties(paramEventLog.getTypedProperties());
    paramEventLog.setName(str);
    return true;
  }
  
  private boolean validateLog(LogWithNameAndProperties paramLogWithNameAndProperties)
  {
    String str = validateName(paramLogWithNameAndProperties.getName(), paramLogWithNameAndProperties.getType());
    if (str == null) {
      return false;
    }
    Map localMap = validateProperties(paramLogWithNameAndProperties.getProperties(), str, paramLogWithNameAndProperties.getType());
    paramLogWithNameAndProperties.setName(str);
    paramLogWithNameAndProperties.setProperties(localMap);
    return true;
  }
  
  public static String validateName(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      String str = paramString1;
      if (paramString1.length() > 256)
      {
        AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : name length cannot be longer than %s characters. Name will be truncated.", new Object[] { paramString2, paramString1, Integer.valueOf(256) }));
        str = paramString1.substring(0, 256);
      }
      return str;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" name cannot be null or empty.");
    AppCenterLog.error("AppCenterAnalytics", paramString1.toString());
    return null;
  }
  
  public static Map<String, String> validateProperties(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      Object localObject = (String)paramMap.getKey();
      String str = (String)paramMap.getValue();
      if (localHashMap.size() >= 20)
      {
        AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : properties cannot contain more than %s items. Skipping other properties.", new Object[] { paramString2, paramString1, Integer.valueOf(20) }));
        break;
      }
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        if (str == null)
        {
          AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : property '%s' : property value cannot be null. Property '%s' will be skipped.", new Object[] { paramString2, paramString1, localObject, localObject }));
        }
        else
        {
          paramMap = (Map<String, String>)localObject;
          if (((String)localObject).length() > 125)
          {
            AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", new Object[] { paramString2, paramString1, localObject, Integer.valueOf(125) }));
            paramMap = ((String)localObject).substring(0, 125);
          }
          localObject = str;
          if (str.length() > 125)
          {
            AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", new Object[] { paramString2, paramString1, paramMap, Integer.valueOf(125) }));
            localObject = str.substring(0, 125);
          }
          localHashMap.put(paramMap, localObject);
        }
      }
      else {
        AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : a property key cannot be null or empty. Property will be skipped.", new Object[] { paramString2, paramString1 }));
      }
    }
    return localHashMap;
  }
  
  public static void validateProperties(List<TypedProperty> paramList)
  {
    if (paramList == null) {
      return;
    }
    ListIterator localListIterator = paramList.listIterator();
    int i = 0;
    int j = 0;
    while (localListIterator.hasNext())
    {
      Object localObject = (TypedProperty)localListIterator.next();
      paramList = ((TypedProperty)localObject).getName();
      int k;
      if (i >= 20)
      {
        k = j;
        if (j == 0)
        {
          AppCenterLog.warn("AppCenterAnalytics", String.format("Typed properties cannot contain more than %s items. Skipping other properties.", new Object[] { Integer.valueOf(20) }));
          k = 1;
        }
        localListIterator.remove();
        j = k;
      }
      else if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (paramList.length() > 125)
        {
          AppCenterLog.warn("AppCenterAnalytics", String.format("Typed property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", new Object[] { paramList, Integer.valueOf(125) }));
          paramList = paramList.substring(0, 125);
          localObject = copyProperty((TypedProperty)localObject, paramList);
          localListIterator.set(localObject);
          k = 0;
        }
        else
        {
          k = 1;
        }
        if ((localObject instanceof StringTypedProperty))
        {
          StringTypedProperty localStringTypedProperty = (StringTypedProperty)localObject;
          localObject = localStringTypedProperty.getValue();
          if (localObject == null)
          {
            AppCenterLog.warn("AppCenterAnalytics", String.format("Typed property '%s' : property value cannot be null. Property '%s' will be skipped.", new Object[] { paramList, paramList }));
            localListIterator.remove();
            continue;
          }
          if (((String)localObject).length() > 125)
          {
            AppCenterLog.warn("AppCenterAnalytics", String.format("A String property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", new Object[] { paramList, Integer.valueOf(125) }));
            localObject = ((String)localObject).substring(0, 125);
            if (k != 0)
            {
              localStringTypedProperty = new StringTypedProperty();
              localStringTypedProperty.setName(paramList);
              localStringTypedProperty.setValue((String)localObject);
              localListIterator.set(localStringTypedProperty);
            }
            else
            {
              localStringTypedProperty.setValue((String)localObject);
            }
          }
        }
        i++;
      }
      else
      {
        AppCenterLog.warn("AppCenterAnalytics", "A typed property key cannot be null or empty. Property will be skipped.");
        localListIterator.remove();
      }
    }
  }
  
  public boolean shouldFilter(Log paramLog)
  {
    if ((paramLog instanceof PageLog)) {
      return validateLog((LogWithNameAndProperties)paramLog) ^ true;
    }
    if ((paramLog instanceof EventLog)) {
      return validateLog((EventLog)paramLog) ^ true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.channel.AnalyticsValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */