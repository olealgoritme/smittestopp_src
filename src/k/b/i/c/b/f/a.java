package k.b.i.c.b.f;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.x;
import k.b.i.a.j;
import k.b.i.b.g.s;

public class a
  implements PrivateKey
{
  public transient o x;
  public transient s y;
  public transient x z;
  
  public a(f paramf)
  {
    z = A;
    x = ay.y).A.x;
    y = ((s)k.b.c.e.a.a(paramf));
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
      if ((!x.b(x)) || (!Arrays.equals(y.b(), y.b()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAlgorithm()
  {
    return "XMSSMT";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = k.b.c.e.a.a(y, z).e();
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
    int i = x.hashCode();
    return k.b.c.e.a.d(y.b()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */