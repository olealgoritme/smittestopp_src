package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.util.Date;

public abstract class RetryPolicy
  implements RetryPolicyFactory
{
  public static final int DEFAULT_CLIENT_BACKOFF = 30000;
  public static final int DEFAULT_CLIENT_RETRY_COUNT = 3;
  public static final int DEFAULT_MAX_BACKOFF = 90000;
  public static final int DEFAULT_MIN_BACKOFF = 3000;
  public int deltaBackoffIntervalInMs;
  public Date lastPrimaryAttempt = null;
  public Date lastSecondaryAttempt = null;
  public int maximumAttempts;
  
  public RetryPolicy() {}
  
  public RetryPolicy(int paramInt1, int paramInt2)
  {
    deltaBackoffIntervalInMs = paramInt1;
    maximumAttempts = paramInt2;
  }
  
  public abstract RetryInfo evaluate(RetryContext paramRetryContext, OperationContext paramOperationContext);
  
  public boolean evaluateLastAttemptAndSecondaryNotFound(RetryContext paramRetryContext)
  {
    Utility.assertNotNull("retryContext", paramRetryContext);
    if (paramRetryContext.getLastRequestResult().getTargetLocation() == StorageLocation.PRIMARY) {
      lastPrimaryAttempt = paramRetryContext.getLastRequestResult().getStopDate();
    } else {
      lastSecondaryAttempt = paramRetryContext.getLastRequestResult().getStopDate();
    }
    boolean bool;
    if ((paramRetryContext.getLastRequestResult().getTargetLocation() == StorageLocation.SECONDARY) && (paramRetryContext.getLastRequestResult().getStatusCode() == 404)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public RetryInfo evaluateRetryInfo(RetryContext paramRetryContext, boolean paramBoolean, long paramLong)
  {
    RetryInfo localRetryInfo = new RetryInfo(paramRetryContext);
    if ((paramBoolean) && (paramRetryContext.getLocationMode() != LocationMode.SECONDARY_ONLY))
    {
      localRetryInfo.setUpdatedLocationMode(LocationMode.PRIMARY_ONLY);
      localRetryInfo.setTargetLocation(StorageLocation.PRIMARY);
    }
    if (localRetryInfo.getTargetLocation() == StorageLocation.PRIMARY) {
      paramRetryContext = lastPrimaryAttempt;
    } else {
      paramRetryContext = lastSecondaryAttempt;
    }
    if (paramRetryContext != null)
    {
      long l1 = new Date().getTime();
      long l2 = paramRetryContext.getTime();
      long l3 = 0L;
      if (l1 - l2 > 0L) {
        l3 = new Date().getTime() - paramRetryContext.getTime();
      }
      localRetryInfo.setRetryInterval((int)(paramLong - l3));
    }
    else
    {
      localRetryInfo.setRetryInterval(0);
    }
    return localRetryInfo;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */