package k.b.i.c.b.f;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.i.a.i;

public class c
  implements PrivateKey
{
  public transient k.b.i.b.g.x x;
  public transient o y;
  public transient k.b.a.x z;
  
  public c(f paramf)
  {
    z = A;
    y = ay.y).z.x;
    x = ((k.b.i.b.g.x)k.b.c.e.a.a(paramf));
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
      byte[] arrayOfByte = k.b.c.e.a.a(x, z).e();
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
    return k.b.c.e.a.d(x.b()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */