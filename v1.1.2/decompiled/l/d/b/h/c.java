package l.d.b.h;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class c<K, T>
  implements a<K, T>
{
  public final HashMap<K, Reference<T>> a = new HashMap();
  public final ReentrantLock b = new ReentrantLock();
  
  public T a(K paramK)
  {
    paramK = (Reference)a.get(paramK);
    if (paramK != null) {
      return (T)paramK.get();
    }
    return null;
  }
  
  public void a()
  {
    b.unlock();
  }
  
  public void a(int paramInt) {}
  
  public void a(K paramK, T paramT)
  {
    a.put(paramK, new WeakReference(paramT));
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
      a.clear();
      return;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public T get(K paramK)
  {
    b.lock();
    try
    {
      paramK = (Reference)a.get(paramK);
      b.unlock();
      if (paramK != null) {
        return (T)paramK.get();
      }
      return null;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public void put(K paramK, T paramT)
  {
    b.lock();
    try
    {
      HashMap localHashMap = a;
      WeakReference localWeakReference = new java/lang/ref/WeakReference;
      localWeakReference.<init>(paramT);
      localHashMap.put(paramK, localWeakReference);
      return;
    }
    finally
    {
      b.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.h.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */