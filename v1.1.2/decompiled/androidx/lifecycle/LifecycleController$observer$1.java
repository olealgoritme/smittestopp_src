package androidx.lifecycle;

import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;
import i.k.b.g;

public final class LifecycleController$observer$1
  implements j
{
  public final void a(l paraml, g.a parama)
  {
    if (paraml != null)
    {
      if (parama != null)
      {
        parama = paraml.getLifecycle();
        g.a(parama, "source.lifecycle");
        if (b == g.b.DESTROYED) {
          throw null;
        }
        paraml = paraml.getLifecycle();
        g.a(paraml, "source.lifecycle");
        paraml = (m)paraml;
        throw null;
      }
      g.a("<anonymous parameter 1>");
      throw null;
    }
    g.a("source");
    throw null;
  }
}

/* Location:
 * Qualified Name:     androidx.lifecycle.LifecycleController.observer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */