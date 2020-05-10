package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.a;
import e.c.c.v.c;

@Deprecated
public class RegisterManagerParser
{
  public static final String CONNECTION_STATE_TAG = "connectionState";
  public static final String CONNECTION_STATE_UPDATED_TIME_TAG = "connectionStateUpdatedTime";
  public static final String DEVICE_ID_TAG = "deviceId";
  public static final String ETAG_TAG = "etag";
  public static final String GENERATION_ID_TAG = "generationId";
  public static final String LAST_ACTIVITY_TIME_TAG = "lastActivityTime";
  public static final String STATUS_REASON_TAG = "statusReason";
  public static final String STATUS_TAG = "status";
  public static final String STATUS_UPDATED_TIME_TAG = "statusUpdatedTime";
  public static final String VERSION_TAG = "version";
  @a(deserialize=true, serialize=true)
  @c("connectionState")
  public TwinConnectionState connectionState = null;
  @a(deserialize=true, serialize=true)
  @c("connectionStateUpdatedTime")
  public String connectionStateUpdatedTime = null;
  @a(deserialize=true, serialize=true)
  @c("deviceId")
  public String deviceId = null;
  @a(deserialize=true, serialize=true)
  @c("etag")
  public String eTag = null;
  @a(deserialize=true, serialize=true)
  @c("generationId")
  public String generationId = null;
  @a(deserialize=true, serialize=true)
  @c("lastActivityTime")
  public String lastActivityTime = null;
  @a(deserialize=true, serialize=true)
  @c("status")
  public TwinStatus status = null;
  @a(deserialize=true, serialize=true)
  @c("statusReason")
  public String statusReason = null;
  @a(deserialize=true, serialize=true)
  @c("statusUpdatedTime")
  public String statusUpdatedTime = null;
  @a(deserialize=true, serialize=true)
  @c("version")
  public Integer version = null;
  
  public boolean setDeviceId(String paramString)
  {
    validateDeviceManager(paramString, null, null);
    String str = deviceId;
    if ((str == null) || (paramString == null) || (!str.equals(paramString)))
    {
      deviceId = paramString;
      if (paramString != null) {
        return true;
      }
    }
    return false;
  }
  
  public boolean setStatus(TwinStatus paramTwinStatus, String paramString)
  {
    validateDeviceManager(null, paramTwinStatus, paramString);
    if (paramTwinStatus == null)
    {
      if (status != null) {
        return true;
      }
      status = null;
      statusReason = null;
      statusUpdatedTime = null;
    }
    else
    {
      if (paramString == null) {
        break label76;
      }
      TwinStatus localTwinStatus = status;
      if ((localTwinStatus == null) || (!localTwinStatus.equals(paramTwinStatus))) {
        break label64;
      }
    }
    return false;
    label64:
    status = paramTwinStatus;
    statusReason = paramString;
    return true;
    label76:
    throw new IllegalArgumentException("Change status without statusReason");
  }
  
  public void validateDeviceManager(String paramString1, TwinStatus paramTwinStatus, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 128)) {
      throw new IllegalArgumentException("DeviceId bigger than 128 chars");
    }
    if ((paramTwinStatus != null) && (paramString2 == null)) {
      throw new IllegalArgumentException("Change status without statusReason");
    }
    if ((paramString2 != null) && (paramString2.length() > 128)) {
      throw new IllegalArgumentException("StatusReason bigger than 128 chars");
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.RegisterManagerParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */