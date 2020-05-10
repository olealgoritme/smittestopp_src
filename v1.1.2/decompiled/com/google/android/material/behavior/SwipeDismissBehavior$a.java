package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import d.i.i.n;
import d.k.b.a;
import d.k.b.a.c;

public class SwipeDismissBehavior$a
  extends a.c
{
  public int a;
  public int b = -1;
  
  public SwipeDismissBehavior$a(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  public int a(View paramView)
  {
    return paramView.getWidth();
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    if (n.i(paramView) == 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i = c.e;
    if (i == 0)
    {
      if (paramInt2 != 0)
      {
        i = a - paramView.getWidth();
        paramInt2 = a;
      }
      else
      {
        i = a;
      }
    }
    else
    {
      for (paramInt2 = paramView.getWidth();; paramInt2 = paramView.getWidth())
      {
        paramInt2 += i;
        break label137;
        if (i != 1) {
          break label114;
        }
        if (paramInt2 == 0) {
          break;
        }
        i = a;
      }
      i = a - paramView.getWidth();
      paramInt2 = a;
      break label137;
      label114:
      i = a - paramView.getWidth();
      paramInt2 = a;
      paramInt2 = paramView.getWidth() + paramInt2;
    }
    label137:
    return Math.min(Math.max(i, paramInt1), paramInt2);
  }
  
  public void a(int paramInt)
  {
    SwipeDismissBehavior.b localb = c.b;
    if (localb != null) {
      localb.a(paramInt);
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    b = -1;
    int i = paramView.getWidth();
    boolean bool1 = false;
    boolean bool2 = paramFloat1 < 0.0F;
    int k;
    int m;
    if (bool2)
    {
      if (n.i(paramView) == 1) {
        k = 1;
      } else {
        k = 0;
      }
      m = c.e;
      if (m != 2)
      {
        if (m != 0) {
          break label95;
        }
        if (k != 0 ? paramFloat1 >= 0.0F : !bool2) {
          break label89;
        }
      }
    }
    label89:
    label95:
    int j;
    for (;;)
    {
      k = 1;
      break;
      do
      {
        do
        {
          k = 0;
          break;
        } while ((m != 1) || (k != 0 ? !bool2 : paramFloat1 >= 0.0F));
        break;
        k = paramView.getLeft();
        j = a;
        m = Math.round(paramView.getWidth() * c.f);
      } while (Math.abs(k - j) < m);
    }
    if (k != 0)
    {
      k = paramView.getLeft();
      j = a;
      if (k < j) {
        k = j - i;
      } else {
        k = j + i;
      }
      bool1 = true;
    }
    else
    {
      k = a;
    }
    if (c.a.b(k, paramView.getTop()))
    {
      n.a(paramView, new SwipeDismissBehavior.c(c, paramView, bool1));
    }
    else if (bool1)
    {
      SwipeDismissBehavior.b localb = c.b;
      if (localb != null) {
        localb.a(paramView);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    b = paramInt;
    a = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = a;
    f1 = paramView.getWidth() * c.g + f1;
    float f2 = a;
    float f3 = paramView.getWidth() * c.h + f2;
    f2 = paramInt1;
    if (f2 <= f1) {
      paramView.setAlpha(1.0F);
    } else if (f2 >= f3) {
      paramView.setAlpha(0.0F);
    } else {
      paramView.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - (f2 - f1) / (f3 - f1), 1.0F));
    }
  }
  
  public int b(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public boolean b(View paramView, int paramInt)
  {
    boolean bool;
    if ((b == -1) && (c.a(paramView))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */