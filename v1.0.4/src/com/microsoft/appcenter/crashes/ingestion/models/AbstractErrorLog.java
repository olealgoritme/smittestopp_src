package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractErrorLog
  extends AbstractLog
{
  public static final String APP_LAUNCH_TIMESTAMP = "appLaunchTimestamp";
  public static final String ARCHITECTURE = "architecture";
  public static final String ERROR_THREAD_ID = "errorThreadId";
  public static final String ERROR_THREAD_NAME = "errorThreadName";
  public static final String FATAL = "fatal";
  public static final String PARENT_PROCESS_ID = "parentProcessId";
  public static final String PARENT_PROCESS_NAME = "parentProcessName";
  public static final String PROCESS_ID = "processId";
  public static final String PROCESS_NAME = "processName";
  public Date appLaunchTimestamp;
  public String architecture;
  public Long errorThreadId;
  public String errorThreadName;
  public Boolean fatal;
  public UUID id;
  public Integer parentProcessId;
  public String parentProcessName;
  public Integer processId;
  public String processName;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (AbstractErrorLog)paramObject;
      Object localObject = id;
      if (localObject != null ? !((UUID)localObject).equals(id) : id != null) {
        return false;
      }
      localObject = processId;
      if (localObject != null ? !((Integer)localObject).equals(processId) : processId != null) {
        return false;
      }
      localObject = processName;
      if (localObject != null ? !((String)localObject).equals(processName) : processName != null) {
        return false;
      }
      localObject = parentProcessId;
      if (localObject != null ? !((Integer)localObject).equals(parentProcessId) : parentProcessId != null) {
        return false;
      }
      localObject = parentProcessName;
      if (localObject != null ? !((String)localObject).equals(parentProcessName) : parentProcessName != null) {
        return false;
      }
      localObject = errorThreadId;
      if (localObject != null ? !((Long)localObject).equals(errorThreadId) : errorThreadId != null) {
        return false;
      }
      localObject = errorThreadName;
      if (localObject != null ? !((String)localObject).equals(errorThreadName) : errorThreadName != null) {
        return false;
      }
      localObject = fatal;
      if (localObject != null ? !((Boolean)localObject).equals(fatal) : fatal != null) {
        return false;
      }
      localObject = appLaunchTimestamp;
      if (localObject != null ? !((Date)localObject).equals(appLaunchTimestamp) : appLaunchTimestamp != null) {
        return false;
      }
      localObject = architecture;
      paramObject = architecture;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Date getAppLaunchTimestamp()
  {
    return appLaunchTimestamp;
  }
  
  public String getArchitecture()
  {
    return architecture;
  }
  
  public Long getErrorThreadId()
  {
    return errorThreadId;
  }
  
  public String getErrorThreadName()
  {
    return errorThreadName;
  }
  
  public Boolean getFatal()
  {
    return fatal;
  }
  
  public UUID getId()
  {
    return id;
  }
  
  public Integer getParentProcessId()
  {
    return parentProcessId;
  }
  
  public String getParentProcessName()
  {
    return parentProcessName;
  }
  
  public Integer getProcessId()
  {
    return processId;
  }
  
  public String getProcessName()
  {
    return processName;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = id;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((UUID)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = processId;
    int m;
    if (localObject != null) {
      m = ((Integer)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = processName;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = parentProcessId;
    int i1;
    if (localObject != null) {
      i1 = ((Integer)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = parentProcessName;
    int i2;
    if (localObject != null) {
      i2 = ((String)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = errorThreadId;
    int i3;
    if (localObject != null) {
      i3 = ((Long)localObject).hashCode();
    } else {
      i3 = 0;
    }
    localObject = errorThreadName;
    int i4;
    if (localObject != null) {
      i4 = ((String)localObject).hashCode();
    } else {
      i4 = 0;
    }
    localObject = fatal;
    int i5;
    if (localObject != null) {
      i5 = ((Boolean)localObject).hashCode();
    } else {
      i5 = 0;
    }
    localObject = appLaunchTimestamp;
    int i6;
    if (localObject != null) {
      i6 = ((Date)localObject).hashCode();
    } else {
      i6 = 0;
    }
    localObject = architecture;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    }
    return (((((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setId(UUID.fromString(paramJSONObject.getString("id")));
    setProcessId(JSONUtils.readInteger(paramJSONObject, "processId"));
    setProcessName(paramJSONObject.optString("processName", null));
    setParentProcessId(JSONUtils.readInteger(paramJSONObject, "parentProcessId"));
    setParentProcessName(paramJSONObject.optString("parentProcessName", null));
    setErrorThreadId(JSONUtils.readLong(paramJSONObject, "errorThreadId"));
    setErrorThreadName(paramJSONObject.optString("errorThreadName", null));
    setFatal(JSONUtils.readBoolean(paramJSONObject, "fatal"));
    setAppLaunchTimestamp(JSONDateUtils.toDate(paramJSONObject.getString("appLaunchTimestamp")));
    setArchitecture(paramJSONObject.optString("architecture", null));
  }
  
  public void setAppLaunchTimestamp(Date paramDate)
  {
    appLaunchTimestamp = paramDate;
  }
  
  public void setArchitecture(String paramString)
  {
    architecture = paramString;
  }
  
  public void setErrorThreadId(Long paramLong)
  {
    errorThreadId = paramLong;
  }
  
  public void setErrorThreadName(String paramString)
  {
    errorThreadName = paramString;
  }
  
  public void setFatal(Boolean paramBoolean)
  {
    fatal = paramBoolean;
  }
  
  public void setId(UUID paramUUID)
  {
    id = paramUUID;
  }
  
  public void setParentProcessId(Integer paramInteger)
  {
    parentProcessId = paramInteger;
  }
  
  public void setParentProcessName(String paramString)
  {
    parentProcessName = paramString;
  }
  
  public void setProcessId(Integer paramInteger)
  {
    processId = paramInteger;
  }
  
  public void setProcessName(String paramString)
  {
    processName = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    JSONUtils.write(paramJSONStringer, "id", getId());
    JSONUtils.write(paramJSONStringer, "processId", getProcessId());
    JSONUtils.write(paramJSONStringer, "processName", getProcessName());
    JSONUtils.write(paramJSONStringer, "parentProcessId", getParentProcessId());
    JSONUtils.write(paramJSONStringer, "parentProcessName", getParentProcessName());
    JSONUtils.write(paramJSONStringer, "errorThreadId", getErrorThreadId());
    JSONUtils.write(paramJSONStringer, "errorThreadName", getErrorThreadName());
    JSONUtils.write(paramJSONStringer, "fatal", getFatal());
    JSONUtils.write(paramJSONStringer, "appLaunchTimestamp", JSONDateUtils.toString(getAppLaunchTimestamp()));
    JSONUtils.write(paramJSONStringer, "architecture", getArchitecture());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */