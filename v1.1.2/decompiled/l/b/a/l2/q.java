package l.b.a.l2;

import l.b.a.b0;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.g;
import l.b.a.n;
import l.b.a.o;
import l.b.a.r0;
import l.b.a.t;
import l.b.a.u;

public class q
  extends n
{
  public r0 A;
  public g x;
  public o y;
  public a z;
  
  public q(u paramu)
  {
    if ((paramu.size() <= 4) && (paramu.size() >= 3))
    {
      int i = 0;
      localObject = paramu.a(0);
      if ((localObject != null) && (!(localObject instanceof g)))
      {
        if ((localObject instanceof byte[]))
        {
          try
          {
            localObject = (g)t.a((byte[])localObject);
          }
          catch (Exception paramu)
          {
            throw new IllegalArgumentException(e.a.a.a.a.a(paramu, e.a.a.a.a.a("encoding error in getInstance: ")));
          }
        }
        else
        {
          paramu = e.a.a.a.a.a("illegal object in getInstance: ");
          paramu.append(localObject.getClass().getName());
          throw new IllegalArgumentException(paramu.toString());
        }
      }
      else {
        localObject = (g)localObject;
      }
      x = ((g)localObject);
      if (paramu.size() == 4)
      {
        y = o.a(paramu.a(1));
        i = 1;
      }
      z = a.a(paramu.a(i + 1));
      A = r0.a(paramu.a(i + 2));
      return;
    }
    Object localObject = e.a.a.a.a.a("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static q a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = u.a(paramb0, paramBoolean);
    if ((paramb0 instanceof q)) {
      paramb0 = (q)paramb0;
    } else if (paramb0 != null) {
      paramb0 = new q(u.a(paramb0));
    } else {
      paramb0 = null;
    }
    return paramb0;
  }
  
  public t b()
  {
    f localf = new f(4);
    localf.a(x);
    o localo = y;
    if (localo != null) {
      localf.a(localo);
    }
    localf.a(z);
    localf.a(A);
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */