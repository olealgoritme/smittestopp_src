package e.c.c.w;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class a$a
  implements GenericArrayType, Serializable
{
  public final Type x;
  
  public a$a(Type paramType)
  {
    x = a.a(paramType);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof GenericArrayType)) && (a.a(this, (GenericArrayType)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Type getGenericComponentType()
  {
    return x;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.d(x));
    localStringBuilder.append("[]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */