package d.b.d.i;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.R.dimen;

import d.i.i.n;

public class l
{
  public final Context a;
  public final g b;
  public final boolean c;
  public final int d;
  public final int e;
  public View f;
  public int g = 8388611;
  public boolean h;
  public m.a i;
  public k j;
  public PopupWindow.OnDismissListener k;
  public final PopupWindow.OnDismissListener l = new l.a(this);
  
  public l(Context paramContext, g paramg, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a = paramContext;
    b = paramg;
    f = paramView;
    c = paramBoolean;
    d = paramInt1;
    e = paramInt2;
  }
  
  public k a()
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
        localObject = new d(a, f, d, e, c);
      } else {
        localObject = new q(a, b, f, d, e, c);
      }
      ((k)localObject).a(b);
      ((k)localObject).a(l);
      ((k)localObject).a(f);
      ((m)localObject).a(i);
      ((k)localObject).b(h);
      ((k)localObject).a(g);
      j = ((k)localObject);
    }
    return j;
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    k localk = a();
    localk.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((Gravity.getAbsoluteGravity(g, n.i(f)) & 0x7) == 5) {
        m = paramInt1 - f.getWidth();
      }
      localk.b(m);
      localk.c(paramInt2);
      paramInt1 = (int)(a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      x = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localk.c();
  }
  
  public void a(m.a parama)
  {
    i = parama;
    k localk = j;
    if (localk != null) {
      localk.a(parama);
    }
  }
  
  public boolean b()
  {
    k localk = j;
    boolean bool;
    if ((localk != null) && (localk.a())) {
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
}

/* Location:
 * Qualified Name:     base.d.b.d.i.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */