package e.c.c.x;

import e.c.c.w.a.a;
import e.c.c.w.a.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class a<T>
{
  public final int hashCode;
  public final Class<? super T> rawType;
  public final Type type;
  
  public a()
  {
    Type localType = getSuperclassTypeParameter(getClass());
    type = localType;
    rawType = e.c.c.w.a.c(localType);
    hashCode = type.hashCode();
  }
  
  public a(Type paramType)
  {
    if (paramType != null)
    {
      paramType = e.c.c.w.a.a(paramType);
      type = paramType;
      rawType = e.c.c.w.a.c(paramType);
      hashCode = type.hashCode();
      return;
    }
    throw null;
  }
  
  public static AssertionError buildUnexpectedTypeError(Type paramType, Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append(paramVarArgs[j].getName());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append("but got: ");
    localStringBuilder.append(paramType.getClass().getName());
    localStringBuilder.append(", for type token: ");
    localStringBuilder.append(paramType.toString());
    localStringBuilder.append('.');
    return new AssertionError(localStringBuilder.toString());
  }
  
  public static <T> a<T> get(Class<T> paramClass)
  {
    return new a(paramClass);
  }
  
  public static a<?> get(Type paramType)
  {
    return new a(paramType);
  }
  
  public static a<?> getArray(Type paramType)
  {
    return new a(new a.a(paramType));
  }
  
  public static a<?> getParameterized(Type paramType, Type... paramVarArgs)
  {
    return new a(new a.b(null, paramType, paramVarArgs));
  }
  
  public static Type getSuperclassTypeParameter(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if (!(paramClass instanceof Class)) {
      return e.c.c.w.a.a(((ParameterizedType)paramClass).getActualTypeArguments()[0]);
    }
    throw new RuntimeException("Missing type parameter.");
  }
  
  public static boolean isAssignableFrom(Type paramType, GenericArrayType paramGenericArrayType)
  {
    Type localType = paramGenericArrayType.getGenericComponentType();
    if ((localType instanceof ParameterizedType))
    {
      if ((paramType instanceof GenericArrayType))
      {
        paramGenericArrayType = ((GenericArrayType)paramType).getGenericComponentType();
      }
      else
      {
        paramGenericArrayType = paramType;
        if ((paramType instanceof Class)) {
          for (paramType = (Class)paramType;; paramType = paramType.getComponentType())
          {
            paramGenericArrayType = paramType;
            if (!paramType.isArray()) {
              break;
            }
          }
        }
      }
      return isAssignableFrom(paramGenericArrayType, (ParameterizedType)localType, new HashMap());
    }
    return true;
  }
  
  public static boolean isAssignableFrom(Type paramType, ParameterizedType paramParameterizedType, Map<String, Type> paramMap)
  {
    int i = 0;
    if (paramType == null) {
      return false;
    }
    if (paramParameterizedType.equals(paramType)) {
      return true;
    }
    Class localClass = e.c.c.w.a.c(paramType);
    ParameterizedType localParameterizedType = null;
    if ((paramType instanceof ParameterizedType)) {
      localParameterizedType = (ParameterizedType)paramType;
    }
    if (localParameterizedType != null)
    {
      Type[] arrayOfType = localParameterizedType.getActualTypeArguments();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      for (j = 0; j < arrayOfType.length; j++)
      {
        paramType = arrayOfType[j];
        TypeVariable localTypeVariable = arrayOfTypeVariable[j];
        while ((paramType instanceof TypeVariable)) {
          paramType = (Type)paramMap.get(((TypeVariable)paramType).getName());
        }
        paramMap.put(localTypeVariable.getName(), paramType);
      }
      if (typeEquals(localParameterizedType, paramParameterizedType, paramMap)) {
        return true;
      }
    }
    paramType = localClass.getGenericInterfaces();
    int k = paramType.length;
    for (int j = i; j < k; j++) {
      if (isAssignableFrom(paramType[j], paramParameterizedType, new HashMap(paramMap))) {
        return true;
      }
    }
    return isAssignableFrom(localClass.getGenericSuperclass(), paramParameterizedType, new HashMap(paramMap));
  }
  
  public static boolean matches(Type paramType1, Type paramType2, Map<String, Type> paramMap)
  {
    boolean bool;
    if ((!paramType2.equals(paramType1)) && ((!(paramType1 instanceof TypeVariable)) || (!paramType2.equals(paramMap.get(((TypeVariable)paramType1).getName()))))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean typeEquals(ParameterizedType paramParameterizedType1, ParameterizedType paramParameterizedType2, Map<String, Type> paramMap)
  {
    if (paramParameterizedType1.getRawType().equals(paramParameterizedType2.getRawType()))
    {
      paramParameterizedType1 = paramParameterizedType1.getActualTypeArguments();
      paramParameterizedType2 = paramParameterizedType2.getActualTypeArguments();
      for (int i = 0; i < paramParameterizedType1.length; i++) {
        if (!matches(paramParameterizedType1[i], paramParameterizedType2[i], paramMap)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof a)) && (e.c.c.w.a.a(type, type))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final Class<? super T> getRawType()
  {
    return rawType;
  }
  
  public final Type getType()
  {
    return type;
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  @Deprecated
  public boolean isAssignableFrom(a<?> parama)
  {
    return isAssignableFrom(parama.getType());
  }
  
  @Deprecated
  public boolean isAssignableFrom(Class<?> paramClass)
  {
    return isAssignableFrom(paramClass);
  }
  
  @Deprecated
  public boolean isAssignableFrom(Type paramType)
  {
    boolean bool1 = false;
    if (paramType == null) {
      return false;
    }
    if (type.equals(paramType)) {
      return true;
    }
    Type localType = type;
    if ((localType instanceof Class)) {
      return rawType.isAssignableFrom(e.c.c.w.a.c(paramType));
    }
    if ((localType instanceof ParameterizedType)) {
      return isAssignableFrom(paramType, (ParameterizedType)localType, new HashMap());
    }
    if ((localType instanceof GenericArrayType))
    {
      boolean bool2 = bool1;
      if (rawType.isAssignableFrom(e.c.c.w.a.c(paramType)))
      {
        bool2 = bool1;
        if (isAssignableFrom(paramType, (GenericArrayType)type)) {
          bool2 = true;
        }
      }
      return bool2;
    }
    throw buildUnexpectedTypeError(localType, new Class[] { Class.class, ParameterizedType.class, GenericArrayType.class });
  }
  
  public final String toString()
  {
    return e.c.c.w.a.d(type);
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.x.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */