package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$6
  extends TypeAdapter<Number>
{
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    try
    {
      parama = Short.valueOf((short)parama.l());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new s(parama);
    }
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a((Number)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */