package l.b.i.b.f;

import java.util.Map;
import l.b.a.l2.s;

public class a$c
  extends a.e
{
  public l.b.c.d.a a(s params, Object paramObject)
  {
    paramObject = x;
    int i = ((Integer)b.i.get(x)).intValue();
    params = y;
    if (y == 0) {
      return new l.b.i.b.c.b(i, l.b.c.e.a.a(x));
    }
    throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.f.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */