package e.e.a.v;

public final class b
{
  public static byte a(int paramInt)
  {
    int i = c(paramInt, 26);
    int j = b(paramInt, 25);
    int k = c(paramInt, 52);
    int m = b(paramInt, 51);
    int n = c(paramInt, 62);
    int i1 = a(paramInt, 62);
    int i2 = a(paramInt, 63);
    i = a(i, paramInt + 0 + 65, 0);
    j = a(j & k, paramInt - 26 + 97, 0);
    return (byte)(a(m & n, paramInt - 52 + 48, 0) | i | j | a(i1, 43, 0) | a(i2, 47, 0));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    paramInt1 ^= paramInt2;
    return (paramInt1 & paramInt1 - 1) >>> 63;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 - 1 & (paramInt3 ^ paramInt2) ^ paramInt2;
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    int j;
    if (paramArrayOfByte != null) {
      j = paramArrayOfByte.length;
    } else {
      j = 0;
    }
    if (j == 0) {
      return "";
    }
    int k = j / 3;
    int m = k * 3;
    if (j == 0)
    {
      k = 0;
    }
    else if (paramBoolean)
    {
      k <<= 2;
      n = j % 3;
      if (n != 0) {
        k = k + n + 1;
      }
    }
    else
    {
      k = (j - 1) / 3 + 1 << 2;
    }
    byte[] arrayOfByte = new byte[k];
    int i1 = 0;
    int n = 0;
    while (i1 < m)
    {
      int i2 = i1 + 1;
      int i3 = paramArrayOfByte[i1];
      i1 = i2 + 1;
      i2 = (i3 & 0xFF) << 16 | (paramArrayOfByte[i2] & 0xFF) << 8 | paramArrayOfByte[i1] & 0xFF;
      if (paramBoolean)
      {
        i3 = n + 1;
        arrayOfByte[n] = b(i2 >>> 18 & 0x3F);
        n = i3 + 1;
        arrayOfByte[i3] = b(i2 >>> 12 & 0x3F);
        i3 = n + 1;
        arrayOfByte[n] = b(i2 >>> 6 & 0x3F);
        n = i3 + 1;
        arrayOfByte[i3] = b(i2 & 0x3F);
      }
      else
      {
        i3 = n + 1;
        arrayOfByte[n] = a(i2 >>> 18 & 0x3F);
        n = i3 + 1;
        arrayOfByte[i3] = a(i2 >>> 12 & 0x3F);
        i3 = n + 1;
        arrayOfByte[n] = a(i2 >>> 6 & 0x3F);
        n = i3 + 1;
        arrayOfByte[i3] = a(i2 & 0x3F);
      }
      i1++;
    }
    i1 = j - m;
    if (i1 > 0)
    {
      m = paramArrayOfByte[m];
      n = i;
      if (i1 == 2) {
        n = (paramArrayOfByte[(j - 1)] & 0xFF) << 2;
      }
      n = (m & 0xFF) << 10 | n;
      if (paramBoolean)
      {
        if (i1 == 2)
        {
          arrayOfByte[(k - 3)] = b(n >> 12);
          arrayOfByte[(k - 2)] = b(n >>> 6 & 0x3F);
          arrayOfByte[(k - 1)] = b(n & 0x3F);
        }
        else
        {
          arrayOfByte[(k - 2)] = b(n >> 12);
          arrayOfByte[(k - 1)] = b(n >>> 6 & 0x3F);
        }
      }
      else
      {
        arrayOfByte[(k - 4)] = a(n >> 12);
        arrayOfByte[(k - 3)] = a(n >>> 6 & 0x3F);
        if (i1 == 2) {
          n = a(n & 0x3F);
        } else {
          n = 61;
        }
        arrayOfByte[(k - 2)] = ((byte)n);
        arrayOfByte[(k - 1)] = ((byte)61);
      }
    }
    return new String(arrayOfByte, d.a);
  }
  
  public static byte b(int paramInt)
  {
    int i = c(paramInt, 26);
    int j = b(paramInt, 25);
    int k = c(paramInt, 52);
    int m = b(paramInt, 51);
    int n = c(paramInt, 62);
    int i1 = a(paramInt, 62);
    int i2 = a(paramInt, 63);
    i = a(i, paramInt + 0 + 65, 0);
    j = a(j & k, paramInt - 26 + 97, 0);
    return (byte)(a(m & n, paramInt - 52 + 48, 0) | i | j | a(i1, 45, 0) | a(i2, 95, 0));
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return (int)(paramInt2 - paramInt1 >>> 63);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return (int)(paramInt1 - paramInt2 >>> 63);
  }
}

/* Location:
 * Qualified Name:     e.e.a.v.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */