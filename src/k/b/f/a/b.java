package k.b.f.a;

import java.math.BigInteger;
import k.b.f.b.a;

public abstract class b
{
  public a a;
  public c b;
  public c c;
  public int d = 0;
  
  public b(a parama)
  {
    a = parama;
  }
  
  public abstract c a(BigInteger paramBigInteger);
  
  public abstract d a();
  
  public d a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return a(a(paramBigInteger1), a(paramBigInteger2));
  }
  
  public abstract d a(c paramc1, c paramc2);
  
  public d a(d paramd)
  {
    if (this == a) {
      return paramd;
    }
    if (paramd.c()) {
      return a();
    }
    paramd = paramd.d();
    return a(b.h(), paramd.b().h());
  }
  
  public boolean a(b paramb)
  {
    boolean bool;
    if ((this != paramb) && ((paramb == null) || (!a.equals(a)) || (!b.h().equals(b.h())) || (!c.h().equals(c.h())))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((this != paramObject) && ((!(paramObject instanceof b)) || (!a((b)paramObject)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a.hashCode() ^ Integer.rotateLeft(b.h().hashCode(), 8) ^ Integer.rotateLeft(c.h().hashCode(), 16);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */