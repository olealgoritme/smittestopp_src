package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import e.c.a.b.a.a;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.c<V>
{
  public int a = 0;
  public int b = 2;
  public ViewPropertyAnimator c;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(V paramV)
  {
    ViewPropertyAnimator localViewPropertyAnimator = c;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    b = 1;
    a(paramV, a, 175L, a.b);
  }
  
  public final void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    c = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new a());
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((b != 1) && (paramInt2 > 0)) {
      a(paramV);
    } else if ((b != 2) && (paramInt2 < 0)) {
      b(paramV);
    }
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    a = paramV.getMeasuredHeight();
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void b(V paramV)
  {
    ViewPropertyAnimator localViewPropertyAnimator = c;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    b = 2;
    a(paramV, 0, 225L, a.c);
  }
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      c = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */