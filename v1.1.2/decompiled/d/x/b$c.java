package d.x;

import android.graphics.PointF;
import android.util.Property;

public final class b$c
  extends Property<b.k, PointF>
{
  public b$c(Class paramClass, String paramString)
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
      a = Math.round(x);
      int i = Math.round(y);
      b = i;
      int j = f + 1;
      f = j;
      if (j == g)
      {
        v.a(e, a, i, c, d);
        f = 0;
        g = 0;
      }
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.x.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */