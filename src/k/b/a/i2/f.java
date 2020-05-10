package k.b.a.i2;

import java.math.BigInteger;
import java.util.Enumeration;
import k.b.a.a1;
import k.b.a.b0;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.h1;
import k.b.a.l;
import k.b.a.l2.a;
import k.b.a.n;
import k.b.a.p;
import k.b.a.r0;
import k.b.a.t;
import k.b.a.u;
import k.b.a.x;

public class f
  extends n
{
  public x A;
  public k.b.a.b B;
  public l x;
  public a y;
  public p z;
  
  public f(a parama, e parame, x paramx, byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger;
    if (paramArrayOfByte != null) {
      localBigInteger = k.b.j.b.b;
    } else {
      localBigInteger = k.b.j.b.a;
    }
    x = new l(localBigInteger);
    y = parama;
    z = new a1(parame);
    A = paramx;
    if (paramArrayOfByte == null) {
      parama = null;
    } else {
      parama = new r0(paramArrayOfByte);
    }
    B = parama;
  }
  
  public f(u paramu)
  {
    paramu = paramu.j();
    Object localObject = l.a(paramu.nextElement());
    x = ((l)localObject);
    int i = ((l)localObject).k();
    if ((i >= 0) && (i <= 1))
    {
      y = a.a(paramu.nextElement());
      z = p.a(paramu.nextElement());
      int j = -1;
      while (paramu.hasMoreElements())
      {
        localObject = (b0)paramu.nextElement();
        int k = x;
        if (k > j)
        {
          if (k != 0)
          {
            if (k == 1)
            {
              if (i >= 1) {
                B = r0.a((b0)localObject, false);
              } else {
                throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
              }
            }
            else {
              throw new IllegalArgumentException("unknown optional field in private key info");
            }
          }
          else {
            A = x.a((b0)localObject, false);
          }
          j = k;
        }
        else
        {
          throw new IllegalArgumentException("invalid optional field in private key info");
        }
      }
      return;
    }
    throw new IllegalArgumentException("invalid version for private key info");
  }
  
  public static f a(Object paramObject)
  {
    if ((paramObject instanceof f)) {
      return (f)paramObject;
    }
    if (paramObject != null) {
      return new f(u.a(paramObject));
    }
    return null;
  }
  
  public t c()
  {
    k.b.a.f localf = new k.b.a.f(5);
    localf.a(x);
    localf.a(y);
    localf.a(z);
    Object localObject = A;
    if (localObject != null) {
      localf.a(new h1(false, 0, (e)localObject));
    }
    localObject = B;
    if (localObject != null) {
      localf.a(new h1(false, 1, (e)localObject));
    }
    return new e1(localf);
  }
  
  public e f()
  {
    return t.a(z.j());
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.i2.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */