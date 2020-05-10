package com.microsoft.azure.storage.core;

import java.net.HttpURLConnection;

public final class CanonicalizerFactory
{
  public static final BlobQueueFileCanonicalizer BLOB_QUEUE_FILE_V2_INSTANCE = new BlobQueueFileCanonicalizer();
  public static final TableCanonicalizer TABLE_INSTANCE = new TableCanonicalizer();
  
  public static Canonicalizer getBlobQueueFileCanonicalizer(HttpURLConnection paramHttpURLConnection)
  {
    return BLOB_QUEUE_FILE_V2_INSTANCE;
  }
  
  public static Canonicalizer getTableCanonicalizer(HttpURLConnection paramHttpURLConnection)
  {
    return TABLE_INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.CanonicalizerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */