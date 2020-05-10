package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class w$d
  extends k0
  implements w.f
{
  public CharSequence c0;
  public ListAdapter d0;
  public final Rect e0 = new Rect();
  public int f0;
  
  public w$d(w paramw, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    O = paramw;
    a(true);
    M = 0;
    P = new w.d.a(this, paramw);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = a();
    h();
    Y.setInputMethodMode(2);
    super.c();
    Object localObject = z;
    ((ListView)localObject).setChoiceMode(1);
    ((ListView)localObject).setTextDirection(paramInt1);
    ((ListView)localObject).setTextAlignment(paramInt2);
    paramInt1 = g0.getSelectedItemPosition();
    localObject = z;
    if ((a()) && (localObject != null))
    {
      ((f0)localObject).setListSelectionHidden(false);
      ((ListView)localObject).setSelection(paramInt1);
      if (((ListView)localObject).getChoiceMode() != 0) {
        ((ListView)localObject).setItemChecked(paramInt1, true);
      }
    }
    if (bool) {
      return;
    }
    localObject = g0.getViewTreeObserver();
    if (localObject != null)
    {
      w.d.b localb = new w.d.b(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(localb);
      localObject = new w.d.c(this, localb);
      Y.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
    }
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    d0 = paramListAdapter;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    c0 = paramCharSequence;
  }
  
  public void c(int paramInt)
  {
    f0 = paramInt;
  }
  
  public CharSequence f()
  {
    return c0;
  }
  
  public void h()
  {
    Object localObject = e();
    int i = 0;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(g0.E);
      if (d1.a(g0)) {
        i = g0.E.right;
      } else {
        i = -g0.E.left;
      }
    }
    else
    {
      localObject = g0.E;
      right = 0;
      left = 0;
    }
    int j = g0.getPaddingLeft();
    int k = g0.getPaddingRight();
    int m = g0.getWidth();
    localObject = g0;
    int n = D;
    if (n == -2)
    {
      int i1 = ((w)localObject).a((SpinnerAdapter)d0, e());
      n = g0.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = g0.E;
      int i2 = n - left - right;
      n = i1;
      if (i1 > i2) {
        n = i2;
      }
      d(Math.max(n, m - j - k));
    }
    else if (n == -1)
    {
      d(m - j - k);
    }
    else
    {
      d(n);
    }
    if (d1.a(g0)) {
      i = m - k - B - f0 + i;
    } else {
      i = j + f0 + i;
    }
    C = i;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.w.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */