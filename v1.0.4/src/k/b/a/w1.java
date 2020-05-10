package k.b.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class w1
  extends b2
{
  public static final byte[] B = new byte[0];
  public int A;
  public final int z;
  
  public w1(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    super(paramInputStream, paramInt2, paramInt1);
    if (paramInt1 >= 0)
    {
      z = paramInt1;
      A = paramInt1;
      if (paramInt1 == 0) {
        a(true);
      }
      return;
    }
    throw new IllegalArgumentException("negative lengths not allowed");
  }
  
  public byte[] a()
  {
    int i = A;
    if (i == 0) {
      return B;
    }
    if (i < y)
    {
      localObject = new byte[i];
      i -= k.b.j.h.a.a(x, (byte[])localObject, 0, i);
      A = i;
      if (i == 0)
      {
        a(true);
        return (byte[])localObject;
      }
      localObject = e.a.a.a.a.a("DEF length ");
      ((StringBuilder)localObject).append(z);
      ((StringBuilder)localObject).append(" object truncated by ");
      ((StringBuilder)localObject).append(A);
      throw new EOFException(((StringBuilder)localObject).toString());
    }
    Object localObject = e.a.a.a.a.a("corrupted stream - out of bounds length found: ");
    ((StringBuilder)localObject).append(A);
    ((StringBuilder)localObject).append(" >= ");
    ((StringBuilder)localObject).append(y);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public int read()
  {
    if (A == 0) {
      return -1;
    }
    int i = x.read();
    if (i >= 0)
    {
      int j = A - 1;
      A = j;
      if (j == 0) {
        a(true);
      }
      return i;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("DEF length ");
    localStringBuilder.append(z);
    localStringBuilder.append(" object truncated by ");
    localStringBuilder.append(A);
    throw new EOFException(localStringBuilder.toString());
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = A;
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, i);
    paramInt1 = x.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 >= 0)
    {
      paramInt2 = A - paramInt1;
      A = paramInt2;
      if (paramInt2 == 0) {
        a(true);
      }
      return paramInt1;
    }
    paramArrayOfByte = e.a.a.a.a.a("DEF length ");
    paramArrayOfByte.append(z);
    paramArrayOfByte.append(" object truncated by ");
    paramArrayOfByte.append(A);
    throw new EOFException(paramArrayOfByte.toString());
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.w1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */