package g.a;

import java.util.Collection;
import java.util.Iterator;

public final class b$b
  implements Iterator<a>
{
  public final Iterator<Enum> x;
  public a y;
  
  public b$b(Collection<Enum> paramCollection)
  {
    paramCollection = null;
    y = null;
    Iterator localIterator = localIterator.iterator();
    x = localIterator;
    if (localIterator.hasNext()) {
      paramCollection = (a)x.next();
    }
    y = paramCollection;
  }
  
  public boolean hasNext()
  {
    a locala = y;
    boolean bool;
    if ((locala != null) && (!locala.name().equals("__UNKNOWN_CONSTANT__"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object next()
  {
    a locala1 = y;
    a locala2;
    if (x.hasNext()) {
      locala2 = (a)x.next();
    } else {
      locala2 = null;
    }
    y = locala2;
    return locala1;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     base.g.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */