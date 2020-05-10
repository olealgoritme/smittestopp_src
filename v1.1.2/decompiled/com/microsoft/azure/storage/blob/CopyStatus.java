package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum CopyStatus
{
  static
  {
    INVALID = new CopyStatus("INVALID", 1);
    PENDING = new CopyStatus("PENDING", 2);
    SUCCESS = new CopyStatus("SUCCESS", 3);
    ABORTED = new CopyStatus("ABORTED", 4);
    CopyStatus localCopyStatus = new CopyStatus("FAILED", 5);
    FAILED = localCopyStatus;
    $VALUES = new CopyStatus[] { UNSPECIFIED, INVALID, PENDING, SUCCESS, ABORTED, localCopyStatus };
  }
  
  public CopyStatus() {}
  
  public static CopyStatus parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNSPECIFIED;
    }
    if ("invalid".equals(paramString.toLowerCase(Locale.US))) {
      return INVALID;
    }
    if ("pending".equals(paramString.toLowerCase(Locale.US))) {
      return PENDING;
    }
    if ("success".equals(paramString.toLowerCase(Locale.US))) {
      return SUCCESS;
    }
    if ("aborted".equals(paramString.toLowerCase(Locale.US))) {
      return ABORTED;
    }
    if ("failed".equals(paramString.toLowerCase(Locale.US))) {
      return FAILED;
    }
    return UNSPECIFIED;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CopyStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */