package k.b.i.a;

import k.b.a.a1;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.n;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;

public class b
  extends n
{
  public final k.b.a.l2.a A;
  public final int x;
  public final int y;
  public final k.b.i.d.a.a z;
  
  public b(int paramInt1, int paramInt2, k.b.i.d.a.a parama, k.b.a.l2.a parama1)
  {
    x = paramInt1;
    y = paramInt2;
    z = new k.b.i.d.a.a(parama.a());
    A = parama1;
  }
  
  public b(u paramu)
  {
    x = ((l)paramu.a(0)).k();
    y = ((l)paramu.a(1)).k();
    z = new k.b.i.d.a.a(((p)paramu.a(2)).j());
    A = k.b.a.l2.a.a(paramu.a(3));
  }
  
  public t c()
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
 * Qualified Name:     base.k.b.i.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */