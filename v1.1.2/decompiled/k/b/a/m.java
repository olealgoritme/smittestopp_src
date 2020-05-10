package k.b.a;

import e.a.a.a.a;
import i.k.b.g;

public final class m
{
  public final l a;
  public final l b;
  
  public m(l paraml1, l paraml2) {}
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
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
    l locall = a;
    int i = 0;
    int j;
    if (locall != null) {
      j = locall.hashCode();
    } else {
      j = 0;
    }
    locall = b;
    if (locall != null) {
      i = locall.hashCode();
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
 * Qualified Name:     k.b.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */