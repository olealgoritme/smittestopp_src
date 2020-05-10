package com.microsoft.azure.sdk.iot.deps.twin;

import com.microsoft.azure.sdk.iot.deps.serializer.ParserUtility;
import com.microsoft.azure.sdk.iot.deps.util.Tools;
import e.c.c.j;
import e.c.c.m;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwinMetadata
{
  public static final String LAST_UPDATE_TAG = "$lastUpdated";
  public static final String LAST_UPDATE_VERSION_TAG = "$lastUpdatedVersion";
  public Date lastUpdated;
  public Integer lastUpdatedVersion;
  
  public TwinMetadata(TwinMetadata paramTwinMetadata)
  {
    if (paramTwinMetadata != null)
    {
      lastUpdated = paramTwinMetadata.getLastUpdated();
      lastUpdatedVersion = paramTwinMetadata.getLastUpdatedVersion();
      return;
    }
    throw new IllegalArgumentException("metadata to copy cannot be null");
  }
  
  public TwinMetadata(String paramString, Integer paramInteger)
  {
    if (!Tools.isNullOrEmpty(paramString).booleanValue()) {
      lastUpdated = ParserUtility.getDateTimeUtc(paramString);
    }
    lastUpdatedVersion = paramInteger;
    if ((paramInteger == null) && (lastUpdated == null)) {
      throw new IllegalArgumentException("no valid data to create a TwinMetadata.");
    }
  }
  
  public static TwinMetadata tryExtractFromMap(Object paramObject)
  {
    if (!(paramObject instanceof Map)) {
      return null;
    }
    Iterator localIterator = ((Map)paramObject).entrySet().iterator();
    Integer localInteger = null;
    paramObject = localInteger;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (str.equals("$lastUpdated")) {
        paramObject = (String)localEntry.getValue();
      } else if (str.equals("$lastUpdatedVersion")) {
        if ((localEntry.getValue() instanceof Number)) {
          localInteger = Integer.valueOf(((Number)localEntry.getValue()).intValue());
        } else {
          throw new IllegalArgumentException("Version in the metadata shall be a number");
        }
      }
    }
    if ((localInteger == null) && (Tools.isNullOrEmpty((String)paramObject).booleanValue())) {
      return null;
    }
    return new TwinMetadata((String)paramObject, localInteger);
  }
  
  public Date getLastUpdated()
  {
    if (lastUpdated == null) {
      return null;
    }
    return new Date(lastUpdated.getTime());
  }
  
  public Integer getLastUpdatedVersion()
  {
    if (lastUpdatedVersion == null) {
      return null;
    }
    return new Integer(lastUpdatedVersion.intValue());
  }
  
  public j toJsonElement()
  {
    m localm = new m();
    Object localObject = lastUpdated;
    if (localObject != null) {
      localm.a("$lastUpdated", localm.a(ParserUtility.dateTimeUtcToString((Date)localObject)));
    }
    localObject = lastUpdatedVersion;
    if (localObject != null) {
      localm.a("$lastUpdatedVersion", localm.a(localObject));
    }
    return localm;
  }
  
  public String toString()
  {
    return toJsonElement().toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.twin.TwinMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */