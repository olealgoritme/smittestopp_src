package l.b.a.k2;

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
  
  public t b()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.k2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */