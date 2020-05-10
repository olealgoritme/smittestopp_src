package d.b.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

import d.b.a.r;

public class b
  extends Drawable
  implements Drawable.Callback
{
  public Drawable A;
  public int B = 255;
  public boolean C;
  public int D = -1;
  public boolean E;
  public Runnable F;
  public long G;
  public long H;
  public b.b I;
  public b.c x;
  public Rect y;
  public Drawable z;
  
  public static int a(Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = getDisplayMetricsdensityDpi;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    return i;
  }
  
  public b.c a()
  {
    throw null;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (I == null) {
      I = new b.b();
    }
    Object localObject1 = I;
    x = paramDrawable.getCallback();
    paramDrawable.setCallback((Drawable.Callback)localObject1);
    try
    {
      if ((x.A <= 0) && (C)) {
        paramDrawable.setAlpha(B);
      }
      if (x.E)
      {
        paramDrawable.setColorFilter(x.D);
      }
      else
      {
        if (x.H) {
          paramDrawable.setTintList(x.F);
        }
        if (x.I) {
          paramDrawable.setTintMode(x.G);
        }
      }
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(x.x);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(getLayoutDirection());
      }
      paramDrawable.setAutoMirrored(x.C);
      localObject1 = y;
      if (localObject1 != null) {
        paramDrawable.setHotspotBounds(left, top, right, bottom);
      }
      localObject1 = I;
      Drawable.Callback localCallback = x;
      x = null;
      paramDrawable.setCallback(localCallback);
      return;
    }
    finally
    {
      b.b localb = I;
      localObject1 = x;
      x = null;
      paramDrawable.setCallback((Drawable.Callback)localObject1);
    }
  }
  
  public void a(b.c paramc)
  {
    x = paramc;
    int i = D;
    if (i >= 0)
    {
      paramc = paramc.a(i);
      z = paramc;
      if (paramc != null) {
        a(paramc);
      }
    }
    A = null;
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    C = true;
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable = z;
    long l2;
    if (localDrawable != null)
    {
      l2 = G;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setAlpha(B);
          G = 0L;
        }
        else
        {
          localDrawable.setAlpha((255 - (int)((l2 - l1) * 255L) / x.A) * B / 255);
          j = 1;
          break label108;
        }
      }
    }
    else
    {
      G = 0L;
    }
    int j = 0;
    label108:
    localDrawable = A;
    if (localDrawable != null)
    {
      l2 = H;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setVisible(false, false);
          A = null;
          H = 0L;
        }
        else
        {
          localDrawable.setAlpha((int)((l2 - l1) * 255L) / x.B * B / 255);
          j = i;
        }
      }
    }
    else
    {
      H = 0L;
    }
    if ((paramBoolean) && (j != 0)) {
      scheduleSelf(F, l1 + 16L);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == D) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (x.B > 0)
    {
      localObject = A;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      localObject = z;
      if (localObject != null)
      {
        A = ((Drawable)localObject);
        H = (x.B + l);
      }
      else
      {
        A = null;
        H = 0L;
      }
    }
    else
    {
      localObject = z;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    if (paramInt >= 0)
    {
      localObject = x;
      if (paramInt < h)
      {
        localObject = ((b.c)localObject).a(paramInt);
        z = ((Drawable)localObject);
        D = paramInt;
        if (localObject == null) {
          break label191;
        }
        paramInt = x.A;
        if (paramInt > 0) {
          G = (l + paramInt);
        }
        a((Drawable)localObject);
        break label191;
      }
    }
    z = null;
    D = -1;
    label191:
    if ((G != 0L) || (H != 0L))
    {
      localObject = F;
      if (localObject == null) {
        F = new b.a(this);
      } else {
        unscheduleSelf((Runnable)localObject);
      }
      a(true);
    }
    invalidateSelf();
    return true;
  }
  
  public boolean canApplyTheme()
  {
    return x.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = z;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    localDrawable = A;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return B;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | x.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (x.a())
    {
      x.d = getChangingConfigurations();
      return x;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return z;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    Rect localRect = y;
    if (localRect != null) {
      paramRect.set(localRect);
    } else {
      super.getHotspotBounds(paramRect);
    }
  }
  
  public int getIntrinsicHeight()
  {
    Object localObject = x;
    if (l)
    {
      if (!m) {
        ((b.c)localObject).b();
      }
      return o;
    }
    localObject = z;
    int i;
    if (localObject != null) {
      i = ((Drawable)localObject).getIntrinsicHeight();
    } else {
      i = -1;
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    Object localObject = x;
    if (l)
    {
      if (!m) {
        ((b.c)localObject).b();
      }
      return n;
    }
    localObject = z;
    int i;
    if (localObject != null) {
      i = ((Drawable)localObject).getIntrinsicWidth();
    } else {
      i = -1;
    }
    return i;
  }
  
  public int getMinimumHeight()
  {
    Object localObject = x;
    if (l)
    {
      if (!m) {
        ((b.c)localObject).b();
      }
      return q;
    }
    localObject = z;
    int i;
    if (localObject != null) {
      i = ((Drawable)localObject).getMinimumHeight();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    Object localObject = x;
    if (l)
    {
      if (!m) {
        ((b.c)localObject).b();
      }
      return p;
    }
    localObject = z;
    int i;
    if (localObject != null) {
      i = ((Drawable)localObject).getMinimumWidth();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getOpacity()
  {
    Object localObject = z;
    int i = -2;
    int j = i;
    if (localObject != null) {
      if (!((Drawable)localObject).isVisible())
      {
        j = i;
      }
      else
      {
        b.c localc = x;
        if (r)
        {
          j = s;
        }
        else
        {
          localc.c();
          int k = h;
          localObject = g;
          j = i;
          if (k > 0) {
            j = localObject[0].getOpacity();
          }
          for (i = 1; i < k; i++) {
            j = Drawable.resolveOpacity(j, localObject[i].getOpacity());
          }
          s = j;
          r = true;
        }
      }
    }
    return j;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Drawable localDrawable = z;
    if (localDrawable != null) {
      localDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    b.c localc = x;
    boolean bool = i;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 1;
    int k;
    if (bool)
    {
      localObject2 = localObject1;
    }
    else if ((k == null) && (!j))
    {
      localc.c();
      Rect localRect = new Rect();
      int j = h;
      Drawable[] arrayOfDrawable = g;
      k = 0;
      while (k < j)
      {
        Object localObject3 = localObject2;
        if (arrayOfDrawable[k].getPadding(localRect))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Rect(0, 0, 0, 0);
          }
          int m = left;
          if (m > left) {
            left = m;
          }
          m = top;
          if (m > top) {
            top = m;
          }
          m = right;
          if (m > right) {
            right = m;
          }
          m = bottom;
          localObject3 = localObject1;
          if (m > bottom)
          {
            bottom = m;
            localObject3 = localObject1;
          }
        }
        k++;
        localObject2 = localObject3;
      }
      j = true;
      k = ((Rect)localObject2);
    }
    else
    {
      localObject2 = k;
    }
    if (localObject2 != null)
    {
      paramRect.set((Rect)localObject2);
      if ((left | top | bottom | right) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject2 = z;
      if (localObject2 != null) {
        bool = ((Drawable)localObject2).getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      }
    }
    if ((x.C) && (r.b(this) == 1)) {
      k = i;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      k = left;
      left = right;
      right = k;
    }
    return bool;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    b.c localc = x;
    if (localc != null)
    {
      r = false;
      t = false;
    }
    if ((paramDrawable == z) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return x.C;
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = A;
    int i = 1;
    int j;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      A = null;
      j = 1;
    }
    else
    {
      j = 0;
    }
    localDrawable = z;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      if (C) {
        z.setAlpha(B);
      }
    }
    if (H != 0L)
    {
      H = 0L;
      j = 1;
    }
    if (G != 0L)
    {
      G = 0L;
      j = i;
    }
    if (j != 0) {
      invalidateSelf();
    }
  }
  
  public Drawable mutate()
  {
    if ((!E) && (super.mutate() == this))
    {
      b.c localc = a();
      localc.d();
      a(localc);
      E = true;
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = A;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
    localDrawable = z;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b.c localc = x;
    int i = D;
    int j = h;
    Drawable[] arrayOfDrawable = g;
    int k = 0;
    boolean bool2;
    for (boolean bool1 = false; k < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (arrayOfDrawable[k] != null)
      {
        boolean bool3;
        if (Build.VERSION.SDK_INT >= 23) {
          bool3 = arrayOfDrawable[k].setLayoutDirection(paramInt);
        } else {
          bool3 = false;
        }
        bool2 = bool1;
        if (k == i) {
          bool2 = bool3;
        }
      }
      k++;
    }
    z = paramInt;
    return bool1;
  }
  
  public boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = A;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    localDrawable = z;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == z) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!C) || (B != paramInt))
    {
      C = true;
      B = paramInt;
      Drawable localDrawable = z;
      if (localDrawable != null) {
        if (G == 0L) {
          localDrawable.setAlpha(paramInt);
        } else {
          a(false);
        }
      }
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Object localObject = x;
    if (C != paramBoolean)
    {
      C = paramBoolean;
      localObject = z;
      if (localObject != null) {
        ((Drawable)localObject).setAutoMirrored(paramBoolean);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = x;
    E = true;
    if (D != paramColorFilter)
    {
      D = paramColorFilter;
      localObject = z;
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    Object localObject = x;
    if (x != paramBoolean)
    {
      x = paramBoolean;
      localObject = z;
      if (localObject != null) {
        ((Drawable)localObject).setDither(paramBoolean);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = z;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = y;
    if (localObject == null) {
      y = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      ((Rect)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = z;
    if (localObject != null) {
      ((Drawable)localObject).setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    b.c localc = x;
    H = true;
    if (F != paramColorStateList)
    {
      F = paramColorStateList;
      r.a(z, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    b.c localc = x;
    I = true;
    if (G != paramMode)
    {
      G = paramMode;
      r.a(z, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = A;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    localDrawable = z;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == z) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */