package l.b.a.f2;

import l.b.a.b0;
import l.b.a.e;
import l.b.a.f;
import l.b.a.j0;
import l.b.a.n;
import l.b.a.n0;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;

public class a
  extends n
{
  public o x;
  public e y;
  
  public a(u paramu)
  {
    if ((paramu.size() >= 1) && (paramu.size() <= 2))
    {
      x = ((o)paramu.a(0));
      if (paramu.size() > 1)
      {
        paramu = (b0)paramu.a(1);
        if ((y) && (x == 0)) {
          y = paramu.j();
        } else {
          throw new IllegalArgumentException("Bad tag for 'content'");
        }
      }
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public t b()
  {
    f localf = new f(2);
    localf.a(x);
    e locale = y;
    if (locale != null) {
      localf.a(new n0(0, locale));
    }
    return new j0(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.f2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */