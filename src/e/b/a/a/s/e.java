package e.b.a.a.s;

import java.util.concurrent.ConcurrentHashMap;

public final class e
  extends ConcurrentHashMap<String, String>
{
  public static final e y = new e();
  public final Object x = new Object();
  
  public e()
  {
    super(180, 0.8F, 4);
  }
  
  public String c(String paramString)
  {
    ??? = (String)get(paramString);
    if (??? != null) {
      return (String)???;
    }
    if (size() >= 180) {
      synchronized (x)
      {
        if (size() >= 180) {
          clear();
        }
      }
    }
    paramString = paramString.intern();
    put(paramString, paramString);
    return paramString;
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.s.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */