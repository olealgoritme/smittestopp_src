package k.b.g;

import k.b.a.k;
import k.b.a.u;
import k.b.j.h.b.c;

public class e$h
  implements c
{
  public Object a(k.b.j.h.b.b paramb)
  {
    try
    {
      k localk = new k/b/a/k;
      localk.<init>(c);
      paramb = localk.readObject();
      if ((paramb instanceof k.b.a.f2.a)) {
        paramb = (k.b.a.f2.a)paramb;
      } else if (paramb != null) {
        paramb = new k.b.a.f2.a(u.a(paramb));
      } else {
        paramb = null;
      }
      return paramb;
    }
    catch (Exception paramb)
    {
      throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing PKCS7 object: ")), paramb);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */