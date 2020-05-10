package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.b;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter<T>
  extends TypeAdapter<T>
{
  public final e.c.c.w.s<T> a;
  public final Map<String, ReflectiveTypeAdapterFactory.a> b;
  
  public ReflectiveTypeAdapterFactory$Adapter(e.c.c.w.s<T> params, Map<String, ReflectiveTypeAdapterFactory.a> paramMap)
  {
    a = params;
    b = paramMap;
  }
  
  public T read(e.c.c.y.a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      return null;
    }
    Object localObject1 = a.a();
    try
    {
      parama.b();
      while (parama.h())
      {
        Object localObject2 = parama.n();
        localObject2 = (ReflectiveTypeAdapterFactory.a)b.get(localObject2);
        if ((localObject2 != null) && (c))
        {
          localObject2 = (e.c.c.w.z.c)localObject2;
          Object localObject3 = f.read(parama);
          if ((localObject3 != null) || (!i)) {
            d.set(localObject1, localObject3);
          }
        }
        else
        {
          parama.u();
        }
      }
      parama.f();
      return (T)localObject1;
    }
    catch (IllegalAccessException parama)
    {
      throw new AssertionError(parama);
    }
    catch (IllegalStateException parama)
    {
      throw new e.c.c.s(parama);
    }
  }
  
  public void write(e.c.c.y.c paramc, T paramT)
  {
    if (paramT == null)
    {
      paramc.g();
      return;
    }
    paramc.c();
    try
    {
      Iterator localIterator = b.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (ReflectiveTypeAdapterFactory.a)localIterator.next();
        Object localObject2 = (e.c.c.w.z.c)localObject1;
        boolean bool = b;
        int i = 0;
        if ((bool) && (d.get(paramT) != paramT)) {
          i = 1;
        }
        if (i != 0)
        {
          paramc.a(a);
          localObject2 = (e.c.c.w.z.c)localObject1;
          localObject1 = d.get(paramT);
          if (e) {
            localObject2 = f;
          } else {
            localObject2 = new TypeAdapterRuntimeTypeWrapper(g, f, h.getType());
          }
          ((TypeAdapter)localObject2).write(paramc, localObject1);
        }
      }
      paramc.e();
      return;
    }
    catch (IllegalAccessException paramc)
    {
      throw new AssertionError(paramc);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */