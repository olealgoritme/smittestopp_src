package l.b.i.c.b.d;

import java.security.PublicKey;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.a.y0;
import l.b.i.a.e;
import l.b.i.a.g;

public class b
  implements PublicKey
{
  public int A;
  public short[][] x;
  public short[][] y;
  public short[] z;
  
  public b(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    A = paramInt;
    x = paramArrayOfShort1;
    y = paramArrayOfShort2;
    z = paramArrayOfShort;
  }
  
  public b(l.b.i.c.c.b paramb)
  {
    A = i;
    x = arrayOfShort1;
    y = arrayOfShort2;
    z = paramb;
  }
  
  public short[][] a()
  {
    short[][] arrayOfShort1 = new short[y.length][];
    for (int i = 0;; i++)
    {
      short[][] arrayOfShort2 = y;
      if (i == arrayOfShort2.length) {
        break;
      }
      arrayOfShort1[i] = l.b.c.e.a.a(arrayOfShort2[i]);
    }
    return arrayOfShort1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((A == A) && (l.b.c.e.a.a(x, x)) && (l.b.c.e.a.a(y, ((b)paramObject).a())) && (l.b.c.e.a.a(z, l.b.c.e.a.a(z)))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public byte[] getEncoded()
  {
    g localg = new g(A, x, y, z);
    l.b.a.l2.a locala = new l.b.a.l2.a(e.a, y0.x);
    Object localObject1 = null;
    try
    {
      Object localObject2 = new l/b/a/l2/s;
      ((s)localObject2).<init>(locala, localg);
      localObject2 = ((n)localObject2).a("DER");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (byte[])localObject1;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public int hashCode()
  {
    int i = A;
    int j = l.b.c.e.a.b(x);
    int k = l.b.c.e.a.b(y);
    return l.b.c.e.a.c(z) + (k + (j + i * 37) * 37) * 37;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */