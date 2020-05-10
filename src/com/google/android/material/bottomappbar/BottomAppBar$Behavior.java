package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.c.a.b.a.a;

public class BottomAppBar$Behavior
  extends HideBottomViewOnScrollBehavior<BottomAppBar>
{
  public final Rect d = new Rect();
  
  public BottomAppBar$Behavior() {}
  
  public BottomAppBar$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(View paramView)
  {
    paramView = (BottomAppBar)paramView;
    super.a(paramView);
    paramView = BottomAppBar.a(paramView);
    if (paramView != null)
    {
      paramView.a(d);
      float f = paramView.getMeasuredHeight() - d.height();
      paramView.clearAnimation();
      paramView.animate().translationY(-paramView.getPaddingBottom() + f).setInterpolator(a.b).setDuration(175L);
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    paramView = (BottomAppBar)paramView;
    Object localObject = BottomAppBar.a(paramView);
    if (localObject == null)
    {
      localObject = q0;
      if ((localObject == null) || (!((Animator)localObject).isRunning()))
      {
        localObject = p0;
        if ((localObject == null) || (!((Animator)localObject).isRunning())) {}
      }
      else
      {
        i = 1;
        break label63;
      }
      int i = 0;
      label63:
      if (i != 0)
      {
        paramCoordinatorLayout.b(paramView, paramInt);
        a = paramView.getMeasuredHeight();
        return false;
      }
      BottomAppBar.b(paramView);
      throw null;
    }
    getLayoutParamsd = 17;
    BottomAppBar.a(paramView, (FloatingActionButton)localObject);
    d.set(0, 0, ((ImageButton)localObject).getMeasuredWidth(), ((ImageButton)localObject).getMeasuredHeight());
    throw null;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    paramView1 = (BottomAppBar)paramView1;
    boolean bool1 = paramView1.getHideOnScroll();
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      if (paramInt2 == 0) {
        bool1 = a(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
      } else {
        bool1 = false;
      }
      bool3 = bool2;
      if (bool1) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public void b(View paramView)
  {
    BottomAppBar localBottomAppBar = (BottomAppBar)paramView;
    super.b(localBottomAppBar);
    paramView = BottomAppBar.a(localBottomAppBar);
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.animate().translationY(BottomAppBar.c(localBottomAppBar)).setInterpolator(a.c).setDuration(225L);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.bottomappbar.BottomAppBar.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */