package l.b.i.c.b.e;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.a1;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.x;
import l.b.i.a.h;

public class a
  implements PrivateKey, l.b.i.c.a.b
{
  public transient o x;
  public transient l.b.i.b.e.b y;
  public transient x z;
  
  public a(f paramf)
  {
    z = A;
    x = ay.y).y.x;
    y = ((l.b.i.b.e.b)l.b.c.e.a.a(paramf));
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
        localObject2 = l.b.c.e.a.a(y, z);
      }
      else
      {
        localObject2 = new l/b/a/l2/a;
        o localo = l.b.i.a.e.e;
        Object localObject4 = new l/b/i/a/h;
        l.b.a.l2.a locala = new l/b/a/l2/a;
        locala.<init>(x);
        ((h)localObject4).<init>(locala);
        ((l.b.a.l2.a)localObject2).<init>(localo, (l.b.a.e)localObject4);
        localObject4 = new l/b/a/a1;
        ((a1)localObject4).<init>(y.a());
        localObject2 = new f((l.b.a.l2.a)localObject2, (l.b.a.e)localObject4, z, null);
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
    return l.b.c.e.a.d(y.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */