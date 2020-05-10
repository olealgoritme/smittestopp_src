package e.c.a.b.m;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class e
{
  public static e c;
  public final Object a = new Object();
  public final Handler b = new Handler(Looper.getMainLooper(), new a());
  
  public void a(b paramb)
  {
    synchronized (a) {}
  }
  
  public void a(c paramc)
  {
    Object localObject = a;
    if ((paramc == null) || (paramc == null)) {}
    try
    {
      b localb = (b)a.get();
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
  
  public void b(b arg1)
  {
    synchronized (a) {}
  }
  
  public class a
    implements Handler.Callback
  {
    public a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      if (what != 0) {
        return false;
      }
      a((e.c)obj);
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
  
  public static class c
  {
    public final WeakReference<e.b> a;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.m.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */