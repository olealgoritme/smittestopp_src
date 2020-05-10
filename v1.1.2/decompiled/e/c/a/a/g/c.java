package e.c.a.a.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class c
{
  public static final Executor a = new a();
  
  public static final class a
    implements Executor
  {
    public final Handler a = new Handler(Looper.getMainLooper());
    
    public final void execute(Runnable paramRunnable)
    {
      a.post(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */