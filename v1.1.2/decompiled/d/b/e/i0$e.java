package d.b.e;

import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import d.i.i.n;

public class i0$e
  implements Runnable
{
  public i0$e(i0 parami0) {}
  
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
        x.a();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.i0.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */