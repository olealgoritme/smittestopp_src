package com.microsoft.azure.storage;

import java.util.Date;

public class GeoReplicationStats
{
  public Date lastSyncTime;
  public GeoReplicationStatus status;
  
  public Date getLastSyncTime()
  {
    return lastSyncTime;
  }
  
  public GeoReplicationStatus getStatus()
  {
    return status;
  }
  
  public void setLastSyncTime(Date paramDate)
  {
    lastSyncTime = paramDate;
  }
  
  public void setStatus(GeoReplicationStatus paramGeoReplicationStatus)
  {
    status = paramGeoReplicationStatus;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.GeoReplicationStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */