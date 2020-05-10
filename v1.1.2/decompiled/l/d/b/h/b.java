package l.d.b.h;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import l.d.b.i.c;

public class b<T>
  implements a<Long, T>
{
  public final c<Reference<T>> a = new c();
  public final ReentrantLock b = new ReentrantLock();
  
  public T a(long paramLong)
  {
    b.lock();
    try
    {
      Reference localReference = (Reference)a.a(paramLong);
      b.unlock();
      if (localReference != null) {
        return (T)localReference.get();
      }
      return null;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public Object a(Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    paramObject = (Reference)a.a(l);
    if (paramObject != null) {
      paramObject = ((Reference)paramObject).get();
    } else {
      paramObject = null;
    }
    return paramObject;
  }
  
  public void a()
  {
    b.unlock();
  }
  
  public void a(int paramInt)
  {
    c localc = a;
    if (localc != null)
    {
      localc.a(paramInt * 5 / 3);
      return;
    }
    throw null;
  }
  
  public void a(long paramLong, T paramT)
  {
    b.lock();
    try
    {
      c localc = a;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(paramT);
      localc.a(paramLong, localWeakReference);
      return;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    long l = ((Long)paramObject1).longValue();
    a.a(l, new WeakReference(paramObject2));
  }
  
  public void b()
  {
    b.lock();
  }
  
  public void clear()
  {
    b.lock();
    try
    {
      c localc = a;
      d = 0;
      Arrays.fill(a, null);
      return;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public Object get(Object paramObject)
  {
    return a(((Long)paramObject).longValue());
  }
  
  public void put(Object paramObject1, Object paramObject2)
  {
    a(((Long)paramObject1).longValue(), paramObject2);
  }
}

/* Location:
 * Qualified Name:     l.d.b.h.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */