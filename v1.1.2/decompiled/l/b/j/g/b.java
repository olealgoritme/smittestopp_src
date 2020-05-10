package l.b.j.g;

import java.io.IOException;
import java.io.OutputStream;

public class b
  implements d
{
  public final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  public byte b = (byte)61;
  public final byte[] c = new byte[''];
  
  public b()
  {
    int i = 0;
    byte[] arrayOfByte;
    int k;
    for (int j = 0;; j++)
    {
      arrayOfByte = c;
      k = i;
      if (j >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[j] = ((byte)-1);
    }
    for (;;)
    {
      arrayOfByte = a;
      if (k >= arrayOfByte.length) {
        break;
      }
      c[arrayOfByte[k]] = ((byte)(byte)k);
      k++;
    }
  }
  
  public final int a(String paramString, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (a(paramString.charAt(paramInt1)))) {
      paramInt1++;
    }
    return paramInt1;
  }
  
  public int a(String paramString, OutputStream paramOutputStream)
  {
    for (int i = paramString.length(); (i > 0) && (a(paramString.charAt(i - 1))); i--) {}
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = i;
    for (int m = 0; (k > 0) && (m != 4); m = n)
    {
      n = m;
      if (!a(paramString.charAt(k - 1))) {
        n = m + 1;
      }
      k--;
    }
    int n = a(paramString, 0, k);
    m = j;
    while (n < k)
    {
      j = c[paramString.charAt(n)];
      i1 = a(paramString, n + 1, k);
      n = c[paramString.charAt(i1)];
      i2 = a(paramString, i1 + 1, k);
      i1 = c[paramString.charAt(i2)];
      i2 = a(paramString, i2 + 1, k);
      int i3 = c[paramString.charAt(i2)];
      if ((j | n | i1 | i3) >= 0)
      {
        paramOutputStream.write(j << 2 | n >> 4);
        paramOutputStream.write(n << 4 | i1 >> 2);
        paramOutputStream.write(i1 << 6 | i3);
        m += 3;
        n = a(paramString, i2 + 1, k);
      }
      else
      {
        throw new IOException("invalid characters encountered in base64 data");
      }
    }
    j = a(paramString, n, i);
    k = a(paramString, j + 1, i);
    n = a(paramString, k + 1, i);
    i = a(paramString, n + 1, i);
    int i1 = paramString.charAt(j);
    k = paramString.charAt(k);
    n = paramString.charAt(n);
    j = paramString.charAt(i);
    int i2 = b;
    i = 2;
    if (n == i2)
    {
      if (j == i2)
      {
        paramString = c;
        i = paramString[i1];
        k = paramString[k];
        if ((i | k) >= 0)
        {
          paramOutputStream.write(k >> 4 | i << 2);
          i = 1;
        }
        else
        {
          throw new IOException("invalid characters encountered at end of base64 data");
        }
      }
      else
      {
        throw new IOException("invalid characters encountered at end of base64 data");
      }
    }
    else if (j == i2)
    {
      paramString = c;
      j = paramString[i1];
      k = paramString[k];
      n = paramString[n];
      if ((j | k | n) >= 0)
      {
        paramOutputStream.write(j << 2 | k >> 4);
        paramOutputStream.write(n >> 2 | k << 4);
      }
      else
      {
        throw new IOException("invalid characters encountered at end of base64 data");
      }
    }
    else
    {
      paramString = c;
      i = paramString[i1];
      k = paramString[k];
      n = paramString[n];
      j = paramString[j];
      if ((i | k | n | j) < 0) {
        break label609;
      }
      paramOutputStream.write(i << 2 | k >> 4);
      paramOutputStream.write(k << 4 | n >> 2);
      paramOutputStream.write(j | n << 6);
      i = 3;
    }
    return m + i;
    label609:
    throw new IOException("invalid characters encountered at end of base64 data");
  }
  
  public final boolean a(char paramChar)
  {
    boolean bool;
    if ((paramChar != '\n') && (paramChar != '\r') && (paramChar != '\t') && (paramChar != ' ')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     l.b.j.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */