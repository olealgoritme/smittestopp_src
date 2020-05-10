package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.c;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TypeAdapters$9
  extends TypeAdapter<AtomicBoolean>
{
  public Object read(a parama)
  {
    return new AtomicBoolean(parama.j());
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramc.a(((AtomicBoolean)paramObject).get());
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */