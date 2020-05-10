package com.microsoft.azure.sdk.iot.deps.twin;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.deps.util.Tools;
import e.c.c.e;
import e.c.c.j;
import e.c.c.m;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Map;

public class TwinState
  extends RegisterManager
{
  public static final String CONFIGURATION_TAG = "configurations";
  public static final String PROPERTIES_TAG = "properties";
  public static final String TAGS_TAG = "tags";
  @a(deserialize=true, serialize=false)
  @c("configurations")
  public Map<String, ConfigurationInfo> configurations;
  @a(deserialize=true, serialize=false)
  @c("properties")
  public TwinProperties properties;
  @a(deserialize=true, serialize=false)
  @c("tags")
  public TwinCollection tags;
  
  public TwinState() {}
  
  public TwinState(TwinCollection paramTwinCollection1, TwinCollection paramTwinCollection2, TwinCollection paramTwinCollection3)
  {
    if (paramTwinCollection1 != null) {
      tags = TwinCollection.createFromRawCollection(paramTwinCollection1);
    }
    if ((paramTwinCollection2 != null) || (paramTwinCollection3 != null)) {
      properties = new TwinProperties(paramTwinCollection2, paramTwinCollection3);
    }
  }
  
  public static TwinState createFromDesiredPropertyJson(String paramString)
  {
    if (!Tools.isNullOrEmpty(paramString).booleanValue())
    {
      e locale = new e();
      locale.b();
      l = false;
      paramString = locale.a().a(paramString, TwinCollection.class);
      return new TwinState(null, (TwinCollection)t.a(TwinCollection.class).cast(paramString), null);
    }
    throw new IllegalArgumentException("JSON with result is null or empty");
  }
  
  public static TwinState createFromPropertiesJson(String paramString)
  {
    if (!Tools.isNullOrEmpty(paramString).booleanValue())
    {
      e locale = new e();
      locale.b();
      l = false;
      paramString = locale.a().a(paramString, TwinProperties.class);
      paramString = (TwinProperties)t.a(TwinProperties.class).cast(paramString);
      return new TwinState(null, paramString.getDesired(), paramString.getReported());
    }
    throw new IllegalArgumentException("JSON with result is null or empty");
  }
  
  public static TwinState createFromReportedPropertyJson(String paramString)
  {
    if (!Tools.isNullOrEmpty(paramString).booleanValue())
    {
      e locale = new e();
      locale.b();
      l = false;
      paramString = locale.a().a(paramString, TwinCollection.class);
      return new TwinState(null, null, (TwinCollection)t.a(TwinCollection.class).cast(paramString));
    }
    throw new IllegalArgumentException("JSON with result is null or empty");
  }
  
  public static TwinState createFromTwinJson(String paramString)
  {
    if (!Tools.isNullOrEmpty(paramString).booleanValue())
    {
      Object localObject = new e();
      ((e)localObject).b();
      l = false;
      paramString = ((e)localObject).a().a(paramString, TwinState.class);
      paramString = (TwinState)t.a(TwinState.class).cast(paramString);
      tags = new TwinCollection(paramString.getTags());
      localObject = properties;
      if (localObject != null) {
        properties = new TwinProperties(((TwinProperties)localObject).getDesired(), properties.getReported());
      }
      return paramString;
    }
    throw new IllegalArgumentException("JSON with result is null or empty");
  }
  
  public Map<String, ConfigurationInfo> getConfigurations()
  {
    return configurations;
  }
  
  public String getConnectionState()
  {
    TwinConnectionState localTwinConnectionState = connectionState;
    if (localTwinConnectionState == null) {
      return null;
    }
    return localTwinConnectionState.toString();
  }
  
  public TwinCollection getDesiredProperty()
  {
    TwinProperties localTwinProperties = properties;
    if (localTwinProperties == null) {
      return null;
    }
    return localTwinProperties.getDesired();
  }
  
  public TwinCollection getReportedProperty()
  {
    TwinProperties localTwinProperties = properties;
    if (localTwinProperties == null) {
      return null;
    }
    return localTwinProperties.getReported();
  }
  
  public TwinCollection getTags()
  {
    return new TwinCollection(tags);
  }
  
  public j toJsonElement()
  {
    Object localObject = new e();
    l = false;
    g = true;
    localObject = ((e)localObject).a().b(this).c();
    if (properties != null) {
      ((j)localObject).c().a("properties", properties.toJsonElement());
    }
    return (j)localObject;
  }
  
  public String toString()
  {
    Object localObject1 = new e();
    ((e)localObject1).b();
    m = true;
    l = false;
    localObject1 = ((e)localObject1).a().b(this).c();
    Object localObject2 = tags;
    if (localObject2 != null) {
      ((m)localObject1).a("tags", ((TwinCollection)localObject2).toJsonElementWithMetadata());
    }
    localObject2 = properties;
    if (localObject2 != null) {
      ((m)localObject1).a("properties", ((TwinProperties)localObject2).toJsonElementWithMetadata());
    }
    return ((j)localObject1).toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.TwinState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */