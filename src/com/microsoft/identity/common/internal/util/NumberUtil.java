package com.microsoft.identity.common.internal.util;

public class NumberUtil
{
  public static Integer parseIntSafely(String paramString)
  {
    try
    {
      paramString = Integer.valueOf(paramString);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public static Long parseLongSafely(String paramString)
  {
    try
    {
      paramString = Long.valueOf(paramString);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.util.NumberUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */