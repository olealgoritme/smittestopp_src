package d.b.e;

import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import d.i.i.n;

public class k0$e
  implements Runnable
{
  public k0$e(k0 paramk0) {}
  
  public void run()
  {
    Object localObject = x.z;
    if ((localObject != null) && (n.s((View)localObject)) && (x.z.getCount() > x.z.getChildCount()))
    {
      int i = x.z.getChildCount();
      localObject = x;
      if (i <= L)
      {
        Y.setInputMethodMode(2);
        x.c();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.k0.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */