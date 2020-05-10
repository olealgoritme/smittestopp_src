package k.e.a;

public final class a
{
  public final x a;
  public final boolean b;
  public final c c;
  public final int d;
  public int e;
  public final a f;
  public a g;
  
  public a(x paramx, boolean paramBoolean, c paramc, a parama)
  {
    a = paramx;
    b = paramBoolean;
    c = paramc;
    int i = b;
    if (i == 0) {
      i = -1;
    } else {
      i -= 2;
    }
    d = i;
    f = parama;
    if (parama != null) {
      g = this;
    }
  }
  
  public static int a(String paramString, a[] paramArrayOfa, int paramInt)
  {
    int i = paramInt * 2 + 7;
    for (int j = 0; j < paramInt; j++)
    {
      a locala = paramArrayOfa[j];
      int k;
      if (locala == null) {
        k = 0;
      } else {
        k = locala.a(paramString) - 8;
      }
      i += k;
    }
    return i;
  }
  
  public static int a(a parama1, a parama2, a parama3, a parama4)
  {
    int i = 0;
    if (parama1 != null) {
      i = 0 + parama1.a("RuntimeVisibleAnnotations");
    }
    int j = i;
    if (parama2 != null) {
      j = i + parama2.a("RuntimeInvisibleAnnotations");
    }
    i = j;
    if (parama3 != null) {
      i = j + parama3.a("RuntimeVisibleTypeAnnotations");
    }
    j = i;
    if (parama4 != null) {
      j = i + parama4.a("RuntimeInvisibleTypeAnnotations");
    }
    return j;
  }
  
  public static a a(x paramx, int paramInt, z paramz, String paramString, a parama)
  {
    c localc = new c();
    int i = paramInt >>> 24;
    if ((i != 0) && (i != 1)) {}
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        throw new IllegalArgumentException();
      }
    case 19: 
    case 20: 
    case 21: 
      localc.b(i);
      break;
      localc.c(paramInt);
      break;
    case 16: 
    case 17: 
    case 18: 
    case 23: 
      localc.b(i, (paramInt & 0xFFFF00) >> 8);
      break;
    case 22: 
      localc.d(paramInt >>> 16);
    }
    z.a(paramz, localc);
    localc.d(paramx.c(paramString));
    localc.d(0);
    return new a(paramx, true, localc, parama);
  }
  
  public static a a(x paramx, String paramString, a parama)
  {
    c localc = new c();
    localc.d(paramx.c(paramString));
    localc.d(0);
    return new a(paramx, true, localc, parama);
  }
  
  public static void a(int paramInt1, a[] paramArrayOfa, int paramInt2, c paramc)
  {
    int i = paramInt2 * 2 + 1;
    Object localObject1;
    for (int j = 0; j < paramInt2; j++)
    {
      localObject1 = paramArrayOfa[j];
      int k;
      if (localObject1 == null) {
        k = 0;
      } else {
        k = ((a)localObject1).a(null) - 8;
      }
      i += k;
    }
    paramc.d(paramInt1);
    paramc.c(i);
    paramc.b(paramInt2);
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      localObject1 = paramArrayOfa[paramInt1];
      Object localObject2 = null;
      j = 0;
      while (localObject1 != null)
      {
        ((a)localObject1).a();
        j++;
        a locala = f;
        localObject2 = localObject1;
        localObject1 = locala;
      }
      paramc.d(j);
      while (localObject2 != null)
      {
        localObject1 = c;
        paramc.a(a, 0, b);
        localObject2 = g;
      }
    }
  }
  
  public static void a(x paramx, a parama1, a parama2, a parama3, a parama4, c paramc)
  {
    if (parama1 != null) {
      parama1.a(paramx.c("RuntimeVisibleAnnotations"), paramc);
    }
    if (parama2 != null) {
      parama2.a(paramx.c("RuntimeInvisibleAnnotations"), paramc);
    }
    if (parama3 != null) {
      parama3.a(paramx.c("RuntimeVisibleTypeAnnotations"), paramc);
    }
    if (parama4 != null) {
      parama4.a(paramx.c("RuntimeInvisibleTypeAnnotations"), paramc);
    }
  }
  
  public int a(String paramString)
  {
    if (paramString != null) {
      a.c(paramString);
    }
    int i = 8;
    for (paramString = this; paramString != null; paramString = f) {
      i += c.b;
    }
    return i;
  }
  
  public void a()
  {
    int i = d;
    if (i != -1)
    {
      byte[] arrayOfByte = c.a;
      int j = e;
      arrayOfByte[i] = ((byte)(byte)(j >>> 8));
      arrayOfByte[(i + 1)] = ((byte)(byte)j);
    }
  }
  
  public void a(int paramInt, c paramc)
  {
    int i = 2;
    int j = 0;
    Object localObject1 = null;
    a locala;
    for (Object localObject2 = this; localObject2 != null; localObject2 = locala)
    {
      ((a)localObject2).a();
      i += c.b;
      j++;
      locala = f;
      localObject1 = localObject2;
    }
    paramc.d(paramInt);
    paramc.c(i);
    paramc.d(j);
    while (localObject1 != null)
    {
      localObject2 = c;
      paramc.a(a, 0, b);
      localObject1 = g;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    e += 1;
    if (b) {
      c.d(a.c(paramString));
    }
    if ((paramObject instanceof String))
    {
      c.b(115, a.c((String)paramObject));
    }
    else if ((paramObject instanceof Byte))
    {
      c.b(66, a.a(((Byte)paramObject).byteValue()).a);
    }
    else if ((paramObject instanceof Boolean))
    {
      int i = ((Boolean)paramObject).booleanValue();
      c.b(90, a.a(i).a);
    }
    else if ((paramObject instanceof Character))
    {
      c.b(67, a.a(((Character)paramObject).charValue()).a);
    }
    else if ((paramObject instanceof Short))
    {
      c.b(83, a.a(((Short)paramObject).shortValue()).a);
    }
    else if ((paramObject instanceof y))
    {
      c.b(99, a.c(((y)paramObject).a()));
    }
    else
    {
      boolean bool = paramObject instanceof byte[];
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int j = 0;
      if (bool)
      {
        paramString = (byte[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        while (j < k)
        {
          m = paramString[j];
          c.b(66, a.a(m).a);
          j++;
        }
      }
      if ((paramObject instanceof boolean[]))
      {
        paramString = (boolean[])paramObject;
        c.b(91, paramString.length);
        m = paramString.length;
        for (j = k; j < m; j++)
        {
          k = paramString[j];
          c.b(90, a.a(k).a);
        }
      }
      if ((paramObject instanceof short[]))
      {
        paramString = (short[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        for (j = m; j < k; j++)
        {
          m = paramString[j];
          c.b(83, a.a(m).a);
        }
      }
      if ((paramObject instanceof char[]))
      {
        paramString = (char[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        for (j = n; j < k; j++)
        {
          m = paramString[j];
          c.b(67, a.a(m).a);
        }
      }
      if ((paramObject instanceof int[]))
      {
        paramString = (int[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        for (j = i1; j < k; j++)
        {
          m = paramString[j];
          c.b(73, a.a(m).a);
        }
      }
      if ((paramObject instanceof long[]))
      {
        paramString = (long[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        for (j = i2; j < k; j++)
        {
          long l = paramString[j];
          c.b(74, a.a(5, l).a);
        }
      }
      Object localObject;
      if ((paramObject instanceof float[]))
      {
        paramString = (float[])paramObject;
        c.b(91, paramString.length);
        k = paramString.length;
        for (j = i3;; j++)
        {
          if (j >= k) {
            return;
          }
          float f1 = paramString[j];
          localObject = c;
          paramObject = a;
          if (paramObject == null) {
            break;
          }
          ((c)localObject).b(70, a4floatToRawIntBitsa);
        }
        throw null;
      }
      if ((paramObject instanceof double[]))
      {
        localObject = (double[])paramObject;
        c.b(91, localObject.length);
        k = localObject.length;
        for (j = i4;; j++)
        {
          if (j >= k) {
            return;
          }
          double d1 = localObject[j];
          paramString = c;
          paramObject = a;
          if (paramObject == null) {
            break;
          }
          paramString.b(68, a6doubleToRawLongBitsa);
        }
        throw null;
      }
      paramString = a.a(paramObject);
      c.b(".s.IFJDCS".charAt(b), a);
    }
  }
  
  public a b(String paramString)
  {
    e += 1;
    if (b) {
      c.d(a.c(paramString));
    }
    c.b(91, 0);
    return new a(a, false, c, null);
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */