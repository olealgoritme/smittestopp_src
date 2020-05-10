package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;

public final class TypeAdapters$35
  implements u
{
  public TypeAdapters$35(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T2> TypeAdapter<T2> a(Gson paramGson, e.c.c.x.a<T2> parama)
  {
    paramGson = parama.getRawType();
    if (!x.isAssignableFrom(paramGson)) {
      return null;
    }
    return new TypeAdapters.35.1(this, paramGson);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[typeHierarchy=");
    localStringBuilder.append(x.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(y);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */