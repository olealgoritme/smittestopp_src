package k.a.b.a.b.n;

import java.util.Map;
import k.a.b.a.b.h;
import k.a.b.a.d.g;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.d;
import k.a.b.a.d.g0.e0;
import k.a.b.a.d.g0.k0;
import k.a.b.a.d.h.b;

public final class f
  implements l
{
  public h a;
  public boolean b;
  public j c;
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      k0 localk0 = (k0)N.get(parama1);
      if (localk0 != null)
      {
        e0 locale0 = localk0.a(a);
        if (locale0 != null)
        {
          parama1 = f;
          h = true;
          paramE = c;
          k.remove(paramE);
          if (b) {
            J.a(h.b.LINK_REMOTE_CLOSE, parama1);
          } else {
            J.a(h.b.LINK_REMOTE_DETACH, parama1);
          }
          if (c != null) {
            f.i();
          }
          c = null;
          y = g.CLOSED;
          parama = c;
          if (parama != null) {
            A.a(parama);
          }
        }
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Detach{handle=");
    localStringBuilder.append(a);
    localStringBuilder.append(", closed=");
    localStringBuilder.append(b);
    localStringBuilder.append(", error=");
    localStringBuilder.append(c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */