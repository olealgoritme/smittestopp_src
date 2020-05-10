package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$16
  extends TypeAdapter<String>
{
  public Object read(a parama)
  {
    b localb = parama.r();
    if (localb == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else if (localb == b.BOOLEAN)
    {
      parama = Boolean.toString(parama.j());
    }
    else
    {
      parama = parama.p();
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */