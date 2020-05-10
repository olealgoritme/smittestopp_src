package androidx.lifecycle;

import d.o.d;
import d.o.g.a;
import d.o.j;
import d.o.l;

public class FullLifecycleObserverAdapter
  implements j
{
  public final d x;
  public final j y;
  
  public FullLifecycleObserverAdapter(d paramd, j paramj)
  {
    x = paramd;
    y = paramj;
  }
  
  public void a(l paraml, g.a parama)
  {
    switch (parama.ordinal())
    {
    default: 
      break;
    case 6: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 5: 
      x.b(paraml);
      break;
    case 4: 
      x.e(paraml);
      break;
    case 3: 
      x.d(paraml);
      break;
    case 2: 
      x.a(paraml);
      break;
    case 1: 
      x.f(paraml);
      break;
    case 0: 
      x.c(paraml);
    }
    j localj = y;
    if (localj != null) {
      localj.a(paraml, parama);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.FullLifecycleObserverAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */