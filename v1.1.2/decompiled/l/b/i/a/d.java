package l.b.i.a;

import l.b.a.a1;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.i.d.a.a;

public class d
  extends n
{
  public final int x;
  public final int y;
  public final a z;
  
  public d(int paramInt1, int paramInt2, a parama)
  {
    x = paramInt1;
    y = paramInt2;
    z = new a(parama);
  }
  
  public d(u paramu)
  {
    x = ((l)paramu.a(0)).k();
    y = ((l)paramu.a(1)).k();
    z = new a(((p)paramu.a(2)).j());
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new a1(z.a()));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */