package e.e.a;

import e.e.a.v.a;
import e.e.a.v.c;
import java.io.Serializable;
import java.text.ParseException;

public abstract class g
  implements Serializable
{
  public p x = null;
  public c[] y = null;
  
  public static c[] a(String paramString)
  {
    paramString = paramString.trim();
    int i = paramString.indexOf(".");
    if (i != -1)
    {
      int j = i + 1;
      int k = paramString.indexOf(".", j);
      if (k != -1)
      {
        int m = k + 1;
        int n = paramString.indexOf(".", m);
        if (n == -1) {
          return new c[] { new c(paramString.substring(0, i)), new c(paramString.substring(j, k)), new c(paramString.substring(m)) };
        }
        int i1 = n + 1;
        int i2 = paramString.indexOf(".", i1);
        if (i2 != -1)
        {
          if ((i2 != -1) && (paramString.indexOf(".", i2 + 1) != -1)) {
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
          }
          return new c[] { new c(paramString.substring(0, i)), new c(paramString.substring(j, k)), new c(paramString.substring(m, n)), new c(paramString.substring(i1, i2)), new c(paramString.substring(i2 + 1)) };
        }
        throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
      }
      throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
    }
    throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
  }
  
  public String a()
  {
    if (y == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (c localc : y)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('.');
      }
      if (localc != null) {
        localStringBuilder.append(x);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */