package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$20
  extends TypeAdapter<StringBuffer>
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
      parama = new StringBuffer(parama.p());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (StringBuffer)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((StringBuffer)paramObject).toString();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */