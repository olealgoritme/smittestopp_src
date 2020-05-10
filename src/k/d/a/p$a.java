package k.d.a;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k.d.a.s.a;

public class p$a
{
  public final List<o> a = new ArrayList();
  public final Map<Class, Object> b = new HashMap();
  public final Map<String, Class> c = new HashMap();
  public final StringBuilder d = new StringBuilder(128);
  public Class<?> e;
  public boolean f;
  public a g;
  
  public void a()
  {
    if (f)
    {
      e = null;
    }
    else
    {
      Object localObject = e.getSuperclass();
      e = ((Class)localObject);
      localObject = ((Class)localObject).getName();
      if ((((String)localObject).startsWith("java.")) || (((String)localObject).startsWith("javax.")) || (((String)localObject).startsWith("android.")) || (((String)localObject).startsWith("androidx."))) {
        e = null;
      }
    }
  }
  
  public boolean a(Method paramMethod, Class<?> paramClass)
  {
    Object localObject = b.put(paramClass, paramMethod);
    if (localObject == null) {
      return true;
    }
    if ((localObject instanceof Method)) {
      if (b((Method)localObject, paramClass)) {
        b.put(paramClass, this);
      } else {
        throw new IllegalStateException();
      }
    }
    return b(paramMethod, paramClass);
  }
  
  public final boolean b(Method paramMethod, Class<?> paramClass)
  {
    d.setLength(0);
    d.append(paramMethod.getName());
    Object localObject = d;
    ((StringBuilder)localObject).append('>');
    ((StringBuilder)localObject).append(paramClass.getName());
    paramClass = d.toString();
    localObject = paramMethod.getDeclaringClass();
    paramMethod = (Class)c.put(paramClass, localObject);
    if ((paramMethod != null) && (!paramMethod.isAssignableFrom((Class)localObject)))
    {
      c.put(paramClass, paramMethod);
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.p.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */