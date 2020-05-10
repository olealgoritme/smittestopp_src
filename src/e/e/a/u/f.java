package e.e.a.u;

import e.a.a.a.a;
import e.e.a.r;
import i.a.b.b;
import i.a.b.d;
import java.io.Serializable;

public final class f
  implements b, Serializable
{
  public static final f A = new f("oct", r.OPTIONAL);
  public static final f B = new f("OKP", r.OPTIONAL);
  public static final f y = new f("EC", r.RECOMMENDED);
  public static final f z = new f("RSA", r.REQUIRED);
  public final String x;
  
  public f(String paramString, r paramr)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The key type value must not be null");
  }
  
  public static f a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals(yx)) {
        return y;
      }
      if (paramString.equals(zx)) {
        return z;
      }
      if (paramString.equals(Ax)) {
        return A;
      }
      if (paramString.equals(Bx)) {
        return B;
      }
      return new f(paramString, null);
    }
    throw new IllegalArgumentException("The key type to parse must not be null");
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
    if ((paramObject != null) && ((paramObject instanceof f)) && (x.equals(paramObject.toString()))) {
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
 * Qualified Name:     base.e.e.a.u.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */