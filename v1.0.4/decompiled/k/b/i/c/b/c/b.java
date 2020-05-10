package k.b.i.c.b.c;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import k.b.a.l2.s;
import k.b.a.n;

public class b
  implements PublicKey
{
  public transient k.b.i.b.c.b x;
  
  public b(s params)
  {
    x = ((k.b.i.b.c.b)k.b.i.b.f.a.a(params));
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
      k.b.i.b.c.b localb = x;
      if ((a != x.a) || (!Arrays.equals(localb.a(), x.a()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return k.b.c.e.a.c(x.a);
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
    k.b.i.b.c.b localb = x;
    int i = a;
    return k.b.c.e.a.d(localb.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */