package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Date;

public class DeviceParser
{
  public static final String AUTHENTICATION_NAME = "authentication";
  public static final String CAPABILITIES_NAME = "capabilities";
  public static final String CLOUD_TO_MESSAGE_COUNT_NAME = "cloudToDeviceMessageCount";
  public static final String CONNECTION_STATE_NAME = "connectionState";
  public static final String CONNECTION_STATE_UPDATED_TIME_NAME = "connectionStateUpdatedTime";
  public static final String DEVICE_ID_NAME = "deviceId";
  public static final String E_TAG_NAME = "etag";
  public static final String GENERATION_ID_NAME = "generationId";
  public static final String LAST_ACTIVITY_TIME_NAME = "lastActivityTime";
  public static final String MANAGED_BY = "managedBy";
  public static final String MODULE_ID_NAME = "moduleId";
  public static final String SCOPE_NAME = "deviceScope";
  public static final String STATUS_NAME = "status";
  public static final String STATUS_REASON = "statusReason";
  public static final String STATUS_UPDATED_TIME_NAME = "statusUpdatedTime";
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("authentication")
  public AuthenticationParser authenticationParser;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("capabilities")
  public DeviceCapabilitiesParser capabilities;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("cloudToDeviceMessageCount")
  public long cloudToDeviceMessageCount;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("connectionState")
  public String connectionState;
  public transient Date connectionStateUpdatedTime;
  @e.c.c.v.a(deserialize=false, serialize=true)
  @c("connectionStateUpdatedTime")
  public String connectionStateUpdatedTimeString;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("deviceId")
  public String deviceId;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("etag")
  public String eTag;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("generationId")
  public String generationId;
  public transient Gson gson = new Gson();
  public transient Date lastActivityTime;
  @e.c.c.v.a(deserialize=false, serialize=true)
  @c("lastActivityTime")
  public String lastActivityTimeString;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("managedBy")
  public String managedBy;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("moduleId")
  public String moduleId;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("deviceScope")
  public String scope;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("status")
  public String status;
  @e.c.c.v.a(deserialize=true, serialize=true)
  @c("statusReason")
  public String statusReason;
  public transient Date statusUpdatedTime;
  @e.c.c.v.a(deserialize=false, serialize=true)
  @c("statusUpdatedTime")
  public String statusUpdatedTimeString;
  
  public DeviceParser() {}
  
  public DeviceParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, DeviceParser.class);
        paramString = (DeviceParser)t.a(DeviceParser.class).cast(paramString);
        Object localObject = deviceId;
        if ((localObject != null) && (!((String)localObject).isEmpty()))
        {
          localObject = authenticationParser;
          if (localObject != null)
          {
            authenticationParser = ((AuthenticationParser)localObject);
            connectionState = connectionState;
            deviceId = deviceId;
            moduleId = moduleId;
            statusReason = statusReason;
            cloudToDeviceMessageCount = cloudToDeviceMessageCount;
            connectionState = connectionState;
            generationId = generationId;
            eTag = eTag;
            status = status;
            managedBy = managedBy;
            capabilities = capabilities;
            scope = scope;
            localObject = lastActivityTimeString;
            if (localObject != null)
            {
              lastActivityTimeString = ((String)localObject);
              lastActivityTime = ParserUtility.getDateTimeUtc(lastActivityTimeString);
            }
            localObject = connectionStateUpdatedTimeString;
            if (localObject != null)
            {
              connectionStateUpdatedTimeString = ((String)localObject);
              connectionStateUpdatedTime = ParserUtility.getDateTimeUtc(connectionStateUpdatedTimeString);
            }
            localObject = statusUpdatedTimeString;
            if (localObject != null)
            {
              statusUpdatedTimeString = ((String)localObject);
              statusUpdatedTime = ParserUtility.getDateTimeUtc(statusUpdatedTimeString);
            }
            return;
          }
          throw new IllegalArgumentException("The provided json must contain the field for authentication and its value may not be empty");
        }
        throw new IllegalArgumentException("The provided json must contain the field for deviceId and its value may not be empty");
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public AuthenticationParser getAuthenticationParser()
  {
    return authenticationParser;
  }
  
  public DeviceCapabilitiesParser getCapabilities()
  {
    return capabilities;
  }
  
  public long getCloudToDeviceMessageCount()
  {
    return cloudToDeviceMessageCount;
  }
  
  public String getConnectionState()
  {
    return connectionState;
  }
  
  public Date getConnectionStateUpdatedTime()
  {
    return connectionStateUpdatedTime;
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public String getGenerationId()
  {
    return generationId;
  }
  
  public Date getLastActivityTime()
  {
    return lastActivityTime;
  }
  
  public String getManagedBy()
  {
    return managedBy;
  }
  
  public String getModuleId()
  {
    return moduleId;
  }
  
  public String getScope()
  {
    return scope;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getStatusReason()
  {
    return statusReason;
  }
  
  public Date getStatusUpdatedTime()
  {
    return statusUpdatedTime;
  }
  
  public String geteTag()
  {
    return e.a.a.a.a.a(e.a.a.a.a.a("\""), eTag, "\"");
  }
  
  public void setAuthenticationParser(AuthenticationParser paramAuthenticationParser)
  {
    if (paramAuthenticationParser != null)
    {
      authenticationParser = paramAuthenticationParser;
      return;
    }
    throw new IllegalArgumentException("Authentication cannot not be null");
  }
  
  public void setCapabilities(DeviceCapabilitiesParser paramDeviceCapabilitiesParser)
  {
    capabilities = paramDeviceCapabilitiesParser;
  }
  
  public void setCloudToDeviceMessageCount(long paramLong)
  {
    cloudToDeviceMessageCount = paramLong;
  }
  
  public void setConnectionState(String paramString)
  {
    connectionState = paramString;
  }
  
  public void setConnectionStateUpdatedTime(Date paramDate)
  {
    connectionStateUpdatedTime = paramDate;
    if (paramDate == null) {
      connectionStateUpdatedTimeString = null;
    } else {
      connectionStateUpdatedTimeString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setDeviceId(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      deviceId = paramString;
      return;
    }
    throw new IllegalArgumentException("DeviceId cannot not be null");
  }
  
  public void setGenerationId(String paramString)
  {
    generationId = paramString;
  }
  
  public void setLastActivityTime(Date paramDate)
  {
    lastActivityTime = paramDate;
    if (paramDate == null) {
      lastActivityTimeString = null;
    } else {
      lastActivityTimeString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void setManagedBy(String paramString)
  {
    managedBy = paramString;
  }
  
  public void setModuleId(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      moduleId = paramString;
      return;
    }
    throw new IllegalArgumentException("DeviceId cannot not be null");
  }
  
  public void setScope(String paramString)
  {
    scope = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setStatusReason(String paramString)
  {
    statusReason = paramString;
  }
  
  public void setStatusUpdatedTime(Date paramDate)
  {
    statusUpdatedTime = paramDate;
    if (paramDate == null) {
      statusUpdatedTimeString = null;
    } else {
      statusUpdatedTimeString = ParserUtility.getDateStringFromDate(paramDate);
    }
  }
  
  public void seteTag(String paramString)
  {
    eTag = paramString;
  }
  
  public String toJson()
  {
    Date localDate = statusUpdatedTime;
    if (localDate != null) {
      statusUpdatedTimeString = ParserUtility.getDateStringFromDate(localDate);
    }
    localDate = connectionStateUpdatedTime;
    if (localDate != null) {
      connectionStateUpdatedTimeString = ParserUtility.getDateStringFromDate(localDate);
    }
    localDate = lastActivityTime;
    if (localDate != null) {
      lastActivityTimeString = ParserUtility.getDateStringFromDate(localDate);
    }
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.DeviceParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */