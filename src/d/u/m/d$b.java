package d.u.m;

import e.a.a.a.a;
import java.util.Collections;
import java.util.List;

public class d$b
{
  public final String a;
  public final String b;
  public final String c;
  public final List<String> d;
  public final List<String> e;
  
  public d$b(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
  {
    a = paramString1;
    b = paramString2;
    c = paramString3;
    d = Collections.unmodifiableList(paramList1);
    e = Collections.unmodifiableList(paramList2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (b.class == paramObject.getClass()))
    {
      paramObject = (b)paramObject;
      if (!a.equals(a)) {
        return false;
      }
      if (!b.equals(b)) {
        return false;
      }
      if (!c.equals(c)) {
        return false;
      }
      if (!d.equals(d)) {
        return false;
      }
      return e.equals(e);
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    int j = b.hashCode();
    int k = c.hashCode();
    int m = d.hashCode();
    return e.hashCode() + (m + (k + (j + i * 31) * 31) * 31) * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("ForeignKey{referenceTable='");
    a.a(localStringBuilder, a, '\'', ", onDelete='");
    a.a(localStringBuilder, b, '\'', ", onUpdate='");
    a.a(localStringBuilder, c, '\'', ", columnNames=");
    localStringBuilder.append(d);
    localStringBuilder.append(", referenceColumnNames=");
    localStringBuilder.append(e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.u.m.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */