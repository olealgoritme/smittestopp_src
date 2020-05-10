package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public class Gson$1
  extends TypeAdapter<Number>
{
  public Gson$1(Gson paramGson) {}
  
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      parama = Double.valueOf(parama.k());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Number)paramObject;
    if (paramObject == null)
    {
      paramc.g();
    }
    else
    {
      Gson.a(((Number)paramObject).doubleValue());
      paramc.a((Number)paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.Gson.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */