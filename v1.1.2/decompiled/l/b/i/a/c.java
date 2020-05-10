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
import l.b.i.d.a.b;
import l.b.i.d.a.d;
import l.b.i.d.a.e;

public class c
  extends n
{
  public byte[] A;
  public byte[] B;
  public byte[] C;
  public byte[] D;
  public int x;
  public int y;
  public byte[] z;
  
  public c(int paramInt1, int paramInt2, b paramb, e parame, d paramd1, d paramd2, a parama)
  {
    x = paramInt1;
    y = paramInt2;
    z = paramb.a();
    A = parame.c();
    B = parama.a();
    C = paramd1.a();
    D = paramd2.a();
  }
  
  public c(u paramu)
  {
    x = ((l)paramu.a(0)).k();
    y = ((l)paramu.a(1)).k();
    z = ((p)paramu.a(2)).j();
    A = ((p)paramu.a(3)).j();
    C = ((p)paramu.a(4)).j();
    D = ((p)paramu.a(5)).j();
    B = ((p)paramu.a(6)).j();
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new a1(z));
    localf.a(new a1(A));
    localf.a(new a1(C));
    localf.a(new a1(D));
    localf.a(new a1(B));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */