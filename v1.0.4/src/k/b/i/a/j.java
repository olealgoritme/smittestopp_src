package k.b.i.a;

import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.l2.a;
import k.b.a.n;
import k.b.a.t;
import k.b.a.u;

public class j
  extends n
{
  public final a A;
  public final l x;
  public final int y;
  public final int z;
  
  public j(int paramInt1, int paramInt2, a parama)
  {
    x = new l(0L);
    y = paramInt1;
    z = paramInt2;
    A = parama;
  }
  
  public j(u paramu)
  {
    x = l.a(paramu.a(0));
    y = l.a(paramu.a(1)).k();
    z = l.a(paramu.a(2)).k();
    A = a.a(paramu.a(3));
  }
  
  public static j a(Object paramObject)
  {
    if ((paramObject instanceof j)) {
      return (j)paramObject;
    }
    if (paramObject != null) {
      return new j(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    f localf = new f(10);
    localf.a(x);
    localf.a(new l(y));
    localf.a(new l(z));
    localf.a(A);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */