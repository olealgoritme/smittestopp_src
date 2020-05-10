package d.b.a;

import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import d.b.d.h;
import d.b.e.b0;

public class t$e
  extends h
{
  public t$e(t paramt, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return new View(y.a.i());
    }
    return x.onCreatePanelView(paramInt);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = x.onPreparePanel(paramInt, paramView, paramMenu);
    if (bool)
    {
      paramView = y;
      if (!b)
      {
        a.b();
        y.b = true;
      }
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     d.b.a.t.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */