package e.c.a.b.b;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import d.b.a.s;
import d.i.i.n;
import d.i.i.w;
import java.util.List;

public abstract class c
  extends d<View>
{
  public final Rect d = new Rect();
  public final Rect e = new Rect();
  public int f = 0;
  public int g;
  
  public c() {}
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final int a(View paramView)
  {
    int i = g;
    int j = 0;
    if (i != 0)
    {
      boolean bool = paramView instanceof AppBarLayout;
      float f1 = 0.0F;
      float f2 = f1;
      if (bool)
      {
        paramView = (AppBarLayout)paramView;
        i = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        paramView = getLayoutParamsa;
        if ((paramView instanceof AppBarLayout.BaseBehavior)) {
          j = ((AppBarLayout.BaseBehavior)paramView).b();
        } else {
          j = 0;
        }
        if ((k != 0) && (i + j <= k))
        {
          f2 = f1;
        }
        else
        {
          i -= k;
          f2 = f1;
          if (i != 0) {
            f2 = 1.0F + j / i;
          }
        }
      }
      j = g;
      j = s.a((int)(f2 * j), 0, j);
    }
    return j;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getLayoutParamsheight;
    if ((i == -1) || (i == -2))
    {
      Object localObject = paramCoordinatorLayout.a(paramView);
      localObject = ((AppBarLayout.ScrollingViewBehavior)this).a((List)localObject);
      if (localObject != null)
      {
        if ((n.g((View)localObject)) && (!paramView.getFitsSystemWindows()))
        {
          paramView.setFitsSystemWindows(true);
          if (paramView.getFitsSystemWindows())
          {
            paramView.requestLayout();
            return true;
          }
        }
        int j = View.MeasureSpec.getSize(paramInt3);
        paramInt3 = j;
        if (j == 0) {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        int k = ((View)localObject).getMeasuredHeight();
        int m = ((AppBarLayout)localObject).getTotalScrollRange();
        if (i == -1) {
          j = 1073741824;
        } else {
          j = Integer.MIN_VALUE;
        }
        paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3 - k + m, j), paramInt4);
        return true;
      }
    }
    return false;
  }
  
  public void b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    Object localObject = paramCoordinatorLayout.a(paramView);
    AppBarLayout localAppBarLayout = ((AppBarLayout.ScrollingViewBehavior)this).a((List)localObject);
    if (localAppBarLayout != null)
    {
      localObject = (CoordinatorLayout.f)paramView.getLayoutParams();
      Rect localRect = d;
      int i = paramCoordinatorLayout.getPaddingLeft();
      int j = leftMargin;
      int k = localAppBarLayout.getBottom();
      int m = topMargin;
      int n = paramCoordinatorLayout.getWidth();
      int i1 = paramCoordinatorLayout.getPaddingRight();
      int i2 = rightMargin;
      int i3 = paramCoordinatorLayout.getHeight();
      localRect.set(i + j, k + m, n - i1 - i2, localAppBarLayout.getBottom() + i3 - paramCoordinatorLayout.getPaddingBottom() - bottomMargin);
      w localw = paramCoordinatorLayout.getLastWindowInsets();
      if ((localw != null) && (n.g(paramCoordinatorLayout)) && (!paramView.getFitsSystemWindows()))
      {
        i1 = left;
        left = (localw.b() + i1);
        right -= localw.c();
      }
      paramCoordinatorLayout = e;
      i1 = c;
      if (i1 == 0) {
        i1 = 8388659;
      }
      Gravity.apply(i1, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = a(localAppBarLayout);
      paramView.layout(left, top - paramInt, right, bottom - paramInt);
      f = (top - localAppBarLayout.getBottom());
    }
    else
    {
      paramCoordinatorLayout.b(paramView, paramInt);
      f = 0;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */