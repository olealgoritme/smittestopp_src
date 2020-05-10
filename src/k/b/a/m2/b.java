package k.b.a.m2;

import java.math.BigInteger;
import k.b.a.e1;
import k.b.a.l;
import k.b.a.n;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;

public class b
  extends n
  implements f
{
  public static final BigInteger C = BigInteger.valueOf(1L);
  public BigInteger A;
  public byte[] B;
  public k.b.f.a.b x;
  public c y;
  public BigInteger z;
  
  public b(u paramu)
  {
    if (((paramu.a(0) instanceof l)) && (((l)paramu.a(0)).a(C)))
    {
      z = ((l)paramu.a(4)).j();
      if (paramu.size() == 6) {
        A = ((l)paramu.a(5)).j();
      }
      a locala = new a(e.a(paramu.a(1)), z, A, u.a(paramu.a(2)));
      x = x;
      paramu = paramu.a(3);
      if ((paramu instanceof c)) {
        y = ((c)paramu);
      } else {
        y = new c(x, (p)paramu);
      }
      B = k.b.c.e.a.a(y);
      return;
    }
    throw new IllegalArgumentException("bad version in X9ECParameters");
  }
  
  public static b a(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return (b)paramObject;
    }
    if (paramObject != null) {
      return new b(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    k.b.a.f localf = new k.b.a.f(6);
    localf.a(new l(C));
    localf.a(null);
    localf.a(new a(x, B));
    localf.a(y);
    localf.a(new l(z));
    BigInteger localBigInteger = A;
    if (localBigInteger != null) {
      localf.a(new l(localBigInteger));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.m2.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */