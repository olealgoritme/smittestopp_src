package com.microsoft.appcenter.analytics.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;

public class CommonSchemaEventLog
  extends CommonSchemaLog
{
  public static final String TYPE = "commonSchemaEvent";
  
  public String getType()
  {
    return "commonSchemaEvent";
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */