package androidx.lifecycle;

import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;

public class LiveData$LifecycleBoundObserver
  extends LiveData<T>.a
  implements j
{
  public final l B;
  
  public void a(l paraml, g.a parama)
  {
    if (B.getLifecycle()).b == g.b.DESTROYED)
    {
      C.a(x);
      return;
    }
    a(B.getLifecycle()).b.isAtLeast(g.b.STARTED));
  }
}

/* Location:
 * Qualified Name:     androidx.lifecycle.LiveData.LifecycleBoundObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */