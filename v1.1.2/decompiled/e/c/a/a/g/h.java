package e.c.a.a.g;

import d.b.a.s;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.GuardedBy;

public final class h<TResult>
  extends h<TResult>
{
  public final Object a = new Object();
  public final g<TResult> b = new g();
  @GuardedBy("mLock")
  public boolean c;
  public volatile boolean d;
  @GuardedBy("mLock")
  public TResult e;
  @GuardedBy("mLock")
  public Exception f;
  
  public final TResult a()
  {
    synchronized (a)
    {
      s.a(c, "Task is not yet complete");
      if (!d)
      {
        if (f == null)
        {
          localObject2 = e;
          return (TResult)localObject2;
        }
        localObject2 = new e/c/a/a/g/a;
        ((a)localObject2).<init>(f);
        throw ((Throwable)localObject2);
      }
      Object localObject2 = new java/util/concurrent/CancellationException;
      ((CancellationException)localObject2).<init>("Task is already canceled.");
      throw ((Throwable)localObject2);
      throw ((Throwable)localObject2);
    }
  }
  
  public final void a(Exception paramException)
  {
    s.b(paramException, "Exception must not be null");
    synchronized (a)
    {
      s.a(c ^ true, "Task is already complete");
      c = true;
      f = paramException;
      b.a(this);
      return;
    }
  }
  
  public final void a(TResult paramTResult)
  {
    synchronized (a)
    {
      s.a(c ^ true, "Task is already complete");
      c = true;
      e = paramTResult;
      b.a(this);
      return;
    }
  }
  
  public final boolean b()
  {
    synchronized (a)
    {
      if (c) {
        return false;
      }
      c = true;
      d = true;
      b.a(this);
      return true;
    }
  }
  
  public final boolean b(Exception paramException)
  {
    s.b(paramException, "Exception must not be null");
    synchronized (a)
    {
      if (c) {
        return false;
      }
      c = true;
      f = paramException;
      b.a(this);
      return true;
    }
  }
  
  public final boolean b(TResult paramTResult)
  {
    synchronized (a)
    {
      if (c) {
        return false;
      }
      c = true;
      e = paramTResult;
      b.a(this);
      return true;
    }
  }
  
  public final void c()
  {
    synchronized (a)
    {
      if (!c) {
        return;
      }
      b.a(this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.g.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */