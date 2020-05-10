package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.Collection;

public abstract interface LogSerializer
{
  public abstract void addLogFactory(String paramString, LogFactory paramLogFactory);
  
  public abstract LogContainer deserializeContainer(String paramString1, String paramString2);
  
  public abstract Log deserializeLog(String paramString1, String paramString2);
  
  public abstract String serializeContainer(LogContainer paramLogContainer);
  
  public abstract String serializeLog(Log paramLog);
  
  public abstract Collection<CommonSchemaLog> toCommonSchemaLog(Log paramLog);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.LogSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */