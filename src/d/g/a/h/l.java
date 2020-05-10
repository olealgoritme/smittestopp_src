package d.g.a.h;

import java.util.HashSet;
import java.util.Iterator;

public class l
{
  public HashSet<l> a = new HashSet(2);
  public int b = 0;
  
  public void a()
  {
    b = 1;
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).d();
    }
  }
  
  public void b()
  {
    b = 0;
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).b();
    }
  }
  
  public boolean c()
  {
    int i = b;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void d() {}
}

/* Location:
 * Qualified Name:     base.d.g.a.h.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */