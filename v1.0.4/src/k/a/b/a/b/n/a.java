package k.a.b.a.b.n;

import java.util.Arrays;
import java.util.Map;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.d.g;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.e0;
import k.a.b.a.d.g0.k0;
import k.a.b.a.d.g0.y;
import k.a.b.a.d.h.b;

public final class a
  implements l
{
  public String a;
  public h b;
  public o c = o.SENDER;
  public p d = p.MIXED;
  public n e = n.FIRST;
  public q f;
  public r g;
  public Map h;
  public boolean i;
  public h j;
  public i k;
  public k.a.b.a.b.f[] l;
  public k.a.b.a.b.f[] m;
  public Map n;
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    a0 locala0 = (a0)parama;
    parama = null;
    if (locala0 != null)
    {
      parama1 = (Integer)paramE;
      k0 localk0 = (k0)N.get(parama1);
      if (localk0 != null)
      {
        y localy = b;
        paramE = b;
        if (paramE.b(e) > 0)
        {
          parama1 = new j(d.a, "handle-max exceeded");
          J.a(parama1);
          J.x = g.CLOSED;
          if (!L)
          {
            parama = new c();
            a = parama1;
            L = true;
            X.a(0, parama, null, null);
          }
          locala0.close_tail();
        }
        else
        {
          if ((e0)k.get(paramE) == null)
          {
            parama = a;
            parama1 = (e0)m.remove(parama);
            if (parama1 == null)
            {
              if (c == o.RECEIVER) {
                parama = localy.a(a);
              } else {
                parama = localy.b(a);
              }
              parama1 = locala0.a(parama);
            }
            else
            {
              parama = f;
            }
            if (c == o.SENDER) {
              d = j;
            }
            y = g.ACTIVE;
            N = f;
            P = g;
            b = a;
            if (c == null) {
              f.w();
            }
            c = paramE;
            k.put(paramE, parama1);
          }
          J.a(h.b.LINK_REMOTE_OPEN, parama);
        }
      }
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Attach{name='");
    e.a.a.a.a.a(localStringBuilder, a, '\'', ", handle=");
    localStringBuilder.append(b);
    localStringBuilder.append(", role=");
    localStringBuilder.append(c);
    localStringBuilder.append(", sndSettleMode=");
    localStringBuilder.append(d);
    localStringBuilder.append(", rcvSettleMode=");
    localStringBuilder.append(e);
    localStringBuilder.append(", source=");
    localStringBuilder.append(f);
    localStringBuilder.append(", target=");
    localStringBuilder.append(g);
    localStringBuilder.append(", unsettled=");
    localStringBuilder.append(h);
    localStringBuilder.append(", incompleteUnsettled=");
    localStringBuilder.append(i);
    localStringBuilder.append(", initialDeliveryCount=");
    localStringBuilder.append(j);
    localStringBuilder.append(", maxMessageSize=");
    localStringBuilder.append(k);
    localStringBuilder.append(", offeredCapabilities=");
    Object localObject1 = l;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", desiredCapabilities=");
    localObject1 = m;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(n);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */