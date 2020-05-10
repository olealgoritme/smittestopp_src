package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$3
  extends TypeAdapter<Boolean>
{
  public Object read(a parama)
  {
    b localb = parama.r();
    if (localb == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else if (localb == b.STRING)
    {
      parama = Boolean.valueOf(Boolean.parseBoolean(parama.p()));
    }
    else
    {
      parama = Boolean.valueOf(parama.j());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a((Boolean)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */