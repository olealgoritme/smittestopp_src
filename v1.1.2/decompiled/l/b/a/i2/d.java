package l.b.a.i2;

import java.util.Enumeration;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l2.a;
import l.b.a.n;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;

public class d
  extends n
{
  public a x;
  public p y;
  
  public d(u paramu)
  {
    paramu = paramu.j();
    x = a.a(paramu.nextElement());
    y = p.a(paramu.nextElement());
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
 * Qualified Name:     l.b.a.i2.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */