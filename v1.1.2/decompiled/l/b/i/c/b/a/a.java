package l.b.i.c.b.a;

import java.io.IOException;
import java.security.PrivateKey;
import l.b.a.i2.f;
import l.b.a.n;
import l.b.i.d.a.d;

public class a
  implements PrivateKey
{
  public l.b.i.b.a.b x;
  
  public a(l.b.i.b.a.b paramb)
  {
    x = paramb;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      a locala = (a)paramObject;
      l.b.i.b.a.b localb = x;
      int i = b;
      paramObject = x;
      if ((i == b) && (c == c) && (d.equals(d)) && (x.e.equals(x.e)) && (x.f.equals(x.f)) && (x.g.equals(x.g)))
      {
        bool = true;
        break label138;
      }
    }
    boolean bool = false;
    label138:
    return bool;
  }
  
  public String getAlgorithm()
  {
    return "McEliece-CCA2";
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new l/b/i/a/a;
      ((l.b.i.a.a)localObject2).<init>(x.b, x.c, x.d, x.e, x.f, l.b.c.e.a.b(x.a));
      l.b.a.l2.a locala = new l/b/a/l2/a;
      locala.<init>(l.b.i.a.e.d);
      f localf = new l/b/a/i2/f;
      localf.<init>(locala, (l.b.a.e)localObject2, null, null);
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
    l.b.i.b.a.b localb = x;
    int i = c;
    int j = b;
    int k = d.b;
    int m = e.hashCode();
    int n = x.f.hashCode();
    return x.g.hashCode() + (n + (m + ((i * 37 + j) * 37 + k) * 37) * 37) * 37;
  }
}

/* Location:
 * Qualified Name:     l.b.i.c.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */