package l.e.a;

public class c
{
  public byte[] a;
  public int b;
  
  public c()
  {
    a = new byte[64];
  }
  
  public c(int paramInt)
  {
    a = new byte[paramInt];
  }
  
  public final c a(int paramInt1, int paramInt2)
  {
    int i = b;
    if (i + 2 > a.length) {
      a(2);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)paramInt1);
    arrayOfByte[j] = ((byte)(byte)paramInt2);
    b = (j + 1);
    return this;
  }
  
  public final c a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = b;
    if (i + 4 > a.length) {
      a(4);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)paramInt1);
    paramInt1 = j + 1;
    arrayOfByte[j] = ((byte)(byte)paramInt2);
    paramInt2 = paramInt1 + 1;
    arrayOfByte[paramInt1] = ((byte)(byte)(paramInt3 >>> 8));
    arrayOfByte[paramInt2] = ((byte)(byte)paramInt3);
    b = (paramInt2 + 1);
    return this;
  }
  
  public final c a(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.length();
    int j = paramInt1;
    int k = j;
    int m = j;
    while (m < i)
    {
      j = paramString.charAt(m);
      if ((j >= 1) && (j <= 127)) {
        j = k + 1;
      } else if (j <= 2047) {
        j = k + 2;
      } else {
        j = k + 3;
      }
      m++;
      k = j;
    }
    if (k <= paramInt2)
    {
      paramInt2 = b - paramInt1 - 2;
      byte[] arrayOfByte;
      if (paramInt2 >= 0)
      {
        arrayOfByte = a;
        arrayOfByte[paramInt2] = ((byte)(byte)(k >>> 8));
        arrayOfByte[(paramInt2 + 1)] = ((byte)(byte)k);
      }
      if (b + k - paramInt1 > a.length) {
        a(k - paramInt1);
      }
      j = b;
      paramInt2 = paramInt1;
      while (paramInt2 < i)
      {
        m = paramString.charAt(paramInt2);
        if ((m >= 1) && (m <= 127))
        {
          arrayOfByte = a;
          paramInt1 = j + 1;
          arrayOfByte[j] = ((byte)(byte)m);
        }
        else if (m <= 2047)
        {
          arrayOfByte = a;
          k = j + 1;
          arrayOfByte[j] = ((byte)(byte)(m >> 6 & 0x1F | 0xC0));
          paramInt1 = k + 1;
          arrayOfByte[k] = ((byte)(byte)(m & 0x3F | 0x80));
        }
        else
        {
          arrayOfByte = a;
          paramInt1 = j + 1;
          arrayOfByte[j] = ((byte)(byte)(m >> 12 & 0xF | 0xE0));
          j = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(byte)(m >> 6 & 0x3F | 0x80));
          paramInt1 = j + 1;
          arrayOfByte[j] = ((byte)(byte)(m & 0x3F | 0x80));
        }
        paramInt2++;
        j = paramInt1;
      }
      b = j;
      return this;
    }
    throw new IllegalArgumentException("UTF8 string too large");
  }
  
  public c a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (b + paramInt2 > a.length) {
      a(paramInt2);
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(paramArrayOfByte, paramInt1, a, b, paramInt2);
    }
    b += paramInt2;
    return this;
  }
  
  public final void a(int paramInt)
  {
    int i = a.length * 2;
    paramInt = b + paramInt;
    if (i > paramInt) {
      paramInt = i;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(a, 0, arrayOfByte, 0, b);
    a = arrayOfByte;
  }
  
  public c b(int paramInt)
  {
    int i = b;
    int j = i + 1;
    if (j > a.length) {
      a(1);
    }
    a[i] = ((byte)(byte)paramInt);
    b = j;
    return this;
  }
  
  public final c b(int paramInt1, int paramInt2)
  {
    int i = b;
    if (i + 3 > a.length) {
      a(3);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)paramInt1);
    paramInt1 = j + 1;
    arrayOfByte[j] = ((byte)(byte)(paramInt2 >>> 8));
    arrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
    b = (paramInt1 + 1);
    return this;
  }
  
  public final c b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = b;
    if (i + 5 > a.length) {
      a(5);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)paramInt1);
    paramInt1 = j + 1;
    arrayOfByte[j] = ((byte)(byte)(paramInt2 >>> 8));
    j = paramInt1 + 1;
    arrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
    paramInt1 = j + 1;
    arrayOfByte[j] = ((byte)(byte)(paramInt3 >>> 8));
    arrayOfByte[paramInt1] = ((byte)(byte)paramInt3);
    b = (paramInt1 + 1);
    return this;
  }
  
  public c c(int paramInt)
  {
    int i = b;
    if (i + 4 > a.length) {
      a(4);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 24));
    i = j + 1;
    arrayOfByte[j] = ((byte)(byte)(paramInt >>> 16));
    j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 8));
    arrayOfByte[j] = ((byte)(byte)paramInt);
    b = (j + 1);
    return this;
  }
  
  public c d(int paramInt)
  {
    int i = b;
    if (i + 2 > a.length) {
      a(2);
    }
    byte[] arrayOfByte = a;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(byte)(paramInt >>> 8));
    arrayOfByte[j] = ((byte)(byte)paramInt);
    b = (j + 1);
    return this;
  }
}

/* Location:
 * Qualified Name:     l.e.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */