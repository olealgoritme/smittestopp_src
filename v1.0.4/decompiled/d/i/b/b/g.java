package d.i.b.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class g
{
  public final void a(int paramInt, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new g.b(this, paramInt));
  }
  
  public abstract void a(Typeface paramTypeface);
  
  public final void a(Typeface paramTypeface, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new g.a(this, paramTypeface));
  }
}

/* Location:
 * Qualified Name:     base.d.i.b.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */