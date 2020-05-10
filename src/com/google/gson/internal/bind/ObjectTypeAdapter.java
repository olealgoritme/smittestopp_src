package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.w.r;
import e.c.c.y.c;
import java.util.ArrayList;

public final class ObjectTypeAdapter
  extends TypeAdapter<Object>
{
  public static final u b = new ObjectTypeAdapter.1();
  public final Gson a;
  
  public ObjectTypeAdapter(Gson paramGson)
  {
    a = paramGson;
  }
  
  public Object read(e.c.c.y.a parama)
  {
    int i = parama.r().ordinal();
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 6)
          {
            if (i != 7)
            {
              if (i == 8)
              {
                parama.o();
                return null;
              }
              throw new IllegalStateException();
            }
            return Boolean.valueOf(parama.j());
          }
          return Double.valueOf(parama.k());
        }
        return parama.p();
      }
      localObject = new r();
      parama.b();
      while (parama.h()) {
        ((r)localObject).put(parama.n(), read(parama));
      }
      parama.f();
      return localObject;
    }
    Object localObject = new ArrayList();
    parama.a();
    while (parama.h()) {
      ((ArrayList)localObject).add(read(parama));
    }
    parama.e();
    return localObject;
  }
  
  public void write(c paramc, Object paramObject)
  {
    if (paramObject == null)
    {
      paramc.g();
      return;
    }
    Gson localGson = a;
    Object localObject = paramObject.getClass();
    if (localGson != null)
    {
      localObject = localGson.a(e.c.c.x.a.get((Class)localObject));
      if ((localObject instanceof ObjectTypeAdapter))
      {
        paramc.c();
        paramc.e();
        return;
      }
      ((TypeAdapter)localObject).write(paramc, paramObject);
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.ObjectTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */