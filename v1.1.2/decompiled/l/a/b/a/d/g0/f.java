package l.a.b.a.d.g0;

import l.a.b.a.b.n.j;
import l.a.b.a.d.g;
import l.a.b.a.d.h.b;
import l.a.b.a.d.p;
import l.a.b.a.d.u;

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
  
  public u B()
  {
    return E;
  }
  
  public abstract void J();
  
  public abstract void M();
  
  public abstract void S();
  
  public final void a()
  {
    if (G) {
      return;
    }
    G = true;
    l();
    k();
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
      locald = p();
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
      locald = p();
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
      J();
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
      d locald = p();
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
  
  public void k()
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
  
  public abstract void l();
  
  public void open()
  {
    g localg1 = x;
    g localg2 = g.ACTIVE;
    if (localg1 != localg2)
    {
      x = localg2;
      M();
      c(true);
    }
  }
  
  public abstract d p();
  
  public j s()
  {
    return A;
  }
  
  public g t()
  {
    return x;
  }
  
  public j v()
  {
    return z;
  }
  
  public void z()
  {
    F += 1;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */