package k.b.i.a;

import k.b.a.a1;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.l;
import k.b.a.n;
import k.b.a.o;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;

public class f
  extends n
{
  public byte[] A;
  public byte[][] B;
  public byte[] C;
  public byte[] D;
  public k.b.i.b.d.a[] E;
  public l x;
  public o y;
  public byte[][] z;
  
  public f(u paramu)
  {
    if ((paramu.a(0) instanceof l)) {
      x = l.a(paramu.a(0));
    } else {
      y = o.a(paramu.a(0));
    }
    Object localObject1 = (u)paramu.a(1);
    z = new byte[((u)localObject1).size()][];
    for (int i = 0; i < ((u)localObject1).size(); i++) {
      z[i] = ((p)((u)localObject1).a(i)).j();
    }
    A = ((p)((u)paramu.a(2)).a(0)).j();
    localObject1 = (u)paramu.a(3);
    B = new byte[((u)localObject1).size()][];
    for (i = 0; i < ((u)localObject1).size(); i++) {
      B[i] = ((p)((u)localObject1).a(i)).j();
    }
    C = ((p)((u)paramu.a(4)).a(0)).j();
    D = ((p)((u)paramu.a(5)).a(0)).j();
    Object localObject2 = (u)paramu.a(6);
    localObject1 = new byte[((u)localObject2).size()][][][];
    byte[][][][] arrayOfByte = new byte[((u)localObject2).size()][][][];
    paramu = new byte[((u)localObject2).size()][][];
    byte[][] arrayOfByte1 = new byte[((u)localObject2).size()][];
    int j;
    for (i = 0; i < ((u)localObject2).size(); i++)
    {
      u localu1 = (u)((u)localObject2).a(i);
      u localu2 = (u)localu1.a(0);
      localObject1[i] = new byte[localu2.size()][][];
      for (j = 0; j < localu2.size(); j++)
      {
        localu3 = (u)localu2.a(j);
        localObject1[i][j] = new byte[localu3.size()][];
        for (k = 0; k < localu3.size(); k++) {
          localObject1[i][j][k] = ((p)localu3.a(k)).j();
        }
      }
      u localu3 = (u)localu1.a(1);
      arrayOfByte[i] = new byte[localu3.size()][][];
      for (j = 0; j < localu3.size(); j++)
      {
        localu2 = (u)localu3.a(j);
        arrayOfByte[i][j] = new byte[localu2.size()][];
        for (k = 0; k < localu2.size(); k++) {
          arrayOfByte[i][j][k] = ((p)localu2.a(k)).j();
        }
      }
      localu3 = (u)localu1.a(2);
      paramu[i] = new byte[localu3.size()][];
      for (j = 0; j < localu3.size(); j++) {
        paramu[i][j] = ((p)localu3.a(j)).j();
      }
      arrayOfByte1[i] = ((p)localu1.a(3)).j();
    }
    int k = D.length - 1;
    E = new k.b.i.b.d.a[k];
    for (i = 0; i < k; i = j)
    {
      localObject2 = D;
      byte b = localObject2[i];
      j = i + 1;
      localObject2 = new k.b.i.b.d.a(b, localObject2[j], k.b.c.e.a.a(localObject1[i]), k.b.c.e.a.a(arrayOfByte[i]), k.b.c.e.a.b(paramu[i]), k.b.c.e.a.c(arrayOfByte1[i]));
      E[i] = localObject2;
    }
  }
  
  public f(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, k.b.i.b.d.a[] paramArrayOfa)
  {
    x = new l(1L);
    z = k.b.c.e.a.a(paramArrayOfShort1);
    A = k.b.c.e.a.b(paramArrayOfShort2);
    B = k.b.c.e.a.a(paramArrayOfShort3);
    C = k.b.c.e.a.b(paramArrayOfShort4);
    paramArrayOfShort1 = new byte[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      paramArrayOfShort1[i] = ((byte)(byte)paramArrayOfInt[i]);
    }
    D = paramArrayOfShort1;
    E = paramArrayOfa;
  }
  
  public t c()
  {
    k.b.a.f localf1 = new k.b.a.f(10);
    Object localObject1 = x;
    if (localObject1 == null) {
      localObject1 = y;
    }
    localf1.a((e)localObject1);
    Object localObject2 = new k.b.a.f(10);
    for (int i = 0;; i++)
    {
      localObject1 = z;
      if (i >= localObject1.length) {
        break;
      }
      ((k.b.a.f)localObject2).a(new a1(localObject1[i]));
    }
    localf1.a(new e1((k.b.a.f)localObject2));
    localObject1 = new k.b.a.f(10);
    ((k.b.a.f)localObject1).a(new a1(A));
    localf1.a(new e1((k.b.a.f)localObject1));
    localObject1 = new k.b.a.f(10);
    for (i = 0;; i++)
    {
      localObject2 = B;
      if (i >= localObject2.length) {
        break;
      }
      ((k.b.a.f)localObject1).a(new a1(localObject2[i]));
    }
    localf1.a(new e1((k.b.a.f)localObject1));
    localObject1 = new k.b.a.f(10);
    ((k.b.a.f)localObject1).a(new a1(C));
    localf1.a(new e1((k.b.a.f)localObject1));
    localObject1 = new k.b.a.f(10);
    ((k.b.a.f)localObject1).a(new a1(D));
    localf1.a(new e1((k.b.a.f)localObject1));
    localObject1 = new k.b.a.f(10);
    for (i = 0; i < E.length; i++)
    {
      localObject2 = new k.b.a.f(10);
      Object localObject3 = k.b.c.e.a.a(E[i].d);
      Object localObject4 = new k.b.a.f(10);
      int k;
      for (int j = 0; j < localObject3.length; j++)
      {
        localf2 = new k.b.a.f(10);
        for (k = 0; k < localObject3[j].length; k++) {
          localf2.a(new a1(localObject3[j][k]));
        }
        ((k.b.a.f)localObject4).a(new e1(localf2));
      }
      ((k.b.a.f)localObject2).a(new e1((k.b.a.f)localObject4));
      localObject4 = k.b.c.e.a.a(E[i].e);
      localObject3 = new k.b.a.f(10);
      for (j = 0; j < localObject4.length; j++)
      {
        localf2 = new k.b.a.f(10);
        for (k = 0; k < localObject4[j].length; k++) {
          localf2.a(new a1(localObject4[j][k]));
        }
        ((k.b.a.f)localObject3).a(new e1(localf2));
      }
      ((k.b.a.f)localObject2).a(new e1((k.b.a.f)localObject3));
      localObject4 = k.b.c.e.a.a(E[i].f);
      k.b.a.f localf2 = new k.b.a.f(10);
      for (j = 0; j < localObject4.length; j++) {
        localf2.a(new a1(localObject4[j]));
      }
      ((k.b.a.f)localObject2).a(new e1(localf2));
      ((k.b.a.f)localObject2).a(new a1(k.b.c.e.a.b(E[i].g)));
      ((k.b.a.f)localObject1).a(new e1((k.b.a.f)localObject2));
    }
    localf1.a(new e1((k.b.a.f)localObject1));
    return new e1(localf1);
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */