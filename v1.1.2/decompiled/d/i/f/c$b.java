package d.i.f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c$b
  implements Runnable
{
  public c$b(c paramc, AtomicReference paramAtomicReference, Callable paramCallable, ReentrantLock paramReentrantLock, AtomicBoolean paramAtomicBoolean, Condition paramCondition) {}
  
  public void run()
  {
    try
    {
      x.set(y.call());
      z.lock();
      try
      {
        A.set(false);
        B.signal();
        return;
      }
      finally
      {
        z.unlock();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     d.i.f.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */