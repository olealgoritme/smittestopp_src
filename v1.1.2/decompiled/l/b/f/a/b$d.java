package l.b.f.a;

import java.math.BigInteger;

public class b$d
  extends b.b
{
  public BigInteger e;
  public BigInteger f;
  public d.d g;
  
  public b$d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
  {
    super(paramBigInteger1);
    e = paramBigInteger1;
    f = c.d.b(paramBigInteger1);
    g = new d.d(this, null, null);
    b = a(paramBigInteger2);
    c = a(paramBigInteger3);
    d = 4;
  }
  
  public c a(BigInteger paramBigInteger)
  {
    return new c.d(e, f, paramBigInteger);
  }
  
  public d a()
  {
    return g;
  }
  
  public d a(c paramc1, c paramc2)
  {
    return new d.d(this, paramc1, paramc2);
  }
  
  public d a(d paramd)
  {
    if ((this != a) && (d == 2) && (!paramd.c()))
    {
      int i = a.d;
      if ((i == 2) || (i == 3) || (i == 4)) {
        return new d.d(this, a(b.h()), a(c.h()), new c[] { a(d[0].h()) });
      }
    }
    return super.a(paramd);
  }
}

/* Location:
 * Qualified Name:     l.b.f.a.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */