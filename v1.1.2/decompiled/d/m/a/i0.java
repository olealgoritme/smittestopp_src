package d.m.a;

import android.view.View;
import d.i.i.n;
import java.util.ArrayList;
import java.util.Map;

public class i0
  implements Runnable
{
  public i0(j0 paramj0, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int i = x.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)x.get(j);
      String str = n.n(localView);
      localView.setTransitionName((String)y.get(str));
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.i0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */