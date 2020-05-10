package k.b.i.c.b.a;

import java.io.IOException;
import java.security.PublicKey;
import k.b.a.l2.s;
import k.b.a.n;
import k.b.i.a.e;
import k.b.i.b.a.f;

public class d
  implements PublicKey
{
  public f x;
  
  public d(f paramf)
  {
    x = paramf;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      Object localObject = (d)paramObject;
      paramObject = x;
      int i = a;
      localObject = x;
      bool3 = bool2;
      if (i == a)
      {
        bool3 = bool2;
        if (b == b)
        {
          bool3 = bool2;
          if (c.equals(c)) {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public String getAlgorithm()
  {
    return "McEliece";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = x;
    k.b.i.a.d locald = new k.b.i.a.d(a, b, c);
    localObject = new k.b.a.l2.a(e.c);
    try
    {
      s locals = new k/b/a/l2/s;
      locals.<init>((k.b.a.l2.a)localObject, locald);
      localObject = locals.e();
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
    f localf = x;
    int i = a;
    int j = b;
    return c.hashCode() + (j * 37 + i) * 37;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a(e.a.a.a.a.a("McEliecePublicKey:\n", " length of the code         : "), x.a, "\n"), " error correction capability: "), x.b, "\n"), " generator matrix           : ");
    localStringBuilder.append(x.c);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */