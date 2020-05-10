package d.x;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

public final class b$g
  extends Property<View, PointF>
{
  public b$g(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Object get(Object paramObject)
  {
    paramObject = (View)paramObject;
    return null;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (View)paramObject1;
    paramObject2 = (PointF)paramObject2;
    int i = Math.round(x);
    int j = Math.round(y);
    v.a((View)paramObject1, i, j, ((View)paramObject1).getWidth() + i, ((View)paramObject1).getHeight() + j);
  }
}

/* Location:
 * Qualified Name:     d.x.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */