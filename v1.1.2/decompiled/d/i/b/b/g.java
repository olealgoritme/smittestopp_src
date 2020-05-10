package d.i.b.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import d.b.e.x.a;

public abstract class g
{
  public final void a(final int paramInt, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new b(paramInt));
  }
  
  public abstract void a(Typeface paramTypeface);
  
  public final void a(final Typeface paramTypeface, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new a(paramTypeface));
  }
  
  public class a
    implements Runnable
  {
    public a(Typeface paramTypeface) {}
    
    public void run()
    {
      a(paramTypeface);
    }
  }
  
  public class b
    implements Runnable
  {
    public b(int paramInt) {}
    
    public void run()
    {
      if ((x.a)g.this != null) {
        return;
      }
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     d.i.b.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */