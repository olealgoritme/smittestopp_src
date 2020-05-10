package d.b.e;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import d.i.i.n;
import d.i.i.r;

public class a1
  implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener
{
  public static a1 G;
  public static a1 H;
  public final Runnable A = new a1.a(this);
  public final Runnable B = new a1.b(this);
  public int C;
  public int D;
  public b1 E;
  public boolean F;
  public final View x;
  public final CharSequence y;
  public final int z;
  
  public a1(View paramView, CharSequence paramCharSequence)
  {
    x = paramView;
    y = paramCharSequence;
    z = r.a(ViewConfiguration.get(paramView.getContext()));
    a();
    x.setOnLongClickListener(this);
    x.setOnHoverListener(this);
  }
  
  public static void a(a1 parama1)
  {
    a1 locala1 = G;
    if (locala1 != null) {
      x.removeCallbacks(A);
    }
    G = parama1;
    if (parama1 != null) {
      x.postDelayed(A, ViewConfiguration.getLongPressTimeout());
    }
  }
  
  public final void a()
  {
    C = Integer.MAX_VALUE;
    D = Integer.MAX_VALUE;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!n.s(x)) {
      return;
    }
    a(null);
    Object localObject1 = H;
    if (localObject1 != null) {
      ((a1)localObject1).b();
    }
    H = this;
    F = paramBoolean;
    b1 localb1 = new b1(x.getContext());
    E = localb1;
    View localView = x;
    int i = C;
    int j = D;
    paramBoolean = F;
    localObject1 = y;
    int k;
    if (b.getParent() != null) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      localb1.a();
    }
    c.setText((CharSequence)localObject1);
    WindowManager.LayoutParams localLayoutParams = d;
    token = localView.getApplicationWindowToken();
    int m = a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
    if (localView.getWidth() >= m) {
      k = i;
    } else {
      k = localView.getWidth() / 2;
    }
    if (localView.getHeight() >= m)
    {
      m = a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
      i = j + m;
      j -= m;
    }
    else
    {
      i = localView.getHeight();
      j = 0;
    }
    gravity = 49;
    localObject1 = a.getResources();
    if (paramBoolean) {
      m = R.dimen.tooltip_y_offset_touch;
    } else {
      m = R.dimen.tooltip_y_offset_non_touch;
    }
    int n = ((Resources)localObject1).getDimensionPixelOffset(m);
    Object localObject2 = localView.getRootView();
    localObject1 = ((View)localObject2).getLayoutParams();
    Object localObject3;
    if (((localObject1 instanceof WindowManager.LayoutParams)) && (type == 2)) {
      localObject1 = localObject2;
    } else {
      for (localObject3 = localView.getContext();; localObject3 = ((ContextWrapper)localObject3).getBaseContext())
      {
        localObject1 = localObject2;
        if (!(localObject3 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject3 instanceof Activity))
        {
          localObject1 = ((Activity)localObject3).getWindow().getDecorView();
          break;
        }
      }
    }
    if (localObject1 == null)
    {
      Log.e("TooltipPopup", "Cannot find app view");
    }
    else
    {
      ((View)localObject1).getWindowVisibleDisplayFrame(e);
      localObject3 = e;
      if ((left < 0) && (top < 0))
      {
        localObject3 = a.getResources();
        m = ((Resources)localObject3).getIdentifier("status_bar_height", "dimen", "android");
        if (m != 0) {
          m = ((Resources)localObject3).getDimensionPixelSize(m);
        } else {
          m = 0;
        }
        localObject3 = ((Resources)localObject3).getDisplayMetrics();
        e.set(0, m, widthPixels, heightPixels);
      }
      ((View)localObject1).getLocationOnScreen(g);
      localView.getLocationOnScreen(f);
      localObject3 = f;
      m = localObject3[0];
      localObject2 = g;
      localObject3[0] = (m - localObject2[0]);
      localObject3[1] -= localObject2[1];
      x = (localObject3[0] + k - ((View)localObject1).getWidth() / 2);
      k = View.MeasureSpec.makeMeasureSpec(0, 0);
      b.measure(k, k);
      k = b.getMeasuredHeight();
      localObject1 = f;
      j = localObject1[1] + j - n - k;
      i = localObject1[1] + i + n;
      if (paramBoolean)
      {
        if (j >= 0) {
          y = j;
        } else {
          y = i;
        }
      }
      else if (k + i <= e.height()) {
        y = i;
      } else {
        y = j;
      }
    }
    ((WindowManager)a.getSystemService("window")).addView(b, d);
    x.addOnAttachStateChangeListener(this);
    long l;
    if (F)
    {
      l = 2500L;
    }
    else
    {
      if ((x.getWindowSystemUiVisibility() & 0x1) == 1)
      {
        l = 3000L;
        k = ViewConfiguration.getLongPressTimeout();
      }
      else
      {
        l = 15000L;
        k = ViewConfiguration.getLongPressTimeout();
      }
      l -= k;
    }
    x.removeCallbacks(B);
    x.postDelayed(B, l);
  }
  
  public void b()
  {
    if (H == this)
    {
      H = null;
      b1 localb1 = E;
      if (localb1 != null)
      {
        localb1.a();
        E = null;
        a();
        x.removeOnAttachStateChangeListener(this);
      }
      else
      {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      }
    }
    if (G == this) {
      a(null);
    }
    x.removeCallbacks(B);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((E != null) && (F)) {
      return false;
    }
    paramView = (AccessibilityManager)x.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 7)
    {
      if (i == 10)
      {
        a();
        b();
      }
    }
    else if ((x.isEnabled()) && (E == null))
    {
      int j = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      if ((Math.abs(j - C) <= z) && (Math.abs(i - D) <= z))
      {
        i = 0;
      }
      else
      {
        C = j;
        D = i;
        i = 1;
      }
      if (i != 0) {
        a(this);
      }
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    C = (paramView.getWidth() / 2);
    D = (paramView.getHeight() / 2);
    a(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    b();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.a1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */