package e.b.a.a.p;

import java.io.InputStream;

public final class e
  extends InputStream
{
  public int A;
  public final int B;
  public final b x;
  public final InputStream y;
  public byte[] z;
  
  public e(b paramb, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    x = paramb;
    y = paramInputStream;
    z = paramArrayOfByte;
    A = paramInt1;
    B = paramInt2;
  }
  
  public final void a()
  {
    byte[] arrayOfByte = z;
    if (arrayOfByte != null)
    {
      z = null;
      b localb = x;
      if (localb != null) {
        localb.a(arrayOfByte);
      }
    }
  }
  
  public int available()
  {
    if (z != null) {
      return B - A;
    }
    return y.available();
  }
  
  public void close()
  {
    a();
    y.close();
  }
  
  public void mark(int paramInt)
  {
    if (z == null) {
      y.mark(paramInt);
    }
  }
  
  public boolean markSupported()
  {
    boolean bool;
    if ((z == null) && (y.markSupported())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int read()
  {
    byte[] arrayOfByte = z;
    if (arrayOfByte != null)
    {
      int i = A;
      int j = i + 1;
      A = j;
      i = arrayOfByte[i];
      if (j >= B) {
        a();
      }
      return i & 0xFF;
    }
    return y.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (z != null)
    {
      int i = B - A;
      int j = paramInt2;
      if (paramInt2 > i) {
        j = i;
      }
      System.arraycopy(z, A, paramArrayOfByte, paramInt1, j);
      paramInt1 = A + j;
      A = paramInt1;
      if (paramInt1 >= B) {
        a();
      }
      return j;
    }
    return y.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    if (z == null) {
      y.reset();
    }
  }
  
  public long skip(long paramLong)
  {
    long l2;
    if (z != null)
    {
      int i = B;
      int j = A;
      l1 = i - j;
      if (l1 > paramLong)
      {
        A = (j + (int)paramLong);
        return paramLong;
      }
      a();
      l2 = l1 + 0L;
      l1 = paramLong - l1;
      paramLong = l2;
      l2 = l1;
    }
    else
    {
      l1 = 0L;
      l2 = paramLong;
      paramLong = l1;
    }
    long l1 = paramLong;
    if (l2 > 0L) {
      l1 = paramLong + y.skip(l2);
    }
    return l1;
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.p.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */