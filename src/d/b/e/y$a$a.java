package d.b.e;

import android.graphics.Typeface;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class y$a$a
  implements Runnable
{
  public final WeakReference<y> x;
  public final Typeface y;
  
  public y$a$a(WeakReference<y> paramWeakReference, Typeface paramTypeface)
  {
    x = paramTypeface;
    Typeface localTypeface;
    y = localTypeface;
  }
  
  public void run()
  {
    y localy = (y)x.get();
    if (localy == null) {
      return;
    }
    Typeface localTypeface = y;
    if (m)
    {
      a.setTypeface(localTypeface);
      l = localTypeface;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.y.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */