package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.math.BigDecimal;

public final class TypeAdapters$17
  extends TypeAdapter<BigDecimal>
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
      parama = new BigDecimal(parama.p());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new s(parama);
    }
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a((BigDecimal)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */