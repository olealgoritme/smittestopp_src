package k.a.b.a.g.i;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.b.a.d.g0.r;
import k.a.b.a.d.h.b;
import k.a.b.a.d.u;
import k.a.b.a.g.e;

public class d
  implements k.a.b.a.g.d, k.a.b.a.d.j
{
  public static final k.a.b.a.d.k<k.a.b.a.d.h, k.a.b.a.d.l> O = new k.a.b.a.d.k(k.a.b.a.d.l.class);
  public k.a.b.a.d.l A = new b();
  public k.a.b.a.d.l B = new k.a.b.a.d.a();
  public Set<e> C = new HashSet();
  public int D = 0;
  public boolean E;
  public boolean F;
  public k.a.b.a.g.g G;
  public k.a.b.a.d.i H;
  public m I = new m(x);
  public final Pipe J;
  public k K;
  public u L;
  public final c M;
  public final k.a.b.a.g.f N;
  public k.a.b.a.d.g0.c x = new k.a.b.a.d.g0.c();
  public long y;
  public long z;
  
  public d()
  {
    this(new c(), new k.a.b.a.g.f());
  }
  
  public d(c paramc, k.a.b.a.g.f paramf)
  {
    M = paramc;
    if (paramc != null)
    {
      J = Pipe.open();
      n();
      L = new r();
      N = paramf;
      return;
    }
    throw null;
  }
  
  public k.a.b.a.g.f B()
  {
    return N;
  }
  
  public k.a.b.a.d.l F()
  {
    return B;
  }
  
  public long S()
  {
    return y;
  }
  
  public String a(k.a.b.a.d.c paramc)
  {
    paramc = (a)a.class.cast(qa.get("pn_reactor_connection_peer_address"));
    if (paramc != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(d);
      if (e != null)
      {
        StringBuilder localStringBuilder2 = e.a.a.a.a.a(":");
        localStringBuilder2.append(e);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      return localStringBuilder1.toString();
    }
    return null;
  }
  
  public k.a.b.a.d.c a(String paramString, int paramInt, k.a.b.a.d.l paraml)
  {
    k.a.b.a.d.g0.d locald = new k.a.b.a.d.g0.d();
    k.a.b.a.d.a.setHandler(locald, paraml);
    locald.a(x);
    C.add(locald);
    Y = this;
    r localr = (r)locald.q();
    if (k.a.b.a.g.a.class.cast(a.get("pn_reactor_connection_acceptor")) == null)
    {
      paraml = new a();
      d = paramString;
      int i = paramInt;
      if (paramInt == 0) {
        i = 5672;
      }
      e = Integer.toString(i);
      a.put("pn_reactor_connection_peer_address", paraml);
      return locald;
    }
    throw new IllegalStateException("Cannot set the host address on an incoming Connection");
  }
  
  public k.a.b.a.g.h a(int paramInt, k.a.b.a.d.l paraml)
  {
    m localm = I;
    l locall = new l(y + paramInt, c.incrementAndGet());
    b.add(locall);
    B = this;
    k.a.b.a.d.a.setHandler(locall, paraml);
    paraml = G;
    if (paraml != null)
    {
      paraml.c(I.a());
      a(G);
    }
    return locall;
  }
  
  public void a()
  {
    if (J.source().isOpen()) {
      try
      {
        J.source().close();
      }
      catch (IOException localIOException1) {}
    }
    if (J.sink().isOpen()) {
      try
      {
        J.sink().close();
      }
      catch (IOException localIOException2) {}
    }
    Object localObject = K;
    if ((localObject == null) || (localObject != null)) {}
    try
    {
      a.close();
    }
    catch (IOException localIOException3)
    {
      for (;;) {}
    }
    throw null;
    localObject = C.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e)((Iterator)localObject).next()).a();
    }
  }
  
  public final void a(k.a.b.a.d.h paramh, k.a.b.a.d.l paraml)
  {
    k.a.b.a.d.k localk = O;
    if (localk != null)
    {
      paramh = (k.a.b.a.d.g0.g)paramh;
      qa.put(localk, paraml);
      paramh.a(paraml);
      return;
    }
    throw null;
  }
  
  public void a(k.a.b.a.g.g paramg)
  {
    j localj = (j)paramg;
    if (!L) {
      if (K)
      {
        L = true;
        x.a(h.b.SELECTABLE_FINAL, paramg);
      }
      else
      {
        x.a(h.b.SELECTABLE_UPDATED, paramg);
      }
    }
  }
  
  public void b(long paramLong)
  {
    z = paramLong;
  }
  
  public long h()
  {
    return z;
  }
  
  public void i()
  {
    E = true;
  }
  
  public long n()
  {
    long l = System.currentTimeMillis();
    y = l;
    return l;
  }
  
  public boolean o()
  {
    k.a.b.a.d.g0.g localg = x.a;
    boolean bool = true;
    if (localg == null) {
      return true;
    }
    int i;
    if (z != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return false;
    }
    if (x != h.b.REACTOR_QUIESCED) {
      bool = false;
    }
    return bool;
  }
  
  public boolean process()
  {
    n();
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2 = x.a;
      if (localObject2 != null)
      {
        if (E)
        {
          E = false;
          return true;
        }
        if (((k.a.b.a.d.g0.g)localObject2).G() != null)
        {
          localObject1 = k.a.b.a.d.a.getHandler(((k.a.b.a.d.g0.g)localObject2).G());
          if (localObject1 != null) {}
        }
        else if (((k.a.b.a.d.g0.g)localObject2).T() != null)
        {
          localObject1 = k.a.b.a.d.a.getHandler(((k.a.b.a.d.g0.g)localObject2).T());
          if (localObject1 != null) {}
        }
        else if (((k.a.b.a.d.g0.g)localObject2).U() != null)
        {
          localObject1 = k.a.b.a.d.a.getHandler(((k.a.b.a.d.g0.g)localObject2).U());
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = y;
          if ((localObject1 instanceof k.a.b.a.g.h)) {
            localObject1 = (k.a.b.a.g.h)localObject1;
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject1 = y;
            if ((localObject1 instanceof k.a.b.a.g.h)) {
              localObject1 = (k.a.b.a.g.h)localObject1;
            } else {
              localObject1 = null;
            }
            localObject1 = k.a.b.a.d.a.getHandler((k.a.b.a.d.j)localObject1);
            if (localObject1 != null) {}
          }
          else if (((k.a.b.a.d.g0.g)localObject2).n() != null)
          {
            localObject1 = k.a.b.a.d.a.getHandler(((k.a.b.a.d.g0.g)localObject2).n());
            if (localObject1 != null) {}
          }
          else
          {
            localObject1 = B;
          }
        }
        a((k.a.b.a.d.h)localObject2, (k.a.b.a.d.l)localObject1);
        a((k.a.b.a.d.h)localObject2, A);
        if (x == h.b.CONNECTION_FINAL) {
          C.remove(((k.a.b.a.d.g0.g)localObject2).U());
        }
        localObject2 = x;
        H = ((k.a.b.a.d.i)localObject2);
        k.a.b.a.d.g0.c localc = x;
        k.a.b.a.d.g0.g localg = a;
        localObject1 = localObject2;
        if (localg != null)
        {
          localObject1 = z;
          z = c;
          c = localg;
          x = null;
          y = null;
          A.a.clear();
          a = ((k.a.b.a.d.g0.g)localObject1);
          localObject1 = localObject2;
        }
      }
      else
      {
        if (!F)
        {
          localObject2 = I;
          ((m)localObject2).b();
          int i;
          if ((b.size() <= 0) && (D <= 1)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            if ((localObject1 != h.b.REACTOR_QUIESCED) && (H != h.b.REACTOR_FINAL))
            {
              x.a(h.b.REACTOR_QUIESCED, this);
              continue;
            }
            return true;
          }
        }
        localObject2 = G;
        if (localObject2 == null) {
          break;
        }
        ((k.a.b.a.g.g)localObject2).p();
        a(G);
        G = null;
      }
    }
    x.a(h.b.REACTOR_FINAL, this);
    return false;
  }
  
  public u q()
  {
    return L;
  }
  
  public void start()
  {
    x.a(h.b.REACTOR_INIT, this);
    k.a.b.a.g.g localg = w();
    localg.a(J.source());
    localg.a(new d.e(this, null));
    localg.e(new d.c(this, null));
    localg.c(new d.d(null));
    localg.a(true);
    localg.c(I.a());
    a(localg);
    G = localg;
  }
  
  public void stop()
  {
    F = true;
  }
  
  public k.a.b.a.g.g w()
  {
    j localj = new j();
    k.a.b.a.d.g0.c localc = x;
    x = new f(localj, localc);
    y = new g(localj, localc);
    A = new h(localj, localc);
    z = new i(localj, localc);
    x.a(h.b.SELECTABLE_INIT, localj);
    I = this;
    C.add(localj);
    B = new d.b(this, this, localj);
    D += 1;
    return localj;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.g.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */