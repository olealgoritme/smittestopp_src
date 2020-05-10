package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.styleable;
import d.i.i.n;
import e.c.a.b.b.c;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
  extends c
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
    g = paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
    paramContext.recycle();
  }
  
  public AppBarLayout a(List<View> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)paramList.get(j);
      if ((localView instanceof AppBarLayout)) {
        return (AppBarLayout)localView;
      }
    }
    return null;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppBarLayout localAppBarLayout = a(paramCoordinatorLayout.a(paramView));
    if (localAppBarLayout != null)
    {
      paramRect.offset(paramView.getLeft(), paramView.getTop());
      paramView = d;
      paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
      if (!paramView.contains(paramRect))
      {
        localAppBarLayout.a(false, paramBoolean ^ true);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof AppBarLayout;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = getLayoutParamsa;
    if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
    {
      paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
      n.d(paramView1, paramView2.getBottom() - paramView1.getTop() + k + f - a(paramView2));
    }
    if ((paramView2 instanceof AppBarLayout))
    {
      paramCoordinatorLayout = (AppBarLayout)paramView2;
      if (E)
      {
        boolean bool;
        if (paramView1.getScrollY() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramCoordinatorLayout.a(bool);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */