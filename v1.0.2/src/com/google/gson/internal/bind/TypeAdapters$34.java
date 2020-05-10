package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;

public final class TypeAdapters$34
  implements u
{
  public TypeAdapters$34(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    paramGson = parama.getRawType();
    if ((paramGson != x) && (paramGson != y)) {
      paramGson = null;
    } else {
      paramGson = z;
    }
    return paramGson;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Factory[type=");
    localStringBuilder.append(x.getName());
    localStringBuilder.append("+");
    localStringBuilder.append(y.getName());
    localStringBuilder.append(",adapter=");
    localStringBuilder.append(z);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.34
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */