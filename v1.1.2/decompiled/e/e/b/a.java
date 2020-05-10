package e.e.b;

import e.e.a.g;
import e.e.a.k;
import e.e.a.p;
import j.a.b.d;
import java.text.ParseException;

public class a
  extends k
  implements b
{
  public a(e.e.a.v.c paramc1, e.e.a.v.c paramc2, e.e.a.v.c paramc3, e.e.a.v.c paramc4, e.e.a.v.c paramc5)
  {
    super(paramc1, paramc2, paramc3, paramc4, paramc5);
  }
  
  public c b()
  {
    Object localObject = x;
    if (localObject == null) {
      return null;
    }
    localObject = ((p)localObject).c();
    if (localObject != null) {
      return c.a((d)localObject);
    }
    throw new ParseException("Payload of JWE object is not a valid JSON object", 0);
  }
}

/* Location:
 * Qualified Name:     e.e.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */