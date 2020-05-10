package g.c;

import java.util.Locale;

public abstract class d
{
  public static final Locale d = Locale.ENGLISH;
  public final d.f a;
  public final d.b b;
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
    return d.g.a;
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
    d.f localf = a;
    boolean bool;
    if ((localf != d.f.FREEBSD) && (localf != d.f.OPENBSD) && (localf != d.f.NETBSD) && (localf != d.f.DARWIN) && (localf != d.f.DRAGONFLY)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.g.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */