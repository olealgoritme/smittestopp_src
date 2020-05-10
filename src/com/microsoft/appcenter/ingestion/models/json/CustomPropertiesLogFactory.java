package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.CustomPropertiesLog;
import com.microsoft.appcenter.ingestion.models.Log;

public class CustomPropertiesLogFactory
  extends AbstractLogFactory
{
  public Log create()
  {
    return new CustomPropertiesLog();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.CustomPropertiesLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */