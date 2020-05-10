package e.c.a.a.b.k;

import java.util.Collections;
import java.util.List;

public class a
{
  public static final Object a = new Object();
  public static volatile a b;
  
  public a()
  {
    List localList = Collections.EMPTY_LIST;
  }
  
  public static a a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null)
        {
          a locala = new e/c/a/a/b/k/a;
          locala.<init>();
          b = locala;
        }
      }
    }
    return b;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */