package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

public class FileOutputStream$1
  implements Callable<Void>
{
  public FileOutputStream$1(FileOutputStream paramFileOutputStream, CloudFile paramCloudFile, ByteArrayInputStream paramByteArrayInputStream, long paramLong1, long paramLong2) {}
  
  public Void call()
  {
    try
    {
      val$fileRef.uploadRange(val$bufferRef, val$opOffset, val$opWriteLength, this$0.accessCondition, this$0.options, this$0.opContext);
    }
    catch (StorageException localStorageException)
    {
      synchronized (this$0.lastErrorLock)
      {
        this$0.streamFaulted = true;
        this$0.lastError = Utility.initIOException(localStorageException);
      }
    }
    catch (IOException localIOException) {}
    synchronized (this$0.lastErrorLock)
    {
      this$0.streamFaulted = true;
      this$0.lastError = localIOException;
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileOutputStream.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */