package d.b.d.i;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import d.b.e.i0;

public class s$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public s$a(s params) {}
  
  public void onGlobalLayout()
  {
    if (x.e())
    {
      Object localObject = x;
      if (!F.X)
      {
        localObject = K;
        if ((localObject != null) && (((View)localObject).isShown())) {
          x.F.a();
        } else {
          x.dismiss();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */