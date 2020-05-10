package l.b.a.i2;

import e.a.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

public class h
  extends n
{
  public BigInteger x;
  public BigInteger y;
  
  public h(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    x = paramBigInteger1;
    y = paramBigInteger2;
  }
  
  public h(u paramu)
  {
    if (paramu.size() == 2)
    {
      localObject = paramu.j();
      paramu = l.a(((Enumeration)localObject).nextElement());
      if (paramu != null)
      {
        x = new BigInteger(1, x);
        paramu = l.a(((Enumeration)localObject).nextElement());
        if (paramu != null)
        {
          y = new BigInteger(1, x);
          return;
        }
        throw null;
      }
      throw null;
    }
    Object localObject = a.a("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public t b()
  {
    f localf = new f(2);
    localf.a(new l(x));
    localf.a(new l(y));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.i2.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */