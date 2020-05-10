package com.microsoft.azure.storage.blob;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Callable;

public class BlobOutputStreamInternal$1
  implements Callable<Void>
{
  public BlobOutputStreamInternal$1(BlobOutputStreamInternal paramBlobOutputStreamInternal, ByteArrayInputStream paramByteArrayInputStream, String paramString, int paramInt) {}
  
  public Void call()
  {
    BlobOutputStreamInternal.access$000(this$0, val$bufferRef, val$blockID, val$writeLength);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobOutputStreamInternal.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */