package l.b.i.c.b.d;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.n;
import l.b.a.y0;
import l.b.i.a.e;

public class a
  implements PrivateKey
{
  public short[] A;
  public l.b.i.b.d.a[] B;
  public int[] C;
  public short[][] x;
  public short[] y;
  public short[][] z;
  
  public a(l.b.i.c.c.a parama)
  {
    x = arrayOfShort1;
    y = arrayOfShort2;
    z = arrayOfShort3;
    A = arrayOfShort4;
    C = arrayOfInt;
    B = parama;
  }
  
  public a(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, l.b.i.b.d.a[] paramArrayOfa)
  {
    x = paramArrayOfShort1;
    y = paramArrayOfShort2;
    z = paramArrayOfShort3;
    A = paramArrayOfShort4;
    C = paramArrayOfInt;
    B = paramArrayOfa;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      paramObject = (a)paramObject;
      if ((l.b.c.e.a.a(x, x)) && (l.b.c.e.a.a(z, z))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (l.b.c.e.a.a(y, y))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (l.b.c.e.a.a(A, A))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if ((i != 0) && (Arrays.equals(C, C))) {
        bool = true;
      } else {
        bool = false;
      }
      l.b.i.b.d.a[] arrayOfa = B;
      if (arrayOfa.length != B.length) {
        return false;
      }
      for (int i = arrayOfa.length - 1; i >= 0; i--) {
        bool &= B[i].equals(B[i]);
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public byte[] getEncoded()
  {
    l.b.i.a.f localf = new l.b.i.a.f(x, y, z, A, C, B);
    Object localObject1 = null;
    try
    {
      l.b.a.l2.a locala = new l/b/a/l2/a;
      locala.<init>(e.a, y0.x);
      Object localObject2 = new l/b/a/i2/f;
      ((l.b.a.i2.f)localObject2).<init>(locala, localf, null, null);
      localObject2 = ((n)localObject2).e();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return (byte[])localObject1;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public int hashCode()
  {
    int i = B.length;
    int j = l.b.c.e.a.b(x);
    int k = l.b.c.e.a.c(y);
    int m = l.b.c.e.a.b(z);
    int n = l.b.c.e.a.c(A);
    i = l.b.c.e.a.b(C) + (n + (m + (k + (j + i * 37) * 37) * 37) * 37) * 37;
    for (n = B.length - 1; n >= 0; n--) {
      i = i * 37 + B[n].hashCode();
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */