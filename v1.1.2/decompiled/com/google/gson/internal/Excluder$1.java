package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.y.c;

public class Excluder$1
  extends TypeAdapter<T>
{
  public TypeAdapter<T> a;
  
  public Excluder$1(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, e.c.c.x.a parama) {}
  
  public T read(e.c.c.y.a parama)
  {
    if (b)
    {
      parama.u();
      return null;
    }
    TypeAdapter localTypeAdapter = a;
    if (localTypeAdapter == null)
    {
      localTypeAdapter = d.a(f, e);
      a = localTypeAdapter;
    }
    return (T)localTypeAdapter.read(parama);
  }
  
  public void write(c paramc, T paramT)
  {
    if (c)
    {
      paramc.g();
      return;
    }
    TypeAdapter localTypeAdapter = a;
    if (localTypeAdapter == null)
    {
      localTypeAdapter = d.a(f, e);
      a = localTypeAdapter;
    }
    localTypeAdapter.write(paramc, paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.Excluder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */