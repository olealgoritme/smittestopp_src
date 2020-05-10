package k.b.g;

import e.a.a.a.a;
import k.b.a.i2.d;
import k.b.a.u;
import k.b.j.h.b.c;

public class e$e
  implements c
{
  public e$e(e parame) {}
  
  public Object a(k.b.j.h.b.b paramb)
  {
    try
    {
      paramb = c;
      if ((paramb instanceof d)) {
        paramb = (d)paramb;
      } else if (paramb != null) {
        paramb = new d(u.a(paramb));
      } else {
        paramb = null;
      }
      paramb = new k.b.h.b(paramb);
      return paramb;
    }
    catch (Exception paramb)
    {
      throw new b(a.a(paramb, a.a("problem parsing ENCRYPTED PRIVATE KEY: ")), paramb);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */