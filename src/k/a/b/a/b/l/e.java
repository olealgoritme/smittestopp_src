package k.a.b.a.b.l;

import java.util.Arrays;
import k.a.b.a.b.f;
import k.a.b.a.d.g0.v;
import k.a.b.a.d.g0.v.b;
import k.a.b.a.d.w;

public final class e
  implements c
{
  public f[] a;
  
  public <E> void a(c.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (v)parama;
    if (parama != null)
    {
      parama1 = (Void)paramE;
      if (v == null) {
        parama.a();
      }
      parama.a(v.b.CLIENT);
      t = a;
      parama1 = x;
      if (parama1 != null) {
        parama1.onSaslMechanisms(parama, d);
      }
      return;
    }
    throw null;
  }
  
  public void a(f... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      a = paramVarArgs;
      return;
    }
    throw new NullPointerException("the sasl-server-mechanisms field is mandatory");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SaslMechanisms{saslServerMechanisms=");
    Object localObject = a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Arrays.asList((Object[])localObject);
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.l.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */