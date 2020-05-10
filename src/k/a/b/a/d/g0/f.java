package k.a.b.a.d.g0;

import k.a.b.a.b.n.j;
import k.a.b.a.d.g;
import k.a.b.a.d.h.b;
import k.a.b.a.d.p;
import k.a.b.a.d.u;

public abstract class f
  implements p
{
  public j A;
  public boolean B;
  public f C;
  public f D;
  public u E;
  public int F;
  public boolean G;
  public g x;
  public g y;
  public j z;
  
  public f()
  {
    g localg = g.UNINITIALIZED;
    x = localg;
    y = localg;
    z = new j();
    A = new j();
    E = new r();
    F = 1;
    G = false;
  }
  
  public abstract void B();
  
  public abstract void F();
  
  public j H()
  {
    return A;
  }
  
  public g J()
  {
    return x;
  }
  
  public j L()
  {
    return z;
  }
  
  public abstract void S();
  
  public final void a()
  {
    if (G) {
      return;
    }
    G = true;
    n();
    i();
  }
  
  public void a(j paramj)
  {
    if (paramj != null)
    {
      z.a(paramj);
    }
    else
    {
      paramj = z;
      a = null;
      b = null;
      c = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    d locald;
    Object localObject;
    if (!B)
    {
      B = true;
      locald = o();
      localObject = I;
      if (localObject == null)
      {
        C = null;
        D = null;
        I = this;
        J = this;
      }
      else
      {
        C = this;
        D = ((f)localObject);
        I = this;
        C = null;
      }
    }
    if (paramBoolean)
    {
      locald = o();
      localObject = R;
      if (localObject != null) {
        locald.a(h.b.TRANSPORT, localObject);
      }
    }
  }
  
  public void close()
  {
    g localg1 = x;
    g localg2 = g.CLOSED;
    if (localg1 != localg2)
    {
      x = localg2;
      B();
      c(true);
    }
  }
  
  public g e()
  {
    return y;
  }
  
  public void h()
  {
    if (B)
    {
      B = false;
      d locald = o();
      if (J == this) {
        J = C;
      } else {
        D.C = C;
      }
      if (I == this) {
        I = D;
      } else {
        C.D = D;
      }
    }
  }
  
  public void i()
  {
    int i = F - 1;
    F = i;
    if (i == 0) {
      S();
    } else {
      if (i < 0) {
        break label28;
      }
    }
    return;
    label28:
    throw new IllegalStateException();
  }
  
  public abstract void n();
  
  public abstract d o();
  
  public void open()
  {
    g localg1 = x;
    g localg2 = g.ACTIVE;
    if (localg1 != localg2)
    {
      x = localg2;
      F();
      c(true);
    }
  }
  
  public u q()
  {
    return E;
  }
  
  public void w()
  {
    F += 1;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */