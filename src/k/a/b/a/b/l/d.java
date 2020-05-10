package k.a.b.a.b.l;

import k.a.b.a.b.f;
import k.a.b.a.d.g0.v;
import k.a.b.a.d.g0.v.b;
import k.a.b.a.d.w;

public final class d
  implements c
{
  public f a;
  public k.a.b.a.b.a b;
  public String c;
  
  public <E> void a(c.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (v)parama;
    if (parama != null)
    {
      parama1 = (Void)paramE;
      if (v == null) {
        v = v.b.SERVER;
      }
      parama.a(v.b.SERVER);
      r = c;
      u = a;
      m = true;
      parama1 = b;
      if (parama1 != null) {
        i = parama1.a();
      }
      parama1 = x;
      if (parama1 != null) {
        parama1.onSaslInit(parama, d);
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SaslInit{mechanism=");
    localStringBuilder.append(a);
    localStringBuilder.append(", initialResponse=");
    localStringBuilder.append(b);
    localStringBuilder.append(", hostname='");
    localStringBuilder.append(c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.l.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */