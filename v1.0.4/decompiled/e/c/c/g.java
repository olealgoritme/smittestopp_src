package e.c.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends j
  implements Iterable<j>
{
  public final List<j> x = new ArrayList();
  
  public int a()
  {
    if (x.size() == 1) {
      return ((j)x.get(0)).a();
    }
    throw new IllegalStateException();
  }
  
  public long e()
  {
    if (x.size() == 1) {
      return ((j)x.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && ((!(paramObject instanceof g)) || (!x.equals(x)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String f()
  {
    if (x.size() == 1) {
      return ((j)x.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public Iterator<j> iterator()
  {
    return x.iterator();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */