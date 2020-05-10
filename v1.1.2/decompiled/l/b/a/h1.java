package l.b.a;

public class h1
  extends b0
{
  public h1(int paramInt, e parame)
  {
    super(true, paramInt, parame);
  }
  
  public h1(boolean paramBoolean, int paramInt, e parame)
  {
    super(paramBoolean, paramInt, parame);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    t localt = z.b().h();
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
    localt.a(paramr.a(), y);
  }
  
  public int f()
  {
    int i = z.b().h().f();
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
    if ((!y) && (!z.b().h().g())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public t h()
  {
    return this;
  }
  
  public t i()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     l.b.a.h1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */