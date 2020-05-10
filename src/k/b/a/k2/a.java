package k.b.a.k2;

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
  
  public a(u paramu)
  {
    x = ((o)paramu.a(0));
    y = paramu.a(1);
  }
  
  public static a a(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return (a)paramObject;
    }
    if (paramObject != null) {
      return new a(u.a(paramObject));
    }
    throw new IllegalArgumentException("null value in getInstance()");
  }
  
  public t c()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.k2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */