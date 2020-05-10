package com.microsoft.appcenter.analytics.ingestion.models.one.json;

import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class CommonSchemaEventLogFactory
  extends AbstractLogFactory
{
  public CommonSchemaEventLog create()
  {
    return new CommonSchemaEventLog();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.one.json.CommonSchemaEventLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */