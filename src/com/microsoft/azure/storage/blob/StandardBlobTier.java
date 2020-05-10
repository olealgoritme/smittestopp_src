package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum StandardBlobTier
{
  static
  {
    HOT = new StandardBlobTier("HOT", 1);
    COOL = new StandardBlobTier("COOL", 2);
    StandardBlobTier localStandardBlobTier = new StandardBlobTier("ARCHIVE", 3);
    ARCHIVE = localStandardBlobTier;
    $VALUES = new StandardBlobTier[] { UNKNOWN, HOT, COOL, localStandardBlobTier };
  }
  
  public StandardBlobTier() {}
  
  public static StandardBlobTier parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNKNOWN;
    }
    if ("hot".equals(paramString.toLowerCase(Locale.US))) {
      return HOT;
    }
    if ("cool".equals(paramString.toLowerCase(Locale.US))) {
      return COOL;
    }
    if ("archive".equals(paramString.toLowerCase(Locale.US))) {
      return ARCHIVE;
    }
    return UNKNOWN;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.StandardBlobTier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */