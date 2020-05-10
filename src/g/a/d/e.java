package g.a.d;

public enum e
  implements g.a.a
{
  public static final a<e> resolver = a.a(e.class, 20000, 29999);
  
  static
  {
    PF_LOCAL = new e("PF_LOCAL", 1);
    PF_UNIX = new e("PF_UNIX", 2);
    PF_INET = new e("PF_INET", 3);
    PF_IMPLINK = new e("PF_IMPLINK", 4);
    PF_PUP = new e("PF_PUP", 5);
    PF_CHAOS = new e("PF_CHAOS", 6);
    PF_NS = new e("PF_NS", 7);
    PF_ISO = new e("PF_ISO", 8);
    PF_OSI = new e("PF_OSI", 9);
    PF_ECMA = new e("PF_ECMA", 10);
    PF_DATAKIT = new e("PF_DATAKIT", 11);
    PF_CCITT = new e("PF_CCITT", 12);
    PF_SNA = new e("PF_SNA", 13);
    PF_DECnet = new e("PF_DECnet", 14);
    PF_DLI = new e("PF_DLI", 15);
    PF_LAT = new e("PF_LAT", 16);
    PF_HYLINK = new e("PF_HYLINK", 17);
    PF_APPLETALK = new e("PF_APPLETALK", 18);
    PF_ROUTE = new e("PF_ROUTE", 19);
    PF_LINK = new e("PF_LINK", 20);
    PF_XTP = new e("PF_XTP", 21);
    PF_COIP = new e("PF_COIP", 22);
    PF_CNT = new e("PF_CNT", 23);
    PF_SIP = new e("PF_SIP", 24);
    PF_IPX = new e("PF_IPX", 25);
    PF_RTIP = new e("PF_RTIP", 26);
    PF_PIP = new e("PF_PIP", 27);
    PF_NDRV = new e("PF_NDRV", 28);
    PF_ISDN = new e("PF_ISDN", 29);
    PF_KEY = new e("PF_KEY", 30);
    PF_INET6 = new e("PF_INET6", 31);
    PF_NATM = new e("PF_NATM", 32);
    PF_SYSTEM = new e("PF_SYSTEM", 33);
    PF_NETBIOS = new e("PF_NETBIOS", 34);
    PF_PPP = new e("PF_PPP", 35);
    PF_ATM = new e("PF_ATM", 36);
    PF_NETGRAPH = new e("PF_NETGRAPH", 37);
    PF_MAX = new e("PF_MAX", 38);
    e locale = new e("__UNKNOWN_CONSTANT__", 39);
    __UNKNOWN_CONSTANT__ = locale;
    $VALUES = new e[] { PF_UNSPEC, PF_LOCAL, PF_UNIX, PF_INET, PF_IMPLINK, PF_PUP, PF_CHAOS, PF_NS, PF_ISO, PF_OSI, PF_ECMA, PF_DATAKIT, PF_CCITT, PF_SNA, PF_DECnet, PF_DLI, PF_LAT, PF_HYLINK, PF_APPLETALK, PF_ROUTE, PF_LINK, PF_XTP, PF_COIP, PF_CNT, PF_SIP, PF_IPX, PF_RTIP, PF_PIP, PF_NDRV, PF_ISDN, PF_KEY, PF_INET6, PF_NATM, PF_SYSTEM, PF_NETBIOS, PF_PPP, PF_ATM, PF_NETGRAPH, PF_MAX, locale };
  }
  
  public e() {}
  
  public static e valueOf(long paramLong)
  {
    return (e)resolver.a(paramLong);
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
 * Qualified Name:     base.g.a.d.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */