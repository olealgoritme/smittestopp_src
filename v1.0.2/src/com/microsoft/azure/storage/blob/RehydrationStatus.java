package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum RehydrationStatus
{
  static
  {
    PENDING_TO_HOT = new RehydrationStatus("PENDING_TO_HOT", 1);
    RehydrationStatus localRehydrationStatus = new RehydrationStatus("PENDING_TO_COOL", 2);
    PENDING_TO_COOL = localRehydrationStatus;
    $VALUES = new RehydrationStatus[] { UNKNOWN, PENDING_TO_HOT, localRehydrationStatus };
  }
  
  public RehydrationStatus() {}
  
  public static RehydrationStatus parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNKNOWN;
    }
    if ("rehydrate-pending-to-hot".equals(paramString.toLowerCase(Locale.US))) {
      return PENDING_TO_HOT;
    }
    if ("rehydrate-pending-to-cool".equals(paramString.toLowerCase(Locale.US))) {
      return PENDING_TO_COOL;
    }
    return UNKNOWN;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.RehydrationStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */