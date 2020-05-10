package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;

public final class RetryContext
{
  public final int currentRetryCount;
  public final RequestResult lastRequestResult;
  public final LocationMode locationMode;
  public final StorageLocation nextLocation;
  
  public RetryContext(int paramInt, RequestResult paramRequestResult, StorageLocation paramStorageLocation, LocationMode paramLocationMode)
  {
    currentRetryCount = paramInt;
    lastRequestResult = paramRequestResult;
    nextLocation = paramStorageLocation;
    locationMode = paramLocationMode;
  }
  
  public int getCurrentRetryCount()
  {
    return currentRetryCount;
  }
  
  public RequestResult getLastRequestResult()
  {
    return lastRequestResult;
  }
  
  public LocationMode getLocationMode()
  {
    return locationMode;
  }
  
  public StorageLocation getNextLocation()
  {
    return nextLocation;
  }
  
  public String toString()
  {
    return String.format(Utility.LOCALE_US, "(%s,%s)", new Object[] { Integer.valueOf(currentRetryCount), locationMode });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */