package l.b.i.c.b.f;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.a.o;
import l.b.i.a.j;

public class b
  implements PublicKey
{
  public transient o x;
  public transient l.b.i.b.g.t y;
  
  public b(s params)
  {
    x = ax.y).A.x;
    y = ((l.b.i.b.g.t)l.b.i.b.f.a.a(params));
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
    return "XMSSMT";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = l.b.c.e.a.a(y).e();
      return arrayOfByte;
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
 * Qualified Name:     l.b.i.c.b.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */