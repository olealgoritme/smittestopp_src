package l.a.b.a.b.n;

import java.util.Map;
import l.a.b.a.b.h;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.d;
import l.a.b.a.d.g0.k0;
import l.a.b.a.d.g0.y;
import l.a.b.a.d.h.b;

public final class g
  implements l
{
  public o a = o.SENDER;
  public h b;
  public h c;
  public boolean d;
  public e e;
  public boolean f;
  
  public void a(h paramh)
  {
    if (paramh != null)
    {
      b = paramh;
      return;
    }
    throw new NullPointerException("the first field is mandatory");
  }
  
  public <E> void a(l.a<E> parama, l.a.b.a.b.a parama1, E paramE)
  {
    parama = (a0)parama;
    if (parama != null)
    {
      parama1 = (Integer)paramE;
      k0 localk0 = (k0)N.get(parama1);
      if (localk0 != null)
      {
        parama1 = b;
        paramE = c;
        parama = paramE;
        if (paramE == null) {
          parama = parama1;
        }
        if (a == o.RECEIVER) {
          paramE = q;
        } else {
          paramE = p;
        }
        while (parama1.b(parama) <= 0)
        {
          l.a.b.a.d.g0.e locale = (l.a.b.a.d.g0.e)paramE.get(parama1);
          if (locale != null)
          {
            e locale1 = e;
            if (locale1 != null)
            {
              L = locale1;
              R = true;
            }
            if (Boolean.TRUE.equals(Boolean.valueOf(d)))
            {
              K = true;
              R = true;
              paramE.remove(parama1);
            }
            locale.l();
            b.H.a(h.b.DELIVERY, locale);
          }
          parama1 = parama1.a(h.A);
        }
      }
      return;
    }
    throw null;
  }
  
  public void a(o paramo)
  {
    if (paramo != null)
    {
      a = paramo;
      return;
    }
    throw new NullPointerException("Role cannot be null");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Disposition{role=");
    localStringBuilder.append(a);
    localStringBuilder.append(", first=");
    localStringBuilder.append(b);
    localStringBuilder.append(", last=");
    localStringBuilder.append(c);
    localStringBuilder.append(", settled=");
    localStringBuilder.append(d);
    localStringBuilder.append(", state=");
    localStringBuilder.append(e);
    localStringBuilder.append(", batchable=");
    localStringBuilder.append(f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.n.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */