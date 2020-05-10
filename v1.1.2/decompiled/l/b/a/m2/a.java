package l.b.a.m2;

import java.math.BigInteger;
import l.b.a.e1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.o;
import l.b.a.p;
import l.b.a.r0;
import l.b.a.t;
import l.b.a.u;
import l.b.f.a.b.c;
import l.b.f.a.b.d;

public class a
  extends n
  implements f
{
  public l.b.f.a.b x;
  public byte[] y;
  public o z = null;
  
  public a(e parame, BigInteger paramBigInteger1, BigInteger paramBigInteger2, u paramu)
  {
    Object localObject = x;
    z = ((o)localObject);
    if (((t)localObject).b(f.g))
    {
      parame = new b.d(((l)y).j(), new BigInteger(1, p.a(paramu.a(0)).j()), new BigInteger(1, p.a(paramu.a(1)).j()), paramBigInteger1, paramBigInteger2);
    }
    else
    {
      if (!z.b(f.h)) {
        break label332;
      }
      localObject = u.a(y);
      int i = ((l)((u)localObject).a(0)).k();
      parame = (o)((u)localObject).a(1);
      int j;
      int k;
      int m;
      if (parame.b(f.i))
      {
        j = l.a(((u)localObject).a(2)).k();
        k = 0;
        m = 0;
      }
      else
      {
        if (!parame.b(f.j)) {
          break label322;
        }
        parame = u.a(((u)localObject).a(2));
        j = l.a(parame.a(0)).k();
        k = l.a(parame.a(1)).k();
        m = l.a(parame.a(2)).k();
      }
      parame = new b.c(i, j, k, m, new BigInteger(1, p.a(paramu.a(0)).j()), new BigInteger(1, p.a(paramu.a(1)).j()), paramBigInteger1, paramBigInteger2);
    }
    x = parame;
    if (paramu.size() == 3) {
      y = ((r0)paramu.a(2)).j();
    }
    return;
    label322:
    throw new IllegalArgumentException("This type of EC basis is not implemented");
    label332:
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  public a(l.b.f.a.b paramb, byte[] paramArrayOfByte)
  {
    x = paramb;
    y = l.b.c.e.a.a(paramArrayOfByte);
    int i = x.a.a();
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramb = f.g;
    }
    else
    {
      paramb = x.a;
      i = j;
      if (paramb.a() > 1)
      {
        i = j;
        if (paramb.b().equals(l.b.f.a.a.c))
        {
          i = j;
          if ((paramb instanceof l.b.f.b.e)) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        break label126;
      }
      paramb = f.h;
    }
    z = paramb;
    return;
    label126:
    throw new IllegalArgumentException("This type of ECCurve is not implemented");
  }
  
  public t b()
  {
    l.b.a.f localf = new l.b.a.f(3);
    if (z.b(f.g)) {
      localf.a(new d(x.b).b());
    }
    for (Object localObject = new d(x.c);; localObject = new d(x.c))
    {
      localf.a(((d)localObject).b());
      break;
      if (!z.b(f.h)) {
        break;
      }
      localf.a(new d(x.b).b());
    }
    localObject = y;
    if (localObject != null) {
      localf.a(new r0((byte[])localObject));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.m2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */