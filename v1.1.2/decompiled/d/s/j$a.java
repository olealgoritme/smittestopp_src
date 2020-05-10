package d.s;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class j$a
  implements Iterator<i>
{
  public int x = -1;
  public boolean y = false;
  
  public j$a(j paramj) {}
  
  public boolean hasNext()
  {
    int i = x;
    boolean bool = true;
    if (i + 1 >= z.F.b()) {
      bool = false;
    }
    return bool;
  }
  
  public Object next()
  {
    if (hasNext())
    {
      y = true;
      d.f.i locali = z.F;
      int i = x + 1;
      x = i;
      return (i)locali.d(i);
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    if (y)
    {
      z.F.d(x)).y = null;
      d.f.i locali = z.F;
      int i = x;
      Object[] arrayOfObject = z;
      Object localObject1 = arrayOfObject[i];
      Object localObject2 = d.f.i.B;
      if (localObject1 != localObject2)
      {
        arrayOfObject[i] = localObject2;
        x = true;
      }
      x -= 1;
      y = false;
      return;
    }
    throw new IllegalStateException("You must call next() before you can remove an element");
  }
}

/* Location:
 * Qualified Name:     d.s.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */