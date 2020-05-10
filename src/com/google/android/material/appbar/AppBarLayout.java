package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import com.google.android.material.R.attr;
import com.google.android.material.R.integer;
import d.i.i.n;

@CoordinatorLayout.d(AppBarLayout.Behavior.class)
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
    return paramLayoutParams instanceof AppBarLayout.a;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new AppBarLayout.a(-1, -2);
  }
  
  public LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new AppBarLayout.a(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new AppBarLayout.a(getContext(), paramAttributeSet);
  }
  
  public LinearLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new AppBarLayout.a(getContext(), paramAttributeSet);
  }
  
  public AppBarLayout.a generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
      return new AppBarLayout.a((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new AppBarLayout.a((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new AppBarLayout.a(paramLayoutParams);
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
      AppBarLayout.a locala = (AppBarLayout.a)localView.getLayoutParams();
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
      AppBarLayout.a locala = (AppBarLayout.a)localView.getLayoutParams();
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
      AppBarLayout.a locala = (AppBarLayout.a)localView.getLayoutParams();
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
}

/* Location:
 * Qualified Name:     base.com.google.android.material.appbar.AppBarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */