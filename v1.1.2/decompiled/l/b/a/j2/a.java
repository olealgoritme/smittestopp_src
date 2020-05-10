package l.b.a.j2;

import java.util.Enumeration;
import l.b.a.b0;
import l.b.a.e;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;

public class a
  extends n
{
  public u x;
  
  public a(u paramu)
  {
    x = paramu;
  }
  
  public final t a(int paramInt)
  {
    Object localObject1 = x.j();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (e)((Enumeration)localObject1).nextElement();
      if ((localObject2 instanceof b0))
      {
        localObject2 = (b0)localObject2;
        if (x == paramInt)
        {
          localObject1 = ((b0)localObject2).j();
          if (localObject1 != null) {
            return (t)localObject1;
          }
          throw null;
        }
      }
    }
    return null;
  }
  
  public t b()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.b.a.j2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */