package l.c.a.a.a.u;

import java.util.Hashtable;
import l.c.a.a.a.m;
import l.c.a.a.a.n;

public class a
  implements AutoCloseable
{
  public Hashtable<String, m> x;
  
  public final void a()
  {
    if (x != null) {
      return;
    }
    throw new n();
  }
  
  public void a(String paramString)
  {
    a();
    x.remove(paramString);
  }
  
  public void a(String paramString, m paramm)
  {
    a();
    x.put(paramString, paramm);
  }
  
  public void b()
  {
    x = new Hashtable();
  }
  
  public void close()
  {
    Hashtable localHashtable = x;
    if (localHashtable != null) {
      localHashtable.clear();
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */