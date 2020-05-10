package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.w.s;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionTypeAdapterFactory$Adapter<E>
  extends TypeAdapter<Collection<E>>
{
  public final TypeAdapter<E> a;
  public final s<? extends Collection<E>> b;
  
  public CollectionTypeAdapterFactory$Adapter(Gson paramGson, Type paramType, TypeAdapter<E> paramTypeAdapter, s<? extends Collection<E>> params)
  {
    a = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramType);
    b = params;
  }
  
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      Collection localCollection = (Collection)b.a();
      parama.a();
      while (parama.h()) {
        localCollection.add(a.read(parama));
      }
      parama.e();
      parama = localCollection;
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Collection)paramObject;
    if (paramObject == null)
    {
      paramc.g();
    }
    else
    {
      paramc.b();
      Iterator localIterator = ((Collection)paramObject).iterator();
      while (localIterator.hasNext())
      {
        paramObject = localIterator.next();
        a.write(paramc, paramObject);
      }
      paramc.d();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.CollectionTypeAdapterFactory.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */