package l.b.i.a;

import l.b.a.a1;
import l.b.a.b0;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.h1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.c.e.a;
import l.b.j.b;

public class m
  extends n
{
  public final byte[] A;
  public final byte[] B;
  public final byte[] C;
  public final int D;
  public final byte[] E;
  public final int x;
  public final int y;
  public final byte[] z;
  
  public m(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    x = 0;
    y = paramInt;
    z = a.a(paramArrayOfByte1);
    A = a.a(paramArrayOfByte2);
    B = a.a(paramArrayOfByte3);
    C = a.a(paramArrayOfByte4);
    E = a.a(paramArrayOfByte5);
    D = -1;
  }
  
  public m(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt2)
  {
    x = 1;
    y = paramInt1;
    z = a.a(paramArrayOfByte1);
    A = a.a(paramArrayOfByte2);
    B = a.a(paramArrayOfByte3);
    C = a.a(paramArrayOfByte4);
    E = a.a(paramArrayOfByte5);
    D = paramInt2;
  }
  
  public m(u paramu)
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
    y = l.a(((u)localObject).a(0)).k();
    z = a.a(p.a(((u)localObject).a(1)).j());
    A = a.a(p.a(((u)localObject).a(2)).j());
    B = a.a(p.a(((u)localObject).a(3)).j());
    C = a.a(p.a(((u)localObject).a(4)).j());
    int i;
    if (((u)localObject).size() == 6)
    {
      localObject = b0.a(((u)localObject).a(5));
      if (x == 0) {
        i = l.a((b0)localObject, false).k();
      } else {
        throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
      }
    }
    else
    {
      if (((u)localObject).size() != 5) {
        break label280;
      }
      i = -1;
    }
    D = i;
    if (paramu.size() == 3) {
      E = a.a(p.a(b0.a(paramu.a(2)), true).j());
    } else {
      E = null;
    }
    return;
    label280:
    throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
  }
  
  public t b()
  {
    f localf = new f(10);
    if (D >= 0) {
      localObject = new l(1L);
    } else {
      localObject = new l(0L);
    }
    localf.a((e)localObject);
    Object localObject = new f(10);
    ((f)localObject).a(new l(y));
    ((f)localObject).a(new a1(z));
    ((f)localObject).a(new a1(A));
    ((f)localObject).a(new a1(B));
    ((f)localObject).a(new a1(C));
    int i = D;
    if (i >= 0) {
      ((f)localObject).a(new h1(false, 0, new l(i)));
    }
    localf.a(new e1((f)localObject));
    localf.a(new h1(true, 0, new a1(E)));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */