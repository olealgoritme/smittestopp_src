package d.f;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class f<K, V>
{
  public final LinkedHashMap<K, V> a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public f(int paramInt)
  {
    if (paramInt > 0)
    {
      c = paramInt;
      a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final V a(K paramK)
  {
    if (paramK != null) {
      try
      {
        paramK = a.get(paramK);
        if (paramK != null)
        {
          f += 1;
          return paramK;
        }
        g += 1;
        return null;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        d += 1;
        b += 1;
        paramK = a.put(paramK, paramV);
        if (paramK != null) {
          b -= 1;
        }
        a(c);
        return paramK;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((b >= 0) && ((!a.isEmpty()) || (b == 0)))
        {
          if ((b > paramInt) && (!a.isEmpty()))
          {
            localObject1 = (Map.Entry)a.entrySet().iterator().next();
            localObject3 = ((Map.Entry)localObject1).getKey();
            ((Map.Entry)localObject1).getValue();
            a.remove(localObject3);
            b -= 1;
            e += 1;
            continue;
          }
          return;
        }
        Object localObject1 = new java/lang/IllegalStateException;
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append(getClass().getName());
        ((StringBuilder)localObject3).append(".sizeOf() is reporting inconsistent results!");
        ((IllegalStateException)localObject1).<init>(((StringBuilder)localObject3).toString());
        throw ((Throwable)localObject1);
      }
      finally {}
    }
  }
  
  public final String toString()
  {
    try
    {
      int i = f + g;
      if (i != 0) {
        i = f * 100 / i;
      } else {
        i = 0;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(c), Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.d.f.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */