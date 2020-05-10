package k.b.a.l2;

import k.b.a.e1;
import k.b.a.f;
import k.b.a.n;
import k.b.a.r0;
import k.b.a.t;
import k.b.a.u;

public class d
  extends n
{
  public e x;
  public a y;
  public r0 z;
  
  public d(u paramu)
  {
    if (paramu.size() == 3)
    {
      localObject = paramu.a(0);
      if ((localObject instanceof e)) {
        localObject = (e)localObject;
      } else if (localObject != null) {
        localObject = new e(u.a(localObject));
      } else {
        localObject = null;
      }
      x = ((e)localObject);
      y = a.a(paramu.a(1));
      z = r0.a(paramu.a(2));
      return;
    }
    Object localObject = e.a.a.a.a.a("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public t c()
  {
    f localf = new f(3);
    localf.a(x);
    localf.a(y);
    localf.a(z);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */