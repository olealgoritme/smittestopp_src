package com.microsoft.identity.common.adal.internal.util;

import java.util.Date;

public final class DateExtensions
{
  public static Date createCopy(Date paramDate)
  {
    if (paramDate != null) {
      return new Date(paramDate.getTime());
    }
    return paramDate;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.util.DateExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */