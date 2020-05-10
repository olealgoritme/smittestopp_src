package com.microsoft.appcenter.crashes.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

public final class ErrorLogHelper$5
  implements FilenameFilter
{
  public ErrorLogHelper$5(UUID paramUUID, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    boolean bool;
    if ((paramString.startsWith(val$id.toString())) && (paramString.endsWith(val$extension))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.utils.ErrorLogHelper.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */