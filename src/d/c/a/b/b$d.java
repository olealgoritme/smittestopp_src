package d.c.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

public class b$d
  implements Iterator<Map.Entry<K, V>>, b.f<K, V>
{
  public b.c<K, V> x;
  public boolean y = true;
  
  public b$d(b paramb) {}
  
  public void a(b.c<K, V> paramc)
  {
    b.c localc = x;
    if (paramc == localc)
    {
      paramc = A;
      x = paramc;
      boolean bool;
      if (paramc == null) {
        bool = true;
      } else {
        bool = false;
      }
      y = bool;
    }
  }
  
  public boolean hasNext()
  {
    boolean bool1 = y;
    boolean bool2 = true;
    boolean bool3 = true;
    if (bool1)
    {
      if (z.x == null) {
        bool3 = false;
      }
      return bool3;
    }
    b.c localc = x;
    if ((localc != null) && (z != null)) {
      bool3 = bool2;
    } else {
      bool3 = false;
    }
    return bool3;
  }
  
  public Object next()
  {
    if (y)
    {
      y = false;
      x = z.x;
    }
    else
    {
      b.c localc = x;
      if (localc != null) {
        localc = z;
      } else {
        localc = null;
      }
      x = localc;
    }
    return x;
  }
}

/* Location:
 * Qualified Name:     base.d.c.a.b.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */