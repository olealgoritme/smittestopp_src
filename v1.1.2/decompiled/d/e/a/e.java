package d.e.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class e
  extends Drawable
{
  public float a;
  public float b;
  public boolean c;
  public boolean d;
  public ColorStateList e;
  public PorterDuffColorFilter f;
  public ColorStateList g;
  public PorterDuff.Mode h;
  
  public final PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public final void a(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    int i = left;
    throw null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (f == null)
    {
      float f1 = a;
      paramCanvas.drawRoundRect(null, f1, f1, null);
      return;
    }
    throw null;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(null, a);
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = g;
    if ((localColorStateList == null) || (!localColorStateList.isStateful()))
    {
      localColorStateList = e;
      if (((localColorStateList == null) || (!localColorStateList.isStateful())) && (!super.isStateful())) {}
    }
    else
    {
      return true;
    }
    boolean bool = false;
    return bool;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a(paramRect);
    throw null;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = e;
    localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
    throw null;
  }
  
  public void setAlpha(int paramInt)
  {
    throw null;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    throw null;
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    g = paramColorStateList;
    f = a(paramColorStateList, h);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    h = paramMode;
    f = a(g, paramMode);
    invalidateSelf();
  }
}

/* Location:
 * Qualified Name:     d.e.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */