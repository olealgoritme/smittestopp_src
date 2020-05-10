package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.c;

public class Gson$FutureTypeAdapter<T>
  extends TypeAdapter<T>
{
  public TypeAdapter<T> a;
  
  public T read(a parama)
  {
    TypeAdapter localTypeAdapter = a;
    if (localTypeAdapter != null) {
      return (T)localTypeAdapter.read(parama);
    }
    throw new IllegalStateException();
  }
  
  public void write(c paramc, T paramT)
  {
    TypeAdapter localTypeAdapter = a;
    if (localTypeAdapter != null)
    {
      localTypeAdapter.write(paramc, paramT);
      return;
    }
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.Gson.FutureTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */