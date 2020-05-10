package e.c.c.w;

import e.a.a.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class h
  implements s<T>
{
  public h(g paramg, Constructor paramConstructor) {}
  
  public T a()
  {
    try
    {
      Object localObject = a.newInstance(null);
      return (T)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = a.a("Failed to invoke ");
      localStringBuilder.append(a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = a.a("Failed to invoke ");
      localStringBuilder.append(a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */