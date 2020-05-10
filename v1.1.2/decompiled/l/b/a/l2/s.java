package l.b.a.l2;

import java.util.Enumeration;
import l.b.a.b;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.n;
import l.b.a.r0;
import l.b.a.t;
import l.b.a.u;

public class s
  extends n
{
  public a x;
  public r0 y;
  
  public s(a parama, e parame)
  {
    y = new r0(parame);
    x = parama;
  }
  
  public s(a parama, byte[] paramArrayOfByte)
  {
    y = new r0(paramArrayOfByte);
    x = parama;
  }
  
  public s(u paramu)
  {
    if (paramu.size() == 2)
    {
      paramu = paramu.j();
      x = a.a(paramu.nextElement());
      y = r0.a(paramu.nextElement());
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static s a(Object paramObject)
  {
    if ((paramObject instanceof s)) {
      return (s)paramObject;
    }
    if (paramObject != null) {
      return new s(u.a(paramObject));
    }
    return null;
  }
  
  public t b()
  {
    f localf = new f(2);
    localf.a(x);
    localf.a(y);
    return new e1(localf);
  }
  
  public t f()
  {
    r0 localr0 = y;
    if (y == 0) {
      return t.a(l.b.c.e.a.a(x));
    }
    throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */