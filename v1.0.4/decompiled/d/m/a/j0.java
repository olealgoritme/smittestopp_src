package d.m.a;

import android.view.View;
import d.i.i.n;
import java.util.ArrayList;
import java.util.Map;

public class j0
  implements Runnable
{
  public j0(k0 paramk0, ArrayList paramArrayList, Map paramMap) {}
  
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
 * Qualified Name:     base.d.m.a.j0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */