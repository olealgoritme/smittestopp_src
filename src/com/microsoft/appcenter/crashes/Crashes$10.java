package com.microsoft.appcenter.crashes;

import java.io.File;
import java.io.FilenameFilter;

public class Crashes$10
  implements FilenameFilter
{
  public Crashes$10(Crashes paramCrashes) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.equals("deviceInfo") ^ true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */