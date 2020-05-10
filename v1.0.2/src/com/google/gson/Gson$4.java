package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.c;
import java.util.concurrent.atomic.AtomicLong;

public final class Gson$4
  extends TypeAdapter<AtomicLong>
{
  public Gson$4(TypeAdapter paramTypeAdapter) {}
  
  public Object read(a parama)
  {
    return new AtomicLong(((Number)a.read(parama)).longValue());
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (AtomicLong)paramObject;
    a.write(paramc, Long.valueOf(((AtomicLong)paramObject).get()));
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.Gson.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */