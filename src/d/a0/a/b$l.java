package d.a0.a;

import android.view.View;
import java.util.Comparator;

public class b$l
  implements Comparator<View>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (View)paramObject1;
    paramObject2 = (View)paramObject2;
    paramObject1 = (b.g)((View)paramObject1).getLayoutParams();
    paramObject2 = (b.g)((View)paramObject2).getLayoutParams();
    boolean bool = a;
    int i;
    if (bool != a)
    {
      if (bool) {
        i = 1;
      } else {
        i = -1;
      }
    }
    else {
      i = e - e;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */