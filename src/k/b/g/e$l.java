package k.b.g;

import java.io.IOException;
import k.b.a.i2.h;
import k.b.a.l2.s;
import k.b.a.u;
import k.b.a.y0;
import k.b.j.h.b.c;

public class e$l
  implements c
{
  public e$l(e parame) {}
  
  public Object a(k.b.j.h.b.b paramb)
  {
    try
    {
      paramb = c;
      if ((paramb instanceof h)) {
        paramb = (h)paramb;
      } else if (paramb != null) {
        paramb = new h(u.a(paramb));
      } else {
        paramb = null;
      }
      k.b.a.l2.a locala = new k/b/a/l2/a;
      locala.<init>(k.b.a.i2.e.b, y0.x);
      paramb = new s(locala, paramb);
      return paramb;
    }
    catch (Exception paramb)
    {
      throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem extracting key: ")), paramb);
    }
    catch (IOException paramb)
    {
      throw paramb;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */