package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileOutputStream
  extends OutputStream
{
  public AccessCondition accessCondition = null;
  public final ExecutorCompletionService<Void> completionService;
  public int currentBufferedBytes;
  public long currentOffset;
  public int internalWriteThreshold = -1;
  public IOException lastError;
  public Object lastErrorLock = new Object();
  public MessageDigest md5Digest;
  public OperationContext opContext;
  public FileRequestOptions options;
  public ByteArrayOutputStream outBuffer;
  public volatile int outstandingRequests;
  public final CloudFile parentFileRef;
  public volatile boolean streamFaulted;
  public final ExecutorService threadExecutor;
  
  @DoesServiceRequest
  public FileOutputStream(CloudFile paramCloudFile, long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    accessCondition = paramAccessCondition;
    parentFileRef = paramCloudFile;
    options = new FileRequestOptions(paramFileRequestOptions);
    outBuffer = new ByteArrayOutputStream();
    opContext = paramOperationContext;
    streamFaulted = false;
    if (options.getConcurrentRequestCount().intValue() >= 1)
    {
      if (options.getStoreFileContentMD5().booleanValue()) {
        try
        {
          md5Digest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException paramCloudFile)
        {
          throw Utility.generateNewUnexpectedStorageException(paramCloudFile);
        }
      }
      threadExecutor = Executors.newFixedThreadPool(options.getConcurrentRequestCount().intValue());
      completionService = new ExecutorCompletionService(threadExecutor);
      internalWriteThreshold = ((int)Math.min(parentFileRef.getStreamWriteSizeInBytes(), paramLong));
      return;
    }
    throw new IllegalArgumentException("ConcurrentRequestCount");
  }
  
  private void checkStreamState()
  {
    synchronized (lastErrorLock)
    {
      if (!streamFaulted) {
        return;
      }
      throw lastError;
    }
  }
  
  @DoesServiceRequest
  private void commit()
  {
    if (options.getStoreFileContentMD5().booleanValue()) {
      parentFileRef.getProperties().setContentMD5(Base64.encode(md5Digest.digest()));
    }
    parentFileRef.uploadProperties(accessCondition, options, opContext);
  }
  
  @DoesServiceRequest
  private void dispatchWrite(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    try
    {
      if (outstandingRequests > options.getConcurrentRequestCount().intValue() * 2) {
        waitForTaskToComplete();
      }
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(outBuffer.toByteArray());
      Object localObject1 = parentFileRef;
      long l1 = currentOffset;
      long l2 = paramInt;
      currentOffset += l2;
      Callable local1 = new com/microsoft/azure/storage/file/FileOutputStream$1;
      local1.<init>(this, (CloudFile)localObject1, localByteArrayInputStream, l1, l2);
      completionService.submit(local1);
      outstandingRequests += 1;
      currentBufferedBytes = 0;
      localObject1 = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject1).<init>();
      outBuffer = ((ByteArrayOutputStream)localObject1);
      return;
    }
    finally {}
  }
  
  private void waitForTaskToComplete()
  {
    try
    {
      completionService.take().get();
      outstandingRequests -= 1;
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw Utility.initIOException(localExecutionException);
    }
    catch (InterruptedException localInterruptedException)
    {
      throw Utility.initIOException(localInterruptedException);
    }
  }
  
  @DoesServiceRequest
  private void writeInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0) {
      try
      {
        checkStreamState();
        int i = Math.min(internalWriteThreshold - currentBufferedBytes, paramInt2);
        if (options.getStoreFileContentMD5().booleanValue()) {
          md5Digest.update(paramArrayOfByte, paramInt1, i);
        }
        outBuffer.write(paramArrayOfByte, paramInt1, i);
        int j = currentBufferedBytes + i;
        currentBufferedBytes = j;
        int k = paramInt1 + i;
        i = paramInt2 - i;
        paramInt1 = k;
        paramInt2 = i;
        if (j == internalWriteThreshold)
        {
          dispatchWrite(internalWriteThreshold);
          paramInt1 = k;
          paramInt2 = i;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  @DoesServiceRequest
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 216	com/microsoft/azure/storage/file/FileOutputStream:checkStreamState	()V
    //   4: aload_0
    //   5: invokevirtual 235	com/microsoft/azure/storage/file/FileOutputStream:flush	()V
    //   8: aload_0
    //   9: getfield 114	com/microsoft/azure/storage/file/FileOutputStream:threadExecutor	Ljava/util/concurrent/ExecutorService;
    //   12: invokeinterface 240 1 0
    //   17: aload_0
    //   18: invokespecial 242	com/microsoft/azure/storage/file/FileOutputStream:commit	()V
    //   21: aload_0
    //   22: getfield 48	com/microsoft/azure/storage/file/FileOutputStream:lastErrorLock	Ljava/lang/Object;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 70	com/microsoft/azure/storage/file/FileOutputStream:streamFaulted	Z
    //   33: new 244	java/io/IOException
    //   36: astore_2
    //   37: aload_2
    //   38: ldc -10
    //   40: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: aload_2
    //   45: putfield 144	com/microsoft/azure/storage/file/FileOutputStream:lastError	Ljava/io/IOException;
    //   48: aload_1
    //   49: monitorexit
    //   50: aload_0
    //   51: getfield 114	com/microsoft/azure/storage/file/FileOutputStream:threadExecutor	Ljava/util/concurrent/ExecutorService;
    //   54: invokeinterface 250 1 0
    //   59: ifne +13 -> 72
    //   62: aload_0
    //   63: getfield 114	com/microsoft/azure/storage/file/FileOutputStream:threadExecutor	Ljava/util/concurrent/ExecutorService;
    //   66: invokeinterface 254 1 0
    //   71: pop
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 212	com/microsoft/azure/storage/core/Utility:initIOException	(Ljava/lang/Exception;)Ljava/io/IOException;
    //   83: athrow
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 212	com/microsoft/azure/storage/core/Utility:initIOException	(Ljava/lang/Exception;)Ljava/io/IOException;
    //   89: athrow
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 48	com/microsoft/azure/storage/file/FileOutputStream:lastErrorLock	Ljava/lang/Object;
    //   95: astore_1
    //   96: aload_1
    //   97: monitorenter
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 70	com/microsoft/azure/storage/file/FileOutputStream:streamFaulted	Z
    //   103: new 244	java/io/IOException
    //   106: astore_3
    //   107: aload_3
    //   108: ldc -10
    //   110: invokespecial 247	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: aload_3
    //   115: putfield 144	com/microsoft/azure/storage/file/FileOutputStream:lastError	Ljava/io/IOException;
    //   118: aload_1
    //   119: monitorexit
    //   120: aload_0
    //   121: getfield 114	com/microsoft/azure/storage/file/FileOutputStream:threadExecutor	Ljava/util/concurrent/ExecutorService;
    //   124: invokeinterface 250 1 0
    //   129: ifne +13 -> 142
    //   132: aload_0
    //   133: getfield 114	com/microsoft/azure/storage/file/FileOutputStream:threadExecutor	Ljava/util/concurrent/ExecutorService;
    //   136: invokeinterface 254 1 0
    //   141: pop
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: aload_1
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	FileOutputStream
    //   78	2	1	localURISyntaxException	java.net.URISyntaxException
    //   84	2	1	localStorageException	StorageException
    //   36	9	2	localIOException1	IOException
    //   73	4	2	localObject3	Object
    //   90	53	2	localObject4	Object
    //   144	4	2	localObject5	Object
    //   106	9	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   28	50	73	finally
    //   74	76	73	finally
    //   17	21	78	java/net/URISyntaxException
    //   17	21	84	com/microsoft/azure/storage/StorageException
    //   0	17	90	finally
    //   17	21	90	finally
    //   79	84	90	finally
    //   85	90	90	finally
    //   98	120	144	finally
    //   145	147	144	finally
  }
  
  @DoesServiceRequest
  public void flush()
  {
    try
    {
      checkStreamState();
      dispatchWrite(currentBufferedBytes);
      while (outstandingRequests > 0)
      {
        waitForTaskToComplete();
        checkStreamState();
      }
      return;
    }
    finally {}
  }
  
  @DoesServiceRequest
  public void write(int paramInt)
  {
    write(new byte[] { (byte)(paramInt & 0xFF) });
  }
  
  @DoesServiceRequest
  public void write(InputStream paramInputStream, long paramLong)
  {
    Utility.writeToOutputStream(paramInputStream, this, paramLong, false, false, opContext, options, Boolean.valueOf(false));
  }
  
  @DoesServiceRequest
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @DoesServiceRequest
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1))
    {
      writeInternal(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */