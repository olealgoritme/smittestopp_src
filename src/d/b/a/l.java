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
      int k = paramw.b();
      i = paramw.c();
      int m = paramw.a();
      localw = new w(((WindowInsets)a).replaceSystemWindowInsets(k, j, i, m));
    }
    return n.a(paramView, localw);
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */