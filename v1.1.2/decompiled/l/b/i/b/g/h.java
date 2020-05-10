package l.b.i.b.g;

import l.b.a.o;
import l.b.c.b;

public final class h
{
  public final l.b.c.a a;
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
    byte[] arrayOfByte = l.b.c.e.a.a(paramInt, b);
    a.a(arrayOfByte, 0, arrayOfByte.length);
    a.a(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    a.a(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramInt = b;
    paramArrayOfByte1 = new byte[paramInt];
    paramArrayOfByte2 = a;
    if ((paramArrayOfByte2 instanceof b)) {
      ((b)paramArrayOfByte2).doFinal(paramArrayOfByte1, 0, paramInt);
    } else {
      paramArrayOfByte2.a(paramArrayOfByte1, 0);
    }
    return paramArrayOfByte1;
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
 * Qualified Name:     l.b.i.b.g.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */