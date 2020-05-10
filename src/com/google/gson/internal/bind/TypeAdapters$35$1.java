package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.s;
import e.c.c.y.c;

public class TypeAdapters$35$1
  extends TypeAdapter<T1>
{
  public TypeAdapters$35$1(TypeAdapters.35 param35, Class paramClass) {}
  
  public T1 read(e.c.c.y.a parama)
  {
    parama = b.y.read(parama);
    if ((parama != null) && (!a.isInstance(parama)))
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("Expected a ");
      localStringBuilder.append(a.getName());
      localStringBuilder.append(" but was ");
      localStringBuilder.append(parama.getClass().getName());
      throw new s(localStringBuilder.toString());
    }
    return parama;
  }
  
  public void write(c paramc, T1 paramT1)
  {
    b.y.write(paramc, paramT1);
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.35.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */