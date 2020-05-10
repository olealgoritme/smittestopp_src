package l.b.i.c.b.a;

import java.io.IOException;
import java.security.PublicKey;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.i.a.e;
import l.b.i.b.a.f;

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
    l.b.i.a.d locald = new l.b.i.a.d(a, b, c);
    l.b.a.l2.a locala = new l.b.a.l2.a(e.c);
    try
    {
      localObject = new l/b/a/l2/s;
      ((s)localObject).<init>(locala, locald);
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
    f localf = x;
    int i = a;
    int j = b;
    return c.hashCode() + (j * 37 + i) * 37;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("McEliecePublicKey:\n", " length of the code         : ");
    localStringBuilder.append(x.a);
    localStringBuilder.append("\n");
    localStringBuilder = e.a.a.a.a.a(localStringBuilder.toString(), " error correction capability: ");
    localStringBuilder.append(x.b);
    localStringBuilder.append("\n");
    localStringBuilder = e.a.a.a.a.a(localStringBuilder.toString(), " generator matrix           : ");
    localStringBuilder.append(x.c);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */