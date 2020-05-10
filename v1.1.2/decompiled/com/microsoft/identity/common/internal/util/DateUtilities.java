package com.microsoft.identity.common.internal.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateUtilities
{
  public static Date createCopy(Date paramDate)
  {
    if (paramDate != null) {
      return new Date(paramDate.getTime());
    }
    return paramDate;
  }
  
  public static long getExpiresOn(long paramLong)
  {
    long l = System.currentTimeMillis();
    return TimeUnit.MILLISECONDS.toSeconds(l) + paramLong;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.util.DateUtilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */