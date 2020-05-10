package d.b.a;

import android.view.Menu;
import android.view.View;

import d.b.d.h;

public class s$e
  extends h
{
  public s$e(s params, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0) {
      return new View(y.a.k());
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
        a.e();
        y.b = true;
      }
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.s.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */