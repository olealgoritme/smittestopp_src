package e.c.a.b.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import com.google.android.material.R.styleable;
import d.b.e.i0;

public class b
  extends i0
{
  public Drawable M;
  public final Rect N = new Rect();
  public final Rect O = new Rect();
  public int P = 119;
  public boolean Q = true;
  public boolean R = false;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int[] arrayOfInt = R.styleable.ForegroundLinearLayout;
    e.a(paramContext, paramAttributeSet, paramInt, 0);
    e.a(paramContext, paramAttributeSet, arrayOfInt, paramInt, 0, new int[0]);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    P = paramAttributeSet.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, P);
    paramContext = paramAttributeSet.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
    if (paramContext != null) {
      setForeground(paramContext);
    }
    Q = paramAttributeSet.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
    paramAttributeSet.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = M;
    if (localDrawable != null)
    {
      if (R)
      {
        R = false;
        Rect localRect1 = N;
        Rect localRect2 = O;
        int i = getRight() - getLeft();
        int j = getBottom() - getTop();
        if (Q) {
          localRect1.set(0, 0, i, j);
        } else {
          localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
        }
        Gravity.apply(P, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
        localDrawable.setBounds(localRect2);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    Drawable localDrawable = M;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = M;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      M.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return M;
  }
  
  public int getForegroundGravity()
  {
    return P;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = M;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    R = (paramBoolean | R);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    R = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    Drawable localDrawable = M;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(M);
      }
      M = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
        if (P == 119) {
          paramDrawable.getPadding(new Rect());
        }
      }
      else
      {
        setWillNotDraw(true);
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (P != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      P = paramInt;
      if ((paramInt == 119) && (M != null))
      {
        Rect localRect = new Rect();
        M.getPadding(localRect);
      }
      requestLayout();
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != M)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */