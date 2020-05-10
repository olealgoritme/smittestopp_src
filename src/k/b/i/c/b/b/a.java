package k.b.i.c.b.b;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.a.x;

public class a
  implements k.b.i.c.a.a, PrivateKey
{
  public transient k.b.i.b.b.a x;
  public transient x y;
  
  public a(f paramf)
  {
    y = A;
    x = ((k.b.i.b.b.a)k.b.c.e.a.a(paramf));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return Arrays.equals(x.a(), x.a());
  }
  
  public final String getAlgorithm()
  {
    return "NH";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = k.b.c.e.a.a(x, y).e();
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
    return k.b.c.e.a.c(x.a());
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */