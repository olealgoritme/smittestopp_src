package e.c.a.b.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public class d
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> b = new d();
  public final WeakHashMap<Drawable, Integer> a = new WeakHashMap();
  
  public d()
  {
    super(Integer.class, "drawableAlphaCompat");
  }
  
  public Object get(Object paramObject)
  {
    return Integer.valueOf(((Drawable)paramObject).getAlpha());
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    ((Drawable)paramObject1).setAlpha(((Integer)paramObject2).intValue());
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */