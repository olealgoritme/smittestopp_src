package d.i.f;

import android.os.Handler;
import java.util.concurrent.Callable;

public class d
  implements Runnable
{
  public d(c paramc, Callable paramCallable, Handler paramHandler, c.c paramc1) {}
  
  public void run()
  {
    Object localObject2;
    try
    {
      Object localObject1 = x.call();
    }
    catch (Exception localException)
    {
      localObject2 = null;
    }
    y.post(new d.a(this, localObject2));
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */