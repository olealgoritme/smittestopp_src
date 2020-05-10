package e.b.a.a.q;

import e.b.a.a.i;
import e.b.a.a.i.a;
import e.b.a.a.k;
import e.b.a.a.l;
import e.b.a.a.r.b.a;
import e.b.a.a.r.b.b;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicReference;

public class f
  extends e.b.a.a.o.b
{
  public static final int a0 = i.a.ALLOW_TRAILING_COMMA.getMask();
  public static final int[] b0 = e.b.a.a.p.a.c;
  public Reader T;
  public char[] U;
  public boolean V;
  public final e.b.a.a.r.b W;
  public final int X;
  public boolean Y;
  public long Z;
  
  public f(e.b.a.a.p.b paramb, int paramInt, Reader paramReader, e.b.a.a.r.b paramb1)
  {
    super(paramb, paramInt);
    T = paramReader;
    paramb.a(g);
    paramReader = d.a(0, 0);
    g = paramReader;
    U = paramReader;
    G = 0;
    H = 0;
    W = paramb1;
    X = c;
    V = true;
  }
  
  public f(e.b.a.a.p.b paramb, int paramInt1, Reader paramReader, e.b.a.a.r.b paramb1, char[] paramArrayOfChar, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramb, paramInt1);
    T = paramReader;
    U = paramArrayOfChar;
    G = paramInt2;
    H = paramInt3;
    W = paramb1;
    X = c;
    V = paramBoolean;
  }
  
  public final int a(boolean paramBoolean)
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!q()))
        {
          localObject = e.a.a.a.a.a(" within/between ");
          ((StringBuilder)localObject).append(N.e());
          ((StringBuilder)localObject).append(" entries");
          a(((StringBuilder)localObject).toString(), null);
          throw null;
        }
        Object localObject = U;
        i = G;
        int j = i + 1;
        G = j;
        i = localObject[i];
        if (i > 32)
        {
          if (i == 47)
          {
            u();
          }
          else if ((i != 35) || (!x()))
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
        else if (i < 32) {
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
            t();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final l a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i = H;
    int j = 0;
    int k = 0;
    paramInt4 = paramInt1;
    int m = paramInt3;
    char[] arrayOfChar;
    if (paramInt1 == 46)
    {
      paramInt1 = 0;
      paramInt4 = paramInt3;
      paramInt3 = paramInt1;
      for (;;)
      {
        if (paramInt4 >= i) {
          return a(paramBoolean, paramInt2);
        }
        arrayOfChar = U;
        paramInt1 = paramInt4 + 1;
        paramInt4 = arrayOfChar[paramInt4];
        if ((paramInt4 < 48) || (paramInt4 > 57)) {
          break;
        }
        paramInt3++;
        paramInt4 = paramInt1;
      }
      if (paramInt3 != 0)
      {
        m = paramInt1;
      }
      else
      {
        c(paramInt4, "Decimal point not followed by a digit");
        throw null;
      }
    }
    if (paramInt4 != 101)
    {
      paramInt3 = paramInt4;
      paramInt1 = m;
      if (paramInt4 != 69) {}
    }
    else
    {
      if (m >= i)
      {
        G = paramInt2;
        return a(paramBoolean, paramInt2);
      }
      arrayOfChar = U;
      int n = m + 1;
      m = arrayOfChar[m];
      if (m != 45)
      {
        paramInt1 = k;
        paramInt4 = n;
        paramInt3 = m;
        if (m == 43) {}
      }
      for (;;)
      {
        m = paramInt1;
        paramInt1 = paramInt4;
        break label246;
        if (n >= i)
        {
          G = paramInt2;
          return a(paramBoolean, paramInt2);
        }
        arrayOfChar = U;
        paramInt1 = n + 1;
        paramInt3 = arrayOfChar[n];
        m = j;
        label246:
        if ((paramInt3 > 57) || (paramInt3 < 48)) {
          break;
        }
        m++;
        if (paramInt1 >= i)
        {
          G = paramInt2;
          return a(paramBoolean, paramInt2);
        }
        arrayOfChar = U;
        paramInt4 = paramInt1 + 1;
        paramInt3 = arrayOfChar[paramInt1];
        paramInt1 = m;
      }
      if (m == 0) {
        break label349;
      }
    }
    paramInt1--;
    G = paramInt1;
    if (N.d()) {
      d(paramInt3);
    }
    P.a(U, paramInt2, paramInt1 - paramInt2);
    return l.VALUE_NUMBER_FLOAT;
    label349:
    c(paramInt3, "Exponent indicator not followed by a digit");
    throw null;
  }
  
  public l a(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt == 73)
    {
      if ((G >= H) && (!q()))
      {
        a(l.VALUE_NUMBER_INT);
        throw null;
      }
      Object localObject = U;
      paramInt = G;
      G = (paramInt + 1);
      paramInt = localObject[paramInt];
      double d = Double.NEGATIVE_INFINITY;
      StringBuilder localStringBuilder;
      if (paramInt == 78)
      {
        if (paramBoolean) {
          localObject = "-INF";
        } else {
          localObject = "+INF";
        }
        a((String)localObject, 3);
        if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS))
        {
          if (!paramBoolean) {
            d = Double.POSITIVE_INFINITY;
          }
          return a((String)localObject, d);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Non-standard token '");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        throw a(localStringBuilder.toString());
      }
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean) {
          localObject = "-Infinity";
        } else {
          localObject = "+Infinity";
        }
        a((String)localObject, 3);
        if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS))
        {
          if (!paramBoolean) {
            d = Double.POSITIVE_INFINITY;
          }
          return a((String)localObject, d);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Non-standard token '");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        throw a(localStringBuilder.toString());
      }
    }
    c(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    throw null;
  }
  
  public final l a(boolean paramBoolean, int paramInt)
  {
    int i = paramInt;
    if (paramBoolean) {
      i = paramInt + 1;
    }
    G = i;
    Object localObject1 = P.c();
    int j = 0;
    int k;
    if (paramBoolean)
    {
      localObject1[0] = ((char)45);
      k = 1;
    }
    else
    {
      k = 0;
    }
    paramInt = G;
    if (paramInt < H)
    {
      localObject2 = U;
      G = (paramInt + 1);
      i = localObject2[paramInt];
    }
    else
    {
      i = b("No digit following minus sign", l.VALUE_NUMBER_INT);
    }
    paramInt = i;
    if (i == 48)
    {
      paramInt = G;
      if (paramInt < H)
      {
        paramInt = U[paramInt];
        if ((paramInt < 48) || (paramInt > 57)) {}
      }
      else if ((G < H) || (q()))
      {
        i = U[G];
        if ((i >= 48) && (i <= 57))
        {
          if (a(i.a.ALLOW_NUMERIC_LEADING_ZEROS))
          {
            G += 1;
            paramInt = i;
            if (i != 48) {
              break label317;
            }
            paramInt = i;
            do
            {
              if ((G >= H) && (!q())) {
                break label317;
              }
              localObject2 = U;
              paramInt = G;
              i = localObject2[paramInt];
              if ((i < 48) || (i > 57)) {
                break;
              }
              G = (paramInt + 1);
              paramInt = i;
            } while (i == 48);
            paramInt = i;
            break label317;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Invalid numeric value: ");
          ((StringBuilder)localObject2).append("Leading zeroes not allowed");
          throw a(((StringBuilder)localObject2).toString());
        }
      }
      paramInt = 48;
    }
    label317:
    int m = 0;
    i = paramInt;
    int n;
    while ((i >= 48) && (i <= 57))
    {
      m++;
      n = k;
      localObject2 = localObject1;
      if (k >= localObject1.length)
      {
        localObject2 = P.f();
        n = 0;
      }
      paramInt = n + 1;
      localObject2[n] = ((char)i);
      if ((G >= H) && (!q()))
      {
        i = 0;
        n = 1;
        k = paramInt;
        paramInt = n;
        break label448;
      }
      localObject1 = U;
      i = G;
      G = (i + 1);
      i = localObject1[i];
      k = paramInt;
      localObject1 = localObject2;
    }
    paramInt = 0;
    Object localObject2 = localObject1;
    label448:
    if (m == 0) {
      return a(i, paramBoolean);
    }
    int i1;
    if (i == 46)
    {
      m = k;
      localObject1 = localObject2;
      if (k >= localObject2.length)
      {
        localObject1 = P.f();
        m = 0;
      }
      localObject1[m] = ((char)i);
      k = m + 1;
      m = 0;
      for (localObject2 = localObject1;; localObject2 = localObject1)
      {
        if ((G >= H) && (!q()))
        {
          n = 1;
          break;
        }
        localObject1 = U;
        i = G;
        G = (i + 1);
        i1 = localObject1[i];
        i = i1;
        n = paramInt;
        if (i1 < 48) {
          break;
        }
        if (i1 > 57)
        {
          i = i1;
          n = paramInt;
          break;
        }
        m++;
        i = k;
        localObject1 = localObject2;
        if (k >= localObject2.length)
        {
          localObject1 = P.f();
          i = 0;
        }
        localObject1[i] = ((char)i1);
        k = i + 1;
        i = i1;
      }
      if (m != 0)
      {
        paramInt = n;
        n = m;
        localObject1 = localObject2;
      }
      else
      {
        c(i, "Decimal point not followed by a digit");
        throw null;
      }
    }
    else
    {
      n = 0;
      localObject1 = localObject2;
    }
    int i2;
    if (i != 101)
    {
      i2 = k;
      i1 = i;
      m = paramInt;
      if (i != 69) {}
    }
    else
    {
      m = k;
      localObject2 = localObject1;
      if (k >= localObject1.length)
      {
        localObject2 = P.f();
        m = 0;
      }
      i1 = m + 1;
      localObject2[m] = ((char)i);
      i = G;
      if (i < H)
      {
        localObject1 = U;
        G = (i + 1);
        k = localObject1[i];
      }
      else
      {
        k = b("expected a digit for number exponent", null);
      }
      if (k != 45)
      {
        m = k;
        i = i1;
        localObject1 = localObject2;
        if (k != 43) {}
      }
      else
      {
        i = i1;
        localObject1 = localObject2;
        if (i1 >= localObject2.length)
        {
          localObject1 = P.f();
          i = 0;
        }
        localObject1[i] = ((char)k);
        k = G;
        if (k < H)
        {
          localObject2 = U;
          G = (k + 1);
          k = localObject2[k];
        }
        else
        {
          k = b("expected a digit for number exponent", null);
        }
        i++;
        m = k;
      }
      k = m;
      m = 0;
      while ((k <= 57) && (k >= 48))
      {
        m++;
        i1 = i;
        localObject2 = localObject1;
        if (i >= localObject1.length)
        {
          localObject2 = P.f();
          i1 = 0;
        }
        i = i1 + 1;
        localObject2[i1] = ((char)k);
        if ((G >= H) && (!q()))
        {
          paramInt = m;
          m = 1;
          break label1031;
        }
        localObject1 = U;
        k = G;
        G = (k + 1);
        k = localObject1[k];
        localObject1 = localObject2;
      }
      i1 = m;
      m = paramInt;
      paramInt = i1;
      label1031:
      if (paramInt == 0) {
        break label1113;
      }
      i1 = k;
      i2 = i;
      j = paramInt;
    }
    if (m == 0)
    {
      G -= 1;
      if (N.d()) {
        d(i1);
      }
    }
    P.i = i2;
    if ((n < 1) && (j < 1)) {
      localObject2 = l.VALUE_NUMBER_INT;
    } else {
      localObject2 = l.VALUE_NUMBER_FLOAT;
    }
    return (l)localObject2;
    label1113:
    c(k, "Exponent indicator not followed by a digit");
    throw null;
  }
  
  public final String a(int paramInt1, int paramInt2, int paramInt3)
  {
    P.a(U, paramInt1, G - paramInt1);
    Object localObject = P.g();
    paramInt1 = P.i;
    int i = 0;
    for (;;)
    {
      if ((G >= H) && (!q()))
      {
        a(" in field name", l.FIELD_NAME);
        throw null;
      }
      char[] arrayOfChar = U;
      int j = G;
      G = (j + 1);
      int k = arrayOfChar[j];
      j = k;
      if (k <= 92) {
        if (k == 92)
        {
          j = k();
        }
        else
        {
          j = k;
          if (k <= paramInt3)
          {
            if (k == paramInt3)
            {
              localObject = P;
              i = paramInt1;
              arrayOfChar = ((e.b.a.a.s.g)localObject).h();
              paramInt3 = c;
              paramInt1 = i;
              if (paramInt3 >= 0) {
                paramInt1 = paramInt3;
              }
              paramInt3 = ((e.b.a.a.s.g)localObject).j();
              return W.a(arrayOfChar, paramInt1, paramInt3, paramInt2);
            }
            j = k;
            if (k < 32)
            {
              b(k, "name");
              j = k;
            }
          }
        }
      }
      paramInt2 = paramInt2 * 33 + j;
      k = paramInt1 + 1;
      localObject[paramInt1] = ((char)j);
      if (k >= localObject.length)
      {
        localObject = P.f();
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = k;
      }
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = paramInt;
    int k;
    if (G + i >= H)
    {
      i = paramString.length();
      while (((G < H) || (q())) && (U[G] == paramString.charAt(paramInt)))
      {
        k = G + 1;
        G = k;
        j = paramInt + 1;
        paramInt = j;
        if (j >= i)
        {
          if ((k < H) || (q()))
          {
            paramInt = U[G];
            if ((paramInt >= 48) && (paramInt != 93) && (paramInt != 125)) {
              a(paramString, j, paramInt);
            }
          }
          return;
        }
      }
      c(paramString.substring(0, paramInt));
      throw null;
    }
    while (U[G] == paramString.charAt(j))
    {
      k = G + 1;
      G = k;
      paramInt = j + 1;
      j = paramInt;
      if (paramInt >= i)
      {
        j = U[k];
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
    if (!Character.isJavaIdentifierPart((char)paramInt2)) {
      return;
    }
    c(paramString.substring(0, paramInt1));
    throw null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(paramString1);
    while ((G < H) || (q()))
    {
      char c = U[G];
      if (Character.isJavaIdentifierPart(c))
      {
        G += 1;
        paramString1.append(c);
        if (paramString1.length() >= 256) {
          paramString1.append("...");
        }
      }
    }
    a("Unrecognized token '%s': was expecting %s", paramString1, paramString2);
    throw null;
  }
  
  public byte[] a(e.b.a.a.a parama)
  {
    Object localObject;
    if (y == l.VALUE_EMBEDDED_OBJECT)
    {
      localObject = S;
      if (localObject != null) {
        return (byte[])localObject;
      }
    }
    if (y == l.VALUE_STRING)
    {
      if (Y)
      {
        try
        {
          S = b(parama);
          Y = false;
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
        localObject = m();
        String str = i();
        try
        {
          parama.a(str, (e.b.a.a.s.c)localObject);
          S = ((e.b.a.a.s.c)localObject).c();
        }
        catch (IllegalArgumentException parama)
        {
          throw a(parama.getMessage());
        }
      }
      return S;
    }
    parama = e.a.a.a.a.a("Current token (");
    parama.append(y);
    parama.append(") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    throw a(parama.toString());
  }
  
  public char b(String paramString, l paraml)
  {
    if ((G >= H) && (!q()))
    {
      a(paramString, paraml);
      throw null;
    }
    paramString = U;
    int i = G;
    G = (i + 1);
    return paramString[i];
  }
  
  public e.b.a.a.g b()
  {
    int i = G;
    int j = K;
    Object localObject = n();
    long l = I;
    return new e.b.a.a.g(localObject, -1L, G + l, J, i - j + 1);
  }
  
  public final String b(String paramString)
  {
    l locall = y;
    if (locall == l.VALUE_STRING)
    {
      if (Y)
      {
        Y = false;
        p();
      }
      return P.b();
    }
    if (locall == l.FIELD_NAME) {
      return c();
    }
    return super.b(paramString);
  }
  
  public byte[] b(e.b.a.a.a parama)
  {
    Object localObject = m();
    for (;;)
    {
      if (G >= H) {
        r();
      }
      char[] arrayOfChar = U;
      int i = G;
      G = (i + 1);
      char c = arrayOfChar[i];
      if (c > ' ')
      {
        int j = parama.a(c);
        i = j;
        if (j < 0)
        {
          if (c == '"') {
            return ((e.b.a.a.s.c)localObject).c();
          }
          j = a(parama, c, 0);
          i = j;
          if (j < 0) {}
        }
        else
        {
          if (G >= H) {
            r();
          }
          arrayOfChar = U;
          j = G;
          G = (j + 1);
          c = arrayOfChar[j];
          int k = parama.a(c);
          j = k;
          if (k < 0) {
            j = a(parama, c, 1);
          }
          int m = i << 6 | j;
          if (G >= H) {
            r();
          }
          arrayOfChar = U;
          i = G;
          G = (i + 1);
          c = arrayOfChar[i];
          k = parama.a(c);
          j = k;
          if (k < 0)
          {
            i = k;
            if (k != -2)
            {
              if ((c == '"') && (!B))
              {
                ((e.b.a.a.s.c)localObject).a(m >> 4);
                return ((e.b.a.a.s.c)localObject).c();
              }
              i = a(parama, c, 2);
            }
            j = i;
            if (i == -2)
            {
              if (G >= H) {
                r();
              }
              arrayOfChar = U;
              i = G;
              G = (i + 1);
              c = arrayOfChar[i];
              if (parama.b(c))
              {
                ((e.b.a.a.s.c)localObject).a(m >> 4);
                continue;
              }
              localObject = e.a.a.a.a.a("expected padding character '");
              ((StringBuilder)localObject).append(C);
              ((StringBuilder)localObject).append("'");
              throw a(parama, c, 3, ((StringBuilder)localObject).toString());
            }
          }
          m = m << 6 | j;
          if (G >= H) {
            r();
          }
          arrayOfChar = U;
          i = G;
          G = (i + 1);
          c = arrayOfChar[i];
          j = parama.a(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((c == '"') && (!B))
              {
                ((e.b.a.a.s.c)localObject).c(m >> 2);
                return ((e.b.a.a.s.c)localObject).c();
              }
              i = a(parama, c, 3);
            }
            k = i;
            if (i == -2)
            {
              ((e.b.a.a.s.c)localObject).c(m >> 2);
              continue;
            }
          }
          ((e.b.a.a.s.c)localObject).b(m << 6 | k);
        }
      }
    }
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == 93)
    {
      y();
      if (N.b())
      {
        N = N.c;
        y = l.END_ARRAY;
      }
      else
      {
        a(paramInt, '}');
        throw null;
      }
    }
    if (paramInt == 125)
    {
      y();
      if (N.c())
      {
        N = N.c;
        y = l.END_OBJECT;
      }
      else
      {
        a(paramInt, ']');
        throw null;
      }
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, "'null', 'true', 'false' or NaN");
    throw null;
  }
  
  public final String d()
  {
    l locall = y;
    if (locall == l.VALUE_STRING)
    {
      if (Y)
      {
        Y = false;
        p();
      }
      return P.b();
    }
    if (locall == l.FIELD_NAME) {
      return c();
    }
    return super.b(null);
  }
  
  public final void d(int paramInt)
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
          t();
        }
      }
      else
      {
        J += 1;
        K = i;
      }
    }
  }
  
  public final l f()
  {
    Object localObject1;
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
    int i;
    int j;
    int k;
    int m;
    if (Y)
    {
      Y = false;
      i = G;
      j = H;
      localObject1 = U;
      for (;;)
      {
        k = i;
        m = j;
        if (i >= j)
        {
          G = i;
          if (q())
          {
            k = G;
            m = H;
          }
          else
          {
            a(": was expecting closing quote for a string value", l.VALUE_STRING);
            throw null;
          }
        }
        i = k + 1;
        j = localObject1[k];
        if (j <= 92)
        {
          if (j == 92)
          {
            G = i;
            k();
            i = G;
            j = H;
            continue;
          }
          if (j <= 34)
          {
            if (j == 34)
            {
              G = i;
              break;
            }
            if (j < 32)
            {
              G = i;
              b(j, "string value");
            }
          }
        }
        j = m;
      }
    }
    if ((G >= H) && (!q()))
    {
      l();
      i = -1;
    }
    else
    {
      localObject1 = U;
      j = G;
      i = j + 1;
      G = i;
      j = localObject1[j];
      if (j > 32)
      {
        if (j != 47)
        {
          i = j;
          if (j != 35) {}
        }
        else
        {
          G -= 1;
          i = w();
        }
      }
      else
      {
        if (j != 32) {
          if (j == 10)
          {
            J += 1;
            K = i;
          }
          else if (j == 13)
          {
            t();
          }
          else if (j != 9)
          {
            a(j);
            throw null;
          }
        }
        do
        {
          for (;;)
          {
            j = G;
            if (j >= H) {
              break label525;
            }
            localObject1 = U;
            i = j + 1;
            G = i;
            j = localObject1[j];
            if (j > 32)
            {
              if (j != 47)
              {
                i = j;
                if (j != 35) {
                  break label530;
                }
              }
              G -= 1;
              i = w();
              break label530;
            }
            if (j != 32) {
              if (j == 10)
              {
                J += 1;
                K = i;
              }
              else
              {
                if (j != 13) {
                  break;
                }
                t();
              }
            }
          }
        } while (j == 9);
        a(j);
        throw null;
        label525:
        i = w();
      }
    }
    label530:
    if (i < 0)
    {
      close();
      y = null;
      return null;
    }
    S = null;
    if ((i != 93) && (i != 125))
    {
      localObject1 = N;
      j = b + 1;
      b = j;
      if ((a != 0) && (j > 0)) {
        m = 1;
      } else {
        m = 0;
      }
      j = i;
      if (m != 0) {
        if (i == 44)
        {
          do
          {
            for (;;)
            {
              j = G;
              if (j >= H) {
                break label743;
              }
              localObject1 = U;
              i = j + 1;
              G = i;
              j = localObject1[j];
              if (j > 32)
              {
                if (j != 47)
                {
                  i = j;
                  if (j != 35) {
                    break label748;
                  }
                }
                G -= 1;
                i = s();
                break label748;
              }
              if (j < 32) {
                if (j == 10)
                {
                  J += 1;
                  K = i;
                }
                else
                {
                  if (j != 13) {
                    break;
                  }
                  t();
                }
              }
            }
          } while (j == 9);
          a(j);
          throw null;
          label743:
          i = s();
          label748:
          j = i;
          if ((x & a0) != 0) {
            if (i != 93)
            {
              j = i;
              if (i != 125) {}
            }
            else
            {
              c(i);
              return y;
            }
          }
        }
        else
        {
          localObject1 = e.a.a.a.a.a("was expecting comma to separate ");
          ((StringBuilder)localObject1).append(N.e());
          ((StringBuilder)localObject1).append(" entries");
          a(i, ((StringBuilder)localObject1).toString());
          throw null;
        }
      }
      boolean bool1 = N.c();
      i = j;
      Object localObject2;
      int n;
      if (bool1)
      {
        i = G;
        Z = i;
        if (j == 34)
        {
          j = X;
          localObject2 = b0;
          while (i < H)
          {
            localObject1 = U;
            m = localObject1[i];
            if ((m < localObject2.length) && (localObject2[m] != 0))
            {
              if (m != 34) {
                break;
              }
              m = G;
              G = (i + 1);
              localObject1 = W.a((char[])localObject1, m, i - m, j);
              break label1540;
            }
            j = j * 33 + m;
            i++;
          }
          m = G;
          G = i;
          localObject1 = a(m, j, 34);
        }
        else
        {
          int i1;
          if ((j == 39) && (a(i.a.ALLOW_SINGLE_QUOTES)))
          {
            m = G;
            k = X;
            n = H;
            j = m;
            i = k;
            if (m < n)
            {
              localObject1 = b0;
              i1 = localObject1.length;
              i = k;
              j = m;
              for (;;)
              {
                localObject2 = U;
                m = localObject2[j];
                if (m == 39)
                {
                  m = G;
                  G = (j + 1);
                  localObject1 = W.a((char[])localObject2, m, j - m, i);
                  break label1540;
                }
                if ((m < i1) && (localObject1[m] != 0)) {
                  break;
                }
                i = i * 33 + m;
                j++;
                if (j >= n) {
                  break;
                }
              }
            }
            m = G;
            G = j;
            localObject1 = a(m, i, 39);
          }
          else
          {
            if (!a(i.a.ALLOW_UNQUOTED_FIELD_NAMES)) {
              break label1987;
            }
            localObject2 = e.b.a.a.p.a.e;
            n = localObject2.length;
            boolean bool2;
            if (j < n)
            {
              if (localObject2[j] == 0) {
                bool2 = true;
              } else {
                bool2 = false;
              }
            }
            else {
              bool2 = Character.isJavaIdentifierPart((char)j);
            }
            if (!bool2) {
              break label1977;
            }
            m = G;
            k = X;
            i1 = H;
            j = m;
            i = k;
            if (m < i1)
            {
              i = k;
              j = m;
              do
              {
                localObject1 = U;
                m = localObject1[j];
                if (m < n)
                {
                  if (localObject2[m] != 0)
                  {
                    m = G - 1;
                    G = j;
                    localObject1 = W.a((char[])localObject1, m, j - m, i);
                    break;
                  }
                }
                else if (!Character.isJavaIdentifierPart((char)m))
                {
                  m = G - 1;
                  G = j;
                  localObject1 = W.a(U, m, j - m, i);
                  break;
                }
                k = i * 33 + m;
                m = j + 1;
                j = m;
                i = k;
              } while (m < i1);
              i = k;
              j = m;
            }
            m = G - 1;
            G = j;
            P.a(U, m, j - m);
            localObject1 = P.g();
            j = P.i;
            k = localObject2.length;
          }
        }
        for (;;)
        {
          int i2;
          if ((G < H) || (q()))
          {
            i2 = U[G];
            if (i2 <= k ? localObject2[i2] == 0 : Character.isJavaIdentifierPart(i2)) {}
          }
          else
          {
            localObject1 = P;
            i = j;
            localObject2 = ((e.b.a.a.s.g)localObject1).h();
            j = c;
            if (j < 0) {
              j = 0;
            }
            m = ((e.b.a.a.s.g)localObject1).j();
            localObject1 = W.a((char[])localObject2, j, m, i);
            label1540:
            N.a((String)localObject1);
            y = l.FIELD_NAME;
            i = G;
            if (i + 4 >= H)
            {
              i = a(false);
              break;
            }
            localObject1 = U;
            j = localObject1[i];
            if (j == 58)
            {
              j = i + 1;
              G = j;
              i = localObject1[j];
              if (i > 32)
              {
                if ((i != 47) && (i != 35))
                {
                  G = (j + 1);
                  break;
                }
                i = a(true);
                break;
              }
              if ((i == 32) || (i == 9))
              {
                localObject1 = U;
                j = G + 1;
                G = j;
                i = localObject1[j];
                if (i > 32)
                {
                  if ((i != 47) && (i != 35))
                  {
                    G = (j + 1);
                    break;
                  }
                  i = a(true);
                  break;
                }
              }
              i = a(true);
              break;
            }
            if (j != 32)
            {
              i = j;
              if (j != 9) {}
            }
            else
            {
              localObject1 = U;
              i = G + 1;
              G = i;
              i = localObject1[i];
            }
            if (i == 58)
            {
              localObject1 = U;
              j = G + 1;
              G = j;
              i = localObject1[j];
              if (i > 32)
              {
                if ((i != 47) && (i != 35))
                {
                  G = (j + 1);
                  break;
                }
                i = a(true);
                break;
              }
              if ((i == 32) || (i == 9))
              {
                localObject1 = U;
                j = G + 1;
                G = j;
                i = localObject1[j];
                if (i > 32)
                {
                  if ((i != 47) && (i != 35))
                  {
                    G = (j + 1);
                    break;
                  }
                  i = a(true);
                  break;
                }
              }
              i = a(true);
              break;
            }
            i = a(false);
            break;
          }
          G += 1;
          m = i * 33 + i2;
          i = j + 1;
          localObject1[j] = i2;
          if (i >= localObject1.length)
          {
            localObject1 = P.f();
            i = 0;
          }
          j = i;
          i = m;
        }
        label1977:
        a(j, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        throw null;
        label1987:
        a(j, "was expecting double-quote to start field name");
        throw null;
      }
      y();
      if (i != 34)
      {
        if (i != 45)
        {
          if (i != 91)
          {
            if (i != 102)
            {
              if (i != 110)
              {
                if (i != 116)
                {
                  if (i != 123)
                  {
                    if (i != 125)
                    {
                      switch (i)
                      {
                      default: 
                        if (i == 39) {
                          break label2509;
                        }
                        if (i == 73) {
                          break label2469;
                        }
                        if (i == 78) {
                          break label2429;
                        }
                        if (i == 93) {
                          break label2389;
                        }
                        if (i != 43) {
                          if (i == 44) {
                            break label2402;
                          }
                        }
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
                        j = G;
                        k = j - 1;
                        n = H;
                        if (i == 48)
                        {
                          localObject1 = a(false, k);
                        }
                        else
                        {
                          i = 1;
                          for (;;)
                          {
                            if (j >= n)
                            {
                              G = k;
                              localObject1 = a(false, k);
                              break label3386;
                            }
                            localObject1 = U;
                            m = j + 1;
                            j = localObject1[j];
                            if ((j < 48) || (j > 57)) {
                              break;
                            }
                            i++;
                            j = m;
                          }
                          if ((j != 46) && (j != 101) && (j != 69))
                          {
                            i = m - 1;
                            G = i;
                            if (N.d()) {
                              d(j);
                            }
                            P.a(U, k, i - k);
                            localObject1 = l.VALUE_NUMBER_INT;
                          }
                          else
                          {
                            G = m;
                            localObject1 = a(j, k, m, false, i);
                          }
                        }
                        break;
                      }
                      if ((G >= H) && (!q()))
                      {
                        a(l.VALUE_NUMBER_INT);
                        throw null;
                      }
                      localObject1 = U;
                      i = G;
                      G = (i + 1);
                      localObject1 = a(localObject1[i], false);
                      break label3386;
                      label2389:
                      if (N.b()) {
                        label2402:
                        if (a(i.a.ALLOW_MISSING_VALUES))
                        {
                          G -= 1;
                          localObject1 = l.VALUE_NULL;
                          break label3386;
                          label2429:
                          a("NaN", 1);
                          if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS))
                          {
                            localObject1 = a("NaN", NaN.0D);
                            break label3386;
                          }
                          throw a("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                          label2469:
                          a("Infinity", 1);
                          if (a(i.a.ALLOW_NON_NUMERIC_NUMBERS))
                          {
                            localObject1 = a("Infinity", Double.POSITIVE_INFINITY);
                            break label3386;
                          }
                          throw a("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                          label2509:
                          if (a(i.a.ALLOW_SINGLE_QUOTES))
                          {
                            localObject1 = P.c();
                            i = P.i;
                            for (;;)
                            {
                              if ((G >= H) && (!q()))
                              {
                                a(": was expecting closing quote for a string value", l.VALUE_STRING);
                                throw null;
                              }
                              localObject2 = U;
                              j = G;
                              G = (j + 1);
                              m = localObject2[j];
                              j = m;
                              if (m <= 92) {
                                if (m == 92)
                                {
                                  j = k();
                                }
                                else
                                {
                                  j = m;
                                  if (m <= 39)
                                  {
                                    if (m == 39)
                                    {
                                      P.i = i;
                                      localObject1 = l.VALUE_STRING;
                                      break;
                                    }
                                    j = m;
                                    if (m < 32)
                                    {
                                      b(m, "string value");
                                      j = m;
                                    }
                                  }
                                }
                              }
                              localObject2 = localObject1;
                              m = i;
                              if (i >= localObject1.length)
                              {
                                localObject2 = P.f();
                                m = 0;
                              }
                              localObject2[m] = ((char)j);
                              i = m + 1;
                              localObject1 = localObject2;
                            }
                          }
                        }
                      }
                      if (Character.isJavaIdentifierStart(i))
                      {
                        localObject1 = e.a.a.a.a.a("");
                        ((StringBuilder)localObject1).append((char)i);
                        a(((StringBuilder)localObject1).toString(), "('true', 'false' or 'null')");
                        throw null;
                      }
                      a(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
                      throw null;
                    }
                    else
                    {
                      a(i, "expected a value");
                      throw null;
                    }
                  }
                  else
                  {
                    if (!bool1) {
                      N = N.b(L, M);
                    }
                    localObject1 = l.START_OBJECT;
                  }
                }
                else
                {
                  i = G;
                  if (i + 3 < H)
                  {
                    localObject1 = U;
                    if (localObject1[i] == 'r')
                    {
                      i++;
                      if (localObject1[i] == 'u')
                      {
                        i++;
                        if (localObject1[i] == 'e')
                        {
                          j = i + 1;
                          i = localObject1[j];
                          if ((i < 48) || (i == 93) || (i == 125))
                          {
                            G = j;
                            break label2890;
                          }
                        }
                      }
                    }
                  }
                  a("true", 1);
                  label2890:
                  localObject1 = l.VALUE_TRUE;
                }
              }
              else
              {
                i = G;
                if (i + 3 < H)
                {
                  localObject1 = U;
                  if (localObject1[i] == 'u')
                  {
                    i++;
                    if (localObject1[i] == 'l')
                    {
                      i++;
                      if (localObject1[i] == 'l')
                      {
                        i++;
                        j = localObject1[i];
                        if ((j < 48) || (j == 93) || (j == 125))
                        {
                          G = i;
                          break label2988;
                        }
                      }
                    }
                  }
                }
                a("null", 1);
                label2988:
                localObject1 = l.VALUE_NULL;
              }
            }
            else
            {
              i = G;
              if (i + 4 < H)
              {
                localObject1 = U;
                if (localObject1[i] == 'a')
                {
                  i++;
                  if (localObject1[i] == 'l')
                  {
                    i++;
                    if (localObject1[i] == 's')
                    {
                      i++;
                      if (localObject1[i] == 'e')
                      {
                        j = i + 1;
                        i = localObject1[j];
                        if ((i < 48) || (i == 93) || (i == 125))
                        {
                          G = j;
                          break label3098;
                        }
                      }
                    }
                  }
                }
              }
              a("false", 1);
              label3098:
              localObject1 = l.VALUE_FALSE;
            }
          }
          else
          {
            if (!bool1) {
              N = N.a(L, M);
            }
            localObject1 = l.START_ARRAY;
          }
        }
        else
        {
          i = G;
          k = i - 1;
          n = H;
          if (i >= n)
          {
            localObject1 = a(true, k);
          }
          else
          {
            localObject1 = U;
            j = i + 1;
            i = localObject1[i];
            if ((i <= 57) && (i >= 48))
            {
              if (i == 48)
              {
                localObject1 = a(true, k);
              }
              else
              {
                i = 1;
                for (;;)
                {
                  if (j >= n)
                  {
                    localObject1 = a(true, k);
                    break label3386;
                  }
                  localObject1 = U;
                  m = j + 1;
                  j = localObject1[j];
                  if ((j < 48) || (j > 57)) {
                    break;
                  }
                  i++;
                  j = m;
                }
                if ((j != 46) && (j != 101) && (j != 69))
                {
                  i = m - 1;
                  G = i;
                  if (N.d()) {
                    d(j);
                  }
                  P.a(U, k, i - k);
                  localObject1 = l.VALUE_NUMBER_INT;
                }
                else
                {
                  G = m;
                  localObject1 = a(j, k, m, true, i);
                }
              }
            }
            else
            {
              G = j;
              localObject1 = a(i, true);
            }
          }
        }
      }
      else
      {
        Y = true;
        localObject1 = l.VALUE_STRING;
      }
      label3386:
      if (bool1)
      {
        O = ((l)localObject1);
        return y;
      }
      y = ((l)localObject1);
      return (l)localObject1;
    }
    c(i);
    return y;
  }
  
  public final String i()
  {
    Object localObject = y;
    if (localObject == l.VALUE_STRING)
    {
      if (Y)
      {
        Y = false;
        p();
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
    if (T != null)
    {
      if ((E.c) || (a(i.a.AUTO_CLOSE_SOURCE))) {
        T.close();
      }
      T = null;
    }
  }
  
  public char k()
  {
    if ((G >= H) && (!q()))
    {
      a(" in character escape sequence", l.VALUE_STRING);
      throw null;
    }
    char[] arrayOfChar = U;
    int i = G;
    G = (i + 1);
    char c1 = arrayOfChar[i];
    char c2 = c1;
    if (c1 != '"')
    {
      c2 = c1;
      if (c1 != '/')
      {
        c2 = c1;
        if (c1 != '\\')
        {
          if (c1 != 'b')
          {
            if (c1 != 'f')
            {
              if (c1 != 'n')
              {
                if (c1 != 'r')
                {
                  if (c1 != 't')
                  {
                    if (c1 != 'u')
                    {
                      a(c1);
                      return c1;
                    }
                    int j = 0;
                    i = 0;
                    while (j < 4)
                    {
                      if ((G >= H) && (!q()))
                      {
                        a(" in character escape sequence", l.VALUE_STRING);
                        throw null;
                      }
                      arrayOfChar = U;
                      int k = G;
                      G = (k + 1);
                      int m = arrayOfChar[k];
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
          i = 8;
          c2 = i;
        }
      }
    }
    return c2;
  }
  
  public void o()
  {
    super.o();
    e.b.a.a.r.b localb = W;
    Object localObject1;
    Object localObject2;
    if ((l ^ true))
    {
      localObject1 = a;
      if ((localObject1 != null) && (e))
      {
        localObject2 = new b.b(localb);
        int i = a;
        b.b localb1 = (b.b)b.get();
        if (i != a)
        {
          if (i > 12000) {
            localObject2 = new b.b(0, 0, new String[64], new b.a[32]);
          }
          b.compareAndSet(localb1, localObject2);
        }
        l = true;
      }
    }
    if (V)
    {
      localObject1 = U;
      if (localObject1 != null)
      {
        U = null;
        localObject2 = E;
        if (localObject2 != null)
        {
          ((e.b.a.a.p.b)localObject2).a((char[])localObject1, g);
          g = null;
          d.b[0] = localObject1;
        }
        else
        {
          throw null;
        }
      }
    }
  }
  
  public final void p()
  {
    int i = G;
    int j = H;
    int k = i;
    if (i < j)
    {
      localObject1 = b0;
      m = localObject1.length;
      do
      {
        localObject2 = U;
        n = localObject2[i];
        if ((n < m) && (localObject1[n] != 0))
        {
          k = i;
          if (n != 34) {
            break;
          }
          localObject1 = P;
          k = G;
          ((e.b.a.a.s.g)localObject1).a((char[])localObject2, k, i - k);
          G = (i + 1);
          return;
        }
        k = i + 1;
        i = k;
      } while (k < j);
    }
    Object localObject1 = P;
    Object localObject3 = U;
    int n = G;
    int m = k - n;
    b = null;
    c = -1;
    d = 0;
    j = null;
    k = null;
    if (f) {
      ((e.b.a.a.s.g)localObject1).a();
    } else if (h == null) {
      h = ((e.b.a.a.s.g)localObject1).a(m);
    }
    g = 0;
    i = 0;
    if (c >= 0) {
      ((e.b.a.a.s.g)localObject1).b(m);
    }
    j = null;
    k = null;
    Object localObject2 = h;
    i = localObject2.length;
    int i1 = i;
    int i2 = i - i1;
    if (i2 >= m)
    {
      System.arraycopy(localObject3, n, localObject2, i1, m);
      i += m;
    }
    else
    {
      j = n;
      i = m;
      if (i2 > 0)
      {
        System.arraycopy(localObject3, n, localObject2, i1, i2);
        j = n + i2;
        i = m - i2;
      }
      do
      {
        ((e.b.a.a.s.g)localObject1).d();
        m = Math.min(h.length, i);
        System.arraycopy(localObject3, j, h, 0, m);
        i += m;
        j += m;
        m = i - m;
        i = m;
      } while (m > 0);
    }
    G = k;
    localObject2 = P.g();
    k = P.i;
    localObject3 = b0;
    m = localObject3.length;
    for (;;)
    {
      if ((G >= H) && (!q()))
      {
        a(": was expecting closing quote for a string value", l.VALUE_STRING);
        throw null;
      }
      localObject1 = U;
      i = G;
      G = (i + 1);
      j = localObject1[i];
      i = j;
      if (j < m)
      {
        i = j;
        if (localObject3[j] != 0)
        {
          if (j == 34)
          {
            P.i = k;
            return;
          }
          if (j == 92)
          {
            i = k();
          }
          else
          {
            i = j;
            if (j < 32)
            {
              b(j, "string value");
              i = j;
            }
          }
        }
      }
      localObject1 = localObject2;
      j = k;
      if (k >= localObject2.length)
      {
        localObject1 = P.f();
        j = 0;
      }
      localObject1[j] = ((char)i);
      k = j + 1;
      localObject2 = localObject1;
    }
  }
  
  public boolean q()
  {
    int i = H;
    long l1 = I;
    long l2 = i;
    I = (l1 + l2);
    K -= i;
    Z -= l2;
    Object localObject = T;
    if (localObject != null)
    {
      char[] arrayOfChar = U;
      i = ((Reader)localObject).read(arrayOfChar, 0, arrayOfChar.length);
      if (i > 0)
      {
        G = 0;
        H = i;
        return true;
      }
      j();
      if (i == 0)
      {
        localObject = e.a.a.a.a.a("Reader returned 0 characters when trying to read ");
        ((StringBuilder)localObject).append(H);
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void r()
  {
    if (q()) {
      return;
    }
    h();
    throw null;
  }
  
  public final int s()
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!q()))
        {
          localObject = e.a.a.a.a.a("Unexpected end-of-input within/between ");
          ((StringBuilder)localObject).append(N.e());
          ((StringBuilder)localObject).append(" entries");
          throw a(((StringBuilder)localObject).toString());
        }
        Object localObject = U;
        i = G;
        int j = i + 1;
        G = j;
        i = localObject[i];
        if (i > 32)
        {
          if (i == 47) {
            u();
          } else if ((i != 35) || (!x())) {
            return i;
          }
        }
        else if (i < 32) {
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
            t();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final void t()
  {
    if ((G < H) || (q()))
    {
      char[] arrayOfChar = U;
      int i = G;
      if (arrayOfChar[i] == '\n') {
        G = (i + 1);
      }
    }
    J += 1;
    K = G;
  }
  
  public final void u()
  {
    if (a(i.a.ALLOW_COMMENTS))
    {
      if ((G >= H) && (!q()))
      {
        a(" in a comment", null);
        throw null;
      }
      char[] arrayOfChar = U;
      int i = G;
      G = (i + 1);
      i = arrayOfChar[i];
      if (i == 47) {
        v();
      } else {
        if (i != 42) {
          break label247;
        }
      }
      int j;
      label188:
      do
      {
        for (;;)
        {
          if ((G < H) || (q()))
          {
            arrayOfChar = U;
            j = G;
            i = j + 1;
            G = i;
            j = arrayOfChar[j];
            if (j > 42) {
              continue;
            }
            if (j != 42) {
              break label188;
            }
            if ((i < H) || (q())) {}
          }
          else
          {
            a(" in a comment", null);
            throw null;
          }
          arrayOfChar = U;
          i = G;
          if (arrayOfChar[i] == '/')
          {
            G = (i + 1);
            return;
            if (j < 32) {
              if (j == 10)
              {
                J += 1;
                K = i;
              }
              else
              {
                if (j != 13) {
                  break;
                }
                t();
              }
            }
          }
        }
      } while (j == 9);
      a(j);
      throw null;
      label247:
      a(i, "was expecting either '*' or '/' for a comment");
      throw null;
    }
    a(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    throw null;
  }
  
  public final void v()
  {
    int i;
    label82:
    do
    {
      while ((G < H) || (q()))
      {
        char[] arrayOfChar = U;
        i = G;
        int j = i + 1;
        G = j;
        i = arrayOfChar[i];
        if (i < 32) {
          if (i == 10)
          {
            J += 1;
            K = j;
          }
          else
          {
            if (i != 13) {
              break label82;
            }
            t();
          }
        }
      }
      return;
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final int w()
  {
    int i;
    do
    {
      for (;;)
      {
        if ((G >= H) && (!q()))
        {
          l();
          return -1;
        }
        char[] arrayOfChar = U;
        i = G;
        int j = i + 1;
        G = j;
        i = arrayOfChar[i];
        if (i > 32)
        {
          if (i == 47) {
            u();
          } else if ((i != 35) || (!x())) {
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
            t();
          }
        }
      }
    } while (i == 9);
    a(i);
    throw null;
  }
  
  public final boolean x()
  {
    if (!a(i.a.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    v();
    return true;
  }
  
  public final void y()
  {
    int i = G;
    L = J;
    M = (i - K);
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */