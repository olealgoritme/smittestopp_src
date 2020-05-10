package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.AbstractLog;

public class StartSessionLog
  extends AbstractLog
{
  public static final String TYPE = "startSession";
  
  public String getType()
  {
    return "startSession";
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */