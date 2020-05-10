package k.b.g;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import k.b.j.g.f;
import k.b.j.h.b.c;

public class e$f
  implements c
{
  public final d a;
  
  public e$f(e parame, d paramd)
  {
    a = paramd;
  }
  
  public Object a(k.b.j.h.b.b paramb)
  {
    Object localObject = b.iterator();
    i = 0;
    String str = null;
    while (((Iterator)localObject).hasNext())
    {
      k.b.j.h.b.a locala = (k.b.j.h.b.a)((Iterator)localObject).next();
      if ((a.equals("Proc-Type")) && (b.equals("4,ENCRYPTED"))) {
        i = 1;
      } else if (a.equals("DEK-Info")) {
        str = b;
      }
    }
    paramb = c;
    if (i != 0) {}
    try
    {
      localObject = new java/util/StringTokenizer;
      ((StringTokenizer)localObject).<init>(str, ",");
      return new a(((StringTokenizer)localObject).nextToken(), f.a(((StringTokenizer)localObject).nextToken()), paramb, a);
    }
    catch (IllegalArgumentException paramb)
    {
      if (i == 0) {
        break label163;
      }
      throw new b("exception decoding - please check password and data.", paramb);
      throw new b(paramb.getMessage(), paramb);
    }
    catch (IOException paramb)
    {
      if (i == 0) {
        break label192;
      }
      throw new b("exception decoding - please check password and data.", paramb);
      throw new b(paramb.getMessage(), paramb);
    }
    paramb = a.a(paramb);
    return paramb;
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */