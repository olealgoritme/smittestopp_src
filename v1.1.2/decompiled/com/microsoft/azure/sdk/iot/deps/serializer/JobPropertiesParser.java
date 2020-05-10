package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Date;

public class JobPropertiesParser
{
  public static final String END_TIME_UTC_NAME = "endTimeUtc";
  public static final String EXCLUDE_KEYS_IN_EXPORT_NAME = "excludeKeysInExport";
  public static final String FAILURE_REASON_NAME = "failureReason";
  public static final String INPUT_BLOB_CONTAINER_URI_NAME = "inputBlobContainerUri";
  public static final String JOB_ID_NAME = "jobId";
  public static final String OUTPUT_BLOB_CONTAINER_URI_NAME = "outputBlobContainerUri";
  public static final String PROGRESS_NAME = "progress";
  public static final String START_TIME_UTC_NAME = "startTimeUtc";
  public static final String STATUS_NAME = "status";
  public static final String STORAGE_AUTHENTICATION_TYPE = "storageAuthenticationType";
  public static final String TYPE_NAME = "type";
  public static transient Gson gson = new Gson();
  public transient Date endTimeUtc;
  @a(deserialize=true, serialize=true)
  @c("endTimeUtc")
  public String endTimeUtcString;
  @a(deserialize=true, serialize=true)
  @c("excludeKeysInExport")
  public boolean excludeKeysInExport;
  @a(deserialize=true, serialize=true)
  @c("failureReason")
  public String failureReason;
  @a(deserialize=true, serialize=true)
  @c("inputBlobContainerUri")
  public String inputBlobContainerUri;
  @a(deserialize=true, serialize=true)
  @c("jobId")
  public String jobId;
  @a(deserialize=true, serialize=true)
  @c("outputBlobContainerUri")
  public String outputBlobContainerUri;
  @a(deserialize=true, serialize=true)
  @c("progress")
  public int progress;
  public transient Date startTimeUtc;
  @a(deserialize=true, serialize=true)
  @c("startTimeUtc")
  public String startTimeUtcString;
  @a(deserialize=true, serialize=true)
  @c("status")
  public String status;
  @a(deserialize=true, serialize=true)
  @c("storageAuthenticationType")
  public StorageAuthenticationType storageAuthenticationType;
  @a(deserialize=true, serialize=true)
  @c("type")
  public String type;
  
  public JobPropertiesParser() {}
  
  public JobPropertiesParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, JobPropertiesParser.class);
        paramString = (JobPropertiesParser)t.a(JobPropertiesParser.class).cast(paramString);
        if ((paramString.getJobIdFinal() != null) && (!paramString.getJobIdFinal().isEmpty()))
        {
          inputBlobContainerUri = inputBlobContainerUri;
          type = type;
          status = status;
          jobId = jobId;
          excludeKeysInExport = excludeKeysInExport;
          progress = progress;
          outputBlobContainerUri = outputBlobContainerUri;
          failureReason = failureReason;
          storageAuthenticationType = storageAuthenticationType;
          String str = endTimeUtcString;
          if (str != null)
          {
            endTimeUtcString = str;
            endTimeUtc = ParserUtility.getDateTimeUtc(endTimeUtcString);
          }
          str = startTimeUtcString;
          if (str != null)
          {
            startTimeUtcString = str;
            startTimeUtc = ParserUtility.getDateTimeUtc(startTimeUtcString);
          }
          return;
        }
        throw new IllegalArgumentException("The provided json is missing the jobId field");
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public Date getEndTimeUtc()
  {
    return endTimeUtc;
  }
  
  public String getFailureReason()
  {
    return failureReason;
  }
  
  public String getInputBlobContainerUri()
  {
    return inputBlobContainerUri;
  }
  
  @Deprecated
  public String getJobId()
  {
    return jobId;
  }
  
  public final String getJobIdFinal()
  {
    return jobId;
  }
  
  public String getOutputBlobContainerUri()
  {
    return outputBlobContainerUri;
  }
  
  public int getProgress()
  {
    return progress;
  }
  
  public Date getStartTimeUtc()
  {
    return startTimeUtc;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public StorageAuthenticationType getStorageAuthenticationType()
  {
    return storageAuthenticationType;
  }
  
  public String getType()
  {
    return type;
  }
  
  public boolean isExcludeKeysInExport()
  {
    return excludeKeysInExport;
  }
  
  public void setEndTimeUtc(Date paramDate)
  {
    endTimeUtc = paramDate;
    if (paramDate == null) {
      endTimeUtcString = null;
    } else {
      endTimeUtcString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setExcludeKeysInExport(boolean paramBoolean)
  {
    excludeKeysInExport = paramBoolean;
  }
  
  public void setFailureReason(String paramString)
  {
    failureReason = paramString;
  }
  
  public void setInputBlobContainerUri(String paramString)
  {
    inputBlobContainerUri = paramString;
  }
  
  public void setJobId(String paramString)
  {
    if (paramString != null)
    {
      jobId = paramString;
      return;
    }
    throw new IllegalArgumentException("jobId cannot be null");
  }
  
  public void setOutputBlobContainerUri(String paramString)
  {
    outputBlobContainerUri = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    progress = paramInt;
  }
  
  public void setStartTimeUtc(Date paramDate)
  {
    startTimeUtc = paramDate;
    if (paramDate == null) {
      startTimeUtcString = null;
    } else {
      startTimeUtcString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setStorageAuthenticationType(StorageAuthenticationType paramStorageAuthenticationType)
  {
    storageAuthenticationType = paramStorageAuthenticationType;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public String toJson()
  {
    Date localDate = startTimeUtc;
    if (localDate != null) {
      startTimeUtcString = ParserUtility.getDateStringFromDate(localDate);
    }
    localDate = endTimeUtc;
    if (localDate != null) {
      endTimeUtcString = ParserUtility.getDateStringFromDate(localDate);
    }
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.JobPropertiesParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */