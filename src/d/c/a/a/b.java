package d.c.a.a;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
  extends c
{
  public final Object a = new Object();
  public final ExecutorService b = Executors.newFixedThreadPool(4, new b.a(this));
  
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
}

/* Location:
 * Qualified Name:     base.d.c.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */