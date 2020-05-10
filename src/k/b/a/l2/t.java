package k.b.a.l2;

import k.b.a.b0;
import k.b.a.d0;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.h1;
import k.b.a.j;
import k.b.a.k2.c;
import k.b.a.l;
import k.b.a.n;
import k.b.a.u;

public class t
  extends n
{
  public v A;
  public v B;
  public u C;
  public k D;
  public l x;
  public a y;
  public c z;
  
  public t(u paramu)
  {
    if ((paramu.size() >= 3) && (paramu.size() <= 7))
    {
      int i = 0;
      if ((paramu.a(0) instanceof l))
      {
        x = l.a(paramu.a(0));
        i = 1;
      }
      else
      {
        x = null;
      }
      int j = i + 1;
      y = a.a(paramu.a(i));
      i = j + 1;
      z = c.a(paramu.a(j));
      j = i + 1;
      A = v.a(paramu.a(i));
      i = j;
      if (j < paramu.size()) {
        if ((!(paramu.a(j) instanceof d0)) && (!(paramu.a(j) instanceof j)))
        {
          i = j;
          if (!(paramu.a(j) instanceof v)) {}
        }
        else
        {
          B = v.a(paramu.a(j));
          i = j + 1;
        }
      }
      j = i;
      if (i < paramu.size())
      {
        j = i;
        if (!(paramu.a(i) instanceof b0))
        {
          C = u.a(paramu.a(i));
          j = i + 1;
        }
      }
      if ((j < paramu.size()) && ((paramu.a(j) instanceof b0))) {
        D = k.a(u.a((b0)paramu.a(j), true));
      }
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Bad sequence size: ");
    localStringBuilder.append(paramu.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public k.b.a.t c()
  {
    f localf = new f(7);
    Object localObject = x;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localf.a(y);
    localf.a(z);
    localf.a(A);
    localObject = B;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = C;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = D;
    if (localObject != null) {
      localf.a(new h1(0, (e)localObject));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */