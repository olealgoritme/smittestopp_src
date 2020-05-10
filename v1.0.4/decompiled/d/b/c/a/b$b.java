package d.b.c.a;

import android.graphics.drawable.Drawable;

public class b$b
  implements Drawable.Callback
{
  public Drawable.Callback x;
  
  public void invalidateDrawable(Drawable paramDrawable) {}
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    Drawable.Callback localCallback = x;
    if (localCallback != null) {
      localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    Drawable.Callback localCallback = x;
    if (localCallback != null) {
      localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */