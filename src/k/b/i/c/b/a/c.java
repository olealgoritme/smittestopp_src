package k.b.i.c.b.a;

import java.io.IOException;
import java.security.PrivateKey;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.i.d.a.b;
import k.b.i.d.a.d;

public class c
  implements PrivateKey
{
  public k.b.i.b.a.e x;
  
  public c(k.b.i.b.a.e parame)
  {
    x = parame;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof c;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    c localc = (c)paramObject;
    k.b.i.b.a.e locale = x;
    int i = a;
    paramObject = x;
    bool1 = bool2;
    if (i == a)
    {
      bool1 = bool2;
      if (b == b)
      {
        bool1 = bool2;
        if (c.equals(c))
        {
          bool1 = bool2;
          if (x.d.equals(x.d))
          {
            bool1 = bool2;
            if (x.e.equals(x.e))
            {
              bool1 = bool2;
              if (x.f.equals(x.f))
              {
                bool1 = bool2;
                if (x.g.equals(x.g)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "McEliece";
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = x;
    k.b.i.a.c localc = new k.b.i.a.c(a, b, c, d, f, g, e);
    localObject1 = null;
    try
    {
      Object localObject2 = new k/b/a/l2/a;
      ((k.b.a.l2.a)localObject2).<init>(k.b.i.a.e.c);
      f localf = new k/b/a/i2/f;
      localf.<init>((k.b.a.l2.a)localObject2, localc, null, null);
      localObject2 = localf.e();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return (byte[])localObject1;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public int hashCode()
  {
    k.b.i.b.a.e locale = x;
    int i = b;
    int j = a;
    int k = c.b;
    int m = d.hashCode();
    int n = x.f.hashCode();
    int i1 = x.g.hashCode();
    return x.e.hashCode() + (i1 + (n + (m + ((i * 37 + j) * 37 + k) * 37) * 37) * 37) * 37;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */