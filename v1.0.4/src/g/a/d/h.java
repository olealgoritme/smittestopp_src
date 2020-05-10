package g.a.d;

public enum h
  implements g.a.a
{
  public static final a<h> resolver = a.a(h.class, 20000, 29999);
  
  static
  {
    SOL_IP = new h("SOL_IP", 1);
    SOL_TCP = new h("SOL_TCP", 2);
    SOL_UDP = new h("SOL_UDP", 3);
    h localh = new h("__UNKNOWN_CONSTANT__", 4);
    __UNKNOWN_CONSTANT__ = localh;
    $VALUES = new h[] { SOL_SOCKET, SOL_IP, SOL_TCP, SOL_UDP, localh };
  }
  
  public h() {}
  
  public static h valueOf(long paramLong)
  {
    return (h)resolver.a(paramLong);
  }
  
  public final boolean defined()
  {
    return resolver.a(this);
  }
  
  public final String description()
  {
    return resolver.b(this).toString();
  }
  
  public final int intValue()
  {
    return (int)resolver.b(this).longValue();
  }
  
  public final long longValue()
  {
    return resolver.c(this);
  }
  
  public final String toString()
  {
    return description();
  }
  
  public final int value()
  {
    return (int)resolver.b(this).longValue();
  }
}

/* Location:
 * Qualified Name:     base.g.a.d.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */