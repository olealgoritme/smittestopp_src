package d.c.a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b$a
  implements ThreadFactory
{
  public final AtomicInteger a = new AtomicInteger(0);
  
  public b$a(b paramb) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(a.getAndIncrement()) }));
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     base.d.c.a.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */