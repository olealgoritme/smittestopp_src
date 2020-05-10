package androidx.activity;

import android.annotation.SuppressLint;
import d.a.b;
import d.o.g.b;
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
    Object localObject = b.descendingIterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (a)
      {
        localb.a();
        return;
      }
    }
    localObject = a;
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
    paraml = new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(this, paraml, paramb);
    b.add(paraml);
  }
}

/* Location:
 * Qualified Name:     base.androidx.activity.OnBackPressedDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */