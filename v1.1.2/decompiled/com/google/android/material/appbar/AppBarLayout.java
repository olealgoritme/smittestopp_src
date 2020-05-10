package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.attr;
import com.google.android.material.R.integer;
import com.google.android.material.R.styleable;
import d.b.a.s;
import d.f.h;
import d.i.i.f;
import d.i.i.n;
import e.c.a.b.b.b;
import e.c.a.b.b.c;
import e.c.a.b.b.d;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  public boolean A;
  public int B;
  public boolean C;
  public boolean D;
  public boolean E;
  public int[] F;
  public int x;
  public int y;
  public int z;
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    int j;
    if (paramBoolean2) {
      j = 4;
    } else {
      j = 0;
    }
    B = (i | j | 0x8);
    requestLayout();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (D != paramBoolean)
    {
      D = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new a(-1, -2);
  }
  
  public LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new a(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }
  
  public LinearLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }
  
  public a generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
      return new a((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new a((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new a(paramLayoutParams);
  }
  
  public int getDownNestedPreScrollRange()
  {
    int i = y;
    if (i != -1) {
      return i;
    }
    int j = getChildCount() - 1;
    for (int k = 0; j >= 0; k = i)
    {
      View localView = getChildAt(j);
      a locala = (a)localView.getLayoutParams();
      int m = localView.getMeasuredHeight();
      i = a;
      if ((i & 0x5) == 5)
      {
        k = topMargin + bottomMargin + k;
        if ((i & 0x8) != 0)
        {
          i = n.j(localView) + k;
        }
        else
        {
          if ((i & 0x2) != 0) {
            i = n.j(localView);
          } else {
            i = getTopInset();
          }
          i = m - i + k;
        }
      }
      else
      {
        i = k;
        if (k > 0) {
          break;
        }
      }
      j--;
    }
    i = Math.max(0, k);
    y = i;
    return i;
  }
  
  public int getDownNestedScrollRange()
  {
    int i = z;
    if (i != -1) {
      return i;
    }
    int j = getChildCount();
    int k = 0;
    i = 0;
    int m;
    for (;;)
    {
      m = i;
      if (k >= j) {
        break;
      }
      View localView = getChildAt(k);
      a locala = (a)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = topMargin;
      int i2 = bottomMargin;
      int i3 = a;
      m = i;
      if ((i3 & 0x1) == 0) {
        break;
      }
      i += i1 + i2 + n;
      if ((i3 & 0x2) != 0)
      {
        k = n.j(localView);
        m = i - (getTopInset() + k);
        break;
      }
      k++;
    }
    i = Math.max(0, m);
    z = i;
    return i;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i = getTopInset();
    int j = n.j(this);
    if (j != 0) {}
    do
    {
      return j * 2 + i;
      j = getChildCount();
      if (j >= 1) {
        j = getChildAt(j - 1).getMinimumHeight();
      } else {
        j = 0;
      }
    } while (j != 0);
    return getHeight() / 3;
  }
  
  public int getPendingAction()
  {
    return B;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  public final int getTopInset()
  {
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    int i = x;
    if (i != -1) {
      return i;
    }
    int j = getChildCount();
    int k = 0;
    i = 0;
    int m;
    for (;;)
    {
      m = i;
      if (k >= j) {
        break;
      }
      View localView = getChildAt(k);
      a locala = (a)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int i1 = a;
      m = i;
      if ((i1 & 0x1) == 0) {
        break;
      }
      i += n + topMargin + bottomMargin;
      if ((i1 & 0x2) != 0)
      {
        m = i - n.j(localView);
        break;
      }
      k++;
    }
    i = Math.max(0, m - getTopInset());
    x = i;
    return i;
  }
  
  public int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (F == null) {
      F = new int[4];
    }
    int[] arrayOfInt1 = F;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (C) {
      paramInt = R.attr.state_liftable;
    } else {
      paramInt = -R.attr.state_liftable;
    }
    arrayOfInt1[0] = paramInt;
    if ((C) && (D)) {
      paramInt = R.attr.state_lifted;
    } else {
      paramInt = -R.attr.state_lifted;
    }
    arrayOfInt1[1] = paramInt;
    if (C) {
      paramInt = R.attr.state_collapsible;
    } else {
      paramInt = -R.attr.state_collapsible;
    }
    arrayOfInt1[2] = paramInt;
    if ((C) && (D)) {
      paramInt = R.attr.state_collapsed;
    } else {
      paramInt = -R.attr.state_collapsed;
    }
    arrayOfInt1[3] = paramInt;
    return LinearLayout.mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    x = -1;
    y = -1;
    z = -1;
    paramBoolean = false;
    A = false;
    paramInt2 = getChildCount();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      if (getChildAtgetLayoutParamsb != null)
      {
        A = true;
        break;
      }
    }
    if (!E)
    {
      paramInt3 = getChildCount();
      for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
      {
        paramInt2 = getChildAtgetLayoutParamsa;
        if (((paramInt2 & 0x1) == 1) && ((paramInt2 & 0xA) != 0)) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        if (paramInt2 != 0)
        {
          paramInt1 = 1;
          break label150;
        }
      }
      paramInt1 = 0;
      label150:
      if (paramInt1 == 0) {}
    }
    else
    {
      paramBoolean = true;
    }
    if (C != paramBoolean)
    {
      C = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    x = -1;
    y = -1;
    z = -1;
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    a(paramBoolean, n.t(this));
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    int i = getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int j = R.attr.state_liftable;
    int k = -R.attr.state_lifted;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "elevation", new float[] { 0.0F });
    long l = i;
    localObjectAnimator = localObjectAnimator.setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766, j, k }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this, "elevation", new float[] { paramFloat }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842766 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    setStateListAnimator(localStateListAnimator);
  }
  
  public static class BaseBehavior<T extends AppBarLayout>
    extends b<T>
  {
    public int k;
    public int l;
    public ValueAnimator m;
    public int n = -1;
    public boolean o;
    public float p;
    public WeakReference<View> q;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
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
          paramCoordinatorLayout = new a(paramView);
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
      if ((paramParcelable instanceof a))
      {
        paramCoordinatorLayout = (a)paramParcelable;
        paramView = x;
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
        View localView = paramT.getChildAt(i1);
        localObject = (AppBarLayout.a)localView.getLayoutParams();
        i2 = a;
        if ((i2 & 0x11) == 17)
        {
          i3 = -localView.getTop();
          i4 = -localView.getBottom();
          i5 = i4;
          if (i1 == paramT.getChildCount() - 1) {
            i5 = i4 + paramT.getTopInset();
          }
          if (a(i2, 2))
          {
            i1 = i5 + n.j(localView);
            i4 = i3;
          }
          else
          {
            i4 = i3;
            i1 = i5;
            if (a(i2, 5))
            {
              i1 = n.j(localView) + i5;
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
          a(paramCoordinatorLayout, paramT, s.a(i1, -paramT.getTotalScrollRange(), 0), 0.0F);
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
        boolean bool1;
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
        bool2 = paramT.a(bool2);
        if (!paramBoolean)
        {
          if (bool2)
          {
            paramCoordinatorLayout = paramCoordinatorLayout.b(paramT);
            i2 = paramCoordinatorLayout.size();
            for (paramInt1 = 0;; paramInt1++)
            {
              paramInt2 = i1;
              if (paramInt1 >= i2) {
                break;
              }
              localObject2 = getgetLayoutParamsa;
              if ((localObject2 instanceof AppBarLayout.ScrollingViewBehavior))
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
      AppBarLayout localAppBarLayout = (AppBarLayout)paramView;
      super.a(paramCoordinatorLayout, localAppBarLayout, paramInt);
      int i = localAppBarLayout.getPendingAction();
      paramInt = n;
      if ((paramInt >= 0) && ((i & 0x8) == 0))
      {
        paramView = localAppBarLayout.getChildAt(paramInt);
        i = -paramView.getBottom();
        if (o)
        {
          paramInt = paramView.getMinimumHeight();
          paramInt = localAppBarLayout.getTopInset() + paramInt + i;
        }
        else
        {
          paramInt = Math.round(paramView.getHeight() * p) + i;
        }
        c(paramCoordinatorLayout, localAppBarLayout, paramInt);
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
          i = -localAppBarLayout.getUpNestedPreScrollRange();
          if (paramInt != 0) {
            a(paramCoordinatorLayout, localAppBarLayout, i, 0.0F);
          } else {
            c(paramCoordinatorLayout, localAppBarLayout, i);
          }
        }
        else if ((i & 0x1) != 0)
        {
          if (paramInt != 0) {
            a(paramCoordinatorLayout, localAppBarLayout, 0, 0.0F);
          } else {
            c(paramCoordinatorLayout, localAppBarLayout, 0);
          }
        }
      }
      B = 0;
      n = -1;
      a(s.a(a(), -localAppBarLayout.getTotalScrollRange(), 0));
      a(paramCoordinatorLayout, localAppBarLayout, a(), 0, true);
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
        paramInt3 = s.a(paramInt1, paramInt2, paramInt3);
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
    
    public static class a
      extends d.k.a.a
    {
      public static final Parcelable.Creator<a> CREATOR = new a();
      public float A;
      public boolean B;
      public int z;
      
      public a(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        z = paramParcel.readInt();
        A = paramParcel.readFloat();
        boolean bool;
        if (paramParcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        B = bool;
      }
      
      public a(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeParcelable(x, paramInt);
        paramParcel.writeInt(z);
        paramParcel.writeFloat(A);
        paramParcel.writeByte((byte)B);
      }
      
      public static final class a
        implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.a>
      {
        public Object createFromParcel(Parcel paramParcel)
        {
          return new AppBarLayout.BaseBehavior.a(paramParcel, null);
        }
        
        public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
        {
          return new AppBarLayout.BaseBehavior.a(paramParcel, paramClassLoader);
        }
        
        public Object[] newArray(int paramInt)
        {
          return new AppBarLayout.BaseBehavior.a[paramInt];
        }
      }
    }
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static class ScrollingViewBehavior
    extends c
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      g = paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
      paramContext.recycle();
    }
    
    public AppBarLayout a(List<View> paramList)
    {
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)paramList.get(j);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
      }
      return null;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = a(paramCoordinatorLayout.a(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = d;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          localAppBarLayout.a(false, paramBoolean ^ true);
          return true;
        }
      }
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      paramCoordinatorLayout = getLayoutParamsa;
      if ((paramCoordinatorLayout instanceof AppBarLayout.BaseBehavior))
      {
        paramCoordinatorLayout = (AppBarLayout.BaseBehavior)paramCoordinatorLayout;
        n.d(paramView1, paramView2.getBottom() - paramView1.getTop() + k + f - a(paramView2));
      }
      if ((paramView2 instanceof AppBarLayout))
      {
        paramCoordinatorLayout = (AppBarLayout)paramView2;
        if (E)
        {
          boolean bool;
          if (paramView1.getScrollY() > 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramCoordinatorLayout.a(bool);
        }
      }
      return false;
    }
  }
  
  public static class a
    extends LinearLayout.LayoutParams
  {
    public int a = 1;
    public Interpolator b;
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_Layout);
      a = paramAttributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
        b = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public a(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */