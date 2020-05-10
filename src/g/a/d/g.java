package g.a.d;

public enum g
  implements g.a.a
{
  public static final a<g> resolver = a.a(g.class, 20000, 29999);
  
  static
  {
    SOCK_DGRAM = new g("SOCK_DGRAM", 1);
    SOCK_RAW = new g("SOCK_RAW", 2);
    SOCK_RDM = new g("SOCK_RDM", 3);
    SOCK_SEQPACKET = new g("SOCK_SEQPACKET", 4);
    SOCK_MAXADDRLEN = new g("SOCK_MAXADDRLEN", 5);
    g localg = new g("__UNKNOWN_CONSTANT__", 6);
    __UNKNOWN_CONSTANT__ = localg;
    $VALUES = new g[] { SOCK_STREAM, SOCK_DGRAM, SOCK_RAW, SOCK_RDM, SOCK_SEQPACKET, SOCK_MAXADDRLEN, localg };
  }
  
  public g() {}
  
  public static g valueOf(long paramLong)
  {
    return (g)resolver.a(paramLong);
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
 * Qualified Name:     base.g.a.d.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */