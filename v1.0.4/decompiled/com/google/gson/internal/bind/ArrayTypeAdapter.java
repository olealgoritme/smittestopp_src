package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E>
  extends TypeAdapter<Object>
{
  public static final u c = new ArrayTypeAdapter.1();
  public final Class<E> a;
  public final TypeAdapter<E> b;
  
  public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass)
  {
    b = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramClass);
    a = paramClass;
  }
  
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.h()) {
      localArrayList.add(b.read(parama));
    }
    parama.e();
    int i = localArrayList.size();
    parama = Array.newInstance(a, i);
    for (int j = 0; j < i; j++) {
      Array.set(parama, j, localArrayList.get(j));
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    if (paramObject == null)
    {
      paramc.g();
      return;
    }
    paramc.b();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      b.write(paramc, localObject);
      i++;
    }
    paramc.d();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.ArrayTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */