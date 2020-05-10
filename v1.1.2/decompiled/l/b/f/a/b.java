package l.b.f.a;

import java.math.BigInteger;
import l.b.f.b.a;
import l.b.f.b.e;

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
  
  public static abstract class a
    extends b
  {
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public d a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    {
      c localc = a(paramBigInteger1);
      paramBigInteger1 = a(paramBigInteger2);
      int i = d;
      if ((i == 5) || (i == 6)) {
        if (localc.e())
        {
          if (!paramBigInteger1.g().equals(c)) {
            throw new IllegalArgumentException();
          }
        }
        else {
          paramBigInteger1 = ((c.c)paramBigInteger1).c(localc.c()).a(localc);
        }
      }
      return new d.c((b.c)this, localc, paramBigInteger1);
    }
  }
  
  public static abstract class b
    extends b
  {
    public b(BigInteger paramBigInteger)
    {
      super();
    }
  }
  
  public static class c
    extends b.a
  {
    public int e;
    public int f;
    public int g;
    public int h;
    public d.c i;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    {
      super(paramInt2, paramInt3, paramInt4);
      e = paramInt1;
      f = paramInt2;
      g = paramInt3;
      h = paramInt4;
      i = new d.c(this, null, null);
      b = a(paramBigInteger1);
      c = a(paramBigInteger2);
      d = 6;
    }
    
    public c a(BigInteger paramBigInteger)
    {
      return new c.c(e, f, g, h, paramBigInteger);
    }
    
    public d a()
    {
      return i;
    }
    
    public d a(c paramc1, c paramc2)
    {
      return new d.c(this, paramc1, paramc2);
    }
  }
  
  public static class d
    extends b.b
  {
    public BigInteger e;
    public BigInteger f;
    public d.d g;
    
    public d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
    {
      super();
      e = paramBigInteger1;
      f = c.d.b(paramBigInteger1);
      g = new d.d(this, null, null);
      b = a(paramBigInteger2);
      c = a(paramBigInteger3);
      d = 4;
    }
    
    public c a(BigInteger paramBigInteger)
    {
      return new c.d(e, f, paramBigInteger);
    }
    
    public d a()
    {
      return g;
    }
    
    public d a(c paramc1, c paramc2)
    {
      return new d.d(this, paramc1, paramc2);
    }
    
    public d a(d paramd)
    {
      if ((this != a) && (d == 2) && (!paramd.c()))
      {
        int i = a.d;
        if ((i == 2) || (i == 3) || (i == 4)) {
          return new d.d(this, a(b.h()), a(c.h()), new c[] { a(d[0].h()) });
        }
      }
      return super.a(paramd);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.f.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */