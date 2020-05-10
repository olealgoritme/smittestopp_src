package e.e.a.u;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

public final class g
  implements Serializable
{
  public static final g y = new g("sig");
  public static final g z = new g("enc");
  public final String x;
  
  public g(String paramString)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The key use identifier must not be null");
  }
  
  public static g a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.equals(yx)) {
      return y;
    }
    if (paramString.equals(zx)) {
      return z;
    }
    if (!paramString.trim().isEmpty()) {
      return new g(paramString);
    }
    throw new ParseException("JWK use value must not be empty or blank", 0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    return Objects.equals(x, x);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { x });
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */