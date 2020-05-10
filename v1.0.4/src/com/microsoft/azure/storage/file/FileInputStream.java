package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileInputStream
  extends InputStream
{
  public AccessCondition accessCondition;
  public int bufferSize;
  public long bufferStartOffset;
  public long currentAbsoluteReadPosition;
  public ByteArrayInputStream currentBuffer;
  public IOException lastError;
  public int markExpiry;
  public long markedPosition;
  public MessageDigest md5Digest;
  public final OperationContext opContext;
  public final FileRequestOptions options;
  public final CloudFile parentFileRef;
  public final int readSize;
  public final String retrievedContentMD5Value;
  public volatile boolean streamFaulted;
  public long streamLength = -1L;
  public boolean validateFileMd5;
  
  @DoesServiceRequest
  public FileInputStream(CloudFile paramCloudFile, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    Object localObject = null;
    accessCondition = null;
    parentFileRef = paramCloudFile;
    options = new FileRequestOptions(paramFileRequestOptions);
    opContext = paramOperationContext;
    boolean bool1 = false;
    streamFaulted = false;
    currentAbsoluteReadPosition = 0L;
    readSize = paramCloudFile.getStreamMinimumReadSizeInBytes();
    if ((paramFileRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (readSize > 4194304)) {
      throw new IllegalArgumentException("Cannot specify x-ms-range-get-content-md5 header on ranges larger than 4 MB. Either use a BlobReadStream via openRead, or disable TransactionalMD5 via the BlobRequestOptions.");
    }
    paramCloudFile.downloadAttributes(paramAccessCondition, options, opContext);
    retrievedContentMD5Value = paramCloudFile.getProperties().getContentMD5();
    boolean bool2 = bool1;
    if (!paramFileRequestOptions.getDisableContentMD5Validation().booleanValue())
    {
      bool2 = bool1;
      if (!Utility.isNullOrEmpty(retrievedContentMD5Value)) {
        bool2 = true;
      }
    }
    validateFileMd5 = bool2;
    paramFileRequestOptions = (FileRequestOptions)localObject;
    if (paramAccessCondition != null) {
      paramFileRequestOptions = paramAccessCondition.getLeaseID();
    }
    paramAccessCondition = AccessCondition.generateIfMatchCondition(parentFileRef.getProperties().getEtag());
    accessCondition = paramAccessCondition;
    paramAccessCondition.setLeaseID(paramFileRequestOptions);
    streamLength = paramCloudFile.getProperties().getLength();
    if (validateFileMd5) {
      try
      {
        md5Digest = MessageDigest.getInstance("MD5");
      }
      catch (NoSuchAlgorithmException paramCloudFile)
      {
        throw Utility.generateNewUnexpectedStorageException(paramCloudFile);
      }
    }
    reposition(0L);
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
    //   7: getfield 48	com/microsoft/azure/storage/file/FileInputStream:parentFileRef	Lcom/microsoft/azure/storage/file/CloudFile;
    //   10: aload_0
    //   11: getfield 61	com/microsoft/azure/storage/file/FileInputStream:currentAbsoluteReadPosition	J
    //   14: iload_1
    //   15: i2l
    //   16: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: aload_2
    //   20: iconst_0
    //   21: aconst_null
    //   22: aload_0
    //   23: getfield 55	com/microsoft/azure/storage/file/FileInputStream:options	Lcom/microsoft/azure/storage/file/FileRequestOptions;
    //   26: aload_0
    //   27: getfield 57	com/microsoft/azure/storage/file/FileInputStream:opContext	Lcom/microsoft/azure/storage/OperationContext;
    //   30: invokevirtual 170	com/microsoft/azure/storage/file/CloudFile:downloadRangeInternal	(JLjava/lang/Long;[BILcom/microsoft/azure/storage/AccessCondition;Lcom/microsoft/azure/storage/file/FileRequestOptions;Lcom/microsoft/azure/storage/OperationContext;)I
    //   33: pop
    //   34: aload_0
    //   35: getfield 46	com/microsoft/azure/storage/file/FileInputStream:accessCondition	Lcom/microsoft/azure/storage/AccessCondition;
    //   38: ifnull +52 -> 90
    //   41: aload_0
    //   42: getfield 46	com/microsoft/azure/storage/file/FileInputStream:accessCondition	Lcom/microsoft/azure/storage/AccessCondition;
    //   45: invokevirtual 173	com/microsoft/azure/storage/AccessCondition:getIfMatch	()Ljava/lang/String;
    //   48: aload_0
    //   49: getfield 48	com/microsoft/azure/storage/file/FileInputStream:parentFileRef	Lcom/microsoft/azure/storage/file/CloudFile;
    //   52: invokevirtual 95	com/microsoft/azure/storage/file/CloudFile:getProperties	()Lcom/microsoft/azure/storage/file/FileProperties;
    //   55: invokevirtual 122	com/microsoft/azure/storage/file/FileProperties:getEtag	()Ljava/lang/String;
    //   58: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifeq +6 -> 67
    //   64: goto +26 -> 90
    //   67: new 160	com/microsoft/azure/storage/StorageException
    //   70: astore_2
    //   71: getstatic 185	com/microsoft/azure/storage/StorageErrorCode:CONDITION_FAILED	Lcom/microsoft/azure/storage/StorageErrorCode;
    //   74: astore_3
    //   75: aload_2
    //   76: ldc -70
    //   78: ldc -68
    //   80: sipush 412
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokespecial 191	com/microsoft/azure/storage/StorageException:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/microsoft/azure/storage/StorageExtendedErrorInformation;Ljava/lang/Exception;)V
    //   88: aload_2
    //   89: athrow
    //   90: new 193	java/io/ByteArrayInputStream
    //   93: astore_3
    //   94: aload_3
    //   95: aload_2
    //   96: invokespecial 196	java/io/ByteArrayInputStream:<init>	([B)V
    //   99: aload_0
    //   100: aload_3
    //   101: putfield 198	com/microsoft/azure/storage/file/FileInputStream:currentBuffer	Ljava/io/ByteArrayInputStream;
    //   104: aload_0
    //   105: iload_1
    //   106: putfield 200	com/microsoft/azure/storage/file/FileInputStream:bufferSize	I
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 61	com/microsoft/azure/storage/file/FileInputStream:currentAbsoluteReadPosition	J
    //   114: putfield 202	com/microsoft/azure/storage/file/FileInputStream:bufferStartOffset	J
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: astore_2
    //   121: goto +21 -> 142
    //   124: astore_2
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 59	com/microsoft/azure/storage/file/FileInputStream:streamFaulted	Z
    //   130: aload_2
    //   131: invokestatic 206	com/microsoft/azure/storage/core/Utility:initIOException	(Ljava/lang/Exception;)Ljava/io/IOException;
    //   134: astore_2
    //   135: aload_0
    //   136: aload_2
    //   137: putfield 156	com/microsoft/azure/storage/file/FileInputStream:lastError	Ljava/io/IOException;
    //   140: aload_2
    //   141: athrow
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	FileInputStream
    //   0	146	1	paramInt	int
    //   5	91	2	localObject1	Object
    //   120	1	2	localObject2	Object
    //   124	7	2	localStorageException	StorageException
    //   134	11	2	localIOException	IOException
    //   74	27	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	120	finally
    //   67	90	120	finally
    //   90	117	120	finally
    //   125	142	120	finally
    //   2	64	124	com/microsoft/azure/storage/StorageException
    //   67	90	124	com/microsoft/azure/storage/StorageException
    //   90	117	124	com/microsoft/azure/storage/StorageException
  }
  
  @DoesServiceRequest
  private int readInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      checkStreamState();
      if (((currentBuffer == null) || (currentBuffer.available() == 0)) && (currentAbsoluteReadPosition < streamLength)) {
        dispatchRead((int)Math.min(readSize, streamLength - currentAbsoluteReadPosition));
      }
      paramInt2 = Math.min(paramInt2, readSize);
      paramInt2 = currentBuffer.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 0)
      {
        currentAbsoluteReadPosition += paramInt2;
        if (validateFileMd5)
        {
          md5Digest.update(paramArrayOfByte, paramInt1, paramInt2);
          if (currentAbsoluteReadPosition == streamLength)
          {
            paramArrayOfByte = Base64.encode(md5Digest.digest());
            if (!paramArrayOfByte.equals(retrievedContentMD5Value))
            {
              StorageException localStorageException = new com/microsoft/azure/storage/StorageException;
              localStorageException.<init>("InvalidMd5", String.format("File data corrupted (integrity check failed), Expected value is %s, retrieved %s", new Object[] { retrievedContentMD5Value, paramArrayOfByte }), 306, null, null);
              lastError = Utility.initIOException(localStorageException);
              streamFaulted = true;
              throw lastError;
            }
          }
        }
      }
      if ((markExpiry > 0) && (markedPosition + markExpiry < currentAbsoluteReadPosition))
      {
        markedPosition = 0L;
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
        validateFileMd5 = false;
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
      if (currentAbsoluteReadPosition + paramLong <= streamLength)
      {
        validateFileMd5 = false;
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
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */