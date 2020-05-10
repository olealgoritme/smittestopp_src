package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class FabTransformationScrimBehavior$a
  extends AnimatorListenerAdapter
{
  public FabTransformationScrimBehavior$a(FabTransformationScrimBehavior paramFabTransformationScrimBehavior, boolean paramBoolean, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!a) {
      b.setVisibility(4);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (a) {
      b.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */