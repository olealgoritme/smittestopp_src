package e.e.a;

import e.a.a.a.a;
import i.a.b.b;
import i.a.b.d;
import java.io.Serializable;

public final class c
  implements b, Serializable
{
  public final String x;
  
  static
  {
    new c("DEF");
  }
  
  public c(String paramString)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The compression algorithm name must not be null");
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
    if ((paramObject != null) && ((paramObject instanceof c)) && (x.equals(paramObject.toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */