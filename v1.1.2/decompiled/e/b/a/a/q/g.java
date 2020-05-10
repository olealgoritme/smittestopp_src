package e.b.a.a.q;

import e.b.a.a.f.a;
import e.b.a.a.k;
import e.b.a.a.p.b;
import e.b.a.a.p.f;
import java.io.OutputStream;

public class g
  extends c
{
  public static final byte[] P = (byte[])e.b.a.a.p.a.b.clone();
  public static final byte[] Q = { 110, 117, 108, 108 };
  public static final byte[] R = { 116, 114, 117, 101 };
  public static final byte[] S = { 102, 97, 108, 115, 101 };
  public final OutputStream G;
  public byte H = (byte)34;
  public byte[] I;
  public int J;
  public final int K;
  public final int L;
  public char[] M;
  public final int N;
  public boolean O;
  
  public g(b paramb, int paramInt, OutputStream paramOutputStream)
  {
    super(paramb, paramInt);
    G = paramOutputStream;
    O = true;
    paramb.a(f);
    paramOutputStream = d.a(1);
    f = paramOutputStream;
    I = paramOutputStream;
    paramInt = paramOutputStream.length;
    K = paramInt;
    L = (paramInt >> 3);
    paramb.a(h);
    paramOutputStream = d.a(1, 0);
    h = paramOutputStream;
    M = paramOutputStream;
    N = paramOutputStream.length;
    if (a(f.a.ESCAPE_NON_ASCII)) {
      C = 127;
    }
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = I;
    int i;
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = ((byte)92);
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)117);
      i = paramInt2 + 1;
      byte[] arrayOfByte2 = P;
      arrayOfByte1[paramInt2] = ((byte)arrayOfByte2[(paramInt1 >> 12 & 0xF)]);
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)arrayOfByte2[(paramInt1 >> 8 & 0xF)]);
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = ((byte)arrayOfByte2[(paramInt1 >> 4 & 0xF)]);
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)arrayOfByte2[(paramInt1 & 0xF)]);
      paramInt1 = paramInt2;
    }
    else
    {
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = ((byte)(byte)(paramInt1 >> 12 | 0xE0));
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)(byte)(paramInt1 >> 6 & 0x3F | 0x80));
      arrayOfByte1[paramInt2] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
  }
  
  public final int a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      if ((paramInt2 < paramInt3) && (paramArrayOfChar != null))
      {
        paramInt3 = paramArrayOfChar[paramInt2];
        if ((paramInt3 >= 56320) && (paramInt3 <= 57343))
        {
          paramInt1 = paramInt3 - 56320 + ((paramInt1 - 55296 << 10) + 65536);
          if (J + 4 > K) {
            d();
          }
          paramArrayOfChar = I;
          paramInt3 = J;
          i = paramInt3 + 1;
          J = i;
          paramArrayOfChar[paramInt3] = ((byte)(byte)(paramInt1 >> 18 | 0xF0));
          paramInt3 = i + 1;
          J = paramInt3;
          paramArrayOfChar[i] = ((byte)(byte)(paramInt1 >> 12 & 0x3F | 0x80));
          i = paramInt3 + 1;
          J = i;
          paramArrayOfChar[paramInt3] = ((byte)(byte)(paramInt1 >> 6 & 0x3F | 0x80));
          J = (i + 1);
          paramArrayOfChar[i] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
          return paramInt2 + 1;
        }
        paramArrayOfChar = e.a.a.a.a.a("Incomplete surrogate pair: first char 0x");
        paramArrayOfChar.append(Integer.toHexString(paramInt1));
        paramArrayOfChar.append(", second 0x");
        paramArrayOfChar.append(Integer.toHexString(paramInt3));
        throw new e.b.a.a.e(paramArrayOfChar.toString(), this);
      }
      throw new e.b.a.a.e(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", new Object[] { Integer.valueOf(paramInt1) }), this);
    }
    paramArrayOfChar = I;
    int i = J;
    paramInt3 = i + 1;
    J = paramInt3;
    paramArrayOfChar[i] = ((byte)(byte)(paramInt1 >> 12 | 0xE0));
    i = paramInt3 + 1;
    J = i;
    paramArrayOfChar[paramInt3] = ((byte)(byte)(paramInt1 >> 6 & 0x3F | 0x80));
    J = (i + 1);
    paramArrayOfChar[i] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
    return paramInt2;
  }
  
  public final void a()
  {
    if (z.c())
    {
      if (J >= K) {
        d();
      }
      localObject = I;
      int i = J;
      J = (i + 1);
      localObject[i] = ((byte)125);
      z = z.c;
      return;
    }
    Object localObject = e.a.a.a.a.a("Current context not Object but ");
    ((StringBuilder)localObject).append(z.e());
    throw new e.b.a.a.e(((StringBuilder)localObject).toString(), this);
  }
  
  public void a(double paramDouble)
  {
    if ((!y) && (((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) || (!f.a.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(x))))
    {
      d("write a number");
      String str = String.valueOf(paramDouble);
      int i = str.length();
      char[] arrayOfChar = M;
      if (i <= arrayOfChar.length)
      {
        str.getChars(0, i, arrayOfChar, 0);
        a(arrayOfChar, 0, i);
      }
      else
      {
        int j = arrayOfChar.length;
        if (i <= j)
        {
          str.getChars(0, i + 0, arrayOfChar, 0);
          a(arrayOfChar, 0, i);
        }
        else
        {
          int k = K;
          int m = Math.min(j, (k >> 2) + (k >> 4));
          j = 0;
          while (i > 0)
          {
            k = Math.min(m, i);
            str.getChars(j, j + k, arrayOfChar, 0);
            if (J + m * 3 > K) {
              d();
            }
            int n = k;
            int i1;
            int i2;
            if (k > 1)
            {
              i1 = k - 1;
              i2 = arrayOfChar[i1];
              n = k;
              if (i2 >= 55296)
              {
                n = k;
                if (i2 <= 56319) {
                  n = i1;
                }
              }
            }
            k = 0;
            if (k < n) {
              do
              {
                i1 = arrayOfChar[k];
                if (i1 > 127)
                {
                  i1 = k + 1;
                  int i3 = arrayOfChar[k];
                  if (i3 < 2048)
                  {
                    arrayOfByte = I;
                    k = J;
                    i2 = k + 1;
                    J = i2;
                    arrayOfByte[k] = ((byte)(byte)(i3 >> 6 | 0xC0));
                    J = (i2 + 1);
                    arrayOfByte[i2] = ((byte)(byte)(i3 & 0x3F | 0x80));
                    k = i1;
                    break;
                  }
                  k = a(i3, arrayOfChar, i1, n);
                  break;
                }
                byte[] arrayOfByte = I;
                i2 = J;
                J = (i2 + 1);
                arrayOfByte[i2] = ((byte)(byte)i1);
                i1 = k + 1;
                k = i1;
              } while (i1 < n);
            }
            j += n;
            i -= n;
          }
        }
      }
      return;
    }
    b(String.valueOf(paramDouble));
  }
  
  public void a(int paramInt)
  {
    d("write a number");
    if (J + 11 >= K) {
      d();
    }
    if (y)
    {
      if (J + 13 >= K) {
        d();
      }
      byte[] arrayOfByte = I;
      int i = J;
      int j = i + 1;
      J = j;
      arrayOfByte[i] = ((byte)H);
      paramInt = f.c(paramInt, arrayOfByte, j);
      J = paramInt;
      arrayOfByte = I;
      J = (paramInt + 1);
      arrayOfByte[paramInt] = ((byte)H);
      return;
    }
    J = f.c(paramInt, I, J);
  }
  
  public void a(e.b.a.a.a parama, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d("write a binary value");
    if (J >= K) {
      d();
    }
    byte[] arrayOfByte1 = I;
    int i = J;
    J = (i + 1);
    arrayOfByte1[i] = ((byte)H);
    int j = paramInt2 + paramInt1;
    int k = K - 6;
    paramInt2 = D >> 2;
    i = paramInt1;
    paramInt1 = paramInt2;
    int m;
    while (i <= j - 3)
    {
      if (J > k) {
        d();
      }
      paramInt2 = i + 1;
      m = paramArrayOfByte[i];
      i = paramInt2 + 1;
      paramInt2 = (m << 8 | paramArrayOfByte[paramInt2] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF;
      byte[] arrayOfByte2 = I;
      m = J;
      int n = m + 1;
      arrayOfByte1 = z;
      arrayOfByte2[m] = ((byte)arrayOfByte1[(paramInt2 >> 18 & 0x3F)]);
      m = n + 1;
      arrayOfByte2[n] = ((byte)arrayOfByte1[(paramInt2 >> 12 & 0x3F)]);
      n = m + 1;
      arrayOfByte2[m] = ((byte)arrayOfByte1[(paramInt2 >> 6 & 0x3F)]);
      m = n + 1;
      arrayOfByte2[n] = ((byte)arrayOfByte1[(paramInt2 & 0x3F)]);
      J = m;
      paramInt2 = paramInt1 - 1;
      paramInt1 = paramInt2;
      if (paramInt2 <= 0)
      {
        paramInt1 = m + 1;
        J = paramInt1;
        arrayOfByte2[m] = ((byte)92);
        J = (paramInt1 + 1);
        arrayOfByte2[paramInt1] = ((byte)110);
        paramInt1 = D >> 2;
      }
      i++;
    }
    j -= i;
    if (j > 0)
    {
      if (J > k) {
        d();
      }
      paramInt1 = paramArrayOfByte[i] << 16;
      paramInt2 = paramInt1;
      if (j == 2) {
        paramInt2 = paramInt1 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      }
      arrayOfByte1 = I;
      i = J;
      paramInt1 = i + 1;
      paramArrayOfByte = z;
      arrayOfByte1[i] = ((byte)paramArrayOfByte[(paramInt2 >> 18 & 0x3F)]);
      i = paramInt1 + 1;
      arrayOfByte1[paramInt1] = ((byte)paramArrayOfByte[(paramInt2 >> 12 & 0x3F)]);
      if (B)
      {
        k = (byte)C;
        m = i + 1;
        if (j == 2) {
          paramInt1 = paramArrayOfByte[(paramInt2 >> 6 & 0x3F)];
        } else {
          paramInt1 = k;
        }
        arrayOfByte1[i] = ((byte)paramInt1);
        paramInt1 = m + 1;
        arrayOfByte1[m] = ((byte)k);
      }
      else
      {
        paramInt1 = i;
        if (j == 2)
        {
          arrayOfByte1[i] = ((byte)paramArrayOfByte[(paramInt2 >> 6 & 0x3F)]);
          paramInt1 = i + 1;
        }
      }
      J = paramInt1;
    }
    if (J >= K) {
      d();
    }
    parama = I;
    paramInt1 = J;
    J = (paramInt1 + 1);
    parama[paramInt1] = ((byte)H);
  }
  
  public void a(String paramString)
  {
    int i = z.a(paramString);
    if (i != 4)
    {
      if (i == 1)
      {
        if (J >= K) {
          d();
        }
        arrayOfByte = I;
        i = J;
        J = (i + 1);
        arrayOfByte[i] = ((byte)44);
      }
      boolean bool = E;
      int j = 0;
      if (bool)
      {
        a(paramString, false);
        return;
      }
      int k = paramString.length();
      if (k > N)
      {
        a(paramString, true);
        return;
      }
      if (J >= K) {
        d();
      }
      byte[] arrayOfByte = I;
      i = J;
      int m = i + 1;
      J = m;
      arrayOfByte[i] = ((byte)H);
      i = k;
      if (k <= L)
      {
        if (m + k > K) {
          d();
        }
        a(paramString, 0, k);
      }
      else
      {
        do
        {
          k = Math.min(L, i);
          if (J + k > K) {
            d();
          }
          a(paramString, j, k);
          j += k;
          k = i - k;
          i = k;
        } while (k > 0);
      }
      if (J >= K) {
        d();
      }
      paramString = I;
      i = J;
      J = (i + 1);
      paramString[i] = ((byte)H);
      return;
    }
    throw new e.b.a.a.e("Can not write a field name, expecting a value", this);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2 + paramInt1;
    paramInt2 = J;
    Object localObject1 = I;
    Object localObject2 = B;
    int j;
    while (paramInt1 < i)
    {
      j = paramString.charAt(paramInt1);
      if ((j > 127) || (localObject2[j] != 0)) {
        break;
      }
      localObject1[paramInt2] = ((byte)(byte)j);
      paramInt1++;
      paramInt2++;
    }
    J = paramInt2;
    if (paramInt1 < i)
    {
      int k;
      if (C == 0)
      {
        if ((i - paramInt1) * 6 + paramInt2 > K) {
          d();
        }
        j = J;
        localObject2 = I;
        localObject1 = B;
        paramInt2 = paramInt1;
        paramInt1 = j;
        while (paramInt2 < i)
        {
          j = paramInt2 + 1;
          paramInt2 = paramString.charAt(paramInt2);
          if (paramInt2 <= 127)
          {
            if (localObject1[paramInt2] == 0)
            {
              localObject2[paramInt1] = ((byte)(byte)paramInt2);
              paramInt2 = j;
              paramInt1++;
              continue;
            }
            k = localObject1[paramInt2];
            if (k > 0)
            {
              paramInt2 = paramInt1 + 1;
              localObject2[paramInt1] = ((byte)92);
              paramInt1 = paramInt2 + 1;
              localObject2[paramInt2] = ((byte)(byte)k);
            }
            else
            {
              paramInt1 = b(paramInt2, paramInt1);
            }
          }
          else if (paramInt2 <= 2047)
          {
            k = paramInt1 + 1;
            localObject2[paramInt1] = ((byte)(byte)(paramInt2 >> 6 | 0xC0));
            paramInt1 = k + 1;
            localObject2[k] = ((byte)(byte)(paramInt2 & 0x3F | 0x80));
          }
          else
          {
            paramInt1 = a(paramInt2, paramInt1);
          }
          paramInt2 = j;
        }
        J = paramInt1;
      }
      else
      {
        if ((i - paramInt1) * 6 + paramInt2 > K) {
          d();
        }
        j = J;
        localObject1 = I;
        localObject2 = B;
        k = C;
        paramInt2 = paramInt1;
        paramInt1 = j;
        while (paramInt2 < i)
        {
          j = paramInt2 + 1;
          paramInt2 = paramString.charAt(paramInt2);
          int m;
          if (paramInt2 <= 127)
          {
            if (localObject2[paramInt2] == 0)
            {
              localObject1[paramInt1] = ((byte)(byte)paramInt2);
              paramInt2 = j;
              paramInt1++;
              continue;
            }
            m = localObject2[paramInt2];
            if (m > 0)
            {
              paramInt2 = paramInt1 + 1;
              localObject1[paramInt1] = ((byte)92);
              paramInt1 = paramInt2 + 1;
              localObject1[paramInt2] = ((byte)(byte)m);
              break label511;
            }
            paramInt1 = b(paramInt2, paramInt1);
          }
          else
          {
            if (paramInt2 <= k) {
              break label452;
            }
          }
          for (paramInt1 = b(paramInt2, paramInt1);; paramInt1 = a(paramInt2, paramInt1))
          {
            break;
            label452:
            if (paramInt2 <= 2047)
            {
              m = paramInt1 + 1;
              localObject1[paramInt1] = ((byte)(byte)(paramInt2 >> 6 | 0xC0));
              paramInt1 = m + 1;
              localObject1[m] = ((byte)(byte)(paramInt2 & 0x3F | 0x80));
              break;
            }
          }
          label511:
          paramInt2 = j;
        }
        J = paramInt1;
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (J >= K) {
        d();
      }
      byte[] arrayOfByte = I;
      i = J;
      J = (i + 1);
      arrayOfByte[i] = ((byte)H);
    }
    int i = paramString.length();
    int j = 0;
    while (i > 0)
    {
      int k = Math.min(L, i);
      if (J + k > K) {
        d();
      }
      a(paramString, j, k);
      j += k;
      i -= k;
    }
    if (paramBoolean)
    {
      if (J >= K) {
        d();
      }
      paramString = I;
      i = J;
      J = (i + 1);
      paramString[i] = ((byte)H);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    d("write a boolean value");
    if (J + 5 >= K) {
      d();
    }
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = R;
    } else {
      arrayOfByte = S;
    }
    int i = arrayOfByte.length;
    System.arraycopy(arrayOfByte, 0, I, J, i);
    J += i;
  }
  
  public final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramInt2 + paramInt2 + paramInt2;
    int j = J;
    int k = K;
    byte[] arrayOfByte;
    if (j + i > k)
    {
      if (k < i)
      {
        arrayOfByte = I;
        j = paramInt2 + paramInt1;
        if (paramInt1 < j) {
          do
          {
            i = paramArrayOfChar[paramInt1];
            if (i >= 128)
            {
              if (J + 3 >= K) {
                d();
              }
              paramInt2 = paramInt1 + 1;
              i = paramArrayOfChar[paramInt1];
              if (i < 2048)
              {
                paramInt1 = J;
                int m = paramInt1 + 1;
                J = m;
                arrayOfByte[paramInt1] = ((byte)(byte)(i >> 6 | 0xC0));
                J = (m + 1);
                arrayOfByte[m] = ((byte)(byte)(i & 0x3F | 0x80));
                paramInt1 = paramInt2;
                break;
              }
              paramInt1 = a(i, paramArrayOfChar, paramInt2, j);
              break;
            }
            if (J >= k) {
              d();
            }
            paramInt2 = J;
            J = (paramInt2 + 1);
            arrayOfByte[paramInt2] = ((byte)(byte)i);
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt2;
          } while (paramInt2 < j);
        }
        return;
      }
      d();
    }
    k = paramInt2 + paramInt1;
    if (paramInt1 < k) {
      do
      {
        j = paramArrayOfChar[paramInt1];
        if (j > 127)
        {
          paramInt2 = paramInt1 + 1;
          i = paramArrayOfChar[paramInt1];
          if (i < 2048)
          {
            arrayOfByte = I;
            paramInt1 = J;
            j = paramInt1 + 1;
            J = j;
            arrayOfByte[paramInt1] = ((byte)(byte)(i >> 6 | 0xC0));
            J = (j + 1);
            arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
            paramInt1 = paramInt2;
            break;
          }
          paramInt1 = a(i, paramArrayOfChar, paramInt2, k);
          break;
        }
        arrayOfByte = I;
        paramInt2 = J;
        J = (paramInt2 + 1);
        arrayOfByte[paramInt2] = ((byte)(byte)j);
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
      } while (paramInt2 < k);
    }
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = I;
    int i = paramInt2 + 1;
    arrayOfByte1[paramInt2] = ((byte)92);
    paramInt2 = i + 1;
    arrayOfByte1[i] = ((byte)117);
    if (paramInt1 > 255)
    {
      int j = 0xFF & paramInt1 >> 8;
      i = paramInt2 + 1;
      arrayOfByte2 = P;
      arrayOfByte1[paramInt2] = ((byte)arrayOfByte2[(j >> 4)]);
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)arrayOfByte2[(j & 0xF)]);
      paramInt1 &= 0xFF;
    }
    else
    {
      i = paramInt2 + 1;
      arrayOfByte1[paramInt2] = ((byte)48);
      paramInt2 = i + 1;
      arrayOfByte1[i] = ((byte)48);
    }
    i = paramInt2 + 1;
    byte[] arrayOfByte2 = P;
    arrayOfByte1[paramInt2] = ((byte)arrayOfByte2[(paramInt1 >> 4)]);
    arrayOfByte1[i] = ((byte)arrayOfByte2[(paramInt1 & 0xF)]);
    return i + 1;
  }
  
  public void b()
  {
    d("write a null");
    e();
  }
  
  public void b(String paramString)
  {
    d("write a string");
    if (paramString == null)
    {
      e();
      return;
    }
    int i = paramString.length();
    if (i > L)
    {
      a(paramString, true);
      return;
    }
    if (J + i >= K) {
      d();
    }
    byte[] arrayOfByte = I;
    int j = J;
    J = (j + 1);
    arrayOfByte[j] = ((byte)H);
    a(paramString, 0, i);
    if (J >= K) {
      d();
    }
    paramString = I;
    j = J;
    J = (j + 1);
    paramString[j] = ((byte)H);
  }
  
  public final void c()
  {
    d("start an object");
    z = z.f();
    if (J >= K) {
      d();
    }
    byte[] arrayOfByte = I;
    int i = J;
    J = (i + 1);
    arrayOfByte[i] = ((byte)123);
  }
  
  public void close()
  {
    if ((I != null) && (a(f.a.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        localObject = z;
        if (((k)localObject).b())
        {
          if (z.b())
          {
            if (J >= K) {
              d();
            }
            localObject = I;
            int i = J;
            J = (i + 1);
            localObject[i] = ((byte)93);
            z = z.c;
          }
          else
          {
            localObject = e.a.a.a.a.a("Current context not Array but ");
            ((StringBuilder)localObject).append(z.e());
            throw new e.b.a.a.e(((StringBuilder)localObject).toString(), this);
          }
        }
        else
        {
          if (!((k)localObject).c()) {
            break;
          }
          a();
        }
      }
    }
    d();
    J = 0;
    if (G != null) {
      if ((!A.c) && (!a(f.a.AUTO_CLOSE_TARGET)))
      {
        if (a(f.a.FLUSH_PASSED_TO_STREAM)) {
          G.flush();
        }
      }
      else {
        G.close();
      }
    }
    Object localObject = I;
    if ((localObject != null) && (O))
    {
      I = null;
      A.b((byte[])localObject);
    }
    localObject = M;
    if (localObject != null)
    {
      M = null;
      b localb = A;
      if (localb != null)
      {
        localb.a((char[])localObject, h);
        h = null;
        d.b[1] = localObject;
      }
      else
      {
        throw null;
      }
    }
  }
  
  public final void d()
  {
    int i = J;
    if (i > 0)
    {
      J = 0;
      G.write(I, 0, i);
    }
  }
  
  public final void d(String paramString)
  {
    int i = z.g();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5) {
            return;
          }
          c(paramString);
          throw null;
        }
        paramString = D;
        if (paramString != null)
        {
          paramString = ((e.b.a.a.p.g)paramString).a();
          if (paramString.length > 0)
          {
            i = paramString.length;
            if (J + i > K)
            {
              d();
              if (i > 512)
              {
                G.write(paramString, 0, i);
                break label122;
              }
            }
            System.arraycopy(paramString, 0, I, J, i);
            J += i;
          }
        }
        label122:
        return;
      }
      i = 58;
    }
    else
    {
      i = 44;
    }
    if (J >= K) {
      d();
    }
    paramString = I;
    int j = J;
    J = (j + 1);
    paramString[j] = ((byte)i);
  }
  
  public final void e()
  {
    if (J + 4 >= K) {
      d();
    }
    System.arraycopy(Q, 0, I, J, 4);
    J += 4;
  }
  
  public void flush()
  {
    d();
    if ((G != null) && (a(f.a.FLUSH_PASSED_TO_STREAM))) {
      G.flush();
    }
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */