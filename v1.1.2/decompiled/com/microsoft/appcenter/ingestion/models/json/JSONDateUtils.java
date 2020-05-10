package com.microsoft.appcenter.ingestion.models.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

public final class JSONDateUtils
{
  public static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal()
  {
    public DateFormat initialValue()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      return localSimpleDateFormat;
    }
  };
  
  public static void checkNull(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new JSONException("date cannot be null");
  }
  
  public static Date toDate(String paramString)
  {
    checkNull(paramString);
    try
    {
      paramString = ((DateFormat)DATE_FORMAT.get()).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      throw new JSONException(paramString.getMessage());
    }
  }
  
  public static String toString(Date paramDate)
  {
    checkNull(paramDate);
    return ((DateFormat)DATE_FORMAT.get()).format(paramDate);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.JSONDateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */