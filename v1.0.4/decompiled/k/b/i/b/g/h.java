package k.b.i.b.g;

import k.b.a.o;
import k.b.c.b;

public final class h
{
  public final k.b.c.a a;
  public final int b;
  
  public h(o paramo, int paramInt)
  {
    if (paramo != null)
    {
      a = f.a(paramo);
      b = paramInt;
      return;
    }
    throw new NullPointerException("digest == null");
  }
  
  public final byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = k.b.c.e.a.a(paramInt, b);
    a.a(arrayOfByte, 0, arrayOfByte.length);
    a.a(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    a.a(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramInt = b;
    paramArrayOfByte2 = new byte[paramInt];
    paramArrayOfByte1 = a;
    if ((paramArrayOfByte1 instanceof b)) {
      ((b)paramArrayOfByte1).doFinal(paramArrayOfByte2, 0, paramInt);
    } else {
      paramArrayOfByte1.a(paramArrayOfByte2, 0);
    }
    return paramArrayOfByte2;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == b)
    {
      if (paramArrayOfByte2.length == 32) {
        return a(3, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong address length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */