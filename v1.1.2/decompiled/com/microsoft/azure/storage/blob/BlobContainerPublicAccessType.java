package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum BlobContainerPublicAccessType
{
  static
  {
    BlobContainerPublicAccessType localBlobContainerPublicAccessType = new BlobContainerPublicAccessType("UNKNOWN", 3);
    UNKNOWN = localBlobContainerPublicAccessType;
    $VALUES = new BlobContainerPublicAccessType[] { BLOB, CONTAINER, OFF, localBlobContainerPublicAccessType };
  }
  
  public BlobContainerPublicAccessType() {}
  
  public static BlobContainerPublicAccessType parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return OFF;
    }
    if ("blob".equals(paramString.toLowerCase(Locale.US))) {
      return BLOB;
    }
    if ("container".equals(paramString.toLowerCase(Locale.US))) {
      return CONTAINER;
    }
    return UNKNOWN;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobContainerPublicAccessType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */