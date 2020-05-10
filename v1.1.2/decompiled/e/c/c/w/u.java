package e.c.c.w;

import java.lang.reflect.Method;

public final class u
  extends y
{
  public u(Method paramMethod, Object paramObject) {}
  
  public <T> T a(Class<T> paramClass)
  {
    y.b(paramClass);
    return (T)a.invoke(b, new Object[] { paramClass });
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */