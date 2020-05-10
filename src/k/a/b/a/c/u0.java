package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import k.a.b.a.b.h;

public class u0
  extends c<h>
{
  public u0.c a;
  public u0.c b;
  public u0.c c;
  
  public u0(x paramx, r paramr)
  {
    a = new u0.a(this, paramx, paramr);
    b = new u0.b(this, paramx, paramr);
    c = new u0.d(this, paramx, paramr);
    c.put(h.class, this);
    paramr.a(this);
  }
  
  public Class<h> a()
  {
    return h.class;
  }
  
  public u0.c a(h paramh)
  {
    int i = x;
    if (i == 0) {
      paramh = c;
    } else if ((i >= 0) && (i <= 255)) {
      paramh = b;
    } else {
      paramh = a;
    }
    return paramh;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<u0.c> i()
  {
    return Arrays.asList(new u0.c[] { a, b, c });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.u0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */