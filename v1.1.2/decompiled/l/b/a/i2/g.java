package l.b.a.i2;

import java.math.BigInteger;
import java.util.Enumeration;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

public class g
  extends n
{
  public BigInteger A;
  public BigInteger B;
  public BigInteger C;
  public BigInteger D;
  public BigInteger E;
  public BigInteger F;
  public u G = null;
  public BigInteger x;
  public BigInteger y;
  public BigInteger z;
  
  public g(u paramu)
  {
    paramu = paramu.j();
    l locall = (l)paramu.nextElement();
    int i = locall.k();
    if ((i >= 0) && (i <= 1))
    {
      x = locall.j();
      y = ((l)paramu.nextElement()).j();
      z = ((l)paramu.nextElement()).j();
      A = ((l)paramu.nextElement()).j();
      B = ((l)paramu.nextElement()).j();
      C = ((l)paramu.nextElement()).j();
      D = ((l)paramu.nextElement()).j();
      E = ((l)paramu.nextElement()).j();
      F = ((l)paramu.nextElement()).j();
      if (paramu.hasMoreElements()) {
        G = ((u)paramu.nextElement());
      }
      return;
    }
    throw new IllegalArgumentException("wrong version for RSA private key");
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(x));
    localf.a(new l(y));
    localf.a(new l(z));
    localf.a(new l(A));
    localf.a(new l(B));
    localf.a(new l(C));
    localf.a(new l(D));
    localf.a(new l(E));
    localf.a(new l(F));
    u localu = G;
    if (localu != null) {
      localf.a(localu);
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.i2.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */