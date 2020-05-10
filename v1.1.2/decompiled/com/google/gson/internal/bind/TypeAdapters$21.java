package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.net.URL;

public final class TypeAdapters$21
  extends TypeAdapter<URL>
{
  public Object read(a parama)
  {
    b localb1 = parama.r();
    b localb2 = b.NULL;
    Object localObject = null;
    if (localb1 == localb2)
    {
      parama.o();
      parama = (a)localObject;
    }
    else
    {
      parama = parama.p();
      if ("null".equals(parama)) {
        parama = (a)localObject;
      } else {
        parama = new URL(parama);
      }
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (URL)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((URL)paramObject).toExternalForm();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */