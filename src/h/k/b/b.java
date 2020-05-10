package h.k.b;

import h.m.a;
import java.io.Serializable;

public abstract class b
  implements a, Serializable
{
  public static final Object z = b.a.x;
  public transient a x;
  public final Object y;
  
  public b()
  {
    y = localObject;
  }
  
  public a a()
  {
    a locala = x;
    Object localObject = locala;
    if (locala == null)
    {
      localObject = (i)this;
      if (l.a != null) {
        x = ((a)localObject);
      } else {
        throw null;
      }
    }
    return (a)localObject;
  }
}

/* Location:
 * Qualified Name:     base.h.k.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */