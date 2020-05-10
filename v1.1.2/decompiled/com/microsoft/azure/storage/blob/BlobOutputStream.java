package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.DoesServiceRequest;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class BlobOutputStream
  extends OutputStream
{
  @DoesServiceRequest
  public abstract void close();
  
  @DoesServiceRequest
  public abstract void flush();
  
  @DoesServiceRequest
  public void write(int paramInt)
  {
    write(new byte[] { (byte)(paramInt & 0xFF) });
  }
  
  @DoesServiceRequest
  public abstract void write(InputStream paramInputStream, long paramLong);
  
  @DoesServiceRequest
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @DoesServiceRequest
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */