package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import d.k.b.a;
import d.k.b.a.c;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.c<V>
{
  public a a;
  public SwipeDismissBehavior.b b;
  public boolean c;
  public float d = 0.0F;
  public int e = 2;
  public float f = 0.5F;
  public float g = 0.0F;
  public float h = 0.5F;
  public final a.c i = new SwipeDismissBehavior.a(this);
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public boolean a(View paramView)
  {
    return true;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool = c;
    int j = paramMotionEvent.getActionMasked();
    if (j != 0)
    {
      if ((j == 1) || (j == 3)) {
        c = false;
      }
    }
    else
    {
      bool = paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      c = bool;
    }
    if (bool)
    {
      if (a == null)
      {
        paramV = i;
        a = new a(paramCoordinatorLayout.getContext(), paramCoordinatorLayout, paramV);
      }
      return a.c(paramMotionEvent);
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = a;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.a(paramMotionEvent);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.behavior.SwipeDismissBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */