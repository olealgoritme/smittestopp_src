package g.c;

public abstract class g$f
  extends g.e
{
  public final int a;
  public final i b;
  
  public g$f(g paramg, c paramc)
  {
    super(paramg);
    paramc = a.a.a(paramc);
    b = paramc;
    paramg = a;
    paramc = (h)paramc;
    a = paramg.a(f * 8, e * 8);
  }
  
  public g$f(g paramg, j paramj)
  {
    super(paramg);
    paramj = a.a.a(paramj);
    b = paramj;
    paramg = a;
    paramj = (h)paramj;
    a = paramg.a(f * 8, e * 8);
  }
  
  public final void a()
  {
    c.a.a(16);
  }
  
  public abstract void a(Number paramNumber);
  
  public abstract int b();
  
  public final long c()
  {
    int i = a;
    return c.a.a() + i;
  }
  
  public String toString()
  {
    return Integer.toString(b(), 10);
  }
}

/* Location:
 * Qualified Name:     base.g.c.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */