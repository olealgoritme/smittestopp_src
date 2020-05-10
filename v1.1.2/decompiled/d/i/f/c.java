package d.i.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c
{
  public final Object a = new Object();
  public HandlerThread b;
  public Handler c;
  public int d;
  public Handler.Callback e = new a();
  public final int f;
  public final int g;
  public final String h;
  
  public c(String paramString, int paramInt1, int paramInt2)
  {
    h = paramString;
    g = paramInt1;
    f = paramInt2;
    d = 0;
  }
  
  public <T> T a(final Callable<T> paramCallable, int paramInt)
  {
    localReentrantLock = new ReentrantLock();
    final Condition localCondition = localReentrantLock.newCondition();
    final AtomicReference localAtomicReference = new AtomicReference();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    b(new b(localAtomicReference, paramCallable, localReentrantLock, localAtomicBoolean, localCondition));
    localReentrantLock.lock();
    label102:
    do
    {
      try
      {
        if (!localAtomicBoolean.get())
        {
          paramCallable = localAtomicReference.get();
          return paramCallable;
        }
        l1 = TimeUnit.MILLISECONDS.toNanos(paramInt);
      }
      finally
      {
        long l1;
        long l2;
        localReentrantLock.unlock();
      }
      try
      {
        l2 = localCondition.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException paramCallable)
      {
        break label102;
      }
      if (!localAtomicBoolean.get())
      {
        paramCallable = localAtomicReference.get();
        localReentrantLock.unlock();
        return paramCallable;
      }
    } while (l1 > 0L);
    paramCallable = new java/lang/InterruptedException;
    paramCallable.<init>("timeout");
    throw paramCallable;
  }
  
  public void a()
  {
    synchronized (a)
    {
      if (c.hasMessages(1)) {
        return;
      }
      b.quit();
      b = null;
      c = null;
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    paramRunnable.run();
    synchronized (a)
    {
      c.removeMessages(0);
      c.sendMessageDelayed(c.obtainMessage(0), f);
      return;
    }
  }
  
  public final void b(Runnable paramRunnable)
  {
    synchronized (a)
    {
      if (b == null)
      {
        Object localObject2 = new android/os/HandlerThread;
        ((HandlerThread)localObject2).<init>(h, g);
        b = ((HandlerThread)localObject2);
        ((HandlerThread)localObject2).start();
        localObject2 = new android/os/Handler;
        ((Handler)localObject2).<init>(b.getLooper(), e);
        c = ((Handler)localObject2);
        d += 1;
      }
      c.removeMessages(0);
      c.sendMessage(c.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  public class a
    implements Handler.Callback
  {
    public a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = what;
      if (i != 0)
      {
        if (i != 1) {
          return true;
        }
        a((Runnable)obj);
        return true;
      }
      a();
      return true;
    }
  }
  
  public class b
    implements Runnable
  {
    public b(AtomicReference paramAtomicReference, Callable paramCallable, ReentrantLock paramReentrantLock, AtomicBoolean paramAtomicBoolean, Condition paramCondition) {}
    
    public void run()
    {
      try
      {
        localAtomicReference.set(paramCallable.call());
        localReentrantLock.lock();
        try
        {
          localAtomicBoolean.set(false);
          localCondition.signal();
          return;
        }
        finally
        {
          localReentrantLock.unlock();
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract void a(T paramT);
  }
}

/* Location:
 * Qualified Name:     d.i.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */