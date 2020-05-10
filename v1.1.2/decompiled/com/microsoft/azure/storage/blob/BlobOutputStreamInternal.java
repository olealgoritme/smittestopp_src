package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Logger;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlobOutputStreamInternal
  extends BlobOutputStream
{
  public AccessCondition accessCondition;
  public String blockIdPrefix;
  public ArrayList<BlockEntry> blockList;
  public final ExecutorCompletionService<Void> completionService;
  public long currentBlobOffset;
  public final Set<Future<Void>> futureSet;
  public int internalWriteThreshold = -1;
  public volatile IOException lastError = null;
  public MessageDigest md5Digest;
  public final OperationContext opContext;
  public final BlobRequestOptions options;
  public volatile ByteArrayOutputStream outBuffer;
  public final CloudBlob parentBlobRef;
  public BlobType streamType = BlobType.UNSPECIFIED;
  public final ThreadPoolExecutor threadExecutor;
  
  @DoesServiceRequest
  public BlobOutputStreamInternal(CloudAppendBlob paramCloudAppendBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    this(paramCloudAppendBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    streamType = BlobType.APPEND_BLOB;
    if (paramAccessCondition == null) {
      paramAccessCondition = new AccessCondition();
    }
    accessCondition = paramAccessCondition;
    if (paramAccessCondition.getIfAppendPositionEqual() != null) {
      currentBlobOffset = accessCondition.getIfAppendPositionEqual().longValue();
    } else {
      currentBlobOffset = paramCloudAppendBlob.getProperties().getLength();
    }
  }
  
  public BlobOutputStreamInternal(CloudBlob paramCloudBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    accessCondition = paramAccessCondition;
    parentBlobRef = paramCloudBlob;
    paramCloudBlob.assertCorrectBlobType();
    options = new BlobRequestOptions(paramBlobRequestOptions);
    outBuffer = new ByteArrayOutputStream();
    opContext = paramOperationContext;
    int i = options.getConcurrentRequestCount().intValue();
    int j = 1;
    if (i >= 1)
    {
      if (options.getConcurrentRequestCount() != null) {
        j = options.getConcurrentRequestCount().intValue() * 2;
      }
      futureSet = Collections.newSetFromMap(new ConcurrentHashMap(j));
      if (options.getStoreBlobContentMD5().booleanValue()) {
        try
        {
          md5Digest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException paramCloudBlob)
        {
          throw Utility.generateNewUnexpectedStorageException(paramCloudBlob);
        }
      }
      threadExecutor = new ThreadPoolExecutor(options.getConcurrentRequestCount().intValue(), options.getConcurrentRequestCount().intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new BlobOutputStreamThreadFactory());
      completionService = new ExecutorCompletionService(threadExecutor);
      return;
    }
    throw new IllegalArgumentException("ConcurrentRequestCount");
  }
  
  public BlobOutputStreamInternal(CloudBlockBlob paramCloudBlockBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    this(paramCloudBlockBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    blockList = new ArrayList();
    paramCloudBlockBlob = new StringBuilder();
    paramCloudBlockBlob.append(UUID.randomUUID().toString());
    paramCloudBlockBlob.append("-");
    blockIdPrefix = paramCloudBlockBlob.toString();
    streamType = BlobType.BLOCK_BLOB;
  }
  
  @DoesServiceRequest
  public BlobOutputStreamInternal(CloudPageBlob paramCloudPageBlob, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    this(paramCloudPageBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    streamType = BlobType.PAGE_BLOB;
  }
  
  private void appendBlock(ByteArrayInputStream paramByteArrayInputStream, long paramLong1, long paramLong2)
  {
    CloudAppendBlob localCloudAppendBlob = (CloudAppendBlob)parentBlobRef;
    accessCondition.setIfAppendPositionEqual(Long.valueOf(paramLong1));
    int i = opContext.getRequestResults().size();
    try
    {
      localCloudAppendBlob.appendBlock(paramByteArrayInputStream, paramLong2, accessCondition, options, opContext);
    }
    catch (StorageException paramByteArrayInputStream)
    {
      if ((options.getAbsorbConditionalErrorsOnRetry().booleanValue()) && (paramByteArrayInputStream.getHttpStatusCode() == 412) && (paramByteArrayInputStream.getExtendedErrorInformation() != null) && (paramByteArrayInputStream.getErrorCode() != null) && ((paramByteArrayInputStream.getErrorCode().equals("AppendPositionConditionNotMet")) || (paramByteArrayInputStream.getErrorCode().equals("MaxBlobSizeConditionNotMet"))) && (opContext.getRequestResults().size() - i > 1)) {
        Logger.info(opContext, "Pre-condition failure on a retry is being ignored since the request should have succeeded in the first attempt.");
      } else {
        lastError = Utility.initIOException(paramByteArrayInputStream);
      }
    }
    catch (IOException paramByteArrayInputStream)
    {
      lastError = paramByteArrayInputStream;
    }
  }
  
  private void checkStreamState()
  {
    if (lastError == null) {
      return;
    }
    throw lastError;
  }
  
  private void clearCompletedFutures()
  {
    Iterator localIterator = futureSet.iterator();
    while (localIterator.hasNext())
    {
      Future localFuture = (Future)localIterator.next();
      if (localFuture.isDone()) {
        futureSet.remove(localFuture);
      }
    }
  }
  
  @DoesServiceRequest
  private void commit()
  {
    try
    {
      if (options.getStoreBlobContentMD5().booleanValue()) {
        parentBlobRef.getProperties().setContentMD5(Base64.encode(md5Digest.digest()));
      }
      if (streamType == BlobType.BLOCK_BLOB) {
        ((CloudBlockBlob)parentBlobRef).commitBlockList(blockList, accessCondition, options, opContext);
      } else if (options.getStoreBlobContentMD5().booleanValue()) {
        parentBlobRef.uploadProperties(accessCondition, options, opContext);
      }
      return;
    }
    finally {}
  }
  
  @DoesServiceRequest
  private void dispatchWrite()
  {
    try
    {
      int i = outBuffer.size();
      if (i == 0) {
        return;
      }
      if ((streamType == BlobType.PAGE_BLOB) && (i % 512 != 0))
      {
        localObject1 = new java/io/IOException;
        ((IOException)localObject1).<init>(String.format("Page data must be a multiple of 512 bytes. Buffer currently contains %d bytes.", new Object[] { Integer.valueOf(i) }));
        throw ((Throwable)localObject1);
      }
      Object localObject1 = null;
      if (threadExecutor.getQueue().size() >= options.getConcurrentRequestCount().intValue() * 2) {
        waitForTaskToComplete();
      }
      if (futureSet.size() >= options.getConcurrentRequestCount().intValue() * 2) {
        clearCompletedFutures();
      }
      final ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(outBuffer.toByteArray());
      if (streamType == BlobType.BLOCK_BLOB)
      {
        String str = getCurrentBlockId();
        ArrayList localArrayList = blockList;
        localObject1 = new com/microsoft/azure/storage/blob/BlockEntry;
        ((BlockEntry)localObject1).<init>(str, BlockSearchMode.LATEST);
        localArrayList.add(localObject1);
        localObject1 = new com/microsoft/azure/storage/blob/BlobOutputStreamInternal$1;
        ((1)localObject1).<init>(this, localByteArrayInputStream, str, i);
      }
      else
      {
        final long l;
        if (streamType == BlobType.PAGE_BLOB)
        {
          l = currentBlobOffset;
          currentBlobOffset += i;
          localObject1 = new Callable()
          {
            public Void call()
            {
              BlobOutputStreamInternal.access$100(BlobOutputStreamInternal.this, localByteArrayInputStream, l, val$writeLength);
              return null;
            }
          };
        }
        else if (streamType == BlobType.APPEND_BLOB)
        {
          l = currentBlobOffset;
          currentBlobOffset += i;
          if ((accessCondition.getIfMaxSizeLessThanOrEqual() != null) && (currentBlobOffset > accessCondition.getIfMaxSizeLessThanOrEqual().longValue()))
          {
            localObject1 = new java/io/IOException;
            ((IOException)localObject1).<init>("Append block data should not exceed the maximum blob size condition value.");
            lastError = ((IOException)localObject1);
            throw lastError;
          }
          localObject1 = new Callable()
          {
            public Void call()
            {
              BlobOutputStreamInternal.access$200(BlobOutputStreamInternal.this, localByteArrayInputStream, l, val$writeLength);
              return null;
            }
          };
        }
      }
      futureSet.add(completionService.submit((Callable)localObject1));
      localObject1 = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject1).<init>();
      outBuffer = ((ByteArrayOutputStream)localObject1);
      return;
    }
    finally {}
  }
  
  private String getCurrentBlockId()
  {
    String str = String.format("%06d", new Object[] { Integer.valueOf(blockList.size()) });
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(blockIdPrefix);
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return Base64.encode((byte[])localObject);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IOException(localUnsupportedEncodingException);
    }
  }
  
  private void waitForTaskToComplete()
  {
    for (int i = 0; completionService.poll() != null; i = 1) {}
    if (i == 0) {
      try
      {
        completionService.take();
      }
      catch (InterruptedException localInterruptedException)
      {
        throw Utility.initIOException(localInterruptedException);
      }
    }
  }
  
  private void writeBlock(ByteArrayInputStream paramByteArrayInputStream, String paramString, long paramLong)
  {
    CloudBlockBlob localCloudBlockBlob = (CloudBlockBlob)parentBlobRef;
    try
    {
      localCloudBlockBlob.uploadBlock(paramString, paramByteArrayInputStream, paramLong, accessCondition, options, opContext);
    }
    catch (StorageException paramByteArrayInputStream)
    {
      lastError = Utility.initIOException(paramByteArrayInputStream);
    }
    catch (IOException paramByteArrayInputStream)
    {
      lastError = paramByteArrayInputStream;
    }
  }
  
  @DoesServiceRequest
  private void writeInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0) {
      try
      {
        checkStreamState();
        int i = Math.min(internalWriteThreshold - outBuffer.size(), paramInt2);
        if (options.getStoreBlobContentMD5().booleanValue()) {
          md5Digest.update(paramArrayOfByte, paramInt1, i);
        }
        outBuffer.write(paramArrayOfByte, paramInt1, i);
        int j = paramInt1 + i;
        i = paramInt2 - i;
        paramInt1 = j;
        paramInt2 = i;
        if (outBuffer.size() == internalWriteThreshold)
        {
          dispatchWrite();
          paramInt1 = j;
          paramInt2 = i;
        }
      }
      finally {}
    }
  }
  
  private void writePages(ByteArrayInputStream paramByteArrayInputStream, long paramLong1, long paramLong2)
  {
    CloudPageBlob localCloudPageBlob = (CloudPageBlob)parentBlobRef;
    try
    {
      localCloudPageBlob.uploadPages(paramByteArrayInputStream, paramLong1, paramLong2, accessCondition, options, opContext);
    }
    catch (StorageException paramByteArrayInputStream)
    {
      lastError = Utility.initIOException(paramByteArrayInputStream);
    }
    catch (IOException paramByteArrayInputStream)
    {
      lastError = paramByteArrayInputStream;
    }
  }
  
  /* Error */
  @DoesServiceRequest
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 471	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:checkStreamState	()V
    //   6: aload_0
    //   7: invokevirtual 492	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:flush	()V
    //   10: aload_0
    //   11: getfield 191	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:threadExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   14: invokevirtual 495	java/util/concurrent/ThreadPoolExecutor:shutdown	()V
    //   17: aload_0
    //   18: invokespecial 497	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:commit	()V
    //   21: new 264	java/io/IOException
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 499
    //   29: invokespecial 386	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_1
    //   34: putfield 104	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:lastError	Ljava/io/IOException;
    //   37: aload_0
    //   38: getfield 191	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:threadExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   41: invokevirtual 502	java/util/concurrent/ThreadPoolExecutor:isShutdown	()Z
    //   44: ifne +11 -> 55
    //   47: aload_0
    //   48: getfield 191	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:threadExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   51: invokevirtual 506	java/util/concurrent/ThreadPoolExecutor:shutdownNow	()Ljava/util/List;
    //   54: pop
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 323	com/microsoft/azure/storage/core/Utility:initIOException	(Ljava/lang/Exception;)Ljava/io/IOException;
    //   63: athrow
    //   64: astore_1
    //   65: new 264	java/io/IOException
    //   68: astore_2
    //   69: aload_2
    //   70: ldc_w 499
    //   73: invokespecial 386	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 104	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:lastError	Ljava/io/IOException;
    //   81: aload_0
    //   82: getfield 191	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:threadExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   85: invokevirtual 502	java/util/concurrent/ThreadPoolExecutor:isShutdown	()Z
    //   88: ifne +11 -> 99
    //   91: aload_0
    //   92: getfield 191	com/microsoft/azure/storage/blob/BlobOutputStreamInternal:threadExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   95: invokevirtual 506	java/util/concurrent/ThreadPoolExecutor:shutdownNow	()Ljava/util/List;
    //   98: pop
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	BlobOutputStreamInternal
    //   24	10	1	localIOException1	IOException
    //   58	2	1	localStorageException	StorageException
    //   64	36	1	localObject1	Object
    //   101	4	1	localObject2	Object
    //   68	10	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   17	21	58	com/microsoft/azure/storage/StorageException
    //   2	17	64	finally
    //   17	21	64	finally
    //   59	64	64	finally
    //   21	55	101	finally
    //   65	99	101	finally
    //   99	101	101	finally
  }
  
  @DoesServiceRequest
  public void flush()
  {
    checkStreamState();
    dispatchWrite();
    Iterator localIterator = new HashSet(futureSet).iterator();
    while (localIterator.hasNext())
    {
      Future localFuture = (Future)localIterator.next();
      try
      {
        localFuture.get();
        checkStreamState();
      }
      catch (Exception localException)
      {
        throw Utility.initIOException(localException);
      }
    }
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
  
  public static class BlobOutputStreamThreadFactory
    implements ThreadFactory
  {
    public final ThreadGroup group;
    public final String namePrefix;
    public final AtomicInteger threadNumber = new AtomicInteger(1);
    
    public BlobOutputStreamThreadFactory()
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {
        localObject = ((SecurityManager)localObject).getThreadGroup();
      } else {
        localObject = Thread.currentThread().getThreadGroup();
      }
      group = ((ThreadGroup)localObject);
      namePrefix = "azure-storage-bloboutputstream-thread-";
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      ThreadGroup localThreadGroup = group;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(namePrefix);
      localStringBuilder.append(threadNumber.getAndIncrement());
      paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
      paramRunnable.setDaemon(true);
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobOutputStreamInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */