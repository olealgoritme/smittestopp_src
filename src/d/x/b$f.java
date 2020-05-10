package d.x;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

public final class b$f
  extends Property<View, PointF>
{
  public b$f(Class paramClass, String paramString)
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
    v.a((View)paramObject1, Math.round(x), Math.round(y), ((View)paramObject1).getRight(), ((View)paramObject1).getBottom());
  }
}

/* Location:
 * Qualified Name:     base.d.x.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */