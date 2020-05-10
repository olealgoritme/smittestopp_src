package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class RegistryStatisticsParser
{
  public static final String DISABLED_DEVICE_COUNT_NAME = "disabledDeviceCount";
  public static final String ENABLED_DEVICE_COUNT_NAME = "enableDeviceCount";
  public static final String TOTAL_DEVICE_COUNT_NAME = "totalDeviceCount";
  public static transient Gson gson = new Gson();
  @a(deserialize=true, serialize=true)
  @c("disabledDeviceCount")
  public long disabledDeviceCount;
  @a(deserialize=true, serialize=true)
  @c("enableDeviceCount")
  public long enabledDeviceCount;
  @a(deserialize=true, serialize=true)
  @c("totalDeviceCount")
  public long totalDeviceCount;
  
  public RegistryStatisticsParser() {}
  
  public RegistryStatisticsParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, RegistryStatisticsParser.class);
        paramString = (RegistryStatisticsParser)t.a(RegistryStatisticsParser.class).cast(paramString);
        totalDeviceCount = totalDeviceCount;
        enabledDeviceCount = enabledDeviceCount;
        disabledDeviceCount = disabledDeviceCount;
        return;
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public long getDisabledDeviceCount()
  {
    return disabledDeviceCount;
  }
  
  public long getEnabledDeviceCount()
  {
    return enabledDeviceCount;
  }
  
  public long getTotalDeviceCount()
  {
    return totalDeviceCount;
  }
  
  public void setDisabledDeviceCount(long paramLong)
  {
    disabledDeviceCount = paramLong;
  }
  
  public void setEnabledDeviceCount(long paramLong)
  {
    enabledDeviceCount = paramLong;
  }
  
  public void setTotalDeviceCount(long paramLong)
  {
    totalDeviceCount = paramLong;
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.RegistryStatisticsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */