package e.c.a.b.m;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public class e
{
  public static e c;
  public final Object a = new Object();
  public final Handler b = new Handler(Looper.getMainLooper(), new e.a(this));
  
  public void a(e.b paramb)
  {
    synchronized (a) {}
  }
  
  public void a(e.c paramc)
  {
    Object localObject = a;
    if ((paramc == null) || (paramc == null)) {}
    try
    {
      e.b localb = (e.b)a.get();
      if (localb != null)
      {
        b.removeCallbacksAndMessages(paramc);
        localb.a(2);
      }
      return;
    }
    finally
    {
      for (;;) {}
    }
    throw paramc;
  }
  
  public void b(e.b paramb)
  {
    synchronized (a) {}
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.m.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */