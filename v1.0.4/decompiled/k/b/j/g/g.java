package k.b.j.g;

import java.io.IOException;
import java.io.OutputStream;

public class g
  implements d
{
  public final byte[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public final byte[] b = new byte[''];
  
  public g()
  {
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      arrayOfByte = b;
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
      b[arrayOfByte[k]] = ((byte)(byte)k);
      k++;
    }
    byte[] arrayOfByte = b;
    arrayOfByte[65] = ((byte)arrayOfByte[97]);
    arrayOfByte[66] = ((byte)arrayOfByte[98]);
    arrayOfByte[67] = ((byte)arrayOfByte[99]);
    arrayOfByte[68] = ((byte)arrayOfByte[100]);
    arrayOfByte[69] = ((byte)arrayOfByte[101]);
    arrayOfByte[70] = ((byte)arrayOfByte[102]);
  }
  
  public static boolean a(char paramChar)
  {
    boolean bool;
    if ((paramChar != '\n') && (paramChar != '\r') && (paramChar != '\t') && (paramChar != ' ')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int a(String paramString, OutputStream paramOutputStream)
  {
    for (int i = paramString.length(); (i > 0) && (a(paramString.charAt(i - 1))); i--) {}
    int j = 0;
    int k = 0;
    while (j < i)
    {
      while ((j < i) && (a(paramString.charAt(j)))) {
        j++;
      }
      byte[] arrayOfByte = b;
      int m = j + 1;
      int n = arrayOfByte[paramString.charAt(j)];
      for (j = m; (j < i) && (a(paramString.charAt(j))); j++) {}
      m = b[paramString.charAt(j)];
      if ((n | m) >= 0)
      {
        paramOutputStream.write(n << 4 | m);
        k++;
        j++;
      }
      else
      {
        throw new IOException("invalid characters encountered in Hex string");
      }
    }
    return k;
  }
  
  public byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramString.length() - paramInt2))
      {
        if ((paramInt2 & 0x1) == 0)
        {
          int i = paramInt2 >>> 1;
          byte[] arrayOfByte1 = new byte[i];
          int j = 0;
          paramInt2 = paramInt1;
          paramInt1 = j;
          while (paramInt1 < i)
          {
            byte[] arrayOfByte2 = b;
            j = paramInt2 + 1;
            paramInt2 = arrayOfByte2[paramString.charAt(paramInt2)] << 4 | b[paramString.charAt(j)];
            if (paramInt2 >= 0)
            {
              arrayOfByte1[paramInt1] = ((byte)(byte)paramInt2);
              paramInt1++;
              paramInt2 = j + 1;
            }
            else
            {
              throw new IOException("invalid characters encountered in Hex string");
            }
          }
          return arrayOfByte1;
        }
        throw new IOException("a hexadecimal encoding must have an even number of characters");
      }
      throw new IndexOutOfBoundsException("invalid offset and/or length specified");
    }
    throw new NullPointerException("'str' cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.k.b.j.g.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */