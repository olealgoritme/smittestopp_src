package d.c.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract class b$e<K, V>
  implements Iterator<Map.Entry<K, V>>, b.f<K, V>
{
  public b.c<K, V> x;
  public b.c<K, V> y;
  
  public b$e(b.c<K, V> paramc1, b.c<K, V> paramc2)
  {
    x = paramc2;
    y = paramc1;
  }
  
  public void a(b.c<K, V> paramc)
  {
    b.c localc1 = x;
    Object localObject = null;
    if ((localc1 == paramc) && (paramc == y))
    {
      y = null;
      x = null;
    }
    localc1 = x;
    if (localc1 == paramc) {
      x = b(localc1);
    }
    localc1 = y;
    if (localc1 == paramc)
    {
      b.c localc2 = x;
      paramc = (b.c<K, V>)localObject;
      if (localc1 != localc2) {
        if (localc2 == null) {
          paramc = (b.c<K, V>)localObject;
        } else {
          paramc = c(localc1);
        }
      }
      y = paramc;
    }
  }
  
  public abstract b.c<K, V> b(b.c<K, V> paramc);
  
  public abstract b.c<K, V> c(b.c<K, V> paramc);
  
  public boolean hasNext()
  {
    boolean bool;
    if (y != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object next()
  {
    b.c localc1 = y;
    b.c localc2 = x;
    if ((localc1 != localc2) && (localc2 != null)) {
      localc2 = c(localc1);
    } else {
      localc2 = null;
    }
    y = localc2;
    return localc1;
  }
}

/* Location:
 * Qualified Name:     base.d.c.a.b.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */