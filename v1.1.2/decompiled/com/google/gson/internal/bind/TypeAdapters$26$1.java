package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.c;
import java.sql.Timestamp;
import java.util.Date;

public class TypeAdapters$26$1
  extends TypeAdapter<Timestamp>
{
  public TypeAdapters$26$1(TypeAdapters.26 param26, TypeAdapter paramTypeAdapter) {}
  
  public Object read(a parama)
  {
    parama = (Date)a.read(parama);
    if (parama != null) {
      parama = new Timestamp(parama.getTime());
    } else {
      parama = null;
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Timestamp)paramObject;
    a.write(paramc, paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.26.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */