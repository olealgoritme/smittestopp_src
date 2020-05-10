package l.b.a.l2;

import l.b.a.n;
import l.b.a.r0;
import l.b.a.t;

public class f
  extends n
{
  public l.b.a.u x;
  public u y;
  
  public f(l.b.a.u paramu)
  {
    x = paramu;
    if (paramu.size() == 3)
    {
      Object localObject = paramu.a(0);
      if ((localObject instanceof u)) {
        localObject = (u)localObject;
      } else if (localObject != null) {
        localObject = new u(l.b.a.u.a(localObject));
      } else {
        localObject = null;
      }
      y = ((u)localObject);
      a.a(paramu.a(1));
      r0.a(paramu.a(2));
      return;
    }
    throw new IllegalArgumentException("sequence wrong size for a certificate");
  }
  
  public t b()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */