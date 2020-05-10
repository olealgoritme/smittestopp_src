package k.b.i.a;

import k.b.a.a1;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.n;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;
import k.b.i.d.a.a;

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
  
  public t c()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new a1(z.a()));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */