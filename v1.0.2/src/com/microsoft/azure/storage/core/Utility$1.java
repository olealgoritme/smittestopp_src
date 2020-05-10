package com.microsoft.azure.storage.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class Utility$1
  extends ThreadLocal<DateFormat>
{
  public DateFormat initialValue()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Utility.LOCALE_US);
    localSimpleDateFormat.setTimeZone(Utility.GMT_ZONE);
    return localSimpleDateFormat;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.Utility.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */