package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum LeaseStatus
{
  static
  {
    LOCKED = new LeaseStatus("LOCKED", 1);
    LeaseStatus localLeaseStatus = new LeaseStatus("UNLOCKED", 2);
    UNLOCKED = localLeaseStatus;
    $VALUES = new LeaseStatus[] { UNSPECIFIED, LOCKED, localLeaseStatus };
  }
  
  public LeaseStatus() {}
  
  public static LeaseStatus parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNSPECIFIED;
    }
    if ("unlocked".equals(paramString.toLowerCase(Locale.US))) {
      return UNLOCKED;
    }
    if ("locked".equals(paramString.toLowerCase(Locale.US))) {
      return LOCKED;
    }
    return UNSPECIFIED;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.LeaseStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */