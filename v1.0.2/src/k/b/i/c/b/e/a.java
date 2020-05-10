package k.b.i.c.b.e;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.a1;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.x;
import k.b.i.a.h;

public class a
  implements PrivateKey, k.b.i.c.a.b
{
  public transient o x;
  public transient k.b.i.b.e.b y;
  public transient x z;
  
  public a(f paramf)
  {
    z = A;
    x = ay.y).y.x;
    y = ((k.b.i.b.e.b)k.b.c.e.a.a(paramf));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((!x.b(x)) || (!Arrays.equals(y.a(), y.a()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "SPHINCS-256";
  }
  
  public byte[] getEncoded()
  {
    localObject1 = null;
    try
    {
      if (y.a != null)
      {
        localObject2 = k.b.c.e.a.a(y, z);
      }
      else
      {
        localObject2 = new k/b/a/l2/a;
        o localo = k.b.i.a.e.e;
        h localh = new k/b/i/a/h;
        Object localObject4 = new k/b/a/l2/a;
        ((k.b.a.l2.a)localObject4).<init>(x);
        localh.<init>((k.b.a.l2.a)localObject4);
        ((k.b.a.l2.a)localObject2).<init>(localo, localh);
        localObject4 = new k/b/a/a1;
        ((a1)localObject4).<init>(y.a());
        localObject2 = new f((k.b.a.l2.a)localObject2, (k.b.a.e)localObject4, z, null);
      }
      localObject2 = ((n)localObject2).e();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3 = localObject1;
      }
    }
    return (byte[])localObject2;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public int hashCode()
  {
    int i = x.hashCode();
    return k.b.c.e.a.d(y.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */