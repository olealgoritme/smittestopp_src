package d.m.a;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;

public final class b0
  implements Runnable
{
  public b0(Object paramObject1, j0 paramj0, View paramView, Fragment paramFragment, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Object paramObject2) {}
  
  public void run()
  {
    Object localObject = x;
    if (localObject != null)
    {
      y.b(localObject, z);
      localObject = e0.a(y, x, A, B, z);
      C.addAll((Collection)localObject);
    }
    if (D != null)
    {
      if (E != null)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(z);
        y.a(E, D, (ArrayList)localObject);
      }
      D.clear();
      D.add(z);
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.b0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */