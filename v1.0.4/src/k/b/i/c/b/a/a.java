package k.b.i.c.b.a;

import java.io.IOException;
import java.security.PrivateKey;
import k.b.a.i2.f;
import k.b.a.n;
import k.b.i.d.a.d;

public class a
  implements PrivateKey
{
  public k.b.i.b.a.b x;
  
  public a(k.b.i.b.a.b paramb)
  {
    x = paramb;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof a)))
    {
      a locala = (a)paramObject;
      k.b.i.b.a.b localb = x;
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
      k.b.i.a.a locala = new k/b/i/a/a;
      locala.<init>(x.b, x.c, x.d, x.e, x.f, k.b.c.e.a.a(x.a));
      Object localObject2 = new k/b/a/l2/a;
      ((k.b.a.l2.a)localObject2).<init>(k.b.i.a.e.d);
      f localf = new k/b/a/i2/f;
      localf.<init>((k.b.a.l2.a)localObject2, locala, null, null);
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
    k.b.i.b.a.b localb = x;
    int i = c;
    int j = b;
    int k = d.b;
    int m = e.hashCode();
    int n = x.f.hashCode();
    return x.g.hashCode() + (n + (m + ((i * 37 + j) * 37 + k) * 37) * 37) * 37;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.c.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */