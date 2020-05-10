package d.o;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class z
  extends c0
{
  public static z b;
  public Application a;
  
  public z(Application paramApplication)
  {
    a = paramApplication;
  }
  
  public <T extends y> T a(Class<T> paramClass)
  {
    if (a.class.isAssignableFrom(paramClass)) {
      try
      {
        localObject = (y)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { a });
        return (T)localObject;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot create an instance of ");
        ((StringBuilder)localObject).append(paramClass);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localInvocationTargetException);
      }
      catch (InstantiationException localInstantiationException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Cannot create an instance of ");
        localStringBuilder2.append(paramClass);
        throw new RuntimeException(localStringBuilder2.toString(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Cannot create an instance of ");
        localStringBuilder2.append(paramClass);
        throw new RuntimeException(localStringBuilder2.toString(), localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Cannot create an instance of ");
        localStringBuilder1.append(paramClass);
        throw new RuntimeException(localStringBuilder1.toString(), localNoSuchMethodException);
      }
    }
    return super.a(paramClass);
  }
}

/* Location:
 * Qualified Name:     d.o.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */