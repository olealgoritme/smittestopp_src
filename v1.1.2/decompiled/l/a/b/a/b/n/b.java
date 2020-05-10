package l.a.b.a.b.n;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.h;
import l.a.b.a.b.j;
import l.a.b.a.d.g;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.d;
import l.a.b.a.d.g0.k0;
import l.a.b.a.d.g0.y;
import l.a.b.a.d.h.b;

public final class b
  implements l
{
  public j a;
  public h b;
  public h c;
  public h d;
  public h e = h.a(-1);
  public l.a.b.a.b.f[] f;
  public l.a.b.a.b.f[] g;
  public Map h;
  
  public <E> void a(l.a<E> parama, l.a.b.a.b.a parama1, E paramE)
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
          parama1 = J;
          if (parama1 != null)
          {
            parama = new y(parama1);
            H.add(parama);
            parama1 = locala0.a(parama);
          }
          else
          {
            throw null;
          }
        }
        else
        {
          parama1 = (k0)O.get(Integer.valueOf(parama.intValue()));
          if (parama1 == null) {
            break label200;
          }
          parama = b;
        }
        int i = paramE.intValue();
        int j;
        if (d != -1) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {
          b.z();
        }
        d = i;
        y = g.ACTIVE;
        j = b;
        N.put(paramE, parama1);
        J.a(h.b.SESSION_REMOTE_OPEN, parama);
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
 * Qualified Name:     l.a.b.a.b.n.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */