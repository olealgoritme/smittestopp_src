package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.i;
import e.c.c.l;
import e.c.c.r;
import e.c.c.u;

public final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  public final r<T> a;
  public final i<T> b;
  public final Gson c;
  public final e.c.c.x.a<T> d;
  public final u e;
  public final TreeTypeAdapter<T>.b f = new TreeTypeAdapter.b(this, null);
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
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TreeTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */