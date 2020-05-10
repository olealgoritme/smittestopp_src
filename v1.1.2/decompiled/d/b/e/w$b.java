package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import d.i.i.n;

public class w$b
  extends i0
{
  public CharSequence c0;
  public ListAdapter d0;
  public final Rect e0 = new Rect();
  
  public w$b(w paramw, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    O = paramw;
    a(true);
    M = 0;
    P = new a(paramw);
  }
  
  public void a()
  {
    boolean bool = e();
    d();
    Y.setInputMethodMode(2);
    super.a();
    z.setChoiceMode(1);
    int i = f0.getSelectedItemPosition();
    final Object localObject = z;
    if ((e()) && (localObject != null))
    {
      ((d0)localObject).setListSelectionHidden(false);
      ((ListView)localObject).setSelection(i);
      if (((ListView)localObject).getChoiceMode() != 0) {
        ((ListView)localObject).setItemChecked(i, true);
      }
    }
    if (bool) {
      return;
    }
    ViewTreeObserver localViewTreeObserver = f0.getViewTreeObserver();
    if (localViewTreeObserver != null)
    {
      localObject = new b();
      localViewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
      localObject = new c((ViewTreeObserver.OnGlobalLayoutListener)localObject);
      Y.setOnDismissListener((PopupWindow.OnDismissListener)localObject);
    }
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    d0 = paramListAdapter;
  }
  
  public void d()
  {
    Object localObject = c();
    int i = 0;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(f0.E);
      if (b1.a(f0)) {
        i = f0.E.right;
      } else {
        i = -f0.E.left;
      }
    }
    else
    {
      localObject = f0.E;
      right = 0;
      left = 0;
    }
    int j = f0.getPaddingLeft();
    int k = f0.getPaddingRight();
    int m = f0.getWidth();
    localObject = f0;
    int n = D;
    if (n == -2)
    {
      int i1 = ((w)localObject).a((SpinnerAdapter)d0, c());
      n = f0.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = f0.E;
      int i2 = n - left - right;
      n = i1;
      if (i1 > i2) {
        n = i2;
      }
      a(Math.max(n, m - j - k));
    }
    else if (n == -1)
    {
      a(m - j - k);
    }
    else
    {
      a(n);
    }
    if (b1.a(f0)) {
      i = m - k - B + i;
    } else {
      i += j;
    }
    C = i;
  }
  
  public class a
    implements AdapterView.OnItemClickListener
  {
    public a(w paramw) {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      f0.setSelection(paramInt);
      if (f0.getOnItemClickListener() != null)
      {
        paramAdapterView = w.b.this;
        f0.performItemClick(paramView, paramInt, d0.getItemId(paramInt));
      }
      dismiss();
    }
  }
  
  public class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public b() {}
    
    public void onGlobalLayout()
    {
      w.b localb = w.b.this;
      w localw = f0;
      if (localb != null)
      {
        int i;
        if ((n.s(localw)) && (localw.getGlobalVisibleRect(e0))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          dismiss();
        }
        else
        {
          d();
          w.b.a(w.b.this);
        }
        return;
      }
      throw null;
    }
  }
  
  public class c
    implements PopupWindow.OnDismissListener
  {
    public c(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
    
    public void onDismiss()
    {
      ViewTreeObserver localViewTreeObserver = f0.getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeGlobalOnLayoutListener(localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.w.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */