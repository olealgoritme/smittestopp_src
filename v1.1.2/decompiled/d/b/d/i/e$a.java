package d.b.d.i;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import d.b.e.i0;
import java.util.Iterator;
import java.util.List;

public class e$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public e$a(e parame) {}
  
  public void onGlobalLayout()
  {
    if ((x.e()) && (x.F.size() > 0) && (!x.F.get(0)).a.X))
    {
      Object localObject = x.M;
      if ((localObject != null) && (((View)localObject).isShown())) {
        localObject = x.F.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        nexta.a();
        continue;
        x.dismiss();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */