package d.x;

import android.util.Property;
import android.view.View;

public final class v$a
  extends Property<View, Float>
{
  public v$a(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Object get(Object paramObject)
  {
    return Float.valueOf(v.b((View)paramObject));
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (View)paramObject1;
    float f = ((Float)paramObject2).floatValue();
    v.a.a((View)paramObject1, f);
  }
}

/* Location:
 * Qualified Name:     base.d.x.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */