package d.b.e;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionMenuView;

import d.b.d.i.b;
import d.i.i.n;
import d.i.i.s;
import d.i.i.t;

public abstract class a
  extends ViewGroup
{
  public c A;
  public int B;
  public s C;
  public boolean D;
  public boolean E;
  public final a.a x = new a.a(this);
  public final Context y;
  public ActionMenuView z;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, paramAttributeSet, true)) && (resourceId != 0)) {
      y = new ContextThemeWrapper(paramContext, resourceId);
    } else {
      y = paramContext;
    }
  }
  
  public int a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 = (paramInt3 - j) / 2 + paramInt2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
    paramInt1 = i;
    if (paramBoolean) {
      paramInt1 = -i;
    }
    return paramInt1;
  }
  
  public s a(int paramInt, long paramLong)
  {
    Object localObject1 = C;
    if (localObject1 != null) {
      ((s)localObject1).a();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      locals = n.a(this);
      locals.a(1.0F);
      locals.a(paramLong);
      localObject1 = x;
      c.C = locals;
      b = paramInt;
      localObject2 = (View)a.get();
      if (localObject2 != null) {
        locals.a((View)localObject2, (t)localObject1);
      }
      return locals;
    }
    s locals = n.a(this);
    locals.a(0.0F);
    locals.a(paramLong);
    Object localObject2 = x;
    c.C = locals;
    b = paramInt;
    localObject1 = (View)a.get();
    if (localObject1 != null) {
      locals.a((View)localObject1, (t)localObject2);
    }
    return locals;
  }
  
  public int getAnimatedVisibility()
  {
    if (C != null) {
      return x.b;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return B;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(R.styleable.ActionBar_height, 0));
    paramConfiguration.recycle();
    paramConfiguration = A;
    if (paramConfiguration != null)
    {
      Configuration localConfiguration = y.getResources().getConfiguration();
      int i = screenWidthDp;
      int j = screenHeightDp;
      if ((smallestScreenWidthDp <= 600) && (i <= 600) && ((i <= 960) || (j <= 720)) && ((i <= 720) || (j <= 960)))
      {
        if ((i < 500) && ((i <= 640) || (j <= 480)) && ((i <= 480) || (j <= 640)))
        {
          if (i >= 360) {
            j = 3;
          } else {
            j = 2;
          }
        }
        else {
          j = 4;
        }
      }
      else {
        j = 5;
      }
      N = j;
      paramConfiguration = z;
      if (paramConfiguration != null) {
        paramConfiguration.b(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      E = false;
    }
    if (!E)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        E = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      E = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      D = false;
    }
    if (!D)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        D = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      D = false;
    }
    return true;
  }
  
  public abstract void setContentHeight(int paramInt);
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      s locals = C;
      if (locals != null) {
        locals.a();
      }
      super.setVisibility(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */