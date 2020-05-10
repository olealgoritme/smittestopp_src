package h.e;

import e.a.a.a.a;
import h.c.g.j;
import java.net.SocketAddress;

public class h
  extends SocketAddress
{
  public transient e x;
  
  public h()
  {
    e locale = e.e();
    x = locale;
    locale.a(h.a.d.e.PF_UNIX);
  }
  
  public h(String paramString)
  {
    e locale = e.e();
    x = locale;
    locale.a(h.a.d.e.PF_UNIX);
    x.a(paramString);
  }
  
  public String a()
  {
    e locale = x;
    String str = c;
    if (str != null) {
      return str;
    }
    locale.c().c();
    throw null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof h;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (h)paramObject;
    bool1 = bool2;
    if (x.a() == x.a())
    {
      bool1 = bool2;
      if (a().equals(((h)paramObject).a())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("[family=");
    localStringBuilder.append(x.a());
    localStringBuilder.append(" path=");
    String str1 = a();
    String str2 = str1;
    if (str1.indexOf(0) == 0) {
      str2 = str1.replace('\000', '@');
    }
    return a.a(localStringBuilder, str2, "]");
  }
}

/* Location:
 * Qualified Name:     h.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */