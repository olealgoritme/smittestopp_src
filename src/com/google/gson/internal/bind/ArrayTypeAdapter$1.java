package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import java.lang.reflect.GenericArrayType;

public final class ArrayTypeAdapter$1
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    parama = parama.getType();
    boolean bool = parama instanceof GenericArrayType;
    if ((!bool) && ((!(parama instanceof Class)) || (!((Class)parama).isArray()))) {
      return null;
    }
    if (bool) {
      parama = ((GenericArrayType)parama).getGenericComponentType();
    } else {
      parama = ((Class)parama).getComponentType();
    }
    return new ArrayTypeAdapter(paramGson, paramGson.a(e.c.c.x.a.get(parama)), e.c.c.w.a.c(parama));
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.ArrayTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */