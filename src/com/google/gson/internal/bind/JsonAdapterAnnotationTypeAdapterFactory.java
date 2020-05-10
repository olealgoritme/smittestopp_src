package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.i;
import e.c.c.r;
import e.c.c.u;
import e.c.c.v.b;
import e.c.c.w.g;
import e.c.c.w.s;

public final class JsonAdapterAnnotationTypeAdapterFactory
  implements u
{
  public final g x;
  
  public JsonAdapterAnnotationTypeAdapterFactory(g paramg)
  {
    x = paramg;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    b localb = (b)parama.getRawType().getAnnotation(b.class);
    if (localb == null) {
      return null;
    }
    return a(x, paramGson, parama, localb);
  }
  
  public TypeAdapter<?> a(g paramg, Gson paramGson, e.c.c.x.a<?> parama, b paramb)
  {
    Object localObject = paramg.a(e.c.c.x.a.get(paramb.value())).a();
    if ((localObject instanceof TypeAdapter))
    {
      paramg = (TypeAdapter)localObject;
    }
    else if ((localObject instanceof u))
    {
      paramg = ((u)localObject).a(paramGson, parama);
    }
    else
    {
      boolean bool = localObject instanceof r;
      if ((!bool) && (!(localObject instanceof i)))
      {
        paramg = e.a.a.a.a.a("Invalid attempt to bind an instance of ");
        paramg.append(localObject.getClass().getName());
        paramg.append(" as a @JsonAdapter for ");
        paramg.append(parama.toString());
        paramg.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramg.toString());
      }
      i locali = null;
      if (bool) {
        paramg = (r)localObject;
      } else {
        paramg = null;
      }
      if ((localObject instanceof i)) {
        locali = (i)localObject;
      }
      paramg = new TreeTypeAdapter(paramg, locali, paramGson, parama, null);
    }
    paramGson = paramg;
    if (paramg != null)
    {
      paramGson = paramg;
      if (paramb.nullSafe()) {
        paramGson = paramg.nullSafe();
      }
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */