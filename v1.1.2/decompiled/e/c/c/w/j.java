package e.c.c.w;

import e.a.a.a.a;
import e.c.c.k;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

public class j
  implements s<T>
{
  public j(g paramg, Type paramType) {}
  
  public T a()
  {
    Object localObject = a;
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
      if ((localObject instanceof Class)) {
        return EnumSet.noneOf((Class)localObject);
      }
      localObject = a.a("Invalid EnumSet type: ");
      ((StringBuilder)localObject).append(a.toString());
      throw new k(((StringBuilder)localObject).toString());
    }
    localObject = a.a("Invalid EnumSet type: ");
    ((StringBuilder)localObject).append(a.toString());
    throw new k(((StringBuilder)localObject).toString());
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */