package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.deps.twin.TwinState;
import e.c.c.e;
import e.c.c.j;
import e.c.c.v.c;
import e.c.c.w.t;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class JobsResponseParser
{
  public static final String CLOUDTODEVICEMETHOD_TAG = "cloudToDeviceMethod";
  public static final String CREATETIME_TAG = "createdTime";
  public static final String CREATE_TIME_UTC_TAG = "createdDateTimeUtc";
  @e.c.c.v.a(deserialize=false)
  public static final String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String DEVICEID_TAG = "deviceId";
  public static final String DEVICEJOBSSTATISTICS_TAG = "deviceJobStatistics";
  public static final String DEVICE_METHOD_RESPONSE_TAG = "deviceMethodResponse";
  public static final String ENDTIME_TAG = "endTime";
  public static final String END_TIME_UTC_TAG = "endTimeUtc";
  public static final String ERROR_TAG = "error";
  public static final String FAILUREREASON_TAG = "failureReason";
  public static final String JOBID_TAG = "jobId";
  public static final String JOB_TYPE_TAG = "jobType";
  public static final String LAST_UPDATED_TIME_UTC_TAG = "lastUpdatedDateTimeUtc";
  public static final String MAXEXECUTIONTIMEINSECONDS_TAG = "maxExecutionTimeInSeconds";
  public static final String OUTCOME_TAG = "outcome";
  public static final String PARENTJOBID_TAG = "parentJobId";
  public static final String QUERYCONDITION_TAG = "queryCondition";
  public static final String STARTTIME_TAG = "startTime";
  public static final String START_TIME_UTC_TAG = "startTimeUtc";
  public static final String STATUSMESSAGE_TAG = "statusMessage";
  public static final String STATUS_TAG = "status";
  @e.c.c.v.a(deserialize=false)
  public static final String TIMEZONE = "UTC";
  public static final String TYPE_TAG = "type";
  public static final String UPDATETWIN_TAG = "updateTwin";
  @c("cloudToDeviceMethod")
  public MethodParser cloudToDeviceMethod = null;
  @c("createdTime")
  public String createdTime;
  @e.c.c.v.a(deserialize=false)
  public Date createdTimeDate;
  @c("createdDateTimeUtc")
  public String createdTimeUTC;
  @c("deviceId")
  public String deviceId = null;
  @c("deviceJobStatistics")
  public JobsStatisticsParser deviceJobStatistics = null;
  @c("endTime")
  public String endTime;
  @e.c.c.v.a(deserialize=false)
  public Date endTimeDate;
  @c("endTimeUtc")
  public String endTimeUTC;
  @c("error")
  public JobQueryResponseError error = null;
  @c("failureReason")
  public String failureReason = null;
  @c("jobId")
  public String jobId;
  @c("jobType")
  public String jobType;
  @c("status")
  public String jobsStatus;
  @c("lastUpdatedDateTimeUtc")
  public String lastUpdatedTime;
  @e.c.c.v.a(deserialize=true, serialize=false)
  public Date lastUpdatedTimeDate;
  @c("maxExecutionTimeInSeconds")
  public Long maxExecutionTimeInSeconds;
  public MethodParser methodResponse;
  @c("outcome")
  public j outcome = null;
  @c("parentJobId")
  public String parentJobId = null;
  @c("queryCondition")
  public String queryCondition;
  @c("startTime")
  public String startTime;
  @e.c.c.v.a(deserialize=false)
  public Date startTimeDate;
  @c("startTimeUtc")
  public String startTimeUTC;
  @c("statusMessage")
  public String statusMessage = null;
  @c("type")
  public String type;
  @c("updateTwin")
  public TwinState updateTwin = null;
  
  public static JobsResponseParser createFromJson(String paramString)
  {
    Object localObject1 = new e();
    l = false;
    Gson localGson = ((e)localObject1).a();
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      localObject1 = localGson.a(paramString, JobsResponseParser.class);
      localObject1 = (JobsResponseParser)t.a(JobsResponseParser.class).cast(localObject1);
      Object localObject2 = jobId;
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        localObject2 = type;
        if ((localObject2 == null) || (((String)localObject2).isEmpty()))
        {
          localObject2 = jobType;
          if ((localObject2 == null) || (((String)localObject2).isEmpty())) {}
        }
        else
        {
          if ((type != null) && (jobType != null)) {
            throw new IllegalArgumentException("Json contains both type and jobType");
          }
          localObject2 = jobsStatus;
          if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
          {
            if (type == null) {
              type = jobType;
            }
            paramString = localGson.a(paramString, Map.class);
            localObject2 = (Map)t.a(Map.class).cast(paramString);
            if (((Map)localObject2).containsKey("updateTwin")) {
              updateTwin = TwinState.createFromTwinJson(localGson.a(((Map)localObject2).get("updateTwin")));
            }
            if (((Map)localObject2).containsKey("cloudToDeviceMethod")) {
              cloudToDeviceMethod.fromJson(localGson.a(((Map)localObject2).get("cloudToDeviceMethod")));
            }
            if (((Map)localObject2).containsKey("outcome"))
            {
              paramString = outcome;
              if (paramString == null) {
                paramString = null;
              } else {
                paramString = localGson.a(new e.c.c.w.z.a(paramString), Map.class);
              }
              paramString = (Map)t.a(Map.class).cast(paramString);
              if (paramString.containsKey("deviceMethodResponse"))
              {
                localObject2 = new MethodParser();
                ((MethodParser)localObject2).fromJson(localGson.a(paramString.get("deviceMethodResponse")));
                methodResponse = ((MethodParser)localObject2);
              }
              else
              {
                paramString = new MethodParser();
                paramString.fromJson(localGson.a(((Map)localObject2).get("outcome")));
                methodResponse = paramString;
              }
            }
            if ((createdTime != null) && (createdTimeUTC != null)) {
              throw new IllegalArgumentException("Both createdTime and createdTimeUTC cannot be sent at the same time");
            }
            paramString = createdTime;
            if (paramString != null)
            {
              try
              {
                createdTimeDate = ParserUtility.getDateTimeUtc(paramString);
              }
              catch (IllegalArgumentException paramString)
              {
                createdTimeDate = null;
              }
            }
            else
            {
              paramString = createdTimeUTC;
              if (paramString != null) {
                try
                {
                  createdTimeDate = ParserUtility.getDateTimeUtc(paramString);
                }
                catch (IllegalArgumentException paramString)
                {
                  createdTimeDate = null;
                }
              }
            }
            if ((startTime != null) && (startTimeUTC != null)) {
              throw new IllegalArgumentException("Both startTime and startTimeUTC cannot be sent at the same time");
            }
            paramString = startTime;
            if (paramString != null)
            {
              try
              {
                startTimeDate = ParserUtility.getDateTimeUtc(paramString);
              }
              catch (IllegalArgumentException paramString)
              {
                startTimeDate = null;
              }
            }
            else
            {
              paramString = startTimeUTC;
              if (paramString != null) {
                try
                {
                  startTimeDate = ParserUtility.getDateTimeUtc(paramString);
                }
                catch (IllegalArgumentException paramString)
                {
                  startTimeDate = null;
                }
              }
            }
            if ((endTime != null) && (endTimeUTC != null)) {
              throw new IllegalArgumentException("Both endTime and endTimeUTC cannot be sent at the same time");
            }
            paramString = endTime;
            if (paramString != null)
            {
              try
              {
                endTimeDate = ParserUtility.getDateTimeUtc(paramString);
              }
              catch (IllegalArgumentException paramString)
              {
                endTimeDate = null;
              }
            }
            else
            {
              paramString = endTimeUTC;
              if (paramString != null) {
                try
                {
                  endTimeDate = ParserUtility.getDateTimeUtc(paramString);
                }
                catch (IllegalArgumentException paramString)
                {
                  endTimeDate = null;
                }
              }
            }
            paramString = lastUpdatedTime;
            if (paramString != null) {
              try
              {
                lastUpdatedTimeDate = ParserUtility.getDateTimeUtc(paramString);
              }
              catch (IllegalArgumentException paramString)
              {
                lastUpdatedTimeDate = null;
              }
            }
            return (JobsResponseParser)localObject1;
          }
          throw new IllegalArgumentException("Json do not contains status");
        }
        throw new IllegalArgumentException("Json do not contains type");
      }
      throw new IllegalArgumentException("Json do not contains jobId");
    }
    throw new IllegalArgumentException("Json is null or empty");
  }
  
  public MethodParser getCloudToDeviceMethod()
  {
    return cloudToDeviceMethod;
  }
  
  public Date getCreatedTime()
  {
    return createdTimeDate;
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public Date getEndTime()
  {
    return endTimeDate;
  }
  
  public JobQueryResponseError getError()
  {
    return error;
  }
  
  public String getFailureReason()
  {
    return failureReason;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public JobsStatisticsParser getJobStatistics()
  {
    return deviceJobStatistics;
  }
  
  public String getJobsStatus()
  {
    return jobsStatus;
  }
  
  public Date getLastUpdatedTimeDate()
  {
    return lastUpdatedTimeDate;
  }
  
  public Long getMaxExecutionTimeInSeconds()
  {
    return maxExecutionTimeInSeconds;
  }
  
  public MethodParser getOutcome()
  {
    return methodResponse;
  }
  
  public String getParentJobId()
  {
    return parentJobId;
  }
  
  public String getQueryCondition()
  {
    return queryCondition;
  }
  
  public Date getStartTime()
  {
    return startTimeDate;
  }
  
  public String getStatusMessage()
  {
    return statusMessage;
  }
  
  public String getType()
  {
    return type;
  }
  
  @Deprecated
  public TwinParser getUpdateTwin()
  {
    TwinParser localTwinParser = new TwinParser();
    try
    {
      localTwinParser.updateTwin(updateTwin.getDesiredProperty(), updateTwin.getReportedProperty(), updateTwin.getTags());
      return localTwinParser;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException(localIOException);
    }
  }
  
  public TwinState getUpdateTwinState()
  {
    return updateTwin;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.JobsResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */