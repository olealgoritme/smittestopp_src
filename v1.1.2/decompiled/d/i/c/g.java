package d.i.c;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g
  extends f
{
  public Typeface b(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(g, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)m.invoke(null, new Object[] { localObject, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException((Throwable)paramObject);
  }
  
  public Method c(Class<?> paramClass)
  {
    Class localClass = Array.newInstance(paramClass, 1).getClass();
    paramClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { localClass, String.class, paramClass, paramClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
}

/* Location:
 * Qualified Name:     d.i.c.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */