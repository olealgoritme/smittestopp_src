package e.c.c.w;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class r$d<T>
  implements Iterator<T>
{
  public r.e<K, V> x;
  public r.e<K, V> y;
  public int z;
  
  public r$d(r paramr)
  {
    paramr = A;
    x = B.A;
    y = null;
    z = A;
  }
  
  public final r.e<K, V> a()
  {
    r.e locale = x;
    r localr = A;
    if (locale != B)
    {
      if (A == z)
      {
        x = A;
        y = locale;
        return locale;
      }
      throw new ConcurrentModificationException();
    }
    throw new NoSuchElementException();
  }
  
  public final boolean hasNext()
  {
    boolean bool;
    if (x != A.B) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void remove()
  {
    r.e locale = y;
    if (locale != null)
    {
      A.b(locale, true);
      y = null;
      z = A.A;
      return;
    }
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.r.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */