package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.c;

public class JobsStatisticsParser
{
  public static final String DEVICECOUNT_TAG = "deviceCount";
  public static final String FAILEDCOUNT_TAG = "failedCount";
  public static final String PENDINGCOUNT_TAG = "pendingCount";
  public static final String RUNNINGCOUNT_TAG = "runningCount";
  public static final String SUCCEEDEDCOUNT_TAG = "succeededCount";
  @c("deviceCount")
  public int deviceCount;
  @c("failedCount")
  public int failedCount;
  @c("pendingCount")
  public int pendingCount;
  @c("runningCount")
  public int runningCount;
  @c("succeededCount")
  public int succeededCount;
  
  public int getDeviceCount()
  {
    return deviceCount;
  }
  
  public int getFailedCount()
  {
    return failedCount;
  }
  
  public int getPendingCount()
  {
    return pendingCount;
  }
  
  public int getRunningCount()
  {
    return runningCount;
  }
  
  public int getSucceededCount()
  {
    return succeededCount;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.JobsStatisticsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */