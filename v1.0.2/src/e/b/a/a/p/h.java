package e.b.a.a.p;

import e.a.a.a.a;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class h
  extends Reader
{
  public int A;
  public int B;
  public final boolean C;
  public char D;
  public int E;
  public int F;
  public final boolean G;
  public char[] H;
  public final b x;
  public InputStream y;
  public byte[] z;
  
  public h(b paramb, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    D = ((char)0);
    x = paramb;
    y = paramInputStream;
    z = paramArrayOfByte;
    A = paramInt1;
    B = paramInt2;
    C = paramBoolean;
    paramBoolean = bool;
    if (paramInputStream != null) {
      paramBoolean = true;
    }
    G = paramBoolean;
  }
  
  public final void a()
  {
    byte[] arrayOfByte = z;
    if (arrayOfByte != null)
    {
      z = null;
      x.a(arrayOfByte);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = F;
    int j = E;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", needed ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", at char #");
    localStringBuilder.append(j);
    localStringBuilder.append(", byte #");
    localStringBuilder.append(i + paramInt1);
    localStringBuilder.append(")");
    throw new CharConversionException(localStringBuilder.toString());
  }
  
  public void close()
  {
    InputStream localInputStream = y;
    if (localInputStream != null)
    {
      y = null;
      a();
      localInputStream.close();
    }
  }
  
  public int read()
  {
    if (H == null) {
      H = new char[1];
    }
    if (read(H, 0, 1) < 1) {
      return -1;
    }
    return H[0];
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = z;
    if (arrayOfByte == null) {
      return -1;
    }
    if (paramInt2 < 1) {
      return paramInt2;
    }
    if (paramInt1 >= 0)
    {
      int i = paramInt1 + paramInt2;
      if (i <= paramArrayOfChar.length)
      {
        int j = D;
        int k;
        if (j != 0)
        {
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = ((char)j);
          D = ((char)0);
        }
        else
        {
          paramInt2 = B;
          k = A;
          j = paramInt2 - k;
          if (j < 4)
          {
            F = (paramInt2 - j + F);
            if (j > 0)
            {
              if (k > 0)
              {
                System.arraycopy(arrayOfByte, k, arrayOfByte, 0, j);
                A = 0;
              }
              B = j;
            }
            else
            {
              A = 0;
              localObject = y;
              if (localObject == null) {
                paramInt2 = -1;
              } else {
                paramInt2 = ((InputStream)localObject).read(arrayOfByte);
              }
              if (paramInt2 < 1)
              {
                B = 0;
                if (paramInt2 < 0)
                {
                  if (G) {
                    a();
                  }
                  paramInt2 = 0;
                  break label314;
                }
                throw new IOException("Strange I/O stream, returned 0 bytes on read");
              }
            }
            for (B = paramInt2;; B += paramInt2)
            {
              paramInt2 = B;
              if (paramInt2 >= 4) {
                break;
              }
              localObject = y;
              if (localObject == null)
              {
                paramInt2 = -1;
              }
              else
              {
                arrayOfByte = z;
                paramInt2 = ((InputStream)localObject).read(arrayOfByte, paramInt2, arrayOfByte.length - paramInt2);
              }
              if (paramInt2 < 1)
              {
                if (paramInt2 < 0)
                {
                  if (G) {
                    a();
                  }
                  a(B, 4);
                  throw null;
                }
                throw new IOException("Strange I/O stream, returned 0 bytes on read");
              }
            }
            paramInt2 = 1;
            label314:
            if (paramInt2 == 0)
            {
              if (j == 0) {
                return -1;
              }
              a(B - A, 4);
              throw null;
            }
          }
          paramInt2 = paramInt1;
        }
        int m = B;
        for (;;)
        {
          j = paramInt2;
          if (paramInt2 >= i) {
            break;
          }
          j = A;
          int n;
          if (C)
          {
            localObject = z;
            n = localObject[j] << 8 | localObject[(j + 1)] & 0xFF;
            k = localObject[(j + 2)];
            j = localObject[(j + 3)] & 0xFF | (k & 0xFF) << 8;
          }
          else
          {
            localObject = z;
            i1 = localObject[j];
            k = localObject[(j + 1)];
            n = localObject[(j + 2)];
            n = localObject[(j + 3)] << 8 | n & 0xFF;
            j = i1 & 0xFF | (k & 0xFF) << 8;
          }
          A += 4;
          k = paramInt2;
          int i1 = j;
          if (n != 0)
          {
            n = 0xFFFF & n;
            k = j | n - 1 << 16;
            if (n <= 16)
            {
              j = paramInt2 + 1;
              paramArrayOfChar[paramInt2] = ((char)(char)((k >> 10) + 55296));
              if (j >= i)
              {
                D = ((char)(char)k);
                paramInt2 = j;
                break label737;
              }
              i1 = 0xDC00 | k & 0x3FF;
              k = j;
            }
            else
            {
              localObject = String.format(" (above 0x%08x)", new Object[] { Integer.valueOf(1114111) });
              i1 = F;
              j = A;
              n = E;
              paramArrayOfChar = a.a("Invalid UTF-32 character 0x");
              paramArrayOfChar.append(Integer.toHexString(k));
              paramArrayOfChar.append((String)localObject);
              paramArrayOfChar.append(" at char #");
              paramArrayOfChar.append(n + (paramInt2 - paramInt1));
              paramArrayOfChar.append(", byte #");
              throw new CharConversionException(a.a(paramArrayOfChar, i1 + j - 1, ")"));
            }
          }
          paramInt2 = k + 1;
          paramArrayOfChar[k] = ((char)(char)i1);
          if (A > m - 4)
          {
            label737:
            j = paramInt2;
            break;
          }
        }
        paramInt1 = j - paramInt1;
        E += paramInt1;
        return paramInt1;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("read(buf,");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("), cbuf[");
    throw new ArrayIndexOutOfBoundsException(a.a((StringBuilder)localObject, paramArrayOfChar.length, "]"));
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.p.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */