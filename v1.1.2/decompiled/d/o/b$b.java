package d.o;

import java.lang.reflect.Method;

public class b$b
{
  public final int a;
  public final Method b;
  
  public b$b(int paramInt, Method paramMethod)
  {
    a = paramInt;
    b = paramMethod;
    paramMethod.setAccessible(true);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (b.class == paramObject.getClass()))
    {
      paramObject = (b)paramObject;
      if ((a != a) || (!b.getName().equals(b.getName()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a;
    return b.getName().hashCode() + i * 31;
  }
}

/* Location:
 * Qualified Name:     d.o.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */