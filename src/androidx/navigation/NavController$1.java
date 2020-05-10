package androidx.navigation;

import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.s.e;
import java.util.Deque;
import java.util.Iterator;

public class NavController$1
  implements j
{
  public NavController$1(NavController paramNavController) {}
  
  public void a(l paraml, g.a parama)
  {
    paraml = x;
    if (d != null)
    {
      Iterator localIterator = h.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale != null)
        {
          int i = parama.ordinal();
          if (i != 0)
          {
            if (i != 1) {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    break label142;
                  }
                  if (i == 5)
                  {
                    paraml = g.b.DESTROYED;
                    break label146;
                  }
                  paraml = new StringBuilder();
                  paraml.append("Unexpected event value ");
                  paraml.append(parama);
                  throw new IllegalArgumentException(paraml.toString());
                }
              }
              else
              {
                paraml = g.b.RESUMED;
                break label146;
              }
            }
            paraml = g.b.STARTED;
            break label146;
          }
          label142:
          paraml = g.b.CREATED;
          label146:
          C = paraml;
          locale.a();
        }
        else
        {
          throw null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.navigation.NavController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */