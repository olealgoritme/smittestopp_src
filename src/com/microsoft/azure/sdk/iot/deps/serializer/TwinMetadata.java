package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.j;
import e.c.c.v.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Deprecated
public class TwinMetadata
{
  public static final String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String TIMEZONE = "UTC";
  @c("$lastUpdated")
  public String lastUpdated;
  @c("$lastUpdatedVersion")
  public Integer lastUpdatedVersion;
  
  public TwinMetadata()
  {
    update();
    lastUpdatedVersion = null;
  }
  
  public TwinMetadata(Integer paramInteger)
  {
    update();
    lastUpdatedVersion = paramInteger;
  }
  
  public TwinMetadata(Integer paramInteger, String paramString)
  {
    lastUpdated = paramString;
    lastUpdatedVersion = paramInteger;
  }
  
  public String getLastUpdate()
  {
    try
    {
      String str = lastUpdated;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Integer getLastUpdateVersion()
  {
    try
    {
      Integer localInteger = lastUpdatedVersion;
      return localInteger;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public j toJsonElement()
  {
    return new e().a().b(this);
  }
  
  public void update()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      localSimpleDateFormat.<init>("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      Date localDate = new java/util/Date;
      localDate.<init>();
      lastUpdated = localSimpleDateFormat.format(localDate);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void update(int paramInt)
  {
    try
    {
      update();
      lastUpdatedVersion = Integer.valueOf(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean update(String paramString, Integer paramInteger)
  {
    try
    {
      boolean bool1 = lastUpdated.equals(paramString);
      boolean bool2 = false;
      if (!bool1) {}
      while (lastUpdatedVersion == null ? paramInteger != null : !lastUpdatedVersion.equals(paramInteger))
      {
        bool2 = true;
        break;
      }
      lastUpdated = paramString;
      lastUpdatedVersion = paramInteger;
      return bool2;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.TwinMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */