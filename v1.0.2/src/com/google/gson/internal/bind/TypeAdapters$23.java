package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.net.InetAddress;

public final class TypeAdapters$23
  extends TypeAdapter<InetAddress>
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
      parama = InetAddress.getByName(parama.p());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (InetAddress)paramObject;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = ((InetAddress)paramObject).getHostAddress();
    }
    paramc.c((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */