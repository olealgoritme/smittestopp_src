package k.b.g;

import e.a.a.a.a;
import java.io.IOException;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u;
import k.b.j.h.b.c;

public class e$c
  implements c
{
  public Object a(k.b.j.h.b.b paramb)
  {
    try
    {
      t localt = t.a(c);
      if ((localt instanceof o)) {
        return t.a(c);
      }
      if ((localt instanceof u))
      {
        paramb = k.b.a.m2.b.a(localt);
        return paramb;
      }
      return null;
    }
    catch (Exception paramb)
    {
      throw new b(a.a(paramb, a.a("exception extracting EC named curve: ")));
    }
    catch (IOException paramb)
    {
      throw paramb;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */