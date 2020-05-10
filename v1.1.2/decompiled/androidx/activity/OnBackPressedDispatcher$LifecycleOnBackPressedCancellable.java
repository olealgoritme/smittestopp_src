package androidx.activity;

import d.a.b;
import d.o.g;
import d.o.g.a;
import d.o.j;
import d.o.l;
import d.o.m;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable
  implements j, d.a.a
{
  public final g x;
  public final b y;
  public d.a.a z;
  
  public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(OnBackPressedDispatcher paramOnBackPressedDispatcher, g paramg, b paramb)
  {
    x = paramg;
    y = paramb;
    paramg.a(this);
  }
  
  public void a(l paraml, g.a parama)
  {
    if (parama == g.a.ON_START)
    {
      parama = A;
      paraml = y;
      b.add(paraml);
      parama = new OnBackPressedDispatcher.a(parama, paraml);
      b.add(parama);
      z = parama;
    }
    else if (parama == g.a.ON_STOP)
    {
      paraml = z;
      if (paraml != null) {
        paraml.cancel();
      }
    }
    else if (parama == g.a.ON_DESTROY)
    {
      cancel();
    }
  }
  
  public void cancel()
  {
    x).a.remove(this);
    y.b.remove(this);
    d.a.a locala = z;
    if (locala != null)
    {
      locala.cancel();
      z = null;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */