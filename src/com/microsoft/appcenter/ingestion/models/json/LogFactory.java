package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.Collection;

public abstract interface LogFactory
{
  public abstract Log create();
  
  public abstract Collection<CommonSchemaLog> toCommonSchemaLogs(Log paramLog);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.LogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */