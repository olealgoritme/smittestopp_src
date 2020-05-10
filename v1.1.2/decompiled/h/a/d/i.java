package h.a.d;

public enum i
  implements h.a.a
{
  public static final a<i> resolver = a.a(i.class, 20000, 29999);
  
  static
  {
    SO_ACCEPTCONN = new i("SO_ACCEPTCONN", 1);
    SO_REUSEADDR = new i("SO_REUSEADDR", 2);
    SO_KEEPALIVE = new i("SO_KEEPALIVE", 3);
    SO_DONTROUTE = new i("SO_DONTROUTE", 4);
    SO_BROADCAST = new i("SO_BROADCAST", 5);
    SO_USELOOPBACK = new i("SO_USELOOPBACK", 6);
    SO_LINGER = new i("SO_LINGER", 7);
    SO_OOBINLINE = new i("SO_OOBINLINE", 8);
    SO_REUSEPORT = new i("SO_REUSEPORT", 9);
    SO_TIMESTAMP = new i("SO_TIMESTAMP", 10);
    SO_ACCEPTFILTER = new i("SO_ACCEPTFILTER", 11);
    SO_DONTTRUNC = new i("SO_DONTTRUNC", 12);
    SO_WANTMORE = new i("SO_WANTMORE", 13);
    SO_WANTOOBFLAG = new i("SO_WANTOOBFLAG", 14);
    SO_SNDBUF = new i("SO_SNDBUF", 15);
    SO_RCVBUF = new i("SO_RCVBUF", 16);
    SO_SNDLOWAT = new i("SO_SNDLOWAT", 17);
    SO_RCVLOWAT = new i("SO_RCVLOWAT", 18);
    SO_SNDTIMEO = new i("SO_SNDTIMEO", 19);
    SO_RCVTIMEO = new i("SO_RCVTIMEO", 20);
    SO_ERROR = new i("SO_ERROR", 21);
    SO_TYPE = new i("SO_TYPE", 22);
    SO_NREAD = new i("SO_NREAD", 23);
    SO_NKE = new i("SO_NKE", 24);
    SO_NOSIGPIPE = new i("SO_NOSIGPIPE", 25);
    SO_NOADDRERR = new i("SO_NOADDRERR", 26);
    SO_NWRITE = new i("SO_NWRITE", 27);
    SO_REUSESHAREUID = new i("SO_REUSESHAREUID", 28);
    SO_LABEL = new i("SO_LABEL", 29);
    SO_PEERLABEL = new i("SO_PEERLABEL", 30);
    SO_ATTACH_FILTER = new i("SO_ATTACH_FILTER", 31);
    SO_BINDTODEVICE = new i("SO_BINDTODEVICE", 32);
    SO_DETACH_FILTER = new i("SO_DETACH_FILTER", 33);
    SO_NO_CHECK = new i("SO_NO_CHECK", 34);
    SO_PASSCRED = new i("SO_PASSCRED", 35);
    SO_PEERCRED = new i("SO_PEERCRED", 36);
    SO_PEERNAME = new i("SO_PEERNAME", 37);
    SO_PRIORITY = new i("SO_PRIORITY", 38);
    SO_SECURITY_AUTHENTICATION = new i("SO_SECURITY_AUTHENTICATION", 39);
    SO_SECURITY_ENCRYPTION_NETWORK = new i("SO_SECURITY_ENCRYPTION_NETWORK", 40);
    SO_SECURITY_ENCRYPTION_TRANSPORT = new i("SO_SECURITY_ENCRYPTION_TRANSPORT", 41);
    i locali = new i("__UNKNOWN_CONSTANT__", 42);
    __UNKNOWN_CONSTANT__ = locali;
    $VALUES = new i[] { SO_DEBUG, SO_ACCEPTCONN, SO_REUSEADDR, SO_KEEPALIVE, SO_DONTROUTE, SO_BROADCAST, SO_USELOOPBACK, SO_LINGER, SO_OOBINLINE, SO_REUSEPORT, SO_TIMESTAMP, SO_ACCEPTFILTER, SO_DONTTRUNC, SO_WANTMORE, SO_WANTOOBFLAG, SO_SNDBUF, SO_RCVBUF, SO_SNDLOWAT, SO_RCVLOWAT, SO_SNDTIMEO, SO_RCVTIMEO, SO_ERROR, SO_TYPE, SO_NREAD, SO_NKE, SO_NOSIGPIPE, SO_NOADDRERR, SO_NWRITE, SO_REUSESHAREUID, SO_LABEL, SO_PEERLABEL, SO_ATTACH_FILTER, SO_BINDTODEVICE, SO_DETACH_FILTER, SO_NO_CHECK, SO_PASSCRED, SO_PEERCRED, SO_PEERNAME, SO_PRIORITY, SO_SECURITY_AUTHENTICATION, SO_SECURITY_ENCRYPTION_NETWORK, SO_SECURITY_ENCRYPTION_TRANSPORT, locali };
  }
  
  public i() {}
  
  public static i valueOf(long paramLong)
  {
    return (i)resolver.a(paramLong);
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
 * Qualified Name:     h.a.d.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */