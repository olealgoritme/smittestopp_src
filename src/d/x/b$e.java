package d.x;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

public final class b$e
  extends Property<View, PointF>
{
  public b$e(Class paramClass, String paramString)
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
    v.a((View)paramObject1, ((View)paramObject1).getLeft(), ((View)paramObject1).getTop(), Math.round(x), Math.round(y));
  }
}

/* Location:
 * Qualified Name:     base.d.x.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */