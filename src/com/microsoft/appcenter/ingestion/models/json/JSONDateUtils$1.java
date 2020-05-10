package com.microsoft.appcenter.ingestion.models.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class JSONDateUtils$1
  extends ThreadLocal<DateFormat>
{
  public DateFormat initialValue()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.JSONDateUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */