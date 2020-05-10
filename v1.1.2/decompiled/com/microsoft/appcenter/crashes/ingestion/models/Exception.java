package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.ExceptionFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Exception
  implements Model
{
  public static final String INNER_EXCEPTIONS = "innerExceptions";
  public static final String MESSAGE = "message";
  public static final String MINIDUMP_FILE_PATH = "minidumpFilePath";
  public static final String STACK_TRACE = "stackTrace";
  public static final String WRAPPER_SDK_NAME = "wrapperSdkName";
  public List<StackFrame> frames;
  public List<Exception> innerExceptions;
  public String message;
  public String minidumpFilePath;
  public String stackTrace;
  public String type;
  public String wrapperSdkName;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Exception.class == paramObject.getClass()))
    {
      paramObject = (Exception)paramObject;
      Object localObject = type;
      if (localObject != null ? !((String)localObject).equals(type) : type != null) {
        return false;
      }
      localObject = message;
      if (localObject != null ? !((String)localObject).equals(message) : message != null) {
        return false;
      }
      localObject = stackTrace;
      if (localObject != null ? !((String)localObject).equals(stackTrace) : stackTrace != null) {
        return false;
      }
      localObject = frames;
      if (localObject != null ? !((List)localObject).equals(frames) : frames != null) {
        return false;
      }
      localObject = innerExceptions;
      if (localObject != null ? !((List)localObject).equals(innerExceptions) : innerExceptions != null) {
        return false;
      }
      localObject = wrapperSdkName;
      if (localObject != null ? !((String)localObject).equals(wrapperSdkName) : wrapperSdkName != null) {
        return false;
      }
      localObject = minidumpFilePath;
      paramObject = minidumpFilePath;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public List<StackFrame> getFrames()
  {
    return frames;
  }
  
  public List<Exception> getInnerExceptions()
  {
    return innerExceptions;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getMinidumpFilePath()
  {
    return minidumpFilePath;
  }
  
  public String getStackTrace()
  {
    return stackTrace;
  }
  
  public String getType()
  {
    return type;
  }
  
  public String getWrapperSdkName()
  {
    return wrapperSdkName;
  }
  
  public int hashCode()
  {
    Object localObject = type;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = message;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = stackTrace;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = frames;
    int n;
    if (localObject != null) {
      n = ((List)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = innerExceptions;
    int i1;
    if (localObject != null) {
      i1 = ((List)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = wrapperSdkName;
    int i2;
    if (localObject != null) {
      i2 = ((String)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = minidumpFilePath;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    }
    return (((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setType(paramJSONObject.optString("type", null));
    setMessage(paramJSONObject.optString("message", null));
    setStackTrace(paramJSONObject.optString("stackTrace", null));
    setFrames(JSONUtils.readArray(paramJSONObject, "frames", StackFrameFactory.getInstance()));
    setInnerExceptions(JSONUtils.readArray(paramJSONObject, "innerExceptions", ExceptionFactory.getInstance()));
    setWrapperSdkName(paramJSONObject.optString("wrapperSdkName", null));
    setMinidumpFilePath(paramJSONObject.optString("minidumpFilePath", null));
  }
  
  public void setFrames(List<StackFrame> paramList)
  {
    frames = paramList;
  }
  
  public void setInnerExceptions(List<Exception> paramList)
  {
    innerExceptions = paramList;
  }
  
  public void setMessage(String paramString)
  {
    message = paramString;
  }
  
  public void setMinidumpFilePath(String paramString)
  {
    minidumpFilePath = paramString;
  }
  
  public void setStackTrace(String paramString)
  {
    stackTrace = paramString;
  }
  
  public void setType(String paramString)
  {
    type = paramString;
  }
  
  public void setWrapperSdkName(String paramString)
  {
    wrapperSdkName = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "type", getType());
    JSONUtils.write(paramJSONStringer, "message", getMessage());
    JSONUtils.write(paramJSONStringer, "stackTrace", getStackTrace());
    JSONUtils.writeArray(paramJSONStringer, "frames", getFrames());
    JSONUtils.writeArray(paramJSONStringer, "innerExceptions", getInnerExceptions());
    JSONUtils.write(paramJSONStringer, "wrapperSdkName", getWrapperSdkName());
    JSONUtils.write(paramJSONStringer, "minidumpFilePath", getMinidumpFilePath());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.Exception
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */