package d.y.a.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

public class c$a
  implements Drawable.Callback
{
  public c$a(c paramc) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    x.invalidateSelf();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    x.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    x.unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */