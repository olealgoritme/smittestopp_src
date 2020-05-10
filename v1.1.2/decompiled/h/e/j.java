package h.e;

import java.net.SocketOption;

public final class j
{
  public static final SocketOption<Integer> a = new a("SO_SNDBUF", Integer.class);
  public static final SocketOption<Integer> b = new a("SO_SNDTIMEO", Integer.class);
  public static final SocketOption<Integer> c = new a("SO_RCVBUF", Integer.class);
  public static final SocketOption<Integer> d = new a("SO_RCVTIMEO", Integer.class);
  public static final SocketOption<Boolean> e = new a("SO_KEEPALIVE", Boolean.class);
  public static final SocketOption<c> f = new a("SO_PEERCRED", c.class);
  public static final SocketOption<Boolean> g = new a("SO_PASSCRED", Boolean.class);
  
  public static class a<T>
    implements SocketOption<T>
  {
    public final String a;
    public final Class<T> b;
    
    public a(String paramString, Class<T> paramClass)
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
}

/* Location:
 * Qualified Name:     h.e.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */