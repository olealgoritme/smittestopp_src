package l.b.i.c.b.f;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.i.a.i;
import l.b.i.b.g.y;

public class d
  implements PublicKey
{
  public transient y x;
  public transient o y;
  
  public d(s params)
  {
    y = ax.y).z.x;
    x = ((y)l.b.i.b.f.a.a(params));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      if ((!y.b(y)) || (!Arrays.equals(x.a(), x.a()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "XMSS";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = l.b.c.e.a.a(x).e();
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
    int i = y.hashCode();
    return l.b.c.e.a.d(x.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.f.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */