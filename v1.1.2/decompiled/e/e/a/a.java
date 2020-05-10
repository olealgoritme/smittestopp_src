package e.e.a;

import j.a.b.b;
import j.a.b.d;
import java.io.Serializable;

public class a
  implements b, Serializable
{
  public static final a y = new a("none", r.REQUIRED);
  public final String x;
  
  public a(String paramString, r paramr)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The algorithm name must not be null");
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("\"");
    localStringBuilder.append(d.c(x));
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && ((paramObject instanceof a)) && (x.equals(paramObject.toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final int hashCode()
  {
    return x.hashCode();
  }
  
  public final String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */