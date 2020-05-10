package k.b.i.c.b.d;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.n;
import k.b.a.y0;

public class a
  implements PrivateKey
{
  public short[] A;
  public k.b.i.b.d.a[] B;
  public int[] C;
  public short[][] x;
  public short[] y;
  public short[][] z;
  
  public a(k.b.i.c.c.a parama)
  {
    x = arrayOfShort1;
    y = arrayOfShort2;
    z = arrayOfShort3;
    A = arrayOfShort4;
    C = arrayOfInt;
    B = parama;
  }
  
  public a(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, k.b.i.b.d.a[] paramArrayOfa)
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
      a locala = (a)paramObject;
      if ((k.b.c.e.a.a(x, x)) && (k.b.c.e.a.a(z, z))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (k.b.c.e.a.a(y, y))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (k.b.c.e.a.a(A, A))) {
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
      paramObject = B;
      if (paramObject.length != B.length) {
        return false;
      }
      for (int i = paramObject.length - 1; i >= 0; i--) {
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
    Object localObject1 = new k.b.i.a.f(x, y, z, A, C, B);
    Object localObject2 = null;
    try
    {
      k.b.a.l2.a locala = new k/b/a/l2/a;
      locala.<init>(k.b.i.a.e.a, y0.x);
      k.b.a.i2.f localf = new k/b/a/i2/f;
      localf.<init>(locala, (k.b.a.e)localObject1, null, null);
      localObject1 = localf.e();
      localObject2 = localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return (byte[])localObject2;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public int hashCode()
  {
    int i = B.length;
    int j = k.b.c.e.a.b(x);
    int k = k.b.c.e.a.c(y);
    int m = k.b.c.e.a.b(z);
    int n = k.b.c.e.a.c(A);
    j = k.b.c.e.a.b(C) + (n + (m + (k + (j + i * 37) * 37) * 37) * 37) * 37;
    for (i = B.length - 1; i >= 0; i--) {
      j = j * 37 + B[i].hashCode();
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */