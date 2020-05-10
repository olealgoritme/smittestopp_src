package com.microsoft.appcenter.ingestion.models;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public abstract interface Log
  extends Model
{
  public abstract void addTransmissionTarget(String paramString);
  
  public abstract Device getDevice();
  
  public abstract String getDistributionGroupId();
  
  public abstract UUID getSid();
  
  public abstract Object getTag();
  
  public abstract Date getTimestamp();
  
  public abstract Set<String> getTransmissionTargetTokens();
  
  public abstract String getType();
  
  public abstract String getUserId();
  
  public abstract void setDevice(Device paramDevice);
  
  public abstract void setDistributionGroupId(String paramString);
  
  public abstract void setSid(UUID paramUUID);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setTimestamp(Date paramDate);
  
  public abstract void setUserId(String paramString);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.Log
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */