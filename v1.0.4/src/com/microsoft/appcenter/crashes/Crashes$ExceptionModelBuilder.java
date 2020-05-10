package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.Exception;

public abstract interface Crashes$ExceptionModelBuilder
{
  public abstract Exception buildExceptionModel();
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.ExceptionModelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */