package com.microsoft.azure.sdk.iot.device.DeviceTwin;

import java.util.Date;

public class Property
{
  public boolean isReported = false;
  public Date lastUpdated;
  public Integer lastUpdatedVersion;
  public Pair<String, Object> property = null;
  public Integer version = null;
  
  public Property(String paramString, Object paramObject)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      property = new Pair(paramString, paramObject);
      return;
    }
    throw new IllegalArgumentException("Key cannot be null or empty");
  }
  
  public Property(String paramString, Object paramObject, Integer paramInteger1, boolean paramBoolean, Date paramDate, Integer paramInteger2)
  {
    this(paramString, paramObject);
    version = paramInteger1;
    isReported = paramBoolean;
    lastUpdated = paramDate;
    lastUpdatedVersion = paramInteger2;
  }
  
  public boolean getIsReported()
  {
    return isReported;
  }
  
  public String getKey()
  {
    return (String)property.getKey();
  }
  
  public Date getLastUpdated()
  {
    return lastUpdated;
  }
  
  public Integer getLastUpdatedVersion()
  {
    return lastUpdatedVersion;
  }
  
  public Object getValue()
  {
    return property.getValue();
  }
  
  public Integer getVersion()
  {
    return version;
  }
  
  public void setValue(Object paramObject)
  {
    property.setValue(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append(" - ");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceTwin.Property
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */