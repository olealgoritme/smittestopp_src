package l.b.a.l2;

import l.b.a.e1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.r0;
import l.b.a.u;

public class g
  extends n
{
  public boolean A = false;
  public int B;
  public t x;
  public a y;
  public r0 z;
  
  public g(u paramu)
  {
    if (paramu.size() == 3)
    {
      Object localObject = paramu.a(0);
      if ((localObject instanceof t)) {
        localObject = (t)localObject;
      } else if (localObject != null) {
        localObject = new t(u.a(localObject));
      } else {
        localObject = null;
      }
      x = ((t)localObject);
      y = a.a(paramu.a(1));
      z = r0.a(paramu.a(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for CertificateList");
  }
  
  public l.b.a.t b()
  {
    f localf = new f(3);
    localf.a(x);
    localf.a(y);
    localf.a(z);
    return new e1(localf);
  }
  
  public int hashCode()
  {
    if (!A)
    {
      B = super.hashCode();
      A = true;
    }
    return B;
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */