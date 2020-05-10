package k.b.a.l2;

import e.a.a.a.a;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.j;
import k.b.a.n;
import k.b.a.t;
import k.b.a.u;

public class c
  extends n
{
  public j x;
  public j y;
  
  public c(u paramu)
  {
    if (paramu.size() == 2)
    {
      x = j.a(paramu.a(0));
      y = j.a(paramu.a(1));
      return;
    }
    StringBuilder localStringBuilder = a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public t c()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */