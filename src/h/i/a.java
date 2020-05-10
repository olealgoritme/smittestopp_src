package h.i;

import e.c.a.a.b.l.c;
import h.k.b.e;
import h.k.b.g;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class a<T>
  implements Collection<T>, Object
{
  public final T[] x;
  public final boolean y;
  
  public a(T[] paramArrayOfT, boolean paramBoolean) {}
  
  public boolean add(T paramT)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    Object[] arrayOfObject = x;
    if (arrayOfObject != null)
    {
      boolean bool;
      if (c.a(arrayOfObject, paramObject) >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    g.a("$this$contains");
    throw null;
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    if (paramCollection != null)
    {
      boolean bool1 = paramCollection.isEmpty();
      boolean bool2 = true;
      if (bool1)
      {
        bool1 = bool2;
      }
      else
      {
        paramCollection = paramCollection.iterator();
        do
        {
          bool1 = bool2;
          if (!paramCollection.hasNext()) {
            break;
          }
        } while (contains(paramCollection.next()));
        bool1 = false;
      }
      return bool1;
    }
    g.a("elements");
    throw null;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (x.length == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    Object[] arrayOfObject = x;
    if (arrayOfObject != null) {
      return new h.k.b.a(arrayOfObject);
    }
    g.a("array");
    throw null;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return x.length;
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = x;
    boolean bool = y;
    if (arrayOfObject != null)
    {
      if ((!bool) || (!g.a(arrayOfObject.getClass(), Object[].class)))
      {
        arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length, Object[].class);
        g.a(arrayOfObject, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
      }
      return arrayOfObject;
    }
    g.a("$this$copyToArrayOfAny");
    throw null;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return e.a(this, paramArrayOfT);
  }
}

/* Location:
 * Qualified Name:     base.h.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */