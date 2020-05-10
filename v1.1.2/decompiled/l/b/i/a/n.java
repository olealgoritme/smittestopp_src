package l.b.i.a;

import java.math.BigInteger;
import l.b.a.a1;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.c.e.a;

public class n
  extends l.b.a.n
{
  public final byte[] x;
  public final byte[] y;
  
  public n(u paramu)
  {
    if (l.a(paramu.a(0)).a(BigInteger.valueOf(0L)))
    {
      x = a.a(p.a(paramu.a(1)).j());
      y = a.a(p.a(paramu.a(2)).j());
      return;
    }
    throw new IllegalArgumentException("unknown version of sequence");
  }
  
  public n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    x = a.a(paramArrayOfByte1);
    y = a.a(paramArrayOfByte2);
  }
  
  public static n a(Object paramObject)
  {
    if ((paramObject instanceof n)) {
      return (n)paramObject;
    }
    if (paramObject != null) {
      return new n(u.a(paramObject));
    }
    return null;
  }
  
  public t b()
  {
    f localf = new f(10);
    localf.a(new l(0L));
    localf.a(new a1(x));
    localf.a(new a1(y));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */