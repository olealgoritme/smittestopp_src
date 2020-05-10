package e.c.a.b.g;

import android.util.Property;

public class c$c
  extends Property<c, c.e>
{
  public static final Property<c, c.e> a = new c("circularReveal");
  
  public c$c(String paramString)
  {
    super(c.e.class, paramString);
  }
  
  public Object get(Object paramObject)
  {
    return ((c)paramObject).getRevealInfo();
  }
  
  public void set(Object paramObject1, Object paramObject2)
  {
    ((c)paramObject1).setRevealInfo((c.e)paramObject2);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.g.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */