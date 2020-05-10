package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.c;

public final class TypeAdapters$1
  extends TypeAdapter<Class>
{
  public Object read(e.c.c.y.a parama)
  {
    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Class)paramObject;
    paramc = e.a.a.a.a.a("Attempted to serialize java.lang.Class: ");
    paramc.append(((Class)paramObject).getName());
    paramc.append(". Forgot to register a type adapter?");
    throw new UnsupportedOperationException(paramc.toString());
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */