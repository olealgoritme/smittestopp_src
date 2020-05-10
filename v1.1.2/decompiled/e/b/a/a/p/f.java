package e.b.a.a.p;

public final class f
{
  public static final String a = String.valueOf(Integer.MIN_VALUE);
  public static final int[] b = new int['Ϩ'];
  
  static
  {
    int i = 0;
    int j = 0;
    while (i < 10)
    {
      for (int k = 0; k < 10; k++)
      {
        int m = 0;
        while (m < 10)
        {
          b[j] = (i + 48 << 16 | k + 48 << 8 | m + 48);
          m++;
          j++;
        }
      }
      i++;
    }
  }
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = b[paramInt1];
    paramInt1 = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(i >> 16));
    paramInt2 = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(byte)(i >> 8));
    paramArrayOfByte[paramInt2] = ((byte)(byte)i);
    return paramInt2 + 1;
  }
  
  public static int a(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    paramInt1 = b[paramInt1];
    int i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = ((char)(char)(paramInt1 >> 16));
    paramInt2 = i + 1;
    paramArrayOfChar[i] = ((char)(char)(paramInt1 >> 8 & 0x7F));
    paramArrayOfChar[paramInt2] = ((char)(char)(paramInt1 & 0x7F));
    return paramInt2 + 1;
  }
  
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = b[paramInt1];
    int j = paramInt2;
    if (paramInt1 > 9)
    {
      j = paramInt2;
      if (paramInt1 > 99)
      {
        paramArrayOfByte[paramInt2] = ((byte)(byte)(i >> 16));
        j = paramInt2 + 1;
      }
      paramArrayOfByte[j] = ((byte)(byte)(i >> 8));
      j++;
    }
    paramArrayOfByte[j] = ((byte)(byte)i);
    return j + 1;
  }
  
  public static int b(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = b[paramInt1];
    int j = paramInt2;
    if (paramInt1 > 9)
    {
      j = paramInt2;
      if (paramInt1 > 99)
      {
        paramArrayOfChar[paramInt2] = ((char)(char)(i >> 16));
        j = paramInt2 + 1;
      }
      paramArrayOfChar[j] = ((char)(char)(i >> 8 & 0x7F));
      j++;
    }
    paramArrayOfChar[j] = ((char)(char)(i & 0x7F));
    return j + 1;
  }
  
  public static int c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE)
      {
        j = a.length();
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          paramArrayOfByte[paramInt2] = ((byte)(byte)a.charAt(paramInt1));
          paramInt1++;
          paramInt2++;
        }
        return paramInt2;
      }
      paramArrayOfByte[paramInt2] = ((byte)45);
      i = -paramInt1;
      j = paramInt2 + 1;
    }
    if (i < 1000000)
    {
      if (i < 1000)
      {
        if (i < 10)
        {
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(byte)(i + 48));
        }
        else
        {
          paramInt1 = b(i, paramArrayOfByte, j);
        }
      }
      else
      {
        paramInt1 = i / 1000;
        paramInt1 = a(i - paramInt1 * 1000, paramArrayOfByte, b(paramInt1, paramArrayOfByte, j));
      }
      return paramInt1;
    }
    if (i >= 1000000000)
    {
      paramInt1 = i - 1000000000;
      if (paramInt1 >= 1000000000)
      {
        paramInt1 -= 1000000000;
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)50);
      }
      else
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)49);
      }
      j = paramInt1 / 1000;
      i = j / 1000;
      int[] arrayOfInt = b;
      int k = arrayOfInt[i];
      int m = paramInt2 + 1;
      paramArrayOfByte[paramInt2] = ((byte)(byte)(k >> 16));
      int n = m + 1;
      paramArrayOfByte[m] = ((byte)(byte)(k >> 8));
      paramInt2 = n + 1;
      paramArrayOfByte[n] = ((byte)(byte)k);
      i = arrayOfInt[(j - i * 1000)];
      n = paramInt2 + 1;
      paramArrayOfByte[paramInt2] = ((byte)(byte)(i >> 16));
      k = n + 1;
      paramArrayOfByte[n] = ((byte)(byte)(i >> 8));
      paramInt2 = k + 1;
      paramArrayOfByte[k] = ((byte)(byte)i);
      paramInt1 = arrayOfInt[(paramInt1 - j * 1000)];
      j = paramInt2 + 1;
      paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >> 16));
      paramInt2 = j + 1;
      paramArrayOfByte[j] = ((byte)(byte)(paramInt1 >> 8));
      paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
      return paramInt2 + 1;
    }
    paramInt1 = i / 1000;
    paramInt2 = paramInt1 / 1000;
    return a(i - paramInt1 * 1000, paramArrayOfByte, a(paramInt1 - paramInt2 * 1000, paramArrayOfByte, b(paramInt2, paramArrayOfByte, j)));
  }
  
  public static int c(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE)
      {
        paramInt1 = a.length();
        a.getChars(0, paramInt1, paramArrayOfChar, paramInt2);
        return paramInt2 + paramInt1;
      }
      paramArrayOfChar[paramInt2] = ((char)45);
      i = -paramInt1;
      j = paramInt2 + 1;
    }
    if (i < 1000000)
    {
      if (i < 1000)
      {
        if (i < 10)
        {
          paramArrayOfChar[j] = ((char)(char)(i + 48));
          return j + 1;
        }
        return b(i, paramArrayOfChar, j);
      }
      paramInt1 = i / 1000;
      return a(i - paramInt1 * 1000, paramArrayOfChar, b(paramInt1, paramArrayOfChar, j));
    }
    if (i >= 1000000000)
    {
      paramInt1 = i - 1000000000;
      if (paramInt1 >= 1000000000)
      {
        paramInt1 -= 1000000000;
        paramInt2 = j + 1;
        paramArrayOfChar[j] = ((char)50);
      }
      else
      {
        paramInt2 = j + 1;
        paramArrayOfChar[j] = ((char)49);
      }
      j = paramInt1 / 1000;
      i = j / 1000;
      int[] arrayOfInt = b;
      int k = arrayOfInt[i];
      int m = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)(k >> 16));
      int n = m + 1;
      paramArrayOfChar[m] = ((char)(char)(k >> 8 & 0x7F));
      paramInt2 = n + 1;
      paramArrayOfChar[n] = ((char)(char)(k & 0x7F));
      i = arrayOfInt[(j - i * 1000)];
      k = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)(i >> 16));
      n = k + 1;
      paramArrayOfChar[k] = ((char)(char)(i >> 8 & 0x7F));
      paramInt2 = n + 1;
      paramArrayOfChar[n] = ((char)(char)(i & 0x7F));
      j = arrayOfInt[(paramInt1 - j * 1000)];
      paramInt1 = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)(j >> 16));
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = ((char)(char)(j >> 8 & 0x7F));
      paramArrayOfChar[paramInt2] = ((char)(char)(j & 0x7F));
      return paramInt2 + 1;
    }
    paramInt1 = i / 1000;
    paramInt2 = paramInt1 / 1000;
    return a(i - paramInt1 * 1000, paramArrayOfChar, a(paramInt1 - paramInt2 * 1000, paramArrayOfChar, b(paramInt2, paramArrayOfChar, j)));
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.p.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */