package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public class TypeAdapter$1
  extends TypeAdapter<T>
{
  public TypeAdapter$1(TypeAdapter paramTypeAdapter) {}
  
  public T read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      return null;
    }
    return (T)a.read(parama);
  }
  
  public void write(c paramc, T paramT)
  {
    if (paramT == null) {
      paramc.g();
    } else {
      a.write(paramc, paramT);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.TypeAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */