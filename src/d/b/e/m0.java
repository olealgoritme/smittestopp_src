package d.b.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import d.b.d.i.g;
import java.lang.reflect.Method;

public class m0
  extends k0
  implements l0
{
  public static Method d0;
  public l0 c0;
  
  static
  {
    try
    {
      if (Build.VERSION.SDK_INT <= 28) {
        d0 = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[] { Boolean.TYPE });
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
    }
  }
  
  public m0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public f0 a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new m0.a(paramContext, paramBoolean);
    paramContext.setHoverListener(this);
    return paramContext;
  }
  
  public void a(g paramg, MenuItem paramMenuItem)
  {
    l0 locall0 = c0;
    if (locall0 != null) {
      locall0.a(paramg, paramMenuItem);
    }
  }
  
  public void b(g paramg, MenuItem paramMenuItem)
  {
    l0 locall0 = c0;
    if (locall0 != null) {
      locall0.b(paramg, paramMenuItem);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.m0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */