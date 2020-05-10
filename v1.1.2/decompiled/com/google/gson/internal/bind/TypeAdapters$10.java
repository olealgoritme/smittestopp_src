package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.a;
import e.c.c.y.c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters$10
  extends TypeAdapter<AtomicIntegerArray>
{
  public Object read(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.h()) {
      try
      {
        localArrayList.add(Integer.valueOf(parama.l()));
      }
      catch (NumberFormatException parama)
      {
        throw new s(parama);
      }
    }
    parama.e();
    int i = localArrayList.size();
    parama = new AtomicIntegerArray(i);
    for (int j = 0; j < i; j++) {
      parama.set(j, ((Integer)localArrayList.get(j)).intValue());
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (AtomicIntegerArray)paramObject;
    paramc.b();
    int i = ((AtomicIntegerArray)paramObject).length();
    for (int j = 0; j < i; j++) {
      paramc.a(((AtomicIntegerArray)paramObject).get(j));
    }
    paramc.d();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */