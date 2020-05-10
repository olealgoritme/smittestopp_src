package l.b.i.c.b.e;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.i.a.e;
import l.b.i.a.h;
import l.b.i.b.e.c;

public class b
  implements PublicKey, l.b.i.c.a.b
{
  public transient o x;
  public transient c y;
  
  public b(s params)
  {
    x = ax.y).y.x;
    y = ((c)l.b.i.b.f.a.a(params));
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
        localObject = l.b.c.e.a.a(y);
      }
      else
      {
        l.b.a.l2.a locala = new l/b/a/l2/a;
        o localo = e.e;
        h localh = new l/b/i/a/h;
        localObject = new l/b/a/l2/a;
        ((l.b.a.l2.a)localObject).<init>(x);
        localh.<init>((l.b.a.l2.a)localObject);
        locala.<init>(localo, localh);
        localObject = new s(locala, y.a());
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
    return l.b.c.e.a.d(y.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */