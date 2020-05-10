package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;

public class Crashes$7
  implements Crashes.ExceptionModelBuilder
{
  public Crashes$7(Crashes paramCrashes, Throwable paramThrowable) {}
  
  public Exception buildExceptionModel()
  {
    return ErrorLogHelper.getModelExceptionFromThrowable(val$throwable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */