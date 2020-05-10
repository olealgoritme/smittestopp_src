package com.microsoft.appcenter.ingestion.models.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;

public final class JSONDateUtils
{
  public static final ThreadLocal<DateFormat> DATE_FORMAT = new JSONDateUtils.1();
  
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
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.JSONDateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */