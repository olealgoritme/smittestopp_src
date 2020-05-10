package d.m.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.e;
import d.f.h;
import e.a.a.a.a;

public class l
{
  public static final h<String, Class<?>> a = new h();
  
  public static boolean b(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      boolean bool = Fragment.class.isAssignableFrom(c(paramClassLoader, paramString));
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader) {}
    return false;
  }
  
  public static Class<?> c(ClassLoader paramClassLoader, String paramString)
  {
    Class localClass1 = (Class)a.getOrDefault(paramString, null);
    Class localClass2 = localClass1;
    if (localClass1 == null)
    {
      localClass2 = Class.forName(paramString, false, paramClassLoader);
      a.put(paramString, localClass2);
    }
    return localClass2;
  }
  
  public static Class<? extends Fragment> d(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = c(paramClassLoader, paramString);
      return paramClassLoader;
    }
    catch (ClassCastException paramClassLoader)
    {
      throw new Fragment.e(a.a("Unable to instantiate fragment ", paramString, ": make sure class is a valid subclass of Fragment"), paramClassLoader);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new Fragment.e(a.a("Unable to instantiate fragment ", paramString, ": make sure class name exists"), paramClassLoader);
    }
  }
  
  public Fragment a(ClassLoader paramClassLoader, String paramString)
  {
    throw null;
  }
}

/* Location:
 * Qualified Name:     d.m.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */