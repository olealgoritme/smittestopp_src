package androidx.activity;

import android.annotation.SuppressLint;
import d.a.b;
import d.o.g;
import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class OnBackPressedDispatcher
{
  public final Runnable a;
  public final ArrayDeque<b> b = new ArrayDeque();
  
  public OnBackPressedDispatcher(Runnable paramRunnable)
  {
    a = paramRunnable;
  }
  
  public void a()
  {
    Iterator localIterator = b.descendingIterator();
    while (localIterator.hasNext())
    {
      localObject = (b)localIterator.next();
      if (a)
      {
        ((b)localObject).a();
        return;
      }
    }
    Object localObject = a;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
  
  @SuppressLint({"LambdaLast"})
  public void a(l paraml, b paramb)
  {
    paraml = paraml.getLifecycle();
    if (b == g.b.DESTROYED) {
      return;
    }
    paraml = new LifecycleOnBackPressedCancellable(paraml, paramb);
    b.add(paraml);
  }
  
  public class LifecycleOnBackPressedCancellable
    implements j, d.a.a
  {
    public final g x;
    public final b y;
    public d.a.a z;
    
    public LifecycleOnBackPressedCancellable(g paramg, b paramb)
    {
      x = paramg;
      y = paramb;
      paramg.a(this);
    }
    
    public void a(l paraml, g.a parama)
    {
      if (parama == g.a.ON_START)
      {
        parama = OnBackPressedDispatcher.this;
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
  
  public class a
    implements d.a.a
  {
    public final b x;
    
    public a(b paramb)
    {
      x = paramb;
    }
    
    public void cancel()
    {
      b.remove(x);
      x.b.remove(this);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.activity.OnBackPressedDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */