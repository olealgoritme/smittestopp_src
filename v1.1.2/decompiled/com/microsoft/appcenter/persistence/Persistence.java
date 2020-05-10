package com.microsoft.appcenter.persistence;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;

public abstract class Persistence
  implements Closeable
{
  public LogSerializer mLogSerializer;
  
  public abstract void clearPendingLogState();
  
  public abstract int countLogs(String paramString);
  
  public abstract void deleteLogs(String paramString);
  
  public abstract void deleteLogs(String paramString1, String paramString2);
  
  public LogSerializer getLogSerializer()
  {
    LogSerializer localLogSerializer = mLogSerializer;
    if (localLogSerializer != null) {
      return localLogSerializer;
    }
    throw new IllegalStateException("logSerializer not configured");
  }
  
  public abstract String getLogs(String paramString, Collection<String> paramCollection, int paramInt, List<Log> paramList);
  
  public abstract long putLog(Log paramLog, String paramString, int paramInt);
  
  public void setLogSerializer(LogSerializer paramLogSerializer)
  {
    mLogSerializer = paramLogSerializer;
  }
  
  public abstract boolean setMaxStorageSize(long paramLong);
  
  public static class PersistenceException
    extends Exception
  {
    public PersistenceException(String paramString)
    {
      super();
    }
    
    public PersistenceException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.persistence.Persistence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */