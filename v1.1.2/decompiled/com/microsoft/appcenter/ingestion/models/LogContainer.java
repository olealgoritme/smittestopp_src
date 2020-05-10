package com.microsoft.appcenter.ingestion.models;

import java.util.List;

public class LogContainer
{
  public List<Log> logs;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (LogContainer.class == paramObject.getClass()))
    {
      Object localObject = (LogContainer)paramObject;
      paramObject = logs;
      localObject = logs;
      if (paramObject != null) {
        bool = ((List)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public List<Log> getLogs()
  {
    return logs;
  }
  
  public int hashCode()
  {
    List localList = logs;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void setLogs(List<Log> paramList)
  {
    logs = paramList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.LogContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */