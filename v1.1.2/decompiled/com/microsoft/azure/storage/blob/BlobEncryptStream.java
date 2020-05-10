package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public final class BlobEncryptStream
  extends BlobOutputStream
{
  public CipherOutputStream cipherStream;
  public OperationContext opContext;
  public BlobRequestOptions options;
  
  @DoesServiceRequest
  public BlobEncryptStream(CloudAppendBlob paramCloudAppendBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, Cipher paramCipher)
  {
    opContext = paramOperationContext;
    options = paramBlobRequestOptions;
    paramBlobRequestOptions.setValidateEncryptionPolicy(false);
    cipherStream = new CipherOutputStream(new BlobOutputStreamInternal(paramCloudAppendBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramCipher);
  }
  
  public BlobEncryptStream(CloudBlockBlob paramCloudBlockBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, Cipher paramCipher)
  {
    opContext = paramOperationContext;
    options = paramBlobRequestOptions;
    paramBlobRequestOptions.setValidateEncryptionPolicy(false);
    cipherStream = new CipherOutputStream(new BlobOutputStreamInternal(paramCloudBlockBlob, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramCipher);
  }
  
  @DoesServiceRequest
  public BlobEncryptStream(CloudPageBlob paramCloudPageBlob, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, Cipher paramCipher)
  {
    opContext = paramOperationContext;
    options = paramBlobRequestOptions;
    paramBlobRequestOptions.setValidateEncryptionPolicy(false);
    cipherStream = new CipherOutputStream(new BlobOutputStreamInternal(paramCloudPageBlob, paramLong, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramCipher);
  }
  
  public void close()
  {
    cipherStream.close();
  }
  
  public void flush()
  {
    cipherStream.flush();
  }
  
  public void write(InputStream paramInputStream, long paramLong)
  {
    Utility.writeToOutputStream(paramInputStream, this, paramLong, false, false, opContext, options, Boolean.valueOf(false));
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    cipherStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobEncryptStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */