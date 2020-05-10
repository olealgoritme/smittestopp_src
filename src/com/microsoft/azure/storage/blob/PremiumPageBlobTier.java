package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum PremiumPageBlobTier
{
  static
  {
    P4 = new PremiumPageBlobTier("P4", 1);
    P6 = new PremiumPageBlobTier("P6", 2);
    P10 = new PremiumPageBlobTier("P10", 3);
    P20 = new PremiumPageBlobTier("P20", 4);
    P30 = new PremiumPageBlobTier("P30", 5);
    P40 = new PremiumPageBlobTier("P40", 6);
    P50 = new PremiumPageBlobTier("P50", 7);
    PremiumPageBlobTier localPremiumPageBlobTier = new PremiumPageBlobTier("P60", 8);
    P60 = localPremiumPageBlobTier;
    $VALUES = new PremiumPageBlobTier[] { UNKNOWN, P4, P6, P10, P20, P30, P40, P50, localPremiumPageBlobTier };
  }
  
  public PremiumPageBlobTier() {}
  
  public static PremiumPageBlobTier parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNKNOWN;
    }
    paramString = paramString.toLowerCase(Locale.US);
    if ("p4".equals(paramString)) {
      return P4;
    }
    if ("p6".equals(paramString)) {
      return P6;
    }
    if ("p10".equals(paramString)) {
      return P10;
    }
    if ("p20".equals(paramString)) {
      return P20;
    }
    if ("p30".equals(paramString)) {
      return P30;
    }
    if ("p40".equals(paramString)) {
      return P40;
    }
    if ("p50".equals(paramString)) {
      return P50;
    }
    if ("p60".equals(paramString)) {
      return P60;
    }
    return UNKNOWN;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.PremiumPageBlobTier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */