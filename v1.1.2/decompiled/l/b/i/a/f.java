package l.b.i.a;

import l.b.a.a1;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;

public class f
  extends n
{
  public byte[] A;
  public byte[][] B;
  public byte[] C;
  public byte[] D;
  public l.b.i.b.d.a[] E;
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
    paramu = new byte[((u)localObject2).size()][][][];
    byte[][][][] arrayOfByte = new byte[((u)localObject2).size()][][][];
    byte[][][] arrayOfByte1 = new byte[((u)localObject2).size()][][];
    localObject1 = new byte[((u)localObject2).size()][];
    int j;
    for (i = 0; i < ((u)localObject2).size(); i++)
    {
      u localu1 = (u)((u)localObject2).a(i);
      u localu2 = (u)localu1.a(0);
      paramu[i] = new byte[localu2.size()][][];
      for (j = 0; j < localu2.size(); j++)
      {
        localu3 = (u)localu2.a(j);
        paramu[i][j] = new byte[localu3.size()][];
        for (k = 0; k < localu3.size(); k++) {
          paramu[i][j][k] = ((p)localu3.a(k)).j();
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
      localu2 = (u)localu1.a(2);
      arrayOfByte1[i] = new byte[localu2.size()][];
      for (j = 0; j < localu2.size(); j++) {
        arrayOfByte1[i][j] = ((p)localu2.a(j)).j();
      }
      localObject1[i] = ((p)localu1.a(3)).j();
    }
    int k = D.length - 1;
    E = new l.b.i.b.d.a[k];
    for (i = 0; i < k; i = j)
    {
      localObject2 = D;
      byte b = localObject2[i];
      j = i + 1;
      localObject2 = new l.b.i.b.d.a(b, localObject2[j], l.b.c.e.a.a(paramu[i]), l.b.c.e.a.a(arrayOfByte[i]), l.b.c.e.a.b(arrayOfByte1[i]), l.b.c.e.a.c(localObject1[i]));
      E[i] = localObject2;
    }
  }
  
  public f(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, l.b.i.b.d.a[] paramArrayOfa)
  {
    x = new l(1L);
    z = l.b.c.e.a.a(paramArrayOfShort1);
    A = l.b.c.e.a.b(paramArrayOfShort2);
    B = l.b.c.e.a.a(paramArrayOfShort3);
    C = l.b.c.e.a.b(paramArrayOfShort4);
    paramArrayOfShort1 = new byte[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++) {
      paramArrayOfShort1[i] = ((byte)(byte)paramArrayOfInt[i]);
    }
    D = paramArrayOfShort1;
    E = paramArrayOfa;
  }
  
  public t b()
  {
    l.b.a.f localf1 = new l.b.a.f(10);
    Object localObject1 = x;
    if (localObject1 == null) {
      localObject1 = y;
    }
    localf1.a((e)localObject1);
    localObject1 = new l.b.a.f(10);
    Object localObject2;
    for (int i = 0;; i++)
    {
      localObject2 = z;
      if (i >= localObject2.length) {
        break;
      }
      ((l.b.a.f)localObject1).a(new a1(localObject2[i]));
    }
    localf1.a(new e1((l.b.a.f)localObject1));
    localObject1 = new l.b.a.f(10);
    ((l.b.a.f)localObject1).a(new a1(A));
    localf1.a(new e1((l.b.a.f)localObject1));
    localObject1 = new l.b.a.f(10);
    for (i = 0;; i++)
    {
      localObject2 = B;
      if (i >= localObject2.length) {
        break;
      }
      ((l.b.a.f)localObject1).a(new a1(localObject2[i]));
    }
    localf1.a(new e1((l.b.a.f)localObject1));
    localObject1 = new l.b.a.f(10);
    ((l.b.a.f)localObject1).a(new a1(C));
    localf1.a(new e1((l.b.a.f)localObject1));
    localObject1 = new l.b.a.f(10);
    ((l.b.a.f)localObject1).a(new a1(D));
    localf1.a(new e1((l.b.a.f)localObject1));
    localObject1 = new l.b.a.f(10);
    for (i = 0; i < E.length; i++)
    {
      localObject2 = new l.b.a.f(10);
      Object localObject3 = l.b.c.e.a.a(E[i].d);
      l.b.a.f localf2 = new l.b.a.f(10);
      int k;
      for (int j = 0; j < localObject3.length; j++)
      {
        localObject4 = new l.b.a.f(10);
        for (k = 0; k < localObject3[j].length; k++) {
          ((l.b.a.f)localObject4).a(new a1(localObject3[j][k]));
        }
        localf2.a(new e1((l.b.a.f)localObject4));
      }
      ((l.b.a.f)localObject2).a(new e1(localf2));
      Object localObject4 = l.b.c.e.a.a(E[i].e);
      localObject3 = new l.b.a.f(10);
      for (j = 0; j < localObject4.length; j++)
      {
        localf2 = new l.b.a.f(10);
        for (k = 0; k < localObject4[j].length; k++) {
          localf2.a(new a1(localObject4[j][k]));
        }
        ((l.b.a.f)localObject3).a(new e1(localf2));
      }
      ((l.b.a.f)localObject2).a(new e1((l.b.a.f)localObject3));
      localObject3 = l.b.c.e.a.a(E[i].f);
      localObject4 = new l.b.a.f(10);
      for (j = 0; j < localObject3.length; j++) {
        ((l.b.a.f)localObject4).a(new a1(localObject3[j]));
      }
      ((l.b.a.f)localObject2).a(new e1((l.b.a.f)localObject4));
      ((l.b.a.f)localObject2).a(new a1(l.b.c.e.a.b(E[i].g)));
      ((l.b.a.f)localObject1).a(new e1((l.b.a.f)localObject2));
    }
    localf1.a(new e1((l.b.a.f)localObject1));
    return new e1(localf1);
  }
}

/* Location:
 * Qualified Name:     l.b.i.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */