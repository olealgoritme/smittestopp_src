package k.b.a.j2;

import java.util.Enumeration;
import k.b.a.b0;
import k.b.a.e;
import k.b.a.n;
import k.b.a.t;
import k.b.a.u;

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
  
  public t c()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.j2.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */