package d.f;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class g$a<T>
  implements Iterator<T>
{
  public boolean A = false;
  public final int x;
  public int y;
  public int z;
  
  public g$a(g paramg, int paramInt)
  {
    x = paramInt;
    y = paramg.c();
  }
  
  public boolean hasNext()
  {
    boolean bool;
    if (z < y) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T next()
  {
    if (hasNext())
    {
      Object localObject = B.a(z, x);
      z += 1;
      A = true;
      return (T)localObject;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (A)
    {
      int i = z - 1;
      z = i;
      y -= 1;
      A = false;
      B.a(i);
      return;
    }
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     base.d.f.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */