package k.b.a.l2;

import k.b.a.e;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u;

public class a
  extends n
{
  public o x;
  public e y;
  
  public a(o paramo)
  {
    x = paramo;
  }
  
  public a(o paramo, e parame)
  {
    x = paramo;
    y = parame;
  }
  
  public a(u paramu)
  {
    if ((paramu.size() >= 1) && (paramu.size() <= 2))
    {
      x = o.a(paramu.a(0));
      if (paramu.size() == 2) {
        paramu = paramu.a(1);
      } else {
        paramu = null;
      }
      y = paramu;
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static a a(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    f localf = new f(2);
    localf.a(x);
    e locale = y;
    if (locale != null) {
      localf.a(locale);
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */