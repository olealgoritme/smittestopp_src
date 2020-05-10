package d.c.a.a;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends c
{
  public final Object a = new Object();
  public final ExecutorService b = Executors.newFixedThreadPool(4, new a());
  
  public void a(Runnable paramRunnable)
  {
    b.execute(paramRunnable);
  }
  
  public boolean a()
  {
    boolean bool;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public class a
    implements ThreadFactory
  {
    public final AtomicInteger a = new AtomicInteger(0);
    
    public a() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(a.getAndIncrement()) }));
      return paramRunnable;
    }
  }
}

/* Location:
 * Qualified Name:     d.c.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */