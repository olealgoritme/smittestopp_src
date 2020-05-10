package e.c.a.a.b.i.k;

import d.b.a.s;
import e.c.a.a.b.i.a;
import e.c.a.a.b.i.a.d;
import java.util.Arrays;

public final class h0<O extends a.d>
{
  public final boolean a = false;
  public final int b;
  public final a<O> c;
  public final O d;
  
  public h0(a<O> parama, O paramO)
  {
    c = parama;
    d = paramO;
    b = Arrays.hashCode(new Object[] { parama, paramO });
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h0)) {
      return false;
    }
    paramObject = (h0)paramObject;
    return (!a) && (!a) && (s.c(c, c)) && (s.c(d, d));
  }
  
  public final int hashCode()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.h0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */