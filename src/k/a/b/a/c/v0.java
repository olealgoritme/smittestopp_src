package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import k.a.b.a.b.i;

public class v0
  extends c<i>
{
  public v0.c a;
  public v0.c b;
  public v0.c c;
  
  public v0(x paramx, r paramr)
  {
    a = new v0.a(this, paramx, paramr);
    b = new v0.b(this, paramx, paramr);
    c = new v0.d(this, paramx, paramr);
    c.put(i.class, this);
    paramr.a(this);
  }
  
  public Class<i> a()
  {
    return i.class;
  }
  
  public v0.c a(i parami)
  {
    long l = x;
    boolean bool = l < 0L;
    if (!bool) {
      parami = c;
    } else if ((!bool) && (l <= 255L)) {
      parami = b;
    } else {
      parami = a;
    }
    return parami;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<v0.c> i()
  {
    return Arrays.asList(new v0.c[] { c, b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.v0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */