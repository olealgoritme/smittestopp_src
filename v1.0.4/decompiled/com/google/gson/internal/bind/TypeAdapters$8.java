package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.a;
import e.c.c.y.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class TypeAdapters$8
  extends TypeAdapter<AtomicInteger>
{
  public Object read(a parama)
  {
    try
    {
      parama = new AtomicInteger(parama.l());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new s(parama);
    }
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a(((AtomicInteger)paramObject).get());
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */