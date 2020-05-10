package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.y.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class TypeAdapterRuntimeTypeWrapper<T>
  extends TypeAdapter<T>
{
  public final Gson a;
  public final TypeAdapter<T> b;
  public final Type c;
  
  public TypeAdapterRuntimeTypeWrapper(Gson paramGson, TypeAdapter<T> paramTypeAdapter, Type paramType)
  {
    a = paramGson;
    b = paramTypeAdapter;
    c = paramType;
  }
  
  public T read(e.c.c.y.a parama)
  {
    return (T)b.read(parama);
  }
  
  public void write(c paramc, T paramT)
  {
    Object localObject1 = b;
    Type localType = c;
    Object localObject2 = localType;
    if (paramT != null) {
      if ((localType != Object.class) && (!(localType instanceof TypeVariable)))
      {
        localObject2 = localType;
        if (!(localType instanceof Class)) {}
      }
      else
      {
        localObject2 = paramT.getClass();
      }
    }
    if (localObject2 != c)
    {
      localObject1 = a.a(e.c.c.x.a.get((Type)localObject2));
      if ((localObject1 instanceof ReflectiveTypeAdapterFactory.Adapter))
      {
        localObject2 = b;
        if (!(localObject2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
          localObject1 = localObject2;
        }
      }
    }
    ((TypeAdapter)localObject1).write(paramc, paramT);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */