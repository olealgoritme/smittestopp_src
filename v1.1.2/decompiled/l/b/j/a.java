package l.b.j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class a<T>
  implements Iterator<T>
{
  public final T[] x;
  public int y = 0;
  
  public a(T[] paramArrayOfT)
  {
    x = paramArrayOfT;
  }
  
  public boolean hasNext()
  {
    boolean bool;
    if (y < x.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T next()
  {
    int i = y;
    Object localObject = x;
    if (i != localObject.length)
    {
      y = (i + 1);
      return localObject[i];
    }
    localObject = e.a.a.a.a.a("Out of elements: ");
    ((StringBuilder)localObject).append(y);
    throw new NoSuchElementException(((StringBuilder)localObject).toString());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove element from an Array.");
  }
}

/* Location:
 * Qualified Name:     l.b.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */