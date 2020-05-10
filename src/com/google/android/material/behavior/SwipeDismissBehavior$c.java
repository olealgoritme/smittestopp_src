package com.google.android.material.behavior;

import android.view.View;
import d.i.i.n;
import d.k.b.a;

public class SwipeDismissBehavior$c
  implements Runnable
{
  public final View x;
  public final boolean y;
  
  public SwipeDismissBehavior$c(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    x = paramView;
    y = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = z.a;
    if ((localObject != null) && (((a)localObject).a(true)))
    {
      n.a(x, this);
    }
    else if (y)
    {
      localObject = z.b;
      if (localObject != null) {
        ((SwipeDismissBehavior.b)localObject).a(x);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.behavior.SwipeDismissBehavior.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */