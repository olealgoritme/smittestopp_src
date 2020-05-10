package k.b.i.c.b.f;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import k.b.a.l2.s;
import k.b.a.n;
import k.b.a.o;
import k.b.i.a.j;

public class b
  implements PublicKey
{
  public transient o x;
  public transient k.b.i.b.g.t y;
  
  public b(s params)
  {
    x = ax.y).A.x;
    y = ((k.b.i.b.g.t)k.b.i.b.f.a.a(params));
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
      byte[] arrayOfByte = k.b.c.e.a.a(y).e();
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
    return k.b.c.e.a.d(y.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */