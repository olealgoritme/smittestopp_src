package e.c.a.a.d.c;

import android.content.Context;
import android.os.IInterface;
import e.c.a.a.b.i.k.f;
import e.c.a.a.b.i.k.f.a;
import e.c.a.a.e.b;
import e.c.a.a.e.r;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class i
{
  public final w<g> a;
  public boolean b = false;
  public final Map<f.a<Object>, n> c = new HashMap();
  public final Map<f.a<Object>, m> d = new HashMap();
  public final Map<f.a<b>, j> e = new HashMap();
  
  public i(Context paramContext, w<g> paramw)
  {
    a = paramw;
  }
  
  public final j a(f<b> paramf)
  {
    synchronized (e)
    {
      j localj1 = (j)e.get(c);
      j localj2 = localj1;
      if (localj1 == null)
      {
        localj2 = new e/c/a/a/d/c/j;
        localj2.<init>(paramf);
      }
      e.put(c, localj2);
      return localj2;
    }
  }
  
  public final void a()
  {
    synchronized (c)
    {
      Object localObject1 = c.values().iterator();
      Object localObject2;
      g localg;
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localg = (g)a.b();
          localObject3 = new e/c/a/a/d/c/s;
          ((s)localObject3).<init>(2, null, ((IInterface)localObject2).asBinder(), null, null, null);
          localg.a((s)localObject3);
        }
      }
      c.clear();
      synchronized (e)
      {
        localObject1 = e.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (j)((Iterator)localObject1).next();
          if (localObject3 != null) {
            ((g)a.b()).a(s.a((r)localObject3, null));
          }
        }
        e.clear();
        synchronized (d)
        {
          localObject2 = d.values().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (m)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localg = (g)a.b();
              localObject1 = new e/c/a/a/d/c/z;
              ((z)localObject1).<init>(2, null, ((IInterface)localObject3).asBinder(), null);
              localg.a((z)localObject1);
            }
          }
          d.clear();
          return;
        }
      }
    }
  }
  
  public final void a(f.a<b> parama, d paramd)
  {
    a.a();
    d.b.a.s.b(parama, "Invalid null listener key");
    synchronized (e)
    {
      parama = (j)e.remove(parama);
      if (parama != null)
      {
        parama.c();
        ((g)a.b()).a(s.a(parama, paramd));
      }
      return;
    }
  }
  
  public final void b()
  {
    if (b)
    {
      a.a();
      ((g)a.b()).a(false);
      b = false;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.d.c.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */