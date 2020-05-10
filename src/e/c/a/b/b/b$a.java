package e.c.a.b.b;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import d.i.i.n;

public class b$a
  implements Runnable
{
  public final CoordinatorLayout x;
  public final V y;
  
  public b$a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    x = paramV;
    View localView;
    y = localView;
  }
  
  public void run()
  {
    if (y != null)
    {
      Object localObject1 = z.e;
      if (localObject1 != null) {
        if (((OverScroller)localObject1).computeScrollOffset())
        {
          localObject1 = z;
          ((b)localObject1).c(x, y, e.getCurrY());
          n.a(y, this);
        }
        else
        {
          Object localObject2 = z;
          CoordinatorLayout localCoordinatorLayout = x;
          localObject1 = y;
          localObject2 = (AppBarLayout.BaseBehavior)localObject2;
          if (localObject2 != null) {
            ((AppBarLayout.BaseBehavior)localObject2).a(localCoordinatorLayout, (AppBarLayout)localObject1);
          } else {
            throw null;
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */