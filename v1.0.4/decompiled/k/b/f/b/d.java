package k.b.f.b;

import java.math.BigInteger;

public class d
  implements e
{
  public final a a;
  public final c b;
  
  public d(a parama, c paramc)
  {
    a = parama;
    b = paramc;
  }
  
  public int a()
  {
    int i = a.a();
    int[] arrayOfInt = b.a;
    return i * arrayOfInt[(arrayOfInt.length - 1)];
  }
  
  public BigInteger b()
  {
    return a.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    if ((!a.equals(a)) || (!b.equals(b))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a.hashCode() ^ Integer.rotateLeft(b.hashCode(), 16);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */