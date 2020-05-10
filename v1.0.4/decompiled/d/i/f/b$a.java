package d.i.f;

import android.content.Context;
import android.graphics.Typeface;
import d.f.f;
import java.util.concurrent.Callable;

public final class b$a
  implements Callable<b.g>
{
  public b$a(Context paramContext, a parama, int paramInt, String paramString) {}
  
  public Object call()
  {
    b.g localg = b.a(a, b, c);
    Typeface localTypeface = a;
    if (localTypeface != null) {
      b.a.a(d, localTypeface);
    }
    return localg;
  }
}

/* Location:
 * Qualified Name:     base.d.i.f.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */