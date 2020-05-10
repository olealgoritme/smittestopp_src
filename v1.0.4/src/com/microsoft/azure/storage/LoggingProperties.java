package com.microsoft.azure.storage;

import java.util.EnumSet;

public final class LoggingProperties
{
  public EnumSet<LoggingOperations> logOperationTypes = EnumSet.noneOf(LoggingOperations.class);
  public Integer retentionIntervalInDays;
  public String version = "1.0";
  
  public EnumSet<LoggingOperations> getLogOperationTypes()
  {
    return logOperationTypes;
  }
  
  public Integer getRetentionIntervalInDays()
  {
    return retentionIntervalInDays;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public void setLogOperationTypes(EnumSet<LoggingOperations> paramEnumSet)
  {
    logOperationTypes = paramEnumSet;
  }
  
  public void setRetentionIntervalInDays(Integer paramInteger)
  {
    retentionIntervalInDays = paramInteger;
  }
  
  public void setVersion(String paramString)
  {
    version = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.LoggingProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */