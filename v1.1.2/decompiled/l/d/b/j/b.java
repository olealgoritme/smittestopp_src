package l.d.b.j;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class b<T, Q extends a<T>>
{
  public final String a;
  public final l.d.b.a<T, ?> b;
  public final String[] c;
  public final Map<Long, WeakReference<Q>> d;
  
  public b(l.d.b.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    b = parama;
    a = paramString;
    c = paramArrayOfString;
    d = new HashMap();
  }
  
  public abstract Q a();
  
  public Q b()
  {
    long l = Thread.currentThread().getId();
    synchronized (d)
    {
      Object localObject1 = (WeakReference)d.get(Long.valueOf(l));
      if (localObject1 != null) {
        localObject1 = (a)((WeakReference)localObject1).get();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null)
      {
        c();
        localObject1 = a();
        Map localMap2 = d;
        WeakReference localWeakReference = new java/lang/ref/WeakReference;
        localWeakReference.<init>(localObject1);
        localMap2.put(Long.valueOf(l), localWeakReference);
      }
      else
      {
        System.arraycopy(c, 0, d, 0, c.length);
      }
      return (Q)localObject1;
    }
  }
  
  public void c()
  {
    synchronized (d)
    {
      Iterator localIterator = d.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)((Map.Entry)localIterator.next()).getValue()).get() == null) {
          localIterator.remove();
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */