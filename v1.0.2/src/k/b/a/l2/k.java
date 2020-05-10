package k.b.a.l2;

import e.a.a.a.a;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u;

public class k
  extends n
{
  public Hashtable x = new Hashtable();
  public Vector y = new Vector();
  
  public k(u paramu)
  {
    Object localObject = paramu.j();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramu = j.a(((Enumeration)localObject).nextElement());
      if (!x.containsKey(x))
      {
        x.put(x, paramu);
        y.addElement(x);
      }
      else
      {
        localObject = a.a("repeated extension found: ");
        ((StringBuilder)localObject).append(x);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static k a(Object paramObject)
  {
    if ((paramObject instanceof k)) {
      return (k)paramObject;
    }
    if (paramObject != null) {
      return new k(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    f localf = new f(y.size());
    Enumeration localEnumeration = y.elements();
    while (localEnumeration.hasMoreElements())
    {
      o localo = (o)localEnumeration.nextElement();
      localf.a((j)x.get(localo));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */