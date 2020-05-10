package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;

public abstract class AbstractCrashesListener
  implements CrashesListener
{
  public Iterable<ErrorAttachmentLog> getErrorAttachments(ErrorReport paramErrorReport)
  {
    return null;
  }
  
  public void onBeforeSending(ErrorReport paramErrorReport) {}
  
  public void onSendingFailed(ErrorReport paramErrorReport, Exception paramException) {}
  
  public void onSendingSucceeded(ErrorReport paramErrorReport) {}
  
  public boolean shouldAwaitUserConfirmation()
  {
    return false;
  }
  
  public boolean shouldProcess(ErrorReport paramErrorReport)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.AbstractCrashesListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */