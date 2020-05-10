package h.i;

import java.util.Iterator;

public abstract class g
  implements Iterator<Integer>, Object
{
  public abstract int a();
  
  public Object next()
  {
    return Integer.valueOf(a());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}

/* Location:
 * Qualified Name:     base.h.i.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */