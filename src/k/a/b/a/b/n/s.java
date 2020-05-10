package k.a.b.a.b.n;

import java.util.Map;
import k.a.b.a.b.h;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.d;
import k.a.b.a.d.g0.e0;
import k.a.b.a.d.g0.f;
import k.a.b.a.d.g0.i0;
import k.a.b.a.d.g0.m;
import k.a.b.a.d.g0.q;
import k.a.b.a.d.g0.y;
import k.a.b.a.d.g0.z;
import k.a.b.a.d.h.b;

public final class s
  implements l
{
  public h a;
  public h b;
  public k.a.b.a.b.a c;
  public h d;
  public Boolean e;
  public boolean f;
  public n g;
  public e h;
  public boolean i;
  public boolean j;
  public boolean k;
  
  public void a(h paramh)
  {
    if (paramh != null)
    {
      a = paramh;
      return;
    }
    throw new NullPointerException("the handle field is mandatory");
  }
  
  public <E> void a(l.a<E> parama, k.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      paramE = (Integer)paramE;
      k.a.b.a.d.g0.k0 localk0 = (k.a.b.a.d.g0.k0)N.get(paramE);
      if (localk0 != null)
      {
        j = j.a(h.A);
        i0 locali0 = (i0)localk0.a(a);
        parama = j;
        paramE = b;
        Object localObject;
        if ((parama != null) && ((parama.equals(paramE)) || (paramE == null)))
        {
          parama = (k.a.b.a.d.g0.e)p.get(parama);
          paramE = P;
          d += 1;
        }
        else
        {
          localObject = n;
          if (paramE == null) {
            break label670;
          }
          if ((localObject != null) && (x + 1 != x))
          {
            parama = e.a.a.a.a.a("Expected delivery-id ");
            parama.append(((h)localObject).a(h.A));
            parama.append(", got ");
            parama.append(paramE);
            throw new IllegalStateException(parama.toString());
          }
          if (parama != null) {
            break label623;
          }
          n = paramE;
          localObject = (q)f;
          parama = c;
          parama = ((m)localObject).c(a, b, c);
          localObject = d;
          if (localObject != null) {
            N = x;
          }
          P = new z(paramE, parama, locali0);
          j = paramE;
          p.put(paramE, parama);
          paramE = b;
          P += 1;
        }
        paramE = h;
        if (paramE != null)
        {
          L = paramE;
          R = true;
        }
        r += 1;
        boolean bool = j;
        if ((parama1 != null) && (!bool))
        {
          localObject = a;
          if (b <= 0)
          {
            paramE = (E)localObject;
            if (c >= localObject.length) {}
          }
          else
          {
            int m = c;
            paramE = new byte[m];
            System.arraycopy(a, b, paramE, 0, m);
          }
          if (T == null)
          {
            localObject = new k.a.b.a.c.l();
            T = ((k.a.b.a.c.l)localObject);
            U = ((k.a.b.a.c.k0)localObject);
          }
          T.b(paramE);
          b.b(c);
        }
        parama.n();
        if ((!f) || (bool))
        {
          j = null;
          if (!bool) {
            Q = true;
          }
          parama1 = H.V();
          e = e.c(h.A);
          parama1 = H.V();
          d = d.a(h.A);
        }
        if ((Boolean.TRUE.equals(e)) || (bool))
        {
          K = true;
          R = true;
        }
        parama1 = g.c(h.A);
        g = parama1;
        if (parama1.equals(h.z)) {
          H.c(false);
        }
        b.H.a(h.b.DELIVERY, parama);
        break label681;
        label623:
        parama1 = new StringBuilder();
        parama1.append("Illegal multiplex of deliveries on same link with delivery-id ");
        parama1.append(parama);
        parama1.append(" and ");
        parama1.append(paramE);
        throw new IllegalStateException(parama1.toString());
        label670:
        throw new IllegalStateException("No delivery-id specified on first Transfer of new delivery");
      }
      label681:
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Transfer{handle=");
    localStringBuilder.append(a);
    localStringBuilder.append(", deliveryId=");
    localStringBuilder.append(b);
    localStringBuilder.append(", deliveryTag=");
    localStringBuilder.append(c);
    localStringBuilder.append(", messageFormat=");
    localStringBuilder.append(d);
    localStringBuilder.append(", settled=");
    localStringBuilder.append(e);
    localStringBuilder.append(", more=");
    localStringBuilder.append(f);
    localStringBuilder.append(", rcvSettleMode=");
    localStringBuilder.append(g);
    localStringBuilder.append(", state=");
    localStringBuilder.append(h);
    localStringBuilder.append(", resume=");
    localStringBuilder.append(i);
    localStringBuilder.append(", aborted=");
    localStringBuilder.append(j);
    localStringBuilder.append(", batchable=");
    localStringBuilder.append(k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */