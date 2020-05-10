package com.microsoft.appcenter.crashes.utils;

import java.io.File;
import java.io.FilenameFilter;

public final class ErrorLogHelper$3
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    if (ErrorLogHelper.access$000() != null) {
      return paramString.equals(ErrorLogHelper.access$000().getName()) ^ true;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.utils.ErrorLogHelper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */