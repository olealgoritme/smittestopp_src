package e.c.c.w;

import java.lang.reflect.Method;

public final class w
  extends y
{
  public w(Method paramMethod) {}
  
  public <T> T a(Class<T> paramClass)
  {
    y.b(paramClass);
    return (T)a.invoke(null, new Object[] { paramClass, Object.class });
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */