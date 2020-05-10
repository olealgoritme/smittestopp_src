package e.c.c.w;

import e.c.a.a.b.l.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public final class a
{
  public static final Type[] a = new Type[0];
  
  public static Type a(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      paramType = localClass;
      if (localClass.isArray()) {
        paramType = new a.a(a(localClass.getComponentType()));
      }
      return paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      return new a.b(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType)) {
      return new a.a(((GenericArrayType)paramType).getGenericComponentType());
    }
    if ((paramType instanceof WildcardType))
    {
      paramType = (WildcardType)paramType;
      return new a.c(paramType.getUpperBounds(), paramType.getLowerBounds());
    }
    return paramType;
  }
  
  public static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {
      return paramType;
    }
    if (paramClass2.isInterface())
    {
      paramType = paramClass1.getInterfaces();
      int i = 0;
      int j = paramType.length;
      while (i < j)
      {
        if (paramType[i] == paramClass2) {
          return paramClass1.getGenericInterfaces()[i];
        }
        if (paramClass2.isAssignableFrom(paramType[i])) {
          return a(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
        }
        i++;
      }
    }
    if (!paramClass1.isInterface()) {
      while (paramClass1 != Object.class)
      {
        paramType = paramClass1.getSuperclass();
        if (paramType == paramClass2) {
          return paramClass1.getGenericSuperclass();
        }
        if (paramClass2.isAssignableFrom(paramType)) {
          return a(paramClass1.getGenericSuperclass(), paramType, paramClass2);
        }
        paramClass1 = paramType;
      }
    }
    return paramClass2;
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    return a(paramType1, paramClass, paramType2, new HashSet());
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection)
  {
    int i;
    int j;
    Object localObject1;
    int k;
    label157:
    do
    {
      boolean bool = paramType2 instanceof TypeVariable;
      i = 0;
      j = 0;
      if (!bool) {
        break;
      }
      localObject1 = (TypeVariable)paramType2;
      if (paramCollection.contains(localObject1)) {
        return paramType2;
      }
      paramCollection.add(localObject1);
      paramType2 = ((TypeVariable)localObject1).getGenericDeclaration();
      if ((paramType2 instanceof Class)) {
        paramType2 = (Class)paramType2;
      } else {
        paramType2 = null;
      }
      if (paramType2 != null)
      {
        localObject2 = a(paramType1, paramClass, paramType2);
        if ((localObject2 instanceof ParameterizedType))
        {
          paramType2 = paramType2.getTypeParameters();
          k = paramType2.length;
          while (j < k)
          {
            if (localObject1.equals(paramType2[j]))
            {
              localObject2 = ((ParameterizedType)localObject2).getActualTypeArguments()[j];
              break label157;
            }
            j++;
          }
          throw new NoSuchElementException();
        }
      }
      localObject2 = localObject1;
      paramType2 = (Type)localObject2;
    } while (localObject2 != localObject1);
    return (Type)localObject2;
    if ((paramType2 instanceof Class))
    {
      localObject2 = (Class)paramType2;
      if (((Class)localObject2).isArray())
      {
        paramType2 = ((Class)localObject2).getComponentType();
        paramType1 = a(paramType1, paramClass, paramType2, paramCollection);
        if (paramType2 == paramType1) {
          paramType1 = (Type)localObject2;
        } else {
          paramType1 = new a.a(paramType1);
        }
        return paramType1;
      }
    }
    if ((paramType2 instanceof GenericArrayType))
    {
      paramType2 = (GenericArrayType)paramType2;
      localObject2 = paramType2.getGenericComponentType();
      paramType1 = a(paramType1, paramClass, (Type)localObject2, paramCollection);
      if (localObject2 == paramType1) {
        paramType1 = paramType2;
      } else {
        paramType1 = new a.a(paramType1);
      }
      return paramType1;
    }
    Object localObject3;
    if ((paramType2 instanceof ParameterizedType))
    {
      localObject1 = (ParameterizedType)paramType2;
      paramType2 = ((ParameterizedType)localObject1).getOwnerType();
      localObject3 = a(paramType1, paramClass, paramType2, paramCollection);
      if (localObject3 != paramType2) {
        j = 1;
      } else {
        j = 0;
      }
      paramType2 = ((ParameterizedType)localObject1).getActualTypeArguments();
      int m = paramType2.length;
      while (i < m)
      {
        Type localType = a(paramType1, paramClass, paramType2[i], paramCollection);
        k = j;
        localObject2 = paramType2;
        if (localType != paramType2[i])
        {
          k = j;
          localObject2 = paramType2;
          if (j == 0)
          {
            localObject2 = (Type[])paramType2.clone();
            k = 1;
          }
          localObject2[i] = localType;
        }
        i++;
        j = k;
        paramType2 = (Type)localObject2;
      }
      paramType1 = (Type)localObject1;
      if (j != 0) {
        paramType1 = new a.b((Type)localObject3, ((ParameterizedType)localObject1).getRawType(), paramType2);
      }
      return paramType1;
    }
    Object localObject2 = paramType2;
    if ((paramType2 instanceof WildcardType))
    {
      paramType2 = (WildcardType)paramType2;
      localObject3 = paramType2.getLowerBounds();
      localObject1 = paramType2.getUpperBounds();
      if (localObject3.length == 1)
      {
        paramType1 = a(paramType1, paramClass, localObject3[0], paramCollection);
        localObject2 = paramType2;
        if (paramType1 != localObject3[0])
        {
          if ((paramType1 instanceof WildcardType)) {
            paramType1 = ((WildcardType)paramType1).getLowerBounds();
          } else {
            paramType1 = new Type[] { paramType1 };
          }
          return new a.c(new Type[] { Object.class }, paramType1);
        }
      }
      else
      {
        localObject2 = paramType2;
        if (localObject1.length == 1)
        {
          localObject2 = localObject1[0];
          try
          {
            paramType1 = a(paramType1, paramClass, (Type)localObject2, paramCollection);
            localObject2 = paramType2;
            if (paramType1 != localObject1[0])
            {
              if ((paramType1 instanceof WildcardType)) {
                paramType1 = ((WildcardType)paramType1).getUpperBounds();
              } else {
                paramType1 = new Type[] { paramType1 };
              }
              return new a.c(paramType1, a);
            }
          }
          finally {}
        }
      }
    }
    return (Type)localObject2;
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramType1 == paramType2) {
      return true;
    }
    if ((paramType1 instanceof Class)) {
      return paramType1.equals(paramType2);
    }
    if ((paramType1 instanceof ParameterizedType))
    {
      if (!(paramType2 instanceof ParameterizedType)) {
        return false;
      }
      paramType1 = (ParameterizedType)paramType1;
      ParameterizedType localParameterizedType = (ParameterizedType)paramType2;
      paramType2 = paramType1.getOwnerType();
      Type localType = localParameterizedType.getOwnerType();
      int i;
      if ((paramType2 != localType) && ((paramType2 == null) || (!paramType2.equals(localType)))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) || (!paramType1.getRawType().equals(localParameterizedType.getRawType())) || (!Arrays.equals(paramType1.getActualTypeArguments(), localParameterizedType.getActualTypeArguments()))) {
        bool3 = false;
      }
      return bool3;
    }
    if ((paramType1 instanceof GenericArrayType))
    {
      if (!(paramType2 instanceof GenericArrayType)) {
        return false;
      }
      paramType1 = (GenericArrayType)paramType1;
      paramType2 = (GenericArrayType)paramType2;
      return a(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
    }
    if ((paramType1 instanceof WildcardType))
    {
      if (!(paramType2 instanceof WildcardType)) {
        return false;
      }
      paramType1 = (WildcardType)paramType1;
      paramType2 = (WildcardType)paramType2;
      if ((Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()))) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    if ((paramType1 instanceof TypeVariable))
    {
      if (!(paramType2 instanceof TypeVariable)) {
        return false;
      }
      paramType1 = (TypeVariable)paramType1;
      paramType2 = (TypeVariable)paramType2;
      if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    return false;
  }
  
  public static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = ((WildcardType)paramType).getUpperBounds()[0];
    }
    c.a(paramClass2.isAssignableFrom(paramClass1));
    return a(localType, paramClass1, a(localType, paramClass1, paramClass2));
  }
  
  public static void b(Type paramType)
  {
    boolean bool;
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive())) {
      bool = false;
    } else {
      bool = true;
    }
    c.a(bool);
  }
  
  public static Class<?> c(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getRawType();
      c.a(paramType instanceof Class);
      return (Class)paramType;
    }
    if ((paramType instanceof GenericArrayType)) {
      return Array.newInstance(c(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    }
    if ((paramType instanceof TypeVariable)) {
      return Object.class;
    }
    if ((paramType instanceof WildcardType)) {
      return c(((WildcardType)paramType).getUpperBounds()[0]);
    }
    String str;
    if (paramType == null) {
      str = "null";
    } else {
      str = paramType.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
    localStringBuilder.append(paramType);
    localStringBuilder.append("> is of type ");
    localStringBuilder.append(str);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static String d(Type paramType)
  {
    if ((paramType instanceof Class)) {
      paramType = ((Class)paramType).getName();
    } else {
      paramType = paramType.toString();
    }
    return paramType;
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */