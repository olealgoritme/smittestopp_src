package com.google.gson;

import e.c.c.y.a;
import e.c.c.y.c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson$5
  extends TypeAdapter<AtomicLongArray>
{
  public Gson$5(TypeAdapter paramTypeAdapter) {}
  
  public Object read(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.h()) {
      localArrayList.add(Long.valueOf(((Number)a.read(parama)).longValue()));
    }
    parama.e();
    int i = localArrayList.size();
    parama = new AtomicLongArray(i);
    for (int j = 0; j < i; j++) {
      parama.set(j, ((Long)localArrayList.get(j)).longValue());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (AtomicLongArray)paramObject;
    paramc.b();
    int i = ((AtomicLongArray)paramObject).length();
    for (int j = 0; j < i; j++) {
      a.write(paramc, Long.valueOf(((AtomicLongArray)paramObject).get(j)));
    }
    paramc.d();
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.Gson.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */