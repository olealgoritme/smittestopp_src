package e.c.a.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import d.b.e.f;
import d.i.i.n;
import e.c.a.b.j.e;

public class a
  extends f
{
  public int A;
  public PorterDuff.Mode B;
  public ColorStateList C;
  public Drawable D;
  public int E;
  public int F;
  public int G;
  public final c z;
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    Object localObject = R.styleable.MaterialButton;
    int j = R.style.Widget_MaterialComponents_Button;
    int k = 0;
    e.a(paramContext, paramAttributeSet, i, j);
    e.a(paramContext, paramAttributeSet, (int[])localObject, i, j, new int[0]);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, i, j);
    A = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    B = e.c.a.a.b.l.c.a(paramAttributeSet.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    C = e.c.a.a.b.l.c.a(getContext(), paramAttributeSet, R.styleable.MaterialButton_iconTint);
    paramContext = getContext();
    i = R.styleable.MaterialButton_icon;
    if (paramAttributeSet.hasValue(i))
    {
      j = paramAttributeSet.getResourceId(i, 0);
      if (j != 0)
      {
        paramContext = d.b.b.a.a.c(paramContext, j);
        if (paramContext != null) {
          break label151;
        }
      }
    }
    paramContext = paramAttributeSet.getDrawable(i);
    label151:
    D = paramContext;
    G = paramAttributeSet.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    E = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    localObject = new c(this);
    z = ((c)localObject);
    b = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
    c = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    d = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    e = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    f = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
    g = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    h = e.c.a.a.b.l.c.a(paramAttributeSet.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    i = e.c.a.a.b.l.c.a(a.getContext(), paramAttributeSet, R.styleable.MaterialButton_backgroundTint);
    j = e.c.a.a.b.l.c.a(a.getContext(), paramAttributeSet, R.styleable.MaterialButton_strokeColor);
    k = e.c.a.a.b.l.c.a(a.getContext(), paramAttributeSet, R.styleable.MaterialButton_rippleColor);
    l.setStyle(Paint.Style.STROKE);
    l.setStrokeWidth(g);
    paramContext = l;
    ColorStateList localColorStateList = j;
    if (localColorStateList != null) {
      k = localColorStateList.getColorForState(a.getDrawableState(), 0);
    }
    paramContext.setColor(k);
    k = n.m(a);
    i = a.getPaddingTop();
    j = a.getPaddingEnd();
    int m = a.getPaddingBottom();
    a.setInternalBackground(((c)localObject).a());
    a.setPaddingRelative(k + b, i + d, j + c, m + e);
    paramAttributeSet.recycle();
    setCompoundDrawablePadding(A);
    b();
  }
  
  public final boolean a()
  {
    c localc = z;
    boolean bool;
    if ((localc != null) && (!r)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void b()
  {
    Object localObject = D;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).mutate();
      D = ((Drawable)localObject);
      ((Drawable)localObject).setTintList(C);
      localObject = B;
      if (localObject != null) {
        D.setTintMode((PorterDuff.Mode)localObject);
      }
      int i = E;
      if (i == 0) {
        i = D.getIntrinsicWidth();
      }
      int j = E;
      if (j == 0) {
        j = D.getIntrinsicHeight();
      }
      localObject = D;
      int k = F;
      ((Drawable)localObject).setBounds(k, 0, i + k, j);
    }
    setCompoundDrawablesRelative(D, null, null, null);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    int i;
    if (a()) {
      i = z.f;
    } else {
      i = 0;
    }
    return i;
  }
  
  public Drawable getIcon()
  {
    return D;
  }
  
  public int getIconGravity()
  {
    return G;
  }
  
  public int getIconPadding()
  {
    return A;
  }
  
  public int getIconSize()
  {
    return E;
  }
  
  public ColorStateList getIconTint()
  {
    return C;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return B;
  }
  
  public ColorStateList getRippleColor()
  {
    ColorStateList localColorStateList;
    if (a()) {
      localColorStateList = z.k;
    } else {
      localColorStateList = null;
    }
    return localColorStateList;
  }
  
  public ColorStateList getStrokeColor()
  {
    ColorStateList localColorStateList;
    if (a()) {
      localColorStateList = z.j;
    } else {
      localColorStateList = null;
    }
    return localColorStateList;
  }
  
  public int getStrokeWidth()
  {
    int i;
    if (a()) {
      i = z.g;
    } else {
      i = 0;
    }
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (a()) {
      return z.i;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (a()) {
      return z.h;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      c localc = z;
      if (localc != null)
      {
        GradientDrawable localGradientDrawable = q;
        if (localGradientDrawable != null) {
          localGradientDrawable.setBounds(b, d, paramInt3 - paramInt1 - c, paramInt4 - paramInt2 - e);
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((D != null) && (G == 2))
    {
      int i = (int)getPaint().measureText(getText().toString());
      paramInt2 = E;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = D.getIntrinsicWidth();
      }
      i = (getMeasuredWidth() - i - n.l(this) - paramInt1 - A - getPaddingStart()) / 2;
      paramInt1 = n.i(this);
      paramInt2 = 1;
      if (paramInt1 != 1) {
        paramInt2 = 0;
      }
      paramInt1 = i;
      if (paramInt2 != 0) {
        paramInt1 = -i;
      }
      if (F != paramInt1)
      {
        F = paramInt1;
        b();
      }
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (a())
    {
      GradientDrawable localGradientDrawable = z.o;
      if (localGradientDrawable != null) {
        localGradientDrawable.setColor(paramInt);
      }
    }
    else
    {
      super.setBackgroundColor(paramInt);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (a())
    {
      if (paramDrawable != getBackground())
      {
        Log.i("MaterialButton", "Setting a custom background is not supported.");
        c localc = z;
        r = true;
        a.setSupportBackgroundTintList(i);
        a.setSupportBackgroundTintMode(h);
        super.setBackgroundDrawable(paramDrawable);
      }
      else
      {
        getBackground().setState(paramDrawable.getState());
      }
    }
    else {
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = d.b.b.a.a.c(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (a())
    {
      c localc = z;
      if (f != paramInt)
      {
        f = paramInt;
        if ((o != null) && (p != null) && (q != null))
        {
          if (Build.VERSION.SDK_INT == 21)
          {
            localObject1 = a.getBackground();
            Object localObject2 = null;
            if (localObject1 != null) {
              localObject1 = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
            } else {
              localObject1 = null;
            }
            f = paramInt + 1.0E-5F;
            ((GradientDrawable)localObject1).setCornerRadius(f);
            localObject1 = localObject2;
            if (a.getBackground() != null) {
              localObject1 = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
            }
            ((GradientDrawable)localObject1).setCornerRadius(f);
          }
          Object localObject1 = o;
          float f = paramInt + 1.0E-5F;
          ((GradientDrawable)localObject1).setCornerRadius(f);
          p.setCornerRadius(f);
          q.setCornerRadius(f);
        }
      }
    }
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (a()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (D != paramDrawable)
    {
      D = paramDrawable;
      b();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    G = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (A != paramInt)
    {
      A = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = d.b.b.a.a.c(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (E != paramInt)
      {
        E = paramInt;
        b();
      }
      return;
    }
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (C != paramColorStateList)
    {
      C = paramColorStateList;
      b();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (B != paramMode)
    {
      B = paramMode;
      b();
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(d.b.b.a.a.b(getContext(), paramInt));
  }
  
  public void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (a())
    {
      c localc = z;
      if (k != paramColorStateList)
      {
        k = paramColorStateList;
        if ((a.getBackground() instanceof RippleDrawable)) {
          ((RippleDrawable)a.getBackground()).setColor(paramColorStateList);
        }
      }
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (a()) {
      setRippleColor(d.b.b.a.a.b(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (a())
    {
      c localc = z;
      if (j != paramColorStateList)
      {
        j = paramColorStateList;
        Paint localPaint = l;
        int i = 0;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(a.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        if (p != null) {
          a.setInternalBackground(localc.a());
        }
      }
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (a()) {
      setStrokeColor(d.b.b.a.a.b(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (a())
    {
      c localc = z;
      if (g != paramInt)
      {
        g = paramInt;
        l.setStrokeWidth(paramInt);
        if (p != null) {
          a.setInternalBackground(localc.a());
        }
      }
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (a()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (a())
    {
      c localc = z;
      if (i != paramColorStateList)
      {
        i = paramColorStateList;
        localc.b();
      }
    }
    else if (z != null)
    {
      super.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (a())
    {
      c localc = z;
      if (h != paramMode)
      {
        h = paramMode;
        localc.b();
      }
    }
    else if (z != null)
    {
      super.setSupportBackgroundTintMode(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */