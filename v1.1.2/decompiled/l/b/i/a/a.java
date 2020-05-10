package l.b.i.a;

import l.b.a.a1;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.i.d.a.b;
import l.b.i.d.a.d;
import l.b.i.d.a.e;

public class a
  extends n
{
  public byte[] A;
  public byte[] B;
  public l.b.a.l2.a C;
  public int x;
  public int y;
  public byte[] z;
  
  public a(int paramInt1, int paramInt2, b paramb, e parame, d paramd, l.b.a.l2.a parama)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramb.a();
    A = parame.c();
    B = paramd.a();
    C = parama;
  }
  
  public a(u paramu)
  {
    x = ((l)paramu.a(0)).k();
    y = ((l)paramu.a(1)).k();
    z = ((p)paramu.a(2)).j();
    A = ((p)paramu.a(3)).j();
    B = ((p)paramu.a(4)).j();
    C = l.b.a.l2.a.a(paramu.a(5));
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new a1(z));
    localf.a(new a1(A));
    localf.a(new a1(B));
    localf.a(C);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */