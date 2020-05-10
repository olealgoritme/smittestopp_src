package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import e.c.a.b.h.b;

public class ExpandableBehavior$a
  implements ViewTreeObserver.OnPreDrawListener
{
  public ExpandableBehavior$a(ExpandableBehavior paramExpandableBehavior, View paramView, int paramInt, b paramb) {}
  
  public boolean onPreDraw()
  {
    x.getViewTreeObserver().removeOnPreDrawListener(this);
    ExpandableBehavior localExpandableBehavior = A;
    if (a == y)
    {
      b localb = z;
      localExpandableBehavior.a((View)localb, x, localb.a(), false);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.transformation.ExpandableBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */