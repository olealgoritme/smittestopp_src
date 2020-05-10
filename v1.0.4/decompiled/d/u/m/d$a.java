package d.u.m;

import e.a.a.a.a;
import java.util.Locale;

public class d$a
{
  public final String a;
  public final String b;
  public final int c;
  public final boolean d;
  public final int e;
  public final String f;
  public final int g;
  
  public d$a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2)
  {
    a = paramString1;
    b = paramString2;
    d = paramBoolean;
    e = paramInt1;
    paramInt1 = 5;
    if (paramString2 != null)
    {
      paramString1 = paramString2.toUpperCase(Locale.US);
      if (paramString1.contains("INT")) {
        paramInt1 = 3;
      } else if ((!paramString1.contains("CHAR")) && (!paramString1.contains("CLOB")) && (!paramString1.contains("TEXT")))
      {
        if (!paramString1.contains("BLOB")) {
          if ((!paramString1.contains("REAL")) && (!paramString1.contains("FLOA")) && (!paramString1.contains("DOUB"))) {
            paramInt1 = 1;
          } else {
            paramInt1 = 4;
          }
        }
      }
      else {
        paramInt1 = 2;
      }
    }
    c = paramInt1;
    f = paramString3;
    g = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (a.class == paramObject.getClass()))
    {
      paramObject = (a)paramObject;
      if (e != e) {
        return false;
      }
      if (!a.equals(a)) {
        return false;
      }
      if (d != d) {
        return false;
      }
      String str;
      if ((g == 1) && (g == 2))
      {
        str = f;
        if ((str != null) && (!str.equals(f))) {
          return false;
        }
      }
      if ((g == 2) && (g == 1))
      {
        str = f;
        if ((str != null) && (!str.equals(f))) {
          return false;
        }
      }
      int i = g;
      if ((i != 0) && (i == g))
      {
        str = f;
        if (str != null ? !str.equals(f) : f != null) {
          return false;
        }
      }
      if (c != c) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    int j = c;
    int k;
    if (d) {
      k = 1231;
    } else {
      k = 1237;
    }
    return ((i * 31 + j) * 31 + k) * 31 + e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Column{name='");
    a.a(localStringBuilder, a, '\'', ", type='");
    a.a(localStringBuilder, b, '\'', ", affinity='");
    localStringBuilder.append(c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notNull=");
    localStringBuilder.append(d);
    localStringBuilder.append(", primaryKeyPosition=");
    localStringBuilder.append(e);
    localStringBuilder.append(", defaultValue='");
    localStringBuilder.append(f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.u.m.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */