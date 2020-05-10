package d.i.c.j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public class c
  extends Drawable
  implements Drawable.Callback, b, a
{
  public static final PorterDuff.Mode D = PorterDuff.Mode.SRC_IN;
  public e A;
  public boolean B;
  public Drawable C;
  public int x;
  public PorterDuff.Mode y;
  public boolean z;
  
  public c(Drawable paramDrawable)
  {
    A = new e(A);
    a(paramDrawable);
  }
  
  public c(e parame, Resources paramResources)
  {
    A = parame;
    if (parame != null)
    {
      parame = b;
      if (parame != null) {
        a(parame.newDrawable(paramResources));
      }
    }
  }
  
  public final Drawable a()
  {
    return C;
  }
  
  public final void a(Drawable paramDrawable)
  {
    Object localObject = C;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    C = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      localObject = A;
      if (localObject != null) {
        b = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    if (!b()) {
      return false;
    }
    Object localObject = A;
    ColorStateList localColorStateList = c;
    localObject = d;
    if ((localColorStateList != null) && (localObject != null))
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if ((!z) || (i != x) || (localObject != y))
      {
        setColorFilter(i, (PorterDuff.Mode)localObject);
        x = i;
        y = ((PorterDuff.Mode)localObject);
        z = true;
        return true;
      }
    }
    else
    {
      z = false;
      clearColorFilter();
    }
    return false;
  }
  
  public boolean b()
  {
    throw null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    C.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int i = super.getChangingConfigurations();
    e locale = A;
    int j;
    if (locale != null) {
      j = locale.getChangingConfigurations();
    } else {
      j = 0;
    }
    return i | j | C.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    e locale = A;
    if (locale != null)
    {
      int i;
      if (b != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        A.a = getChangingConfigurations();
        return A;
      }
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return C.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return C.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return C.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return C.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return C.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return C.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return C.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return C.getState();
  }
  
  public Region getTransparentRegion()
  {
    return C.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return C.isAutoMirrored();
  }
  
  public boolean isStateful()
  {
    if (b())
    {
      localObject = A;
      if (localObject != null)
      {
        localObject = c;
        break label26;
      }
    }
    Object localObject = null;
    label26:
    boolean bool;
    if (((localObject != null) && (((ColorStateList)localObject).isStateful())) || (C.isStateful())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void jumpToCurrentState()
  {
    C.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    if ((!B) && (super.mutate() == this))
    {
      A = new e(A);
      Object localObject = C;
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      e locale = A;
      if (locale != null)
      {
        localObject = C;
        if (localObject != null) {
          localObject = ((Drawable)localObject).getConstantState();
        } else {
          localObject = null;
        }
        b = ((Drawable.ConstantState)localObject);
      }
      B = true;
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = C;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLevelChange(int paramInt)
  {
    return C.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    C.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    C.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    C.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    C.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    C.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    C.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = C.setState(paramArrayOfInt);
    if ((!a(paramArrayOfInt)) && (!bool)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    throw null;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!super.setVisible(paramBoolean1, paramBoolean2)) && (!C.setVisible(paramBoolean1, paramBoolean2))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.j.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */