package k.b.i.c.b.e;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import k.b.a.l2.s;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.i.a.e;
import k.b.i.a.h;
import k.b.i.b.e.c;

public class b
  implements PublicKey, k.b.i.c.a.b
{
  public transient o x;
  public transient c y;
  
  public b(s params)
  {
    x = ax.y).y.x;
    y = ((c)k.b.i.b.f.a.a(params));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
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
    try
    {
      if (y.a != null)
      {
        localObject = k.b.c.e.a.a(y);
      }
      else
      {
        localObject = new k/b/a/l2/a;
        o localo = e.e;
        h localh = new k/b/i/a/h;
        k.b.a.l2.a locala = new k/b/a/l2/a;
        locala.<init>(x);
        localh.<init>(locala);
        ((k.b.a.l2.a)localObject).<init>(localo, localh);
        localObject = new s((k.b.a.l2.a)localObject, y.a());
      }
      Object localObject = ((n)localObject).e();
      return (byte[])localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public int hashCode()
  {
    int i = x.hashCode();
    return k.b.c.e.a.d(y.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */