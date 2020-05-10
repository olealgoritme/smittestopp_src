package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class PageLogFactory
  extends AbstractLogFactory
{
  public PageLog create()
  {
    return new PageLog();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.json.PageLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */