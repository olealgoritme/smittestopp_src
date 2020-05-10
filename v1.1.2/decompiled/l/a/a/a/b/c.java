package l.a.a.a.b;

import java.util.Arrays;

public abstract class c
{
  public final byte a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte)
  {
    b = paramInt1;
    c = paramInt2;
    int i = 0;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      i = paramInt3 / paramInt2 * paramInt2;
    }
    d = i;
    e = paramInt4;
    a = ((byte)paramByte);
  }
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, a parama);
  
  public abstract boolean a(byte paramByte);
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    int i = paramArrayOfByte.length;
    int j = 0;
    while (j < i)
    {
      byte b1 = paramArrayOfByte[j];
      if ((a != b1) && (!a(b1))) {
        j++;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public byte[] a(int paramInt, a parama)
  {
    byte[] arrayOfByte1 = c;
    if ((arrayOfByte1 != null) && (arrayOfByte1.length >= d + paramInt)) {
      return arrayOfByte1;
    }
    byte[] arrayOfByte2 = c;
    if (arrayOfByte2 == null)
    {
      c = new byte[' '];
      d = 0;
      e = 0;
    }
    else
    {
      arrayOfByte1 = new byte[arrayOfByte2.length * 2];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
      c = arrayOfByte1;
    }
    return c;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      a locala = new a();
      a(paramArrayOfByte, 0, paramArrayOfByte.length, locala);
      a(paramArrayOfByte, 0, -1, locala);
      int i = d;
      int j = e;
      int k = i - j;
      paramArrayOfByte = new byte[k];
      if (c != null)
      {
        k = Math.min(i - j, k);
        System.arraycopy(c, e, paramArrayOfByte, 0, k);
        k = e + k;
        e = k;
        if (k >= d) {
          c = null;
        }
      }
      else
      {
        boolean bool = f;
      }
      return paramArrayOfByte;
    }
    return paramArrayOfByte;
  }
  
  public static class a
  {
    public int a;
    public long b;
    public byte[] c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    
    public String toString()
    {
      return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] { a.class.getSimpleName(), Arrays.toString(c), Integer.valueOf(g), Boolean.valueOf(f), Integer.valueOf(a), Long.valueOf(b), Integer.valueOf(h), Integer.valueOf(d), Integer.valueOf(e) });
    }
  }
}

/* Location:
 * Qualified Name:     l.a.a.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */