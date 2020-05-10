package k.b.i.c.b.b;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import k.b.a.l2.s;
import k.b.a.n;

public class b
  implements k.b.i.c.a.a, PublicKey
{
  public transient k.b.i.b.b.b x;
  
  public b(s params)
  {
    x = ((k.b.i.b.b.b)k.b.i.b.f.a.a(params));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      return Arrays.equals(x.a(), x.a());
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "NH";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = k.b.c.e.a.a(x).e();
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
    return k.b.c.e.a.d(x.a());
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */