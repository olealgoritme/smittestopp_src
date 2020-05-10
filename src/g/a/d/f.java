package g.a.d;

public enum f
  implements g.a.a
{
  public static final a<f> resolver = a.a(f.class, 20000, 29999);
  
  static
  {
    SHUT_RDWR = new f("SHUT_RDWR", 2);
    f localf = new f("__UNKNOWN_CONSTANT__", 3);
    __UNKNOWN_CONSTANT__ = localf;
    $VALUES = new f[] { SHUT_RD, SHUT_WR, SHUT_RDWR, localf };
  }
  
  public f() {}
  
  public static f valueOf(long paramLong)
  {
    return (f)resolver.a(paramLong);
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
 * Qualified Name:     base.g.a.d.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */