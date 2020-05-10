package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import d.i.i.n;
import e.c.a.b.h.b;
import java.util.List;

public abstract class ExpandableBehavior
  extends CoordinatorLayout.c<View>
{
  public int a = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public boolean a(final CoordinatorLayout paramCoordinatorLayout, final View paramView, final int paramInt)
  {
    if (!n.t(paramView))
    {
      List localList = paramCoordinatorLayout.a(paramView);
      int i = localList.size();
      for (paramInt = 0; paramInt < i; paramInt++)
      {
        View localView = (View)localList.get(paramInt);
        if (a(paramCoordinatorLayout, paramView, localView))
        {
          paramCoordinatorLayout = (b)localView;
          break label72;
        }
      }
      paramCoordinatorLayout = null;
      label72:
      if ((paramCoordinatorLayout != null) && (a(paramCoordinatorLayout.a())))
      {
        if (paramCoordinatorLayout.a()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        a = paramInt;
        paramView.getViewTreeObserver().addOnPreDrawListener(new a(paramView, paramInt, paramCoordinatorLayout));
      }
    }
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramBoolean)
    {
      int i = a;
      if (i != 0)
      {
        paramBoolean = bool2;
        if (i != 2) {}
      }
      else
      {
        paramBoolean = true;
      }
      return paramBoolean;
    }
    paramBoolean = bool1;
    if (a == 1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = (b)paramView2;
    if (a(paramCoordinatorLayout.a()))
    {
      int i;
      if (paramCoordinatorLayout.a()) {
        i = 1;
      } else {
        i = 2;
      }
      a = i;
      return a((View)paramCoordinatorLayout, paramView1, paramCoordinatorLayout.a(), true);
    }
    return false;
  }
  
  public class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, int paramInt, b paramb) {}
    
    public boolean onPreDraw()
    {
      paramView.getViewTreeObserver().removeOnPreDrawListener(this);
      ExpandableBehavior localExpandableBehavior = ExpandableBehavior.this;
      if (a == paramInt)
      {
        b localb = paramCoordinatorLayout;
        localExpandableBehavior.a((View)localb, paramView, localb.a(), false);
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */