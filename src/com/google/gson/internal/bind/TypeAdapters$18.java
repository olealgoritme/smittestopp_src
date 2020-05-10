package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.math.BigInteger;

public final class TypeAdapters$18
  extends TypeAdapter<BigInteger>
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
      parama = new BigInteger(parama.p());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new s(parama);
    }
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a((BigInteger)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */