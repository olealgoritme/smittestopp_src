package i.i;

import e.a.a.a.a;
import i.k.b.e;
import i.k.b.g;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class d
  implements List, Serializable, RandomAccess
{
  public static final d x = new d();
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Void))
    {
      if ((Void)paramObject != null) {
        return false;
      }
      g.a("element");
      throw null;
    }
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    if (paramCollection != null) {
      return paramCollection.isEmpty();
    }
    g.a("elements");
    throw null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof List)) && (((List)paramObject).isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object get(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty list doesn't contain element at index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append('.');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int indexOf(Object paramObject)
  {
    if ((paramObject instanceof Void))
    {
      if ((Void)paramObject != null) {
        return -1;
      }
      g.a("element");
      throw null;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return c.x;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    if ((paramObject instanceof Void))
    {
      if ((Void)paramObject != null) {
        return -1;
      }
      g.a("element");
      throw null;
    }
    return -1;
  }
  
  public ListIterator listIterator()
  {
    return c.x;
  }
  
  public ListIterator listIterator(int paramInt)
  {
    if (paramInt == 0) {
      return c.x;
    }
    throw new IndexOutOfBoundsException(a.a("Index: ", paramInt));
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return 0;
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public Object[] toArray()
  {
    return e.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return e.a(this, paramArrayOfT);
  }
  
  public String toString()
  {
    return "[]";
  }
}

/* Location:
 * Qualified Name:     i.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */