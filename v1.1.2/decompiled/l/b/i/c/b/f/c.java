package l.b.i.c.b.f;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.i.a.i;

public class c
  implements PrivateKey
{
  public transient l.b.i.b.g.x x;
  public transient o y;
  public transient l.b.a.x z;
  
  public c(f paramf)
  {
    z = A;
    y = ay.y).z.x;
    x = ((l.b.i.b.g.x)l.b.c.e.a.a(paramf));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((!y.b(y)) || (!Arrays.equals(x.b(), x.b()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAlgorithm()
  {
    return "XMSS";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = l.b.c.e.a.a(x, z).e();
      return arrayOfByte;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public int hashCode()
  {
    int i = y.hashCode();
    return l.b.c.e.a.d(x.b()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */