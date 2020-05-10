package l.a;

import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static final a.b[] a = new a.b[0];
  public static final List<a.b> b = new ArrayList();
  public static volatile a.b[] c = a;
  public static final a.b d = new a.a();
  
  public static void a(a.b paramb)
  {
    if (paramb != null)
    {
      if (paramb != d) {
        synchronized (b)
        {
          b.add(paramb);
          c = (a.b[])b.toArray(new a.b[b.size()]);
          return;
        }
      }
      throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }
    throw new NullPointerException("tree == null");
  }
}

/* Location:
 * Qualified Name:     base.l.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */