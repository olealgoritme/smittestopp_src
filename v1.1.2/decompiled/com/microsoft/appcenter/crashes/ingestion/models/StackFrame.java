package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StackFrame
  implements Model
{
  public static final String CLASS_NAME = "className";
  public static final String FILE_NAME = "fileName";
  public static final String LINE_NUMBER = "lineNumber";
  public static final String METHOD_NAME = "methodName";
  public String className;
  public String fileName;
  public Integer lineNumber;
  public String methodName;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (StackFrame.class == paramObject.getClass()))
    {
      paramObject = (StackFrame)paramObject;
      Object localObject = className;
      if (localObject != null ? !((String)localObject).equals(className) : className != null) {
        return false;
      }
      localObject = methodName;
      if (localObject != null ? !((String)localObject).equals(methodName) : methodName != null) {
        return false;
      }
      localObject = lineNumber;
      if (localObject != null ? !((Integer)localObject).equals(lineNumber) : lineNumber != null) {
        return false;
      }
      localObject = fileName;
      paramObject = fileName;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getClassName()
  {
    return className;
  }
  
  public String getFileName()
  {
    return fileName;
  }
  
  public Integer getLineNumber()
  {
    return lineNumber;
  }
  
  public String getMethodName()
  {
    return methodName;
  }
  
  public int hashCode()
  {
    Object localObject = className;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = methodName;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = lineNumber;
    int m;
    if (localObject != null) {
      m = ((Integer)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = fileName;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setClassName(paramJSONObject.optString("className", null));
    setMethodName(paramJSONObject.optString("methodName", null));
    setLineNumber(JSONUtils.readInteger(paramJSONObject, "lineNumber"));
    setFileName(paramJSONObject.optString("fileName", null));
  }
  
  public void setClassName(String paramString)
  {
    className = paramString;
  }
  
  public void setFileName(String paramString)
  {
    fileName = paramString;
  }
  
  public void setLineNumber(Integer paramInteger)
  {
    lineNumber = paramInteger;
  }
  
  public void setMethodName(String paramString)
  {
    methodName = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "className", getClassName());
    JSONUtils.write(paramJSONStringer, "methodName", getMethodName());
    JSONUtils.write(paramJSONStringer, "lineNumber", getLineNumber());
    JSONUtils.write(paramJSONStringer, "fileName", getFileName());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.StackFrame
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */