package l.a.b.a.d.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.a.b.a.d.b;
import l.a.b.a.d.c0;
import l.a.b.a.d.h.b;
import l.a.b.a.d.o;

public class d
  extends f
  implements o
{
  public List<y> H = new ArrayList();
  public f I;
  public f J;
  public int K = 65535;
  public n<y> L;
  public n<y> M;
  public n<m> N;
  public n<m> O;
  public e P;
  public e Q;
  public a0 R;
  public e S;
  public e T;
  public int U = 0;
  public String V = "";
  public String W;
  public c X;
  public l.a.b.a.g.d Y;
  
  public void J()
  {
    a(h.b.CONNECTION_LOCAL_CLOSE, this);
  }
  
  public void M()
  {
    a(h.b.CONNECTION_LOCAL_OPEN, this);
  }
  
  public void S()
  {
    a(h.b.CONNECTION_FINAL, this);
  }
  
  public g a(h.b paramb, Object paramObject)
  {
    c localc = X;
    if (localc != null) {
      return localc.a(paramb, paramObject);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    W = paramString;
  }
  
  public void a(b paramb)
  {
    X = ((c)paramb);
    a(h.b.CONNECTION_INIT, this);
    for (paramb = L; paramb != null; paramb = c) {
      a(h.b.SESSION_INIT, a);
    }
    for (paramb = N; paramb != null; paramb = c) {
      a(h.b.LINK_INIT, a);
    }
  }
  
  public void a(e parame)
  {
    if (parame != null)
    {
      Object localObject;
      if (!J) {
        if (!parame.D())
        {
          localObject = H;
          if (((localObject instanceof x)) && (K == parame))
          {
            if (R > 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              i = 1;
              break label66;
            }
          }
          int i = 0;
          label66:
          if ((i == 0) && (!R)) {}
        }
        else
        {
          if (B) {
            return;
          }
          z = null;
          localObject = Q;
          A = ((e)localObject);
          if (localObject != null) {
            z = parame;
          }
          Q = parame;
          if (P == null) {
            P = parame;
          }
          B = true;
          return;
        }
      }
      boolean bool = B;
      if (bool)
      {
        localObject = z;
        if (localObject == null) {
          if (!bool) {
            localObject = H.H.H.P;
          } else {
            localObject = null;
          }
        }
        e locale = A;
        if (locale != null) {
          z = ((e)localObject);
        }
        if (localObject != null) {
          A = locale;
        }
        z = null;
        A = null;
        if (P == parame) {
          P = ((e)localObject);
        }
        if (Q == parame) {
          Q = locale;
        }
        B = false;
      }
    }
  }
  
  public l.a.b.a.g.d b()
  {
    return Y;
  }
  
  public String f()
  {
    return W;
  }
  
  public c0 j()
  {
    return R;
  }
  
  public void l()
  {
    Iterator localIterator = new ArrayList(H).iterator();
    while (localIterator.hasNext()) {
      ((l.a.b.a.d.y)localIterator.next()).a();
    }
    H = null;
  }
  
  public d p()
  {
    return this;
  }
  
  public l.a.b.a.d.y q()
  {
    y localy = new y(this);
    H.add(localy);
    return localy;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */