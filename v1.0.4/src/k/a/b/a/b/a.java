package k.a.b.a.b;

import java.nio.ByteBuffer;

public final class a
{
  public final byte[] a;
  public final int b;
  public final int c;
  public int d;
  
  public a(byte[] paramArrayOfByte)
  {
    a = paramArrayOfByte;
    b = 0;
    c = i;
  }
  
  public a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a = paramArrayOfByte;
    b = paramInt1;
    c = paramInt2;
  }
  
  public ByteBuffer a()
  {
    return ByteBuffer.wrap(a, b, c);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (a.class == paramObject.getClass()))
    {
      a locala = (a)paramObject;
      int i = c;
      if (i != c) {
        return false;
      }
      paramObject = a;
      byte[] arrayOfByte = a;
      int j = b;
      int k = b;
      int m = j;
      while (m < i + j)
      {
        if (paramObject[m] != arrayOfByte[k]) {
          return false;
        }
        m++;
        k++;
      }
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = d;
    int j = i;
    if (i == 0)
    {
      for (j = 0; j < c; j++) {
        i = i * 31 + (a[(b + j)] & 0xFF);
      }
      d = i;
      j = i;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < c; i++)
    {
      byte b1 = a[(b + i)];
      if ((b1 > 31) && (b1 < Byte.MAX_VALUE) && (b1 != 92)) {
        localStringBuilder.append((char)b1);
      } else {
        localStringBuilder.append(String.format("\\x%02x", new Object[] { Byte.valueOf(b1) }));
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */