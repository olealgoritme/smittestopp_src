package h.c;

import java.util.Locale;

public abstract class d
{
  public static final Locale d = Locale.ENGLISH;
  public final f a;
  public final b b;
  public final int c;
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!paramString1.equalsIgnoreCase(paramString2)) && (!paramString1.toUpperCase(d).equals(paramString2.toUpperCase(d))) && (!paramString1.toLowerCase(d).equals(paramString2.toLowerCase(d)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!paramString1.startsWith(paramString2)) && (!paramString1.toUpperCase(d).startsWith(paramString2.toUpperCase(d))) && (!paramString1.toLowerCase(d).startsWith(paramString2.toLowerCase(d)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static d d()
  {
    return g.a;
  }
  
  public String a()
  {
    int i = a.ordinal();
    if (i != 5)
    {
      if (i != 7)
      {
        if (i != 8) {
          return "c";
        }
        String str;
        if (c == 32) {
          str = "libc.a(shr.o)";
        } else {
          str = "libc.a(shr_64.o)";
        }
        return str;
      }
      return "msvcrt";
    }
    return "libc.so.6";
  }
  
  public final boolean b()
  {
    f localf = a;
    boolean bool;
    if ((localf != f.FREEBSD) && (localf != f.OPENBSD) && (localf != f.NETBSD) && (localf != f.DARWIN) && (localf != f.DRAGONFLY)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static enum b
  {
    static
    {
      PPC = new b("PPC", 2);
      PPC64 = new b("PPC64", 3);
      PPC64LE = new b("PPC64LE", 4);
      SPARC = new b("SPARC", 5);
      SPARCV9 = new b("SPARCV9", 6);
      S390X = new b("S390X", 7);
      MIPS32 = new b("MIPS32", 8);
      ARM = new b("ARM", 9);
      AARCH64 = new b("AARCH64", 10);
      b localb = new b("UNKNOWN", 11);
      UNKNOWN = localb;
      $VALUES = new b[] { I386, X86_64, PPC, PPC64, PPC64LE, SPARC, SPARCV9, S390X, MIPS32, ARM, AARCH64, localb };
    }
    
    public b() {}
    
    public String toString()
    {
      return name().toLowerCase(d.d);
    }
  }
  
  public static final class c
    extends d.h
  {
    public c()
    {
      super();
    }
  }
  
  public static final class d
    extends d.h
  {
    public d(d.f paramf)
    {
      super();
    }
  }
  
  public static final class e
    extends d.h
  {
    public e()
    {
      super();
    }
  }
  
  public static enum f
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
    
    public f() {}
    
    public String toString()
    {
      return name().toLowerCase(d.d);
    }
  }
  
  public static final class g
  {
    public static final d a = ;
  }
  
  public static class h
    extends d
  {
    public h(d.f paramf)
    {
      super(null);
    }
  }
  
  public static class i
    extends d
  {
    public i(d.f paramf)
    {
      super(null);
    }
  }
  
  public static class j
    extends d.h
  {
    public j()
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     h.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */