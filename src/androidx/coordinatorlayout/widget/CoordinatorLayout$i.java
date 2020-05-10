package androidx.coordinatorlayout.widget;

import android.view.View;
import d.i.i.n;
import java.util.Comparator;

public class CoordinatorLayout$i
  implements Comparator<View>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (View)paramObject1;
    paramObject2 = (View)paramObject2;
    float f1 = n.p((View)paramObject1);
    float f2 = ((View)paramObject2).getZ();
    int i;
    if (f1 > f2) {
      i = -1;
    } else if (f1 < f2) {
      i = 1;
    } else {
      i = 0;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.androidx.coordinatorlayout.widget.CoordinatorLayout.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */