package h.c;

public enum d$f
{
  static
  {
    DRAGONFLY = new f("DRAGONFLY", 4);
    LINUX = new f("LINUX", 5);
    SOLARIS = new f("SOLARIS", 6);
    WINDOWS = new f("WINDOWS", 7);
    AIX = new f("AIX", 8);
    ZLINUX = new f("ZLINUX", 9);
    f localf = new f("UNKNOWN", 10);
    UNKNOWN = localf;
    $VALUES = new f[] { DARWIN, FREEBSD, NETBSD, OPENBSD, DRAGONFLY, LINUX, SOLARIS, WINDOWS, AIX, ZLINUX, localf };
  }
  
  public d$f() {}
  
  public String toString()
  {
    return name().toLowerCase(d.d);
  }
}

/* Location:
 * Qualified Name:     h.c.d.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */