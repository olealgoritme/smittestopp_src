package d.a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b
{
  public boolean a;
  public CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList();
  
  public b(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public abstract void a();
  
  public final void b()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */