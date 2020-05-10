package g.a.d;

public enum d
  implements g.a.a
{
  public static final a<d> resolver = new a(d.class, 0, true);
  
  static
  {
    O_RDWR = new d("O_RDWR", 2);
    O_ACCMODE = new d("O_ACCMODE", 3);
    O_NONBLOCK = new d("O_NONBLOCK", 4);
    O_APPEND = new d("O_APPEND", 5);
    O_SYNC = new d("O_SYNC", 6);
    O_SHLOCK = new d("O_SHLOCK", 7);
    O_EXLOCK = new d("O_EXLOCK", 8);
    O_ASYNC = new d("O_ASYNC", 9);
    O_FSYNC = new d("O_FSYNC", 10);
    O_NOFOLLOW = new d("O_NOFOLLOW", 11);
    O_CREAT = new d("O_CREAT", 12);
    O_TRUNC = new d("O_TRUNC", 13);
    O_EXCL = new d("O_EXCL", 14);
    O_EVTONLY = new d("O_EVTONLY", 15);
    O_DIRECTORY = new d("O_DIRECTORY", 16);
    O_SYMLINK = new d("O_SYMLINK", 17);
    O_BINARY = new d("O_BINARY", 18);
    O_NOCTTY = new d("O_NOCTTY", 19);
    O_TMPFILE = new d("O_TMPFILE", 20);
    O_CLOEXEC = new d("O_CLOEXEC", 21);
    d locald = new d("__UNKNOWN_CONSTANT__", 22);
    __UNKNOWN_CONSTANT__ = locald;
    $VALUES = new d[] { O_RDONLY, O_WRONLY, O_RDWR, O_ACCMODE, O_NONBLOCK, O_APPEND, O_SYNC, O_SHLOCK, O_EXLOCK, O_ASYNC, O_FSYNC, O_NOFOLLOW, O_CREAT, O_TRUNC, O_EXCL, O_EVTONLY, O_DIRECTORY, O_SYMLINK, O_BINARY, O_NOCTTY, O_TMPFILE, O_CLOEXEC, locald };
  }
  
  public d() {}
  
  public static d valueOf(long paramLong)
  {
    return (d)resolver.a(paramLong);
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
 * Qualified Name:     base.g.a.d.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */