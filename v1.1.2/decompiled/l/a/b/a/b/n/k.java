package l.a.b.a.b.n;

import java.util.Map;
import l.a.b.a.b.h;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.e0;
import l.a.b.a.d.g0.k0;

public final class k
  implements l
{
  public h a;
  public h b;
  public h c;
  public h d;
  public h e;
  public h f;
  public h g;
  public h h;
  public boolean i;
  public boolean j;
  public Map k;
  
  public void a(h paramh)
  {
    if (paramh != null)
    {
      b = paramh;
      return;
    }
    throw new NullPointerException("the incoming-window field is mandatory");
  }
  
  public <E> void a(l.a<E> parama, l.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      parama = (k0)N.get(parama1);
      if (parama != null)
      {
        paramE = a;
        parama1 = b;
        if (paramE != null) {
          o = paramE.a(parama1).c(i);
        } else {
          o = parama1;
        }
        parama1 = e;
        if (parama1 != null) {
          parama.a(parama1).a(this);
        }
      }
      return;
    }
    throw null;
  }
  
  public void b(h paramh)
  {
    if (paramh != null)
    {
      c = paramh;
      return;
    }
    throw new NullPointerException("the next-outgoing-id field is mandatory");
  }
  
  public void c(h paramh)
  {
    if (paramh != null)
    {
      d = paramh;
      return;
    }
    throw new NullPointerException("the outgoing-window field is mandatory");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Flow{nextIncomingId=");
    localStringBuilder.append(a);
    localStringBuilder.append(", incomingWindow=");
    localStringBuilder.append(b);
    localStringBuilder.append(", nextOutgoingId=");
    localStringBuilder.append(c);
    localStringBuilder.append(", outgoingWindow=");
    localStringBuilder.append(d);
    localStringBuilder.append(", handle=");
    localStringBuilder.append(e);
    localStringBuilder.append(", deliveryCount=");
    localStringBuilder.append(f);
    localStringBuilder.append(", linkCredit=");
    localStringBuilder.append(g);
    localStringBuilder.append(", available=");
    localStringBuilder.append(h);
    localStringBuilder.append(", drain=");
    localStringBuilder.append(i);
    localStringBuilder.append(", echo=");
    localStringBuilder.append(j);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.n.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */