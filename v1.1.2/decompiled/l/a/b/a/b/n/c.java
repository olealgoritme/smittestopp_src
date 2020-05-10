package l.a.b.a.b.n;

import l.a.b.a.d.g;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.d;
import l.a.b.a.d.g0.f;
import l.a.b.a.d.h.b;

public final class c
  implements l
{
  public j a;
  
  public <E> void a(l.a<E> parama, l.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      Y = true;
      o0 = 0;
      paramE = g.CLOSED;
      y = paramE;
      parama1 = J;
      if (parama1 != null)
      {
        y = paramE;
        paramE = a;
        if (paramE != null) {
          A.a(paramE);
        }
        parama = J;
        parama.a(h.b.CONNECTION_REMOTE_CLOSE, parama);
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Close{error=");
    localStringBuilder.append(a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.n.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */