package i.k.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<T>
  implements Iterator<T>, Object
{
  public int x;
  public final T[] y;
  
  public a(T[] paramArrayOfT) {}
  
  public boolean hasNext()
  {
    boolean bool;
    if (x < y.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T next()
  {
    try
    {
      Object localObject = y;
      int i = x;
      x = (i + 1);
      localObject = localObject[i];
      return (T)localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      x -= 1;
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}

/* Location:
 * Qualified Name:     i.k.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */