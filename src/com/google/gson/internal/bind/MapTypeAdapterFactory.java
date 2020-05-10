package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.w.g;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;

public final class MapTypeAdapterFactory
  implements u
{
  public final g x;
  public final boolean y;
  
  public MapTypeAdapterFactory(g paramg, boolean paramBoolean)
  {
    x = paramg;
    y = paramBoolean;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    Object localObject1 = parama.getType();
    if (!Map.class.isAssignableFrom(parama.getRawType())) {
      return null;
    }
    Object localObject2 = e.c.c.w.a.c((Type)localObject1);
    if (localObject1 == Properties.class)
    {
      localObject2 = new Type[2];
      localObject2[0] = String.class;
      localObject2[1] = String.class;
    }
    else
    {
      localObject2 = e.c.c.w.a.b((Type)localObject1, (Class)localObject2, Map.class);
      if ((localObject2 instanceof ParameterizedType))
      {
        localObject2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      }
      else
      {
        localObject2 = new Type[2];
        localObject2[0] = Object.class;
        localObject2[1] = Object.class;
      }
    }
    localObject1 = localObject2[0];
    if ((localObject1 != Boolean.TYPE) && (localObject1 != Boolean.class)) {
      localObject1 = paramGson.a(e.c.c.x.a.get((Type)localObject1));
    } else {
      localObject1 = TypeAdapters.f;
    }
    TypeAdapter localTypeAdapter = paramGson.a(e.c.c.x.a.get(localObject2[1]));
    parama = x.a(parama);
    return new MapTypeAdapterFactory.Adapter(this, paramGson, localObject2[0], (TypeAdapter)localObject1, localObject2[1], localTypeAdapter, parama);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.MapTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */