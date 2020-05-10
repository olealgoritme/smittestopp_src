package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum LeaseDuration
{
  static
  {
    FIXED = new LeaseDuration("FIXED", 1);
    LeaseDuration localLeaseDuration = new LeaseDuration("INFINITE", 2);
    INFINITE = localLeaseDuration;
    $VALUES = new LeaseDuration[] { UNSPECIFIED, FIXED, localLeaseDuration };
  }
  
  public LeaseDuration() {}
  
  public static LeaseDuration parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNSPECIFIED;
    }
    if ("fixed".equals(paramString.toLowerCase(Locale.US))) {
      return FIXED;
    }
    if ("infinite".equals(paramString.toLowerCase(Locale.US))) {
      return INFINITE;
    }
    return UNSPECIFIED;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.LeaseDuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */