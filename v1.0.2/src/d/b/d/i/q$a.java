package d.b.d.i;

import android.view.View;

public class q$a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public q$a(q paramq) {}
  
  public void onGlobalLayout()
  {
    if (x.a())
    {
      Object localObject = x;
      if (!F.X)
      {
        localObject = K;
        if ((localObject != null) && (((View)localObject).isShown())) {
          x.F.c();
        } else {
          x.dismiss();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.q.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */