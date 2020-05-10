package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import e.c.a.b.m.a;
import e.c.a.b.m.d;
import e.c.a.b.m.e;

public class BaseTransientBottomBar$Behavior
  extends SwipeDismissBehavior<View>
{
  public final a j = new a(this);
  
  public boolean a(View paramView)
  {
    if (j != null) {
      return paramView instanceof d;
    }
    throw null;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (j != null)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i != 0)
      {
        if ((i == 1) || (i == 3))
        {
          if (e.c == null) {
            e.c = new e();
          }
          e.c.b(null);
        }
      }
      else if (paramCoordinatorLayout.a(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        if (e.c == null) {
          e.c = new e();
        }
        e.c.a(null);
      }
      return super.a(paramCoordinatorLayout, paramView, paramMotionEvent);
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */