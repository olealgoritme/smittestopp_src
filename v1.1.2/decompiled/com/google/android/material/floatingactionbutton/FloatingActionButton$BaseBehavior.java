package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.i.i.n;
import e.c.a.b.j.a;
import e.c.a.b.j.f;
import java.util.List;

public class FloatingActionButton$BaseBehavior<T extends FloatingActionButton>
  extends CoordinatorLayout.c<T>
{
  public Rect a;
  public boolean b;
  
  public FloatingActionButton$BaseBehavior()
  {
    b = true;
  }
  
  public FloatingActionButton$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
    b = paramContext.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
    paramContext.recycle();
  }
  
  public void a(CoordinatorLayout.f paramf)
  {
    if (h == 0) {
      h = 80;
    }
  }
  
  public final boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    CoordinatorLayout.f localf = (CoordinatorLayout.f)paramFloatingActionButton.getLayoutParams();
    if (!b) {
      return false;
    }
    if (f != paramView.getId()) {
      return false;
    }
    return paramFloatingActionButton.getUserSetVisibility() == 0;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    paramView = (FloatingActionButton)paramView;
    Object localObject1 = paramCoordinatorLayout.a(paramView);
    int i = ((List)localObject1).size();
    int j = 0;
    Object localObject2;
    for (int k = 0; k < i; k++)
    {
      localObject2 = (View)((List)localObject1).get(k);
      if ((localObject2 instanceof AppBarLayout))
      {
        if (a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramView)) {
          break;
        }
      }
      else
      {
        ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
        boolean bool;
        if ((localLayoutParams instanceof CoordinatorLayout.f)) {
          bool = a instanceof BottomSheetBehavior;
        } else {
          bool = false;
        }
        if ((bool) && (b((View)localObject2, paramView))) {
          break;
        }
      }
    }
    paramCoordinatorLayout.b(paramView, paramInt);
    localObject1 = H;
    if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
    {
      localObject2 = (CoordinatorLayout.f)paramView.getLayoutParams();
      if (paramView.getRight() >= paramCoordinatorLayout.getWidth() - rightMargin) {
        paramInt = right;
      } else if (paramView.getLeft() <= leftMargin) {
        paramInt = -left;
      } else {
        paramInt = 0;
      }
      if (paramView.getBottom() >= paramCoordinatorLayout.getHeight() - bottomMargin)
      {
        k = bottom;
      }
      else
      {
        k = j;
        if (paramView.getTop() <= topMargin) {
          k = -top;
        }
      }
      if (k != 0) {
        n.d(paramView, k);
      }
      if (paramInt != 0) {
        n.c(paramView, paramInt);
      }
    }
    return true;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect)
  {
    paramCoordinatorLayout = (FloatingActionButton)paramView;
    paramView = H;
    paramRect.set(paramCoordinatorLayout.getLeft() + left, paramCoordinatorLayout.getTop() + top, paramCoordinatorLayout.getRight() - right, paramCoordinatorLayout.getBottom() - bottom);
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramAppBarLayout, paramFloatingActionButton)) {
      return false;
    }
    if (a == null) {
      a = new Rect();
    }
    Rect localRect = a;
    a.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
    if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
      paramFloatingActionButton.a(null, false);
    } else {
      paramFloatingActionButton.b(null, false);
    }
    return true;
  }
  
  public final boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramView, paramFloatingActionButton)) {
      return false;
    }
    CoordinatorLayout.f localf = (CoordinatorLayout.f)paramFloatingActionButton.getLayoutParams();
    if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + topMargin) {
      paramFloatingActionButton.a(null, false);
    } else {
      paramFloatingActionButton.b(null, false);
    }
    return true;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramView1 = (FloatingActionButton)paramView1;
    if ((paramView2 instanceof AppBarLayout))
    {
      a(paramCoordinatorLayout, (AppBarLayout)paramView2, paramView1);
    }
    else
    {
      paramCoordinatorLayout = paramView2.getLayoutParams();
      boolean bool;
      if ((paramCoordinatorLayout instanceof CoordinatorLayout.f)) {
        bool = a instanceof BottomSheetBehavior;
      } else {
        bool = false;
      }
      if (bool) {
        b(paramView2, paramView1);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */