package d.x;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import d.i.i.n;

public final class v$b
  extends Property<View, Rect>
{
  public v$b(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Object get(Object paramObject)
  {
    return n.d((View)paramObject);
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    n.a((View)paramObject1, (Rect)paramObject2);
  }
}

/* Location:
 * Qualified Name:     d.x.v.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */