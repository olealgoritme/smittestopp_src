package l.d.a;

import java.util.ArrayList;
import java.util.List;

public final class j
{
  public static final List<j> d = new ArrayList();
  public Object a;
  public q b;
  public j c;
  
  public j(Object paramObject, q paramq)
  {
    a = paramObject;
    b = paramq;
  }
  
  public static j a(q paramq, Object paramObject)
  {
    synchronized (d)
    {
      int i = d.size();
      if (i > 0)
      {
        j localj = (j)d.remove(i - 1);
        a = paramObject;
        b = paramq;
        c = null;
        return localj;
      }
      return new j(paramObject, paramq);
    }
  }
  
  public static void a(j paramj)
  {
    a = null;
    b = null;
    c = null;
    synchronized (d)
    {
      if (d.size() < 10000) {
        d.add(paramj);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     l.d.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */