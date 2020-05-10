package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import d.b.a.r;
import d.f.h;
import d.i.i.f;
import d.i.i.n;
import e.c.a.b.b.b;
import e.c.a.b.b.c;
import e.c.a.b.b.d;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$BaseBehavior<T extends AppBarLayout>
  extends b<T>
{
  public int k;
  public int l;
  public ValueAnimator m;
  public int n = -1;
  public boolean o;
  public float p;
  public WeakReference<View> q;
  
  public AppBarLayout$BaseBehavior() {}
  
  public AppBarLayout$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 & paramInt2) == paramInt2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Parcelable a(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    AppBarLayout localAppBarLayout = (AppBarLayout)paramView;
    paramView = View.BaseSavedState.EMPTY_STATE;
    int i = a();
    int j = localAppBarLayout.getChildCount();
    boolean bool = false;
    for (int i1 = 0;; i1++)
    {
      paramCoordinatorLayout = paramView;
      if (i1 >= j) {
        break;
      }
      View localView = localAppBarLayout.getChildAt(i1);
      int i2 = localView.getBottom() + i;
      if ((localView.getTop() + i <= 0) && (i2 >= 0))
      {
        paramCoordinatorLayout = new AppBarLayout.BaseBehavior.a(paramView);
        z = i1;
        i1 = n.j(localView);
        if (i2 == localAppBarLayout.getTopInset() + i1) {
          bool = true;
        }
        B = bool;
        A = (i2 / localView.getHeight());
        break;
      }
    }
    return paramCoordinatorLayout;
  }
  
  public final void a(int paramInt1, T paramT, View paramView, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      paramInt2 = b();
      if (((paramInt1 < 0) && (paramInt2 == 0)) || ((paramInt1 > 0) && (paramInt2 == -paramT.getDownNestedScrollRange()))) {
        n.f(paramView, 1);
      }
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable)
  {
    paramCoordinatorLayout = (AppBarLayout)paramView;
    if ((paramParcelable instanceof AppBarLayout.BaseBehavior.a))
    {
      paramView = (AppBarLayout.BaseBehavior.a)paramParcelable;
      paramCoordinatorLayout = x;
      n = z;
      p = A;
      o = B;
    }
    else
    {
      n = -1;
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    paramView1 = (AppBarLayout)paramView1;
    if ((l == 0) || (paramInt == 1)) {
      a(paramCoordinatorLayout, paramView1);
    }
    q = new WeakReference(paramView2);
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramView1 = (AppBarLayout)paramView1;
    if (paramInt4 < 0)
    {
      a(paramCoordinatorLayout, paramView1, paramInt4, -paramView1.getDownNestedScrollRange(), 0);
      a(paramInt4, paramView1, paramView2, paramInt5);
    }
    if (E)
    {
      boolean bool;
      if (paramView2.getScrollY() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramView1.a(bool);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    paramView1 = (AppBarLayout)paramView1;
    if (paramInt2 != 0)
    {
      int i;
      if (paramInt2 < 0)
      {
        i = -paramView1.getTotalScrollRange();
        int j = paramView1.getDownNestedPreScrollRange();
        paramInt1 = i;
        j += i;
        i = paramInt1;
        paramInt1 = j;
      }
      else
      {
        i = -paramView1.getUpNestedPreScrollRange();
        paramInt1 = 0;
      }
      if (i != paramInt1)
      {
        paramArrayOfInt[1] = a(paramCoordinatorLayout, paramView1, paramInt2, i, paramInt1);
        a(paramInt2, paramView1, paramView2, paramInt3);
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, T paramT)
  {
    int i = b();
    int j = paramT.getChildCount();
    Object localObject;
    int i2;
    int i3;
    int i4;
    int i5;
    for (int i1 = 0; i1 < j; i1++)
    {
      localObject = paramT.getChildAt(i1);
      i2 = ((View)localObject).getTop();
      i3 = ((View)localObject).getBottom();
      localObject = (AppBarLayout.a)((View)localObject).getLayoutParams();
      i4 = i2;
      i5 = i3;
      if (a(a, 32))
      {
        i4 = i2 - topMargin;
        i5 = i3 + bottomMargin;
      }
      i3 = -i;
      if ((i4 <= i3) && (i5 >= i3)) {
        break label124;
      }
    }
    i1 = -1;
    label124:
    if (i1 >= 0)
    {
      localObject = paramT.getChildAt(i1);
      AppBarLayout.a locala = (AppBarLayout.a)((View)localObject).getLayoutParams();
      i2 = a;
      if ((i2 & 0x11) == 17)
      {
        i3 = -((View)localObject).getTop();
        i4 = -((View)localObject).getBottom();
        i5 = i4;
        if (i1 == paramT.getChildCount() - 1) {
          i5 = i4 + paramT.getTopInset();
        }
        if (a(i2, 2))
        {
          i1 = i5 + n.j((View)localObject);
          i4 = i3;
        }
        else
        {
          i4 = i3;
          i1 = i5;
          if (a(i2, 5))
          {
            i1 = n.j((View)localObject) + i5;
            if (i < i1)
            {
              i4 = i1;
              i1 = i5;
            }
            else
            {
              i4 = i3;
            }
          }
        }
        i3 = i4;
        i5 = i1;
        if (a(i2, 32))
        {
          i3 = i4 + topMargin;
          i5 = i1 - bottomMargin;
        }
        i1 = i3;
        if (i < (i5 + i3) / 2) {
          i1 = i5;
        }
        a(paramCoordinatorLayout, paramT, r.a(i1, -paramT.getTotalScrollRange(), 0), 0.0F);
      }
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt, float paramFloat)
  {
    int i = Math.abs(b() - paramInt);
    paramFloat = Math.abs(paramFloat);
    if (paramFloat > 0.0F) {
      i = Math.round(i / paramFloat * 1000.0F) * 3;
    } else {
      i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F);
    }
    int j = b();
    if (j == paramInt)
    {
      paramCoordinatorLayout = m;
      if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
        m.cancel();
      }
    }
    else
    {
      ValueAnimator localValueAnimator = m;
      if (localValueAnimator == null)
      {
        localValueAnimator = new ValueAnimator();
        m = localValueAnimator;
        localValueAnimator.setInterpolator(e.c.a.b.a.a.d);
        m.addUpdateListener(new e.c.a.b.b.a(this, paramCoordinatorLayout, paramT));
      }
      else
      {
        localValueAnimator.cancel();
      }
      m.setDuration(Math.min(i, 600));
      m.setIntValues(new int[] { j, paramInt });
      m.start();
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = Math.abs(paramInt1);
    int j = paramT.getChildCount();
    int i1 = 0;
    Object localObject1;
    for (int i2 = 0;; i2++)
    {
      localObject1 = null;
      if (i2 >= j) {
        break;
      }
      localObject2 = paramT.getChildAt(i2);
      if ((i >= ((View)localObject2).getTop()) && (i <= ((View)localObject2).getBottom())) {
        break label68;
      }
    }
    Object localObject2 = null;
    label68:
    if (localObject2 != null)
    {
      i2 = getLayoutParamsa;
      if ((i2 & 0x1) != 0)
      {
        i = n.j((View)localObject2);
        if ((paramInt2 <= 0) || ((i2 & 0xC) == 0)) {
          break label143;
        }
        if (-paramInt1 < ((View)localObject2).getBottom() - i - paramT.getTopInset()) {}
      }
      for (;;)
      {
        bool1 = true;
        break;
        label143:
        do
        {
          bool1 = false;
          break;
        } while (((i2 & 0x2) == 0) || (-paramInt1 < ((View)localObject2).getBottom() - i - paramT.getTopInset()));
      }
      boolean bool2 = bool1;
      if (E)
      {
        paramInt2 = paramCoordinatorLayout.getChildCount();
        for (paramInt1 = 0;; paramInt1++)
        {
          localObject2 = localObject1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject2 = paramCoordinatorLayout.getChildAt(paramInt1);
          if ((localObject2 instanceof f)) {
            break;
          }
        }
        bool2 = bool1;
        if (localObject2 != null) {
          if (((View)localObject2).getScrollY() > 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
        }
      }
      boolean bool1 = paramT.a(bool2);
      if (!paramBoolean)
      {
        if (bool1)
        {
          localObject2 = paramCoordinatorLayout.b(paramT);
          i2 = ((List)localObject2).size();
          for (paramInt1 = 0;; paramInt1++)
          {
            paramInt2 = i1;
            if (paramInt1 >= i2) {
              break;
            }
            paramCoordinatorLayout = getgetLayoutParamsa;
            if ((paramCoordinatorLayout instanceof AppBarLayout.ScrollingViewBehavior))
            {
              paramInt2 = i1;
              if (g == 0) {
                break;
              }
              paramInt2 = 1;
              break;
            }
          }
          if (paramInt2 == 0) {}
        }
      }
      else {
        paramT.jumpDrawablesToCurrentState();
      }
    }
  }
  
  public boolean a(View paramView)
  {
    paramView = (AppBarLayout)paramView;
    paramView = q;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramView != null)
    {
      paramView = (View)paramView.get();
      if ((paramView != null) && (paramView.isShown()) && (!paramView.canScrollVertically(-1))) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    paramView = (AppBarLayout)paramView;
    super.a(paramCoordinatorLayout, paramView, paramInt);
    int i = paramView.getPendingAction();
    paramInt = n;
    if ((paramInt >= 0) && ((i & 0x8) == 0))
    {
      View localView = paramView.getChildAt(paramInt);
      i = -localView.getBottom();
      if (o)
      {
        paramInt = localView.getMinimumHeight();
        paramInt = paramView.getTopInset() + paramInt + i;
      }
      else
      {
        paramInt = Math.round(localView.getHeight() * p) + i;
      }
      c(paramCoordinatorLayout, paramView, paramInt);
    }
    else if (i != 0)
    {
      if ((i & 0x4) != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((i & 0x2) != 0)
      {
        i = -paramView.getUpNestedPreScrollRange();
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramView, i, 0.0F);
        } else {
          c(paramCoordinatorLayout, paramView, i);
        }
      }
      else if ((i & 0x1) != 0)
      {
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramView, 0, 0.0F);
        } else {
          c(paramCoordinatorLayout, paramView, 0);
        }
      }
    }
    B = 0;
    n = -1;
    a(r.a(a(), -paramView.getTotalScrollRange(), 0));
    a(paramCoordinatorLayout, paramView, a(), 0, true);
    a();
    return true;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView = (AppBarLayout)paramView;
    paramInt3 = getLayoutParamsheight;
    boolean bool = false;
    if (paramInt3 == -2)
    {
      paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
      bool = true;
    }
    return bool;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    paramView1 = (AppBarLayout)paramView1;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if ((paramInt1 & 0x2) != 0) {
      if (!E)
      {
        if (paramView1.getTotalScrollRange() != 0) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if ((paramInt1 != 0) && (paramCoordinatorLayout.getHeight() - paramView2.getHeight() <= paramView1.getHeight())) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        bool2 = bool1;
        if (paramInt1 == 0) {}
      }
      else
      {
        bool2 = true;
      }
    }
    if (bool2)
    {
      paramCoordinatorLayout = m;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.cancel();
      }
    }
    q = null;
    l = paramInt2;
    return bool2;
  }
  
  public int b()
  {
    return a() + k;
  }
  
  public int b(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView = (AppBarLayout)paramView;
    int i = b();
    int j = 0;
    int i1 = 0;
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt3 = r.a(paramInt1, paramInt2, paramInt3);
      paramInt1 = j;
      if (i != paramInt3)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (A)
        {
          j = Math.abs(paramInt3);
          paramInt2 = paramView.getChildCount();
          for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
          {
            localObject1 = paramView.getChildAt(paramInt1);
            localObject2 = (AppBarLayout.a)((View)localObject1).getLayoutParams();
            localObject3 = b;
            if ((j >= ((View)localObject1).getTop()) && (j <= ((View)localObject1).getBottom()))
            {
              if (localObject3 == null) {
                break;
              }
              int i2 = a;
              if ((i2 & 0x1) != 0)
              {
                paramInt2 = ((View)localObject1).getHeight() + topMargin + bottomMargin + 0;
                paramInt1 = paramInt2;
                if ((i2 & 0x2) != 0) {
                  paramInt1 = paramInt2 - n.j((View)localObject1);
                }
              }
              else
              {
                paramInt1 = 0;
              }
              paramInt2 = paramInt1;
              if (n.g((View)localObject1)) {
                paramInt2 = paramInt1 - paramView.getTopInset();
              }
              if (paramInt2 <= 0) {
                break;
              }
              paramInt1 = ((View)localObject1).getTop();
              float f = paramInt2;
              paramInt1 = Math.round(((Interpolator)localObject3).getInterpolation((j - paramInt1) / f) * f);
              paramInt2 = Integer.signum(paramInt3);
              paramInt1 = (((View)localObject1).getTop() + paramInt1) * paramInt2;
              break label279;
            }
          }
        }
        paramInt1 = paramInt3;
        label279:
        boolean bool = a(paramInt1);
        k = (paramInt3 - paramInt1);
        if ((!bool) && (A))
        {
          localObject1 = (List)y.b.getOrDefault(paramView, null);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            for (paramInt1 = i1; paramInt1 < ((List)localObject1).size(); paramInt1++)
            {
              localObject3 = (View)((List)localObject1).get(paramInt1);
              localObject2 = getLayoutParamsa;
              if (localObject2 != null) {
                ((CoordinatorLayout.c)localObject2).b(paramCoordinatorLayout, (View)localObject3, paramView);
              }
            }
          }
        }
        a();
        if (paramInt3 < i) {
          paramInt1 = -1;
        } else {
          paramInt1 = 1;
        }
        a(paramCoordinatorLayout, paramView, paramInt3, paramInt1, false);
        paramInt1 = i - paramInt3;
      }
    }
    else
    {
      k = 0;
      paramInt1 = j;
    }
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.appbar.AppBarLayout.BaseBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */