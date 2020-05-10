package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;

public final class TypeAdapters$31
  implements u
{
  public TypeAdapters$31(a parama, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    if (parama.equals(x)) {
      paramGson = y;
    } else {
      paramGson = null;
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.31
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */