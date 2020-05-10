package d.b.a;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContainer;
import d.b.d.a.a;
import d.i.i.n;
import d.i.i.u;

public class w$a
  extends u
{
  public w$a(w paramw) {}
  
  public void b(View paramView)
  {
    paramView = a;
    if (p)
    {
      paramView = g;
      if (paramView != null)
      {
        paramView.setTranslationY(0.0F);
        a.d.setTranslationY(0.0F);
      }
    }
    a.d.setVisibility(8);
    a.d.setTransitioning(false);
    paramView = a;
    u = null;
    a.a locala = k;
    if (locala != null)
    {
      locala.a(j);
      j = null;
      k = null;
    }
    paramView = a.c;
    if (paramView != null) {
      n.y(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */