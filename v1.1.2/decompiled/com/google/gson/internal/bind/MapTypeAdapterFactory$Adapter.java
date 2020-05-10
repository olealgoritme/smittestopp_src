package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.y.a.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapTypeAdapterFactory$Adapter<K, V>
  extends TypeAdapter<Map<K, V>>
{
  public final TypeAdapter<K> a;
  public final TypeAdapter<V> b;
  public final e.c.c.w.s<? extends Map<K, V>> c;
  
  public MapTypeAdapterFactory$Adapter(Gson paramGson, Type paramType1, TypeAdapter<K> paramTypeAdapter, Type paramType2, TypeAdapter<V> paramTypeAdapter1, e.c.c.w.s<? extends Map<K, V>> params)
  {
    a = new TypeAdapterRuntimeTypeWrapper(paramType1, paramType2, paramTypeAdapter);
    b = new TypeAdapterRuntimeTypeWrapper(paramType1, params, paramTypeAdapter1);
    e.c.c.w.s locals;
    c = locals;
  }
  
  public Object read(e.c.c.y.a parama)
  {
    Object localObject1 = parama.r();
    Object localObject2 = b.NULL;
    Object localObject3 = null;
    if (localObject1 == localObject2)
    {
      parama.o();
      parama = (e.c.c.y.a)localObject3;
    }
    else
    {
      localObject3 = (Map)c.a();
      if (localObject1 == b.BEGIN_ARRAY)
      {
        parama.a();
        while (parama.h())
        {
          parama.a();
          localObject1 = a.read(parama);
          if (((Map)localObject3).put(localObject1, b.read(parama)) == null)
          {
            parama.e();
          }
          else
          {
            parama = new StringBuilder();
            parama.append("duplicate key: ");
            parama.append(localObject1);
            throw new e.c.c.s(parama.toString());
          }
        }
        parama.e();
      }
      else
      {
        parama.b();
        while (parama.h()) {
          if ((a.a)e.c.c.w.p.a != null)
          {
            if ((parama instanceof e.c.c.w.z.a))
            {
              localObject1 = (e.c.c.w.z.a)parama;
              ((e.c.c.w.z.a)localObject1).a(b.NAME);
              localObject2 = (Map.Entry)((Iterator)((e.c.c.w.z.a)localObject1).v()).next();
              ((e.c.c.w.z.a)localObject1).a(((Map.Entry)localObject2).getValue());
              ((e.c.c.w.z.a)localObject1).a(new e.c.c.p((String)((Map.Entry)localObject2).getKey()));
            }
            else
            {
              int i = E;
              int j = i;
              if (i == 0) {
                j = parama.d();
              }
              if (j == 13)
              {
                E = 9;
              }
              else if (j == 12)
              {
                E = 8;
              }
              else
              {
                if (j != 14) {
                  break label356;
                }
                E = 10;
              }
            }
            localObject1 = a.read(parama);
            if (((Map)localObject3).put(localObject1, b.read(parama)) != null)
            {
              parama = new StringBuilder();
              parama.append("duplicate key: ");
              parama.append(localObject1);
              throw new e.c.c.s(parama.toString());
              label356:
              localObject3 = e.a.a.a.a.a("Expected a name but was ");
              ((StringBuilder)localObject3).append(parama.r());
              ((StringBuilder)localObject3).append(parama.i());
              throw new IllegalStateException(((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            throw null;
          }
        }
        parama.f();
      }
      parama = (e.c.c.y.a)localObject3;
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Map)paramObject;
    if (paramObject == null)
    {
      paramc.g();
    }
    else
    {
      Object localObject1;
      if (!d.y)
      {
        paramc.c();
        localObject1 = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramObject = (Map.Entry)((Iterator)localObject1).next();
          paramc.a(String.valueOf(((Map.Entry)paramObject).getKey()));
          b.write(paramc, ((Map.Entry)paramObject).getValue());
        }
        paramc.e();
      }
      else
      {
        ArrayList localArrayList = new ArrayList(((Map)paramObject).size());
        localObject1 = new ArrayList(((Map)paramObject).size());
        Object localObject2 = ((Map)paramObject).entrySet().iterator();
        int i = 0;
        int j = 0;
        int k = 0;
        int m;
        while (((Iterator)localObject2).hasNext())
        {
          paramObject = (Map.Entry)((Iterator)localObject2).next();
          j localj = a.toJsonTree(((Map.Entry)paramObject).getKey());
          localArrayList.add(localj);
          ((ArrayList)localObject1).add(((Map.Entry)paramObject).getValue());
          if (localj != null)
          {
            if ((!(localj instanceof g)) && (!(localj instanceof m))) {
              m = 0;
            } else {
              m = 1;
            }
            k |= m;
          }
          else
          {
            throw null;
          }
        }
        if (k != 0)
        {
          paramc.b();
          m = localArrayList.size();
          for (k = j; k < m; k++)
          {
            paramc.b();
            paramObject = (j)localArrayList.get(k);
            TypeAdapters.X.write(paramc, paramObject);
            b.write(paramc, ((ArrayList)localObject1).get(k));
            paramc.d();
          }
          paramc.d();
        }
        else
        {
          paramc.c();
          m = localArrayList.size();
          k = i;
          while (k < m)
          {
            paramObject = (j)localArrayList.get(k);
            if (paramObject != null)
            {
              if ((paramObject instanceof e.c.c.p))
              {
                paramObject = ((j)paramObject).d();
                localObject2 = a;
                if ((localObject2 instanceof Number)) {
                  paramObject = String.valueOf(((e.c.c.p)paramObject).h());
                } else if ((localObject2 instanceof Boolean)) {
                  paramObject = Boolean.toString(((e.c.c.p)paramObject).g());
                } else if ((localObject2 instanceof String)) {
                  paramObject = ((e.c.c.p)paramObject).f();
                } else {
                  throw new AssertionError();
                }
              }
              else
              {
                if (!(paramObject instanceof l)) {
                  break label493;
                }
                paramObject = "null";
              }
              paramc.a((String)paramObject);
              b.write(paramc, ((ArrayList)localObject1).get(k));
              k++;
              continue;
              label493:
              throw new AssertionError();
            }
            else
            {
              throw null;
            }
          }
          paramc.e();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */