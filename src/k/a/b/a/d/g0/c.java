package k.a.b.a.d.g0;

import java.util.Map;
import k.a.b.a.d.b;
import k.a.b.a.d.i;

public class c
  implements b
{
  public g a;
  public g b;
  public g c;
  
  public g a(i parami, Object paramObject)
  {
    if (parami != null)
    {
      if (parami.isValid())
      {
        g localg = b;
        if ((localg != null) && (x == parami) && (y == paramObject)) {
          return null;
        }
        localg = c;
        if (localg == null)
        {
          localg = new g();
        }
        else
        {
          c = z;
          z = null;
        }
        x = parami;
        y = paramObject;
        A.a.clear();
        if (a == null)
        {
          a = localg;
          b = localg;
        }
        else
        {
          b.z = localg;
          b = localg;
        }
        return localg;
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Cannot put events of type ");
      ((StringBuilder)paramObject).append(parami);
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    throw new IllegalArgumentException("Type cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */