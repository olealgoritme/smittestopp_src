package i.k.b;

import i.m.a;
import java.io.Serializable;

public abstract class b
  implements a, Serializable
{
  public static final Object z = a.x;
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
  
  public static class a
    implements Serializable
  {
    public static final a x = new a();
  }
}

/* Location:
 * Qualified Name:     i.k.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */