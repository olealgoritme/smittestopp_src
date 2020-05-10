package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class StartSessionLogFactory
  extends AbstractLogFactory
{
  public StartSessionLog create()
  {
    return new StartSessionLog();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.ingestion.models.json.StartSessionLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */