package k.b.a.l2;

import k.b.a.b0;
import k.b.a.e1;
import k.b.a.f;
import k.b.a.l;
import k.b.a.r0;
import k.b.a.t;
import k.b.a.u;

public class e
  extends k.b.a.n
{
  public a A;
  public l B;
  public c C;
  public u D;
  public r0 E;
  public k F;
  public l x;
  public n y;
  public b z;
  
  public e(u paramu)
  {
    if ((paramu.size() >= 6) && (paramu.size() <= 9))
    {
      int i;
      if ((paramu.a(0) instanceof l))
      {
        x = l.a(paramu.a(0));
        i = 1;
      }
      else
      {
        x = new l(0L);
        i = 0;
      }
      localObject1 = paramu.a(i);
      boolean bool = localObject1 instanceof n;
      Object localObject2 = null;
      if (bool)
      {
        localObject1 = (n)localObject1;
      }
      else
      {
        if ((localObject1 instanceof b0)) {
          localObject1 = new n(b0.a(localObject1));
        }
        for (;;)
        {
          break;
          if (localObject1 != null) {
            localObject1 = new n(u.a(localObject1));
          } else {
            localObject1 = null;
          }
        }
      }
      y = ((n)localObject1);
      localObject1 = paramu.a(i + 1);
      if ((localObject1 != null) && (!(localObject1 instanceof b)))
      {
        if ((localObject1 instanceof w))
        {
          localObject1 = new b(w.a(localObject1));
        }
        else if ((localObject1 instanceof m))
        {
          localObject1 = new b((m)localObject1);
        }
        else if ((localObject1 instanceof b0))
        {
          localObject1 = new b(w.a(u.a((b0)localObject1, false)));
        }
        else if ((localObject1 instanceof u))
        {
          localObject1 = new b(m.a(localObject1));
        }
        else
        {
          paramu = e.a.a.a.a.a("unknown object in factory: ");
          paramu.append(localObject1.getClass().getName());
          throw new IllegalArgumentException(paramu.toString());
        }
      }
      else {
        localObject1 = (b)localObject1;
      }
      z = ((b)localObject1);
      A = a.a(paramu.a(i + 2));
      B = l.a(paramu.a(i + 3));
      k.b.a.e locale = paramu.a(i + 4);
      if ((locale instanceof c))
      {
        localObject1 = (c)locale;
      }
      else
      {
        localObject1 = localObject2;
        if (locale != null) {
          localObject1 = new c(u.a(locale));
        }
      }
      C = ((c)localObject1);
      D = u.a(paramu.a(i + 5));
      i += 6;
      while (i < paramu.size())
      {
        localObject1 = paramu.a(i);
        if ((localObject1 instanceof r0)) {
          E = r0.a(paramu.a(i));
        } else if (((localObject1 instanceof u)) || ((localObject1 instanceof k))) {
          F = k.a(paramu.a(i));
        }
        i++;
      }
      return;
    }
    Object localObject1 = e.a.a.a.a.a("Bad sequence size: ");
    ((StringBuilder)localObject1).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public t c()
  {
    f localf = new f(9);
    if (x.k() != 0) {
      localf.a(x);
    }
    localf.a(y);
    localf.a(z);
    localf.a(A);
    localf.a(B);
    localf.a(C);
    localf.a(D);
    Object localObject = E;
    if (localObject != null) {
      localf.a((k.b.a.e)localObject);
    }
    localObject = F;
    if (localObject != null) {
      localf.a((k.b.a.e)localObject);
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */