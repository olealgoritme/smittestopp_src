package e.e.b;

import e.e.a.g;
import e.e.a.m;
import e.e.a.n;
import e.e.a.p;
import j.a.b.d;
import java.text.ParseException;

public class e
  extends n
  implements b
{
  public e(m paramm, c paramc)
  {
    super(paramm, new p(paramc.a()));
  }
  
  public e(e.e.a.v.c paramc1, e.e.a.v.c paramc2, e.e.a.v.c paramc3)
  {
    super(paramc1, paramc2, paramc3);
  }
  
  public c b()
  {
    d locald = x.c();
    if (locald != null) {
      return c.a(locald);
    }
    throw new ParseException("Payload of JWS object is not a valid JSON object", 0);
  }
}

/* Location:
 * Qualified Name:     e.e.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */