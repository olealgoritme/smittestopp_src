package l.b.i.a;

import l.b.a.a1;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;

public class b
  extends n
{
  public final l.b.a.l2.a A;
  public final int x;
  public final int y;
  public final l.b.i.d.a.a z;
  
  public b(int paramInt1, int paramInt2, l.b.i.d.a.a parama, l.b.a.l2.a parama1)
  {
    x = paramInt1;
    y = paramInt2;
    z = new l.b.i.d.a.a(parama.a());
    A = parama1;
  }
  
  public b(u paramu)
  {
    x = ((l)paramu.a(0)).k();
    y = ((l)paramu.a(1)).k();
    z = new l.b.i.d.a.a(((p)paramu.a(2)).j());
    A = l.b.a.l2.a.a(paramu.a(3));
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new a1(z.a()));
    localf.a(A);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */