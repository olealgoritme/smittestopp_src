package d.b.e;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.widget.TextView;
import d.i.b.b.g;
import java.lang.ref.WeakReference;

public class y$a
  extends g
{
  public final WeakReference<y> a;
  public final int b;
  public final int c;
  
  public y$a(y paramy, int paramInt1, int paramInt2)
  {
    a = new WeakReference(paramy);
    b = paramInt1;
    c = paramInt2;
  }
  
  public void a(Typeface paramTypeface)
  {
    y localy = (y)a.get();
    if (localy == null) {
      return;
    }
    Typeface localTypeface = paramTypeface;
    if (Build.VERSION.SDK_INT >= 28)
    {
      int i = b;
      localTypeface = paramTypeface;
      if (i != -1)
      {
        boolean bool;
        if ((c & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localTypeface = Typeface.create(paramTypeface, i, bool);
      }
    }
    paramTypeface = new y.a.a(this, a, localTypeface);
    a.post(paramTypeface);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.y.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */