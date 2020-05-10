package com.microsoft.appcenter.crashes.utils;

import java.io.File;
import java.io.FilenameFilter;

public final class ErrorLogHelper$4
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".json");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.utils.ErrorLogHelper.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */