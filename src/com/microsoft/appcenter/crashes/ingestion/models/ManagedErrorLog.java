package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.ThreadFactory;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ManagedErrorLog
  extends AbstractErrorLog
{
  public static final String EXCEPTION = "exception";
  public static final String THREADS = "threads";
  public static final String TYPE = "managedError";
  public Exception exception;
  public List<Thread> threads;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ManagedErrorLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (ManagedErrorLog)paramObject;
      Object localObject = exception;
      if (localObject != null ? !((Exception)localObject).equals(exception) : exception != null) {
        return false;
      }
      localObject = threads;
      paramObject = threads;
      if (localObject != null) {
        bool = ((List)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  public List<Thread> getThreads()
  {
    return threads;
  }
  
  public String getType()
  {
    return "managedError";
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = exception;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((Exception)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = threads;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    if (paramJSONObject.has("exception"))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("exception");
      Exception localException = new Exception();
      localException.read(localJSONObject);
      setException(localException);
    }
    setThreads(JSONUtils.readArray(paramJSONObject, "threads", ThreadFactory.getInstance()));
  }
  
  public void setException(Exception paramException)
  {
    exception = paramException;
  }
  
  public void setThreads(List<Thread> paramList)
  {
    threads = paramList;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    if (getException() != null)
    {
      paramJSONStringer.key("exception").object();
      exception.write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
    JSONUtils.writeArray(paramJSONStringer, "threads", getThreads());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */