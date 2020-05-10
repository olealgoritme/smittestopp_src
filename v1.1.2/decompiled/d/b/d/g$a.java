package d.b.d;

import android.view.View;
import d.i.i.t;
import d.i.i.u;
import java.util.ArrayList;

public class g$a
  extends u
{
  public boolean a = false;
  public int b = 0;
  
  public g$a(g paramg) {}
  
  public void b(View paramView)
  {
    int i = b + 1;
    b = i;
    if (i == c.a.size())
    {
      paramView = c.d;
      if (paramView != null) {
        paramView.b(null);
      }
      b = 0;
      a = false;
      c.e = false;
    }
  }
  
  public void c(View paramView)
  {
    if (a) {
      return;
    }
    a = true;
    paramView = c.d;
    if (paramView != null) {
      paramView.c(null);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */