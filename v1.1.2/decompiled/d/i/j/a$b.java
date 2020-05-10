package d.i.j;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import d.i.i.n;

public class a$b
  implements Runnable
{
  public a$b(a parama) {}
  
  public void run()
  {
    Object localObject = x;
    if (!L) {
      return;
    }
    long l1;
    if (J)
    {
      J = false;
      localObject = x;
      if (localObject != null)
      {
        l1 = AnimationUtils.currentAnimationTimeMillis();
        e = l1;
        i = -1L;
        f = l1;
        j = 0.5F;
        g = 0;
        h = 0;
      }
      else
      {
        throw null;
      }
    }
    a.a locala = x.x;
    int i;
    if ((i > 0L) && (AnimationUtils.currentAnimationTimeMillis() > i + k)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (x.b()))
    {
      localObject = x;
      if (K)
      {
        K = false;
        if (localObject != null)
        {
          l1 = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
          z.onTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
        }
        else
        {
          throw null;
        }
      }
      if (f != 0L)
      {
        l1 = AnimationUtils.currentAnimationTimeMillis();
        float f = locala.a(l1);
        long l2 = f;
        f = l1;
        f = (float)(l1 - l2) * (f * 4.0F + -4.0F * f * f);
        g = ((int)(c * f));
        i = (int)(f * d);
        h = i;
        x).O.scrollListBy(i);
        n.a(x.z, this);
        return;
      }
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    x.L = false;
  }
}

/* Location:
 * Qualified Name:     d.i.j.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */