package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Date;

public class FileUploadNotificationParser
{
  public static final String BLOB_NAME_TAG = "blobName";
  public static final String BLOB_SIZE_IN_BYTES_TAG = "blobSizeInBytes";
  public static final String BLOB_URI_TAG = "blobUri";
  public static final String DEVICE_ID_TAG = "deviceId";
  public static final String ENQUEUED_TIME_UTC_TAG = "enqueuedTimeUtc";
  public static final String LAST_UPDATED_TIME_TAG = "lastUpdatedTime";
  @a(deserialize=true, serialize=true)
  @c("blobName")
  public String blobName = null;
  @a(deserialize=true, serialize=true)
  @c("blobSizeInBytes")
  public Long blobSizeInBytes = null;
  @a(deserialize=true, serialize=true)
  @c("blobUri")
  public String blobUri = null;
  @a(deserialize=true, serialize=true)
  @c("deviceId")
  public String deviceId = null;
  @a(deserialize=true, serialize=true)
  @c("enqueuedTimeUtc")
  public String enqueuedTimeUtc = null;
  public transient Date enqueuedTimeUtcDate;
  @a(deserialize=true, serialize=true)
  @c("lastUpdatedTime")
  public String lastUpdatedTime = null;
  public transient Date lastUpdatedTimeDate;
  
  public FileUploadNotificationParser() {}
  
  public FileUploadNotificationParser(String paramString)
  {
    Object localObject = new e();
    l = false;
    g = true;
    localObject = ((e)localObject).a();
    ParserUtility.validateStringUTF8(paramString);
    try
    {
      paramString = ((Gson)localObject).a(paramString, FileUploadNotificationParser.class);
      paramString = (FileUploadNotificationParser)t.a(FileUploadNotificationParser.class).cast(paramString);
      ParserUtility.validateStringUTF8(deviceId);
      ParserUtility.validateStringUTF8(blobUri);
      ParserUtility.validateBlobName(blobName);
      ParserUtility.validateStringUTF8(enqueuedTimeUtc);
      ParserUtility.validateStringUTF8(lastUpdatedTime);
      localObject = blobSizeInBytes;
      if (localObject == null) {
        blobSizeInBytes = Long.valueOf(0L);
      } else {
        if (((Long)localObject).longValue() < 0L) {
          break label216;
        }
      }
      deviceId = deviceId;
      blobUri = blobUri;
      blobName = blobName;
      lastUpdatedTime = lastUpdatedTime;
      localObject = enqueuedTimeUtc;
      enqueuedTimeUtc = ((String)localObject);
      blobSizeInBytes = blobSizeInBytes;
      enqueuedTimeUtcDate = ParserUtility.getDateTimeUtc((String)localObject);
      lastUpdatedTimeDate = ParserUtility.stringToDateTimeOffset(lastUpdatedTime);
      return;
      label216:
      throw new IllegalArgumentException("negative size");
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Malformed json:");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  public String getBlobName()
  {
    return blobName;
  }
  
  public Long getBlobSizeInBytesTag()
  {
    return blobSizeInBytes;
  }
  
  public String getBlobUri()
  {
    return blobUri;
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public Date getEnqueuedTimeUtc()
  {
    return enqueuedTimeUtcDate;
  }
  
  public Date getLastUpdatedTime()
  {
    return lastUpdatedTimeDate;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.FileUploadNotificationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */