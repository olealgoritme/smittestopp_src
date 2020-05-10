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
        y localy = (y)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { a });
        return localy;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("Cannot create an instance of ");
        localStringBuilder3.append(paramClass);
        throw new RuntimeException(localStringBuilder3.toString(), localInvocationTargetException);
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Cannot create an instance of ");
        localStringBuilder1.append(paramClass);
        throw new RuntimeException(localStringBuilder1.toString(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        StringBuilder localStringBuilder4 = new StringBuilder();
        localStringBuilder4.append("Cannot create an instance of ");
        localStringBuilder4.append(paramClass);
        throw new RuntimeException(localStringBuilder4.toString(), localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Cannot create an instance of ");
        localStringBuilder2.append(paramClass);
        throw new RuntimeException(localStringBuilder2.toString(), localNoSuchMethodException);
      }
    }
    return super.a(paramClass);
  }
}

/* Location:
 * Qualified Name:     base.d.o.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */