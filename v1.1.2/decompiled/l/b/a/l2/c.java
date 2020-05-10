package l.b.a.l2;

import e.a.a.a.a;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.j;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

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
  
  public t b()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */