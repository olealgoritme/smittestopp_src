package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import d.i.i.k;
import d.i.i.n;
import d.i.i.w;
import java.util.Objects;

public class CoordinatorLayout$a
  implements k
{
  public CoordinatorLayout$a(CoordinatorLayout paramCoordinatorLayout) {}
  
  public w a(View paramView, w paramw)
  {
    CoordinatorLayout localCoordinatorLayout = a;
    if (!Objects.equals(J, paramw))
    {
      J = paramw;
      int i = 0;
      boolean bool1 = true;
      boolean bool2;
      if ((paramw != null) && (paramw.d() > 0)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      K = bool2;
      if ((!bool2) && (localCoordinatorLayout.getBackground() == null)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      localCoordinatorLayout.setWillNotDraw(bool2);
      if (!((WindowInsets)a).isConsumed())
      {
        int j = localCoordinatorLayout.getChildCount();
        while (i < j)
        {
          paramView = localCoordinatorLayout.getChildAt(i);
          if ((n.g(paramView)) && (getLayoutParamsa != null) && (((WindowInsets)a).isConsumed())) {
            break;
          }
          i++;
        }
      }
      localCoordinatorLayout.requestLayout();
    }
    return paramw;
  }
}

/* Location:
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */