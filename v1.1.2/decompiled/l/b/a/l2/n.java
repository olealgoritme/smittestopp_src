package l.b.a.l2;

import e.a.a.a.a;
import l.b.a.b0;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.h1;
import l.b.a.t;
import l.b.a.u;

public class n
  extends l.b.a.n
{
  public int A = 1;
  public o x;
  public m y;
  public q z;
  
  public n(b0 paramb0)
  {
    int i = x;
    if (i != 0)
    {
      if (i == 1) {
        y = m.a(paramb0, true);
      } else {
        throw new IllegalArgumentException("unknown tag in Holder");
      }
    }
    else {
      x = o.a(paramb0, true);
    }
    A = 0;
  }
  
  public n(u paramu)
  {
    if (paramu.size() <= 3)
    {
      for (int i = 0; i != paramu.size(); i++)
      {
        localObject = b0.a(paramu.a(i));
        int j = x;
        if (j != 0)
        {
          if (j != 1)
          {
            if (j == 2) {
              z = q.a((b0)localObject, false);
            } else {
              throw new IllegalArgumentException("unknown tag in Holder");
            }
          }
          else {
            y = m.a((b0)localObject, false);
          }
        }
        else {
          x = o.a((b0)localObject, false);
        }
      }
      A = 1;
      return;
    }
    Object localObject = a.a("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public t b()
  {
    if (A == 1)
    {
      localObject1 = new f(3);
      Object localObject2 = x;
      if (localObject2 != null) {
        ((f)localObject1).a(new h1(false, 0, (e)localObject2));
      }
      localObject2 = y;
      if (localObject2 != null) {
        ((f)localObject1).a(new h1(false, 1, (e)localObject2));
      }
      localObject2 = z;
      if (localObject2 != null) {
        ((f)localObject1).a(new h1(false, 2, (e)localObject2));
      }
      return new e1((f)localObject1);
    }
    Object localObject1 = y;
    if (localObject1 != null) {
      return new h1(true, 1, (e)localObject1);
    }
    return new h1(true, 0, x);
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */