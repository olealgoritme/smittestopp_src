package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.util.Date;

public abstract class RequestOptions
{
  public LocationMode locationMode;
  public Integer maximumExecutionTimeInMs;
  public Long operationExpiryTime;
  public Boolean requireEncryption;
  public RetryPolicyFactory retryPolicyFactory;
  public Integer timeoutIntervalInMs;
  
  public RequestOptions() {}
  
  public RequestOptions(RequestOptions paramRequestOptions)
  {
    if (paramRequestOptions != null)
    {
      setRetryPolicyFactory(paramRequestOptions.getRetryPolicyFactory());
      setTimeoutIntervalInMs(paramRequestOptions.getTimeoutIntervalInMs());
      setLocationMode(paramRequestOptions.getLocationMode());
      setMaximumExecutionTimeInMs(paramRequestOptions.getMaximumExecutionTimeInMs());
      setOperationExpiryTimeInMs(paramRequestOptions.getOperationExpiryTimeInMs());
      setRequireEncryption(paramRequestOptions.requireEncryption());
    }
  }
  
  public static void applyBaseDefaultsInternal(RequestOptions paramRequestOptions)
  {
    Utility.assertNotNull("modifiedOptions", paramRequestOptions);
    if (paramRequestOptions.getRetryPolicyFactory() == null) {
      paramRequestOptions.setRetryPolicyFactory(new RetryExponentialRetry());
    }
    if (paramRequestOptions.getLocationMode() == null) {
      paramRequestOptions.setLocationMode(LocationMode.PRIMARY_ONLY);
    }
    if (paramRequestOptions.requireEncryption() == null) {
      paramRequestOptions.setRequireEncryption(Boolean.valueOf(false));
    }
  }
  
  public static void populateRequestOptions(RequestOptions paramRequestOptions1, RequestOptions paramRequestOptions2, boolean paramBoolean)
  {
    if (paramRequestOptions1.getRetryPolicyFactory() == null) {
      paramRequestOptions1.setRetryPolicyFactory(paramRequestOptions2.getRetryPolicyFactory());
    }
    if (paramRequestOptions1.getLocationMode() == null) {
      paramRequestOptions1.setLocationMode(paramRequestOptions2.getLocationMode());
    }
    if (paramRequestOptions1.getTimeoutIntervalInMs() == null) {
      paramRequestOptions1.setTimeoutIntervalInMs(paramRequestOptions2.getTimeoutIntervalInMs());
    }
    if (paramRequestOptions1.requireEncryption() == null) {
      paramRequestOptions1.setRequireEncryption(paramRequestOptions2.requireEncryption());
    }
    if (paramRequestOptions1.getMaximumExecutionTimeInMs() == null) {
      paramRequestOptions1.setMaximumExecutionTimeInMs(paramRequestOptions2.getMaximumExecutionTimeInMs());
    }
    if ((paramRequestOptions1.getMaximumExecutionTimeInMs() != null) && (paramRequestOptions1.getOperationExpiryTimeInMs() == null) && (paramBoolean)) {
      paramRequestOptions1.setOperationExpiryTimeInMs(Long.valueOf(new Date().getTime() + paramRequestOptions1.getMaximumExecutionTimeInMs().intValue()));
    }
  }
  
  private void setOperationExpiryTimeInMs(Long paramLong)
  {
    operationExpiryTime = paramLong;
  }
  
  public final LocationMode getLocationMode()
  {
    return locationMode;
  }
  
  public Integer getMaximumExecutionTimeInMs()
  {
    return maximumExecutionTimeInMs;
  }
  
  public Long getOperationExpiryTimeInMs()
  {
    return operationExpiryTime;
  }
  
  public final RetryPolicyFactory getRetryPolicyFactory()
  {
    return retryPolicyFactory;
  }
  
  public final Integer getTimeoutIntervalInMs()
  {
    return timeoutIntervalInMs;
  }
  
  public Boolean requireEncryption()
  {
    return requireEncryption;
  }
  
  public void setLocationMode(LocationMode paramLocationMode)
  {
    locationMode = paramLocationMode;
  }
  
  public void setMaximumExecutionTimeInMs(Integer paramInteger)
  {
    maximumExecutionTimeInMs = paramInteger;
  }
  
  public void setRequireEncryption(Boolean paramBoolean)
  {
    requireEncryption = paramBoolean;
  }
  
  public final void setRetryPolicyFactory(RetryPolicyFactory paramRetryPolicyFactory)
  {
    retryPolicyFactory = paramRetryPolicyFactory;
  }
  
  public final void setTimeoutIntervalInMs(Integer paramInteger)
  {
    timeoutIntervalInMs = paramInteger;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.RequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */