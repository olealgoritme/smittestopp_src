package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class FabTransformationBehavior$a
  extends AnimatorListenerAdapter
{
  public FabTransformationBehavior$a(FabTransformationBehavior paramFabTransformationBehavior, boolean paramBoolean, View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!a)
    {
      b.setVisibility(4);
      c.setAlpha(1.0F);
      c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (a)
    {
      b.setVisibility(0);
      c.setAlpha(0.0F);
      c.setVisibility(4);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */