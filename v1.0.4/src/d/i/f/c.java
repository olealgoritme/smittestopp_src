package d.i.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
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
  public Handler.Callback e = new c.a(this);
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
  
  public <T> T a(Callable<T> paramCallable, int paramInt)
  {
    localReentrantLock = new ReentrantLock();
    Condition localCondition = localReentrantLock.newCondition();
    AtomicReference localAtomicReference = new AtomicReference();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    b(new c.b(this, localAtomicReference, paramCallable, localReentrantLock, localAtomicBoolean, localCondition));
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
  
  public void a(Runnable arg1)
  {
    ???.run();
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
}

/* Location:
 * Qualified Name:     base.d.i.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */