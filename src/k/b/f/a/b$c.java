package k.b.f.a;

import java.math.BigInteger;

public class b$c
  extends b.a
{
  public int e;
  public int f;
  public int g;
  public int h;
  public d.c i;
  
  public b$c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
    e = paramInt1;
    f = paramInt2;
    g = paramInt3;
    h = paramInt4;
    i = new d.c(this, null, null);
    b = a(paramBigInteger1);
    c = a(paramBigInteger2);
    d = 6;
  }
  
  public c a(BigInteger paramBigInteger)
  {
    return new c.c(e, f, g, h, paramBigInteger);
  }
  
  public d a()
  {
    return i;
  }
  
  public d a(c paramc1, c paramc2)
  {
    return new d.c(this, paramc1, paramc2);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */