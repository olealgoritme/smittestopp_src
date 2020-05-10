package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;

public enum GeoReplicationStatus
{
  static
  {
    LIVE = new GeoReplicationStatus("LIVE", 1);
    GeoReplicationStatus localGeoReplicationStatus = new GeoReplicationStatus("BOOTSTRAP", 2);
    BOOTSTRAP = localGeoReplicationStatus;
    $VALUES = new GeoReplicationStatus[] { UNAVAILABLE, LIVE, localGeoReplicationStatus };
  }
  
  public GeoReplicationStatus() {}
  
  public static GeoReplicationStatus parse(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("unavailable")) {
        return UNAVAILABLE;
      }
      if (paramString.equals("live")) {
        return LIVE;
      }
      if (paramString.equals("bootstrap")) {
        return BOOTSTRAP;
      }
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Null or Invalid geo-replication status in response: %s.", new Object[] { paramString }));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.GeoReplicationStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */