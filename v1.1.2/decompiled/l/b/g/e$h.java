package l.b.g;

import l.b.a.k;
import l.b.a.u;
import l.b.j.h.b.c;

public class e$h
  implements c
{
  public Object a(l.b.j.h.b.b paramb)
  {
    try
    {
      k localk = new l/b/a/k;
      localk.<init>(c);
      paramb = localk.readObject();
      if ((paramb instanceof l.b.a.f2.a)) {
        paramb = (l.b.a.f2.a)paramb;
      } else if (paramb != null) {
        paramb = new l.b.a.f2.a(u.a(paramb));
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
 * Qualified Name:     l.b.g.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */