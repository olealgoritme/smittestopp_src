package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum LeaseState
{
  static
  {
    AVAILABLE = new LeaseState("AVAILABLE", 1);
    LEASED = new LeaseState("LEASED", 2);
    EXPIRED = new LeaseState("EXPIRED", 3);
    BREAKING = new LeaseState("BREAKING", 4);
    LeaseState localLeaseState = new LeaseState("BROKEN", 5);
    BROKEN = localLeaseState;
    $VALUES = new LeaseState[] { UNSPECIFIED, AVAILABLE, LEASED, EXPIRED, BREAKING, localLeaseState };
  }
  
  public LeaseState() {}
  
  public static LeaseState parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNSPECIFIED;
    }
    if ("available".equals(paramString.toLowerCase(Locale.US))) {
      return AVAILABLE;
    }
    if ("leased".equals(paramString.toLowerCase(Locale.US))) {
      return LEASED;
    }
    if ("expired".equals(paramString.toLowerCase(Locale.US))) {
      return EXPIRED;
    }
    if ("breaking".equals(paramString.toLowerCase(Locale.US))) {
      return BREAKING;
    }
    if ("broken".equals(paramString.toLowerCase(Locale.US))) {
      return BROKEN;
    }
    return UNSPECIFIED;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.LeaseState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */