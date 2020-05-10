package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.l;
import e.c.c.q;
import e.c.c.r;
import e.c.c.u;
import e.c.c.w.z.b;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  public final r<T> a;
  public final i<T> b;
  public final Gson c;
  public final e.c.c.x.a<T> d;
  public final u e;
  public final TreeTypeAdapter<T>.b f = new b(null);
  public TypeAdapter<T> g;
  
  public TreeTypeAdapter(r<T> paramr, i<T> parami, Gson paramGson, e.c.c.x.a<T> parama, u paramu)
  {
    a = paramr;
    b = parami;
    c = paramGson;
    d = parama;
    e = paramu;
  }
  
  public T read(e.c.c.y.a parama)
  {
    if (b == null)
    {
      TypeAdapter localTypeAdapter = g;
      if (localTypeAdapter == null)
      {
        localTypeAdapter = c.a(e, d);
        g = localTypeAdapter;
      }
      return (T)localTypeAdapter.read(parama);
    }
    parama = e.c.a.a.b.l.c.a(parama);
    if (parama != null)
    {
      if ((parama instanceof l)) {
        return null;
      }
      return (T)b.deserialize(parama, d.getType(), f);
    }
    throw null;
  }
  
  public void write(e.c.c.y.c paramc, T paramT)
  {
    Object localObject = a;
    if (localObject == null)
    {
      localObject = g;
      if (localObject == null)
      {
        localObject = c.a(e, d);
        g = ((TypeAdapter)localObject);
      }
      ((TypeAdapter)localObject).write(paramc, paramT);
      return;
    }
    if (paramT == null)
    {
      paramc.g();
      return;
    }
    paramT = ((r)localObject).serialize(paramT, d.getType(), f);
    TypeAdapters.X.write(paramc, paramT);
  }
  
  public static final class SingleTypeFactory
    implements u
  {
    public final r<?> A;
    public final i<?> B;
    public final e.c.c.x.a<?> x;
    public final boolean y;
    public final Class<?> z;
    
    public SingleTypeFactory(Object paramObject, e.c.c.x.a<?> parama, boolean paramBoolean, Class<?> paramClass)
    {
      boolean bool = paramObject instanceof r;
      Object localObject1 = null;
      if (bool) {
        localObject2 = (r)paramObject;
      } else {
        localObject2 = null;
      }
      A = ((r)localObject2);
      Object localObject2 = localObject1;
      if ((paramObject instanceof i)) {
        localObject2 = (i)paramObject;
      }
      B = ((i)localObject2);
      if ((A == null) && (localObject2 == null)) {
        bool = false;
      } else {
        bool = true;
      }
      e.c.a.a.b.l.c.a(bool);
      x = parama;
      y = paramBoolean;
      z = paramClass;
    }
    
    public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
    {
      e.c.c.x.a locala = x;
      boolean bool;
      if (locala != null)
      {
        if ((!locala.equals(parama)) && ((!y) || (x.getType() != parama.getRawType()))) {
          bool = false;
        } else {
          bool = true;
        }
      }
      else {
        bool = z.isAssignableFrom(parama.getRawType());
      }
      if (bool) {
        paramGson = new TreeTypeAdapter(A, B, paramGson, parama, this);
      } else {
        paramGson = null;
      }
      return paramGson;
    }
  }
  
  public final class b
    implements q, h
  {
    public j a(Object paramObject, Type paramType)
    {
      Gson localGson = a.c;
      if (localGson != null)
      {
        b localb = new b();
        localGson.a(paramObject, paramType, localb);
        return localb.j();
      }
      throw null;
    }
    
    public <R> R a(j paramj, Type paramType)
    {
      Gson localGson = a.c;
      Object localObject = null;
      if (localGson != null)
      {
        if (paramj == null) {
          paramj = (j)localObject;
        } else {
          paramj = localGson.a(new e.c.c.w.z.a(paramj), paramType);
        }
        return paramj;
      }
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */