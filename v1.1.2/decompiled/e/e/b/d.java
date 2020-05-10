package e.e.b;

import e.a.a.a.a;
import e.e.a.g;
import e.e.a.p;
import e.e.a.q;
import java.text.ParseException;

public class d
  extends g
  implements b
{
  public final q z;
  
  public d(q paramq, c paramc)
  {
    if (paramq != null)
    {
      z = paramq;
      x = paramc;
      return;
    }
    throw new IllegalArgumentException("The unsecured header must not be null");
  }
  
  public d(e.e.a.v.c paramc1, e.e.a.v.c paramc2)
  {
    if (paramc1 != null) {
      try
      {
        z = q.a(paramc1);
        if (paramc2 != null)
        {
          x = new p(paramc2);
          y = new e.e.a.v.c[] { paramc1, paramc2, null };
          return;
        }
        throw new IllegalArgumentException("The second part must not be null");
      }
      catch (ParseException paramc1)
      {
        paramc2 = a.a("Invalid unsecured header: ");
        paramc2.append(paramc1.getMessage());
        throw new ParseException(paramc2.toString(), 0);
      }
    }
    throw new IllegalArgumentException("The first part must not be null");
  }
  
  public c b()
  {
    j.a.b.d locald = x.c();
    if (locald != null) {
      return c.a(locald);
    }
    throw new ParseException("Payload of unsecured JOSE object is not a valid JSON object", 0);
  }
}

/* Location:
 * Qualified Name:     e.e.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */