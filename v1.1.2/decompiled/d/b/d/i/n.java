package d.b.d.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R.dimen;

public class n
{
  public final Context a;
  public final h b;
  public final boolean c;
  public final int d;
  public final int e;
  public View f;
  public int g = 8388611;
  public boolean h;
  public o.a i;
  public m j;
  public PopupWindow.OnDismissListener k;
  public final PopupWindow.OnDismissListener l = new a();
  
  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a = paramContext;
    b = paramh;
    f = paramView;
    c = paramBoolean;
    d = paramInt1;
    e = paramInt2;
  }
  
  public m a()
  {
    if (j == null)
    {
      Display localDisplay = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
      Object localObject = new Point();
      localDisplay.getRealSize((Point)localObject);
      int m;
      if (Math.min(x, y) >= a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        localObject = new e(a, f, d, e, c);
      } else {
        localObject = new s(a, b, f, d, e, c);
      }
      ((m)localObject).a(b);
      ((m)localObject).a(l);
      ((m)localObject).a(f);
      ((o)localObject).a(i);
      ((m)localObject).b(h);
      ((m)localObject).a(g);
      j = ((m)localObject);
    }
    return j;
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = a();
    localm.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((Gravity.getAbsoluteGravity(g, d.i.i.n.i(f)) & 0x7) == 5) {
        m = paramInt1 - f.getWidth();
      }
      localm.b(m);
      localm.c(paramInt2);
      paramInt1 = (int)(a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      x = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localm.a();
  }
  
  public void a(o.a parama)
  {
    i = parama;
    m localm = j;
    if (localm != null) {
      localm.a(parama);
    }
  }
  
  public boolean b()
  {
    m localm = j;
    boolean bool;
    if ((localm != null) && (localm.e())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    j = null;
    PopupWindow.OnDismissListener localOnDismissListener = k;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public boolean d()
  {
    if (b()) {
      return true;
    }
    if (f == null) {
      return false;
    }
    a(0, 0, false, false);
    return true;
  }
  
  public class a
    implements PopupWindow.OnDismissListener
  {
    public a() {}
    
    public void onDismiss()
    {
      c();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */