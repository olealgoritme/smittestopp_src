package d.b.e;

import android.graphics.Typeface;
import android.widget.TextView;
import d.i.b.b.g;
import java.lang.ref.WeakReference;

public class x$a
  extends g
{
  public x$a(x paramx, WeakReference paramWeakReference) {}
  
  public void a(Typeface paramTypeface)
  {
    x localx = b;
    Object localObject = a;
    if (k)
    {
      j = paramTypeface;
      localObject = (TextView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((TextView)localObject).setTypeface(paramTypeface, i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */