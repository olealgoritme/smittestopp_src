package g.a.d;

public enum c
  implements g.a.a
{
  public static final a<c> resolver = a.a(c.class, 20000, 20999);
  
  static
  {
    FASYNC = new c("FASYNC", 3);
    FFSYNC = new c("FFSYNC", 4);
    FNONBLOCK = new c("FNONBLOCK", 5);
    FNDELAY = new c("FNDELAY", 6);
    F_DUPFD = new c("F_DUPFD", 7);
    F_GETFD = new c("F_GETFD", 8);
    F_SETFD = new c("F_SETFD", 9);
    F_GETFL = new c("F_GETFL", 10);
    F_SETFL = new c("F_SETFL", 11);
    F_GETOWN = new c("F_GETOWN", 12);
    F_SETOWN = new c("F_SETOWN", 13);
    F_GETLK = new c("F_GETLK", 14);
    F_SETLK = new c("F_SETLK", 15);
    F_SETLKW = new c("F_SETLKW", 16);
    F_CHKCLEAN = new c("F_CHKCLEAN", 17);
    F_PREALLOCATE = new c("F_PREALLOCATE", 18);
    F_SETSIZE = new c("F_SETSIZE", 19);
    F_RDADVISE = new c("F_RDADVISE", 20);
    F_RDAHEAD = new c("F_RDAHEAD", 21);
    F_READBOOTSTRAP = new c("F_READBOOTSTRAP", 22);
    F_WRITEBOOTSTRAP = new c("F_WRITEBOOTSTRAP", 23);
    F_NOCACHE = new c("F_NOCACHE", 24);
    F_LOG2PHYS = new c("F_LOG2PHYS", 25);
    F_GETPATH = new c("F_GETPATH", 26);
    F_FULLFSYNC = new c("F_FULLFSYNC", 27);
    F_PATHPKG_CHECK = new c("F_PATHPKG_CHECK", 28);
    F_FREEZE_FS = new c("F_FREEZE_FS", 29);
    F_THAW_FS = new c("F_THAW_FS", 30);
    F_GLOBAL_NOCACHE = new c("F_GLOBAL_NOCACHE", 31);
    F_ADDSIGS = new c("F_ADDSIGS", 32);
    F_MARKDEPENDENCY = new c("F_MARKDEPENDENCY", 33);
    F_RDLCK = new c("F_RDLCK", 34);
    F_UNLCK = new c("F_UNLCK", 35);
    F_WRLCK = new c("F_WRLCK", 36);
    F_ALLOCATECONTIG = new c("F_ALLOCATECONTIG", 37);
    F_ALLOCATEALL = new c("F_ALLOCATEALL", 38);
    c localc = new c("__UNKNOWN_CONSTANT__", 39);
    __UNKNOWN_CONSTANT__ = localc;
    $VALUES = new c[] { FAPPEND, FREAD, FWRITE, FASYNC, FFSYNC, FNONBLOCK, FNDELAY, F_DUPFD, F_GETFD, F_SETFD, F_GETFL, F_SETFL, F_GETOWN, F_SETOWN, F_GETLK, F_SETLK, F_SETLKW, F_CHKCLEAN, F_PREALLOCATE, F_SETSIZE, F_RDADVISE, F_RDAHEAD, F_READBOOTSTRAP, F_WRITEBOOTSTRAP, F_NOCACHE, F_LOG2PHYS, F_GETPATH, F_FULLFSYNC, F_PATHPKG_CHECK, F_FREEZE_FS, F_THAW_FS, F_GLOBAL_NOCACHE, F_ADDSIGS, F_MARKDEPENDENCY, F_RDLCK, F_UNLCK, F_WRLCK, F_ALLOCATECONTIG, F_ALLOCATEALL, localc };
  }
  
  public c() {}
  
  public static c valueOf(long paramLong)
  {
    return (c)resolver.a(paramLong);
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
 * Qualified Name:     base.g.a.d.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */