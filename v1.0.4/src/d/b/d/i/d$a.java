package d.b.d.i;

import android.view.View;

import java.util.Iterator;

public class d$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public d$a(d paramd) {}
  
  public void onGlobalLayout()
  {
    if ((x.a()) && (x.F.size() > 0) && (!x.F.get(0)).a.X))
    {
      Object localObject = x.M;
      if ((localObject != null) && (((View)localObject).isShown())) {
        localObject = x.F.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        nexta.c();
        continue;
        x.dismiss();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */