package e.b.a.a.q;

import e.b.a.a.f.a;
import e.b.a.a.k;
import e.b.a.a.n;
import e.b.a.a.p.b;
import e.b.a.a.p.f;
import e.b.a.a.p.g;
import java.io.Writer;

public class i
  extends c
{
  public static final char[] P = (char[])e.b.a.a.p.a.a.clone();
  public final Writer G;
  public char H = (char)34;
  public char[] I;
  public int J;
  public int K;
  public int L;
  public char[] M;
  public n N;
  public char[] O;
  
  public i(b paramb, int paramInt, Writer paramWriter)
  {
    super(paramb, paramInt);
    G = paramWriter;
    paramb.a(h);
    paramWriter = d.a(1, 0);
    h = paramWriter;
    I = paramWriter;
    L = paramWriter.length;
  }
  
  public final int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
  {
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 2;
        paramArrayOfChar[paramInt1] = ((char)92);
        paramArrayOfChar[(paramInt1 + 1)] = ((char)(char)paramInt3);
      }
      else
      {
        localObject = M;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = d();
        }
        paramArrayOfChar[1] = ((char)(char)paramInt3);
        G.write(paramArrayOfChar, 0, 2);
      }
      return paramInt1;
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 6;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = ((char)92);
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = ((char)117);
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramInt3 = paramInt1 + 1;
          localObject = P;
          paramArrayOfChar[paramInt1] = ((char)localObject[(paramInt2 >> 4)]);
          paramInt1 = paramInt3 + 1;
          paramArrayOfChar[paramInt3] = ((char)localObject[(paramInt2 & 0xF)]);
          paramChar = (char)(paramChar & 0xFF);
        }
        else
        {
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = ((char)48);
          paramInt1 = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = ((char)48);
        }
        paramInt2 = paramInt1 + 1;
        localObject = P;
        paramArrayOfChar[paramInt1] = ((char)localObject[(paramChar >> '\004')]);
        paramArrayOfChar[paramInt2] = ((char)localObject[(paramChar & 0xF)]);
        paramInt1 = paramInt2 - 5;
      }
      else
      {
        localObject = M;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = d();
        }
        J = K;
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramChar &= 0xFF;
          localObject = P;
          paramArrayOfChar[10] = ((char)localObject[(paramInt2 >> 4)]);
          paramArrayOfChar[11] = ((char)localObject[(paramInt2 & 0xF)]);
          paramArrayOfChar[12] = ((char)localObject[(paramChar >> '\004')]);
          paramArrayOfChar[13] = ((char)localObject[(paramChar & 0xF)]);
          G.write(paramArrayOfChar, 8, 6);
        }
        else
        {
          localObject = P;
          paramArrayOfChar[6] = ((char)localObject[(paramChar >> '\004')]);
          paramArrayOfChar[7] = ((char)localObject[(paramChar & 0xF)]);
          G.write(paramArrayOfChar, 2, 6);
        }
      }
      return paramInt1;
    }
    Object localObject = N;
    if (localObject != null)
    {
      localObject = x;
      N = null;
      paramChar = ((String)localObject).length();
      if ((paramInt1 >= paramChar) && (paramInt1 < paramInt2))
      {
        paramInt1 -= paramChar;
        ((String)localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
      }
      else
      {
        G.write((String)localObject);
      }
      return paramInt1;
    }
    throw null;
  }
  
  public void a()
  {
    if (z.c())
    {
      if (K >= L) {
        e();
      }
      localObject = I;
      int i = K;
      K = (i + 1);
      localObject[i] = ((char)125);
      z = z.c;
      return;
    }
    Object localObject = e.a.a.a.a.a("Current context not Object but ");
    ((StringBuilder)localObject).append(z.e());
    throw new e.b.a.a.e(((StringBuilder)localObject).toString(), this);
  }
  
  public final void a(char paramChar, int paramInt)
  {
    char[] arrayOfChar;
    if (paramInt >= 0)
    {
      paramChar = K;
      if (paramChar >= '\002')
      {
        paramChar -= 2;
        J = paramChar;
        localObject = I;
        localObject[paramChar] = ((char)92);
        localObject[(paramChar + '\001')] = ((char)(char)paramInt);
        return;
      }
      arrayOfChar = M;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = d();
      }
      J = K;
      localObject[1] = ((char)(char)paramInt);
      G.write((char[])localObject, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      paramInt = K;
      if (paramInt >= 6)
      {
        localObject = I;
        paramInt -= 6;
        J = paramInt;
        localObject[paramInt] = ((char)92);
        paramInt++;
        localObject[paramInt] = ((char)117);
        if (paramChar > 'ÿ')
        {
          int i = paramChar >> '\b' & 0xFF;
          paramInt++;
          arrayOfChar = P;
          localObject[paramInt] = ((char)arrayOfChar[(i >> 4)]);
          paramInt++;
          localObject[paramInt] = ((char)arrayOfChar[(i & 0xF)]);
          paramChar = (char)(paramChar & 0xFF);
        }
        else
        {
          paramInt++;
          localObject[paramInt] = ((char)48);
          paramInt++;
          localObject[paramInt] = ((char)48);
        }
        paramInt++;
        arrayOfChar = P;
        localObject[paramInt] = ((char)arrayOfChar[(paramChar >> '\004')]);
        localObject[(paramInt + 1)] = ((char)arrayOfChar[(paramChar & 0xF)]);
        return;
      }
      arrayOfChar = M;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = d();
      }
      J = K;
      if (paramChar > 'ÿ')
      {
        paramInt = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        arrayOfChar = P;
        localObject[10] = ((char)arrayOfChar[(paramInt >> 4)]);
        localObject[11] = ((char)arrayOfChar[(paramInt & 0xF)]);
        localObject[12] = ((char)arrayOfChar[(paramChar >> '\004')]);
        localObject[13] = ((char)arrayOfChar[(paramChar & 0xF)]);
        G.write((char[])localObject, 8, 6);
      }
      else
      {
        arrayOfChar = P;
        localObject[6] = ((char)arrayOfChar[(paramChar >> '\004')]);
        localObject[7] = ((char)arrayOfChar[(paramChar & 0xF)]);
        G.write((char[])localObject, 2, 6);
      }
      return;
    }
    Object localObject = N;
    if (localObject != null)
    {
      localObject = x;
      N = null;
      paramChar = ((String)localObject).length();
      paramInt = K;
      if (paramInt >= paramChar)
      {
        paramInt -= paramChar;
        J = paramInt;
        ((String)localObject).getChars(0, paramChar, I, paramInt);
        return;
      }
      J = paramInt;
      G.write((String)localObject);
      return;
    }
    throw null;
  }
  
  public void a(double paramDouble)
  {
    if ((!y) && ((!a(f.a.QUOTE_NON_NUMERIC_NUMBERS)) || ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble)))))
    {
      d("write a number");
      f(String.valueOf(paramDouble));
      return;
    }
    b(String.valueOf(paramDouble));
  }
  
  public void a(int paramInt)
  {
    d("write a number");
    if (y)
    {
      if (K + 13 >= L) {
        e();
      }
      char[] arrayOfChar = I;
      int i = K;
      int j = i + 1;
      K = j;
      arrayOfChar[i] = ((char)H);
      paramInt = f.c(paramInt, arrayOfChar, j);
      K = paramInt;
      arrayOfChar = I;
      K = (paramInt + 1);
      arrayOfChar[paramInt] = ((char)H);
      return;
    }
    if (K + 11 >= L) {
      e();
    }
    K = f.c(paramInt, I, K);
  }
  
  public void a(e.b.a.a.a parama, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d("write a binary value");
    if (K >= L) {
      e();
    }
    char[] arrayOfChar1 = I;
    int i = K;
    K = (i + 1);
    arrayOfChar1[i] = ((char)H);
    int j = paramInt2 + paramInt1;
    int k = L - 6;
    i = D >> 2;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 <= j - 3)
    {
      if (K > k) {
        e();
      }
      int m = paramInt2 + 1;
      paramInt2 = paramArrayOfByte[paramInt2];
      i = m + 1;
      paramInt2 = (paramInt2 << 8 | paramArrayOfByte[m] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF;
      arrayOfChar1 = I;
      m = K;
      int n = m + 1;
      char[] arrayOfChar2 = y;
      arrayOfChar1[m] = ((char)arrayOfChar2[(paramInt2 >> 18 & 0x3F)]);
      m = n + 1;
      arrayOfChar1[n] = ((char)arrayOfChar2[(paramInt2 >> 12 & 0x3F)]);
      n = m + 1;
      arrayOfChar1[m] = ((char)arrayOfChar2[(paramInt2 >> 6 & 0x3F)]);
      m = n + 1;
      arrayOfChar1[n] = ((char)arrayOfChar2[(paramInt2 & 0x3F)]);
      K = m;
      paramInt2 = paramInt1 - 1;
      paramInt1 = paramInt2;
      if (paramInt2 <= 0)
      {
        paramInt1 = m + 1;
        K = paramInt1;
        arrayOfChar1[m] = ((char)92);
        K = (paramInt1 + 1);
        arrayOfChar1[paramInt1] = ((char)110);
        paramInt1 = D >> 2;
      }
      paramInt2 = i + 1;
    }
    j -= paramInt2;
    if (j > 0)
    {
      if (K > k) {
        e();
      }
      paramInt1 = paramArrayOfByte[paramInt2] << 16;
      i = paramInt1;
      if (j == 2) {
        i = paramInt1 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8;
      }
      paramArrayOfByte = I;
      paramInt2 = K;
      paramInt1 = paramInt2 + 1;
      arrayOfChar1 = y;
      paramArrayOfByte[paramInt2] = ((char)arrayOfChar1[(i >> 18 & 0x3F)]);
      paramInt2 = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((char)arrayOfChar1[(i >> 12 & 0x3F)]);
      if (B)
      {
        k = paramInt2 + 1;
        if (j == 2) {
          paramInt1 = arrayOfChar1[(i >> 6 & 0x3F)];
        } else {
          paramInt1 = C;
        }
        paramArrayOfByte[paramInt2] = ((char)paramInt1);
        paramInt1 = k + 1;
        paramArrayOfByte[k] = ((char)C);
      }
      else
      {
        paramInt1 = paramInt2;
        if (j == 2)
        {
          paramArrayOfByte[paramInt2] = ((char)arrayOfChar1[(i >> 6 & 0x3F)]);
          paramInt1 = paramInt2 + 1;
        }
      }
      K = paramInt1;
    }
    if (K >= L) {
      e();
    }
    parama = I;
    paramInt1 = K;
    K = (paramInt1 + 1);
    parama[paramInt1] = ((char)H);
  }
  
  public void a(String paramString)
  {
    int i = z.a(paramString);
    if (i != 4)
    {
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (K + 1 >= L) {
        e();
      }
      char[] arrayOfChar;
      if (i != 0)
      {
        arrayOfChar = I;
        i = K;
        K = (i + 1);
        arrayOfChar[i] = ((char)44);
      }
      if (E)
      {
        e(paramString);
      }
      else
      {
        arrayOfChar = I;
        i = K;
        K = (i + 1);
        arrayOfChar[i] = ((char)H);
        e(paramString);
        if (K >= L) {
          e();
        }
        paramString = I;
        i = K;
        K = (i + 1);
        paramString[i] = ((char)H);
      }
      return;
    }
    throw new e.b.a.a.e("Can not write a field name, expecting a value", this);
  }
  
  public void a(boolean paramBoolean)
  {
    d("write a boolean value");
    if (K + 5 >= L) {
      e();
    }
    int i = K;
    char[] arrayOfChar = I;
    if (paramBoolean)
    {
      arrayOfChar[i] = ((char)116);
      i++;
      arrayOfChar[i] = ((char)114);
      i++;
      arrayOfChar[i] = ((char)117);
      i++;
      arrayOfChar[i] = ((char)101);
    }
    else
    {
      arrayOfChar[i] = ((char)102);
      i++;
      arrayOfChar[i] = ((char)97);
      i++;
      arrayOfChar[i] = ((char)108);
      i++;
      arrayOfChar[i] = ((char)115);
      i++;
      arrayOfChar[i] = ((char)101);
    }
    K = (i + 1);
  }
  
  public void b()
  {
    d("write a null");
    f();
  }
  
  public void b(String paramString)
  {
    d("write a string");
    if (paramString == null)
    {
      f();
      return;
    }
    if (K >= L) {
      e();
    }
    char[] arrayOfChar = I;
    int i = K;
    K = (i + 1);
    arrayOfChar[i] = ((char)H);
    e(paramString);
    if (K >= L) {
      e();
    }
    paramString = I;
    i = K;
    K = (i + 1);
    paramString[i] = ((char)H);
  }
  
  public void c()
  {
    d("start an object");
    z = z.f();
    if (K >= L) {
      e();
    }
    char[] arrayOfChar = I;
    int i = K;
    K = (i + 1);
    arrayOfChar[i] = ((char)123);
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
            if (K >= L) {
              e();
            }
            localObject = I;
            int i = K;
            K = (i + 1);
            localObject[i] = ((char)93);
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
    e();
    J = 0;
    K = 0;
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
    b localb;
    if (localObject != null)
    {
      I = null;
      localb = A;
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
    localObject = O;
    if (localObject != null)
    {
      O = null;
      localb = A;
      if (localb != null)
      {
        localb.a((char[])localObject, i);
        i = null;
        d.b[3] = localObject;
      }
      else
      {
        throw null;
      }
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
        if (paramString != null) {
          f(x);
        }
        return;
      }
      i = 58;
    }
    else
    {
      i = 44;
    }
    if (K >= L) {
      e();
    }
    paramString = I;
    int j = K;
    K = (j + 1);
    paramString[j] = ((char)i);
  }
  
  public final char[] d()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = ((char)92);
    arrayOfChar[2] = ((char)92);
    arrayOfChar[3] = ((char)117);
    arrayOfChar[4] = ((char)48);
    arrayOfChar[5] = ((char)48);
    arrayOfChar[8] = ((char)92);
    arrayOfChar[9] = ((char)117);
    M = arrayOfChar;
    return arrayOfChar;
  }
  
  public void e()
  {
    int i = K;
    int j = J;
    i -= j;
    if (i > 0)
    {
      J = 0;
      K = 0;
      G.write(I, j, i);
    }
  }
  
  public final void e(String paramString)
  {
    int i = paramString.length();
    int j = L;
    int m;
    Object localObject;
    int i3;
    int i4;
    int i8;
    if (i > j)
    {
      e();
      int k = paramString.length();
      int n;
      for (i = 0;; i = n)
      {
        j = L;
        m = j;
        if (i + j > k) {
          m = k - i;
        }
        n = i + m;
        paramString.getChars(i, n, I, 0);
        int i1 = C;
        if (i1 != 0)
        {
          localObject = B;
          int i2 = Math.min(localObject.length, i1 + 1);
          i = 0;
          j = 0;
          i3 = 0;
          while (i < m)
          {
            i4 = j;
            int i5;
            do
            {
              i5 = I[i];
              if (i5 < i2)
              {
                i4 = localObject[i5];
                j = i4;
                if (i4 != 0)
                {
                  j = i;
                  i = i4;
                  break;
                }
              }
              else
              {
                j = i4;
                if (i5 > i1)
                {
                  i4 = -1;
                  j = i;
                  i = i4;
                  break;
                }
              }
              i8 = i + 1;
              i = i8;
              i4 = j;
            } while (i8 < m);
            i = j;
            j = i8;
            i4 = j - i3;
            if (i4 > 0)
            {
              G.write(I, i3, i4);
              if (j >= m) {
                break;
              }
            }
            i4 = j + 1;
            i3 = a(I, i4, m, i5, i);
            j = i;
            i = i4;
          }
        }
        localObject = B;
        i4 = localObject.length;
        i = 0;
        int i6;
        for (j = 0; i < m; j = a(I, i, m, i6, localObject[i6]))
        {
          do
          {
            i6 = I[i];
            if ((i6 < i4) && (localObject[i6] != 0)) {
              break;
            }
            i3 = i + 1;
            i = i3;
          } while (i3 < m);
          i = i3;
          i3 = i - j;
          if (i3 > 0)
          {
            G.write(I, j, i3);
            if (i >= m) {
              break;
            }
          }
          i++;
        }
        if (n >= k) {
          return;
        }
      }
    }
    if (K + i > j) {
      e();
    }
    paramString.getChars(0, i, I, K);
    j = C;
    if (j != 0)
    {
      i3 = K + i;
      paramString = B;
      m = Math.min(paramString.length, j + 1);
      if (K < i3) {
        label562:
        do
        {
          int i7 = I[K];
          if (i7 < m)
          {
            i = paramString[i7];
            if (i == 0) {
              break label562;
            }
          }
          else
          {
            if (i7 <= j) {
              break label562;
            }
            i = -1;
          }
          i8 = K;
          i4 = J;
          i8 -= i4;
          if (i8 > 0) {
            G.write(I, i4, i8);
          }
          K += 1;
          a(i7, i);
          break;
          i = K + 1;
          K = i;
        } while (i < i3);
      }
    }
    else
    {
      i = K + i;
      paramString = B;
      j = paramString.length;
      if (K < i) {
        do
        {
          localObject = I;
          i3 = K;
          m = localObject[i3];
          if ((m < j) && (paramString[m] != 0))
          {
            m = J;
            i3 -= m;
            if (i3 > 0) {
              G.write((char[])localObject, m, i3);
            }
            localObject = I;
            m = K;
            K = (m + 1);
            char c = localObject[m];
            a(c, paramString[c]);
            break;
          }
          m = K + 1;
          K = m;
        } while (m < i);
      }
    }
  }
  
  public final void f()
  {
    if (K + 4 >= L) {
      e();
    }
    int i = K;
    char[] arrayOfChar = I;
    arrayOfChar[i] = ((char)110);
    i++;
    arrayOfChar[i] = ((char)117);
    i++;
    arrayOfChar[i] = ((char)108);
    i++;
    arrayOfChar[i] = ((char)108);
    K = (i + 1);
  }
  
  public void f(String paramString)
  {
    int i = paramString.length();
    int j = L - K;
    int k = j;
    if (j == 0)
    {
      e();
      k = L - K;
    }
    if (k >= i)
    {
      paramString.getChars(0, i, I, K);
      K += i;
    }
    else
    {
      j = L;
      k = K;
      j -= k;
      paramString.getChars(0, j, I, k);
      K += j;
      e();
      k = paramString.length() - j;
      for (;;)
      {
        int m = L;
        if (k <= m) {
          break;
        }
        i = j + m;
        paramString.getChars(j, i, I, 0);
        J = 0;
        K = m;
        e();
        k -= m;
        j = i;
      }
      paramString.getChars(j, j + k, I, 0);
      J = 0;
      K = k;
    }
  }
  
  public void flush()
  {
    e();
    if ((G != null) && (a(f.a.FLUSH_PASSED_TO_STREAM))) {
      G.flush();
    }
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.q.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */