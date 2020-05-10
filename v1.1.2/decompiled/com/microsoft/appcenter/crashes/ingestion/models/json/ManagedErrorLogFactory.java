package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ManagedErrorLogFactory
  extends AbstractLogFactory
{
  public static final ManagedErrorLogFactory sInstance = new ManagedErrorLogFactory();
  
  public static ManagedErrorLogFactory getInstance()
  {
    return sInstance;
  }
  
  public ManagedErrorLog create()
  {
    return new ManagedErrorLog();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.json.ManagedErrorLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */