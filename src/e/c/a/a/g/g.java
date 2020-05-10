package e.c.a.a.g;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class g<TResult>
{
  public final Object a = new Object();
  @GuardedBy("mLock")
  public Queue<f<TResult>> b;
  @GuardedBy("mLock")
  public boolean c;
  
  public final void a(f<TResult> paramf)
  {
    synchronized (a)
    {
      if (b == null)
      {
        ArrayDeque localArrayDeque = new java/util/ArrayDeque;
        localArrayDeque.<init>();
        b = localArrayDeque;
      }
      b.add(paramf);
      return;
    }
  }
  
  public final void a(h<TResult> paramh)
  {
    synchronized (a)
    {
      if ((b != null) && (!c))
      {
        c = true;
        synchronized (a)
        {
          f localf = (f)b.poll();
          if (localf == null)
          {
            c = false;
            return;
          }
          localf.a(paramh);
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.g.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */