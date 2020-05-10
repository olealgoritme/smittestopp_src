package l.b.i.a;

import l.b.a.a1;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.l;
import l.b.a.n;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.c.e.a;

public class g
  extends n
{
  public byte[][] A;
  public byte[][] B;
  public byte[] C;
  public l x;
  public o y;
  public l z;
  
  public g(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    x = new l(0L);
    z = new l(paramInt);
    A = a.a(paramArrayOfShort1);
    B = a.a(paramArrayOfShort2);
    C = a.b(paramArrayOfShort);
  }
  
  public g(u paramu)
  {
    if ((paramu.a(0) instanceof l)) {
      x = l.a(paramu.a(0));
    } else {
      y = o.a(paramu.a(0));
    }
    z = l.a(paramu.a(1));
    u localu = u.a(paramu.a(2));
    A = new byte[localu.size()][];
    for (int i = 0; i < localu.size(); i++) {
      A[i] = p.a(localu.a(i)).j();
    }
    localu = (u)paramu.a(3);
    B = new byte[localu.size()][];
    for (i = 0; i < localu.size(); i++) {
      B[i] = p.a(localu.a(i)).j();
    }
    C = p.a(((u)paramu.a(4)).a(0)).j();
  }
  
  public t b()
  {
    f localf1 = new f(10);
    Object localObject = x;
    if (localObject == null) {
      localObject = y;
    }
    localf1.a((e)localObject);
    localf1.a(z);
    f localf2 = new f(10);
    int i = 0;
    for (int j = 0;; j++)
    {
      localObject = A;
      if (j >= localObject.length) {
        break;
      }
      localf2.a(new a1(localObject[j]));
    }
    localf1.a(new e1(localf2));
    localf2 = new f(10);
    for (j = i;; j++)
    {
      localObject = B;
      if (j >= localObject.length) {
        break;
      }
      localf2.a(new a1(localObject[j]));
    }
    localf1.a(new e1(localf2));
    localObject = new f(10);
    ((f)localObject).a(new a1(C));
    localf1.a(new e1((f)localObject));
    return new e1(localf1);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */