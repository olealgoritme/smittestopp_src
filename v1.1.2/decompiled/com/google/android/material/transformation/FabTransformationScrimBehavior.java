package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.c.a.a.b.l.c;
import e.c.a.b.a.h;
import java.util.ArrayList;

public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  public final h c = new h(75L, 150L);
  public final h d = new h(0L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  public AnimatorSet b(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    new ArrayList();
    if (paramBoolean1) {
      paramView1 = c;
    } else {
      paramView1 = d;
    }
    ObjectAnimator localObjectAnimator;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView2.setAlpha(0.0F);
      }
      localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 1.0F });
    }
    else
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 0.0F });
    }
    paramView1.a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramView1 = new AnimatorSet();
    c.a(paramView1, localArrayList);
    paramView1.addListener(new a(paramBoolean1, paramView2));
    return paramView1;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a(boolean paramBoolean, View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!paramBoolean1) {
        paramView2.setVisibility(4);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (paramBoolean1) {
        paramView2.setVisibility(0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */