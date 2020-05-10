package e.c.a.b.e;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import d.i.i.a;
import d.i.i.x.d;

public class b$b
  extends a
{
  public b$b(b paramb) {}
  
  public void a(View paramView, d paramd)
  {
    a.onInitializeAccessibilityNodeInfo(paramView, a);
    if (d.A)
    {
      a.addAction(1048576);
      a.setDismissable(true);
    }
    else
    {
      a.setDismissable(false);
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1048576)
    {
      b localb = d;
      if (A)
      {
        localb.cancel();
        return true;
      }
    }
    return super.a(paramView, paramInt, paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.e.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */