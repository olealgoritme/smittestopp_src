package d.m.a;

import android.view.View;
import d.i.i.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class i0
  implements Runnable
{
  public i0(k0 paramk0, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int i = x.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)x.get(j);
      String str = n.n(localView);
      if (str != null)
      {
        Iterator localIterator = y.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          if (str.equals(((Map.Entry)localObject).getValue()))
          {
            localObject = (String)((Map.Entry)localObject).getKey();
            break label109;
          }
        }
        Object localObject = null;
        label109:
        localView.setTransitionName((String)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.i0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */