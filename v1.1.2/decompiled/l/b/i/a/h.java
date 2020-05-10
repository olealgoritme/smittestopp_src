package l.b.i.a;

import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.l2.a;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

public class h
  extends n
{
  public final l x;
  public final a y;
  
  public h(a parama)
  {
    x = new l(0L);
    y = parama;
  }
  
  public h(u paramu)
  {
    x = l.a(paramu.a(0));
    y = a.a(paramu.a(1));
  }
  
  public static final h a(Object paramObject)
  {
    if ((paramObject instanceof h)) {
      return (h)paramObject;
    }
    if (paramObject != null) {
      return new h(u.a(paramObject));
    }
    return null;
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */