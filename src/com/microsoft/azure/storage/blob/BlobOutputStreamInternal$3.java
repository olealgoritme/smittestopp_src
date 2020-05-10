package com.microsoft.azure.storage.blob;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Callable;

public class BlobOutputStreamInternal$3
  implements Callable<Void>
{
  public BlobOutputStreamInternal$3(BlobOutputStreamInternal paramBlobOutputStreamInternal, ByteArrayInputStream paramByteArrayInputStream, long paramLong, int paramInt) {}
  
  public Void call()
  {
    BlobOutputStreamInternal.access$200(this$0, val$bufferRef, val$opOffset, val$writeLength);
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobOutputStreamInternal.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */