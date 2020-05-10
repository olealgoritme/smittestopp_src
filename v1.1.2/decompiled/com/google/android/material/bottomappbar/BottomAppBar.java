package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.b.a.a.a;
import d.i.i.n;
import e.c.a.b.c.b;
import e.c.a.b.c.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.b
{
  public Animator p0;
  public Animator q0;
  public int r0;
  public boolean s0;
  public boolean t0;
  
  private ActionMenuView getActionMenuView()
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
    }
    return null;
  }
  
  private float getFabTranslationX()
  {
    return b(r0);
  }
  
  private float getFabTranslationY()
  {
    boolean bool = t0;
    FloatingActionButton localFloatingActionButton = g();
    float f1 = 0.0F;
    if (localFloatingActionButton != null)
    {
      Rect localRect = new Rect();
      localFloatingActionButton.a(localRect);
      float f2 = localRect.height();
      f1 = f2;
      if (f2 == 0.0F) {
        f1 = localFloatingActionButton.getMeasuredHeight();
      }
      float f3 = localFloatingActionButton.getHeight() - bottom;
      f2 = localFloatingActionButton.getHeight() - localRect.height();
      float f4 = -getCradleVerticalOffset();
      f1 = f1 / 2.0F + f4 + f3;
      f4 = localFloatingActionButton.getPaddingBottom();
      f3 = -getMeasuredHeight();
      if (!bool) {
        f1 = f2 - f4;
      }
      f1 = f3 + f1;
    }
    return f1;
  }
  
  public final void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    int i;
    if (n.i(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 0;
    int n;
    for (int k = 0; j < getChildCount(); k = n)
    {
      View localView = getChildAt(j);
      int m;
      if (((localView.getLayoutParams() instanceof Toolbar.d)) && ((getLayoutParamsa & 0x800007) == 8388611)) {
        m = 1;
      } else {
        m = 0;
      }
      n = k;
      if (m != 0)
      {
        if (i != 0) {
          n = localView.getLeft();
        } else {
          n = localView.getRight();
        }
        n = Math.max(k, n);
      }
      j++;
    }
    if (i != 0) {
      i = paramActionMenuView.getRight();
    } else {
      i = paramActionMenuView.getLeft();
    }
    float f;
    if ((paramInt == 1) && (paramBoolean)) {
      f = k - i;
    } else {
      f = 0.0F;
    }
    paramActionMenuView.setTranslationX(f);
  }
  
  public final int b(int paramInt)
  {
    int i = n.i(this);
    int j = 0;
    int k = 1;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt == 1)
    {
      j = getMeasuredWidth() / 2;
      paramInt = k;
      if (i != 0) {
        paramInt = -1;
      }
      j = (j - 0) * paramInt;
    }
    return j;
  }
  
  public final FloatingActionButton g()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).b(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof FloatingActionButton)) {
        return (FloatingActionButton)localView;
      }
    }
    return null;
  }
  
  public ColorStateList getBackgroundTint()
  {
    throw null;
  }
  
  public CoordinatorLayout.c<BottomAppBar> getBehavior()
  {
    return new Behavior();
  }
  
  public float getCradleVerticalOffset()
  {
    throw null;
  }
  
  public int getFabAlignmentMode()
  {
    return r0;
  }
  
  public float getFabCradleMargin()
  {
    throw null;
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    throw null;
  }
  
  public boolean getHideOnScroll()
  {
    return s0;
  }
  
  public final boolean h()
  {
    FloatingActionButton localFloatingActionButton = g();
    boolean bool;
    if ((localFloatingActionButton != null) && (localFloatingActionButton.b())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Animator localAnimator = q0;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = p0;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    getFabTranslationX();
    throw null;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof a))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (a)paramParcelable;
    super.onRestoreInstanceState(x);
    r0 = z;
    t0 = A;
  }
  
  public Parcelable onSaveInstanceState()
  {
    a locala = new a(super.onSaveInstanceState());
    z = r0;
    A = t0;
    return locala;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    throw null;
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    if (paramFloat == getCradleVerticalOffset()) {
      return;
    }
    throw null;
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((r0 != paramInt) && (n.t(this)))
    {
      localObject1 = p0;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
      localObject1 = new ArrayList();
      if (!t0)
      {
        localObject2 = ObjectAnimator.ofFloat(g(), "translationX", new float[] { b(paramInt) });
        ((ObjectAnimator)localObject2).setDuration(300L);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
        p0 = ((Animator)localObject2);
        ((Animator)localObject2).addListener(new e.c.a.b.c.a(this));
        p0.start();
      }
      else
      {
        throw null;
      }
    }
    boolean bool = t0;
    if (n.t(this))
    {
      localObject1 = q0;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
      localObject1 = new ArrayList();
      int i;
      if (!h())
      {
        bool = false;
        i = 0;
      }
      else
      {
        i = paramInt;
      }
      Object localObject3 = getActionMenuView();
      if (localObject3 != null)
      {
        localObject2 = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 1.0F });
        if (((!t0) && ((!bool) || (!h()))) || ((r0 != 1) && (i != 1)))
        {
          if (((ViewGroup)localObject3).getAlpha() < 1.0F) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        else
        {
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject3, "alpha", new float[] { 0.0F });
          localObjectAnimator.addListener(new c(this, (ActionMenuView)localObject3, i, bool));
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).setDuration(150L);
          ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObjectAnimator, localObject2 });
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
      q0 = ((Animator)localObject2);
      ((Animator)localObject2).addListener(new b(this));
      q0.start();
    }
    r0 = paramInt;
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    if (paramFloat == getFabCradleMargin()) {
      return;
    }
    throw null;
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    if (paramFloat == getFabCradleRoundedCornerRadius()) {
      return;
    }
    throw null;
  }
  
  public void setFabDiameter(int paramInt)
  {
    throw null;
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    s0 = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    public final Rect d = new Rect();
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public void a(View paramView)
    {
      paramView = (BottomAppBar)paramView;
      super.a(paramView);
      paramView = BottomAppBar.a(paramView);
      if (paramView != null)
      {
        paramView.a(d);
        float f = paramView.getMeasuredHeight() - d.height();
        paramView.clearAnimation();
        paramView.animate().translationY(-paramView.getPaddingBottom() + f).setInterpolator(e.c.a.b.a.a.b).setDuration(175L);
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
    {
      paramView = (BottomAppBar)paramView;
      Object localObject = BottomAppBar.a(paramView);
      if (localObject == null)
      {
        localObject = q0;
        if ((localObject == null) || (!((Animator)localObject).isRunning()))
        {
          localObject = p0;
          if ((localObject == null) || (!((Animator)localObject).isRunning())) {}
        }
        else
        {
          i = 1;
          break label63;
        }
        int i = 0;
        label63:
        if (i != 0)
        {
          paramCoordinatorLayout.b(paramView, paramInt);
          a = paramView.getMeasuredHeight();
          return false;
        }
        BottomAppBar.b(paramView);
        throw null;
      }
      getLayoutParamsd = 17;
      BottomAppBar.a(paramView, (FloatingActionButton)localObject);
      d.set(0, 0, ((ImageButton)localObject).getMeasuredWidth(), ((ImageButton)localObject).getMeasuredHeight());
      throw null;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
    {
      paramView1 = (BottomAppBar)paramView1;
      boolean bool1 = paramView1.getHideOnScroll();
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        if (paramInt2 == 0) {
          bool1 = a(paramCoordinatorLayout, paramView1, paramView2, paramView3, paramInt1);
        } else {
          bool1 = false;
        }
        bool3 = bool2;
        if (bool1) {
          bool3 = true;
        }
      }
      return bool3;
    }
    
    public void b(View paramView)
    {
      BottomAppBar localBottomAppBar = (BottomAppBar)paramView;
      super.b(localBottomAppBar);
      paramView = BottomAppBar.a(localBottomAppBar);
      if (paramView != null)
      {
        paramView.clearAnimation();
        paramView.animate().translationY(BottomAppBar.c(localBottomAppBar)).setInterpolator(e.c.a.b.a.a.c).setDuration(225L);
      }
    }
  }
  
  public static class a
    extends d.k.a.a
  {
    public static final Parcelable.Creator<a> CREATOR = new a();
    public boolean A;
    public int z;
    
    public a(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      z = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      A = bool;
    }
    
    public a(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeInt(z);
      paramParcel.writeInt(A);
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<BottomAppBar.a>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new BottomAppBar.a(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomAppBar.a(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new BottomAppBar.a[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */