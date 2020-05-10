package e.b.a.a.p;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class i
  extends Writer
{
  public final int A;
  public int B;
  public int C;
  public final b x;
  public OutputStream y;
  public byte[] z;
  
  public i(b paramb, OutputStream paramOutputStream)
  {
    x = paramb;
    y = paramOutputStream;
    paramb.a(f);
    paramOutputStream = d.a(1);
    f = paramOutputStream;
    z = paramOutputStream;
    A = (paramOutputStream.length - 4);
    B = 0;
  }
  
  public static void b(int paramInt)
  {
    throw new IOException(c(paramInt));
  }
  
  public static String c(int paramInt)
  {
    if (paramInt > 1114111)
    {
      localStringBuilder = e.a.a.a.a.a("Illegal character point (0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(") to output; max is 0x10FFFF as per RFC 4627");
      return localStringBuilder.toString();
    }
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319)
      {
        localStringBuilder = e.a.a.a.a.a("Unmatched first part of surrogate pair (0x");
        localStringBuilder.append(Integer.toHexString(paramInt));
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      localStringBuilder = e.a.a.a.a.a("Unmatched second part of surrogate pair (0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Illegal character point (0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append(") to output");
    return localStringBuilder.toString();
  }
  
  public int a(int paramInt)
  {
    int i = C;
    C = 0;
    if ((paramInt >= 56320) && (paramInt <= 57343)) {
      return paramInt - 56320 + ((i - 55296 << 10) + 65536);
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Broken surrogate pair: first char 0x");
    localStringBuilder.append(Integer.toHexString(i));
    localStringBuilder.append(", second 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append("; illegal combination");
    throw new IOException(localStringBuilder.toString());
  }
  
  public Writer append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public Appendable append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public void close()
  {
    OutputStream localOutputStream = y;
    if (localOutputStream != null)
    {
      int i = B;
      if (i > 0)
      {
        localOutputStream.write(z, 0, i);
        B = 0;
      }
      localOutputStream = y;
      y = null;
      byte[] arrayOfByte = z;
      if (arrayOfByte != null)
      {
        z = null;
        x.b(arrayOfByte);
      }
      localOutputStream.close();
      i = C;
      C = 0;
      if (i > 0)
      {
        b(i);
        throw null;
      }
    }
  }
  
  public void flush()
  {
    OutputStream localOutputStream = y;
    if (localOutputStream != null)
    {
      int i = B;
      if (i > 0)
      {
        localOutputStream.write(z, 0, i);
        B = 0;
      }
      y.flush();
    }
  }
  
  public void write(int paramInt)
  {
    int i;
    if (C > 0)
    {
      i = a(paramInt);
    }
    else
    {
      i = paramInt;
      if (paramInt >= 55296)
      {
        i = paramInt;
        if (paramInt <= 57343)
        {
          if (paramInt <= 56319)
          {
            C = paramInt;
            return;
          }
          b(paramInt);
          throw null;
        }
      }
    }
    paramInt = B;
    if (paramInt >= A)
    {
      y.write(z, 0, paramInt);
      B = 0;
    }
    byte[] arrayOfByte;
    if (i < 128)
    {
      arrayOfByte = z;
      paramInt = B;
      B = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)(byte)i);
    }
    else
    {
      paramInt = B;
      int j;
      if (i < 2048)
      {
        arrayOfByte = z;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 6 | 0xC0));
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
      }
      else if (i <= 65535)
      {
        arrayOfByte = z;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 12 | 0xE0));
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
        arrayOfByte[paramInt] = ((byte)(byte)(i & 0x3F | 0x80));
        paramInt++;
      }
      else
      {
        if (i > 1114111) {
          break label338;
        }
        arrayOfByte = z;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 18 | 0xF0));
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i >> 12 & 0x3F | 0x80));
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
      }
      B = paramInt;
    }
    return;
    label338:
    b(i);
    throw null;
  }
  
  public void write(String paramString)
  {
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramString.charAt(paramInt1));
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (C > 0)
    {
      i = paramString.charAt(paramInt1);
      j = paramInt2 - 1;
      write(a(i));
      i = paramInt1 + 1;
    }
    paramInt1 = B;
    byte[] arrayOfByte = z;
    int k = A;
    int m = j + i;
    paramInt2 = i;
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 >= m) {
        break;
      }
      i = paramInt1;
      if (paramInt1 >= k)
      {
        y.write(arrayOfByte, 0, paramInt1);
        i = 0;
      }
      j = paramInt2 + 1;
      int n = paramString.charAt(paramInt2);
      paramInt2 = i;
      paramInt1 = j;
      int i1 = n;
      if (n < 128)
      {
        paramInt1 = i + 1;
        arrayOfByte[i] = ((byte)(byte)n);
        i1 = m - j;
        paramInt2 = k - paramInt1;
        i = i1;
        if (i1 > paramInt2) {
          i = paramInt2;
        }
        paramInt2 = j;
        while (paramInt2 < i + j)
        {
          i1 = paramInt2 + 1;
          n = paramString.charAt(paramInt2);
          if (n >= 128)
          {
            paramInt2 = paramInt1;
            paramInt1 = i1;
            i1 = n;
            break label257;
          }
          int i2 = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(byte)n);
          paramInt2 = i1;
          paramInt1 = i2;
        }
      }
      else
      {
        label257:
        if (i1 < 2048)
        {
          j = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(byte)(i1 >> 6 | 0xC0));
          i = j + 1;
          arrayOfByte[j] = ((byte)(byte)(i1 & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        else if ((i1 >= 55296) && (i1 <= 57343))
        {
          if (i1 <= 56319)
          {
            C = i1;
            if (paramInt1 >= m)
            {
              i = paramInt2;
              break;
            }
            i = paramInt1 + 1;
            j = a(paramString.charAt(paramInt1));
            if (j <= 1114111)
            {
              i1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(j >> 18 | 0xF0));
              paramInt1 = i1 + 1;
              arrayOfByte[i1] = ((byte)(byte)(j >> 12 & 0x3F | 0x80));
              paramInt2 = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(byte)(j >> 6 & 0x3F | 0x80));
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(j & 0x3F | 0x80));
              paramInt2 = i;
            }
            else
            {
              B = paramInt2;
              b(j);
              throw null;
            }
          }
          else
          {
            B = paramInt2;
            b(i1);
            throw null;
          }
        }
        else
        {
          i = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(byte)(i1 >> 12 | 0xE0));
          j = i + 1;
          arrayOfByte[i] = ((byte)(byte)(i1 >> 6 & 0x3F | 0x80));
          arrayOfByte[j] = ((byte)(byte)(i1 & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = j + 1;
        }
      }
    }
    B = i;
  }
  
  public void write(char[] paramArrayOfChar)
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramArrayOfChar[paramInt1]);
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (C > 0)
    {
      i = paramArrayOfChar[paramInt1];
      j = paramInt2 - 1;
      write(a(i));
      i = paramInt1 + 1;
    }
    paramInt1 = B;
    byte[] arrayOfByte = z;
    int k = A;
    int m = j + i;
    paramInt2 = i;
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 >= m) {
        break;
      }
      i = paramInt1;
      if (paramInt1 >= k)
      {
        y.write(arrayOfByte, 0, paramInt1);
        i = 0;
      }
      j = paramInt2 + 1;
      int n = paramArrayOfChar[paramInt2];
      paramInt2 = i;
      paramInt1 = j;
      int i1 = n;
      if (n < 128)
      {
        paramInt1 = i + 1;
        arrayOfByte[i] = ((byte)(byte)n);
        i1 = m - j;
        paramInt2 = k - paramInt1;
        i = i1;
        if (i1 > paramInt2) {
          i = paramInt2;
        }
        paramInt2 = j;
        while (paramInt2 < i + j)
        {
          i1 = paramInt2 + 1;
          n = paramArrayOfChar[paramInt2];
          if (n >= 128)
          {
            paramInt2 = paramInt1;
            paramInt1 = i1;
            i1 = n;
            break label249;
          }
          int i2 = paramInt1 + 1;
          arrayOfByte[paramInt1] = ((byte)(byte)n);
          paramInt2 = i1;
          paramInt1 = i2;
        }
      }
      else
      {
        label249:
        if (i1 < 2048)
        {
          j = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(byte)(i1 >> 6 | 0xC0));
          i = j + 1;
          arrayOfByte[j] = ((byte)(byte)(i1 & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        else if ((i1 >= 55296) && (i1 <= 57343))
        {
          if (i1 <= 56319)
          {
            C = i1;
            if (paramInt1 >= m)
            {
              i = paramInt2;
              break;
            }
            i = paramInt1 + 1;
            j = a(paramArrayOfChar[paramInt1]);
            if (j <= 1114111)
            {
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(j >> 18 | 0xF0));
              i1 = paramInt1 + 1;
              arrayOfByte[paramInt1] = ((byte)(byte)(j >> 12 & 0x3F | 0x80));
              paramInt2 = i1 + 1;
              arrayOfByte[i1] = ((byte)(byte)(j >> 6 & 0x3F | 0x80));
              paramInt1 = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(j & 0x3F | 0x80));
              paramInt2 = i;
            }
            else
            {
              B = paramInt2;
              b(j);
              throw null;
            }
          }
          else
          {
            B = paramInt2;
            b(i1);
            throw null;
          }
        }
        else
        {
          i = paramInt2 + 1;
          arrayOfByte[paramInt2] = ((byte)(byte)(i1 >> 12 | 0xE0));
          j = i + 1;
          arrayOfByte[i] = ((byte)(byte)(i1 >> 6 & 0x3F | 0x80));
          arrayOfByte[j] = ((byte)(byte)(i1 & 0x3F | 0x80));
          paramInt2 = paramInt1;
          paramInt1 = j + 1;
        }
      }
    }
    B = i;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.p.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */