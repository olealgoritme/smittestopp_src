package h.a.d;

import h.a.b;
import h.a.c;
import java.lang.reflect.Array;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class a<E extends Enum<E>>
{
  public final Object a = new Object();
  public final Class<E> b;
  public final Map<Long, E> c = new ConcurrentHashMap();
  public final AtomicLong d;
  public final boolean e;
  public h.a.a[] f = null;
  public volatile E[] g = null;
  public volatile int h = 0;
  public volatile b i;
  
  public a(Class<E> paramClass, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b = paramClass;
    d = new AtomicLong(paramInt1);
    e = paramInt2;
  }
  
  public static <T extends Enum<T>> a<T> a(Class<T> paramClass, int paramInt1, int paramInt2)
  {
    return new a(paramClass, paramInt1, false);
  }
  
  public final b a()
  {
    if (i == null)
    {
      String str = b.getSimpleName();
      Object localObject = (b)b.B.get(str);
      if (localObject == null) {
        localObject = b.b(str);
      }
      i = ((b)localObject);
      if (i == null)
      {
        localObject = e.a.a.a.a.a("Could not load platform constants for ");
        ((StringBuilder)localObject).append(b.getSimpleName());
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
    }
    return i;
  }
  
  public final E a(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 256L) && (g != null))
    {
      localObject = g[((int)paramLong)];
      if (localObject != null) {
        return (E)localObject;
      }
    }
    Object localObject = (Enum)c.get(Long.valueOf(paramLong));
    if (localObject != null) {
      return (E)localObject;
    }
    h.a.a locala = (h.a.a)ay.get(Long.valueOf(paramLong));
    if (locala != null) {}
    try
    {
      Enum localEnum = Enum.valueOf(b, locala.name());
      c.put(Long.valueOf(paramLong), localEnum);
      if ((locala.intValue() >= 0) && (locala.intValue() < 256))
      {
        Enum[] arrayOfEnum = g;
        localObject = arrayOfEnum;
        if (arrayOfEnum == null) {
          localObject = (Enum[])Array.newInstance(b, 256);
        }
        localObject[locala.intValue()] = localEnum;
        g = ((Enum[])localObject);
      }
      return localEnum;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    return Enum.valueOf(b, "__UNKNOWN_CONSTANT__");
  }
  
  public final boolean a(E paramE)
  {
    return b(paramE).defined();
  }
  
  public final h.a.a b(E paramE)
  {
    if (h != 0)
    {
      h.a.a locala = f[paramE.ordinal()];
      if (locala != null) {
        return locala;
      }
    }
    return d(paramE);
  }
  
  public final long c(E paramE)
  {
    return b(paramE).longValue();
  }
  
  public final h.a.a d(E paramE)
  {
    synchronized (a)
    {
      if (h != 0)
      {
        localObject2 = f[paramE.ordinal()];
        if (localObject2 != null) {
          return (h.a.a)localObject2;
        }
      }
      Object localObject2 = EnumSet.allOf(b);
      b localb = a();
      if (f == null) {
        f = new h.a.a[((EnumSet)localObject2).size()];
      }
      Iterator localIterator = ((EnumSet)localObject2).iterator();
      long l1 = 0L;
      long l3;
      long l4;
      for (long l2 = l1; localIterator.hasNext(); l2 = l3)
      {
        Enum localEnum = (Enum)localIterator.next();
        localObject2 = localEnum.name();
        h.a.a locala = (h.a.a)x.get(localObject2);
        if (locala == null)
        {
          if (e)
          {
            l3 = l2 | 1L << localEnum.ordinal();
            localObject2 = new h/a/d/a$a;
            ((a)localObject2).<init>(0L, localEnum.name());
            l4 = l1;
          }
          else
          {
            localObject2 = new a(d.getAndAdd(1L), localEnum.name());
            l4 = l1;
            l3 = l2;
          }
        }
        else
        {
          l4 = l1;
          l3 = l2;
          localObject2 = locala;
          if (e)
          {
            l4 = l1 | locala.longValue();
            localObject2 = locala;
            l3 = l2;
          }
        }
        f[localEnum.ordinal()] = localObject2;
        l1 = l4;
      }
      if (e) {
        for (;;)
        {
          l4 = Long.lowestOneBit(l2);
          if (l4 == 0L) {
            break;
          }
          int j = Long.numberOfTrailingZeros(l4);
          int k = Long.numberOfTrailingZeros(Long.lowestOneBit(l1));
          localObject2 = f;
          l4 = 1 << k;
          localObject2[j] = new a(l4, f[j].name());
          l1 |= l4;
          l2 &= 1L << j;
        }
      }
      h = 1;
      paramE = f[paramE.ordinal()];
      return paramE;
    }
  }
  
  public static final class a
    implements h.a.a
  {
    public final long x;
    public final String y;
    
    public a(long paramLong, String paramString)
    {
      x = paramLong;
      y = paramString;
    }
    
    public final void a()
    {
      if (c.b) {
        return;
      }
      StringBuilder localStringBuilder = e.a.a.a.a.a("Constant ");
      localStringBuilder.append(y);
      localStringBuilder.append(" is not defined on ");
      localStringBuilder.append(c.g);
      throw new AssertionError(localStringBuilder.toString());
    }
    
    public final boolean defined()
    {
      return false;
    }
    
    public final int intValue()
    {
      a();
      return (int)x;
    }
    
    public final long longValue()
    {
      a();
      return x;
    }
    
    public final String name()
    {
      return y;
    }
    
    public final String toString()
    {
      return y;
    }
  }
}

/* Location:
 * Qualified Name:     h.a.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */