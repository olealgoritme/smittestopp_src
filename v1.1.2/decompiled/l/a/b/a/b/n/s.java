package l.a.b.a.b.n;

import java.util.Map;
import l.a.b.a.b.h;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.d;
import l.a.b.a.d.g0.e0;
import l.a.b.a.d.g0.f;
import l.a.b.a.d.g0.i0;
import l.a.b.a.d.g0.m;
import l.a.b.a.d.g0.q;
import l.a.b.a.d.g0.y;
import l.a.b.a.d.g0.z;
import l.a.b.a.d.h.b;

public final class s
  implements l
{
  public h a;
  public h b;
  public l.a.b.a.b.a c;
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
  
  public <E> void a(l.a<E> parama, l.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      paramE = (Integer)paramE;
      l.a.b.a.d.g0.k0 localk0 = (l.a.b.a.d.g0.k0)N.get(paramE);
      if (localk0 != null)
      {
        j = j.a(h.A);
        i0 locali0 = (i0)localk0.a(a);
        Object localObject = j;
        paramE = b;
        if ((localObject != null) && ((((h)localObject).equals(paramE)) || (paramE == null)))
        {
          parama = (l.a.b.a.d.g0.e)p.get(localObject);
          paramE = P;
          d += 1;
        }
        else
        {
          parama = n;
          if (paramE == null) {
            break label674;
          }
          if ((parama != null) && (x + 1 != x))
          {
            parama1 = e.a.a.a.a.a("Expected delivery-id ");
            parama1.append(parama.a(h.A));
            parama1.append(", got ");
            parama1.append(paramE);
            throw new IllegalStateException(parama1.toString());
          }
          if (localObject != null) {
            break label626;
          }
          n = paramE;
          parama = (q)f;
          localObject = c;
          parama = parama.c(a, b, c);
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
            localObject = new l.a.b.a.c.l();
            T = ((l.a.b.a.c.l)localObject);
            U = ((l.a.b.a.c.k0)localObject);
          }
          T.b(paramE);
          b.b(c);
        }
        parama.l();
        if ((!f) || (bool))
        {
          j = null;
          if (!bool) {
            Q = true;
          }
          parama1 = H.U();
          e = e.c(h.A);
          parama1 = H.U();
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
        break label685;
        label626:
        parama = new StringBuilder();
        parama.append("Illegal multiplex of deliveries on same link with delivery-id ");
        parama.append(localObject);
        parama.append(" and ");
        parama.append(paramE);
        throw new IllegalStateException(parama.toString());
        label674:
        throw new IllegalStateException("No delivery-id specified on first Transfer of new delivery");
      }
      label685:
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
 * Qualified Name:     l.a.b.a.b.n.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */