package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;

public final class TypeAdapters$30
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    parama = parama.getRawType();
    if ((Enum.class.isAssignableFrom(parama)) && (parama != Enum.class))
    {
      paramGson = parama;
      if (!parama.isEnum()) {
        paramGson = parama.getSuperclass();
      }
      return new TypeAdapters.EnumTypeAdapter(paramGson);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */