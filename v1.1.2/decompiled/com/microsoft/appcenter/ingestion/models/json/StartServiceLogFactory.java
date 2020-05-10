package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;

public class StartServiceLogFactory
  extends AbstractLogFactory
{
  public Log create()
  {
    return new StartServiceLog();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.StartServiceLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */