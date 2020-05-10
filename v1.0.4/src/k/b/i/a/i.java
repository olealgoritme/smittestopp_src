package k.b.i.a;

import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.l2.a;
import k.b.a.n;
import k.b.a.t;
import k.b.a.u;

public class i
  extends n
{
  public final l x;
  public final int y;
  public final a z;
  
  public i(int paramInt, a parama)
  {
    x = new l(0L);
    y = paramInt;
    z = parama;
  }
  
  public i(u paramu)
  {
    x = l.a(paramu.a(0));
    y = l.a(paramu.a(1)).k();
    z = a.a(paramu.a(2));
  }
  
  public static i a(Object paramObject)
  {
    if ((paramObject instanceof i)) {
      return (i)paramObject;
    }
    if (paramObject != null) {
      return new i(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    f localf = new f(10);
    localf.a(x);
    localf.a(new l(y));
    localf.a(z);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */