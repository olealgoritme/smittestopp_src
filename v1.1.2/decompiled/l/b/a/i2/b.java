package l.b.a.i2;

import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l2.a;
import l.b.a.n;
import l.b.a.r0;
import l.b.a.t;
import l.b.a.u;

public class b
  extends n
{
  public c x;
  public a y;
  public r0 z;
  
  public b()
  {
    x = null;
    y = null;
    z = null;
  }
  
  public b(u paramu)
  {
    c localc = null;
    x = null;
    y = null;
    z = null;
    e locale = paramu.a(0);
    if ((locale instanceof c)) {
      localc = (c)locale;
    } else if (locale != null) {
      localc = new c(u.a(locale));
    }
    x = localc;
    y = a.a(paramu.a(1));
    z = ((r0)paramu.a(2));
  }
  
  public t b()
  {
    f localf = new f(3);
    localf.a(x);
    localf.a(y);
    localf.a(z);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.i2.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */