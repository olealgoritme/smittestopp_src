package k.b.i.c.b.a;

import java.io.IOException;
import java.security.PublicKey;
import k.b.a.l2.s;
import k.b.a.n;
import k.b.i.a.e;
import k.b.i.b.a.c;

public class b
  implements PublicKey
{
  public c x;
  
  public b(c paramc)
  {
    x = paramc;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof b))
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (b)paramObject;
        paramObject = x;
        int i = b;
        localObject = x;
        bool2 = bool1;
        if (i == b)
        {
          bool2 = bool1;
          if (c == c)
          {
            bool2 = bool1;
            if (d.equals(d)) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public String getAlgorithm()
  {
    return "McEliece-CCA2";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = x;
    k.b.i.a.b localb = new k.b.i.a.b(b, c, d, k.b.c.e.a.a(a));
    k.b.a.l2.a locala = new k.b.a.l2.a(e.d);
    try
    {
      localObject = new k/b/a/l2/s;
      ((s)localObject).<init>(locala, localb);
      localObject = ((n)localObject).e();
      return (byte[])localObject;
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
    c localc = x;
    int i = b;
    int j = c;
    return d.hashCode() + (j * 37 + i) * 37;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a("McEliecePublicKey:\n", " length of the code         : "), x.b, "\n"), " error correction capability: "), x.c, "\n"), " generator matrix           : ");
    localStringBuilder.append(x.d.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */