package k.a.b.a.d.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.a.b.a.d.c;
import k.a.b.a.d.g;
import k.a.b.a.d.h.b;

public class y
  extends f
  implements k.a.b.a.d.q
{
  public final d H;
  public Map<String, x> I = new LinkedHashMap();
  public Map<String, q> J = new LinkedHashMap();
  public List<m> K = new ArrayList();
  public k0 L;
  public int M = 0;
  public int N = 0;
  public int O = 0;
  public int P = 0;
  public int Q = 0;
  public long R = 2147483647L;
  public n<y> S;
  
  public y(d paramd)
  {
    H = paramd;
    paramd.w();
    d locald = H;
    if (L == null)
    {
      paramd = new n(this);
      M = paramd;
      L = paramd;
    }
    else
    {
      paramd = M.a(this);
      M = paramd;
    }
    S = paramd;
    H.a(h.b.SESSION_INIT, this);
  }
  
  public void B()
  {
    H.a(h.b.SESSION_LOCAL_CLOSE, this);
  }
  
  public void F()
  {
    H.a(h.b.SESSION_LOCAL_OPEN, this);
  }
  
  public void S()
  {
    H.a(h.b.SESSION_FINAL, this);
    H.i();
  }
  
  public c U()
  {
    return H;
  }
  
  public x a(String paramString)
  {
    x localx1 = (x)I.get(paramString);
    x localx2;
    if (localx1 == null)
    {
      localx2 = new x(this, paramString);
      I.put(paramString, localx2);
    }
    else
    {
      g localg1 = x;
      g localg2 = g.CLOSED;
      localx2 = localx1;
      if (localg1 == localg2)
      {
        localx2 = localx1;
        if (y == localg2)
        {
          K.add(localx1);
          localx2 = new x(this, paramString);
          I.put(paramString, localx2);
        }
      }
    }
    return localx2;
  }
  
  public q b(String paramString)
  {
    q localq1 = (q)J.get(paramString);
    q localq2;
    if (localq1 == null)
    {
      localq2 = new q(this, paramString);
      J.put(paramString, localq2);
    }
    else
    {
      g localg1 = x;
      g localg2 = g.CLOSED;
      localq2 = localq1;
      if (localg1 == localg2)
      {
        localq2 = localq1;
        if (y == localg2)
        {
          K.add(localq1);
          localq2 = new q(this, paramString);
          J.put(paramString, localq2);
        }
      }
    }
    return localq2;
  }
  
  public void b(int paramInt)
  {
    N += paramInt;
  }
  
  public void c(int paramInt)
  {
    O += paramInt;
  }
  
  public void n()
  {
    H.H.remove(this);
    d locald = H;
    Object localObject = S;
    if (locald != null)
    {
      n localn1 = b;
      n localn2 = c;
      if (L == localObject) {
        L = localn2;
      }
      if (M == localObject) {
        M = localn1;
      }
      localn2 = b;
      localn1 = c;
      if (localn2 != null) {
        c = localn1;
      }
      if (localn1 != null) {
        b = localn2;
      }
      b = null;
      c = null;
      S = null;
      localObject = new ArrayList(I.values()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((x)((Iterator)localObject).next()).a();
      }
      I.clear();
      localObject = new ArrayList(J.values()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((q)((Iterator)localObject).next()).a();
      }
      J.clear();
      localObject = new ArrayList(K).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((m)((Iterator)localObject).next()).a();
      }
      return;
    }
    throw null;
  }
  
  public d o()
  {
    return H;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */