package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.w.g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

public final class CollectionTypeAdapterFactory
  implements u
{
  public final g x;
  
  public CollectionTypeAdapterFactory(g paramg)
  {
    x = paramg;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    Object localObject1 = parama.getType();
    Object localObject2 = parama.getRawType();
    if (!Collection.class.isAssignableFrom((Class)localObject2)) {
      return null;
    }
    localObject2 = e.c.c.w.a.b((Type)localObject1, (Class)localObject2, Collection.class);
    localObject1 = localObject2;
    if ((localObject2 instanceof WildcardType)) {
      localObject1 = ((WildcardType)localObject2).getUpperBounds()[0];
    }
    if ((localObject1 instanceof ParameterizedType)) {
      localObject1 = ((ParameterizedType)localObject1).getActualTypeArguments()[0];
    } else {
      localObject1 = Object.class;
    }
    return new CollectionTypeAdapterFactory.Adapter(paramGson, (Type)localObject1, paramGson.a(e.c.c.x.a.get((Type)localObject1)), x.a(parama));
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.CollectionTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */