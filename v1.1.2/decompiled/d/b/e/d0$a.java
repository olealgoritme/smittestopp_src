package d.b.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import d.b.c.a.c;

public class d0$a
  extends c
{
  public boolean y = true;
  
  public d0$a(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (y) {
      x.draw(paramCanvas);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (y) {
      x.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (y) {
      x.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (y) {
      return x.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (y) {
      return super.setVisible(paramBoolean1, paramBoolean2);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     d.b.e.d0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */