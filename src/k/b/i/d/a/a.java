package k.b.i.d.a;

public class a
{
  public int a;
  public int b;
  public int[][] c;
  public int d;
  
  public a(int paramInt, int[][] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt[0].length == paramInt + 31 >> 5)
    {
      b = paramInt;
      a = paramArrayOfInt.length;
      d = paramArrayOfInt[0].length;
      paramInt &= 0x1F;
      if (paramInt == 0) {
        paramInt = -1;
      } else {
        paramInt = (1 << paramInt) - 1;
      }
      while (i < a)
      {
        int[] arrayOfInt = paramArrayOfInt[i];
        int j = d - 1;
        arrayOfInt[j] &= paramInt;
        i++;
      }
      c = paramArrayOfInt;
      return;
    }
    throw new ArithmeticException("Int array does not match given number of columns.");
  }
  
  public a(a parama)
  {
    b = b;
    a = a;
    d = d;
    c = new int[c.length][];
    for (int i = 0;; i++)
    {
      int[][] arrayOfInt = c;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = k.b.c.e.a.a(c[i]);
    }
  }
  
  public a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 9)
    {
      a = k.b.c.e.a.a(paramArrayOfByte, 0);
      int i = k.b.c.e.a.a(paramArrayOfByte, 4);
      b = i;
      int j = a;
      if (j > 0)
      {
        int k = paramArrayOfByte.length;
        int m = 8;
        if ((i + 7 >>> 3) * j == k - 8)
        {
          i = i + 31 >>> 5;
          d = i;
          c = new int[j][i];
          k = b;
          int n = k >> 5;
          for (j = 0; j < a; j++)
          {
            i = 0;
            while (i < n)
            {
              c[j][i] = k.b.c.e.a.a(paramArrayOfByte, m);
              i++;
              m += 4;
            }
            i = 0;
            while (i < (k & 0x1F))
            {
              int[] arrayOfInt = c[j];
              int i1 = arrayOfInt[n];
              arrayOfInt[n] = ((paramArrayOfByte[m] & 0xFF) << i ^ i1);
              i += 8;
              m++;
            }
          }
          return;
        }
      }
      throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }
    throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
  }
  
  public byte[] a()
  {
    int i = b;
    int j = a;
    int k = 8;
    byte[] arrayOfByte = new byte[(i + 7 >>> 3) * j + 8];
    k.b.c.e.a.a(j, arrayOfByte, 0);
    k.b.c.e.a.a(b, arrayOfByte, 4);
    int m = b;
    int n = m >>> 5;
    for (j = 0; j < a; j++)
    {
      i = 0;
      while (i < n)
      {
        k.b.c.e.a.a(c[j][i], arrayOfByte, k);
        i++;
        k += 4;
      }
      i = 0;
      while (i < (m & 0x1F))
      {
        arrayOfByte[k] = ((byte)(byte)(c[j][n] >>> i & 0xFF));
        i += 8;
        k++;
      }
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    if ((a == a) && (b == b) && (d == d))
    {
      for (int i = 0; i < a; i++) {
        if (!k.b.c.e.a.a(c[i], c[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = (a * 31 + b) * 31 + d;
    for (int j = 0; j < a; j++) {
      i = i * 31 + k.b.c.e.a.b(c[j]);
    }
    return i;
  }
  
  public String toString()
  {
    int i = b & 0x1F;
    int j = d;
    if (i != 0) {
      j--;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    for (int k = 0; k < a; k++)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append(": ");
      localStringBuffer.append(localStringBuilder.toString());
      for (int m = 0; m < j; m++)
      {
        int n = c[k][m];
        for (i1 = 0; i1 < 32; i1++) {
          if ((n >>> i1 & 0x1) == 0) {
            localStringBuffer.append('0');
          } else {
            localStringBuffer.append('1');
          }
        }
        localStringBuffer.append(' ');
      }
      int i1 = c[k][(d - 1)];
      for (m = 0; m < i; m++) {
        if ((i1 >>> m & 0x1) == 0) {
          localStringBuffer.append('0');
        } else {
          localStringBuffer.append('1');
        }
      }
      localStringBuffer.append('\n');
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.d.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */