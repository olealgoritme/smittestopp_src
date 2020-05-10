package h.i;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class c
  implements ListIterator
{
  public static final c x = new c();
  
  public boolean hasNext()
  {
    return false;
  }
  
  public boolean hasPrevious()
  {
    return false;
  }
  
  public Object next()
  {
    throw new NoSuchElementException();
  }
  
  public int nextIndex()
  {
    return 0;
  }
  
  public Object previous()
  {
    throw new NoSuchElementException();
  }
  
  public int previousIndex()
  {
    return -1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}

/* Location:
 * Qualified Name:     base.h.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */