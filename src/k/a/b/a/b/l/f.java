package k.a.b.a.b.l;

import java.util.logging.Level;
import java.util.logging.Logger;
import k.a.b.a.d.g0.v;
import k.a.b.a.d.v.a;
import k.a.b.a.d.w;

public final class f
  implements c
{
  public b a;
  public k.a.b.a.b.a b;
  
  public <E> void a(c.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama1 = (v)parama;
    if (parama1 != null)
    {
      parama = (Void)paramE;
      parama1.a(k.a.b.a.d.g0.v.b.CLIENT);
      for (paramE : v.a.values())
      {
        parama = b;
        if (parama == null) {
          parama = null;
        } else {
          parama = parama.a();
        }
        i = parama;
        if (paramE.getCode() == a.ordinal())
        {
          p = paramE;
          if (q == k.a.b.a.d.v.b.PN_SASL_IDLE) {
            break;
          }
          if (paramE == v.a.PN_SASL_OK) {
            parama = k.a.b.a.d.v.b.PN_SASL_PASS;
          } else {
            parama = k.a.b.a.d.v.b.PN_SASL_FAIL;
          }
          q = parama;
          break;
        }
      }
      s = true;
      if (v.y.isLoggable(Level.FINE))
      {
        parama = v.y;
        paramE = new StringBuilder();
        paramE.append("Handled outcome: ");
        paramE.append(parama1);
        parama.fine(paramE.toString());
      }
      parama = x;
      if (parama != null) {
        parama.onSaslOutcome(parama1, d);
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SaslOutcome{_code=");
    localStringBuilder.append(a);
    localStringBuilder.append(", _additionalData=");
    localStringBuilder.append(b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.l.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */