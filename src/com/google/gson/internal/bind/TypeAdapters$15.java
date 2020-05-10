package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.b;
import e.c.c.y.c;

public final class TypeAdapters$15
  extends TypeAdapter<Character>
{
  public Object read(e.c.c.y.a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      parama = parama.p();
      if (parama.length() != 1) {
        break label43;
      }
      parama = Character.valueOf(parama.charAt(0));
    }
    return parama;
    label43:
    throw new s(e.a.a.a.a.b("Expecting character, got: ", parama));
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Character)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = String.valueOf(paramObject);
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */