package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.k;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.net.URI;
import java.net.URISyntaxException;

public final class TypeAdapters$22
  extends TypeAdapter<URI>
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
    try
    {
      parama = parama.p();
      if ("null".equals(parama)) {
        parama = (a)localObject;
      } else {
        parama = new URI(parama);
      }
      return parama;
    }
    catch (URISyntaxException parama)
    {
      throw new k(parama);
    }
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (URI)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((URI)paramObject).toASCIIString();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */