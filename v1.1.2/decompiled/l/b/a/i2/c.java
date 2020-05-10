package l.b.a.i2;

import java.util.NoSuchElementException;
import l.b.a.b0;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.h1;
import l.b.a.l;
import l.b.a.l2.s;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;
import l.b.a.x;

public class c
  extends n
{
  public x A = null;
  public l x = new l(0L);
  public l.b.a.k2.c y;
  public s z;
  
  public c(u paramu)
  {
    x = ((l)paramu.a(0));
    y = l.b.a.k2.c.a(paramu.a(1));
    z = s.a(paramu.a(2));
    if (paramu.size() > 3) {
      A = x.a((b0)paramu.a(3), false);
    }
    Object localObject = A;
    if (localObject != null)
    {
      for (int i = 0;; i++)
      {
        int j;
        if (i < x.length) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0) {
          break label258;
        }
        paramu = x;
        if (i >= paramu.length) {
          break;
        }
        paramu = paramu[i];
        if ((paramu != null) && (!(paramu instanceof a)))
        {
          if ((paramu instanceof u))
          {
            paramu = new a((u)paramu);
          }
          else
          {
            localObject = e.a.a.a.a.a("unknown object in factory: ");
            ((StringBuilder)localObject).append(paramu.getClass().getName());
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else {
          paramu = (a)paramu;
        }
        if ((x.b(e.j)) && (y.x.length != 1)) {
          throw new IllegalArgumentException("challengePassword attribute must have one value");
        }
      }
      throw new NoSuchElementException("ASN1Set Enumeration");
    }
    label258:
    if ((y != null) && (x != null) && (z != null)) {
      return;
    }
    throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
  }
  
  public t b()
  {
    f localf = new f(4);
    localf.a(x);
    localf.a(y);
    localf.a(z);
    x localx = A;
    if (localx != null) {
      localf.a(new h1(false, 0, localx));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.i2.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */