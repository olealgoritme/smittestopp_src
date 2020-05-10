package k.a.b.a.b.n;

import java.util.Map;
import k.a.b.a.d.g;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.d;
import k.a.b.a.d.g0.f;
import k.a.b.a.d.g0.k0;
import k.a.b.a.d.h.b;

public final class i
  implements l
{
  public j a;
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      paramE = (k0)N.get(parama1);
      if (paramE != null)
      {
        N.remove(parama1);
        s = true;
        paramE.c();
        paramE = b;
        y = g.CLOSED;
        parama1 = a;
        if (parama1 != null) {
          A.a(parama1);
        }
        J.a(h.b.SESSION_REMOTE_CLOSE, paramE);
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("End{error=");
    localStringBuilder.append(a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */