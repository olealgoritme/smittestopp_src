package com.microsoft.azure.storage.core;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class MarkableFileStream
  extends FilterInputStream
{
  public FileChannel fileChannel;
  public long mark = -1L;
  
  public MarkableFileStream(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
    fileChannel = paramFileInputStream.getChannel();
  }
  
  /* Error */
  public void mark(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 25	com/microsoft/azure/storage/core/MarkableFileStream:fileChannel	Ljava/nio/channels/FileChannel;
    //   7: invokevirtual 35	java/nio/channels/FileChannel:position	()J
    //   10: putfield 17	com/microsoft/azure/storage/core/MarkableFileStream:mark	J
    //   13: goto +15 -> 28
    //   16: astore_2
    //   17: goto +14 -> 31
    //   20: astore_2
    //   21: aload_0
    //   22: ldc2_w 14
    //   25: putfield 17	com/microsoft/azure/storage/core/MarkableFileStream:mark	J
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	MarkableFileStream
    //   0	35	1	paramInt	int
    //   16	1	2	localObject	Object
    //   20	14	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   21	28	16	finally
    //   2	13	20	java/io/IOException
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void reset()
  {
    try
    {
      if (mark != -1L)
      {
        fileChannel.position(mark);
        return;
      }
      IOException localIOException = new java/io/IOException;
      localIOException.<init>("Stream must be marked before calling reset");
      throw localIOException;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.MarkableFileStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */