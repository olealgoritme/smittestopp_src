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
import k.b.i.d.a.b;
import k.b.i.d.a.d;
import k.b.i.d.a.e;

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
  
  public t c()
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
 * Qualified Name:     base.k.b.i.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */