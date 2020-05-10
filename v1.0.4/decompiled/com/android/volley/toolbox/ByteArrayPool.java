package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ByteArrayPool
{
  public static final Comparator<byte[]> BUF_COMPARATOR = new ByteArrayPool.1();
  public final List<byte[]> mBuffersByLastUse = new ArrayList();
  public final List<byte[]> mBuffersBySize = new ArrayList(64);
  public int mCurrentSize = 0;
  public final int mSizeLimit;
  
  public ByteArrayPool(int paramInt)
  {
    mSizeLimit = paramInt;
  }
  
  private void trim()
  {
    try
    {
      while (mCurrentSize > mSizeLimit)
      {
        byte[] arrayOfByte = (byte[])mBuffersByLastUse.remove(0);
        mBuffersBySize.remove(arrayOfByte);
        mCurrentSize -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte[] getBuf(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < mBuffersBySize.size())
      {
        arrayOfByte = (byte[])mBuffersBySize.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          mCurrentSize -= arrayOfByte.length;
          mBuffersBySize.remove(i);
          mBuffersByLastUse.remove(arrayOfByte);
          return arrayOfByte;
        }
        i++;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
  }
  
  public void returnBuf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= mSizeLimit)
        {
          mBuffersByLastUse.add(paramArrayOfByte);
          int i = Collections.binarySearch(mBuffersBySize, paramArrayOfByte, BUF_COMPARATOR);
          int j = i;
          if (i < 0) {
            j = -i - 1;
          }
          mBuffersBySize.add(j, paramArrayOfByte);
          mCurrentSize += paramArrayOfByte.length;
          trim();
          return;
        }
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.ByteArrayPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */