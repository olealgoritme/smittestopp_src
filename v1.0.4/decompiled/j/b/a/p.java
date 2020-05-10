package j.b.a;

import e.a.a.a.a;
import h.k.b.g;

public final class p
{
  public final o a;
  public final o b;
  
  public p(o paramo1, o paramo2) {}
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((g.a(a, a)) && (g.a(b, b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    o localo = a;
    int i = 0;
    int j;
    if (localo != null) {
      j = localo.hashCode();
    } else {
      j = 0;
    }
    localo = b;
    if (localo != null) {
      i = localo.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("JsonChunks(gps=");
    localStringBuilder.append(a);
    localStringBuilder.append(", bluetooth=");
    localStringBuilder.append(b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */