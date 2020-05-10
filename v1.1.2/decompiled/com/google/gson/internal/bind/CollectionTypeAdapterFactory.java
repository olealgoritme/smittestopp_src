package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.w.g;
import e.c.c.w.s;
import e.c.c.y.b;
import e.c.c.y.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionTypeAdapterFactory
  implements u
{
  public final g x;
  
  public CollectionTypeAdapterFactory(g paramg)
  {
    x = paramg;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    Type localType = parama.getType();
    Object localObject = parama.getRawType();
    if (!Collection.class.isAssignableFrom((Class)localObject)) {
      return null;
    }
    localType = e.c.c.w.a.b(localType, (Class)localObject, Collection.class);
    localObject = localType;
    if ((localType instanceof WildcardType)) {
      localObject = ((WildcardType)localType).getUpperBounds()[0];
    }
    if ((localObject instanceof ParameterizedType)) {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments()[0];
    } else {
      localObject = Object.class;
    }
    return new Adapter(paramGson, (Type)localObject, paramGson.a(e.c.c.x.a.get((Type)localObject)), x.a(parama));
  }
  
  public static final class Adapter<E>
    extends TypeAdapter<Collection<E>>
  {
    public final TypeAdapter<E> a;
    public final s<? extends Collection<E>> b;
    
    public Adapter(Gson paramGson, Type paramType, TypeAdapter<E> paramTypeAdapter, s<? extends Collection<E>> params)
    {
      a = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramType);
      b = params;
    }
    
    public Object read(e.c.c.y.a parama)
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
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.CollectionTypeAdapterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */