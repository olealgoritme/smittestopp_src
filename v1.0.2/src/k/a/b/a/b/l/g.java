package k.a.b.a.b.l;

import k.a.b.a.d.g0.v;
import k.a.b.a.d.g0.v.b;
import k.a.b.a.d.w;

public final class g
  implements c
{
  public k.a.b.a.b.a a;
  
  public <E> void a(c.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama1 = (v)parama;
    parama = null;
    if (parama1 != null)
    {
      paramE = (Void)paramE;
      parama1.a(v.b.SERVER);
      paramE = a;
      if (paramE != null) {
        parama = paramE.a();
      }
      i = parama;
      parama = x;
      if (parama != null) {
        parama.onSaslResponse(parama1, d);
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SaslResponse{response=");
    localStringBuilder.append(a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.l.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */