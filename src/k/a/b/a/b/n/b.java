package k.a.b.a.b.n;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import k.a.b.a.b.h;
import k.a.b.a.b.j;
import k.a.b.a.d.g;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.d;
import k.a.b.a.d.g0.k0;
import k.a.b.a.d.g0.y;
import k.a.b.a.d.h.b;

public final class b
  implements l
{
  public j a;
  public h b;
  public h c;
  public h d;
  public h e = h.a(-1);
  public k.a.b.a.b.f[] f;
  public k.a.b.a.b.f[] g;
  public Map h;
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    a0 locala0 = (a0)parama;
    if (locala0 != null)
    {
      paramE = (Integer)paramE;
      if ((k0)N.get(paramE) == null)
      {
        parama = a;
        if (parama == null)
        {
          parama = J;
          if (parama != null)
          {
            parama1 = new y(parama);
            H.add(parama1);
            parama = locala0.a(parama1);
          }
          else
          {
            throw null;
          }
        }
        else
        {
          parama = (k0)O.get(Integer.valueOf(parama.intValue()));
          if (parama == null) {
            break label200;
          }
          parama1 = b;
        }
        int i = paramE.intValue();
        int j;
        if (d != -1) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {
          b.w();
        }
        d = i;
        y = g.ACTIVE;
        j = b;
        N.put(paramE, parama);
        J.a(h.b.SESSION_REMOTE_OPEN, parama1);
      }
      else
      {
        return;
      }
      label200:
      parama = e.a.a.a.a.a("uncorrelated channel: ");
      parama.append(a);
      throw new NullPointerException(parama.toString());
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Begin{remoteChannel=");
    localStringBuilder.append(a);
    localStringBuilder.append(", nextOutgoingId=");
    localStringBuilder.append(b);
    localStringBuilder.append(", incomingWindow=");
    localStringBuilder.append(c);
    localStringBuilder.append(", outgoingWindow=");
    localStringBuilder.append(d);
    localStringBuilder.append(", handleMax=");
    localStringBuilder.append(e);
    localStringBuilder.append(", offeredCapabilities=");
    Object localObject1 = f;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", desiredCapabilities=");
    localObject1 = g;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */