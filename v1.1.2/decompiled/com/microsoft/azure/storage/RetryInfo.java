package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;

public class RetryInfo
{
  public int retryInterval = 3000;
  public StorageLocation targetLocation;
  public LocationMode updatedLocationMode;
  
  public RetryInfo()
  {
    targetLocation = StorageLocation.PRIMARY;
    updatedLocationMode = LocationMode.PRIMARY_ONLY;
  }
  
  public RetryInfo(RetryContext paramRetryContext)
  {
    Utility.assertNotNull("retryContext", paramRetryContext);
    targetLocation = paramRetryContext.getNextLocation();
    updatedLocationMode = paramRetryContext.getLocationMode();
  }
  
  public int getRetryInterval()
  {
    return retryInterval;
  }
  
  public final StorageLocation getTargetLocation()
  {
    return targetLocation;
  }
  
  public LocationMode getUpdatedLocationMode()
  {
    return updatedLocationMode;
  }
  
  public void setRetryInterval(int paramInt)
  {
    if (paramInt <= 0) {
      paramInt = 0;
    }
    retryInterval = paramInt;
  }
  
  public void setTargetLocation(StorageLocation paramStorageLocation)
  {
    targetLocation = paramStorageLocation;
  }
  
  public void setUpdatedLocationMode(LocationMode paramLocationMode)
  {
    updatedLocationMode = paramLocationMode;
  }
  
  public String toString()
  {
    return String.format(Utility.LOCALE_US, "(%s,%s)", new Object[] { targetLocation, Integer.valueOf(retryInterval) });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */