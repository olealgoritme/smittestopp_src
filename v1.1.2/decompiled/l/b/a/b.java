package l.b.a;

import java.io.IOException;

public abstract class b
  extends t
  implements a0
{
  public static final char[] z = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public final byte[] x;
  public final int y;
  
  public b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramArrayOfByte.length == 0) && (paramInt != 0)) {
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
      }
      if ((paramInt <= 7) && (paramInt >= 0))
      {
        x = l.b.c.e.a.a(paramArrayOfByte);
        y = paramInt;
        return;
      }
      throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }
    throw new NullPointerException("'data' cannot be null");
  }
  
  public boolean a(t paramt)
  {
    boolean bool1 = paramt instanceof b;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = (b)paramt;
    if (y != y) {
      return false;
    }
    paramt = x;
    localObject = x;
    int i = paramt.length;
    if (i != localObject.length) {
      return false;
    }
    int j = i - 1;
    if (j < 0) {
      return true;
    }
    for (i = 0; i < j; i++) {
      if (paramt[i] != localObject[i]) {
        return false;
      }
    }
    int k = paramt[j];
    i = y;
    if ((byte)(k & 255 << i) == (byte)(localObject[j] & 255 << i)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public String c()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    try
    {
      localObject = e();
      for (int i = 0; i != localObject.length; i++)
      {
        localStringBuffer.append(z[(localObject[i] >>> 4 & 0xF)]);
        localStringBuffer.append(z[(localObject[i] & 0xF)]);
      }
      return localStringBuffer.toString();
    }
    catch (IOException localIOException)
    {
      Object localObject = e.a.a.a.a.a("Internal error encoding BitString: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new s(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  public t h()
  {
    return new r0(x, y);
  }
  
  public int hashCode()
  {
    byte[] arrayOfByte = x;
    int i = arrayOfByte.length - 1;
    if (i < 0) {
      return 1;
    }
    int j = (byte)(arrayOfByte[i] & 255 << y);
    int k = 0;
    if (arrayOfByte != null) {
      for (k = i + 1;; k = k * 257 ^ arrayOfByte[(0 + i)])
      {
        i--;
        if (i < 0) {
          break;
        }
      }
    }
    return k * 257 ^ j ^ y;
  }
  
  public t i()
  {
    return new n1(x, y);
  }
  
  public byte[] j()
  {
    byte[] arrayOfByte1 = x;
    int i = y;
    byte[] arrayOfByte2;
    if (arrayOfByte1.length == 0)
    {
      arrayOfByte2 = arrayOfByte1;
    }
    else
    {
      arrayOfByte2 = l.b.c.e.a.a(arrayOfByte1);
      int j = arrayOfByte1.length - 1;
      arrayOfByte2[j] = ((byte)(byte)(255 << i & arrayOfByte2[j]));
    }
    return arrayOfByte2;
  }
  
  public String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     l.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */