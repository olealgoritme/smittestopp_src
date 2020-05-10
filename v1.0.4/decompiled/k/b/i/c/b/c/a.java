package k.b.i.c.b.c;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.a.x;

public class a
  implements PrivateKey
{
  public transient k.b.i.b.c.a x;
  public transient x y;
  
  public a(f paramf)
  {
    y = A;
    x = ((k.b.i.b.c.a)k.b.c.e.a.a(paramf));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      a locala = (a)paramObject;
      paramObject = x;
      if ((a != x.a) || (!Arrays.equals(((k.b.i.b.c.a)paramObject).a(), x.a()))) {
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
    k.b.i.b.c.a locala = x;
    int i = a;
    return k.b.c.e.a.d(locala.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */