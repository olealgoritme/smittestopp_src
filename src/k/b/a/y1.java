package k.b.a;

import java.io.EOFException;
import java.io.InputStream;

public class y1
  extends b2
{
  public int A;
  public boolean B = false;
  public boolean C = true;
  public int z;
  
  public y1(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt, paramInt);
    z = paramInputStream.read();
    paramInt = paramInputStream.read();
    A = paramInt;
    if (paramInt >= 0)
    {
      a();
      return;
    }
    throw new EOFException();
  }
  
  public final boolean a()
  {
    if ((!B) && (C) && (z == 0) && (A == 0))
    {
      B = true;
      a(true);
    }
    return B;
  }
  
  public int read()
  {
    if (a()) {
      return -1;
    }
    int i = x.read();
    if (i >= 0)
    {
      int j = z;
      z = A;
      A = i;
      return j;
    }
    throw new EOFException();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!C) && (paramInt2 >= 3))
    {
      if (B) {
        return -1;
      }
      paramInt2 = x.read(paramArrayOfByte, paramInt1 + 2, paramInt2 - 2);
      if (paramInt2 >= 0)
      {
        paramArrayOfByte[paramInt1] = ((byte)(byte)z);
        paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)A);
        z = x.read();
        paramInt1 = x.read();
        A = paramInt1;
        if (paramInt1 >= 0) {
          return paramInt2 + 2;
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    return super.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.y1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */