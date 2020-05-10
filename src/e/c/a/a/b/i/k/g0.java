package e.c.a.a.b.i.k;

import e.c.a.a.b.c;
import e.c.a.a.d.c.d;
import e.c.a.a.d.c.i;
import e.c.a.a.d.c.o;
import e.c.a.a.e.m;
import e.c.a.a.e.n;
import e.c.a.a.g.b;
import java.util.Map;

public final class g0
  extends e0<Boolean>
{
  public final f.a<?> b;
  
  public g0(f.a<?> parama, b<Boolean> paramb)
  {
    super(4, paramb);
    b = parama;
  }
  
  public final c[] b(c.a<?> parama)
  {
    parama = (v)g.get(b);
    if (parama == null) {
      return null;
    }
    return a.b;
  }
  
  public final boolean c(c.a<?> parama)
  {
    parama = (v)g.get(b);
    return (parama != null) && (a.c);
  }
  
  public final void d(c.a<?> parama)
  {
    v localv = (v)g.remove(b);
    if (localv != null)
    {
      Object localObject1 = b;
      Object localObject2 = b;
      parama = a;
      Object localObject3 = (m)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (o)localObject2;
        if (b != null)
        {
          localObject2 = new n(parama);
          try
          {
            localObject3 = a;
            z.a((f.a)localObject3, (d)localObject2);
          }
          catch (RuntimeException localRuntimeException)
          {
            a.b(localRuntimeException);
          }
          a.a.b = null;
          return;
        }
        throw null;
      }
      throw null;
    }
    a.a.b(Boolean.valueOf(false));
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.g0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */