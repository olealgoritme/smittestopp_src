package k.a.b.a.d.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.a.b.a.d.b;
import k.a.b.a.d.c0;
import k.a.b.a.d.h.b;
import k.a.b.a.d.o;

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
  public k.a.b.a.g.d Y;
  
  public void B()
  {
    a(h.b.CONNECTION_LOCAL_CLOSE, this);
  }
  
  public k.a.b.a.d.y D()
  {
    y localy = new y(this);
    H.add(localy);
    return localy;
  }
  
  public void F()
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
        if (!parame.t())
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
  
  public k.a.b.a.g.d b()
  {
    return Y;
  }
  
  public void c(String paramString)
  {
    W = paramString;
  }
  
  public String f()
  {
    return W;
  }
  
  public c0 l()
  {
    return R;
  }
  
  public void n()
  {
    Iterator localIterator = new ArrayList(H).iterator();
    while (localIterator.hasNext()) {
      ((k.a.b.a.d.y)localIterator.next()).a();
    }
    H = null;
  }
  
  public d o()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */