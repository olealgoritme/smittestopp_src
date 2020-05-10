package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageErrorCode;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BlobInputStream
  extends InputStream
{
  public AccessCondition accessCondition;
  public final long blobRangeOffset;
  public int bufferSize;
  public long bufferStartOffset;
  public long currentAbsoluteReadPosition;
  public ByteArrayInputStream currentBuffer;
  public IOException lastError;
  public int markExpiry;
  public long markedPosition;
  public MessageDigest md5Digest;
  public final OperationContext opContext;
  public final BlobRequestOptions options;
  public final CloudBlob parentBlobRef;
  public final int readSize;
  public final String retrievedContentMD5Value;
  public volatile boolean streamFaulted;
  public long streamLength;
  public boolean validateBlobMd5;
  
  @DoesServiceRequest
  public BlobInputStream(long paramLong, Long paramLong1, CloudBlob paramCloudBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Object localObject = null;
    accessCondition = null;
    blobRangeOffset = paramLong;
    parentBlobRef = paramCloudBlob;
    paramCloudBlob.assertCorrectBlobType();
    options = new BlobRequestOptions(paramBlobRequestOptions);
    opContext = paramOperationContext;
    streamFaulted = false;
    currentAbsoluteReadPosition = paramLong;
    readSize = paramCloudBlob.getStreamMinimumReadSizeInBytes();
    if ((paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (readSize > 4194304)) {
      throw new IllegalArgumentException("Cannot specify x-ms-range-get-content-md5 header on ranges larger than 4 MB. Either use a BlobReadStream via openRead, or disable TransactionalMD5 via the BlobRequestOptions.");
    }
    paramCloudBlob.downloadAttributes(paramAccessCondition, options, opContext);
    Utility.assertInBounds("blobRangeOffset", paramLong, 0L, paramCloudBlob.getProperties().getLength() - 1L);
    if (paramLong1 != null) {
      Utility.assertGreaterThanOrEqual("blobRangeLength", paramLong1.longValue(), 0L);
    }
    retrievedContentMD5Value = paramCloudBlob.getProperties().getContentMD5();
    boolean bool;
    if ((!paramBlobRequestOptions.getDisableContentMD5Validation().booleanValue()) && (!Utility.isNullOrEmpty(retrievedContentMD5Value))) {
      bool = true;
    } else {
      bool = false;
    }
    validateBlobMd5 = bool;
    if ((paramLong != 0L) || (paramLong1 != null)) {
      validateBlobMd5 = false;
    }
    paramCloudBlob = (CloudBlob)localObject;
    if (paramAccessCondition != null)
    {
      paramCloudBlob = paramAccessCondition.getLeaseID();
      if (!paramAccessCondition.verifyConditional(parentBlobRef.getProperties().getEtag(), parentBlobRef.getProperties().getLastModified()))
      {
        paramLong1 = StorageErrorCode.CONDITION_FAILED;
        throw new StorageException("CONDITION_FAILED", "The conditionals specified for this operation did not match server.", 412, null, null);
      }
    }
    paramAccessCondition = new AccessCondition();
    accessCondition = paramAccessCondition;
    paramAccessCondition.setLeaseID(paramCloudBlob);
    if (!paramBlobRequestOptions.getSkipEtagLocking()) {
      accessCondition.setIfMatch(parentBlobRef.getProperties().getEtag());
    }
    long l;
    if (paramLong1 == null) {
      l = parentBlobRef.getProperties().getLength() - blobRangeOffset;
    } else {
      l = Math.min(parentBlobRef.getProperties().getLength() - blobRangeOffset, paramLong1.longValue());
    }
    streamLength = l;
    if (validateBlobMd5) {
      try
      {
        md5Digest = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException paramLong1)
      {
        throw Utility.generateNewUnexpectedStorageException(paramLong1);
      }
    }
    reposition(paramLong);
  }
  
  @DoesServiceRequest
  public BlobInputStream(CloudBlob paramCloudBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    this(0L, null, paramCloudBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  private void checkStreamState()
  {
    try
    {
      boolean bool = streamFaulted;
      if (!bool) {
        return;
      }
      throw lastError;
    }
    finally {}
  }
  
  /* Error */
  @DoesServiceRequest
  private void dispatchRead(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: newarray <illegal type>
    //   5: astore_2
    //   6: aload_0
    //   7: getfield 47	com/microsoft/azure/storage/blob/BlobInputStream:parentBlobRef	Lcom/microsoft/azure/storage/blob/CloudBlob;
    //   10: aload_0
    //   11: getfield 65	com/microsoft/azure/storage/blob/BlobInputStream:currentAbsoluteReadPosition	J
    //   14: iload_1
    //   15: i2l
    //   16: invokestatic 216	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aload_2
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield 43	com/microsoft/azure/storage/blob/BlobInputStream:accessCondition	Lcom/microsoft/azure/storage/AccessCondition;
    //   25: aload_0
    //   26: getfield 59	com/microsoft/azure/storage/blob/BlobInputStream:options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
    //   29: aload_0
    //   30: getfield 61	com/microsoft/azure/storage/blob/BlobInputStream:opContext	Lcom/microsoft/azure/storage/OperationContext;
    //   33: invokevirtual 220	com/microsoft/azure/storage/blob/CloudBlob:downloadRangeInternal	(JLjava/lang/Long;[BILcom/microsoft/azure/storage/AccessCondition;Lcom/microsoft/azure/storage/blob/BlobRequestOptions;Lcom/microsoft/azure/storage/OperationContext;)I
    //   36: pop
    //   37: new 222	java/io/ByteArrayInputStream
    //   40: astore_3
    //   41: aload_3
    //   42: aload_2
    //   43: invokespecial 225	java/io/ByteArrayInputStream:<init>	([B)V
    //   46: aload_0
    //   47: aload_3
    //   48: putfield 227	com/microsoft/azure/storage/blob/BlobInputStream:currentBuffer	Ljava/io/ByteArrayInputStream;
    //   51: aload_0
    //   52: iload_1
    //   53: putfield 229	com/microsoft/azure/storage/blob/BlobInputStream:bufferSize	I
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 65	com/microsoft/azure/storage/blob/BlobInputStream:currentAbsoluteReadPosition	J
    //   61: putfield 231	com/microsoft/azure/storage/blob/BlobInputStream:bufferStartOffset	J
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_3
    //   68: goto +21 -> 89
    //   71: astore_3
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 63	com/microsoft/azure/storage/blob/BlobInputStream:streamFaulted	Z
    //   77: aload_3
    //   78: invokestatic 235	com/microsoft/azure/storage/core/Utility:initIOException	(Ljava/lang/Exception;)Ljava/io/IOException;
    //   81: astore_3
    //   82: aload_0
    //   83: aload_3
    //   84: putfield 210	com/microsoft/azure/storage/blob/BlobInputStream:lastError	Ljava/io/IOException;
    //   87: aload_3
    //   88: athrow
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	BlobInputStream
    //   0	93	1	paramInt	int
    //   5	38	2	arrayOfByte	byte[]
    //   40	8	3	localByteArrayInputStream	ByteArrayInputStream
    //   67	1	3	localObject	Object
    //   71	7	3	localStorageException	StorageException
    //   81	11	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	64	67	finally
    //   72	89	67	finally
    //   2	64	71	com/microsoft/azure/storage/StorageException
  }
  
  @DoesServiceRequest
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      checkStreamState();
      if (((currentBuffer == null) || (currentBuffer.available() == 0)) && (currentAbsoluteReadPosition < streamLength + blobRangeOffset)) {
        dispatchRead((int)Math.min(readSize, streamLength + blobRangeOffset - currentAbsoluteReadPosition));
      }
      paramInt2 = Math.min(paramInt2, readSize);
      paramInt2 = currentBuffer.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 0)
      {
        currentAbsoluteReadPosition += paramInt2;
        if (validateBlobMd5)
        {
          md5Digest.update(paramArrayOfByte, paramInt1, paramInt2);
          if (currentAbsoluteReadPosition == streamLength + blobRangeOffset)
          {
            paramArrayOfByte = Base64.encode(md5Digest.digest());
            if (!paramArrayOfByte.equals(retrievedContentMD5Value))
            {
              StorageException localStorageException = new com/microsoft/azure/storage/StorageException;
              localStorageException.<init>("InvalidMd5", String.format("Blob data corrupted (integrity check failed), Expected value is %s, retrieved %s", new Object[] { retrievedContentMD5Value, paramArrayOfByte }), 306, null, null);
              lastError = Utility.initIOException(localStorageException);
              streamFaulted = true;
              throw lastError;
            }
          }
        }
      }
      if ((markExpiry > 0) && (markedPosition + markExpiry < currentAbsoluteReadPosition))
      {
        markedPosition = blobRangeOffset;
        markExpiry = 0;
      }
      return paramInt2;
    }
    finally {}
  }
  
  private void reposition(long paramLong)
  {
    try
    {
      currentAbsoluteReadPosition = paramLong;
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(new byte[0]);
      currentBuffer = localByteArrayInputStream;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int available()
  {
    try
    {
      int i = bufferSize;
      long l1 = currentAbsoluteReadPosition;
      long l2 = bufferStartOffset;
      int j = (int)(l1 - l2);
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    try
    {
      currentBuffer = null;
      streamFaulted = true;
      IOException localIOException = new java/io/IOException;
      localIOException.<init>("Stream is already closed.");
      lastError = localIOException;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void mark(int paramInt)
  {
    try
    {
      markedPosition = currentAbsoluteReadPosition;
      markExpiry = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  @DoesServiceRequest
  public int read()
  {
    byte[] arrayOfByte = new byte[1];
    int i = read(arrayOfByte, 0, 1);
    if (i > 0) {
      return arrayOfByte[0] & 0xFF;
    }
    if (i != 0) {
      return -1;
    }
    throw new IOException("Unexpected error. Stream returned unexpected number of bytes.");
  }
  
  @DoesServiceRequest
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @DoesServiceRequest
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1)) {
      return readInternal(paramArrayOfByte, paramInt1, paramInt2);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public void reset()
  {
    try
    {
      if (markedPosition + markExpiry >= currentAbsoluteReadPosition)
      {
        validateBlobMd5 = false;
        md5Digest = null;
        reposition(markedPosition);
        return;
      }
      IOException localIOException = new java/io/IOException;
      localIOException.<init>("Stream mark expired.");
      throw localIOException;
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return 0L;
    }
    if (!bool) {}
    try
    {
      if (currentAbsoluteReadPosition + paramLong <= streamLength + blobRangeOffset)
      {
        validateBlobMd5 = false;
        md5Digest = null;
        reposition(currentAbsoluteReadPosition + paramLong);
        return paramLong;
      }
      IndexOutOfBoundsException localIndexOutOfBoundsException = new java/lang/IndexOutOfBoundsException;
      localIndexOutOfBoundsException.<init>();
      throw localIndexOutOfBoundsException;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */