package i;

import i.k.a.a;
import i.k.b.g;
import java.io.Serializable;

public final class d<T>
  implements b<T>, Serializable
{
  public a<? extends T> x;
  public volatile Object y;
  public final Object z;
  
  public T getValue()
  {
    Object localObject1 = y;
    if (localObject1 != f.a) {
      return (T)localObject1;
    }
    synchronized (z)
    {
      localObject1 = y;
      if (localObject1 == f.a)
      {
        localObject1 = x;
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).invoke();
          y = localObject1;
          x = null;
        }
      }
      else
      {
        return (T)localObject1;
      }
      g.a();
      throw null;
    }
  }
  
  public String toString()
  {
    int i;
    if (y != f.a) {
      i = 1;
    } else {
      i = 0;
    }
    String str;
    if (i != 0) {
      str = String.valueOf(getValue());
    } else {
      str = "Lazy value not initialized yet.";
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     i.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */