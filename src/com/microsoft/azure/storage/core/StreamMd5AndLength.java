package com.microsoft.azure.storage.core;

import java.security.MessageDigest;

public final class StreamMd5AndLength
{
  public long currentOperationByteCount;
  public MessageDigest intermediateMD5;
  public long streamLength;
  public String streamMd5;
  
  public long getCurrentOperationByteCount()
  {
    return currentOperationByteCount;
  }
  
  public MessageDigest getDigest()
  {
    return intermediateMD5;
  }
  
  public long getLength()
  {
    return streamLength;
  }
  
  public String getMd5()
  {
    if (streamMd5 == null)
    {
      MessageDigest localMessageDigest = intermediateMD5;
      if (localMessageDigest != null) {
        streamMd5 = Base64.encode(localMessageDigest.digest());
      }
    }
    return streamMd5;
  }
  
  public void setCurrentOperationByteCount(long paramLong)
  {
    currentOperationByteCount = paramLong;
  }
  
  public void setDigest(MessageDigest paramMessageDigest)
  {
    intermediateMD5 = paramMessageDigest;
  }
  
  public void setLength(long paramLong)
  {
    streamLength = paramLong;
  }
  
  public void setMd5(String paramString)
  {
    streamMd5 = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.StreamMd5AndLength
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */