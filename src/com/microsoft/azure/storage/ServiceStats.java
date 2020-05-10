package com.microsoft.azure.storage;

public class ServiceStats
{
  public GeoReplicationStats geoReplication;
  
  public GeoReplicationStats getGeoReplication()
  {
    return geoReplication;
  }
  
  public void setGeoReplication(GeoReplicationStats paramGeoReplicationStats)
  {
    geoReplication = paramGeoReplicationStats;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServiceStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */