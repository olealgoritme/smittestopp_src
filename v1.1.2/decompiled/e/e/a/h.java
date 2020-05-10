package e.e.a;

import e.a.a.a.a;
import j.a.b.b;
import j.a.b.d;
import java.io.Serializable;

public final class h
  implements b, Serializable
{
  public static final h y = new h("JWT");
  public final String x;
  
  static
  {
    new h("JOSE");
    new h("JOSE+JSON");
  }
  
  public h(String paramString)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The object type must not be null");
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = a.a("\"");
    localStringBuilder.append(d.c(x));
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof h)) && (x.toLowerCase().equals(x.toLowerCase()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return x.toLowerCase().hashCode();
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.e.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */