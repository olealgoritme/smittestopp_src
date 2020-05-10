package l.b.a.l2;

import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;

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
  
  public t b()
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
 * Qualified Name:     l.b.a.l2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */