package d.b.d;

import android.view.View;

import d.i.i.u;

public class g$a
  extends u
{
  public boolean a = false;
  public int b = 0;
  
  public g$a(g paramg) {}
  
  public void a(View paramView)
  {
    int i = b + 1;
    b = i;
    if (i == c.a.size())
    {
      paramView = c.d;
      if (paramView != null) {
        paramView.a(null);
      }
      b = 0;
      a = false;
      c.e = false;
    }
  }
  
  public void b(View paramView)
  {
    if (a) {
      return;
    }
    a = true;
    paramView = c.d;
    if (paramView != null) {
      paramView.b(null);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */