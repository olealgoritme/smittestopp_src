package k.e.a;

public final class x
{
  public final g a;
  public final d b;
  public int c;
  public String d;
  public int e;
  public x.a[] f;
  public int g;
  public c h;
  public int i;
  public c j;
  public int k;
  public x.a[] l;
  
  public x(g paramg)
  {
    a = paramg;
    b = null;
    f = new x.a['Ā'];
    g = 1;
    h = new c();
  }
  
  public static int a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    int m = paramString1.hashCode();
    int n = paramString2.hashCode();
    return 0x7FFFFFFF & paramString3.hashCode() * (n * m) * paramInt2 + paramInt1;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2 & 0x7FFFFFFF;
  }
  
  public static int b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int m = paramString1.hashCode();
    return 0x7FFFFFFF & (paramInt2 + 1) * (paramString2.hashCode() * m) + paramInt1;
  }
  
  public static int b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int m = paramString1.hashCode();
    int n = paramString2.hashCode();
    return 0x7FFFFFFF & paramString3.hashCode() * (n * m) + paramInt;
  }
  
  public int a(String paramString, int paramInt)
  {
    int m = paramString.hashCode() + 129 + paramInt & 0x7FFFFFFF;
    for (x.a locala = b(m); locala != null; locala = i) {
      if ((b == 129) && (h == m) && (f == paramInt) && (e.equals(paramString))) {
        return a;
      }
    }
    return a(new x.a(k, 129, paramString, paramInt, m));
  }
  
  public int a(String paramString1, String paramString2)
  {
    int m = paramString1.hashCode();
    int n = paramString2.hashCode() * m + 12 & 0x7FFFFFFF;
    for (x.a locala = b(n); locala != null; locala = i) {
      if ((b == 12) && (h == n) && (d.equals(paramString1)) && (e.equals(paramString2))) {
        return a;
      }
    }
    h.b(12, c(paramString1), c(paramString2));
    m = g;
    g = (m + 1);
    paramString1 = new x.a(m, 12, paramString1, paramString2, n);
    b(paramString1);
    return a;
  }
  
  public final int a(x.a parama)
  {
    if (l == null) {
      l = new x.a[16];
    }
    int m = k;
    x.a[] arrayOfa1 = l;
    if (m == arrayOfa1.length)
    {
      x.a[] arrayOfa2 = new x.a[arrayOfa1.length * 2];
      System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, arrayOfa1.length);
      l = arrayOfa2;
    }
    arrayOfa1 = l;
    m = k;
    k = (m + 1);
    arrayOfa1[m] = parama;
    b(parama);
    return a;
  }
  
  public w a(int paramInt)
  {
    return a(3, paramInt);
  }
  
  public final w a(int paramInt1, int paramInt2)
  {
    int m = b(paramInt1, paramInt2);
    for (Object localObject = b(m); localObject != null; localObject = i) {
      if ((b == paramInt1) && (h == m) && (f == paramInt2)) {
        return (w)localObject;
      }
    }
    localObject = h;
    ((c)localObject).b(paramInt1);
    ((c)localObject).c(paramInt2);
    int n = g;
    g = (n + 1);
    localObject = new x.a(n, paramInt1, paramInt2, m);
    b((x.a)localObject);
    return (w)localObject;
  }
  
  public final w a(int paramInt, long paramLong)
  {
    int m = (int)paramLong;
    int n = (int)(paramLong >>> 32);
    int i1 = paramInt + m + n & 0x7FFFFFFF;
    for (Object localObject = b(i1); localObject != null; localObject = i) {
      if ((b == paramInt) && (h == i1) && (f == paramLong)) {
        return (w)localObject;
      }
    }
    int i2 = g;
    localObject = h;
    ((c)localObject).b(paramInt);
    int i3 = b;
    if (i3 + 8 > a.length) {
      ((c)localObject).a(8);
    }
    byte[] arrayOfByte = a;
    int i4 = i3 + 1;
    arrayOfByte[i3] = ((byte)(byte)(n >>> 24));
    i3 = i4 + 1;
    arrayOfByte[i4] = ((byte)(byte)(n >>> 16));
    int i5 = i3 + 1;
    arrayOfByte[i3] = ((byte)(byte)(n >>> 8));
    i4 = i5 + 1;
    arrayOfByte[i5] = ((byte)(byte)n);
    i3 = i4 + 1;
    arrayOfByte[i4] = ((byte)(byte)(m >>> 24));
    n = i3 + 1;
    arrayOfByte[i3] = ((byte)(byte)(m >>> 16));
    i4 = n + 1;
    arrayOfByte[n] = ((byte)(byte)(m >>> 8));
    arrayOfByte[i4] = ((byte)(byte)m);
    b = (i4 + 1);
    g += 2;
    localObject = new x.a(i2, paramInt, paramLong, i1);
    b((x.a)localObject);
    return (w)localObject;
  }
  
  public final w a(int paramInt, String paramString)
  {
    int m = paramString.hashCode() + paramInt & 0x7FFFFFFF;
    for (x.a locala = b(m); locala != null; locala = i) {
      if ((b == paramInt) && (h == m) && (e.equals(paramString))) {
        return locala;
      }
    }
    h.b(paramInt, c(paramString));
    int n = g;
    g = (n + 1);
    paramString = new x.a(n, paramInt, paramString, m);
    b(paramString);
    return paramString;
  }
  
  public final w a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    int m = b(paramInt1, paramString1, paramString2, paramInt2);
    for (x.a locala = b(m); locala != null; locala = i) {
      if ((b == paramInt1) && (h == m) && (f == paramInt2) && (d.equals(paramString1)) && (e.equals(paramString2))) {
        return locala;
      }
    }
    h.b(paramInt1, paramInt2, a(paramString1, paramString2));
    int n = g;
    g = (n + 1);
    paramString1 = new x.a(n, paramInt1, null, paramString1, paramString2, paramInt2, m);
    b(paramString1);
    return paramString1;
  }
  
  public w a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int m = a(15, paramString1, paramString2, paramString3, paramInt);
    for (Object localObject = b(m); localObject != null; localObject = i) {
      if ((b == 15) && (h == m) && (f == paramInt) && (c.equals(paramString1)) && (d.equals(paramString2)) && (e.equals(paramString3))) {
        return (w)localObject;
      }
    }
    if (paramInt <= 4)
    {
      h.a(15, paramInt, a9a);
    }
    else
    {
      localObject = h;
      if (paramBoolean) {
        n = 11;
      } else {
        n = 10;
      }
      ((c)localObject).a(15, paramInt, aa);
    }
    int n = g;
    g = (n + 1);
    paramString1 = new x.a(n, 15, paramString1, paramString2, paramString3, paramInt, m);
    b(paramString1);
    return paramString1;
  }
  
  public w a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return a(((Integer)paramObject).intValue());
    }
    if ((paramObject instanceof Byte)) {
      return a(((Byte)paramObject).intValue());
    }
    if ((paramObject instanceof Character)) {
      return a(((Character)paramObject).charValue());
    }
    if ((paramObject instanceof Short)) {
      return a(((Short)paramObject).intValue());
    }
    if ((paramObject instanceof Boolean)) {
      return a(((Boolean)paramObject).booleanValue());
    }
    if ((paramObject instanceof Float)) {
      return a(4, Float.floatToRawIntBits(((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Long)) {
      return a(5, ((Long)paramObject).longValue());
    }
    if ((paramObject instanceof Double)) {
      return a(6, Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
    }
    if ((paramObject instanceof String)) {
      return a(8, (String)paramObject);
    }
    if ((paramObject instanceof y))
    {
      paramObject = (y)paramObject;
      int m = a;
      int n = m;
      if (m == 12) {
        n = 10;
      }
      if (n == 10) {
        return a(b.substring(c, d));
      }
      if (n == 11) {
        return a(16, ((y)paramObject).a());
      }
      return a(((y)paramObject).a());
    }
    if ((paramObject instanceof o))
    {
      paramObject = (o)paramObject;
      return a(a, b, c, d, e);
    }
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      return a(17, a, b, ac, d).a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("value ");
    localStringBuilder.append(paramObject);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public w a(String paramString)
  {
    return a(7, paramString);
  }
  
  public w a(o paramo, Object... paramVarArgs)
  {
    c localc1 = j;
    c localc2 = localc1;
    if (localc1 == null)
    {
      localc2 = new c();
      j = localc2;
    }
    int m = paramVarArgs.length;
    for (int n = 0; n < m; n++) {
      a(paramVarArgs[n]);
    }
    int i1 = b;
    localc2.d(aa, b, c, d, e).a);
    localc2.d(paramVarArgs.length);
    m = paramVarArgs.length;
    for (n = 0; n < m; n++) {
      localc2.d(aa);
    }
    int i2 = b;
    m = paramo.hashCode();
    int i3 = paramVarArgs.length;
    for (n = 0; n < i3; n++) {
      m ^= paramVarArgs[n].hashCode();
    }
    m &= 0x7FFFFFFF;
    paramVarArgs = j.a;
    paramo = f;
    for (paramo = paramo[(m % paramo.length)]; paramo != null; paramo = i) {
      if ((b == 64) && (h == m))
      {
        i3 = (int)f;
        for (n = 0; n < i2 - i1; n++) {
          if (paramVarArgs[(i1 + n)] != paramVarArgs[(i3 + n)])
          {
            n = 0;
            break label288;
          }
        }
        n = 1;
        label288:
        if (n != 0)
        {
          j.b = i1;
          return paramo;
        }
      }
    }
    n = i;
    i = (n + 1);
    paramo = new x.a(n, 64, i1, m);
    b(paramo);
    return paramo;
  }
  
  public final x.a a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int m = b(paramInt, paramString1, paramString2, paramString3);
    for (x.a locala = b(m); locala != null; locala = i) {
      if ((b == paramInt) && (h == m) && (c.equals(paramString1)) && (d.equals(paramString2)) && (e.equals(paramString3))) {
        return locala;
      }
    }
    h.b(paramInt, a7a, a(paramString2, paramString3));
    int n = g;
    g = (n + 1);
    paramString1 = new x.a(n, paramInt, paramString1, paramString2, paramString3, 0L, m);
    b(paramString1);
    return paramString1;
  }
  
  public w b(String paramString)
  {
    return a(19, paramString);
  }
  
  public final x.a b(int paramInt)
  {
    x.a[] arrayOfa = f;
    return arrayOfa[(paramInt % arrayOfa.length)];
  }
  
  public final x.a b(x.a parama)
  {
    int m = e;
    Object localObject = f;
    if (m > localObject.length * 3 / 4)
    {
      m = localObject.length;
      int n = m * 2 + 1;
      x.a[] arrayOfa = new x.a[n];
      m--;
      while (m >= 0)
      {
        x.a locala;
        for (localObject = f[m]; localObject != null; localObject = locala)
        {
          int i1 = h % n;
          locala = i;
          i = arrayOfa[i1];
          arrayOfa[i1] = localObject;
        }
        m--;
      }
      f = arrayOfa;
    }
    e += 1;
    m = h;
    localObject = f;
    m %= localObject.length;
    i = localObject[m];
    localObject[m] = parama;
    return parama;
  }
  
  public int c(String paramString)
  {
    int m = paramString.hashCode() + 1 & 0x7FFFFFFF;
    for (Object localObject = b(m); localObject != null; localObject = i) {
      if ((b == 1) && (h == m) && (e.equals(paramString))) {
        return a;
      }
    }
    c localc = h;
    localc.b(1);
    int n = paramString.length();
    if (n <= 65535)
    {
      int i1 = b;
      if (i1 + 2 + n > a.length) {
        localc.a(n + 2);
      }
      localObject = a;
      int i2 = i1 + 1;
      localObject[i1] = ((byte)(byte)(n >>> 8));
      i1 = i2 + 1;
      localObject[i2] = ((byte)(byte)n);
      i2 = 0;
      while (i2 < n)
      {
        int i3 = paramString.charAt(i2);
        if ((i3 >= 1) && (i3 <= 127))
        {
          localObject[i1] = ((byte)(byte)i3);
          i2++;
          i1++;
        }
        else
        {
          b = i1;
          localc.a(paramString, i2, 65535);
          break label233;
        }
      }
      b = i1;
      label233:
      i1 = g;
      g = (i1 + 1);
      paramString = new x.a(i1, 1, paramString, m);
      b(paramString);
      return a;
    }
    throw new IllegalArgumentException("UTF8 string too large");
  }
  
  public int d(String paramString)
  {
    int m = paramString.hashCode() + 128 & 0x7FFFFFFF;
    for (x.a locala = b(m); locala != null; locala = i) {
      if ((b == 128) && (h == m) && (e.equals(paramString))) {
        return a;
      }
    }
    return a(new x.a(k, 128, paramString, m));
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */