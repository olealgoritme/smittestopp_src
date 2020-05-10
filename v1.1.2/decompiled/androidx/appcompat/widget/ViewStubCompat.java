package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.R.styleable;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  public LayoutInflater A;
  public a B;
  public int x = 0;
  public int y;
  public WeakReference<View> z;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewStubCompat, paramInt, 0);
    y = paramContext.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
    x = paramContext.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
    setId(paramContext.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  public View a()
  {
    Object localObject1 = getParent();
    if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
    {
      if (x != 0)
      {
        Object localObject2 = (ViewGroup)localObject1;
        localObject1 = A;
        if (localObject1 == null) {
          localObject1 = LayoutInflater.from(getContext());
        }
        localObject1 = ((LayoutInflater)localObject1).inflate(x, (ViewGroup)localObject2, false);
        int i = y;
        if (i != -1) {
          ((View)localObject1).setId(i);
        }
        i = ((ViewGroup)localObject2).indexOfChild(this);
        ((ViewGroup)localObject2).removeViewInLayout(this);
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        if (localLayoutParams != null) {
          ((ViewGroup)localObject2).addView((View)localObject1, i, localLayoutParams);
        } else {
          ((ViewGroup)localObject2).addView((View)localObject1, i);
        }
        z = new WeakReference(localObject1);
        localObject2 = B;
        if (localObject2 != null) {
          ((a)localObject2).a(this, (View)localObject1);
        }
        return (View)localObject1;
      }
      throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }
  
  public void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  public int getInflatedId()
  {
    return y;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return A;
  }
  
  public int getLayoutResource()
  {
    return x;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public void setInflatedId(int paramInt)
  {
    y = paramInt;
  }
  
  public void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    A = paramLayoutInflater;
  }
  
  public void setLayoutResource(int paramInt)
  {
    x = paramInt;
  }
  
  public void setOnInflateListener(a parama)
  {
    B = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    Object localObject = z;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject != null) {
        ((View)localObject).setVisibility(paramInt);
      } else {
        throw new IllegalStateException("setVisibility called on un-referenced view");
      }
    }
    else
    {
      super.setVisibility(paramInt);
      if ((paramInt == 0) || (paramInt == 4)) {
        a();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ViewStubCompat paramViewStubCompat, View paramView);
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.ViewStubCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */