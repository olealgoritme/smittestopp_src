package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  public AnimatorSet b;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (b != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      b.cancel();
    }
    paramView1 = b(paramView1, paramView2, paramBoolean1, bool);
    b = paramView1;
    paramView1.addListener(new a());
    b.start();
    if (!paramBoolean2) {
      b.end();
    }
    return true;
  }
  
  public abstract AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      b = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.ExpandableTransformationBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */