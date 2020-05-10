package com.microsoft.appcenter.crashes.utils;

import java.io.File;
import java.io.FilenameFilter;

public final class ErrorLogHelper$2
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.equals("deviceInfo");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.utils.ErrorLogHelper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */