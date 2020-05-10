package d.x;

import android.graphics.PointF;
import android.util.Property;

public final class b$d
  extends Property<b.k, PointF>
{
  public b$d(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Object get(Object paramObject)
  {
    paramObject = (b.k)paramObject;
    return null;
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (b.k)paramObject1;
    paramObject2 = (PointF)paramObject2;
    if (paramObject1 != null)
    {
      c = Math.round(x);
      int i = Math.round(y);
      d = i;
      int j = g + 1;
      g = j;
      if (f == j)
      {
        v.a(e, a, b, c, i);
        f = 0;
        g = 0;
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.x.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */