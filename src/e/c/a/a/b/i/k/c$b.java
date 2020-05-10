package e.c.a.a.b.i.k;

import d.b.a.r;
import e.c.a.a.b.c;
import e.c.a.a.b.j.o;
import java.util.Arrays;

public final class c$b
{
  public final h0<?> a;
  public final c b;
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((r.c(a, a)) && (r.c(b, b))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b });
  }
  
  public final String toString()
  {
    o localo = r.c(this);
    localo.a("key", a);
    localo.a("feature", b);
    return localo.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */