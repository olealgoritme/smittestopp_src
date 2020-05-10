package j.a.a;

import java.lang.reflect.Method;

public class h
  extends ClassLoader
{
  public static final String a = c.class.getName();
  public static final Class<?>[] b;
  
  static
  {
    Class localClass = Integer.TYPE;
    b = new Class[] { String.class, byte[].class, localClass, localClass };
  }
  
  public h(ClassLoader paramClassLoader)
  {
    super(paramClassLoader);
  }
  
  public Class<?> a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = ClassLoader.class.getDeclaredMethod("defineClass", b);
      ((Method)localObject).setAccessible(true);
      localObject = (Class)((Method)localObject).invoke(getParent(), new Object[] { paramString, paramArrayOfByte, Integer.valueOf(0), Integer.valueOf(paramArrayOfByte.length) });
      return (Class<?>)localObject;
    }
    catch (Exception localException) {}
    return defineClass(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    try
    {
      if (paramString.equals(a)) {
        return c.class;
      }
      paramString = super.loadClass(paramString, paramBoolean);
      return paramString;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     j.a.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */