package e.c.c.y;

import e.c.c.w.p;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  public static final char[] M = ")]}'\n".toCharArray();
  public int A = 0;
  public int B = 0;
  public int C = 0;
  public int D = 0;
  public int E = 0;
  public long F;
  public int G;
  public String H;
  public int[] I;
  public int J;
  public String[] K;
  public int[] L;
  public final Reader x;
  public boolean y = false;
  public final char[] z = new char['Ѐ'];
  
  static
  {
    p.a = new a();
  }
  
  public a(Reader paramReader)
  {
    int[] arrayOfInt = new int[32];
    I = arrayOfInt;
    J = 0;
    J = (0 + 1);
    arrayOfInt[0] = 6;
    K = new String[32];
    L = new int[32];
    if (paramReader != null)
    {
      x = paramReader;
      return;
    }
    throw new NullPointerException("in == null");
  }
  
  public final int a(boolean paramBoolean)
  {
    char[] arrayOfChar = z;
    int i = A;
    int j = B;
    for (;;)
    {
      int k = 1;
      int m = i;
      int n = j;
      Object localObject;
      if (i == j)
      {
        A = i;
        if (!a(1))
        {
          if (!paramBoolean) {
            return -1;
          }
          localObject = e.a.a.a.a.a("End of input");
          ((StringBuilder)localObject).append(i());
          throw new EOFException(((StringBuilder)localObject).toString());
        }
        m = A;
        n = B;
      }
      i = m + 1;
      j = arrayOfChar[m];
      if (j == 10)
      {
        C += 1;
        D = i;
      }
      else if ((j != 32) && (j != 13) && (j != 9))
      {
        if (j == 47)
        {
          A = i;
          if (i == n)
          {
            A = (i - 1);
            boolean bool = a(2);
            A += 1;
            if (!bool) {
              return j;
            }
          }
          c();
          n = A;
          i = arrayOfChar[n];
          if (i != 42)
          {
            if (i != 47) {
              return j;
            }
            A = (n + 1);
            t();
            i = A;
            j = B;
            continue;
          }
          A = (n + 1);
          n = A;
          j = B;
          i = 0;
          if ((n + 2 > j) && (!a(2)))
          {
            j = 0;
          }
          else
          {
            localObject = z;
            j = A;
            if (localObject[j] == '\n')
            {
              C += 1;
              D = (j + 1);
            }
            for (;;)
            {
              j = k;
              if (i >= 2) {
                break label398;
              }
              if (z[(A + i)] != "*/".charAt(i))
              {
                A += 1;
                break;
              }
              i++;
            }
          }
          label398:
          if (j != 0)
          {
            i = A + 2;
            j = B;
            continue;
          }
          a("Unterminated comment");
          throw null;
        }
        if (j == 35)
        {
          A = i;
          c();
          t();
          i = A;
          j = B;
          continue;
        }
        A = i;
        return j;
      }
      j = n;
    }
  }
  
  public final IOException a(String paramString)
  {
    paramString = e.a.a.a.a.a(paramString);
    paramString.append(i());
    throw new d(paramString.toString());
  }
  
  public void a()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 3)
    {
      b(1);
      L[(J - 1)] = 0;
      E = 0;
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(r());
    localStringBuilder.append(i());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final boolean a(char paramChar)
  {
    if ((paramChar != '\t') && (paramChar != '\n') && (paramChar != '\f') && (paramChar != '\r') && (paramChar != ' '))
    {
      if (paramChar != '#')
      {
        if (paramChar == ',') {
          break label110;
        }
        if ((paramChar != '/') && (paramChar != '='))
        {
          if ((paramChar == '{') || (paramChar == '}') || (paramChar == ':')) {
            break label110;
          }
          if (paramChar == ';') {}
        }
      }
      switch (paramChar)
      {
      default: 
        return true;
      case '\\': 
        c();
      }
    }
    label110:
    return false;
  }
  
  public final boolean a(int paramInt)
  {
    char[] arrayOfChar = z;
    int i = D;
    int j = A;
    D = (i - j);
    i = B;
    if (i != j)
    {
      i -= j;
      B = i;
      System.arraycopy(arrayOfChar, j, arrayOfChar, 0, i);
    }
    else
    {
      B = 0;
    }
    A = 0;
    do
    {
      Reader localReader = x;
      j = B;
      j = localReader.read(arrayOfChar, j, arrayOfChar.length - j);
      if (j == -1) {
        break;
      }
      i = B + j;
      B = i;
      j = paramInt;
      if (C == 0)
      {
        int k = D;
        j = paramInt;
        if (k == 0)
        {
          j = paramInt;
          if (i > 0)
          {
            j = paramInt;
            if (arrayOfChar[0] == 65279)
            {
              A += 1;
              D = (k + 1);
              j = paramInt + 1;
            }
          }
        }
      }
      paramInt = j;
    } while (B < j);
    return true;
    return false;
  }
  
  public final String b(char paramChar)
  {
    char[] arrayOfChar = z;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      char c1 = A;
      int i = B;
      char c2 = c1;
      char c3;
      for (;;)
      {
        c3 = c2;
        if (c3 >= i) {
          break label210;
        }
        c2 = c3 + '\001';
        c3 = arrayOfChar[c3];
        if (c3 == paramChar)
        {
          A = c2;
          paramChar = c2 - c1 - 1;
          if (localObject1 == null) {
            return new String(arrayOfChar, c1, paramChar);
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c1, paramChar);
          return ((StringBuilder)localObject1).toString();
        }
        if (c3 == '\\')
        {
          A = c2;
          c2 = c2 - c1 - 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max((c2 + '\001') * 2, 16));
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c1, c2);
          ((StringBuilder)localObject2).append(s());
          c1 = A;
          i = B;
          localObject1 = localObject2;
          break;
        }
        if (c3 == '\n')
        {
          C += 1;
          D = c2;
        }
      }
      label210:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c3 - c1) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c1, c3 - c1);
      A = c3;
      if (!a(1)) {
        break;
      }
    }
    a("Unterminated string");
    throw null;
  }
  
  public void b()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 1)
    {
      b(3);
      E = 0;
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(r());
    localStringBuilder.append(i());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final void b(int paramInt)
  {
    int i = J;
    int[] arrayOfInt1 = I;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 2];
      int[] arrayOfInt3 = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      System.arraycopy(L, 0, arrayOfInt3, 0, J);
      System.arraycopy(K, 0, arrayOfString, 0, J);
      I = arrayOfInt2;
      L = arrayOfInt3;
      K = arrayOfString;
    }
    arrayOfInt1 = I;
    i = J;
    J = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  public final void c()
  {
    if (y) {
      return;
    }
    a("Use JsonReader.setLenient(true) to accept malformed JSON");
    throw null;
  }
  
  public final void c(char paramChar)
  {
    char[] arrayOfChar = z;
    do
    {
      char c1 = A;
      char c2 = B;
      while (c1 < c2)
      {
        char c3 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          A = c3;
          return;
        }
        if (c1 == '\\')
        {
          A = c3;
          s();
          c1 = A;
          c2 = B;
        }
        else
        {
          if (c1 == '\n')
          {
            C += 1;
            D = c3;
          }
          c1 = c3;
        }
      }
      A = c1;
    } while (a(1));
    a("Unterminated string");
    throw null;
  }
  
  public void close()
  {
    E = 0;
    I[0] = 8;
    J = 1;
    x.close();
  }
  
  public int d()
  {
    Object localObject = I;
    int i = J;
    int m = localObject[(i - 1)];
    if (m == 1)
    {
      localObject[(i - 1)] = 2;
    }
    else if (m == 2)
    {
      i = a(true);
      if (i != 44)
      {
        if (i != 59)
        {
          if (i == 93)
          {
            E = 4;
            return 4;
          }
          a("Unterminated array");
          throw null;
        }
        c();
      }
    }
    else
    {
      if ((m == 3) || (m == 5)) {
        break label1333;
      }
      if (m == 4)
      {
        localObject[(i - 1)] = 5;
        i = a(true);
        if (i != 58) {
          if (i == 61)
          {
            c();
            if ((A < B) || (a(1)))
            {
              localObject = z;
              i = A;
              if (localObject[i] == '>') {
                A = (i + 1);
              }
            }
          }
          else
          {
            a("Expected ':'");
            throw null;
          }
        }
      }
      else if (m == 6)
      {
        if (y)
        {
          a(true);
          i = A - 1;
          A = i;
          localObject = M;
          if ((i + localObject.length <= B) || (a(localObject.length)))
          {
            for (i = 0;; i++)
            {
              localObject = M;
              if (i >= localObject.length) {
                break;
              }
              if (z[(A + i)] != localObject[i]) {
                break label291;
              }
            }
            A += localObject.length;
          }
        }
        label291:
        I[(J - 1)] = 7;
      }
      else if (m == 7)
      {
        if (a(false) == -1)
        {
          E = 17;
          return 17;
        }
        c();
        A -= 1;
      }
      else
      {
        if (m == 8) {
          break label1323;
        }
      }
    }
    i = a(true);
    if (i != 34)
    {
      if (i != 39)
      {
        if ((i != 44) && (i != 59)) {
          if (i != 91)
          {
            if (i != 93)
            {
              if (i != 123)
              {
                i = A - 1;
                A = i;
                i = z[i];
                String str;
                if ((i != 116) && (i != 84))
                {
                  if ((i != 102) && (i != 70))
                  {
                    if ((i != 110) && (i != 78)) {
                      break label625;
                    }
                    localObject = "null";
                    str = "NULL";
                    i = 7;
                  }
                  else
                  {
                    localObject = "false";
                    str = "FALSE";
                    i = 6;
                  }
                }
                else
                {
                  localObject = "true";
                  str = "TRUE";
                  i = 5;
                }
                int n = ((String)localObject).length();
                for (m = 1; m < n; m++)
                {
                  if ((A + m >= B) && (!a(m + 1))) {
                    break label625;
                  }
                  i2 = z[(A + m)];
                  if ((i2 != ((String)localObject).charAt(m)) && (i2 != str.charAt(m))) {
                    break label625;
                  }
                }
                if (((A + n < B) || (a(n + 1))) && (a(z[(A + n)])))
                {
                  label625:
                  i = 0;
                }
                else
                {
                  A += n;
                  E = i;
                }
                if (i != 0) {
                  return i;
                }
                localObject = z;
                int i3 = A;
                int i2 = B;
                long l1 = 0L;
                long l2 = 0L;
                int i4 = 0;
                int i1 = 0;
                m = 1;
                int i5 = 0;
                for (;;)
                {
                  int i6 = i3;
                  int i7 = i2;
                  if (i3 + i4 == i2) {
                    if (i4 != localObject.length) {}
                  }
                  label947:
                  label961:
                  label978:
                  label987:
                  label1102:
                  label1113:
                  label1143:
                  label1160:
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            char c;
                            do
                            {
                              do
                              {
                                i = 0;
                                break label1186;
                                if (!a(i4 + 1)) {
                                  break label987;
                                }
                                i6 = A;
                                i7 = B;
                                c = localObject[(i6 + i4)];
                                if (c == '+') {
                                  break label1160;
                                }
                                if ((c == 'E') || (c == 'e')) {
                                  break label1143;
                                }
                                if (c == '-') {
                                  break label1113;
                                }
                                if (c == '.') {
                                  break label1102;
                                }
                                if ((c < '0') || (c > '9')) {
                                  break label978;
                                }
                                if ((i1 == 1) || (i1 == 0)) {
                                  break label947;
                                }
                                if (i1 != 2) {
                                  break;
                                }
                              } while (l2 == l1);
                              l1 = 10L * l2 - (c - '0');
                              int j = l2 < -922337203685477580L;
                              if ((j <= 0) && ((j != 0) || (l1 >= l2))) {
                                j = 0;
                              } else {
                                j = 1;
                              }
                              i2 = m & j;
                              j = i1;
                              break label961;
                              if (i1 == 3)
                              {
                                k = 4;
                                l1 = l2;
                                i2 = m;
                              }
                              else if (i1 != 5)
                              {
                                l1 = l2;
                                k = i1;
                                i2 = m;
                                if (i1 != 6) {}
                              }
                              else
                              {
                                k = 7;
                                l1 = l2;
                                i2 = m;
                                break label961;
                                l1 = -(c - '0');
                                k = 2;
                                i2 = m;
                              }
                              l3 = 0L;
                              l2 = l1;
                              m = i2;
                              l1 = l3;
                              break label1169;
                            } while (a(c));
                            if ((i1 == 2) && (m != 0) && ((l2 != Long.MIN_VALUE) || (i5 != 0)) && ((l2 != 0L) || (i5 == 0)))
                            {
                              if (i5 == 0) {
                                l2 = -l2;
                              }
                              F = l2;
                              A += i4;
                              k = 15;
                              E = 15;
                              break label1186;
                            }
                          } while ((i1 != 2) && (i1 != 4) && (i1 != 7));
                          G = i4;
                          k = 16;
                          E = 16;
                          break label1186;
                        } while (i1 != 2);
                        k = 3;
                        break label1169;
                        long l3 = l1;
                        if (i1 == 0)
                        {
                          k = 1;
                          i5 = 1;
                          l1 = l3;
                          break label1169;
                        }
                      } while (i1 != 5);
                      break label1166;
                    } while ((i1 != 2) && (i1 != 4));
                    k = 5;
                    break label1169;
                  } while (i1 != 5);
                  label1166:
                  k = 6;
                  label1169:
                  i4++;
                  i3 = i6;
                  i2 = i7;
                  i1 = k;
                }
                label1186:
                if (k != 0) {
                  return k;
                }
                if (a(z[A]))
                {
                  c();
                  E = 10;
                  return 10;
                }
                a("Expected value");
                throw null;
              }
              E = 1;
              return 1;
            }
            if (m == 1)
            {
              E = 4;
              return 4;
            }
          }
          else
          {
            E = 3;
            return 3;
          }
        }
        if ((m != 1) && (m != 2))
        {
          a("Unexpected value");
          throw null;
        }
        c();
        A -= 1;
        E = 7;
        return 7;
      }
      c();
      E = 8;
      return 8;
    }
    E = 9;
    return 9;
    label1323:
    throw new IllegalStateException("JsonReader is closed");
    label1333:
    I[(J - 1)] = 4;
    if (m == 5)
    {
      k = a(true);
      if (k != 44)
      {
        if (k != 59)
        {
          if (k == 125)
          {
            E = 2;
            return 2;
          }
          a("Unterminated object");
          throw null;
        }
        c();
      }
    }
    int k = a(true);
    if (k != 34)
    {
      if (k != 39)
      {
        if (k != 125)
        {
          c();
          A -= 1;
          if (a((char)k))
          {
            E = 14;
            return 14;
          }
          a("Expected name");
          throw null;
        }
        if (m != 5)
        {
          E = 2;
          return 2;
        }
        a("Expected name");
        throw null;
      }
      c();
      E = 12;
      return 12;
    }
    E = 13;
    return 13;
  }
  
  public void e()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 4)
    {
      j = J - 1;
      J = j;
      localObject = L;
      j--;
      localObject[j] += 1;
      E = 0;
      return;
    }
    Object localObject = e.a.a.a.a.a("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void f()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 2)
    {
      j = J - 1;
      J = j;
      K[j] = null;
      localObject = L;
      j--;
      localObject[j] += 1;
      E = 0;
      return;
    }
    Object localObject = e.a.a.a.a.a("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i = J;
    for (int j = 0; j < i; j++)
    {
      int k = I[j];
      if ((k != 1) && (k != 2))
      {
        if ((k == 3) || (k == 4) || (k == 5))
        {
          localStringBuilder.append('.');
          String[] arrayOfString = K;
          if (arrayOfString[j] != null) {
            localStringBuilder.append(arrayOfString[j]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(L[j]);
        localStringBuilder.append(']');
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean h()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    boolean bool;
    if ((j != 2) && (j != 4)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String i()
  {
    int i = C;
    int j = A;
    int k = D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at line ");
    localStringBuilder.append(i + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(j - k + 1);
    localStringBuilder.append(" path ");
    localStringBuilder.append(g());
    return localStringBuilder.toString();
  }
  
  public boolean j()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 5)
    {
      E = 0;
      localObject = L;
      j = J - 1;
      localObject[j] += 1;
      return true;
    }
    if (j == 6)
    {
      E = 0;
      localObject = L;
      j = J - 1;
      localObject[j] += 1;
      return false;
    }
    Object localObject = e.a.a.a.a.a("Expected a boolean but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public double k()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 15)
    {
      E = 0;
      localObject = L;
      j = J - 1;
      localObject[j] += 1;
      return F;
    }
    if (j == 16)
    {
      H = new String(z, A, G);
      A += G;
    }
    else if ((j != 8) && (j != 9))
    {
      if (j == 10)
      {
        H = q();
      }
      else if (j != 11)
      {
        localObject = e.a.a.a.a.a("Expected a double but was ");
        ((StringBuilder)localObject).append(r());
        ((StringBuilder)localObject).append(i());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int k;
      if (j == 8)
      {
        j = 39;
        k = j;
      }
      else
      {
        j = 34;
        k = j;
      }
      H = b(k);
    }
    E = 11;
    double d = Double.parseDouble(H);
    if ((!y) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(i());
      throw new d(((StringBuilder)localObject).toString());
    }
    H = null;
    E = 0;
    Object localObject = L;
    j = J - 1;
    localObject[j] += 1;
    return d;
  }
  
  public int l()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    Object localObject1;
    if (j == 15)
    {
      long l = F;
      i = (int)l;
      if (l == i)
      {
        E = 0;
        localObject1 = L;
        j = J - 1;
        localObject1[j] += 1;
        return i;
      }
      localObject1 = e.a.a.a.a.a("Expected an int but was ");
      ((StringBuilder)localObject1).append(F);
      ((StringBuilder)localObject1).append(i());
      throw new NumberFormatException(((StringBuilder)localObject1).toString());
    }
    if (j == 16)
    {
      H = new String(z, A, G);
      A += G;
    }
    else
    {
      if ((j != 8) && (j != 9) && (j != 10))
      {
        localObject1 = e.a.a.a.a.a("Expected an int but was ");
        ((StringBuilder)localObject1).append(r());
        ((StringBuilder)localObject1).append(i());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      if (j == 10)
      {
        H = q();
      }
      else
      {
        int k;
        if (j == 8)
        {
          j = 39;
          k = j;
        }
        else
        {
          j = 34;
          k = j;
        }
        H = b(k);
      }
      try
      {
        i = Integer.parseInt(H);
        E = 0;
        localObject1 = L;
        j = J - 1;
        localObject1[j] += 1;
        return i;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    E = 11;
    double d = Double.parseDouble(H);
    i = (int)d;
    if (i == d)
    {
      H = null;
      E = 0;
      localObject2 = L;
      j = J - 1;
      localObject2[j] += 1;
      return i;
    }
    Object localObject2 = e.a.a.a.a.a("Expected an int but was ");
    ((StringBuilder)localObject2).append(H);
    ((StringBuilder)localObject2).append(i());
    throw new NumberFormatException(((StringBuilder)localObject2).toString());
  }
  
  public long m()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    Object localObject1;
    if (j == 15)
    {
      E = 0;
      localObject1 = L;
      j = J - 1;
      localObject1[j] += 1;
      return F;
    }
    if (j == 16)
    {
      H = new String(z, A, G);
      A += G;
    }
    else
    {
      if ((j != 8) && (j != 9) && (j != 10))
      {
        localObject1 = e.a.a.a.a.a("Expected a long but was ");
        ((StringBuilder)localObject1).append(r());
        ((StringBuilder)localObject1).append(i());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      if (j == 10)
      {
        H = q();
      }
      else
      {
        int k;
        if (j == 8)
        {
          j = 39;
          k = j;
        }
        else
        {
          j = 34;
          k = j;
        }
        H = b(k);
      }
      try
      {
        l = Long.parseLong(H);
        E = 0;
        localObject1 = L;
        j = J - 1;
        localObject1[j] += 1;
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    E = 11;
    double d = Double.parseDouble(H);
    long l = d;
    if (l == d)
    {
      H = null;
      E = 0;
      localObject2 = L;
      j = J - 1;
      localObject2[j] += 1;
      return l;
    }
    Object localObject2 = e.a.a.a.a.a("Expected a long but was ");
    ((StringBuilder)localObject2).append(H);
    ((StringBuilder)localObject2).append(i());
    throw new NumberFormatException(((StringBuilder)localObject2).toString());
  }
  
  public String n()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 14)
    {
      localObject = q();
    }
    else if (j == 12)
    {
      localObject = b('\'');
    }
    else
    {
      if (j != 13) {
        break label78;
      }
      localObject = b('"');
    }
    E = 0;
    K[(J - 1)] = localObject;
    return (String)localObject;
    label78:
    Object localObject = e.a.a.a.a.a("Expected a name but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void o()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 7)
    {
      E = 0;
      localObject = L;
      j = J - 1;
      localObject[j] += 1;
      return;
    }
    Object localObject = e.a.a.a.a.a("Expected null but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String p()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    if (j == 10)
    {
      localObject = q();
    }
    else if (j == 8)
    {
      localObject = b('\'');
    }
    else if (j == 9)
    {
      localObject = b('"');
    }
    else if (j == 11)
    {
      localObject = H;
      H = null;
    }
    else if (j == 15)
    {
      localObject = Long.toString(F);
    }
    else
    {
      if (j != 16) {
        break label167;
      }
      localObject = new String(z, A, G);
      A += G;
    }
    E = 0;
    int[] arrayOfInt = L;
    j = J - 1;
    arrayOfInt[j] += 1;
    return (String)localObject;
    label167:
    Object localObject = e.a.a.a.a.a("Expected a string but was ");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append(i());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final String q()
  {
    int i = 0;
    Object localObject1 = null;
    label165:
    label187:
    Object localObject2;
    label193:
    do
    {
      j = 0;
      do
      {
        for (;;)
        {
          int k = A;
          if (k + j >= B) {
            break label165;
          }
          k = z[(k + j)];
          if ((k == 9) || (k == 10) || (k == 12) || (k == 13) || (k == 32)) {
            break label187;
          }
          if (k == 35) {
            break;
          }
          if (k == 44) {
            break label187;
          }
          if ((k == 47) || (k == 61)) {
            break;
          }
          if ((k == 123) || (k == 125) || (k == 58)) {
            break label187;
          }
          if (k == 59) {
            break;
          }
          switch (k)
          {
          default: 
            j++;
          }
        }
        c();
        break;
        if (j >= z.length) {
          break label193;
        }
      } while (a(j + 1));
      localObject2 = localObject1;
      break;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max(j, 16));
      }
      ((StringBuilder)localObject2).append(z, A, j);
      A += j;
      localObject1 = localObject2;
    } while (a(1));
    int j = i;
    if (localObject2 == null)
    {
      localObject2 = new String(z, A, j);
    }
    else
    {
      ((StringBuilder)localObject2).append(z, A, j);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    A += j;
    return (String)localObject2;
  }
  
  public b r()
  {
    int i = E;
    int j = i;
    if (i == 0) {
      j = d();
    }
    switch (j)
    {
    default: 
      throw new AssertionError();
    case 17: 
      return b.END_DOCUMENT;
    case 15: 
    case 16: 
      return b.NUMBER;
    case 12: 
    case 13: 
    case 14: 
      return b.NAME;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return b.STRING;
    case 7: 
      return b.NULL;
    case 5: 
    case 6: 
      return b.BOOLEAN;
    case 4: 
      return b.END_ARRAY;
    case 3: 
      return b.BEGIN_ARRAY;
    case 2: 
      return b.END_OBJECT;
    }
    return b.BEGIN_OBJECT;
  }
  
  public final char s()
  {
    if ((A == B) && (!a(1)))
    {
      a("Unterminated escape sequence");
      throw null;
    }
    Object localObject = z;
    int i = A;
    int j = i + 1;
    A = j;
    char c = localObject[i];
    if (c != '\n')
    {
      if ((c != '"') && (c != '\'') && (c != '/') && (c != '\\'))
      {
        if (c != 'b')
        {
          if (c != 'f')
          {
            if (c != 'n')
            {
              if (c != 'r')
              {
                if (c != 't')
                {
                  if (c == 'u')
                  {
                    if ((j + 4 > B) && (!a(4)))
                    {
                      a("Unterminated escape sequence");
                      throw null;
                    }
                    int k = 0;
                    i = A;
                    j = i;
                    int m;
                    for (c = k;; c = m)
                    {
                      k = j;
                      if (k >= i + 4) {
                        break label317;
                      }
                      j = z[k];
                      m = (char)(c << '\004');
                      if ((j >= 48) && (j <= 57))
                      {
                        j -= 48;
                      }
                      else
                      {
                        if ((j >= 97) && (j <= 102))
                        {
                          j -= 97;
                        }
                        else
                        {
                          if ((j < 65) || (j > 70)) {
                            break;
                          }
                          j -= 65;
                        }
                        j += 10;
                      }
                      m = (char)(j + m);
                      j = k + 1;
                    }
                    localObject = e.a.a.a.a.a("\\u");
                    ((StringBuilder)localObject).append(new String(z, A, 4));
                    throw new NumberFormatException(((StringBuilder)localObject).toString());
                    label317:
                    A += 4;
                    return c;
                  }
                  a("Invalid escape sequence");
                  throw null;
                }
                return '\t';
              }
              return '\r';
            }
            return '\n';
          }
          return '\f';
        }
        return '\b';
      }
    }
    else
    {
      C += 1;
      D = j;
    }
    return c;
  }
  
  public final void t()
  {
    int i;
    do
    {
      if ((A >= B) && (!a(1))) {
        break;
      }
      char[] arrayOfChar = z;
      i = A;
      int j = i + 1;
      A = j;
      i = arrayOfChar[i];
      if (i == 10)
      {
        C += 1;
        D = j;
        break;
      }
    } while (i != 13);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(i());
    return localStringBuilder.toString();
  }
  
  public void u()
  {
    int i = 0;
    label322:
    label337:
    label352:
    do
    {
      j = E;
      int k = j;
      if (j == 0) {
        k = d();
      }
      if (k == 3) {
        b(1);
      }
      for (;;)
      {
        j = i + 1;
        break label352;
        if (k != 1) {
          break;
        }
        b(3);
      }
      if (k == 4) {}
      for (J -= 1;; J -= 1)
      {
        j = i - 1;
        break label352;
        if (k != 2) {
          break;
        }
      }
      if ((k != 14) && (k != 10))
      {
        if ((k != 8) && (k != 12))
        {
          if ((k != 9) && (k != 13))
          {
            j = i;
            if (k == 16)
            {
              A += G;
              j = i;
            }
          }
          else
          {
            c('"');
            j = i;
          }
        }
        else
        {
          c('\'');
          j = i;
        }
      }
      else
      {
        do
        {
          for (j = 0;; j++)
          {
            k = A + j;
            if (k >= B) {
              break label337;
            }
            k = z[k];
            if ((k == 9) || (k == 10) || (k == 12) || (k == 13) || (k == 32)) {
              break label322;
            }
            if (k == 35) {
              break;
            }
            if (k == 44) {
              break label322;
            }
            if ((k == 47) || (k == 61)) {
              break;
            }
            if ((k == 123) || (k == 125) || (k == 58)) {
              break label322;
            }
            if (k == 59) {
              break;
            }
            switch (k)
            {
            }
          }
          c();
          A += j;
          j = i;
          break;
          A = k;
        } while (a(1));
        j = i;
      }
      E = 0;
      i = j;
    } while (j != 0);
    int[] arrayOfInt = L;
    i = J;
    int j = i - 1;
    arrayOfInt[j] += 1;
    K[(i - 1)] = "null";
  }
  
  public static final class a
    extends p
  {}
}

/* Location:
 * Qualified Name:     e.c.c.y.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */