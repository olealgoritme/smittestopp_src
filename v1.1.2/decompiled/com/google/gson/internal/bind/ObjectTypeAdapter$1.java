package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;

public final class ObjectTypeAdapter$1
  implements u
{
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.getRawType() == Object.class) {
      return new ObjectTypeAdapter(paramGson);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.ObjectTypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */