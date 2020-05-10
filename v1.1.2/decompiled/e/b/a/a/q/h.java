package e.b.a.a.q;

import e.b.a.a.i;
import e.b.a.a.i.a;
import e.b.a.a.k;
import e.b.a.a.l;
import e.b.a.a.r.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public class h
  extends e.b.a.a.o.b
{
  public static final int[] b0 = e.b.a.a.p.a.d;
  public static final int[] c0 = e.b.a.a.p.a.c;
  public static final int d0 = i.a.ALLOW_TRAILING_COMMA.getMask();
  public final e.b.a.a.r.a T;
  public int[] U = new int[16];
  public boolean V;
  public int W;
  public int X;
  public InputStream Y;
  public byte[] Z;
  public boolean a0;
  
  public h(e.b.a.a.p.b paramb, int paramInt1, InputStream paramInputStream, e.b.a.a.r.a parama, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramb, paramInt1);
    Y = paramInputStream;
    T = parama;
    Z = paramArrayOfByte;
    G = paramInt2;
    H = paramInt3;
    K = paramInt2;
    I = (-paramInt2);
    a0 = paramBoolean;
  }
  
  public static final int c(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 4) {
      paramInt1 |= -1 << (paramInt2 << 3);
    }
    return paramInt1;
  }
  
  public final void A()
  {
    int[] arrayOfInt = e.b.a.a.p.a.g;
    for (;;)
    {
      if ((G >= H) && (!s())) {
        return;
      }
      byte[] arrayOfByte = Z;
      int i = G;
      int j = i + 1;
      G = j;
      i = arrayOfByte[i] & 0xFF;
      int k = arrayOfInt[i];
      if (k != 0) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k != 10)
              {
                if (k != 13)
                {
                  if ((k != 42) && (k < 0))
                  {
                    j(i);
                    throw null;
                  }
                }
                else {
                  y();
                }
              }
              else
              {
                J += 1;
                K = j;
              }
            }
            else {
              D();
            }
          }
          else {
            C();
          }
        }
        else {
          B();
        }
      }
    }
  }
  
  public final void B()
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128) {
      return;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public final void C()
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128)
    {
      if (j >= H) {
        t();
      }
      arrayOfByte = Z;
      i = G;
      j = i + 1;
      G = j;
      i = arrayOfByte[i];
      if ((i & 0xC0) == 128) {
        return;
      }
      a(i & 0xFF, j);
      throw null;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public final void D()
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128)
    {
      if (j >= H) {
        t();
      }
      arrayOfByte = Z;
      i = G;
      j = i + 1;
      G = j;
      i = arrayOfByte[i];
      if ((i & 0xC0) == 128)
      {
        if (j >= H) {
          t();
        }
        arrayOfByte = Z;
        i = G;
        j = i + 1;
        G = j;
        i = arrayOfByte[i];
        if ((i & 0xC0) == 128) {
          return;
        }
        a(i & 0xFF, j);
        throw null;
      }
      a(i & 0xFF, j);
      throw null;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public final int E()
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!s()))
        {
          localObject = e.a.a.a.a.a("Unexpected end-of-input within/between ");
          ((StringBuilder)localObject).append(N.e());
          ((StringBuilder)localObject).append(" entries");
          throw a(((StringBuilder)localObject).toString());
        }
        Object localObject = Z;
        i = G;
        int j = i + 1;
        G = j;
        i = localObject[i] & 0xFF;
        if (i > 32)
        {
          if (i == 47) {
            z();
          } else if ((i != 35) || (!G())) {
            return i;
          }
        }
        else if (i != 32) {
          if (i == 10)
          {
            J += 1;
            K = j;
          }
          else
          {
            if (i != 13) {
              break;
            }
            y();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final int F()
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!s()))
        {
          l();
          return -1;
        }
        byte[] arrayOfByte = Z;
        i = G;
        int j = i + 1;
        G = j;
        i = arrayOfByte[i] & 0xFF;
        if (i > 32)
        {
          if (i == 47) {
            z();
          } else if ((i != 35) || (!G())) {
            return i;
          }
        }
        else if (i != 32) {
          if (i == 10)
          {
            J += 1;
            K = j;
          }
          else
          {
            if (i != 13) {
              break;
            }
            y();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final boolean G()
  {
    if (!a(i.a.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    A();
    return true;
  }
  
  public final void H()
  {
    L = J;
    M = (G - K);
  }
  
  public final int I()
  {
    if ((G >= H) && (!s())) {
      return 48;
    }
    int i = Z[G] & 0xFF;
    if ((i >= 48) && (i <= 57))
    {
      if (a(i.a.ALLOW_NUMERIC_LEADING_ZEROS))
      {
        G += 1;
        int j = i;
        if (i == 48)
        {
          j = i;
          while ((G < H) || (s()))
          {
            localObject = Z;
            j = G;
            i = localObject[j] & 0xFF;
            if ((i >= 48) && (i <= 57))
            {
              G = (j + 1);
              j = i;
              if (i != 48) {
                j = i;
              }
            }
            else
            {
              return 48;
            }
          }
        }
        return j;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid numeric value: ");
      ((StringBuilder)localObject).append("Leading zeroes not allowed");
      throw a(((StringBuilder)localObject).toString());
    }
    return 48;
  }
  
  public final int J()
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    G = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final int a(boolean paramBoolean)
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!s()))
        {
          localObject = e.a.a.a.a.a(" within/between ");
          ((StringBuilder)localObject).append(N.e());
          ((StringBuilder)localObject).append(" entries");
          a(((StringBuilder)localObject).toString(), null);
          throw null;
        }
        Object localObject = Z;
        i = G;
        int j = i + 1;
        G = j;
        i = localObject[i] & 0xFF;
        if (i > 32)
        {
          if (i == 47)
          {
            z();
          }
          else if ((i != 35) || (!G()))
          {
            if (paramBoolean) {
              return i;
            }
            if (i == 58)
            {
              paramBoolean = true;
            }
            else
            {
              a(i, "was expecting a colon to separate field name and value");
              throw null;
            }
          }
        }
        else if (i != 32) {
          if (i == 10)
          {
            J += 1;
            K = j;
          }
          else
          {
            if (i != 13) {
              break;
            }
            y();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public l a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt == 73)
    {
      if ((G >= H) && (!s()))
      {
        a(l.VALUE_NUMBER_FLOAT);
        throw null;
      }
      Object localObject = Z;
      paramInt = G;
      G = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt == 78)
      {
        if (paramBoolean) {
          localObject = "-INF";
        } else {
          localObject = "+INF";
        }
      }
      else
      {
        i = paramInt;
        if (paramInt != 110) {
          break label170;
        }
        if (paramBoolean) {
          localObject = "-Infinity";
        } else {
          localObject = "+Infinity";
        }
      }
      a((String)localObject, 3);
      if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS))
      {
        double d;
        if (paramBoolean) {
          d = Double.NEGATIVE_INFINITY;
        } else {
          d = Double.POSITIVE_INFINITY;
        }
        return a((String)localObject, d);
      }
      throw a(String.format("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", new Object[] { localObject }));
    }
    label170:
    c(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    throw null;
  }
  
  public final l a(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    Object localObject;
    int i;
    int j;
    if (paramInt2 == 46)
    {
      localObject = paramArrayOfChar;
      paramInt3 = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = P.f();
        paramInt3 = 0;
      }
      localObject[paramInt3] = ((char)(char)paramInt2);
      paramInt3++;
      i = 0;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
      for (paramArrayOfChar = (char[])localObject;; paramArrayOfChar = (char[])localObject)
      {
        if ((G >= H) && (!s()))
        {
          j = 1;
          paramInt3 = paramInt1;
          break label173;
        }
        localObject = Z;
        paramInt1 = G;
        G = (paramInt1 + 1);
        paramInt1 = localObject[paramInt1] & 0xFF;
        if ((paramInt1 < 48) || (paramInt1 > 57)) {
          break;
        }
        i++;
        localObject = paramArrayOfChar;
        paramInt3 = paramInt2;
        if (paramInt2 >= paramArrayOfChar.length)
        {
          localObject = P.f();
          paramInt3 = 0;
        }
        localObject[paramInt3] = ((char)(char)paramInt1);
        paramInt2 = paramInt3 + 1;
      }
      j = 0;
      paramInt3 = paramInt1;
      label173:
      if (i != 0)
      {
        paramInt1 = j;
        localObject = paramArrayOfChar;
      }
      else
      {
        c(paramInt3, "Decimal point not followed by a digit");
        throw null;
      }
    }
    else
    {
      j = 0;
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      localObject = paramArrayOfChar;
      paramInt1 = j;
    }
    int k;
    if (paramInt3 != 101)
    {
      j = paramInt1;
      k = paramInt2;
      i = paramInt3;
      if (paramInt3 != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      i = paramInt2;
      if (paramInt2 >= localObject.length)
      {
        paramArrayOfChar = P.f();
        i = 0;
      }
      j = i + 1;
      paramArrayOfChar[i] = ((char)(char)paramInt3);
      if (G >= H) {
        t();
      }
      localObject = Z;
      paramInt2 = G;
      G = (paramInt2 + 1);
      i = localObject[paramInt2] & 0xFF;
      if (i != 45)
      {
        paramInt2 = j;
        localObject = paramArrayOfChar;
        paramInt3 = i;
        if (i == 43) {}
      }
      for (;;)
      {
        k = 0;
        break;
        paramInt2 = j;
        localObject = paramArrayOfChar;
        if (j >= paramArrayOfChar.length)
        {
          localObject = P.f();
          paramInt2 = 0;
        }
        localObject[paramInt2] = ((char)(char)i);
        if (G >= H) {
          t();
        }
        paramArrayOfChar = Z;
        paramInt3 = G;
        G = (paramInt3 + 1);
        paramInt3 = paramArrayOfChar[paramInt3] & 0xFF;
        paramInt2++;
      }
      int m;
      for (;;)
      {
        i = paramInt2;
        j = paramInt1;
        m = k;
        if (paramInt3 < 48) {
          break;
        }
        i = paramInt2;
        j = paramInt1;
        m = k;
        if (paramInt3 > 57) {
          break;
        }
        k++;
        j = paramInt2;
        paramArrayOfChar = (char[])localObject;
        if (paramInt2 >= localObject.length)
        {
          paramArrayOfChar = P.f();
          j = 0;
        }
        paramInt2 = j + 1;
        paramArrayOfChar[j] = ((char)(char)paramInt3);
        if ((G >= H) && (!s()))
        {
          j = 1;
          i = paramInt2;
          m = k;
          break;
        }
        localObject = Z;
        paramInt3 = G;
        G = (paramInt3 + 1);
        paramInt3 = localObject[paramInt3] & 0xFF;
        localObject = paramArrayOfChar;
      }
      if (m == 0) {
        break label630;
      }
      k = i;
      i = paramInt3;
    }
    if (j == 0)
    {
      G -= 1;
      if (N.d()) {
        m(i);
      }
    }
    P.i = k;
    return l.VALUE_NUMBER_FLOAT;
    label630:
    c(paramInt3, "Exponent indicator not followed by a digit");
    throw null;
  }
  
  public final l a(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j;
    for (;;)
    {
      if ((G >= H) && (!s()))
      {
        P.i = paramInt1;
        return l.VALUE_NUMBER_INT;
      }
      Object localObject = Z;
      int i = G;
      G = (i + 1);
      j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48)) {
        break;
      }
      localObject = paramArrayOfChar;
      i = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = P.f();
        i = 0;
      }
      localObject[i] = ((char)(char)j);
      paramInt2++;
      paramInt1 = i + 1;
      paramArrayOfChar = (char[])localObject;
    }
    if ((j != 46) && (j != 101) && (j != 69))
    {
      G -= 1;
      P.i = paramInt1;
      if (N.d())
      {
        paramArrayOfChar = Z;
        paramInt1 = G;
        G = (paramInt1 + 1);
        m(paramArrayOfChar[paramInt1] & 0xFF);
      }
      return l.VALUE_NUMBER_INT;
    }
    return a(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
  }
  
  public final String a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = c(paramInt2, paramInt3);
    Object localObject = T.b(paramInt1, paramInt2);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = U;
    localObject[0] = paramInt1;
    localObject[1] = paramInt2;
    return a((int[])localObject, 2, paramInt3);
  }
  
  public final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = c(paramInt3, paramInt4);
    Object localObject = T.b(paramInt1, paramInt2, paramInt3);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = U;
    localObject[0] = paramInt1;
    localObject[1] = paramInt2;
    localObject[2] = c(paramInt3, paramInt4);
    return a((int[])localObject, 3, paramInt4);
  }
  
  public final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = U;
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    return a(arrayOfInt, 2, paramInt3, paramInt4, paramInt5);
  }
  
  public final String a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = (paramInt1 << 2) - 4 + paramInt2;
    int j;
    int k;
    if (paramInt2 < 4)
    {
      j = paramInt1 - 1;
      k = paramArrayOfInt[j];
      paramArrayOfInt[j] = (k << (4 - paramInt2 << 3));
    }
    else
    {
      k = 0;
    }
    Object localObject1 = P.c();
    int m = 0;
    int i2;
    for (int n = 0; m < i; n = i2 + 1)
    {
      j = paramArrayOfInt[(m >> 2)] >> (3 - (m & 0x3) << 3) & 0xFF;
      int i1 = m + 1;
      Object localObject2 = localObject1;
      m = i1;
      i2 = n;
      int i3 = j;
      if (j > 127)
      {
        int i4;
        if ((j & 0xE0) == 192)
        {
          j &= 0x1F;
          i4 = 1;
        }
        else if ((j & 0xF0) == 224)
        {
          j &= 0xF;
          i4 = 2;
        }
        else
        {
          if ((j & 0xF8) != 240) {
            break label496;
          }
          j &= 0x7;
          i4 = 3;
        }
        if (i1 + i4 <= i)
        {
          i3 = paramArrayOfInt[(i1 >> 2)] >> (3 - (i1 & 0x3) << 3);
          m = i1 + 1;
          if ((i3 & 0xC0) == 128)
          {
            i3 = j << 6 | i3 & 0x3F;
            j = m;
            i1 = i3;
            if (i4 > 1)
            {
              i1 = paramArrayOfInt[(m >> 2)] >> (3 - (m & 0x3) << 3);
              j = m + 1;
              if ((i1 & 0xC0) == 128)
              {
                i1 = i1 & 0x3F | i3 << 6;
                if (i4 > 2)
                {
                  m = paramArrayOfInt[(j >> 2)] >> (3 - (j & 0x3) << 3);
                  j++;
                  if ((m & 0xC0) == 128)
                  {
                    i1 = i1 << 6 | m & 0x3F;
                  }
                  else
                  {
                    l(m & 0xFF);
                    throw null;
                  }
                }
              }
              else
              {
                l(i1);
                throw null;
              }
            }
            localObject2 = localObject1;
            m = j;
            i2 = n;
            i3 = i1;
            if (i4 > 2)
            {
              i1 -= 65536;
              localObject2 = localObject1;
              if (n >= localObject1.length) {
                localObject2 = P.e();
              }
              localObject2[n] = ((char)(char)((i1 >> 10) + 55296));
              i3 = i1 & 0x3FF | 0xDC00;
              i2 = n + 1;
              m = j;
            }
          }
          else
          {
            l(i3);
            throw null;
          }
        }
        else
        {
          a(" in field name", l.FIELD_NAME);
          throw null;
          label496:
          k(j);
          throw null;
        }
      }
      localObject1 = localObject2;
      if (i2 >= localObject2.length) {
        localObject1 = P.e();
      }
      localObject1[i2] = ((char)(char)i3);
    }
    localObject1 = new String((char[])localObject1, 0, n);
    if (paramInt2 < 4) {
      paramArrayOfInt[(paramInt1 - 1)] = k;
    }
    return T.a((String)localObject1, paramArrayOfInt, paramInt1);
  }
  
  public final String a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      arrayOfInt = e.b.a.a.o.b.a(paramArrayOfInt, paramArrayOfInt.length);
      U = arrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = c(paramInt2, paramInt3);
    paramArrayOfInt = T.b(arrayOfInt, i);
    if (paramArrayOfInt == null) {
      return a(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  public final String a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = c0;
    Object localObject2;
    for (int i = paramInt3;; i = localObject2[paramInt3] & 0xFF)
    {
      localObject2 = paramArrayOfInt;
      int j = paramInt1;
      int k = paramInt2;
      paramInt3 = i;
      int m = paramInt4;
      if (localObject1[i] != 0)
      {
        if (i == 34)
        {
          localObject2 = paramArrayOfInt;
          paramInt3 = paramInt1;
          if (paramInt4 > 0)
          {
            localObject2 = paramArrayOfInt;
            if (paramInt1 >= paramArrayOfInt.length)
            {
              localObject2 = e.b.a.a.o.b.a(paramArrayOfInt, paramArrayOfInt.length);
              U = ((int[])localObject2);
            }
            localObject2[paramInt1] = c(paramInt2, paramInt4);
            paramInt3 = paramInt1 + 1;
          }
          localObject1 = T.b((int[])localObject2, paramInt3);
          paramArrayOfInt = (int[])localObject1;
          if (localObject1 == null) {
            paramArrayOfInt = a((int[])localObject2, paramInt3, paramInt4);
          }
          return paramArrayOfInt;
        }
        if (i != 92) {
          b(i, "name");
        } else {
          i = k();
        }
        localObject2 = paramArrayOfInt;
        j = paramInt1;
        k = paramInt2;
        paramInt3 = i;
        m = paramInt4;
        if (i > 127)
        {
          k = 0;
          localObject2 = paramArrayOfInt;
          paramInt3 = paramInt1;
          m = paramInt2;
          j = paramInt4;
          if (paramInt4 >= 4)
          {
            localObject2 = paramArrayOfInt;
            if (paramInt1 >= paramArrayOfInt.length)
            {
              localObject2 = e.b.a.a.o.b.a(paramArrayOfInt, paramArrayOfInt.length);
              U = ((int[])localObject2);
            }
            localObject2[paramInt1] = paramInt2;
            paramInt3 = paramInt1 + 1;
            m = 0;
            j = 0;
          }
          if (i < 2048)
          {
            paramInt1 = m << 8 | i >> 6 | 0xC0;
            paramInt2 = j + 1;
            j = paramInt3;
          }
          else
          {
            paramInt2 = m << 8 | i >> 12 | 0xE0;
            paramInt1 = j + 1;
            if (paramInt1 >= 4)
            {
              paramArrayOfInt = (int[])localObject2;
              if (paramInt3 >= localObject2.length)
              {
                paramArrayOfInt = e.b.a.a.o.b.a((int[])localObject2, localObject2.length);
                U = paramArrayOfInt;
              }
              paramArrayOfInt[paramInt3] = paramInt2;
              paramInt3++;
              paramInt1 = 0;
              paramInt2 = k;
            }
            else
            {
              paramArrayOfInt = (int[])localObject2;
            }
            paramInt4 = paramInt2 << 8 | i >> 6 & 0x3F | 0x80;
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt4;
            j = paramInt3;
            localObject2 = paramArrayOfInt;
          }
          paramInt3 = i & 0x3F | 0x80;
          m = paramInt2;
          k = paramInt1;
        }
      }
      if (m < 4)
      {
        paramInt4 = m + 1;
        paramInt2 = k << 8 | paramInt3;
        paramArrayOfInt = (int[])localObject2;
        paramInt1 = j;
      }
      else
      {
        paramArrayOfInt = (int[])localObject2;
        if (j >= localObject2.length)
        {
          paramArrayOfInt = e.b.a.a.o.b.a((int[])localObject2, localObject2.length);
          U = paramArrayOfInt;
        }
        paramArrayOfInt[j] = k;
        paramInt2 = paramInt3;
        paramInt1 = j + 1;
        paramInt4 = 1;
      }
      if ((G >= H) && (!s()))
      {
        a(" in field name", l.FIELD_NAME);
        throw null;
      }
      localObject2 = Z;
      paramInt3 = G;
      G = (paramInt3 + 1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    G = paramInt2;
    l(paramInt1);
    throw null;
  }
  
  public final void a(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = paramInt;
    if (G + i >= H)
    {
      b(paramString, paramInt);
      return;
    }
    while (Z[G] == paramString.charAt(j))
    {
      int k = G + 1;
      G = k;
      paramInt = j + 1;
      j = paramInt;
      if (paramInt >= i)
      {
        j = Z[k] & 0xFF;
        if ((j >= 48) && (j != 93) && (j != 125)) {
          a(paramString, paramInt, j);
        }
        return;
      }
    }
    c(paramString.substring(0, j));
    throw null;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!Character.isJavaIdentifierPart((char)c(paramInt2))) {
      return;
    }
    c(paramString.substring(0, paramInt1));
    throw null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    while ((G < H) || (s()))
    {
      paramString1 = Z;
      int i = G;
      G = (i + 1);
      char c = (char)c(paramString1[i]);
      if (Character.isJavaIdentifierPart(c))
      {
        localStringBuilder.append(c);
        if (localStringBuilder.length() >= 256) {
          localStringBuilder.append("...");
        }
      }
    }
    a("Unrecognized token '%s': was expecting %s", localStringBuilder, paramString2);
    throw null;
  }
  
  public byte[] a(e.b.a.a.a parama)
  {
    Object localObject = y;
    if ((localObject != l.VALUE_STRING) && ((localObject != l.VALUE_EMBEDDED_OBJECT) || (S == null)))
    {
      parama = e.a.a.a.a.a("Current token (");
      parama.append(y);
      parama.append(") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
      throw a(parama.toString());
    }
    if (V)
    {
      try
      {
        S = b(parama);
        V = false;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to decode VALUE_STRING as base64 (");
        ((StringBuilder)localObject).append(parama);
        ((StringBuilder)localObject).append("): ");
        ((StringBuilder)localObject).append(localIllegalArgumentException.getMessage());
        throw a(((StringBuilder)localObject).toString());
      }
    }
    else if (S == null)
    {
      e.b.a.a.s.c localc = m();
      localObject = i();
      try
      {
        parama.a((String)localObject, localc);
        S = localc.c();
      }
      catch (IllegalArgumentException parama)
      {
        throw a(parama.getMessage());
      }
    }
    return S;
  }
  
  public e.b.a.a.g b()
  {
    int i = G;
    int j = K;
    return new e.b.a.a.g(n(), I + G, -1L, J, i - j + 1);
  }
  
  public final String b(int paramInt1, int paramInt2)
  {
    paramInt1 = c(paramInt1, paramInt2);
    Object localObject = T.c(paramInt1);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = U;
    localObject[0] = paramInt1;
    return a((int[])localObject, 1, paramInt2);
  }
  
  public final String b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(U, 0, paramInt1, paramInt2, paramInt3);
  }
  
  public final String b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = U;
    arrayOfInt[0] = paramInt1;
    return a(arrayOfInt, 1, paramInt2, paramInt3, paramInt4);
  }
  
  public String b(String paramString)
  {
    l locall = y;
    if (locall == l.VALUE_STRING)
    {
      if (V)
      {
        V = false;
        return r();
      }
      return P.b();
    }
    if (locall == l.FIELD_NAME) {
      return c();
    }
    return super.b(paramString);
  }
  
  public final void b(String paramString, int paramInt)
  {
    int i = paramString.length();
    while (((G < H) || (s())) && (Z[G] == paramString.charAt(paramInt)))
    {
      int j = G + 1;
      G = j;
      int k = paramInt + 1;
      paramInt = k;
      if (k >= i)
      {
        if ((j >= H) && (!s())) {
          return;
        }
        paramInt = Z[G] & 0xFF;
        if ((paramInt >= 48) && (paramInt != 93) && (paramInt != 125)) {
          a(paramString, k, paramInt);
        }
        return;
      }
    }
    c(paramString.substring(0, paramInt));
    throw null;
  }
  
  public final byte[] b(e.b.a.a.a parama)
  {
    Object localObject = m();
    for (;;)
    {
      if (G >= H) {
        t();
      }
      byte[] arrayOfByte = Z;
      int i = G;
      G = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      if (j > 32)
      {
        int k = parama.a(j);
        int m = 0;
        i = k;
        if (k < 0)
        {
          if (j == 34) {
            return ((e.b.a.a.s.c)localObject).c();
          }
          k = a(parama, j, 0);
          i = k;
          if (k < 0) {}
        }
        else
        {
          if (G >= H) {
            t();
          }
          arrayOfByte = Z;
          k = G;
          G = (k + 1);
          int n = arrayOfByte[k] & 0xFF;
          j = parama.a(n);
          k = j;
          if (j < 0) {
            k = a(parama, n, 1);
          }
          n = i << 6 | k;
          if (G >= H) {
            t();
          }
          arrayOfByte = Z;
          i = G;
          G = (i + 1);
          int i1 = arrayOfByte[i] & 0xFF;
          k = parama.a(i1);
          j = k;
          if (k < 0)
          {
            i = k;
            if (k != -2)
            {
              if ((i1 == 34) && (!B))
              {
                ((e.b.a.a.s.c)localObject).a(n >> 4);
                return ((e.b.a.a.s.c)localObject).c();
              }
              i = a(parama, i1, 2);
            }
            j = i;
            if (i == -2)
            {
              if (G >= H) {
                t();
              }
              arrayOfByte = Z;
              i = G;
              G = (i + 1);
              k = arrayOfByte[i] & 0xFF;
              i = m;
              if (k == C) {
                i = 1;
              }
              if (i != 0)
              {
                ((e.b.a.a.s.c)localObject).a(n >> 4);
                continue;
              }
              localObject = e.a.a.a.a.a("expected padding character '");
              ((StringBuilder)localObject).append(C);
              ((StringBuilder)localObject).append("'");
              throw a(parama, k, 3, ((StringBuilder)localObject).toString());
            }
          }
          m = n << 6 | j;
          if (G >= H) {
            t();
          }
          arrayOfByte = Z;
          i = G;
          G = (i + 1);
          n = arrayOfByte[i] & 0xFF;
          k = parama.a(n);
          j = k;
          if (k < 0)
          {
            i = k;
            if (k != -2)
            {
              if ((n == 34) && (!B))
              {
                ((e.b.a.a.s.c)localObject).c(m >> 2);
                return ((e.b.a.a.s.c)localObject).c();
              }
              i = a(parama, n, 3);
            }
            j = i;
            if (i == -2)
            {
              ((e.b.a.a.s.c)localObject).c(m >> 2);
              continue;
            }
          }
          ((e.b.a.a.s.c)localObject).b(m << 6 | j);
        }
      }
    }
  }
  
  public int c(int paramInt)
  {
    int i = paramInt & 0xFF;
    paramInt = i;
    if (i > 127)
    {
      if ((i & 0xE0) == 192)
      {
        paramInt = i & 0x1F;
        i = 1;
      }
      else if ((i & 0xF0) == 224)
      {
        paramInt = i & 0xF;
        i = 2;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label202;
        }
        paramInt = i & 0x7;
        i = 3;
      }
      int j = J();
      if ((j & 0xC0) == 128)
      {
        j = paramInt << 6 | j & 0x3F;
        paramInt = j;
        if (i > 1)
        {
          paramInt = J();
          if ((paramInt & 0xC0) == 128)
          {
            j = j << 6 | paramInt & 0x3F;
            paramInt = j;
            if (i > 2)
            {
              paramInt = J();
              if ((paramInt & 0xC0) == 128)
              {
                paramInt = j << 6 | paramInt & 0x3F;
              }
              else
              {
                l(paramInt & 0xFF);
                throw null;
              }
            }
          }
          else
          {
            l(paramInt & 0xFF);
            throw null;
          }
        }
      }
      else
      {
        l(j & 0xFF);
        throw null;
        label202:
        k(i & 0xFF);
        throw null;
      }
    }
    return paramInt;
  }
  
  public void c(String paramString)
  {
    a(paramString, "'null', 'true', 'false' or NaN");
    throw null;
  }
  
  public final int d(int paramInt)
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128) {
      return (paramInt & 0x1F) << 6 | i & 0x3F;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public String d()
  {
    l locall = y;
    if (locall == l.VALUE_STRING)
    {
      if (V)
      {
        V = false;
        return r();
      }
      return P.b();
    }
    if (locall == l.FIELD_NAME) {
      return c();
    }
    return super.b(null);
  }
  
  public final int e(int paramInt)
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128)
    {
      if (j >= H) {
        t();
      }
      arrayOfByte = Z;
      int k = G;
      j = k + 1;
      G = j;
      k = arrayOfByte[k];
      if ((k & 0xC0) == 128) {
        return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | k & 0x3F;
      }
      a(k & 0xFF, j);
      throw null;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public final int f(int paramInt)
  {
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    int k = arrayOfByte[i];
    if ((k & 0xC0) == 128)
    {
      i = j + 1;
      G = i;
      j = arrayOfByte[j];
      if ((j & 0xC0) == 128) {
        return ((paramInt & 0xF) << 6 | k & 0x3F) << 6 | j & 0x3F;
      }
      a(j & 0xFF, i);
      throw null;
    }
    a(k & 0xFF, j);
    throw null;
  }
  
  public l f()
  {
    if (y == l.FIELD_NAME)
    {
      localObject1 = O;
      O = null;
      if (localObject1 == l.START_ARRAY) {
        N = N.a(L, M);
      } else if (localObject1 == l.START_OBJECT) {
        N = N.b(L, M);
      }
      y = ((l)localObject1);
      return (l)localObject1;
    }
    Object localObject2;
    int i;
    int j;
    if (V)
    {
      V = false;
      localObject1 = b0;
      localObject2 = Z;
      for (;;)
      {
        i = G;
        j = H;
        k = i;
        m = j;
        if (i >= j)
        {
          t();
          k = G;
          m = H;
        }
        for (;;)
        {
          if (k >= m) {
            break label282;
          }
          j = k + 1;
          k = localObject2[k] & 0xFF;
          if (localObject1[k] != 0)
          {
            G = j;
            if (k == 34) {
              break label291;
            }
            m = localObject1[k];
            if (m != 1)
            {
              if (m != 2)
              {
                if (m != 3)
                {
                  if (m != 4)
                  {
                    if (k < 32)
                    {
                      b(k, "string value");
                      break;
                    }
                    j(k);
                    throw null;
                  }
                  D();
                  break;
                }
                C();
                break;
              }
              B();
              break;
            }
            k();
            break;
          }
          k = j;
        }
        label282:
        G = k;
      }
    }
    label291:
    if ((G >= H) && (!s()))
    {
      l();
      k = -1;
    }
    else
    {
      localObject1 = Z;
      m = G;
      k = m + 1;
      G = k;
      m = localObject1[m] & 0xFF;
      if (m > 32)
      {
        if (m != 47)
        {
          k = m;
          if (m != 35) {}
        }
        else
        {
          G -= 1;
          k = F();
        }
      }
      else
      {
        if (m != 32) {
          if (m == 10)
          {
            J += 1;
            K = k;
          }
          else if (m == 13)
          {
            y();
          }
          else if (m != 9)
          {
            a(m);
            throw null;
          }
        }
        do
        {
          for (;;)
          {
            m = G;
            if (m >= H) {
              break label613;
            }
            localObject1 = Z;
            k = m + 1;
            G = k;
            m = localObject1[m] & 0xFF;
            if (m > 32)
            {
              if (m != 47)
              {
                k = m;
                if (m != 35) {
                  break label619;
                }
              }
              G -= 1;
              k = F();
              break label619;
            }
            if (m != 32) {
              if (m == 10)
              {
                J += 1;
                K = k;
              }
              else
              {
                if (m != 13) {
                  break;
                }
                y();
              }
            }
          }
        } while (m == 9);
        a(m);
        throw null;
        label613:
        k = F();
      }
    }
    label619:
    if (k < 0)
    {
      close();
      y = null;
      return null;
    }
    S = null;
    if (k == 93)
    {
      p();
      localObject1 = l.END_ARRAY;
      y = ((l)localObject1);
      return (l)localObject1;
    }
    if (k == 125)
    {
      q();
      localObject1 = l.END_OBJECT;
      y = ((l)localObject1);
      return (l)localObject1;
    }
    Object localObject1 = N;
    int m = b + 1;
    b = m;
    if ((a != 0) && (m > 0)) {
      j = 1;
    } else {
      j = 0;
    }
    m = k;
    if (j != 0) {
      if (k == 44)
      {
        do
        {
          for (;;)
          {
            m = G;
            if (m >= H) {
              break label891;
            }
            localObject1 = Z;
            k = m + 1;
            G = k;
            m = localObject1[m] & 0xFF;
            if (m > 32)
            {
              if (m != 47)
              {
                k = m;
                if (m != 35) {
                  break label897;
                }
              }
              G -= 1;
              k = E();
              break label897;
            }
            if (m != 32) {
              if (m == 10)
              {
                J += 1;
                K = k;
              }
              else
              {
                if (m != 13) {
                  break;
                }
                y();
              }
            }
          }
        } while (m == 9);
        a(m);
        throw null;
        label891:
        k = E();
        label897:
        m = k;
        if ((x & d0) != 0) {
          if (k != 93)
          {
            m = k;
            if (k != 125) {}
          }
          else
          {
            if (k == 125)
            {
              q();
              localObject1 = l.END_OBJECT;
              y = ((l)localObject1);
            }
            else
            {
              p();
              localObject1 = l.END_ARRAY;
              y = ((l)localObject1);
            }
            return (l)localObject1;
          }
        }
      }
      else
      {
        localObject1 = e.a.a.a.a.a("was expecting comma to separate ");
        ((StringBuilder)localObject1).append(N.e());
        ((StringBuilder)localObject1).append(" entries");
        a(k, ((StringBuilder)localObject1).toString());
        throw null;
      }
    }
    if (!N.c())
    {
      H();
      if (m == 34)
      {
        V = true;
        localObject1 = l.VALUE_STRING;
        y = ((l)localObject1);
      }
      else if (m != 45)
      {
        if (m != 91)
        {
          if (m != 102)
          {
            if (m != 110)
            {
              if (m != 116)
              {
                if (m != 123)
                {
                  switch (m)
                  {
                  default: 
                    localObject1 = h(m);
                    y = ((l)localObject1);
                    break;
                  case 48: 
                  case 49: 
                  case 50: 
                  case 51: 
                  case 52: 
                  case 53: 
                  case 54: 
                  case 55: 
                  case 56: 
                  case 57: 
                    localObject1 = i(m);
                    y = ((l)localObject1);
                    break;
                  }
                }
                else
                {
                  N = N.b(L, M);
                  localObject1 = l.START_OBJECT;
                  y = ((l)localObject1);
                }
              }
              else
              {
                w();
                localObject1 = l.VALUE_TRUE;
                y = ((l)localObject1);
              }
            }
            else
            {
              v();
              localObject1 = l.VALUE_NULL;
              y = ((l)localObject1);
            }
          }
          else
          {
            u();
            localObject1 = l.VALUE_FALSE;
            y = ((l)localObject1);
          }
        }
        else
        {
          N = N.a(L, M);
          localObject1 = l.START_ARRAY;
          y = ((l)localObject1);
        }
      }
      else
      {
        localObject1 = x();
        y = ((l)localObject1);
      }
      return (l)localObject1;
    }
    int k = G;
    X = k;
    Object localObject3;
    int n;
    if (m != 34)
    {
      if ((m == 39) && (a(i.a.ALLOW_SINGLE_QUOTES)))
      {
        if ((G >= H) && (!s()))
        {
          a(": was expecting closing ''' for field name", l.FIELD_NAME);
          throw null;
        }
        localObject1 = Z;
        k = G;
        G = (k + 1);
        i = localObject1[k] & 0xFF;
        if (i != 39)
        {
          localObject1 = U;
          localObject3 = c0;
          m = 0;
          k = 0;
          j = 0;
          for (;;)
          {
            if (i == 39)
            {
              localObject2 = localObject1;
              i = k;
              if (m > 0)
              {
                localObject2 = localObject1;
                if (k >= localObject1.length)
                {
                  localObject2 = e.b.a.a.o.b.a((int[])localObject1, localObject1.length);
                  U = ((int[])localObject2);
                }
                localObject2[k] = c(j, m);
                i = k + 1;
              }
              localObject3 = T.b((int[])localObject2, i);
              localObject1 = localObject3;
              if (localObject3 != null) {
                break;
              }
              localObject1 = a((int[])localObject2, i, m);
              break;
            }
            n = i;
            localObject2 = localObject1;
            int i1 = m;
            int i2 = k;
            int i3 = j;
            if (localObject3[i] != 0)
            {
              n = i;
              localObject2 = localObject1;
              i1 = m;
              i2 = k;
              i3 = j;
              if (i != 34)
              {
                int i4;
                if (i != 92)
                {
                  b(i, "name");
                  i4 = i;
                }
                else
                {
                  i4 = k();
                }
                n = i4;
                localObject2 = localObject1;
                i1 = m;
                i2 = k;
                i3 = j;
                if (i4 > 127)
                {
                  localObject2 = localObject1;
                  n = m;
                  i = k;
                  i2 = j;
                  if (m >= 4)
                  {
                    localObject2 = localObject1;
                    if (k >= localObject1.length)
                    {
                      localObject2 = e.b.a.a.o.b.a((int[])localObject1, localObject1.length);
                      U = ((int[])localObject2);
                    }
                    localObject2[k] = j;
                    n = 0;
                    i2 = 0;
                    i = k + 1;
                  }
                  k = i2 << 8;
                  if (i4 < 2048)
                  {
                    j = i4 >> 6 | 0xC0 | k;
                    m = n + 1;
                    k = i;
                    localObject1 = localObject2;
                  }
                  for (;;)
                  {
                    break;
                    i2 = i4 >> 12 | 0xE0 | k;
                    n++;
                    j = i2;
                    localObject1 = localObject2;
                    m = n;
                    k = i;
                    if (n >= 4)
                    {
                      localObject1 = localObject2;
                      if (i >= localObject2.length)
                      {
                        localObject1 = e.b.a.a.o.b.a((int[])localObject2, localObject2.length);
                        U = ((int[])localObject1);
                      }
                      localObject1[i] = i2;
                      j = 0;
                      k = i + 1;
                      m = 0;
                    }
                    j = j << 8 | i4 >> 6 & 0x3F | 0x80;
                    m++;
                  }
                  n = i4 & 0x3F | 0x80;
                  i3 = j;
                  i2 = k;
                  i1 = m;
                  localObject2 = localObject1;
                }
              }
            }
            if (i1 < 4)
            {
              m = i1 + 1;
              j = n | i3 << 8;
              localObject1 = localObject2;
              k = i2;
            }
            else
            {
              localObject1 = localObject2;
              if (i2 >= localObject2.length)
              {
                localObject1 = e.b.a.a.o.b.a((int[])localObject2, localObject2.length);
                U = ((int[])localObject1);
              }
              localObject1[i2] = i3;
              m = 1;
              j = n;
              k = i2 + 1;
            }
            if ((G >= H) && (!s()))
            {
              a(" in field name", l.FIELD_NAME);
              throw null;
            }
            localObject2 = Z;
            i = G;
            G = (i + 1);
            i = localObject2[i] & 0xFF;
          }
        }
      }
      else
      {
        if (a(i.a.ALLOW_UNQUOTED_FIELD_NAMES))
        {
          localObject3 = e.b.a.a.p.a.f;
          if (localObject3[m] == 0)
          {
            localObject1 = U;
            n = 0;
            j = 0;
            k = 0;
            i = m;
            for (;;)
            {
              if (n < 4)
              {
                m = n + 1;
                k = i | k << 8;
              }
              else
              {
                localObject2 = localObject1;
                if (j >= localObject1.length)
                {
                  localObject2 = e.b.a.a.o.b.a((int[])localObject1, localObject1.length);
                  U = ((int[])localObject2);
                }
                localObject2[j] = k;
                k = i;
                j++;
                m = 1;
                localObject1 = localObject2;
              }
              if ((G >= H) && (!s()))
              {
                a(" in field name", l.FIELD_NAME);
                throw null;
              }
              localObject2 = Z;
              n = G;
              i = localObject2[n] & 0xFF;
              if (localObject3[i] != 0)
              {
                localObject2 = localObject1;
                i = j;
                if (m > 0)
                {
                  localObject2 = localObject1;
                  if (j >= localObject1.length)
                  {
                    localObject2 = e.b.a.a.o.b.a((int[])localObject1, localObject1.length);
                    U = ((int[])localObject2);
                  }
                  localObject2[j] = k;
                  i = j + 1;
                }
                localObject3 = T.b((int[])localObject2, i);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = a((int[])localObject2, i, m);
                }
                break;
              }
              G = (n + 1);
              n = m;
            }
          }
          a(m, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
          throw null;
        }
        a((char)c(m), "was expecting double-quote to start field name");
        throw null;
      }
    }
    else
    {
      m = H;
      if (k + 13 <= m) {
        break label2336;
      }
      if ((k >= m) && (!s()))
      {
        a(": was expecting closing '\"' for name", l.FIELD_NAME);
        throw null;
      }
      localObject1 = Z;
      k = G;
      G = (k + 1);
      k = localObject1[k] & 0xFF;
      if (k == 34) {
        break label3599;
      }
    }
    localObject1 = a(U, 0, 0, k, 0);
    for (;;)
    {
      break label3603;
      label2336:
      localObject2 = Z;
      localObject1 = c0;
      j = k + 1;
      G = j;
      m = localObject2[k] & 0xFF;
      if (localObject1[m] != 0) {
        break;
      }
      k = j + 1;
      G = k;
      j = localObject2[j] & 0xFF;
      if (localObject1[j] == 0)
      {
        j = m << 8 | j;
        m = k + 1;
        G = m;
        k = localObject2[k] & 0xFF;
        if (localObject1[k] == 0)
        {
          k = j << 8 | k;
          j = m + 1;
          G = j;
          m = localObject2[m] & 0xFF;
          if (localObject1[m] == 0)
          {
            k = k << 8 | m;
            i = j + 1;
            G = i;
            m = localObject2[j] & 0xFF;
            if (localObject1[m] == 0)
            {
              W = k;
              j = i + 1;
              G = j;
              i = localObject2[i] & 0xFF;
              if (localObject1[i] != 0)
              {
                if (i == 34) {
                  localObject1 = a(k, m, 1);
                } else {
                  localObject1 = b(k, m, i, 1);
                }
              }
              else
              {
                i |= m << 8;
                m = j + 1;
                G = m;
                j = localObject2[j] & 0xFF;
                if (localObject1[j] != 0)
                {
                  if (j == 34) {
                    localObject1 = a(k, i, 2);
                  } else {
                    localObject1 = b(k, i, j, 2);
                  }
                }
                else
                {
                  j = i << 8 | j;
                  i = m + 1;
                  G = i;
                  m = localObject2[m] & 0xFF;
                  if (localObject1[m] != 0)
                  {
                    if (m == 34) {
                      localObject1 = a(k, j, 3);
                    } else {
                      localObject1 = b(k, j, m, 3);
                    }
                  }
                  else
                  {
                    j = j << 8 | m;
                    n = i + 1;
                    G = n;
                    i = localObject2[i] & 0xFF;
                    if (localObject1[i] != 0)
                    {
                      if (i == 34) {
                        localObject1 = a(k, j, 4);
                      } else {
                        localObject1 = b(k, j, i, 4);
                      }
                    }
                    else
                    {
                      m = n + 1;
                      G = m;
                      n = localObject2[n] & 0xFF;
                      if (localObject1[n] != 0)
                      {
                        if (n == 34) {
                          localObject1 = a(k, j, i, 1);
                        } else {
                          localObject1 = a(k, j, i, n, 1);
                        }
                      }
                      else
                      {
                        n |= i << 8;
                        i = m + 1;
                        G = i;
                        m = localObject2[m] & 0xFF;
                        if (localObject1[m] != 0)
                        {
                          if (m == 34) {
                            localObject1 = a(k, j, n, 2);
                          } else {
                            localObject1 = a(k, j, n, m, 2);
                          }
                        }
                        else
                        {
                          n = n << 8 | m;
                          m = i + 1;
                          G = m;
                          i = localObject2[i] & 0xFF;
                          if (localObject1[i] != 0)
                          {
                            if (i == 34) {
                              localObject1 = a(k, j, n, 3);
                            } else {
                              localObject1 = a(k, j, n, i, 3);
                            }
                          }
                          else
                          {
                            i = n << 8 | i;
                            G = (m + 1);
                            m = localObject2[m] & 0xFF;
                            if (localObject1[m] != 0)
                            {
                              if (m == 34) {
                                localObject1 = a(k, j, i, 4);
                              } else {
                                localObject1 = a(k, j, i, m, 4);
                              }
                            }
                            else
                            {
                              localObject3 = U;
                              localObject3[0] = k;
                              localObject3[1] = j;
                              localObject3[2] = i;
                              for (k = 3;; k++)
                              {
                                i = G;
                                if (i + 4 > H) {
                                  break label3450;
                                }
                                j = i + 1;
                                G = j;
                                i = localObject2[i] & 0xFF;
                                if (localObject1[i] != 0)
                                {
                                  if (i == 34)
                                  {
                                    localObject1 = a(U, k, m, 1);
                                    break;
                                  }
                                  localObject1 = a(U, k, m, i, 1);
                                  break;
                                }
                                i |= m << 8;
                                m = j + 1;
                                G = m;
                                j = localObject2[j] & 0xFF;
                                if (localObject1[j] != 0)
                                {
                                  if (j == 34)
                                  {
                                    localObject1 = a(U, k, i, 2);
                                    break;
                                  }
                                  localObject1 = a(U, k, i, j, 2);
                                  break;
                                }
                                i = i << 8 | j;
                                j = m + 1;
                                G = j;
                                m = localObject2[m] & 0xFF;
                                if (localObject1[m] != 0)
                                {
                                  if (m == 34)
                                  {
                                    localObject1 = a(U, k, i, 3);
                                    break;
                                  }
                                  localObject1 = a(U, k, i, m, 3);
                                  break;
                                }
                                i = i << 8 | m;
                                G = (j + 1);
                                m = localObject2[j] & 0xFF;
                                if (localObject1[m] != 0)
                                {
                                  if (m == 34)
                                  {
                                    localObject1 = a(U, k, i, 4);
                                    break;
                                  }
                                  localObject1 = a(U, k, i, m, 4);
                                  break;
                                }
                                localObject3 = U;
                                if (k >= localObject3.length) {
                                  U = e.b.a.a.o.b.a((int[])localObject3, k);
                                }
                                U[k] = i;
                              }
                              label3450:
                              localObject1 = a(U, k, 0, m, 0);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            else if (m == 34)
            {
              localObject1 = b(k, 4);
            }
            else
            {
              localObject1 = b(k, m, 4);
            }
          }
          else if (m == 34)
          {
            localObject1 = b(k, 3);
          }
          else
          {
            localObject1 = b(k, m, 3);
          }
        }
        else if (k == 34)
        {
          localObject1 = b(j, 2);
        }
        else
        {
          localObject1 = b(j, k, 2);
        }
      }
      else if (j == 34)
      {
        localObject1 = b(m, 1);
      }
      else
      {
        localObject1 = b(m, j, 1);
      }
    }
    if (m == 34) {
      label3599:
      localObject1 = "";
    } else {
      label3603:
      localObject1 = b(0, m, 0);
    }
    N.a((String)localObject1);
    y = l.FIELD_NAME;
    k = G;
    if (k + 4 >= H)
    {
      k = a(false);
    }
    else
    {
      localObject1 = Z;
      m = localObject1[k];
      if (m == 58)
      {
        m = k + 1;
        G = m;
        k = localObject1[m];
        if (k > 32)
        {
          if ((k != 47) && (k != 35)) {
            G = (m + 1);
          } else {
            k = a(true);
          }
        }
        else
        {
          if ((k == 32) || (k == 9))
          {
            localObject1 = Z;
            m = G + 1;
            G = m;
            k = localObject1[m];
            if (k > 32)
            {
              if ((k != 47) && (k != 35))
              {
                G = (m + 1);
                break label4053;
              }
              k = a(true);
              break label4053;
            }
          }
          k = a(true);
        }
      }
      else
      {
        if (m != 32)
        {
          k = m;
          if (m != 9) {}
        }
        else
        {
          localObject1 = Z;
          k = G + 1;
          G = k;
          k = localObject1[k];
        }
        if (k == 58)
        {
          localObject1 = Z;
          m = G + 1;
          G = m;
          k = localObject1[m];
          if (k > 32)
          {
            if ((k != 47) && (k != 35)) {
              G = (m + 1);
            } else {
              k = a(true);
            }
          }
          else
          {
            if ((k == 32) || (k == 9))
            {
              localObject1 = Z;
              m = G + 1;
              G = m;
              k = localObject1[m];
              if (k > 32)
              {
                if ((k != 47) && (k != 35))
                {
                  G = (m + 1);
                  break label4053;
                }
                k = a(true);
                break label4053;
              }
            }
            k = a(true);
          }
        }
        else
        {
          k = a(false);
        }
      }
    }
    label4053:
    H();
    if (k == 34)
    {
      V = true;
      O = l.VALUE_STRING;
      return y;
    }
    if (k != 45)
    {
      if (k != 91)
      {
        if (k != 102)
        {
          if (k != 110)
          {
            if (k != 116)
            {
              if (k != 123) {
                switch (k)
                {
                default: 
                  localObject1 = h(k);
                  break;
                case 48: 
                case 49: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                  localObject1 = i(k);
                  break;
                }
              } else {
                localObject1 = l.START_OBJECT;
              }
            }
            else
            {
              w();
              localObject1 = l.VALUE_TRUE;
            }
          }
          else
          {
            v();
            localObject1 = l.VALUE_NULL;
          }
        }
        else
        {
          u();
          localObject1 = l.VALUE_FALSE;
        }
      }
      else {
        localObject1 = l.START_ARRAY;
      }
    }
    else {
      localObject1 = x();
    }
    O = ((l)localObject1);
    return y;
  }
  
  public final int g(int paramInt)
  {
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    int j = i + 1;
    G = j;
    i = arrayOfByte[i];
    if ((i & 0xC0) == 128)
    {
      if (j >= H) {
        t();
      }
      arrayOfByte = Z;
      j = G;
      int k = j + 1;
      G = k;
      j = arrayOfByte[j];
      if ((j & 0xC0) == 128)
      {
        if (k >= H) {
          t();
        }
        arrayOfByte = Z;
        int m = G;
        k = m + 1;
        G = k;
        m = arrayOfByte[m];
        if ((m & 0xC0) == 128) {
          return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | m & 0x3F) - 65536;
        }
        a(m & 0xFF, k);
        throw null;
      }
      a(j & 0xFF, k);
      throw null;
    }
    a(i & 0xFF, j);
    throw null;
  }
  
  public l h(int paramInt)
  {
    Object localObject1;
    if (paramInt != 39)
    {
      if (paramInt != 73)
      {
        if (paramInt != 78)
        {
          if (paramInt != 93)
          {
            if (paramInt == 125) {
              break label142;
            }
            if (paramInt != 43)
            {
              if (paramInt != 44) {
                break label619;
              }
            }
            else
            {
              if ((G >= H) && (!s()))
              {
                a(l.VALUE_NUMBER_INT);
                throw null;
              }
              localObject1 = Z;
              paramInt = G;
              G = (paramInt + 1);
              return a(localObject1[paramInt] & 0xFF, false);
            }
          }
          else
          {
            if (!N.b()) {
              break label619;
            }
          }
          if (a(i.a.ALLOW_MISSING_VALUES))
          {
            G -= 1;
            return l.VALUE_NULL;
          }
          label142:
          a(paramInt, "expected a value");
          throw null;
        }
        else
        {
          a("NaN", 1);
          if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS)) {
            return a("NaN", NaN.0D);
          }
          throw a("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
      else
      {
        a("Infinity", 1);
        if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS)) {
          return a("Infinity", Double.POSITIVE_INFINITY);
        }
        throw a("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }
    }
    else if (a(i.a.ALLOW_SINGLE_QUOTES))
    {
      Object localObject2 = P.c();
      int[] arrayOfInt = b0;
      byte[] arrayOfByte = Z;
      paramInt = 0;
      for (;;)
      {
        if (G >= H) {
          t();
        }
        int i = paramInt;
        localObject1 = localObject2;
        if (paramInt >= localObject2.length)
        {
          localObject1 = P.f();
          i = 0;
        }
        paramInt = H;
        int j = G;
        int k = localObject1.length - i + j;
        j = i;
        int m = paramInt;
        if (k < paramInt) {
          m = k;
        }
        for (j = i;; j++)
        {
          i = G;
          paramInt = j;
          localObject2 = localObject1;
          if (i >= m) {
            break;
          }
          G = (i + 1);
          paramInt = arrayOfByte[i] & 0xFF;
          if ((paramInt == 39) || (arrayOfInt[paramInt] != 0)) {
            break label401;
          }
          localObject1[j] = ((char)(char)paramInt);
        }
        label401:
        if (paramInt == 39)
        {
          P.i = j;
          return l.VALUE_STRING;
        }
        i = arrayOfInt[paramInt];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (paramInt < 32) {
                  b(paramInt, "string value");
                }
                j(paramInt);
                throw null;
              }
              i = g(paramInt);
              paramInt = j + 1;
              localObject1[j] = ((char)(char)(0xD800 | i >> 10));
              if (paramInt >= localObject1.length)
              {
                localObject1 = P.f();
                j = 0;
              }
              else
              {
                j = paramInt;
              }
              paramInt = i & 0x3FF | 0xDC00;
            }
            else if (H - G >= 2)
            {
              paramInt = f(paramInt);
            }
            else
            {
              paramInt = e(paramInt);
            }
          }
          else {
            paramInt = d(paramInt);
          }
        }
        else {
          paramInt = k();
        }
        i = j;
        localObject2 = localObject1;
        if (j >= localObject1.length)
        {
          localObject2 = P.f();
          i = 0;
        }
        localObject2[i] = ((char)(char)paramInt);
        paramInt = i + 1;
      }
    }
    label619:
    if (Character.isJavaIdentifierStart(paramInt))
    {
      localObject1 = e.a.a.a.a.a("");
      ((StringBuilder)localObject1).append((char)paramInt);
      a(((StringBuilder)localObject1).toString(), "('true', 'false' or 'null')");
      throw null;
    }
    a(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
    throw null;
  }
  
  public l i(int paramInt)
  {
    char[] arrayOfChar = P.c();
    int i = paramInt;
    if (paramInt == 48) {
      i = I();
    }
    arrayOfChar[0] = ((char)(char)i);
    int j = Math.min(H, G + arrayOfChar.length - 1);
    paramInt = 1;
    i = 1;
    int k;
    for (;;)
    {
      k = G;
      if (k >= j) {
        return a(arrayOfChar, paramInt, false, i);
      }
      byte[] arrayOfByte = Z;
      G = (k + 1);
      k = arrayOfByte[k] & 0xFF;
      if ((k < 48) || (k > 57)) {
        break;
      }
      i++;
      arrayOfChar[paramInt] = ((char)(char)k);
      paramInt++;
    }
    if ((k != 46) && (k != 101) && (k != 69))
    {
      G -= 1;
      P.i = paramInt;
      if (N.d()) {
        m(k);
      }
      return l.VALUE_NUMBER_INT;
    }
    return a(arrayOfChar, paramInt, k, false, i);
  }
  
  public String i()
  {
    Object localObject = y;
    if (localObject == l.VALUE_STRING)
    {
      if (V)
      {
        V = false;
        return r();
      }
      return P.b();
    }
    if (localObject == null)
    {
      localObject = null;
    }
    else
    {
      int i = ((l)localObject).id();
      if (i != 5)
      {
        if ((i != 6) && (i != 7) && (i != 8)) {
          localObject = ((l)localObject).asString();
        } else {
          localObject = P.b();
        }
      }
      else {
        localObject = N.f;
      }
    }
    return (String)localObject;
  }
  
  public void j()
  {
    if (Y != null)
    {
      if ((E.c) || (a(i.a.AUTO_CLOSE_SOURCE))) {
        Y.close();
      }
      Y = null;
    }
  }
  
  public void j(int paramInt)
  {
    if (paramInt < 32)
    {
      a(paramInt);
      throw null;
    }
    k(paramInt);
    throw null;
  }
  
  public char k()
  {
    if ((G >= H) && (!s()))
    {
      a(" in character escape sequence", l.VALUE_STRING);
      throw null;
    }
    byte[] arrayOfByte = Z;
    int i = G;
    G = (i + 1);
    i = arrayOfByte[i];
    if ((i != 34) && (i != 47) && (i != 92))
    {
      if (i != 98)
      {
        if (i != 102)
        {
          if (i != 110)
          {
            if (i != 114)
            {
              if (i != 116)
              {
                if (i != 117)
                {
                  char c = (char)c(i);
                  a(c);
                  return c;
                }
                int j = 0;
                i = 0;
                while (j < 4)
                {
                  if ((G >= H) && (!s()))
                  {
                    a(" in character escape sequence", l.VALUE_STRING);
                    throw null;
                  }
                  arrayOfByte = Z;
                  int k = G;
                  G = (k + 1);
                  int m = arrayOfByte[k];
                  if (m > 127) {
                    k = -1;
                  } else {
                    k = e.b.a.a.p.a.i[m];
                  }
                  if (k >= 0)
                  {
                    i = i << 4 | k;
                    j++;
                  }
                  else
                  {
                    a(m, "expected a hex-digit for character escape sequence");
                    throw null;
                  }
                }
                return (char)i;
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
    return (char)i;
  }
  
  public void k(int paramInt)
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Invalid UTF-8 start byte 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw a(localStringBuilder.toString());
  }
  
  public void l(int paramInt)
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Invalid UTF-8 middle byte 0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw a(localStringBuilder.toString());
  }
  
  public final void m(int paramInt)
  {
    int i = G + 1;
    G = i;
    if (paramInt != 9) {
      if (paramInt != 10)
      {
        if (paramInt != 13)
        {
          if (paramInt != 32)
          {
            a(paramInt, "Expected space separating root-level values");
            throw null;
          }
        }
        else {
          y();
        }
      }
      else
      {
        J += 1;
        K = i;
      }
    }
  }
  
  public void o()
  {
    super.o();
    e.b.a.a.r.a locala1 = T;
    e.b.a.a.r.a locala2 = a;
    Object localObject;
    if ((locala2 != null) && ((p ^ true)))
    {
      localObject = new a.a(locala1);
      int i = b;
      a.a locala = (a.a)b.get();
      if (i != b)
      {
        if (i > 6000) {
          localObject = a.a.a(64);
        }
        b.compareAndSet(locala, localObject);
      }
      p = true;
    }
    if (a0)
    {
      localObject = Z;
      if (localObject != null)
      {
        Z = e.b.a.a.o.c.z;
        E.a((byte[])localObject);
      }
    }
  }
  
  public final void p()
  {
    H();
    if (N.b())
    {
      N = N.c;
      return;
    }
    a(93, '}');
    throw null;
  }
  
  public final void q()
  {
    H();
    if (N.c())
    {
      N = N.c;
      return;
    }
    a(125, ']');
    throw null;
  }
  
  public String r()
  {
    int i = G;
    int j = i;
    if (i >= H)
    {
      t();
      j = G;
    }
    Object localObject1 = P.c();
    int[] arrayOfInt = b0;
    int k = Math.min(H, localObject1.length + j);
    Object localObject2 = Z;
    int m;
    for (i = 0; j < k; i++)
    {
      m = localObject2[j] & 0xFF;
      if (arrayOfInt[m] != 0)
      {
        if (m != 34) {
          break;
        }
        G = (j + 1);
        localObject1 = P;
        i = i;
        if (g > 0)
        {
          localObject2 = ((e.b.a.a.s.g)localObject1).b();
        }
        else
        {
          if (i == 0) {
            localObject2 = "";
          } else {
            localObject2 = new String(h, 0, i);
          }
          j = ((String)localObject2);
        }
        return (String)localObject2;
      }
      j++;
      localObject1[i] = ((char)(char)m);
    }
    G = j;
    arrayOfInt = b0;
    byte[] arrayOfByte = Z;
    for (;;)
    {
      k = G;
      j = k;
      if (k >= H)
      {
        t();
        j = G;
      }
      localObject2 = localObject1;
      k = i;
      if (i >= localObject1.length)
      {
        localObject2 = P.f();
        k = 0;
      }
      m = Math.min(H, localObject2.length - k + j);
      for (i = k;; i++)
      {
        if (j >= m) {
          break label533;
        }
        k = j + 1;
        j = arrayOfByte[j] & 0xFF;
        if (arrayOfInt[j] != 0)
        {
          G = k;
          if (j == 34)
          {
            localObject2 = P;
            i = i;
            return ((e.b.a.a.s.g)localObject2).b();
          }
          m = arrayOfInt[j];
          if (m != 1)
          {
            if (m != 2)
            {
              if (m != 3)
              {
                if (m != 4)
                {
                  if (j < 32)
                  {
                    b(j, "string value");
                  }
                  else
                  {
                    j(j);
                    throw null;
                  }
                }
                else
                {
                  k = g(j);
                  j = i + 1;
                  localObject2[i] = ((char)(char)(0xD800 | k >> 10));
                  if (j >= localObject2.length)
                  {
                    localObject2 = P.f();
                    i = 0;
                  }
                  else
                  {
                    i = j;
                  }
                  j = k & 0x3FF | 0xDC00;
                }
              }
              else if (H - k >= 2) {
                j = f(j);
              } else {
                j = e(j);
              }
            }
            else {
              j = d(j);
            }
          }
          else {
            j = k();
          }
          localObject1 = localObject2;
          k = i;
          if (i >= localObject2.length)
          {
            localObject1 = P.f();
            k = 0;
          }
          localObject1[k] = ((char)(char)j);
          i = k + 1;
          break;
        }
        localObject2[i] = ((char)(char)j);
        j = k;
      }
      label533:
      G = j;
      localObject1 = localObject2;
    }
  }
  
  public final boolean s()
  {
    int i = H;
    I += i;
    K -= i;
    X -= i;
    InputStream localInputStream = Y;
    if (localInputStream != null)
    {
      Object localObject = Z;
      i = localObject.length;
      if (i == 0) {
        return false;
      }
      i = localInputStream.read((byte[])localObject, 0, i);
      if (i > 0)
      {
        G = 0;
        H = i;
        return true;
      }
      j();
      if (i == 0)
      {
        localObject = e.a.a.a.a.a("InputStream.read() returned 0 characters when trying to read ");
        ((StringBuilder)localObject).append(Z.length);
        ((StringBuilder)localObject).append(" bytes");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void t()
  {
    if (s()) {
      return;
    }
    h();
    throw null;
  }
  
  public final void u()
  {
    int i = G;
    if (i + 4 < H)
    {
      byte[] arrayOfByte = Z;
      int j = i + 1;
      if (arrayOfByte[i] == 97)
      {
        i = j + 1;
        if (arrayOfByte[j] == 108)
        {
          j = i + 1;
          if (arrayOfByte[i] == 115)
          {
            i = j + 1;
            if (arrayOfByte[j] == 101)
            {
              j = arrayOfByte[i] & 0xFF;
              if ((j < 48) || (j == 93) || (j == 125))
              {
                G = i;
                return;
              }
            }
          }
        }
      }
    }
    b("false", 1);
  }
  
  public final void v()
  {
    int i = G;
    if (i + 3 < H)
    {
      byte[] arrayOfByte = Z;
      int j = i + 1;
      if (arrayOfByte[i] == 117)
      {
        i = j + 1;
        if (arrayOfByte[j] == 108)
        {
          j = i + 1;
          if (arrayOfByte[i] == 108)
          {
            i = arrayOfByte[j] & 0xFF;
            if ((i < 48) || (i == 93) || (i == 125))
            {
              G = j;
              return;
            }
          }
        }
      }
    }
    b("null", 1);
  }
  
  public final void w()
  {
    int i = G;
    if (i + 3 < H)
    {
      byte[] arrayOfByte = Z;
      int j = i + 1;
      if (arrayOfByte[i] == 114)
      {
        i = j + 1;
        if (arrayOfByte[j] == 117)
        {
          j = i + 1;
          if (arrayOfByte[i] == 101)
          {
            i = arrayOfByte[j] & 0xFF;
            if ((i < 48) || (i == 93) || (i == 125))
            {
              G = j;
              return;
            }
          }
        }
      }
    }
    b("true", 1);
  }
  
  public l x()
  {
    char[] arrayOfChar = P.c();
    arrayOfChar[0] = ((char)45);
    if (G >= H) {
      t();
    }
    byte[] arrayOfByte = Z;
    int i = G;
    G = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    if (j <= 48)
    {
      if (j != 48) {
        return a(j, true);
      }
      i = I();
    }
    else
    {
      i = j;
      if (j > 57) {
        return a(j, true);
      }
    }
    j = 2;
    arrayOfChar[1] = ((char)(char)i);
    int k = Math.min(H, G + arrayOfChar.length - 2);
    i = 1;
    int m;
    for (;;)
    {
      m = G;
      if (m >= k) {
        return a(arrayOfChar, j, true, i);
      }
      arrayOfByte = Z;
      G = (m + 1);
      m = arrayOfByte[m] & 0xFF;
      if ((m < 48) || (m > 57)) {
        break;
      }
      i++;
      arrayOfChar[j] = ((char)(char)m);
      j++;
    }
    if ((m != 46) && (m != 101) && (m != 69))
    {
      G -= 1;
      P.i = j;
      if (N.d()) {
        m(m);
      }
      return l.VALUE_NUMBER_INT;
    }
    return a(arrayOfChar, j, m, true, i);
  }
  
  public final void y()
  {
    if ((G < H) || (s()))
    {
      byte[] arrayOfByte = Z;
      int i = G;
      if (arrayOfByte[i] == 10) {
        G = (i + 1);
      }
    }
    J += 1;
    K = G;
  }
  
  public final void z()
  {
    if (a(i.a.ALLOW_COMMENTS))
    {
      if ((G >= H) && (!s()))
      {
        a(" in a comment", null);
        throw null;
      }
      Object localObject = Z;
      int i = G;
      G = (i + 1);
      i = localObject[i] & 0xFF;
      if (i == 47)
      {
        A();
      }
      else
      {
        if (i != 42) {
          break label296;
        }
        localObject = e.b.a.a.p.a.g;
      }
      for (;;)
      {
        int j;
        if ((G < H) || (s()))
        {
          arrayOfByte = Z;
          j = G;
          i = j + 1;
          G = i;
          j = arrayOfByte[j] & 0xFF;
          int k = localObject[j];
          if (k == 0) {
            continue;
          }
          if (k == 2) {
            break label289;
          }
          if (k == 3) {
            break label282;
          }
          if (k == 4) {
            break label275;
          }
          if (k == 10) {
            break label257;
          }
          if (k == 13) {
            break label250;
          }
          if (k != 42) {
            break label242;
          }
          if ((i < H) || (s())) {}
        }
        else
        {
          a(" in a comment", null);
          throw null;
        }
        byte[] arrayOfByte = Z;
        i = G;
        if (arrayOfByte[i] == 47)
        {
          G = (i + 1);
          return;
          label242:
          j(j);
          throw null;
          label250:
          y();
          continue;
          label257:
          J += 1;
          K = i;
          continue;
          label275:
          D();
          continue;
          label282:
          C();
          continue;
          label289:
          B();
        }
      }
      label296:
      a(i, "was expecting either '*' or '/' for a comment");
      throw null;
    }
    a(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    throw null;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */