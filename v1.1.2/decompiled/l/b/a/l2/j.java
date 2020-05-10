package l.b.a.l2;

import e.a.a.a.a;
import l.b.a.c;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;

public class j
  extends n
{
  public static final o A;
  public o x;
  public boolean y;
  public p z;
  
  static
  {
    new o("2.5.29.9").k();
    new o("2.5.29.14").k();
    new o("2.5.29.15").k();
    new o("2.5.29.16").k();
    new o("2.5.29.17").k();
    new o("2.5.29.18").k();
    new o("2.5.29.19").k();
    new o("2.5.29.20").k();
    new o("2.5.29.21").k();
    new o("2.5.29.23").k();
    new o("2.5.29.24").k();
    new o("2.5.29.27").k();
    A = new o("2.5.29.28").k();
    new o("2.5.29.29").k();
    new o("2.5.29.30").k();
    new o("2.5.29.31").k();
    new o("2.5.29.32").k();
    new o("2.5.29.33").k();
    new o("2.5.29.35").k();
    new o("2.5.29.36").k();
    new o("2.5.29.37").k();
    new o("2.5.29.46").k();
    new o("2.5.29.54").k();
    new o("1.3.6.1.5.5.7.1.1").k();
    new o("1.3.6.1.5.5.7.1.11").k();
    new o("1.3.6.1.5.5.7.1.12").k();
    new o("1.3.6.1.5.5.7.1.2").k();
    new o("1.3.6.1.5.5.7.1.3").k();
    new o("1.3.6.1.5.5.7.1.4").k();
    new o("2.5.29.56").k();
    new o("2.5.29.55").k();
    new o("2.5.29.60").k();
  }
  
  public j(u paramu)
  {
    if (paramu.size() == 2)
    {
      x = o.a(paramu.a(0));
      y = false;
      paramu = paramu.a(1);
    }
    else
    {
      if (paramu.size() != 3) {
        break label88;
      }
      x = o.a(paramu.a(0));
      y = c.a(paramu.a(1)).j();
      paramu = paramu.a(2);
    }
    z = p.a(paramu);
    return;
    label88:
    StringBuilder localStringBuilder = a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static j a(Object paramObject)
  {
    if ((paramObject instanceof j)) {
      return (j)paramObject;
    }
    if (paramObject != null) {
      return new j(u.a(paramObject));
    }
    return null;
  }
  
  public t b()
  {
    f localf = new f(3);
    localf.a(x);
    if (y) {
      localf.a(c.z);
    }
    localf.a(z);
    return new e1(localf);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof j;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (j)paramObject;
    bool1 = bool2;
    if (x.b(x))
    {
      bool1 = bool2;
      if (z.b(z))
      {
        bool1 = bool2;
        if (y == y) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (y) {
      return z.hashCode() ^ x.hashCode();
    }
    return z.hashCode() ^ x.hashCode();
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */