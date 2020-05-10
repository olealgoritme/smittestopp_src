package i.k.b;

import i.m.c;
import i.m.e;

public abstract class j
  extends b
  implements e
{
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof j))
    {
      j localj = (j)paramObject;
      i locali = (i)this;
      c localc = A;
      paramObject = (i)localj;
      if ((!localc.equals(A)) || (!B.equals(B)) || (!C.equals(C)) || (!g.a(y, y))) {
        bool = false;
      }
      return bool;
    }
    if ((paramObject instanceof e)) {
      return paramObject.equals(a());
    }
    return false;
  }
  
  public int hashCode()
  {
    i locali = (i)this;
    int i = A.hashCode();
    int j = B.hashCode();
    return C.hashCode() + (j + i * 31) * 31;
  }
  
  public String toString()
  {
    i.m.a locala = a();
    if (locala != this) {
      return locala.toString();
    }
    return e.a.a.a.a.a(e.a.a.a.a.a("property "), B, " (Kotlin reflection is not available)");
  }
}

/* Location:
 * Qualified Name:     i.k.b.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */