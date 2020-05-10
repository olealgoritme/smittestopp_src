package h.e;

import java.net.SocketOption;

public class j$a<T>
  implements SocketOption<T>
{
  public final String a;
  public final Class<T> b;
  
  public j$a(String paramString, Class<T> paramClass)
  {
    a = paramString;
    b = paramClass;
  }
  
  public String name()
  {
    return a;
  }
  
  public String toString()
  {
    return a;
  }
  
  public Class<T> type()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     h.e.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */