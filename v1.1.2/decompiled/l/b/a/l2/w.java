package l.b.a.l2;

import e.a.a.a.a;
import l.b.a.b0;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.f;
import l.b.a.h1;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

public class w
  extends n
{
  public m x;
  public o y;
  public q z;
  
  public w(u paramu)
  {
    if (paramu.size() <= 3)
    {
      int i;
      if (!(paramu.a(0) instanceof b0))
      {
        x = m.a(paramu.a(0));
        i = 1;
      }
      else
      {
        i = 0;
      }
      while (i != paramu.size())
      {
        localObject = b0.a(paramu.a(i));
        int j = x;
        if (j == 0)
        {
          y = o.a((b0)localObject, false);
        }
        else
        {
          if (j != 1) {
            break label103;
          }
          z = q.a((b0)localObject, false);
        }
        i++;
        continue;
        label103:
        paramu = a.a("Bad tag number: ");
        paramu.append(x);
        throw new IllegalArgumentException(paramu.toString());
      }
      return;
    }
    Object localObject = a.a("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramu.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static w a(Object paramObject)
  {
    if ((paramObject instanceof w)) {
      return (w)paramObject;
    }
    if (paramObject != null) {
      return new w(u.a(paramObject));
    }
    return null;
  }
  
  public t b()
  {
    f localf = new f(3);
    Object localObject = x;
    if (localObject != null) {
      localf.a((e)localObject);
    }
    localObject = y;
    if (localObject != null) {
      localf.a(new h1(false, 0, (e)localObject));
    }
    localObject = z;
    if (localObject != null) {
      localf.a(new h1(false, 1, (e)localObject));
    }
    return new e1(localf);
  }
}

/* Location:
 * Qualified Name:     l.b.a.l2.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */