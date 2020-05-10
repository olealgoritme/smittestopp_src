package l.b.i.c.b.c;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.a.x;

public class a
  implements PrivateKey
{
  public transient l.b.i.b.c.a x;
  public transient x y;
  
  public a(f paramf)
  {
    y = A;
    x = ((l.b.i.b.c.a)l.b.c.e.a.a(paramf));
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
      l.b.i.b.c.a locala = x;
      if ((a != x.a) || (!Arrays.equals(locala.a(), x.a()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return l.b.c.e.a.c(x.a);
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = l.b.c.e.a.a(x, y).e();
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
    l.b.i.b.c.a locala = x;
    int i = a;
    return l.b.c.e.a.d(locala.a()) * 37 + i;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */