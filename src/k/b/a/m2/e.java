package k.b.a.m2;

import k.b.a.e1;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u;

public class e
  extends n
  implements f
{
  public o x;
  public t y;
  
  public e(u paramu)
  {
    x = o.a(paramu.a(0));
    y = paramu.a(1).c();
  }
  
  public static e a(Object paramObject)
  {
    if ((paramObject instanceof e)) {
      return (e)paramObject;
    }
    if (paramObject != null) {
      return new e(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    k.b.a.f localf = new k.b.a.f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.m2.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */