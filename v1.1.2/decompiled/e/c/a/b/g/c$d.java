package e.c.a.b.g;

import android.util.Property;

public class c$d
  extends Property<c, Integer>
{
  public static final Property<c, Integer> a = new d("circularRevealScrimColor");
  
  public c$d(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public Object get(Object paramObject)
  {
    return Integer.valueOf(((c)paramObject).getCircularRevealScrimColor());
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    ((c)paramObject1).setCircularRevealScrimColor(((Integer)paramObject2).intValue());
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.g.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */