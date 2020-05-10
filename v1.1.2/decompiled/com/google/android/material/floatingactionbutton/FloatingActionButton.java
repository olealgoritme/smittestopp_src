package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.R.animator;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d.b.a.s;
import d.b.e.j;
import d.f.h;
import d.i.i.n;
import e.c.a.b.a.g;
import e.c.a.b.i.c;
import e.c.a.b.i.d;
import e.c.a.b.i.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.d(Behavior.class)
public class FloatingActionButton
  extends e.c.a.b.j.f
  implements e.c.a.b.h.a
{
  public ColorStateList A;
  public PorterDuff.Mode B;
  public ColorStateList C;
  public int D;
  public int E;
  public int F;
  public boolean G;
  public final Rect H;
  public e I;
  public ColorStateList y;
  public PorterDuff.Mode z;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0) {
        if (i == 1073741824) {
          paramInt1 = paramInt2;
        } else {
          throw new IllegalArgumentException();
        }
      }
    }
    else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  private e getImpl()
  {
    if (I == null) {
      I = new e.c.a.b.i.f(this, new b());
    }
    return I;
  }
  
  public final int a(int paramInt)
  {
    int i = E;
    if (i != 0) {
      return i;
    }
    Resources localResources = getResources();
    if (paramInt != -1)
    {
      if (paramInt != 1) {
        return localResources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
      }
      return localResources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
    }
    if (Math.max(getConfigurationscreenWidthDp, getConfigurationscreenHeightDp) < 470) {
      paramInt = a(1);
    } else {
      paramInt = a(0);
    }
    return paramInt;
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    e locale = getImpl();
    if (n == null) {
      n = new ArrayList();
    }
    n.add(paramAnimatorListener);
  }
  
  public void a(a parama, boolean paramBoolean)
  {
    e locale = getImpl();
    if (parama == null) {
      parama = null;
    } else {
      parama = new e.c.a.b.i.a(this);
    }
    int i = o.getVisibility();
    int j = 0;
    if (i == 0 ? a == 1 : a != 2) {
      j = 1;
    }
    if (j == 0)
    {
      Object localObject = b;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      if (locale.f())
      {
        localObject = d;
        if (localObject == null)
        {
          if (f == null) {
            f = g.a(o.getContext(), R.animator.design_fab_hide_motion_spec);
          }
          localObject = f;
        }
        localObject = locale.a((g)localObject, 0.0F, 0.0F, 0.0F);
        ((AnimatorSet)localObject).addListener(new e.c.a.b.i.b(locale, paramBoolean, parama));
        parama = n;
        if (parama != null)
        {
          parama = parama.iterator();
          while (parama.hasNext()) {
            ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)parama.next());
          }
        }
        ((AnimatorSet)localObject).start();
      }
      else
      {
        localObject = o;
        if (paramBoolean) {
          j = 8;
        } else {
          j = 4;
        }
        ((e.c.a.b.j.f)localObject).a(j, paramBoolean);
        if (parama != null) {
          break label244;
        }
      }
    }
    return;
    label244:
    throw null;
  }
  
  public boolean a()
  {
    throw null;
  }
  
  @Deprecated
  public boolean a(Rect paramRect)
  {
    if (!n.t(this)) {
      return false;
    }
    paramRect.set(0, 0, getWidth(), getHeight());
    throw null;
  }
  
  public void b(Animator.AnimatorListener paramAnimatorListener)
  {
    e locale = getImpl();
    if (m == null) {
      m = new ArrayList();
    }
    m.add(paramAnimatorListener);
  }
  
  public void b(a parama, boolean paramBoolean)
  {
    e locale = getImpl();
    if (parama == null) {
      parama = null;
    } else {
      parama = new e.c.a.b.i.a(this);
    }
    if (!locale.b())
    {
      Object localObject = b;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      if (locale.f())
      {
        if (o.getVisibility() != 0)
        {
          o.setAlpha(0.0F);
          o.setScaleY(0.0F);
          o.setScaleX(0.0F);
          locale.a(0.0F);
        }
        localObject = c;
        if (localObject == null)
        {
          if (e == null) {
            e = g.a(o.getContext(), R.animator.design_fab_show_motion_spec);
          }
          localObject = e;
        }
        localObject = locale.a((g)localObject, 1.0F, 1.0F, 1.0F);
        ((AnimatorSet)localObject).addListener(new c(locale, paramBoolean, parama));
        parama = m;
        if (parama != null)
        {
          parama = parama.iterator();
          while (parama.hasNext()) {
            ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)parama.next());
          }
        }
        ((AnimatorSet)localObject).start();
      }
      else
      {
        o.a(0, paramBoolean);
        o.setAlpha(1.0F);
        o.setScaleY(1.0F);
        o.setScaleX(1.0F);
        locale.a(1.0F);
        if (parama != null) {
          break label256;
        }
      }
    }
    return;
    label256:
    throw null;
  }
  
  public boolean b()
  {
    return getImpl().b();
  }
  
  public final void c()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = A;
    if (localObject == null)
    {
      s.a(localDrawable);
      return;
    }
    int i = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = B;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(j.a(i, (PorterDuff.Mode)localObject));
  }
  
  public void c(Animator.AnimatorListener paramAnimatorListener)
  {
    ArrayList localArrayList = getImpln;
    if (localArrayList != null) {
      localArrayList.remove(paramAnimatorListener);
    }
  }
  
  public void d(Animator.AnimatorListener paramAnimatorListener)
  {
    ArrayList localArrayList = getImplm;
    if (localArrayList != null) {
      localArrayList.remove(paramAnimatorListener);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return y;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return z;
  }
  
  public float getCompatElevation()
  {
    return getImpl().a();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImplj;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImplk;
  }
  
  public Drawable getContentBackground()
  {
    if (getImpl() != null) {
      return null;
    }
    throw null;
  }
  
  public int getCustomSize()
  {
    return E;
  }
  
  public int getExpandedComponentIdHint()
  {
    throw null;
  }
  
  public g getHideMotionSpec()
  {
    return getImpld;
  }
  
  @Deprecated
  public int getRippleColor()
  {
    ColorStateList localColorStateList = C;
    int i;
    if (localColorStateList != null) {
      i = localColorStateList.getDefaultColor();
    } else {
      i = 0;
    }
    return i;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return C;
  }
  
  public g getShowMotionSpec()
  {
    return getImplc;
  }
  
  public int getSize()
  {
    return D;
  }
  
  public int getSizeDimension()
  {
    return a(D);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return A;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return B;
  }
  
  public boolean getUseCompatPadding()
  {
    return G;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().c();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e locale = getImpl();
    if (locale.e())
    {
      if (u == null) {
        u = new d(locale);
      }
      o.getViewTreeObserver().addOnPreDrawListener(u);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e locale = getImpl();
    if (u != null)
    {
      o.getViewTreeObserver().removeOnPreDrawListener(u);
      u = null;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    F = ((i + 0) / 2);
    getImpl().g();
    Math.min(a(i, paramInt1), a(i, paramInt2));
    throw null;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof e.c.a.b.n.a))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (e.c.a.b.n.a)paramParcelable;
    super.onRestoreInstanceState(x);
    paramParcelable = (Bundle)z.getOrDefault("expandableWidgetHelper", null);
    throw null;
  }
  
  public Parcelable onSaveInstanceState()
  {
    new e.c.a.b.n.a(super.onSaveInstanceState());
    throw null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      a(null);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (y != paramColorStateList)
    {
      y = paramColorStateList;
      if (getImpl() == null) {
        throw null;
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (z != paramMode)
    {
      z = paramMode;
      if (getImpl() == null) {
        throw null;
      }
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    e locale = getImpl();
    if (i != paramFloat)
    {
      i = paramFloat;
      locale.a(paramFloat, j, k);
    }
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    e locale = getImpl();
    if (j != paramFloat)
    {
      j = paramFloat;
      locale.a(i, paramFloat, k);
    }
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    e locale = getImpl();
    if (k != paramFloat)
    {
      k = paramFloat;
      locale.a(i, j, paramFloat);
    }
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      E = paramInt;
      return;
    }
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    throw null;
  }
  
  public void setHideMotionSpec(g paramg)
  {
    getImpld = paramg;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(g.a(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = getImpl();
    paramDrawable.a(l);
  }
  
  public void setImageResource(int paramInt)
  {
    throw null;
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (C != paramColorStateList)
    {
      C = paramColorStateList;
      getImpl().a(C);
    }
  }
  
  public void setShowMotionSpec(g paramg)
  {
    getImplc = paramg;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(g.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    E = 0;
    if (paramInt != D)
    {
      D = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (A != paramColorStateList)
    {
      A = paramColorStateList;
      c();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (B != paramMode)
    {
      B = paramMode;
      c();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (G != paramBoolean)
    {
      G = paramBoolean;
      getImpl().d();
    }
  }
  
  public static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.c<T>
  {
    public Rect a;
    public boolean b;
    
    public BaseBehavior()
    {
      b = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      b = paramContext.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
    }
    
    public void a(CoordinatorLayout.f paramf)
    {
      if (h == 0) {
        h = 80;
      }
    }
    
    public final boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.f localf = (CoordinatorLayout.f)paramFloatingActionButton.getLayoutParams();
      if (!b) {
        return false;
      }
      if (f != paramView.getId()) {
        return false;
      }
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
    {
      paramView = (FloatingActionButton)paramView;
      Object localObject1 = paramCoordinatorLayout.a(paramView);
      int i = ((List)localObject1).size();
      int j = 0;
      Object localObject2;
      for (int k = 0; k < i; k++)
      {
        localObject2 = (View)((List)localObject1).get(k);
        if ((localObject2 instanceof AppBarLayout))
        {
          if (a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramView)) {
            break;
          }
        }
        else
        {
          ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
          boolean bool;
          if ((localLayoutParams instanceof CoordinatorLayout.f)) {
            bool = a instanceof BottomSheetBehavior;
          } else {
            bool = false;
          }
          if ((bool) && (b((View)localObject2, paramView))) {
            break;
          }
        }
      }
      paramCoordinatorLayout.b(paramView, paramInt);
      localObject1 = H;
      if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
      {
        localObject2 = (CoordinatorLayout.f)paramView.getLayoutParams();
        if (paramView.getRight() >= paramCoordinatorLayout.getWidth() - rightMargin) {
          paramInt = right;
        } else if (paramView.getLeft() <= leftMargin) {
          paramInt = -left;
        } else {
          paramInt = 0;
        }
        if (paramView.getBottom() >= paramCoordinatorLayout.getHeight() - bottomMargin)
        {
          k = bottom;
        }
        else
        {
          k = j;
          if (paramView.getTop() <= topMargin) {
            k = -top;
          }
        }
        if (k != 0) {
          n.d(paramView, k);
        }
        if (paramInt != 0) {
          n.c(paramView, paramInt);
        }
      }
      return true;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect)
    {
      paramCoordinatorLayout = (FloatingActionButton)paramView;
      paramView = H;
      paramRect.set(paramCoordinatorLayout.getLeft() + left, paramCoordinatorLayout.getTop() + top, paramCoordinatorLayout.getRight() - right, paramCoordinatorLayout.getBottom() - bottom);
      return true;
    }
    
    public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (a == null) {
        a = new Rect();
      }
      Rect localRect = a;
      e.c.a.b.j.a.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.a(null, false);
      } else {
        paramFloatingActionButton.b(null, false);
      }
      return true;
    }
    
    public final boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.f localf = (CoordinatorLayout.f)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + topMargin) {
        paramFloatingActionButton.a(null, false);
      } else {
        paramFloatingActionButton.b(null, false);
      }
      return true;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      paramView1 = (FloatingActionButton)paramView1;
      if ((paramView2 instanceof AppBarLayout))
      {
        a(paramCoordinatorLayout, (AppBarLayout)paramView2, paramView1);
      }
      else
      {
        paramCoordinatorLayout = paramView2.getLayoutParams();
        boolean bool;
        if ((paramCoordinatorLayout instanceof CoordinatorLayout.f)) {
          bool = a instanceof BottomSheetBehavior;
        } else {
          bool = false;
        }
        if (bool) {
          b(paramView2, paramView1);
        }
      }
      return false;
    }
  }
  
  public static class Behavior
    extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static abstract class a {}
  
  public class b
    implements e.c.a.b.l.b
  {
    public b() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */