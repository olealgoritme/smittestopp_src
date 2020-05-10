package d.b.a;

import android.view.View;
import android.view.WindowInsets;
import d.i.i.n;
import d.i.i.w;

public class l
  implements d.i.i.k
{
  public l(k paramk) {}
  
  public w a(View paramView, w paramw)
  {
    int i = paramw.d();
    int j = a.f(i);
    w localw = paramw;
    if (i != j)
    {
      i = paramw.b();
      int k = paramw.c();
      int m = paramw.a();
      localw = new w(((WindowInsets)a).replaceSystemWindowInsets(i, j, k, m));
    }
    return n.a(paramView, localw);
  }
}

/* Location:
 * Qualified Name:     d.b.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */