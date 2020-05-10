package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.util.Locale;

public enum BlobType
{
  static
  {
    BLOCK_BLOB = new BlobType("BLOCK_BLOB", 1);
    PAGE_BLOB = new BlobType("PAGE_BLOB", 2);
    BlobType localBlobType = new BlobType("APPEND_BLOB", 3);
    APPEND_BLOB = localBlobType;
    $VALUES = new BlobType[] { UNSPECIFIED, BLOCK_BLOB, PAGE_BLOB, localBlobType };
  }
  
  public BlobType() {}
  
  public static BlobType parse(String paramString)
  {
    if (Utility.isNullOrEmpty(paramString)) {
      return UNSPECIFIED;
    }
    if ("blockblob".equals(paramString.toLowerCase(Locale.US))) {
      return BLOCK_BLOB;
    }
    if ("pageblob".equals(paramString.toLowerCase(Locale.US))) {
      return PAGE_BLOB;
    }
    if ("appendblob".equals(paramString.toLowerCase(Locale.US))) {
      return APPEND_BLOB;
    }
    return UNSPECIFIED;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */