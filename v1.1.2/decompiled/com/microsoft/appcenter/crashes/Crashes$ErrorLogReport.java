package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;

public class Crashes$ErrorLogReport
{
  public final ManagedErrorLog log;
  public final ErrorReport report;
  
  public Crashes$ErrorLogReport(ManagedErrorLog paramManagedErrorLog, ErrorReport paramErrorReport)
  {
    log = paramManagedErrorLog;
    report = paramErrorReport;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.ErrorLogReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */