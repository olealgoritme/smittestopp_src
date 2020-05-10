package l.a.b.a.g.i;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import l.a.b.a.d.g0.r;
import l.a.b.a.d.h.b;
import l.a.b.a.d.u;
import l.a.b.a.g.e;
import l.a.b.a.g.g.a;

public class d
  implements l.a.b.a.g.d, l.a.b.a.d.j
{
  public static final l.a.b.a.d.k<l.a.b.a.d.h, l.a.b.a.d.l> O = new l.a.b.a.d.k(l.a.b.a.d.l.class);
  public l.a.b.a.d.l A = new b();
  public l.a.b.a.d.l B = new l.a.b.a.d.a();
  public Set<e> C = new HashSet();
  public int D = 0;
  public boolean E;
  public boolean F;
  public l.a.b.a.g.g G;
  public l.a.b.a.d.i H;
  public m I = new m(x);
  public final Pipe J;
  public k K;
  public u L;
  public final c M;
  public final l.a.b.a.g.f N;
  public l.a.b.a.d.g0.c x = new l.a.b.a.d.g0.c();
  public long y;
  public long z;
  
  public d()
  {
    this(new c(), new l.a.b.a.g.f());
  }
  
  public d(c paramc, l.a.b.a.g.f paramf)
  {
    M = paramc;
    if (paramc != null)
    {
      J = Pipe.open();
      k();
      L = new r();
      N = paramf;
      return;
    }
    throw null;
  }
  
  public u B()
  {
    return L;
  }
  
  public l.a.b.a.g.f J()
  {
    return N;
  }
  
  public l.a.b.a.d.l M()
  {
    return B;
  }
  
  public long S()
  {
    return y;
  }
  
  public l.a.b.a.d.c a(String paramString, int paramInt, l.a.b.a.d.l paraml)
  {
    l.a.b.a.d.g0.d locald = new l.a.b.a.d.g0.d();
    l.a.b.a.d.a.setHandler(locald, paraml);
    locald.a(x);
    C.add(locald);
    Y = this;
    paraml = (r)locald.B();
    if (l.a.b.a.g.a.class.cast(a.get("pn_reactor_connection_acceptor")) == null)
    {
      a locala = new a();
      d = paramString;
      int i = paramInt;
      if (paramInt == 0) {
        i = 5672;
      }
      e = Integer.toString(i);
      a.put("pn_reactor_connection_peer_address", locala);
      return locald;
    }
    throw new IllegalStateException("Cannot set the host address on an incoming Connection");
  }
  
  public l.a.b.a.g.h a(int paramInt, l.a.b.a.d.l paraml)
  {
    m localm = I;
    l locall = new l(y + paramInt, c.incrementAndGet());
    b.add(locall);
    B = this;
    l.a.b.a.d.a.setHandler(locall, paraml);
    paraml = G;
    if (paraml != null)
    {
      paraml.a(I.a());
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
  
  public final void a(l.a.b.a.d.h paramh, l.a.b.a.d.l paraml)
  {
    l.a.b.a.d.k localk = O;
    if (localk != null)
    {
      paramh = (l.a.b.a.d.g0.g)paramh;
      Ba.put(localk, paraml);
      paramh.a(paraml);
      return;
    }
    throw null;
  }
  
  public void a(l.a.b.a.g.g paramg)
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
  
  public String b(l.a.b.a.d.c paramc)
  {
    a locala = (a)a.class.cast(Ba.get("pn_reactor_connection_peer_address"));
    if (locala != null)
    {
      paramc = new StringBuilder(d);
      if (e != null)
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a(":");
        localStringBuilder.append(e);
        paramc.append(localStringBuilder.toString());
      }
      return paramc.toString();
    }
    return null;
  }
  
  public void c(long paramLong)
  {
    z = paramLong;
  }
  
  public void h()
  {
    E = true;
  }
  
  public long k()
  {
    long l = System.currentTimeMillis();
    y = l;
    return l;
  }
  
  public boolean l()
  {
    l.a.b.a.d.g0.g localg = x.a;
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
  
  public l.a.b.a.g.g p()
  {
    j localj = new j();
    l.a.b.a.d.g0.c localc = x;
    x = new f(localj, localc);
    y = new g(localj, localc);
    A = new h(localj, localc);
    z = new i(localj, localc);
    x.a(h.b.SELECTABLE_INIT, localj);
    I = this;
    C.add(localj);
    B = new b(this, localj);
    D += 1;
    return localj;
  }
  
  public boolean process()
  {
    k();
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
        if (((l.a.b.a.d.g0.g)localObject2).r() != null)
        {
          localObject1 = l.a.b.a.d.a.getHandler(((l.a.b.a.d.g0.g)localObject2).r());
          if (localObject1 != null) {}
        }
        else if (((l.a.b.a.d.g0.g)localObject2).y() != null)
        {
          localObject1 = l.a.b.a.d.a.getHandler(((l.a.b.a.d.g0.g)localObject2).y());
          if (localObject1 != null) {}
        }
        else if (((l.a.b.a.d.g0.g)localObject2).T() != null)
        {
          localObject1 = l.a.b.a.d.a.getHandler(((l.a.b.a.d.g0.g)localObject2).T());
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = y;
          if ((localObject1 instanceof l.a.b.a.g.h)) {
            localObject1 = (l.a.b.a.g.h)localObject1;
          } else {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject1 = y;
            if ((localObject1 instanceof l.a.b.a.g.h)) {
              localObject1 = (l.a.b.a.g.h)localObject1;
            } else {
              localObject1 = null;
            }
            localObject1 = l.a.b.a.d.a.getHandler((l.a.b.a.d.j)localObject1);
            if (localObject1 != null) {}
          }
          else if (((l.a.b.a.d.g0.g)localObject2).l() != null)
          {
            localObject1 = l.a.b.a.d.a.getHandler(((l.a.b.a.d.g0.g)localObject2).l());
            if (localObject1 != null) {}
          }
          else
          {
            localObject1 = B;
          }
        }
        a((l.a.b.a.d.h)localObject2, (l.a.b.a.d.l)localObject1);
        a((l.a.b.a.d.h)localObject2, A);
        if (x == h.b.CONNECTION_FINAL) {
          C.remove(((l.a.b.a.d.g0.g)localObject2).T());
        }
        localObject2 = x;
        H = ((l.a.b.a.d.i)localObject2);
        l.a.b.a.d.g0.c localc = x;
        l.a.b.a.d.g0.g localg = a;
        localObject1 = localObject2;
        if (localg != null)
        {
          localObject1 = z;
          z = c;
          c = localg;
          x = null;
          y = null;
          A.a.clear();
          a = ((l.a.b.a.d.g0.g)localObject1);
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
        ((l.a.b.a.g.g)localObject2).m();
        a(G);
        G = null;
      }
    }
    x.a(h.b.REACTOR_FINAL, this);
    return false;
  }
  
  public void start()
  {
    x.a(h.b.REACTOR_INIT, this);
    l.a.b.a.g.g localg = p();
    localg.a(J.source());
    localg.d(new e(null));
    localg.e(new c(null));
    localg.b(new d(null));
    localg.a(true);
    localg.a(I.a());
    a(localg);
    G = localg;
  }
  
  public void stop()
  {
    F = true;
  }
  
  public long z()
  {
    return z;
  }
  
  public class b
    implements g.a
  {
    public final d a;
    public final e b;
    
    public b(d paramd, e parame)
    {
      a = paramd;
      b = parame;
    }
    
    public void a(l.a.b.a.g.g paramg)
    {
      if (a.C.remove(b))
      {
        paramg = a;
        D -= 1;
        b.a();
      }
    }
  }
  
  public class c
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      d.a(a, paramg);
    }
  }
  
  public static class d
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      try
      {
        paramg.N().close();
        return;
      }
      catch (IOException paramg)
      {
        for (;;) {}
      }
    }
  }
  
  public class e
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      try
      {
        a.J.source().read(ByteBuffer.allocate(64));
        d.a(a, paramg);
        return;
      }
      catch (IOException paramg)
      {
        throw new RuntimeException(paramg);
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */