package k.b.i.a;

import k.b.a.a1;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.n;
import k.b.a.o;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;
import k.b.c.e.a;

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
  
  public t c()
  {
    f localf = new f(10);
    Object localObject1 = x;
    if (localObject1 == null) {
      localObject1 = y;
    }
    localf.a((e)localObject1);
    localf.a(z);
    Object localObject2 = new f(10);
    int i = 0;
    for (int j = 0;; j++)
    {
      localObject1 = A;
      if (j >= localObject1.length) {
        break;
      }
      ((f)localObject2).a(new a1(localObject1[j]));
    }
    localf.a(new e1((f)localObject2));
    localObject1 = new f(10);
    for (j = i;; j++)
    {
      localObject2 = B;
      if (j >= localObject2.length) {
        break;
      }
      ((f)localObject1).a(new a1(localObject2[j]));
    }
    localf.a(new e1((f)localObject1));
    localObject1 = new f(10);
    ((f)localObject1).a(new a1(C));
    localf.a(new e1((f)localObject1));
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */