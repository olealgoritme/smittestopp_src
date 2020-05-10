package e.c.c.w;

import e.c.a.a.b.l.c;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class a$b
  implements ParameterizedType, Serializable
{
  public final Type x;
  public final Type y;
  public final Type[] z;
  
  public a$b(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool1 = paramType2 instanceof Class;
    int i = 0;
    if (bool1)
    {
      Class localClass = (Class)paramType2;
      bool1 = Modifier.isStatic(localClass.getModifiers());
      boolean bool2 = true;
      if ((!bool1) && (localClass.getEnclosingClass() != null)) {
        j = 0;
      } else {
        j = 1;
      }
      bool1 = bool2;
      if (paramType1 == null) {
        if (j != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      c.a(bool1);
    }
    if (paramType1 == null) {
      paramType1 = null;
    } else {
      paramType1 = a.a(paramType1);
    }
    x = paramType1;
    y = a.a(paramType2);
    paramType1 = (Type[])paramVarArgs.clone();
    z = paramType1;
    int k = paramType1.length;
    for (int j = i; j < k; j++)
    {
      c.a(z[j]);
      a.b(z[j]);
      paramType1 = z;
      paramType1[j] = a.a(paramType1[j]);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof ParameterizedType)) && (a.a(this, (ParameterizedType)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])z.clone();
  }
  
  public Type getOwnerType()
  {
    return x;
  }
  
  public Type getRawType()
  {
    return y;
  }
  
  public int hashCode()
  {
    int i = Arrays.hashCode(z);
    int j = y.hashCode();
    Type localType = x;
    int k;
    if (localType != null) {
      k = localType.hashCode();
    } else {
      k = 0;
    }
    return i ^ j ^ k;
  }
  
  public String toString()
  {
    int i = z.length;
    if (i == 0) {
      return a.d(y);
    }
    StringBuilder localStringBuilder = new StringBuilder((i + 1) * 30);
    localStringBuilder.append(a.d(y));
    localStringBuilder.append("<");
    localStringBuilder.append(a.d(z[0]));
    for (int j = 1; j < i; j++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(a.d(z[j]));
    }
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */