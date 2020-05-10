package k.b.a;

public class v1
  extends b0
{
  public v1(boolean paramBoolean, int paramInt, e parame)
  {
    super(paramBoolean, paramInt, parame);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    t localt = z.c().i();
    int i;
    if ((!y) && (!localt.g())) {
      i = 128;
    } else {
      i = 160;
    }
    paramr.a(paramBoolean, i, x);
    if (y) {
      paramr.a(localt.f());
    }
    paramr.b().a(localt, y);
  }
  
  public int f()
  {
    int i = z.c().i().f();
    if (y)
    {
      int j = d2.b(x);
      return d2.a(i) + j + i;
    }
    return d2.b(x) + (i - 1);
  }
  
  public boolean g()
  {
    boolean bool;
    if ((!y) && (!z.c().i().g())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public t i()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.v1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */