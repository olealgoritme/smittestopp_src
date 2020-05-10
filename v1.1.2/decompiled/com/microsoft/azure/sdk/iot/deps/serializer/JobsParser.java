package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.deps.twin.TwinState;
import e.c.c.e;
import e.c.c.j;
import e.c.c.v.a;
import e.c.c.v.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JobsParser
{
  public static final String CLOUDTODEVICEMETHOD_TAG = "cloudToDeviceMethod";
  public static final transient String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String JOBID_TAG = "jobId";
  public static final String MAXEXECUTIONTIMEINSECONDS_TAG = "maxExecutionTimeInSeconds";
  public static final String QUERYCONDITION_TAG = "queryCondition";
  public static final transient String SCHEDULE_DEVICE_METHOD = "scheduleDeviceMethod";
  public static final transient String SCHEDULE_UPDATE_TWIN = "scheduleUpdateTwin";
  public static final String STARTTIME_TAG = "startTime";
  public static final transient String TIMEZONE = "UTC";
  public static final String TYPE_TAG = "type";
  public static final String UPDATETWIN_TAG = "updateTwin";
  @a(deserialize=false, serialize=true)
  @c("cloudToDeviceMethod")
  public j cloudToDeviceMethod = null;
  @a(deserialize=false, serialize=true)
  @c("jobId")
  public String jobId;
  @a(deserialize=false, serialize=true)
  @c("type")
  public String jobType;
  @a(deserialize=false, serialize=true)
  @c("maxExecutionTimeInSeconds")
  public long maxExecutionTimeInSeconds;
  @a(deserialize=false, serialize=true)
  @c("queryCondition")
  public String queryCondition;
  @a(deserialize=false, serialize=true)
  @c("startTime")
  public String startTime;
  @a(deserialize=false, serialize=true)
  @c("updateTwin")
  public j updateTwin = null;
  
  public JobsParser() {}
  
  public JobsParser(String paramString1, MethodParser paramMethodParser, String paramString2, Date paramDate, long paramLong)
  {
    if (paramMethodParser != null)
    {
      validateCommonFields(paramString1, paramString2, paramDate, paramLong);
      cloudToDeviceMethod = paramMethodParser.toJsonElement();
      jobType = "scheduleDeviceMethod";
      updateTwin = null;
      return;
    }
    throw new IllegalArgumentException("Null cloudToDeviceMethod parameter");
  }
  
  @Deprecated
  public JobsParser(String paramString1, TwinParser paramTwinParser, String paramString2, Date paramDate, long paramLong)
  {
    if (paramTwinParser != null)
    {
      validateCommonFields(paramString1, paramString2, paramDate, paramLong);
      updateTwin = paramTwinParser.toJsonElement();
      jobType = "scheduleUpdateTwin";
      cloudToDeviceMethod = null;
      return;
    }
    throw new IllegalArgumentException("Null TwinParser parameter");
  }
  
  public JobsParser(String paramString1, TwinState paramTwinState, String paramString2, Date paramDate, long paramLong)
  {
    if (paramTwinState != null)
    {
      validateCommonFields(paramString1, paramString2, paramDate, paramLong);
      updateTwin = paramTwinState.toJsonElement();
      jobType = "scheduleUpdateTwin";
      cloudToDeviceMethod = null;
      return;
    }
    throw new IllegalArgumentException("Null twinState parameter");
  }
  
  private void validateCommonFields(String paramString1, String paramString2, Date paramDate, long paramLong)
  {
    ParserUtility.validateStringUTF8(paramString1);
    if (paramDate != null)
    {
      if (paramLong >= 0L)
      {
        jobId = paramString1;
        queryCondition = paramString2;
        maxExecutionTimeInSeconds = paramLong;
        paramString1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        paramString1.setTimeZone(TimeZone.getTimeZone("UTC"));
        startTime = paramString1.format(paramDate);
        return;
      }
      throw new IllegalArgumentException("Negative max execution time in seconds");
    }
    throw new IllegalArgumentException("Null start time");
  }
  
  public String toJson()
  {
    e locale = new e();
    l = false;
    g = true;
    return locale.a().a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.JobsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */