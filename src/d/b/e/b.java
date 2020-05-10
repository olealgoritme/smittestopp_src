package d.b.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.ActionBarContainer;

public class b
  extends Drawable
{
  public final ActionBarContainer a;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    a = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = a;
    if (E)
    {
      localObject = D;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else
    {
      localObject = B;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      ActionBarContainer localActionBarContainer = a;
      localObject = C;
      if ((localObject != null) && (F)) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Object localObject = a;
    if (E)
    {
      localObject = D;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
    else
    {
      localObject = B;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}

/* Location:
 * Qualified Name:     base.d.b.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */