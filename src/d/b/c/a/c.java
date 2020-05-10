package d.b.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class c
  extends Drawable
  implements Drawable.Callback
{
  public Drawable x;
  
  public c(Drawable paramDrawable)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    x = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    x.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return x.getChangingConfigurations();
  }
  
  public Drawable getCurrent()
  {
    return x.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return x.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return x.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return x.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return x.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return x.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return x.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return x.getState();
  }
  
  public Region getTransparentRegion()
  {
    return x.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return x.isAutoMirrored();
  }
  
  public boolean isStateful()
  {
    return x.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    x.jumpToCurrentState();
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    x.setBounds(paramRect);
  }
  
  public boolean onLevelChange(int paramInt)
  {
    return x.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    x.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    x.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    x.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    x.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    x.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    x.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    x.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    x.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    return x.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    x.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    x.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    x.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!super.setVisible(paramBoolean1, paramBoolean2)) && (!x.setVisible(paramBoolean1, paramBoolean2))) {
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
 * Qualified Name:     base.d.b.c.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */