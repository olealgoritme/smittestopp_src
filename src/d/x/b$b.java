package d.x;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

public final class b$b
  extends Property<Drawable, PointF>
{
  public Rect a = new Rect();
  
  public b$b(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Object get(Object paramObject)
  {
    ((Drawable)paramObject).copyBounds(a);
    paramObject = a;
    return new PointF(left, top);
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Drawable)paramObject1;
    paramObject2 = (PointF)paramObject2;
    ((Drawable)paramObject1).copyBounds(a);
    a.offsetTo(Math.round(x), Math.round(y));
    ((Drawable)paramObject1).setBounds(a);
  }
}

/* Location:
 * Qualified Name:     base.d.x.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */