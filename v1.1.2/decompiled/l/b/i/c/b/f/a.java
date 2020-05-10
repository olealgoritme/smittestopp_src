package l.b.i.c.b.f;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.x;
import l.b.i.a.j;
import l.b.i.b.g.s;

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
    y = ((s)l.b.c.e.a.a(paramf));
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
      byte[] arrayOfByte = l.b.c.e.a.a(y, z).e();
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
    return l.b.c.e.a.d(y.b()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */