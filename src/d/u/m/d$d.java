package d.u.m;

import e.a.a.a.a;
import java.util.List;

public class d$d
{
  public final String a;
  public final boolean b;
  public final List<String> c;
  
  public d$d(String paramString, boolean paramBoolean, List<String> paramList)
  {
    a = paramString;
    b = paramBoolean;
    c = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      paramObject = (d)paramObject;
      if (b != b) {
        return false;
      }
      if (!c.equals(c)) {
        return false;
      }
      if (a.startsWith("index_")) {
        return a.startsWith("index_");
      }
      return a.equals(a);
    }
    return false;
  }
  
  public int hashCode()
  {
    int i;
    if (a.startsWith("index_")) {
      i = -1184239155;
    } else {
      i = a.hashCode();
    }
    int j = b;
    return c.hashCode() + (i * 31 + j) * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Index{name='");
    a.a(localStringBuilder, a, '\'', ", unique=");
    localStringBuilder.append(b);
    localStringBuilder.append(", columns=");
    localStringBuilder.append(c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.u.m.d.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */