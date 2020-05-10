package e.c.c.w;

import java.lang.reflect.Method;

public final class v
  extends y
{
  public v(Method paramMethod, int paramInt) {}
  
  public <T> T a(Class<T> paramClass)
  {
    y.b(paramClass);
    return (T)a.invoke(null, new Object[] { paramClass, Integer.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */