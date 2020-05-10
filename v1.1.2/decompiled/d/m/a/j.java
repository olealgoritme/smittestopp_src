package d.m.a;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R.id;
import androidx.fragment.R.styleable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public final class j
  extends FrameLayout
{
  public ArrayList<View> x;
  public ArrayList<View> y;
  public boolean z = true;
  
  public j(Context paramContext)
  {
    super(paramContext);
  }
  
  public j(Context paramContext, AttributeSet paramAttributeSet, p paramp)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getClassAttribute();
    Object localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FragmentContainerView);
    Object localObject2 = str;
    if (str == null) {
      localObject2 = ((TypedArray)localObject1).getString(R.styleable.FragmentContainerView_android_name);
    }
    str = ((TypedArray)localObject1).getString(R.styleable.FragmentContainerView_android_tag);
    ((TypedArray)localObject1).recycle();
    int i = getId();
    localObject1 = paramp.b(i);
    if ((localObject2 != null) && (localObject1 == null))
    {
      if (i <= 0)
      {
        if (str != null) {
          paramContext = e.a.a.a.a.b(" with tag ", str);
        } else {
          paramContext = "";
        }
        throw new IllegalStateException(e.a.a.a.a.a("FragmentContainerView must have an android:id to add Fragment ", (String)localObject2, paramContext));
      }
      localObject2 = paramp.h().a(paramContext.getClassLoader(), (String)localObject2);
      ((Fragment)localObject2).onInflate(paramContext, paramAttributeSet, null);
      paramContext = new a(paramp);
      p = true;
      mContainer = this;
      paramContext.a(getId(), (Fragment)localObject2, str, 1);
      if (!g)
      {
        h = false;
        paramAttributeSet = r;
        if ((n != null) && (!w))
        {
          paramAttributeSet.c(true);
          if (paramContext.a(y, z)) {
            b = true;
          }
          try
          {
            paramAttributeSet.c(y, z);
            paramAttributeSet.a();
          }
          finally
          {
            paramAttributeSet.a();
          }
          paramAttributeSet.e();
          c.a();
        }
      }
      else
      {
        throw new IllegalStateException("This transaction is already being added to the back stack");
      }
    }
  }
  
  public final void a(View paramView)
  {
    if (paramView.getAnimation() == null)
    {
      ArrayList localArrayList = y;
      if ((localArrayList == null) || (!localArrayList.contains(paramView))) {}
    }
    else
    {
      if (x == null) {
        x = new ArrayList();
      }
      x.add(paramView);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = paramView.getTag(R.id.fragment_container_view_tag);
    if ((localObject instanceof Fragment)) {
      localObject = (Fragment)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    Object localObject = paramView.getTag(R.id.fragment_container_view_tag);
    if ((localObject instanceof Fragment)) {
      localObject = (Fragment)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if ((z) && (x != null)) {
      for (int i = 0; i < x.size(); i++) {
        super.drawChild(paramCanvas, (View)x.get(i), getDrawingTime());
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (z)
    {
      ArrayList localArrayList = x;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (x.contains(paramView))) {
        return false;
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void endViewTransition(View paramView)
  {
    ArrayList localArrayList = y;
    if (localArrayList != null)
    {
      localArrayList.remove(paramView);
      localArrayList = x;
      if ((localArrayList != null) && (localArrayList.remove(paramView))) {
        z = true;
      }
    }
    super.endViewTransition(paramView);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    for (int i = 0; i < getChildCount(); i++) {
      getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(paramWindowInsets));
    }
    return paramWindowInsets;
  }
  
  public void removeAllViewsInLayout()
  {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      a(getChildAt(i));
    }
    super.removeAllViewsInLayout();
  }
  
  public void removeDetachedView(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramView);
    }
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeView(View paramView)
  {
    a(paramView);
    super.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    a(getChildAt(paramInt));
    super.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(View paramView)
  {
    a(paramView);
    super.removeViewInLayout(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      a(getChildAt(i));
    }
    super.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      a(getChildAt(i));
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  public void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    z = paramBoolean;
  }
  
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
  }
  
  public void startViewTransition(View paramView)
  {
    if (paramView.getParent() == this)
    {
      if (y == null) {
        y = new ArrayList();
      }
      y.add(paramView);
    }
    super.startViewTransition(paramView);
  }
}

/* Location:
 * Qualified Name:     d.m.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */