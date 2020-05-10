package d.e.a;

import android.content.res.ColorStateList;
import android.widget.FrameLayout;

public class a
  extends FrameLayout
{
  public static final d z = new b();
  public boolean x;
  public boolean y;
  
  public ColorStateList getCardBackgroundColor()
  {
    b localb = (b)z;
    throw null;
  }
  
  public float getCardElevation()
  {
    throw null;
  }
  
  public int getContentPaddingBottom()
  {
    throw null;
  }
  
  public int getContentPaddingLeft()
  {
    throw null;
  }
  
  public int getContentPaddingRight()
  {
    throw null;
  }
  
  public int getContentPaddingTop()
  {
    throw null;
  }
  
  public float getMaxCardElevation()
  {
    return ((b)z).b(null);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return y;
  }
  
  public float getRadius()
  {
    return ((b)z).c(null);
  }
  
  public boolean getUseCompatPadding()
  {
    return x;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    d locald = z;
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    ((b)locald).a(null, localColorStateList);
    throw null;
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    ((b)z).a(null, paramColorStateList);
    throw null;
  }
  
  public void setCardElevation(float paramFloat)
  {
    throw null;
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    ((b)z).a(null, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean == y) {
      return;
    }
    y = paramBoolean;
    b localb = (b)z;
    throw null;
  }
  
  public void setRadius(float paramFloat)
  {
    b localb = (b)z;
    throw null;
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (x == paramBoolean) {
      return;
    }
    x = paramBoolean;
    b localb = (b)z;
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.e.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */