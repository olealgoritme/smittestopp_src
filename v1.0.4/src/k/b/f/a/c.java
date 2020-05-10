package k.b.f.a;

import java.math.BigInteger;

public abstract class c
  implements a
{
  public int a()
  {
    return h().bitLength();
  }
  
  public abstract c a(c paramc);
  
  public abstract int b();
  
  public abstract c b(c paramc);
  
  public abstract c c();
  
  public abstract c c(c paramc);
  
  public boolean d()
  {
    int i = a();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool;
    if (h().signum() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract c f();
  
  public abstract c g();
  
  public abstract BigInteger h();
  
  public String toString()
  {
    return h().toString(16);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */