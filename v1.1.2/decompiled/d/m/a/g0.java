package d.m.a;

import android.view.View;
import d.i.i.n;
import java.util.ArrayList;

public class g0
  implements Runnable
{
  public g0(j0 paramj0, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    for (int i = 0; i < x; i++)
    {
      n.a((View)y.get(i), (String)z.get(i));
      ((View)A.get(i)).setTransitionName((String)B.get(i));
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.g0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */