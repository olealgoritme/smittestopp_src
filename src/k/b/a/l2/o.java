package k.b.a.l2;

import e.a.a.a.a;
import k.b.a.b0;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.n;
import k.b.a.r0;
import k.b.a.t;
import k.b.a.u;

public class o
  extends n
{
  public m x;
  public l y;
  public r0 z;
  
  public o(u paramu)
  {
    if ((paramu.size() != 2) && (paramu.size() != 3))
    {
      StringBuilder localStringBuilder = a.a("Bad sequence size: ");
      localStringBuilder.append(paramu.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    x = m.a(paramu.a(0));
    y = l.a(paramu.a(1));
    if (paramu.size() == 3) {
      z = r0.a(paramu.a(2));
    }
  }
  
  public static o a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = u.a(paramb0, paramBoolean);
    if ((paramb0 instanceof o)) {
      paramb0 = (o)paramb0;
    } else if (paramb0 != null) {
      paramb0 = new o(u.a(paramb0));
    } else {
      paramb0 = null;
    }
    return paramb0;
  }
  
  public t c()
  {
    f localf = new f(3);
    localf.a(x);
    localf.a(y);
    r0 localr0 = z;
    if (localr0 != null) {
      localf.a(localr0);
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */