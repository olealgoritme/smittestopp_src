package l.a.b.a.g;

import l.a.b.a.d.a;
import l.a.b.a.d.g0.g;
import l.a.b.a.d.h;
import l.a.b.a.d.n;
import l.a.b.a.d.t;

public class b
  extends a
{
  public int a = 0;
  public int b = 1024;
  
  public void onUnhandled(h paramh)
  {
    int i = b;
    g localg = (g)paramh;
    paramh = localg.r();
    int j = localg.z().ordinal();
    if (((j == 19) || (j == 20) || (j == 25) || (j == 27)) && ((paramh instanceof t)))
    {
      j = a;
      j = paramh.g() + j;
      a = j;
      if (j == 0)
      {
        paramh = (t)paramh;
        paramh.a(i - paramh.F());
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */