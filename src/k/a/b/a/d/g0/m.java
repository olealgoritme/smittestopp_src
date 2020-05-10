package k.a.b.a.d.g0;

import java.util.Map;
import k.a.b.a.b.n.p;
import k.a.b.a.b.n.q;
import k.a.b.a.b.n.r;
import k.a.b.a.d.h.b;

public abstract class m
  extends f
  implements k.a.b.a.d.n
{
  public final y H;
  public e I;
  public e J;
  public e K;
  public String L;
  public q M;
  public q N;
  public r O;
  public r P;
  public int Q;
  public int R;
  public int S;
  public int T;
  public p U;
  public k.a.b.a.b.n.n V;
  public n<m> W;
  public boolean X;
  public Map<k.a.b.a.b.f, Object> Y;
  
  public m(y paramy, String paramString)
  {
    H = paramy;
    paramy.w();
    L = paramString;
    paramString = H;
    if (N == null)
    {
      paramy = new n(this);
      O = paramy;
      N = paramy;
    }
    else
    {
      paramy = O.a(this);
      O = paramy;
    }
    W = paramy;
    paramString.a(h.b.LINK_INIT, this);
  }
  
  public q A()
  {
    return M;
  }
  
  public void B()
  {
    H.H.a(h.b.LINK_LOCAL_CLOSE, this);
  }
  
  public void F()
  {
    H.H.a(h.b.LINK_LOCAL_OPEN, this);
  }
  
  public void S()
  {
    H.H.a(h.b.LINK_FINAL, this);
    H.i();
  }
  
  public k.a.b.a.d.y T()
  {
    return H;
  }
  
  public abstract e0 V();
  
  public k.a.b.a.d.e a(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(Map<k.a.b.a.b.f, Object> paramMap)
  {
    Y = paramMap;
  }
  
  public void a(k.a.b.a.b.n.n paramn)
  {
    V = paramn;
  }
  
  public void a(p paramp)
  {
    U = paramp;
  }
  
  public void a(q paramq)
  {
    M = paramq;
  }
  
  public void a(r paramr)
  {
    O = paramr;
  }
  
  public void b(int paramInt)
  {
    R = paramInt;
  }
  
  public e c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length))
    {
      Q += 1;
      try
      {
        e locale = new k/a/b/a/d/g0/e;
        locale.<init>(paramArrayOfByte, this, J);
        if (J == null) {
          I = locale;
        }
        J = locale;
        if (K == null) {
          K = locale;
        }
        H.H.a(locale);
        return locale;
      }
      catch (RuntimeException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
    }
    throw new IllegalArgumentException("At present delivery tag must be the whole byte array");
  }
  
  public boolean d()
  {
    e locale = K;
    if (locale != null)
    {
      K = y;
      H.H.a(locale);
      locale = K;
      if (locale != null) {
        H.H.a(locale);
      }
      return true;
    }
    return false;
  }
  
  public int g()
  {
    boolean bool = this instanceof x;
    int i = 0;
    int j;
    if (bool)
    {
      j = i;
      if (X)
      {
        int k;
        if (R > 0) {
          k = 1;
        } else {
          k = 0;
        }
        j = i;
        if (k != 0)
        {
          T = R;
          b(0);
          c(true);
          j = T;
        }
      }
    }
    else
    {
      j = T;
      T = 0;
    }
    return j;
  }
  
  public String getName()
  {
    return L;
  }
  
  public k.a.b.a.d.e head()
  {
    return I;
  }
  
  public k.a.b.a.d.e k()
  {
    return K;
  }
  
  public void n()
  {
    Object localObject2;
    for (Object localObject1 = I; localObject1 != null; localObject1 = localObject2)
    {
      localObject2 = y;
      ((e)localObject1).R();
    }
    d locald = H.H;
    localObject1 = W;
    if (locald != null)
    {
      n localn = b;
      localObject2 = c;
      if (N == localObject1) {
        N = ((n)localObject2);
      }
      if (O == localObject1) {
        O = localn;
      }
      localObject2 = b;
      localn = c;
      if (localObject2 != null) {
        c = localn;
      }
      if (localn != null) {
        b = ((n)localObject2);
      }
      b = null;
      c = null;
      W = null;
      return;
    }
    throw null;
  }
  
  public d o()
  {
    return H.H;
  }
  
  public r r()
  {
    return P;
  }
  
  public int x()
  {
    return R;
  }
  
  public q z()
  {
    return N;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */