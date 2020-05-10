package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.util.UUID;

public final class TypeAdapters$24
  extends TypeAdapter<UUID>
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
      parama = UUID.fromString(parama.p());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (UUID)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((UUID)paramObject).toString();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */