package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.j;
import e.c.c.m;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Date;
import java.util.HashMap;

public class ConfigurationParser
{
  public static final String CONFIGURATION_ID_NAME = "id";
  public static final String CONTENT_NAME = "content";
  public static final String CONTENT_TYPE_NAME = "contentType";
  public static final String CREATED_TIME_UTC_NAME = "createdTimeUtc";
  public static final String E_TAG_NAME = "etag";
  public static final String LABELS_NAME = "labels";
  public static final String LAST_UPDATED_TIME_UTC_NAME = "lastUpdatedTimeUtc";
  public static final String METRICS_NAME = "metrics";
  public static final String PRIORITY_NAME = "priority";
  public static final String SCHEMA_VERSION_NAME = "schemaVersion";
  public static final String SYSTEM_METRICS_NAME = "systemMetrics";
  public static final String TARGET_CONDITION_NAME = "targetCondition";
  public static transient Gson gson;
  @a(deserialize=true, serialize=false)
  @c("content")
  public ConfigurationContentParser content;
  @a(deserialize=true, serialize=true)
  @c("contentType")
  public String contentType;
  public transient Date createdTimeUtc;
  @a(deserialize=false, serialize=true)
  @c("createdTimeUtc")
  public String createdTimeUtcString;
  @a(deserialize=true, serialize=true)
  @c("etag")
  public String eTag;
  @a(deserialize=true, serialize=true)
  @c("id")
  public String id;
  @a(deserialize=true, serialize=true)
  @c("labels")
  public HashMap<String, String> labels;
  public transient Date lastUpdatedTimeUtc;
  @a(deserialize=false, serialize=true)
  @c("lastUpdatedTimeUtc")
  public String lastUpdatedTimeUtcString;
  @a(deserialize=true, serialize=true)
  @c("metrics")
  public ConfigurationMetricsParser metrics;
  @a(deserialize=true, serialize=true)
  @c("priority")
  public Integer priority;
  @a(deserialize=true, serialize=true)
  @c("schemaVersion")
  public String schemaVersion;
  @a(deserialize=true, serialize=true)
  @c("systemMetrics")
  public ConfigurationMetricsParser systemMetrics;
  @a(deserialize=true, serialize=true)
  @c("targetCondition")
  public String targetCondition;
  
  static
  {
    e locale = new e();
    j = true;
    g = true;
    gson = locale.a();
  }
  
  public ConfigurationParser() {}
  
  public ConfigurationParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, ConfigurationParser.class);
        paramString = (ConfigurationParser)t.a(ConfigurationParser.class).cast(paramString);
        String str = id;
        if ((str != null) && (!str.isEmpty()))
        {
          id = id;
          schemaVersion = schemaVersion;
          labels = labels;
          content = content;
          contentType = contentType;
          targetCondition = targetCondition;
          priority = priority;
          systemMetrics = systemMetrics;
          metrics = metrics;
          eTag = eTag;
          str = createdTimeUtcString;
          if (str != null)
          {
            createdTimeUtcString = str;
            createdTimeUtc = ParserUtility.getDateTimeUtc(createdTimeUtcString);
          }
          str = lastUpdatedTimeUtcString;
          if (str != null)
          {
            lastUpdatedTimeUtcString = str;
            lastUpdatedTimeUtc = ParserUtility.getDateTimeUtc(lastUpdatedTimeUtcString);
          }
          return;
        }
        throw new IllegalArgumentException("The provided json must contain the field for configurationId and its value may not be empty");
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public ConfigurationContentParser getContent()
  {
    return content;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public Date getCreatedTimeUtc()
  {
    return createdTimeUtc;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public String getId()
  {
    return id;
  }
  
  public HashMap<String, String> getLabels()
  {
    return labels;
  }
  
  public Date getLastUpdatedTimeUtc()
  {
    return lastUpdatedTimeUtc;
  }
  
  public ConfigurationMetricsParser getMetrics()
  {
    return metrics;
  }
  
  public Integer getPriority()
  {
    return priority;
  }
  
  public String getSchemaVersion()
  {
    return schemaVersion;
  }
  
  public ConfigurationMetricsParser getSystemMetrics()
  {
    return systemMetrics;
  }
  
  public String getTargetCondition()
  {
    return targetCondition;
  }
  
  public void setContent(ConfigurationContentParser paramConfigurationContentParser)
  {
    content = paramConfigurationContentParser;
  }
  
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
  
  public void setCreatedTimeUtc(Date paramDate)
  {
    createdTimeUtc = paramDate;
    if (paramDate == null) {
      createdTimeUtcString = null;
    } else {
      createdTimeUtcString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setETag(String paramString)
  {
    eTag = paramString;
  }
  
  public void setId(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      id = paramString;
      return;
    }
    throw new IllegalArgumentException("Configuration Id cannot not be null");
  }
  
  public void setLabels(HashMap<String, String> paramHashMap)
  {
    labels = paramHashMap;
  }
  
  public void setLastUpdatedTimeUtc(Date paramDate)
  {
    lastUpdatedTimeUtc = paramDate;
    if (paramDate == null) {
      lastUpdatedTimeUtcString = null;
    } else {
      lastUpdatedTimeUtcString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setMetrics(ConfigurationMetricsParser paramConfigurationMetricsParser)
  {
    metrics = paramConfigurationMetricsParser;
  }
  
  public void setPriority(Integer paramInteger)
  {
    priority = paramInteger;
  }
  
  public void setSchemaVersion(String paramString)
  {
    schemaVersion = paramString;
  }
  
  public void setSystemMetrics(ConfigurationMetricsParser paramConfigurationMetricsParser)
  {
    systemMetrics = paramConfigurationMetricsParser;
  }
  
  public void setTargetCondition(String paramString)
  {
    targetCondition = paramString;
  }
  
  public String toJson()
  {
    Object localObject = createdTimeUtc;
    if (localObject != null) {
      createdTimeUtcString = ParserUtility.getDateStringFromDate((Date)localObject);
    }
    localObject = lastUpdatedTimeUtc;
    if (localObject != null) {
      lastUpdatedTimeUtcString = ParserUtility.getDateStringFromDate((Date)localObject);
    }
    localObject = new e();
    ((e)localObject).b();
    localObject = ((e)localObject).a().b(this).c();
    ConfigurationContentParser localConfigurationContentParser = content;
    if (localConfigurationContentParser != null) {
      ((m)localObject).a("content", localConfigurationContentParser.toJsonElement());
    }
    return ((j)localObject).toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.ConfigurationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */