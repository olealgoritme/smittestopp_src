package d.b.e;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import d.b.d.i.a;

public class y0
  implements View.OnClickListener
{
  public final a x = new a(y.a.getContext(), 0, 16908332, 0, 0, y.i);
  
  public y0(z0 paramz0) {}
  
  public void onClick(View paramView)
  {
    paramView = y;
    Window.Callback localCallback = l;
    if ((localCallback != null) && (m)) {
      localCallback.onMenuItemSelected(0, x);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.y0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */