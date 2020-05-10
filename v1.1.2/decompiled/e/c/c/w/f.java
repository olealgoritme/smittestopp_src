package e.c.c.w;

import e.a.a.a.a;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class f
  implements s<T>
{
  public final y a;
  
  public f(g paramg, Class paramClass, Type paramType)
  {
    try
    {
      paramg = Class.forName("sun.misc.Unsafe");
      paramClass = paramg.getDeclaredField("theUnsafe");
      paramClass.setAccessible(true);
      paramClass = paramClass.get(null);
      paramType = paramg.getMethod("allocateInstance", new Class[] { Class.class });
      paramg = new e/c/c/w/u;
      paramg.<init>(paramType, paramClass);
    }
    catch (Exception paramg)
    {
      try
      {
        paramg = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        paramg.setAccessible(true);
        int i = ((Integer)paramg.invoke(null, new Object[] { Object.class })).intValue();
        paramClass = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
        paramClass.setAccessible(true);
        paramg = new e/c/c/w/v;
        paramg.<init>(paramClass, i);
      }
      catch (Exception paramg)
      {
        try
        {
          paramClass = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          paramClass.setAccessible(true);
          paramg = new e/c/c/w/w;
          paramg.<init>(paramClass);
        }
        catch (Exception paramg)
        {
          paramg = new x();
        }
      }
    }
    a = paramg;
  }
  
  public T a()
  {
    try
    {
      localObject = a.a(b);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      Object localObject = a.a("Unable to invoke no-args constructor for ");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
      throw new RuntimeException(((StringBuilder)localObject).toString(), localException);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */