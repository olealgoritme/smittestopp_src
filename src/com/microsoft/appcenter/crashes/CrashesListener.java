package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;

public abstract interface CrashesListener
{
  public abstract Iterable<ErrorAttachmentLog> getErrorAttachments(ErrorReport paramErrorReport);
  
  public abstract void onBeforeSending(ErrorReport paramErrorReport);
  
  public abstract void onSendingFailed(ErrorReport paramErrorReport, Exception paramException);
  
  public abstract void onSendingSucceeded(ErrorReport paramErrorReport);
  
  public abstract boolean shouldAwaitUserConfirmation();
  
  public abstract boolean shouldProcess(ErrorReport paramErrorReport);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.CrashesListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */