package k.b.i.a;

import k.b.a.a1;
import k.b.a.b0;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.h1;
import k.b.a.l;
import k.b.a.n;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;
import k.b.c.e.a;
import k.b.j.b;

public class k
  extends n
{
  public final byte[] A;
  public final byte[] B;
  public final byte[] C;
  public final byte[] D;
  public final byte[] E;
  public final int x;
  public final long y;
  public final long z;
  
  public k(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    x = 0;
    y = paramLong;
    A = a.a(paramArrayOfByte1);
    B = a.a(paramArrayOfByte2);
    C = a.a(paramArrayOfByte3);
    D = a.a(paramArrayOfByte4);
    E = a.a(paramArrayOfByte5);
    z = -1L;
  }
  
  public k(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, long paramLong2)
  {
    x = 1;
    y = paramLong1;
    A = a.a(paramArrayOfByte1);
    B = a.a(paramArrayOfByte2);
    C = a.a(paramArrayOfByte3);
    D = a.a(paramArrayOfByte4);
    E = a.a(paramArrayOfByte5);
    z = paramLong2;
  }
  
  public k(u paramu)
  {
    Object localObject = l.a(paramu.a(0));
    if ((!((l)localObject).a(b.a)) && (!((l)localObject).a(b.b))) {
      throw new IllegalArgumentException("unknown version of sequence");
    }
    x = ((l)localObject).k();
    if ((paramu.size() != 2) && (paramu.size() != 3)) {
      throw new IllegalArgumentException("key sequence wrong size");
    }
    localObject = u.a(paramu.a(1));
    y = l.a(((u)localObject).a(0)).l();
    A = a.a(p.a(((u)localObject).a(1)).j());
    B = a.a(p.a(((u)localObject).a(2)).j());
    C = a.a(p.a(((u)localObject).a(3)).j());
    D = a.a(p.a(((u)localObject).a(4)).j());
    long l;
    if (((u)localObject).size() == 6)
    {
      localObject = b0.a(((u)localObject).a(5));
      if (x == 0) {
        l = l.a((b0)localObject, false).l();
      } else {
        throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
      }
    }
    else
    {
      if (((u)localObject).size() != 5) {
        break label282;
      }
      l = -1L;
    }
    z = l;
    if (paramu.size() == 3) {
      E = a.a(p.a(b0.a(paramu.a(2)), true).j());
    } else {
      E = null;
    }
    return;
    label282:
    throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
  }
  
  public t c()
  {
    f localf = new f(10);
    long l = z;
    Object localObject = new k/b/a/l;
    if (l >= 0L) {
      ((l)localObject).<init>(1L);
    } else {
      ((l)localObject).<init>(0L);
    }
    localf.a((e)localObject);
    localObject = new f(10);
    ((f)localObject).a(new l(y));
    ((f)localObject).a(new a1(A));
    ((f)localObject).a(new a1(B));
    ((f)localObject).a(new a1(C));
    ((f)localObject).a(new a1(D));
    l = z;
    if (l >= 0L) {
      ((f)localObject).a(new h1(false, 0, new l(l)));
    }
    localf.a(new e1((f)localObject));
    localf.a(new h1(true, 0, new a1(E)));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */