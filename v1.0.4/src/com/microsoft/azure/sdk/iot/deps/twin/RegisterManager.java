package com.microsoft.azure.sdk.iot.deps.twin;

import com.microsoft.azure.sdk.iot.deps.serializer.ParserUtility;
import e.c.c.v.a;
import e.c.c.v.c;

public class RegisterManager
{
  public static final String CAPABILITIES_TAG = "capabilities";
  public static final String CONNECTION_STATE_TAG = "connectionState";
  public static final String CONNECTION_STATE_UPDATED_TIME_TAG = "connectionStateUpdatedTime";
  public static final String DEVICE_ID_TAG = "deviceId";
  public static final String ETAG_TAG = "etag";
  public static final String GENERATION_ID_TAG = "generationId";
  public static final String LAST_ACTIVITY_TIME_TAG = "lastActivityTime";
  public static final String MODULE_ID_TAG = "moduleId";
  public static final String STATUS_REASON_TAG = "statusReason";
  public static final String STATUS_TAG = "status";
  public static final String STATUS_UPDATED_TIME_TAG = "statusUpdatedTime";
  public static final String VERSION_TAG = "version";
  @a(deserialize=true, serialize=true)
  @c("capabilities")
  public DeviceCapabilities capabilities = null;
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
  @c("moduleId")
  public String moduleId = null;
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
  
  public DeviceCapabilities getCapabilities()
  {
    return capabilities;
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public String getModuleId()
  {
    return moduleId;
  }
  
  public Integer getVersion()
  {
    return version;
  }
  
  public void setCapabilities(DeviceCapabilities paramDeviceCapabilities)
  {
    capabilities = paramDeviceCapabilities;
  }
  
  public void setDeviceId(String paramString)
  {
    ParserUtility.validateId(paramString);
    deviceId = paramString;
  }
  
  public void setETag(String paramString)
  {
    eTag = paramString;
  }
  
  public void setModuleId(String paramString)
  {
    ParserUtility.validateId(paramString);
    moduleId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.RegisterManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */