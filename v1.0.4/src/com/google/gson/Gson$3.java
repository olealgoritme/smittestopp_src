package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class Gson$3
  extends TypeAdapter<Number>
{
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      parama = Long.valueOf(parama.m());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Number)paramObject;
    if (paramObject == null) {
      paramc.g();
    } else {
      paramc.c(paramObject.toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.Gson.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */