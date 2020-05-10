package j.a.b;

import j.a.b.m.l;
import j.a.b.m.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class d
  extends HashMap<String, Object>
  implements b, c, f
{
  public d() {}
  
  public d(Map<String, ?> paramMap)
  {
    super(paramMap);
  }
  
  public static String a(Map<String, ? extends Object> paramMap)
  {
    return a(paramMap, i.a);
  }
  
  public static String a(Map<String, ? extends Object> paramMap, g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(paramMap, localStringBuilder, paramg);
      return localStringBuilder.toString();
    }
    catch (IOException paramMap)
    {
      for (;;) {}
    }
  }
  
  public static void a(String paramString, Object paramObject, Appendable paramAppendable, g paramg)
  {
    if (paramString == null)
    {
      paramAppendable.append("null");
    }
    else if (!e.a(paramString))
    {
      paramAppendable.append(paramString);
    }
    else
    {
      paramAppendable.append('"');
      i.a(paramString, paramAppendable, paramg);
      paramAppendable.append('"');
    }
    paramAppendable.append(':');
    if ((paramObject instanceof String)) {
      paramg.a(paramAppendable, (String)paramObject);
    } else {
      i.a(paramObject, paramAppendable, paramg);
    }
  }
  
  public static void a(Map<String, ? extends Object> paramMap, Appendable paramAppendable, g paramg)
  {
    if (paramMap == null)
    {
      paramAppendable.append("null");
      return;
    }
    l.i.a(paramMap, paramAppendable, paramg);
  }
  
  public static String c(String paramString)
  {
    return i.a(paramString);
  }
  
  public String a()
  {
    return a(this, i.a);
  }
  
  public String a(g paramg)
  {
    return a(this, paramg);
  }
  
  public void a(Appendable paramAppendable)
  {
    a(this, paramAppendable, i.a);
  }
  
  public void a(Appendable paramAppendable, g paramg)
  {
    a(this, paramAppendable, paramg);
  }
  
  public String toString()
  {
    return a(this, i.a);
  }
}

/* Location:
 * Qualified Name:     j.a.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */