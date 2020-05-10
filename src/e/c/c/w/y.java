package e.c.c.w;

import e.a.a.a.a;
import java.lang.reflect.Modifier;

public abstract class y
{
  public static void b(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = a.a("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = a.a("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public abstract <T> T a(Class<T> paramClass);
}

/* Location:
 * Qualified Name:     base.e.c.c.w.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */