package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.w.q;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$14
  extends TypeAdapter<Number>
{
  public Object read(a parama)
  {
    b localb = parama.r();
    int i = localb.ordinal();
    if ((i != 5) && (i != 6))
    {
      if (i == 8)
      {
        parama.o();
        parama = null;
      }
      else
      {
        parama = new StringBuilder();
        parama.append("Expecting number, got: ");
        parama.append(localb);
        throw new s(parama.toString());
      }
    }
    else {
      parama = new q(parama.p());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a((Number)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */