package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;

public final class TypeAdapters$32
  implements u
{
  public TypeAdapters$32(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    if (parama.getRawType() == x) {
      paramGson = y;
    } else {
      paramGson = null;
    }
    return paramGson;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
    localStringBuilder.append(x.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.32
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */