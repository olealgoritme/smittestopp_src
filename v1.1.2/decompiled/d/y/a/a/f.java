package d.y.a.a;

import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import d.i.c.j.a;

public abstract class f
  extends Drawable
  implements a
{
  public Drawable x;
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.applyTheme(paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public Drawable getCurrent()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getMinimumHeight()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}

/* Location:
 * Qualified Name:     d.y.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */