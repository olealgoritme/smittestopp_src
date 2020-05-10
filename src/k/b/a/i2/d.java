package k.b.a.i2;

import java.util.Enumeration;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l2.a;
import k.b.a.n;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;

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
  
  public t c()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.i2.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */