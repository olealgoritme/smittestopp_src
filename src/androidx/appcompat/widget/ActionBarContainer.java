package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import d.b.e.b;
import d.b.e.q0;
import d.i.i.n;

public class ActionBarContainer
  extends FrameLayout
{
  public View A;
  public Drawable B;
  public Drawable C;
  public Drawable D;
  public boolean E;
  public boolean F;
  public int G;
  public boolean x;
  public View y;
  public View z;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n.a(this, new b(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    B = paramContext.getDrawable(R.styleable.ActionBar_background);
    C = paramContext.getDrawable(R.styleable.ActionBar_backgroundStacked);
    G = paramContext.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
    int i = getId();
    int j = R.id.split_action_bar;
    boolean bool = true;
    if (i == j)
    {
      E = true;
      D = paramContext.getDrawable(R.styleable.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    if (E ? D == null : (B != null) || (C != null)) {
      bool = false;
    }
    setWillNotDraw(bool);
  }
  
  public final int a(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + topMargin + bottomMargin;
  }
  
  public final boolean b(View paramView)
  {
    boolean bool;
    if ((paramView != null) && (paramView.getVisibility() != 8) && (paramView.getMeasuredHeight() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = B;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      B.setState(getDrawableState());
    }
    localDrawable = C;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      C.setState(getDrawableState());
    }
    localDrawable = D;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      D.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return y;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = B;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = C;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = D;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    z = findViewById(R.id.action_bar);
    A = findViewById(R.id.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!x) && (!super.onInterceptTouchEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = y;
    paramInt2 = 1;
    paramInt4 = 0;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    Object localObject2;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() != 8))
    {
      int i = getMeasuredHeight();
      localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      int j = ((View)localObject1).getMeasuredHeight();
      int k = bottomMargin;
      ((View)localObject1).layout(paramInt1, i - j - k, paramInt3, i - k);
    }
    if (E)
    {
      localObject1 = D;
      if (localObject1 != null)
      {
        ((Drawable)localObject1).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = 0;
      }
    }
    else
    {
      paramInt1 = paramInt4;
      if (B != null)
      {
        if (z.getVisibility() == 0)
        {
          B.setBounds(z.getLeft(), z.getTop(), z.getRight(), z.getBottom());
        }
        else
        {
          localObject2 = A;
          if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
            B.setBounds(A.getLeft(), A.getTop(), A.getRight(), A.getBottom());
          } else {
            B.setBounds(0, 0, 0, 0);
          }
        }
        paramInt1 = 1;
      }
      F = paramBoolean;
      if (paramBoolean)
      {
        localObject2 = C;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setBounds(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
          paramInt1 = paramInt2;
        }
      }
    }
    if (paramInt1 != 0) {
      invalidate();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (z == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        int j = G;
        i = paramInt2;
        if (j >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(j, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (z == null) {
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(i);
    View localView = y;
    if ((localView != null) && (localView.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (!b(z)) {
        paramInt1 = a(z);
      } else if (!b(A)) {
        paramInt1 = a(A);
      } else {
        paramInt1 = 0;
      }
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt2 = View.MeasureSpec.getSize(i);
      } else {
        paramInt2 = Integer.MAX_VALUE;
      }
      setMeasuredDimension(getMeasuredWidth(), Math.min(a(y) + paramInt1, paramInt2));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = B;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(B);
    }
    B = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable = z;
      if (paramDrawable != null) {
        B.setBounds(paramDrawable.getLeft(), z.getTop(), z.getRight(), z.getBottom());
      }
    }
    boolean bool1 = E;
    boolean bool2 = true;
    if (bool1 ? D == null : (B != null) || (C != null)) {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    invalidate();
    invalidateOutline();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = D;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(D);
    }
    D = paramDrawable;
    boolean bool1 = false;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (E)
      {
        paramDrawable = D;
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    boolean bool2;
    if (E)
    {
      bool2 = bool1;
      if (D != null) {}
    }
    else
    {
      do
      {
        bool2 = true;
        break;
        bool2 = bool1;
        if (B != null) {
          break;
        }
        bool2 = bool1;
      } while (C == null);
    }
    setWillNotDraw(bool2);
    invalidate();
    invalidateOutline();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    Drawable localDrawable = C;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(C);
    }
    C = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (F)
      {
        paramDrawable = C;
        if (paramDrawable != null) {
          paramDrawable.setBounds(y.getLeft(), y.getTop(), y.getRight(), y.getBottom());
        }
      }
    }
    boolean bool1 = E;
    boolean bool2 = true;
    if (bool1 ? D == null : (B != null) || (C != null)) {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    invalidate();
    invalidateOutline();
  }
  
  public void setTabContainer(q0 paramq0)
  {
    Object localObject = y;
    if (localObject != null) {
      removeView((View)localObject);
    }
    y = paramq0;
    if (paramq0 != null)
    {
      addView(paramq0);
      localObject = paramq0.getLayoutParams();
      width = -1;
      height = -2;
      paramq0.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    x = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 393216;
    } else {
      i = 262144;
    }
    setDescendantFocusability(i);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = B;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = C;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
    localDrawable = D;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if (((paramDrawable == B) && (!E)) || ((paramDrawable == C) && (F)) || ((paramDrawable == D) && (E)) || (super.verifyDrawable(paramDrawable))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionBarContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */